package forum.hub.api.domain.topico;

public record DadosListagemTopico(Long id, String titulo, String mensagem, java.time.LocalDateTime dataCriacao, String autor) {
    public static DadosListagemTopico fromTopico(Topico topico) {
        return new DadosListagemTopico(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getAutor());
    }



    @Override
    public String toString() {
        return "DadosListagemTopico{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", mensagem='" + mensagem + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", autor='" + autor + '\'' +
                '}';
    }
}