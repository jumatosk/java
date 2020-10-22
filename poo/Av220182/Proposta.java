public class Proposta{
    private double valor;
    private Objetos objeto;
    
    public Proposta(double valor, Objetos objeto){
        this.setValor(valor);
        this.setObjeto(objeto);
    }
    
    public void setValor(double valor){
        this.valor = valor;
    }
    
    public void setObjeto(Objetos objeto){
        this.objeto = objeto;
    }
    
}
