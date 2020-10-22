public abstract class Edital{
    protected String numeracao;
    protected String descricao;
    protected Objetos[] objetos;
    protected Empresa[] empresas;

    public Edital(String numeracao, String descricao){
        this.setNumeracao(numeracao);
        this.setDescricao(descricao);
        this.objetos = new Objetos[0];
        this.empresas = new Empresa[0];
    }    
    
    public void adicionarEmpresa(Empresa empresa){
        Empresa[] nova = new Empresa[this.empresas.length + 1];
        
        for(int iCont=0; iCont<this.empresas.length; iCont++)
            nova[iCont] = this.empresas[iCont];
        nova[nova.length - 1] = empresa;
        this.empresas = nova;
    }

    public Empresa[] getEmpresas(){
        return this.empresas;
    }
    
    private void setNumeracao(String numeracao){
        this.numeracao = numeracao;
    }

    public String getNumeracao(){
        return this.numeracao;
    }

    private void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }

}
