public class Fragmento{
       
    public int getSimilaridade(Mapa m1, Mapa m2){
        return Math.abs(m1.getLuminosidade() - m2.getLuminosidade());
    }
}
