public class ImagemRGB{
    private MapaRGB[][] pixels;
    
    public ImagemRGB (int altura, int largura){
        this.pixels = new MapaRGB[altura][largura];
        
        for(int iCont=0; iCont < this.pixels.length; iCont++){
            for(int jCont=iCont; jCont < this.pixels.length; jCont++){
                this.pixels[iCont][jCont] = new MapaRGB(255, 255, 255);
            }
        }
    }
    
    private void setPixel(int x, int y, MapaRGB cor){
        this.pixels[x][y] = cor;
    }
    
    public int getAltura(){
        return this.pixels[0].length;
    }
    
    public int getLargura(){
        return this.pixels.length;
    }
    
    public void criarImagem(int altura, int largura, MapaRGB cor){
        for(int iCont=0; iCont<altura; iCont++){
            for(int jCont=0; jCont<largura; jCont++){
               
            }
        }
    }
}
