public class Empresa{
    private String nome;
    private int CNPJ;
    private String representante;
    private Proposta[] propostas;
    
    public Empresa (String nome, int CNPJ, String representante){
        this.setNome(nome);
        this.setCNPJ(CNPJ);
        this.setRepresentate(representante);
        this.propostas = new Proposta[0];
    }
    
    public void adicionarProposta(Proposta proposta){
        Proposta[] nova = new Proposta[this.propostas.length + 1];
        
        for(int iCont=0; iCont<this.propostas.length; iCont++)
            nova[iCont] = this.propostas[iCont];
        nova[nova.length - 1] = proposta;
        this.propostas = nova;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    private void setCNPJ(int CNPJ){
        this.CNPJ = CNPJ;
    }
    
    public int getCNPJ(){
        return this.CNPJ;
    }
    
    private void setRepresentate(String representante){
        this.representante = representante;
    }
}

