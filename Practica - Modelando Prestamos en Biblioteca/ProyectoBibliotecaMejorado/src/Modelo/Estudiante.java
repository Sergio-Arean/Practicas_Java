package Modelo;

public class Estudiante extends Cliente{
    private String institucion;

    public Estudiante(String nombre, String dni, String domicilio, String telefono, String institucion) {
        super(nombre, dni, domicilio, telefono);
        this.institucion = institucion;
    }

    @Override
    double DefinirPorcentajeDeDescuento() {
        return 0.15;
    }
}
