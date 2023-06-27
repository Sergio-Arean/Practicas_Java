package Modelo;

public class Clicker extends Zombie{
    private int grado_chasqueo;

    public Clicker(double posicion_x, double posicion_y, String nombre, String skin, int nivel_de_vida, String armas, int grado_chasqueo) {
        super(posicion_x, posicion_y, nombre, skin, nivel_de_vida, armas);
        this.grado_chasqueo = grado_chasqueo;
    }

    public Clicker(){

    }
    public String Chasquear(){
        String rta= "Como buen clicker estoy chasqueando";
        return rta;
    }

    @Override
    public String toString() {
        return "Clicker{" +
                 super.toString() +
                "grado_chasqueo=" + grado_chasqueo +
                "} " ;
    }
}
