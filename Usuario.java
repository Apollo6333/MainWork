//André Luiz de Souza Nunes
//Arthur Henrique Damann
//João Vinícius Rosá

public class Usuario {
    private String login;
    private String senha;
    
    public Usuario(String login, String senha) {
        setLogin(login);
        setSenha(senha);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}