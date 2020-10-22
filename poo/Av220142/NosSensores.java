public class NosSensores extends UnidadeSensora{
   private double valor;
   
   public NosSensores(double latitude, double longitude, double altura, int id, double valor){
       super(latitude, longitude, altura, id);
       this.valor = valor;
   }
   
   
}

