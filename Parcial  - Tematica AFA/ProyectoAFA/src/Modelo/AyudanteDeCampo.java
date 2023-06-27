package Modelo;

import Interfaces.IJuegaPartido;
import Interfaces.IPreparacionEntrenamiento;

public class AyudanteDeCampo extends Miembro implements IJuegaPartido, IPreparacionEntrenamiento {
    private String metodologia;

    public AyudanteDeCampo(String nombre, String apellido, int edad, String metodologia) {
        super(nombre, apellido, edad);
        this.metodologia = metodologia;
    }

    public AyudanteDeCampo(){
        this("","",0,"");
    }

    public String getMetodologia() {
        return metodologia;
    }

    @Override
    public String JugarPartido() {
        return "Soy un ayudante  de campo y estoy jugando partido...";
    }

    @Override
    public String PrepararEntrenamiento() {
        return "Soy un ayudante de campo y estoy preparando el entrenamiento...";
    }


    @Override
    public String toString() {
        return "AyudanteDeCampo{" +  super.toString() +
                "metodologia='" + metodologia + '\'' +
                "} " ;
    }

    @Override
    public boolean equals(Object obj) {
        boolean rta = false;
        if(obj instanceof AyudanteDeCampo){
            AyudanteDeCampo recibido = (AyudanteDeCampo) obj;
            if(super.equals(obj) && getMetodologia().equals(recibido.getMetodologia())){
                rta = true;
            }
        }
        return rta;
    }
}
