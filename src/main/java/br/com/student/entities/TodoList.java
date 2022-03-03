package br.com.student.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})

@Entity
@Table(name = "todolist")
public class TodoList {

    private static final String SEQUENCE = "seq_todolist";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column (name = "data", nullable = false)
    private LocalDateTime data;

    @NotNull
    @Column(name = "status", nullable = false)
    private boolean status;
}
