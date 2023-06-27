package Modelo;

public class Muro extends Objeto{
    private int nivel_de_resistencia;

    public Muro(double posicion_x, double posicion_y, double ancho, double alto, int nivel_de_resistencia) {
        super(posicion_x, posicion_y, ancho, alto);
        this.nivel_de_resistencia = nivel_de_resistencia;
    }

    public Muro(){

    }

    @Override
    public String toString() {
        return "Muro{" +
                "nivel_de_resistencia=" + nivel_de_resistencia +
                "} " + super.toString();
    }
}
