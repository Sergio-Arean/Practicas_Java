package Modelo;

public class Particular extends Cliente{
    private boolean quejoso;

    public Particular(String nombre, String dni, String domicilio, String telefono) {
        super(nombre, dni, domicilio, telefono);
        quejoso = false; //al crearlo somos optimistas
    }

    @Override
    double DefinirPorcentajeDeDescuento() {
        return 0;
    }

    @Override
    public String toString() {
        return "CLIENTE PARTICULAR{" +
                super.toString() +
                "quejoso=" + Quejoso() +
                "} " ;
    }

    private String Quejoso(){
        String rta = " Si ";
        if(!quejoso){
            rta = " No ";
        }
        return rta;
    }
}
