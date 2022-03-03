package br.com.student.services;

import br.com.student.entities.TodoList;
import br.com.student.repositories.TodoListRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoListService {

    private final TodoListRepository repository;

    public TodoListService(TodoListRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public TodoList save(TodoList todoList) {
        return repository.save(todoList);
    }

    @Transactional
    public TodoList findAll() { return (TodoList) repository.findAll();}

    @Transactional(readOnly = true)
    public TodoList findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
