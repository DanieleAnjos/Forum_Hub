package forum.hub.api.infra.security;

public class DadosTokenJWT {

    private String token;
    private String username;
    private String expiration;

    public DadosTokenJWT(String token) {
        this.token = token;
        this.username = username;
        this.expiration = expiration;
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public String getExpiration() {
        return expiration;
    }
}