public class Coluna{
    private String nome;
    private Tipo tipo;
    private boolean nulo;
    private boolean chavePrimaria;
    
    public Coluna(String nome, Tipo tipo){
        this.setNome(nome);
        this.setTipo(tipo);
        this.setNulo(true);
        this.setChavePrimaria(false);
    }
    
    public Coluna(String nome, Tipo tipo, boolean nulo, boolean chavePrimaria){
        this.setNome(nome);
        this.setTipo(tipo);
        this.setNulo(nulo);
        this.setChavePrimaria(chavePrimaria);
    }    
    
    public boolean equals(Coluna coluna){
        return this.getNome() == coluna.getNome() &&
               this.getTipo() == coluna.getTipo();
    }
    
    public String toString(){
        return this.nome.toString() + ", " + this.tipo.toString() + ", [" + this.getNulo() + "]";
    }
    
    private void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    private void setTipo(Tipo tipo){
        this.tipo = tipo;
    }
    
    public Tipo getTipo(){
        return this.tipo;
    }
    
    private void setNulo(boolean nulo){
        this.nulo = nulo;
    }
    
    public boolean getNulo(){
        return this.nulo;
    }
    
    private void setChavePrimaria(boolean chavePrimaria){
        this.chavePrimaria = chavePrimaria;
    }
    
    public boolean getChavePrimaria(){
        return this.chavePrimaria;
    }

}