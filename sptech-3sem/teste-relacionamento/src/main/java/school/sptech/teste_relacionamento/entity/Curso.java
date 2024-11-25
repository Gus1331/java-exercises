package school.sptech.teste_relacionamento.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder // mapear sem precisar instanciar (necessita de allArgs e NoArgs)
/*
@EqualsAndHashCode.Exclude
@EqualsAndHashCode.Include
*/

// td acima
// @Data // não usa em uma entidade, mt pesado
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private Double preco;
    private String categoria;
}
