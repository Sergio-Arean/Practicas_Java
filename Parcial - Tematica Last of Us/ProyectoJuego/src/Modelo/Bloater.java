package Modelo;

import Interfaces.ICamuflable;

public class Bloater extends Zombie implements ICamuflable {
    private int nivel_hinchazon;

    public Bloater(double posicion_x, double posicion_y, String nombre, String skin, int nivel_de_vida, String armas, int nivel_hinchazon) {
        super(posicion_x, posicion_y, nombre, skin, nivel_de_vida, armas);
        this.nivel_hinchazon = nivel_hinchazon;
    }

    @Override
    public String Camuflarse() {
        String rta = "Me estoy camuflando bro";
        return rta;
    }

    @Override
    public String toString() {
        return "Bloater{"
                + super.toString()+
                "nivel_hinchazon=" + nivel_hinchazon +
                "} ";
    }
}
