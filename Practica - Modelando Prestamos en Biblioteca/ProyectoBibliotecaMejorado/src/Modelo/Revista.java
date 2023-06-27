package Modelo;

public class Revista extends Libro{
    private boolean bizarra;

    public Revista(String titulo, String autor, int anio_publicacion, int cantidad, int cantidad_prestados, boolean disponible, int prestamos_realizados, boolean promocion_vigente, boolean bizarra) {
        super(titulo, autor, anio_publicacion, cantidad, cantidad_prestados, disponible, prestamos_realizados, promocion_vigente);
        this.bizarra = bizarra;
    }


    @Override
    double DefinirValorAlquilerDiario() {
        return 100;
    }

    @Override
    double DefinirPorcentajeDescuentoPromoVigente() {
        return 0.3;
    }

    @Override
    public String toString() {
        return "Revista{" +super.toString()+
                "bizarra=" + Bizarra() +
                "} " ;
    }


    private String Bizarra(){
        String rta = " Si ";
        if(!bizarra){
            rta = " No ";
        }
        return rta;
    }
}
