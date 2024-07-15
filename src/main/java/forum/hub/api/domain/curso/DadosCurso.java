package forum.hub.api.domain.curso;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCurso(

        @Id
        Long id,

        @NotNull
        @NotBlank
        String curso_nome,

        @NotBlank
        String categoria) {

    public DadosCurso {
        if (id == null) {
            throw new NullPointerException("id cannot be null");
        }
        if (curso_nome == null || curso_nome.isBlank()) {
            throw new NullPointerException("curso_nome cannot be null or blank");
        }
        if (categoria == null || categoria.isBlank()) {
            throw new NullPointerException("categoria cannot be null or blank");
        }
    }
}