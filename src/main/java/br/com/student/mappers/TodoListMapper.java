package br.com.student.mappers;

import br.com.student.dtos.TodoListRequestDTO;
import br.com.student.dtos.TodoListResponseDTO;
import br.com.student.entities.TodoList;
import org.mapstruct.*;

import java.util.List;


@Mapper(componentModel = "spring")
public interface TodoListMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    TodoList sourceToDestination(TodoListRequestDTO todoListRequestDTO);

    @InheritInverseConfiguration
    TodoListResponseDTO destinationToSource(final TodoList todoList);

    @Mapping(target = "id", ignore = true)
    void updateSourceToDestination(TodoListRequestDTO todoListRequest, @MappingTarget TodoList todoList);

    List<TodoListRequestDTO> map(List<TodoList> todoList);

}
