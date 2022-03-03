package br.com.student.resources.services;

import br.com.student.dtos.TodoListRequestDTO;
import br.com.student.dtos.TodoListResponseDTO;
import br.com.student.entities.TodoList;
import br.com.student.exceptions.CustomException;
import br.com.student.mappers.TodoListMapper;
import br.com.student.services.TodoListService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Service
public class TodoListResourcesService {

    private final TodoListService service;
    private final TodoListMapper mapper;

    public TodoListResourcesService(TodoListService service, TodoListMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public TodoListResponseDTO save(@Valid TodoListRequestDTO todoListRequest) {
        TodoList todoListConverted = mapper.sourceToDestination(todoListRequest);
        TodoList todoListSaved = service.save(todoListConverted);
        return mapper.destinationToSource(todoListSaved);
    }

    public String findAll() {
       String todoList = "oi";
       return todoList;
    }

    public TodoListResponseDTO findById(Long id) {
        if (Objects.isNull(id)) {
            throw new CustomException(HttpStatus.PRECONDITION_FAILED, "Não foi possível recuperar a ocorrência veículo. ID é obrigatório");
        }
        TodoList todoList = service.findById(id);
        if (Objects.isNull(todoList)) {
            throw new EmptyResultDataAccessException(1);
        }
        return mapper.destinationToSource(todoList);
    }

    public TodoListResponseDTO update(Long id, @Valid TodoListRequestDTO todoListRequest) {
        if (Objects.isNull(id)) {
            throw new CustomException(HttpStatus.PRECONDITION_FAILED, "Não foi possível recuperar a ocorrência veículo. ID é obrigatório");
        }
        TodoList todoListRecovered = service.findById(id);
        if (Objects.isNull(todoListRecovered)) {
            throw new EmptyResultDataAccessException(1);
        }
        mapper.updateSourceToDestination(todoListRequest, todoListRecovered);
        return mapper.destinationToSource(service.save(todoListRecovered));
    }
}
