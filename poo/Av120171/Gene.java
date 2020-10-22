public class Gene{
//    private int codigo;
    private int valor;

    public Gene(int valor){
        this.setValor(valor);
    }
    
    private void setValor(int valor){
        this.valor = valor;
    }
    
    public int getValor(){
        return this.valor;
    }
    
    public boolean equals(Gene gene){
        return this.getValor() == gene.getValor();
    }
    
    public Gene clonar(){
        Gene clone = new Gene(this.getValor());
        clone = this;
        return clone;
    }
}
