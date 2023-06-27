package Modelo;

public abstract class Cliente {
    private String nombre;
    private String dni;
    private String domicilio;
    private String telefono;
    private boolean debe_libro;

    public Cliente(String nombre, String dni, String domicilio, String telefono) {
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.telefono = telefono;
        debe_libro = false; //al crear un cliente se supone q no debe un libro
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public boolean isDebe_libro() {
        return debe_libro;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", telefono='" + telefono + '\'' +
                ", debe_libro=" + DebeLibro() +
                '}';
    }
    private String DebeLibro(){
        String rta = " Si ";
        if(!debe_libro){
            rta = " No ";
        }
        return rta;
    }

    public void setDebe_libro(boolean debe_libro) {
        this.debe_libro = debe_libro;
    }

    abstract double DefinirPorcentajeDeDescuento();

    @Override
    public boolean equals(Object obj) {
        boolean rta = false;
        if(obj!=null){
            if(obj instanceof Cliente){
                Cliente recibido = (Cliente) obj;
                if(getDni().equals(((Cliente) obj).getDni())){
                    rta = true;
                }
            }
        }
        return rta;
    }
}
