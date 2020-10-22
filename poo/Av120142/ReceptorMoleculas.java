public class ReceptorMoleculas{
    private double proteina;
    
    public ReceptorMoleculas(double valor){
        this.setProteina(valor);
    }
    
    public ReceptorMoleculas(){
        this.setProteina(0);
    }
    
    public double getAfinidade(ReceptorMoleculas outro){
        return Math.abs(this.getProteina() - outro.getProteina());
    }
    
    public double getProteina(){
        return this.proteina;
    }
    
    public void setProteina(double valor){
        this.proteina = valor;
    }
    
    public String toString(){
        return "[" + this.getProteina() + "]";
    }
}
