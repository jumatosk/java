public class Playlist{
    private String nome;
    private Musica[] musicas;
    
    public Playlist(String nome){
        this.musicas = new Musica[0];
        this.setNome(nome);
    }
    
    private void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public Musica[] getMusicas(){
        return this.musicas;
    }
    
    public boolean pertence(Musica musica){
        for(Musica m : this.musicas)
            if(musica.equals(m))
                return true;
        return false;
    }
    
    public long getDuracao(){
        long duracao=0;
        
        for(Musica musica : this.musicas)
            duracao += musica.getSegundos();
        return duracao;
    }
    
    public void addMusica(Musica musica){
        Musica[] nova = new Musica[this.musicas.length + 1];
        
        for(int i=0; i<this.musicas.length; i++)
            nova[i] = this.musicas[i];
        nova[nova.length - 1] = musica;
        this.musicas = nova;
    }
}