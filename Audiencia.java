//André Luiz de Souza Nunes
//Arthur Henrique Damann
//João Vinícius Rosá

public class Audiencia {
    private String data;
    private String recomendacaoTribunal;
    
    public Audiencia(String data, String recomendacaoTribunal) {
        setData(data);
        setRecomendacaoTribunal(recomendacaoTribunal);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRecomendacaoTribunal() {
        return recomendacaoTribunal;
    }

    public void setRecomendacaoTribunal(String recomendacaoTribunal) {
        this.recomendacaoTribunal = recomendacaoTribunal;
    }
}