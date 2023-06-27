package Modelo;

public abstract class Player extends Personaje{

    public Player(double posicion_x, double posicion_y, String nombre, String skin, int nivel_de_vida, String armas) {
        super(posicion_x, posicion_y, nombre, skin, nivel_de_vida, armas);
    }

    public Player(){

    }

    public String Curarse(){
        String rta = "Me estoy curando";
        return rta;
    }
    public String RecargarArma(){
        String rta = "Estoy recargando arma";
        return rta;
    }




}
