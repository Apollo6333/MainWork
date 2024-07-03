//André Luiz de Souza Nunes
//Arthur Henrique Damann
//João Vinícius Rosá

import java.util.ArrayList;
import java.util.List;

public class Advogado extends Usuario{
    private String registroOAB;
    private List<Processo> processosVinculados;

    public Advogado(String login, String senha, String registroOAB) {
        super(login, senha);
        setRegistroOAB(registroOAB);
        this.processosVinculados = new ArrayList<>();
    }

    public String getRegistroOAB() {
        return registroOAB;
    }

    public void setRegistroOAB(String registroOAB) {
        this.registroOAB = registroOAB;
    }

    public List<Processo> getProcessosVinculados() {
        return processosVinculados;
    }

    public void vincularProcesso(Processo processo) {
        processosVinculados.add(processo);
    }

}