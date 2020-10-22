public class Atomo{

    public int nroAtomico;
    public double massa;
    public String nome;
    public int[] eletrons;
    
    public Atomo(){}
    
    public Atomo(int nroAtomico, double massa, String nome){
        this.setNroAtomico(nroAtomico);
        this.setMassa(massa);
        this.setNome(nome);
        this.eletrons = new int[7];
    }
    
    public boolean saoIguais(Atomo outro){
        return this.getNroAtomico() == outro.getNroAtomico();
    }
    
    public int getEletron(int camada){
        return this.eletrons[camada];
    }
    
    private void setNroAtomico(int nroAtomico){
        this.nroAtomico = nroAtomico;
    }
    
    public int getNroAtomico(){
        return this.nroAtomico;
    }
    
    private void setMassa(double massa){
        this.massa = massa;
    }
    
    public double getMassa(){
        return this.massa;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setEletrons(int valor){
        int k=0;
        
        for(int i=0; i<this.eletrons.length; i++)
            if(this.getEletron(i) != 0)
                k++;
        this.eletrons[k] = valor;
    }
}