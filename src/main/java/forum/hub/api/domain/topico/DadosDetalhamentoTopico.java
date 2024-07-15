package forum.hub.api.domain.topico;

public record DadosDetalhamentoTopico(Long id, String titulo, String mensagem, java.time.LocalDateTime dataCriacao, String autor) {


    public static DadosDetalhamentoTopico fromTopico(Topico topico) {
        return new DadosDetalhamentoTopico(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getAutor());
    }

    @Override
    public String toString() {
        return "DadosDetalhamentoTopico{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", mensagem='" + mensagem + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", autor='" + autor + '\'' +
                '}';
    }
}