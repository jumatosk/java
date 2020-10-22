public class DatabaseMusicas{
    private Musica[] musicas;
    
    public DatabaseMusicas(){
        this.musicas = new Musica[0];
    }
    
    public void addMusica(Musica musica){
        Musica[] nova = new Musica[this.musicas.length + 1];
        
        for(int i=0; i<this.musicas.length; i++)
            nova[i] = this.musicas[i];
        nova[nova.length - 1] = musica;
        this.musicas = nova;
    }
    
    public Playlist similar(String nome, long duracao, Playlist base){
        Playlist similar = new Playlist(nome);
        int iCont=0;
        
        while(similar.getDuracao() < duracao && iCont < this.musicas.length){
            if(!base.pertence(this.musicas[iCont]))
                similar.addMusica(this.musicas[iCont]);
                iCont++;
        }
        
        return similar;
        
    }
}