package Modelo;

public class Runner extends Zombie{
    private int nivel_energia_extra;

    public Runner(double posicion_x, double posicion_y, String nombre, String skin, int nivel_de_vida, String armas, int nivel_energia_extra) {
        super(posicion_x, posicion_y, nombre, skin, nivel_de_vida, armas);
        this.nivel_energia_extra = nivel_energia_extra;
    }

    public Runner(){

    }

    public String Correr(){
        String rta = "Como buen runner estoy corriendo";
        return rta;
    }

    @Override
    public String toString() {
        return "Runner{" +
                super.toString() +
                "nivel_energia_extra=" + nivel_energia_extra +
                "} " ;
    }
}
