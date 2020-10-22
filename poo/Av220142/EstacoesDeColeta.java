public class EstacoesDeColeta extends UnidadeSensora{
    private double historicoValores[];

    
    public EstacoesDeColeta(double latitude, double longitude, double altura, int id){
        super(latitude, longitude, altura, id);
        this.historicoValores = new double[0];
    }
}
