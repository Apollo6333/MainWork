//André Luiz de Souza Nunes
//Arthur Henrique Damann
//João Vinícius Rosá

public class Secretaria extends Usuario{
    private String numeroCT;

    public Secretaria(String login, String senha, String numeroCT) {
        super(login, senha);
        setNumeroCT(numeroCT);
    }

    public String getNumeroCT() {
        return numeroCT;
    }

    public void setNumeroCT(String numeroCT) {
        this.numeroCT = numeroCT;
    }
}