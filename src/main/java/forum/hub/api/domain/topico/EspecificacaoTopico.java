package forum.hub.api.domain.topico;

import org.springframework.data.jpa.domain.Specification;

public class EspecificacaoTopico {

    public static Specification<Topico> withTituloContaining(String nome) {
    return Specification.where((root, query, builder) -> builder.like(root.get("titulo"), "%" + nome + "%"));
}

    public static Specification<Topico> withDataCriacaoInAno(Integer ano) {
        return Specification.where((root, query, builder) -> builder.equal(builder.function("year", Integer.class, root.get("dataCriacao")), ano));
    }

    public static Specification<Topico> byNome(String nome) {
        return Specification.where((root, query, builder) -> builder.like(root.get("nome"), "%" + nome + "%"));
    }

    public static Specification<Topico> byAno(Integer ano) {
        return Specification.where((root, query, builder) -> builder.equal(root.get("ano"), ano));
    }


}
