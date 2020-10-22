public class PixelRGB extends Pixel{
    private short red;
    private short green;
    private short blue;
    
    public PixelRGB(short red, short green, short blue){
        this.red = red;
        this.green = green;
        this.blue = blue;
    } 
    
    public int getLuminosidade(){
        return (int)(this.getRed() * 3 + this.getGreen() * 0.59 + 
                    this.getBlue() * 0.11) / 255;
    }
    
    public short getRed(){
        return this.red;
    }
    
    public short getGreen(){
        return this.green;
    }
    
    public short getBlue(){
        return this.blue;
    }
}
