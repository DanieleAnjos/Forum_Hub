package forum.hub.api.domain.topico;

import forum.hub.api.domain.curso.Curso;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopicos(

        @NotNull
        @NotBlank
        String titulo,

        @NotNull
        @NotBlank
        String mensagem,

        @NotNull
        @NotBlank
        String autor,

        @NotNull
        @Valid
        Curso curso) {

        public String getTitulo() {
                return titulo;
        }

        public String getMensagem() {
                return mensagem;
        }

        public String getAutor() {
                return autor;
        }

        public Curso getCurso() {
                return curso;
        }

        @Override
        public String toString() {
                return "DadosCadastroTopicos{" +
                        "titulo='" + titulo + '\'' +
                        ", mensagem='" + mensagem + '\'' +
                        ", autor='" + autor + '\'' +
                        ", curso=" + curso +
                        '}';
        }
}