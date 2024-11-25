package school.sptech.teste_relacionamento.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;

    @ManyToOne // esquerda cima, direita baixo // muitos alunos para um curso
    // @OneToMany
    // @OneToOne
    // @ManyToMany
    private Curso curso; // curso_id
}
