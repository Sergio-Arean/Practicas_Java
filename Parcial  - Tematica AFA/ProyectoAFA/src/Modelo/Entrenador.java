package Modelo;

import Interfaces.IJuegaPartido;
import Interfaces.IPreparacionEntrenamiento;

public class Entrenador extends Miembro implements IJuegaPartido, IPreparacionEntrenamiento {
    private String sistema_de_juego;
    private String estilo;

    public Entrenador(String nombre, String apellido, int edad, String sistema_de_juego, String estilo) {
        super(nombre, apellido, edad);
        this.sistema_de_juego = sistema_de_juego;
        this.estilo = estilo;
    }
    public Entrenador(){
     this("","",0,"","");
    }

    public String getSistema_de_juego() {
        return sistema_de_juego;
    }

    public String getEstilo() {
        return estilo;
    }

    @Override
    public String JugarPartido() {
        return "Soy un entrenador y estoy jugando el partido!";
    }

    @Override
    public String PrepararEntrenamiento() {
        return "Soy el entrenador "+ getNombre() + " " + getApellido() + " y estoy preparando el entrenamiento...";
    }

    @Override
    public String toString() {
        return "Entrenador{" + super.toString() +
                "sistema_de_juego='" + sistema_de_juego + '\'' +
                ", estilo='" + estilo + '\'' +
                "} ";
    }

    @Override
    public boolean equals(Object obj) {
        boolean rta = false;
        if(obj instanceof Entrenador){
            Entrenador recibido = (Entrenador) obj;
            if(super.equals(obj) && getSistema_de_juego().equals(recibido.sistema_de_juego.equals(recibido.sistema_de_juego))&& getEstilo().equals(recibido.getEstilo())){
                rta = true;
            }
        }
        return rta;
    }
}
