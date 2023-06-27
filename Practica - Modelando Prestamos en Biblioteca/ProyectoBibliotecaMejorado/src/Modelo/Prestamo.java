package Modelo;

public class Prestamo {
    private static int cantidad_creados; //para autogeneracion de id
    private int id_prestamo;
    private boolean activo;
    private String nombre_de_cliente;
    private String dni_de_cliente;
    private String titulo_de_libro;
    private double tarifa ; //resultado de metodos aplicados
    private int dias;

    public Prestamo(String nombre_de_cliente, String dni_de_cliente, String titulo_de_libro, double tarifa, int dias) {
        activo = true ; //al crearlo empeiza a estar activo
        this.nombre_de_cliente = nombre_de_cliente;
        this.dni_de_cliente = dni_de_cliente;
        this.titulo_de_libro = titulo_de_libro;
        this.tarifa = tarifa;
        this.dias = dias;
        cantidad_creados++;
        id_prestamo = cantidad_creados;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id_prestamo=" + id_prestamo +
                ", activo=" + Activo() +
                ", nombre_de_cliente='" + nombre_de_cliente + '\'' +
                ", dni_de_cliente='" + dni_de_cliente + '\'' +
                ", titulo_de_libro='" + titulo_de_libro + '\'' +
                ", tarifa=" + tarifa +
                ", dias=" + dias +
                '}';
    }

    private String Activo(){
        String rta = " Si ";
        if(!activo){
            rta = " No ";
        }
        return rta;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getDni_de_cliente() {
        return dni_de_cliente;
    }

    public String getTitulo_de_libro() {
        return titulo_de_libro;
    }
}
