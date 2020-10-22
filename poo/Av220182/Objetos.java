public class Objetos{
    private String unidade;
    private int qtd;
    
    public Objetos(){}
    
    public Objetos(String unidade, int qtd){
        this.setUnidade(unidade);
        this.setQtd(qtd);
    }
    
    private void setUnidade(String unidade){
        this.unidade = unidade;
    }
    
    private void setQtd(int qtd){
        this.qtd = qtd;
    }
}
