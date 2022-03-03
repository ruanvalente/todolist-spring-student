package br.com.student.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoListResponseDTO {
    private Long id;
    private String description;
    private LocalDateTime data;
    private boolean status;
}
