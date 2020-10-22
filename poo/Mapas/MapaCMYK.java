public class MapaCMYK{
   private int c;
   private int m;
   private int y;
   private int k;
   
   public MapaCMYK(int c, int m, int y, int k){
       this.c = c;
       this.m = m;
       this.y = y;
       this.k = k;
   }
   
   public int getC(){
       return this.c;
   }
   
   public int getM(){
       return this.m;
   }

   public int getY(){
       return this.y;
   }
   
   public int getK(){
       return this.k;
   }
   
   public int getLuminosidade(){
       return this.k;
   }
   
}
