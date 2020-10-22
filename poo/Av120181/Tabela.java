public class Tabela{
    private String nome;
    private Coluna[] colunas;
    
    public Tabela(String nome){
        this.colunas = new Coluna[0];
        this.nome = nome;
    }
    
    public Tabela(){
        this.colunas = new Coluna[0];
    }
    
    public String getNome(){
        return this.nome;
    }
    
    private Coluna[] adicionaColuna(Coluna coluna){
        Coluna[] nova = new Coluna[this.colunas.length+1];
        
        for(int i=0; i<this.colunas.length; i++)
            nova[i] = this.colunas[i];
        nova[nova.length-1] = coluna;
        this.colunas = nova;
        
        return this.colunas;
    }
    
    public void addColuna(Coluna coluna){
        this.adicionaColuna(coluna);
    }
    
    private Coluna getColuna(int pos){
        return this.colunas[pos];
    }
    
    private int getSize(){
        return this.colunas.length;
    }
    
    public Tabela isPK(){
        Tabela colunasPK = new Tabela();
        
        for(Coluna c: this.colunas)
            if(c.getChavePrimaria())
                colunasPK.addColuna(c);
        return colunasPK;
    }
    
//    private Coluna criaNova
    
    public Tabela merge(Tabela outra, String nome){
        Tabela merge = new Tabela(nome);
        int sizeTotal = this.getSize() + outra.getSize();
        
        for(int i=0; i<this.getSize(); i++){
            if(!this.getColuna(i).equals(outra.getColuna(i))){
                merge.addColuna(this.getColuna(i));
                merge.addColuna(outra.getColuna(i));
            }
            else if(this.getColuna(i).getNulo() && outra.getColuna(i).getNulo()){
                merge.addColuna(new Coluna(this.getColuna(i).getNome(), this.getColuna(i).getTipo(), true, true));
            }
            else if(!this.getColuna(i).getNulo() && !outra.getColuna(i).getNulo()){
                merge.addColuna(new Coluna(this.getColuna(i).getNome(), this.getColuna(i).getTipo(), false, false));
            }
        }
        return merge;
    }
    
    public String toString(){
        String rep;
        rep = "CREATE TABLE " + this.getNome() +"(\n"+
        "[" + this.getColuna(1) + "]1*\n" + 
        "CONSTRAINT PRIMARY KEY([" + this.getColuna(1).getNome() + "]*)";
        
        return rep;
    }
}