        public class PixelCMYK extends Pixel{
            private short cyan;
            private short magenta;
            private short yellow;
            private short key;
        
    public PixelCMYK(short cyan, short magenta, short yellow, short key){
        this.cyan = cyan;
        this.magenta = magenta;
        this.yellow = yellow;
        this.key = key;
    } 
    
    public int getLuminosidade(){
        return (int)(this.getKey());
    }
    
    public short getCyan(){
        return this.cyan;
    }
    
    public short getMagenta(){
        return this.magenta;
    }
    
    public short getYellow(){
        return this.yellow;
    }
    
    public short getKey(){
        return this.key;
    }
}
