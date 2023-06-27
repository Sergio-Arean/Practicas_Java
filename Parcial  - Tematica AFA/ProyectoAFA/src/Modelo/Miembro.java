package Modelo;

public abstract class Miembro implements Comparable{
    private String nombre;
    private String apellido;
    private int edad;

    public Miembro(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Miembro(){
        this("","",0);
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    // COMPARE TO - TO STRING - EQUALS - HASHCODE


    @Override
    public int compareTo(Object o) {
        if(o instanceof Miembro){
            Miembro recibido = (Miembro) o;
            if(getEdad()>recibido.getEdad()){
                return 1;
            }
            else if(getEdad()< recibido.getEdad()){
                return -1;
            }
            else{
                return 0;
            }
        }else{
            throw new IllegalArgumentException("El objeto a comparar debe ser un miembro");
        }
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        boolean rta = false;
        if(obj instanceof  Miembro){
            Miembro recibido = (Miembro)obj;
            if(getNombre().equals(recibido.getNombre()) && getApellido().equals(recibido.getApellido()) && getEdad()==recibido.getEdad()){
                rta = true;
            }
        }
        return rta;
    }

    public String Viajar(){
        return "Soy un miembro de la AFA y estoy viajando...";
    }

    public String Concentrar(){
        return "Soy un miembro de la AFA y estoy concentrando...";
    }
}
