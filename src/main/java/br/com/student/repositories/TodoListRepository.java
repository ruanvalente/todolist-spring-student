package br.com.student.repositories;

import br.com.student.entities.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListRepository extends JpaRepository<TodoList, Long > {
}
