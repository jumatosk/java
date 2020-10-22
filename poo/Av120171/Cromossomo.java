public class Cromossomo{
    private Gene[] cromossomo;
    private int alelos;
    
    public Cromossomo(int alelos){
        this.cromossomo = new Gene[alelos];
        this.setAlelos(alelos);
    }
    
    public Cromossomo(){
        this.cromossomo = new Gene[0];
    }

    public Gene getGene(int alelo){
        return this.cromossomo[alelo];
    }
    
    private void setAlelos(int alelos){
        this.alelos = alelos;
    }
    
    public int getAlelos(){
        return this.alelos;
    }
    
    public void setGene(Gene gene){
        int j=0;
        for(int i=0; i<this.cromossomo.length; i++)
            if(this.getGene(i) != null)
                j++;
            this.cromossomo[j] = gene;
                
    }
    
    private void setGene(Gene gene, int pos){
        this.cromossomo[pos] = gene;
    }  
    
    private int getSize(){
        return this.cromossomo.length;
    }
    
    public void addGene(Gene outro){
        Gene[] novo = new Gene[this.cromossomo.length + 1];
        
        for(int i=0; i<this.cromossomo.length; i++)
            novo[i] = this.cromossomo[i];
        novo[novo.length-1] = outro;
        this.cromossomo = novo;
    
    }
    
    public Cromossomo clonar(){
        Cromossomo novo = new Cromossomo(this.getAlelos());
        
        for(int i=0; i<this.getAlelos(); i++)
            if(this.getGene(i) != null)
                novo.setGene(this.getGene(i).clonar(), i);
        
        return novo;
    }
    
    public double getPercentualId(Cromossomo outro){
        double pontuacao = 0;
        int menor=0;
        
        if(outro.getAlelos() == this.getAlelos()){
            for(int i=0; i<this.cromossomo.length; i++){
                if(this.getGene(i).equals(outro.getGene(i)))
                    pontuacao += 1;
                else if(!this.getGene(i).equals(outro.getGene(i)))
                    pontuacao -= 1;
                else if(this.getGene(i) == null && outro.getGene(i) != null || this.getGene(i) != null || outro.getGene(i) == null)
                    pontuacao -= 2;
                else if(this.getGene(i) == null && outro.getGene(i) == null)
                    pontuacao = 0;
            }
            pontuacao = pontuacao / this.getSize();
        }
        else{
            if(this.getAlelos() < outro.getAlelos())
                menor = this.getAlelos();
            else
                menor = outro.getAlelos();
            for(int i=0; i<menor; i++){
                if(this.getGene(i).equals(outro.getGene(i)))
                    pontuacao += 1;
                else if(!this.getGene(i).equals(outro.getGene(i)))
                    pontuacao -= 1;
                else if(this.getGene(i) == null && outro.getGene(i) != null || this.getGene(i) != null || outro.getGene(i) == null)
                    pontuacao -= 2;
                else if(this.getGene(i) == null && outro.getGene(i) == null)
                    pontuacao = 0;
            }
            pontuacao = pontuacao / this.getSize();
        }
        return pontuacao;    
   }
   
   public void cruzamento(Cromossomo outro, int ponto){
       int maior = this.getSize() > outro.getSize() ? this.getSize() : outro.getSize();
       Gene[] aux1 = new Gene[this.getSize() - ponto];
       Gene[] aux2 = new Gene[outro.getSize() - ponto];
       int i;
       
       for(i=0; i<ponto; i++){
           if(i < aux1.length)
                aux1[i] = this.getGene(i);
           if(i < aux2.length)
                aux2[i] = outro.getGene(i);
       }
       
       for(; i<maior; i++){
           if(i < aux1.length)
                aux1[i] = outro.getGene(i);
           if(i < aux2.length)
                aux2[i] = this.getGene(i);
       }
       
       this.cromossomo = aux1;
       outro.cromossomo = aux2;
   }
}        