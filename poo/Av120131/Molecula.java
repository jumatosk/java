public class Molecula{
    private Atomo[] elementos;
    
    public Molecula(){
        this.elementos = new Atomo[0];
    }
    
    public void addAtomo(Atomo atomo){
        this.add(atomo);
    }
    
    private void add(Atomo atomo){
        Atomo[] novo = new Atomo[this.elementos.length + 1];
        
        for(int i=0; i<this.elementos.length; i++)
            novo[i] = this.elementos[i];
        
        novo[novo.length -1] = atomo;
        this.elementos = novo;
    }
    
    public Atomo getMenor(){
        int menor=this.elementos[0].getNroAtomico();
        Atomo atomo = new Atomo();
        
        for(int i=1; i<this.elementos.length; i++){
            if(menor > this.elementos[i].getNroAtomico())
                menor = this.elementos[i].getNroAtomico();
                atomo = this.elementos[i];
        }
        return atomo;
    }
    
    public int getQtdAtomos(Atomo a){
        int total=0;
        for(Atomo atomo: this.elementos)
            if(atomo.equals(a))
                total++;
        return total;
    }
    
    private int getSize(){
        return this.elementos.length;
    }
    
    public Atomo getAtomo(int pos){
        return this.elementos[pos];
    }
    
    public boolean mesmosElementos(Molecula outra){  
      boolean v1 = false;
      boolean v2 = false;
      
      for(int j=0; j<outra.getSize(); j++)
            for(int i=outra.getSize(); i==0; i--)     
            if(this.getAtomo(j).equals(outra.getAtomo(j)) && this.getAtomo(i).equals(outra.getAtomo(i)))
                return true;
      
      /*for(int i=outra.getSize(); i==0; i--)
            if()
                v2 = true;
        return v1 && v2;*/
      return false;  
    }
    
    public boolean equivalentes(Molecula outra){
        return this.mesmosElementos(outra) && outra.mesmosElementos(this);
    
    }
    
}