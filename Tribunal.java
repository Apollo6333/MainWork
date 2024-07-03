//André Luiz de Souza Nunes
//Arthur Henrique Damann
//João Vinícius Rosá

import java.util.List;

public class Tribunal {
    private String nome;
    private List<Vara> varas;

    public Tribunal(String nome, List<Vara> varas) {
        setNome(nome);
        setVaras(varas);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Vara> getVaras() {
        return varas;
    }

    public void setVaras(List<Vara> varas) {
        this.varas = varas;
    }

    @Override
    public String toString() {
        return nome;
    }
}