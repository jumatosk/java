public class Musica{
    private String titulo;
    private String[] artistas;
    private long segundos;
    private String genero;
    private String gravadora;
    private CampoHarmonico campoHarmonico;
    
    public Musica(String titulo, String[] artistas, long segundos, String genero, String gravadora, CampoHarmonico campoHarmonico){
        this.setTitulo(titulo);
        this.setArtistas(artistas);
        this.setSegundos(segundos);
        this.setGenero(genero);
        this.setGravadora(gravadora);
        this.setCampoHarmonico(campoHarmonico);
    }
    
    public boolean equals(Musica outra){
        return this.getTitulo().equals(outra.getTitulo()) && this.getArtistas().equals(outra.getArtistas());
    }
    
    private boolean possuiArtista(String artista){
        for(String art : this.getArtistas())
            if(art.equals(artista))
                return true;
        return false;
    }
    
    private double getProximidadeArtistas(Musica musica){
      int possui=0;
      
      double maximo = this.getArtistas().length >= musica.getArtistas().length ?
                      this.getArtistas().length : musica.getArtistas().length;
                      
      for(String a : musica.getArtistas())
            if(possuiArtista(a))
                possui++;
      return possui / maximo;    
    }
    
    public double getProximidade(Musica outra){
        int valor=0;
        
        if(this.getCampoHarmonico().equals(outra.getCampoHarmonico()))
            valor +=1;
        if(this.getGravadora().equals(outra.getGravadora()))
            valor +=1;
        if(this.getGenero().equals(outra.getGenero()))
            valor+=1;
      
        return valor + this.getProximidadeArtistas(outra);
    }
    
    private void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    
    private void setArtistas(String[] artistas){
        this.artistas = artistas;
    }
    
    public String[] getArtistas(){
        return this.artistas;
    }
    
    private void setSegundos(long segundos){
        this.segundos = segundos;
    }
    
    public long getSegundos(){
        return this.segundos;
    }
    
    private void setGenero(String genero){
        this.genero = genero;
    }
    
    public String getGenero(){
        return this.genero;
    }
    
    private void setGravadora(String gravadora){
        this.gravadora = gravadora;
    }
    
    public String getGravadora(){
        return this.getGravadora();
    }
    
    private void setCampoHarmonico(CampoHarmonico campoHarmonico){
        this.campoHarmonico = campoHarmonico;
    }
    
    public CampoHarmonico getCampoHarmonico(){
        return this.campoHarmonico;
    }
}