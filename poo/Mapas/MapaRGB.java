public class MapaRGB extends Mapa{
    private int r;
    private int g;
    private int b;
    
    public MapaRGB(int r, int g, int b){
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public int getR(){
       return this.r;
    }
   
    public int getG(){
       return this.g;
    }
    
    public int getB(){
       return this.b;
   }
   
   public int getLuminosidade(){
       int luminosidade = (int)(this.getR() * 0.3 + this.getG() * 0.59 + this.getB() * 0.11) / 255;
       return luminosidade;
   }
}
