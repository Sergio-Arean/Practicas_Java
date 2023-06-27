package Modelo;

public class Stalker extends Zombie{
    private int nivel_acechanza;

    public Stalker(double posicion_x, double posicion_y, String nombre, String skin, int nivel_de_vida, String armas, int nivel_acechanza) {
        super(posicion_x, posicion_y, nombre, skin, nivel_de_vida, armas);
        this.nivel_acechanza = nivel_acechanza;
    }

    public Stalker(){

    }

    public String Acechar(){
        String rta = "Como buen stalker estoy acechando";
        return rta;
    }

    @Override
    public String toString() {
        return "Stalker{" +
                "nivel_acechanza=" + nivel_acechanza +
                "} " + super.toString();
    }
}
