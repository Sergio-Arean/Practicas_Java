package Modelo;

public abstract class Zombie extends Personaje{

    public Zombie(double posicion_x, double posicion_y, String nombre, String skin, int nivel_de_vida, String armas) {
        super(posicion_x, posicion_y, nombre, skin, nivel_de_vida, armas);
    }

    public Zombie(){

    }

    public String Morder(){
        String rta = "Estoy mordiendo";
        return rta;
    }
}
