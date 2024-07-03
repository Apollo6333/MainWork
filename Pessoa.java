//André Luiz de Souza Nunes
//Arthur Henrique Damann
//João Vinícius Rosá

public class Pessoa {

    private String nome;
    private boolean cliente;

    public Pessoa(String nome, boolean cliente) {
        setNome(nome);
        setCliente(cliente);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isCliente() {
        return cliente;
    }

    public void setCliente(boolean cliente) {
        this.cliente = cliente;
    }
    
}