package br.com.student.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoListRequestDTO {

    private Long id;

    @Size(min = 3)
    @Size(max = 100)
    @NotNull()
    @NotBlank()
    private String description;

    @NotNull
    @NotBlank()
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT")
    private LocalDateTime data;

    private boolean status;
}
