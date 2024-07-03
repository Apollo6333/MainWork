//André Luiz de Souza Nunes
//Arthur Henrique Damann
//João Vinícius Rosá

public class Fisica extends Pessoa{
    private String cpf;

    public Fisica(String nome, boolean cliente, String cpf) {
        super(nome, cliente);
        setCpf(cpf);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
}