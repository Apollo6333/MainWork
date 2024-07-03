//André Luiz de Souza Nunes
//Arthur Henrique Damann
//João Vinícius Rosá

public class Custo {
    private String data;
    private String descricao;
    private double valor;
    
    public Custo(String data, String descricao, double valor) {
        setData(data);
        setDescricao(descricao);
        setValor(valor);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}