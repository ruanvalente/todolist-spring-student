package br.com.student.resources;

import br.com.student.dtos.TodoListRequestDTO;
import br.com.student.dtos.TodoListResponseDTO;
import br.com.student.entities.TodoList;
import br.com.student.events.ResourceCreatedEvent;
import br.com.student.resources.services.TodoListResourcesService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/todolist")
public class TodoListResource {

    private final ApplicationEventPublisher publisher;
    private final TodoListResourcesService service;

    public TodoListResource(TodoListResourcesService service, ApplicationEventPublisher publisher) {
        this.service = service;
        this.publisher = publisher;
    }

    @GetMapping("/")
    public String findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoListResponseDTO> findById(@PathVariable Long id) {
        TodoListResponseDTO todoListResponse = service.findById(id);
        return Objects.nonNull(todoListResponse) ? ResponseEntity.ok(todoListResponse) : ResponseEntity.notFound().build();
    }

    @PostMapping
        public ResponseEntity<TodoListResponseDTO> save(@Valid @RequestBody TodoListRequestDTO todoListRequest, HttpServletResponse response) {
            TodoListResponseDTO todoListResponse = service.save(todoListRequest);
            publisher.publishEvent(new ResourceCreatedEvent(this, response, todoListResponse.getId()));
            return ResponseEntity.status(HttpStatus.CREATED).body(todoListResponse);
        }

    @PutMapping("/{id}")
        public ResponseEntity<TodoListResponseDTO> update(@PathVariable Long id, @Valid @RequestBody TodoListRequestDTO todoListRequest)  {
            TodoListResponseDTO todoListResponse = service.update(id, todoListRequest);
            return ResponseEntity.ok(todoListResponse);
        }
    }


