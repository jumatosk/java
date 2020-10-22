public class MapaCMYK extends Mapa{
    private PixelCMYK[][] pixelsCMYK;
    
    public MapaCMYK(int altura, int largura){
        this.pixelsCMYK = new PixelCMYK[altura][largura];
    }
    
    public void setPixelsRGB(int y, int x, Pixel pixel){
        this.pixelsCMYK[y][x] = (PixelCMYK)pixel;
    }
    
}
