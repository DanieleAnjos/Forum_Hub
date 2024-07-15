package forum.hub.api.domain.usuario;

public record DadosAutenticacao(String login, String senha) {

    public DadosAutenticacao {
        if (login == null || login.isEmpty()) {
            throw new IllegalArgumentException("Login cannot be null or empty");
        }
        if (senha == null || senha.isEmpty()) {
            throw new IllegalArgumentException("Senha cannot be null or empty");
        }
    }

    public String login() {
        return login;
    }

    public String senha() {
        return senha;
    }
}