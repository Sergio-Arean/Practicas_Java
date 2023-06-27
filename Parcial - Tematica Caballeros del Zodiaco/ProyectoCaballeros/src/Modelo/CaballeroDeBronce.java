package Modelo;

import Enums.Constelacion;
import Enums.TipoSangre;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class CaballeroDeBronce implements Comparable{
    /*● Nombre: Seiya
● Constelación: Pegaso
● Edad: 13
● Altura: 165cm
● Peso: 53kg
● Nacimiento: 1 de Diciembre
● Tipo de Sangre: B
● Lugar de origen: Japón
● Lugar de entrenamiento: Santuario (Grecia)*/
    private String nombre;
    private Constelacion constelacion;
    private int edad;
    private double altura;
    private double peso;
    private String nacimiento;
    private TipoSangre tipo_de_sangre;
    private String lugar_de_origen;
    private String lugar_de_entrenamiento;

    private int cantidad_de_vida;
    private int poder_de_ataque; //poder-punto

    public CaballeroDeBronce(String nombre, Constelacion constelacion, int edad, double altura, double peso, String nacimiento, TipoSangre tipo_de_sangre, String lugar_de_origen, String lugar_de_entrenamiento, int cantidad_de_vida, int poder_de_ataque) {
        this.nombre = nombre;
        this.constelacion = constelacion;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.nacimiento = nacimiento;
        this.tipo_de_sangre = tipo_de_sangre;
        this.lugar_de_origen = lugar_de_origen;
        this.lugar_de_entrenamiento = lugar_de_entrenamiento;
        this.cantidad_de_vida = cantidad_de_vida;
        this.poder_de_ataque = poder_de_ataque;
    }
    public CaballeroDeBronce(){
        this("",null,0,0,0,"",null,"","",0,0);
    }

    public String getNombre() {
        return nombre;
    }

    public Constelacion getConstelacion() {
        return constelacion;
    }

    public int getEdad() {
        return edad;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public TipoSangre getTipo_de_sangre() {
        return tipo_de_sangre;
    }

    public String getLugar_de_origen() {
        return lugar_de_origen;
    }

    public String getLugar_de_entrenamiento() {
        return lugar_de_entrenamiento;
    }

    public int getCantidad_de_vida() {
        return cantidad_de_vida;
    }

    public int getPoder_de_ataque() {
        return poder_de_ataque;
    }

    public void setCantidad_de_vida(int cantidad_de_vida) {
        this.cantidad_de_vida = cantidad_de_vida;
    }

    public void setPoder_de_ataque(int poder_de_ataque) {
        this.poder_de_ataque = poder_de_ataque;
    }

    public String Atacar(){
        return "Soy un caballero de bronce y estoy atacando!";
    }

    public String Defenderse(){
        return "Soy un caballero de bronce y estoy defiendiendome";
    }

    public boolean VidaCargada(){
        boolean rta = false;
        if(cantidad_de_vida>0){
            rta = true;
        }
        return rta;
    }

    public boolean AptoAtaque(){
        boolean rta = false;
        if(poder_de_ataque>=1){
            rta = true;
        }
        return rta;
    }

    //equals - haschcode - compareTO - to string
    @Override
    public int compareTo(Object obj) { //criterio elegido : la edad
        if(obj instanceof CaballeroDeBronce){
            CaballeroDeBronce recibido = (CaballeroDeBronce) obj;
            if(getEdad()==recibido.getEdad()){
                return 0;
            }
            else if(getEdad()> recibido.getEdad()){
                return 1;
            }
            else{
                return -1;
            }
        }
        else{
            throw new IllegalArgumentException("Debe comparar con un Caballero de Bronce");
        }
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) { //criterio elegido : nombre y constelacion
        boolean rta = false;
        if(obj instanceof CaballeroDeBronce){
            CaballeroDeBronce recibido = (CaballeroDeBronce) obj;
            if(getNombre().equals(recibido.getNombre()) && getConstelacion()==recibido.getConstelacion()){
                rta = true;
            }
        }
        return rta;
    }


    @Override
    public String toString() {
        return "CABALLERO DE BRONCE >>" +
                "nombre='" + nombre + '\'' +
                ", constelacion=" + constelacion +
                ", edad=" + edad +
                ", altura=" + altura +
                ", peso=" + peso +
                ", nacimiento='" + nacimiento + '\'' +
                ", tipo_de_sangre=" + tipo_de_sangre +
                ", lugar_de_origen='" + lugar_de_origen + '\'' +
                ", lugar_de_entrenamiento='" + lugar_de_entrenamiento + '\'' +
                ", cantidad_de_vida=" + cantidad_de_vida +
                ", poder_de_ataque=" + poder_de_ataque + "\n";
    }

    public void toJSON(JSONObject jsonObject) throws JSONException {
        jsonObject.put("nombre",getNombre());
        jsonObject.put("constelacion",getConstelacion());
        jsonObject.put("edad",getEdad());
        jsonObject.put("altura",getAltura());
        jsonObject.put("peso",getPeso());
        jsonObject.put("nacimiento",getNacimiento());
        jsonObject.put("tipo de sangre", getTipo_de_sangre());
        jsonObject.put("lugar de origen",getLugar_de_origen());
        jsonObject.put("lugar de entrenamiento",getLugar_de_entrenamiento());
        jsonObject.put("cantidad de vida",getCantidad_de_vida());
        jsonObject.put("poder de ataque",getPoder_de_ataque());
    }

}
