package Modelo;

public class Ellie extends Player{
    private int grado_de_humor;
    private int cantidad_chistes_malos;

    public Ellie(double posicion_x, double posicion_y, String nombre, String skin, int nivel_de_vida, String armas, int grado_de_humor, int cantidad_chistes_malos) {
        super(posicion_x, posicion_y, nombre, skin, nivel_de_vida, armas);
        this.grado_de_humor = grado_de_humor;
        this.cantidad_chistes_malos = cantidad_chistes_malos;
    }

    public Ellie(){

    }

    @Override
    public String toString() {
        return "ELLIE{"
                + super.toString() +
                "grado_de_humor=" + grado_de_humor +
                ", cantidad_chistes_malos=" + cantidad_chistes_malos +
                "} " ;
    }
}
