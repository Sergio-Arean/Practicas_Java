package Modelo;

public class Novela extends Libro{
    private String editorial;

    public Novela(String titulo, String autor, int anio_publicacion, int cantidad, int cantidad_prestados, boolean disponible, int prestamos_realizados, boolean promocion_vigente, String editorial) {
        super(titulo, autor, anio_publicacion, cantidad, cantidad_prestados, disponible, prestamos_realizados, promocion_vigente);
        this.editorial = editorial;
    }

    @Override
    double DefinirValorAlquilerDiario() {
        return 70;
    }

    @Override
    double DefinirPorcentajeDescuentoPromoVigente() {
        return 0.1;
    }

    @Override
    public String toString() {
        return "Novela{" +
                 super.toString() +
                "editorial='" + editorial + '\'' +
                "} " ;
    }
}
