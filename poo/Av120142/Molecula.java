public class Molecula{
    private ReceptorMoleculas[] receptores;
    private double limiarAfinidade;
    private int tamanho;
    
    public Molecula(int tamanho){
        this.receptores = new ReceptorMoleculas[0];
        this.tamanho = tamanho;
    }

    public void setReceptor(ReceptorMoleculas receptor){
        ReceptorMoleculas[] novo = new ReceptorMoleculas[this.receptores.length+1];
        
        for(int iCont=0; iCont<this.receptores.length; iCont++)
            novo[iCont] = this.receptores[iCont];
        novo[novo.length-1] = receptor;
        this.receptores = novo;
    }
    
    public ReceptorMoleculas getReceptor(int posicao){
        return this.receptores[posicao];
    }
    
    public int getSize(){
        return this.receptores.length;
    }
    
    public double getAfinidade(Molecula outra){
        double afinidade=0;
        
        if(this.getSize() == outra.getSize())
            for(int iCont=0; iCont<this.getSize(); iCont++)
                afinidade += Math.sqrt(Math.pow(this.getReceptor(iCont).getAfinidade(outra.getReceptor(iCont)), 2) + Math.pow(outra.getReceptor(iCont).getAfinidade(this.getReceptor(iCont)), 2));
        return afinidade;        
    }
    
    public boolean adere(Molecula outra){
        int distancia = Math.abs(this.getSize() - outra.getSize());
        
        return distancia < this.getAfinidade(outra); 
    }
    
    public boolean detecta(Molecula outra){
        return this.adere(outra) && outra.adere(this);
    }
    
    public String toString(){
        String rep = "";
        
        for(int iCont=0; iCont<this.receptores.length; iCont++)
            rep= "[" + iCont + "." + this.getReceptor(iCont)+ "]"; 
        
        return rep;
    }
}
