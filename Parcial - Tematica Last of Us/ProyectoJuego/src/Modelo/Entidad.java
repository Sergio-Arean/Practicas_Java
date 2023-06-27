package Modelo;

public abstract class Entidad {
    private double posicion_x;
    private double posicion_y;

    public Entidad(double posicion_x, double posicion_y) {
        this.posicion_x = posicion_x;
        this.posicion_y = posicion_y;
    }

    public Entidad(){

    }

    @Override
    public String toString() {
        return "Entidad{" +
                "posicion_x=" + posicion_x +
                ", posicion_y=" + posicion_y +
                '}';
    }
}
