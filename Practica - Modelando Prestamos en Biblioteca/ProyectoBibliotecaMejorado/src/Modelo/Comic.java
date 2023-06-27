package Modelo;

public class Comic extends Libro{
    private String personaje_principal;

    public Comic(String titulo, String autor, int anio_publicacion, int cantidad, int cantidad_prestados, boolean disponible, int prestamos_realizados, boolean promocion_vigente, String personaje_principal) {
        super(titulo, autor, anio_publicacion, cantidad, cantidad_prestados, disponible, prestamos_realizados, promocion_vigente);
        this.personaje_principal = personaje_principal;
    }

    @Override
    double DefinirValorAlquilerDiario() {
        return 50;
    }

    @Override
    double DefinirPorcentajeDescuentoPromoVigente() {
        return 0.1;
    }

    @Override
    public String toString() {
        return "Comic{" +
                super.toString() +
                "personaje_principal='" + personaje_principal + '\'' +
                "} " ;
    }
}
