package sptech.school.continuada2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String ultimate;
    private String funcaoPrincipal;

    //TODO: Implementar o relacionamento com a entidade Regiao
    @ManyToOne
    private Regiao regiao;
}
