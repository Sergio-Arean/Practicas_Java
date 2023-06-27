package Modelo;

import Interfaces.IJuegaPartido;
import Enums.*;

public class Futbolista extends Miembro implements IJuegaPartido {
    private int numero_camiseta;
    private Puesto puesto;

    public Futbolista(String nombre, String apellido, int edad, int numero_camiseta, Puesto puesto) {
        super(nombre, apellido, edad);
        this.numero_camiseta = numero_camiseta;
        this.puesto = puesto;
    }

    public Futbolista(){
        this("","",0,0,null);
    }

    public int getNumero_camiseta() {
        return numero_camiseta;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    @Override
    public String toString() {
        return "Futbolista{" +
                super.toString() +
                "numero_camiseta=" + numero_camiseta +
                ", puesto='" + puesto + '\'' +
                "} ";
    }

    @Override
    public boolean equals(Object obj) {
        boolean rta = false;
        if(obj instanceof Futbolista){
            Futbolista recibido = (Futbolista) obj;
            if(super.equals(obj) && getNumero_camiseta()==recibido.getNumero_camiseta() && getPuesto().equals(recibido.getPuesto())){
                rta = true;
            }
        }
        return rta;
    }

    @Override
    public String JugarPartido() {
        return "Soy un futbolista y estoy jugando un partido!";
    }
}
