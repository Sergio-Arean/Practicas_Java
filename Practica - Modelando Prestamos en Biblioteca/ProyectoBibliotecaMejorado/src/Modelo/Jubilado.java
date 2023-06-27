package Modelo;

public class Jubilado extends Cliente{
    private boolean por_la_minima;

    public Jubilado(String nombre, String dni, String domicilio, String telefono) {
        super(nombre, dni, domicilio, telefono);
        por_la_minima = false; //al crearlo somos optimistas
    }

    @Override
    public String toString() {
        return "JUBILADO{"
                + super.toString() +
                "por_la_minima=" + PorLaMinima() +
                "} " ;
    }

    @Override
    double DefinirPorcentajeDeDescuento() {
        return 0.2;
    }

    private String PorLaMinima(){
        String rta= " Si ";
        if(!por_la_minima){
            rta = " No ";
        }
        return rta;
    }
}
