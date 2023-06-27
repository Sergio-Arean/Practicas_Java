package Modelo;

import java.util.ArrayList;

public class SistemaJuego2D { //Clase envoltorio
    private String nombre;

    private ArrayList <Personaje> listaDePersonajes;
    private ArrayList <Objeto> listaDeObjetos;

    public SistemaJuego2D(String nombre) {
        this.nombre = nombre;
        listaDePersonajes = new ArrayList<Personaje>();
        listaDeObjetos = new ArrayList<Objeto>();
    }
    /**--------------------------------------
     *LISTAR PERSONAJES
     * -------------------------------------*/
    public String VerPersonajes(){
        String rta = "--PERSONAJES--\n";
        int cantidad = 1;
        for(Personaje p : listaDePersonajes){
            rta += cantidad + p.toString() + "\n";
            cantidad++;
        }
        return rta;
    }

    /**--------------------------------------
     *AGREGAR PERSONAJE
     * -------------------------------------*/
    public String AgregarPersonaje(Personaje p){
        String rta = "El personaje no pudo ser agregado";
        boolean existe_personaje = ExistePersonaje(p);
        boolean agregado = false;
            if(!existe_personaje){
                agregado = listaDePersonajes.add(p);
            }
            if(agregado){
                rta = "El personaje " + p.getNombre() + " ha sido agregado exitosamente";
            }
            return rta;
    }
    private boolean ExistePersonaje(Personaje p){
        boolean encontrado = false;
        for(int i=0; i<listaDePersonajes.size();i++){
            if(listaDePersonajes.get(i).equals(p)){
                encontrado = true;
            }
        }
        return encontrado;
    }



    /**--------------------------------------
     *LISTAR OBJETO
     * -------------------------------------*/
    public String VerObjetos(){
        String rta = "--OBJETOS--\n";
        int cantidad = 1;
        for(Objeto o : listaDeObjetos){
            rta += cantidad + o.toString() + "\n";
            cantidad++;
        }
        return rta;
    }


    /**--------------------------------------
     *AGREGAR OBJETO
     * -------------------------------------*/
    public String AgregarObjeto(Objeto o){
        String rta = "El objeto no pudo ser agregado";
        boolean existe_objeto = ExisteObjeto(o);
        boolean agregado = false;
        if(!existe_objeto){
            agregado = listaDeObjetos.add(o);
        }
        if(agregado){
            rta = "El objeto pudo ser agregado exitosamente";
        }
        return rta;
    }

    private boolean ExisteObjeto(Objeto o){
        boolean encontrado = false;
        for(int i=0; i<listaDeObjetos.size();i++){
            if(listaDeObjetos.get(i).equals(o)){
                encontrado = true;
            }
        }
        return encontrado;
    }


    /**--------------------------------------
     *
     * -------------------------------------*/



    /**--------------------------------------
     *
     * -------------------------------------*/


}
