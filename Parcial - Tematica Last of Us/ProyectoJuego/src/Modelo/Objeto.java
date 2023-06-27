package Modelo;

public abstract class Objeto extends Entidad {
    private double ancho;
    private double alto;

    private static int cantidad_creados;//para autogeneracion de id
    private int id_objeto; //para que cada objeto tenga una identificacion unica

    public Objeto(double posicion_x, double posicion_y, double ancho, double alto) {
        super(posicion_x, posicion_y);
        this.ancho = ancho;
        this.alto = alto;
        cantidad_creados++;
        id_objeto = cantidad_creados;
    }

    public Objeto(){

    }

    public int getId_objeto() {
        return id_objeto;
    }

    @Override
    public boolean equals(Object obj) {
        boolean rta = false;
        if(obj!=null){
            if(obj instanceof Objeto){
                Objeto recibido = (Objeto) obj;
                if(getId_objeto()==recibido.getId_objeto()){
                    rta = true;
                }
            }
        }
        return rta;
    }

    @Override
    public String toString() {
        return "Objeto{" +
                "id_objeto=" + id_objeto +
                "ancho=" + ancho +
                ", alto=" + alto +
                  super.toString();
    }
}
