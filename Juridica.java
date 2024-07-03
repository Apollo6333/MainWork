//André Luiz de Souza Nunes
//Arthur Henrique Damann
//João Vinícius Rosá

public class Juridica extends Pessoa{
    private String cnpj;

    public Juridica(String nome, boolean cliente, String cnpj) {
        super(nome, cliente);
        setCnpj(cnpj);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}