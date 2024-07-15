package forum.hub.api.domain.curso;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Table(name = "cursos")
@Entity(name = "Curso")
@Data
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Builder
    public Curso(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Curso() {}

    public static Curso fromDadosCurso(DadosCurso dadosCurso) {
        return Curso.builder()
                .id(dadosCurso.id())
                .nome(dadosCurso.curso_nome())
                .build();
    }


}