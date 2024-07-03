//André Luiz de Souza Nunes
//Arthur Henrique Damann
//João Vinícius Rosá

public class Processo {
    private int codigo;
    private Tribunal tribunal;
    private String descricao;
    private Usuario secretariaAbertura;
    private Usuario advogadoResponsavel;
    private boolean concluido;
    
    public Processo(int codigo, Tribunal tribunal, String descricao, Usuario secretariaAbertura, Usuario advogadoResponsavel, boolean concluido) {
        setCodigo(codigo);
        setTribunal(tribunal);
        setDescricao(descricao);
        setSecretariaAbertura(secretariaAbertura);
        setAdvogadoResponsavel(advogadoResponsavel);
        setConcluido(concluido);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Tribunal getTribunal() {
        return tribunal;
    }

    public void setTribunal(Tribunal tribunal) {
        this.tribunal = tribunal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getSecretariaAbertura() {
        return secretariaAbertura;
    }

    public void setSecretariaAbertura(Usuario secretariaAbertura) {
        this.secretariaAbertura = secretariaAbertura;
    }

    public Usuario getAdvogadoResponsavel() {
        return advogadoResponsavel;
    }

    public void setAdvogadoResponsavel(Usuario advogadoResponsavel) {
        this.advogadoResponsavel = advogadoResponsavel;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
    
}