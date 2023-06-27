package Modelo;

public class Plataforma extends Objeto {
    private String material;
    private String soporte;

    public Plataforma(double posicion_x, double posicion_y, double ancho, double alto, String material, String soporte) {
        super(posicion_x, posicion_y, ancho, alto);
        this.material = material;
        this.soporte = soporte;
    }

    public Plataforma(){

    }

    @Override
    public String toString() {
        return "Plataforma{" +
                "material='" + material + '\'' +
                ", soporte='" + soporte + '\'' +
                "} " + super.toString();
    }
}
