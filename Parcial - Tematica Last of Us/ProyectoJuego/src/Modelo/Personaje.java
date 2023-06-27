package Modelo;

import Interfaces.IAccionesBasicas;

public abstract class Personaje extends Entidad implements IAccionesBasicas {
    private String nombre;
    private String skin;
    private int nivel_de_vida;
    private String armas;

    public Personaje(double posicion_x, double posicion_y, String nombre, String skin, int nivel_de_vida, String armas) {
        super(posicion_x, posicion_y);
        this.nombre = nombre;
        this.skin = skin;
        this.nivel_de_vida = nivel_de_vida;
        this.armas = armas;
    }
    public Personaje(){

    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", skin='" + skin + '\'' +
                ", nivel_de_vida=" + nivel_de_vida +
                ", armas='" + armas + '\'' +
                "} " + super.toString();
    }

    @Override
    public String Atacar() {
        String rta = "Estoy atacando!!!";
        return rta;
    }

    @Override
    public String Defenderse() {
        String rta = "Estoy defendiendome!!!";
        return rta;
    }

    @Override
    public String Morir() {
        String rta = "Estoy muriendo!!!";
        return rta;
    }

    @Override
    public String CargarEnergia() {
        String rta = "Estoy cargando energia!!!";
        return rta;
    }

    @Override
    public boolean equals(Object obj) {
        boolean rta = false;
        if(obj!=null){
            if(obj instanceof Personaje){
                Personaje recibido = (Personaje) obj;
                if(getNombre().equals(recibido.getNombre())){
                    rta = true;
                }
            }
        }
        return rta;
    }
}
