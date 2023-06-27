package Modelo;

public class Joel extends Player{
    private int nivel_mala_onda;
    private int nivel_testarudez;

    public Joel(double posicion_x, double posicion_y, String nombre, String skin, int nivel_de_vida, String armas, int nivel_mala_onda, int nivel_testarudez) {
        super(posicion_x, posicion_y, nombre, skin, nivel_de_vida, armas);
        this.nivel_mala_onda = nivel_mala_onda;
        this.nivel_testarudez = nivel_testarudez;
    }

    public Joel(){

    }

    @Override
    public String toString() {
        return "JOEL" +
                super.toString() +
                "nivel_mala_onda=" + nivel_mala_onda +
                ", nivel_testarudez=" + nivel_testarudez +
                "} " ;
    }
}
