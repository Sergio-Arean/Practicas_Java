package Generico;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.Iterator;

public class Generic <T>{ //
    /**Clase generica implementada a traves de un Hashet**/
    /* Ambas colecciones (las materias y las notas) tendrán los mismos métodos (agregar, contar, listar y eliminar)*/
    private HashSet<T> hs;

    public Generic() {
        hs = new HashSet<T>();
    }

    public boolean Agregar(T elemento){
        return hs.add(elemento);
    }

    public int Contar(){
        return hs.size();
    }
    public boolean Eliminar(T elemento){
        return hs.remove(elemento);
    }

    public T GetElemento(T elemento){
        Iterator it = hs.iterator();
        T encontrado = null;
        while(it.hasNext()){
            T elem = (T)it.next();
            if(elem.equals(elemento)){
                encontrado = elem;
            }
        }
        return encontrado;
    }

    public Iterator GetRecorredor(){
        return hs.iterator();
    }

    public String Listar(){
        String rta = "";
        Iterator it = hs.iterator();
        while(it.hasNext()){
            T elemento = (T)it.next();
            rta += "\n" + elemento.toString();
        }
        return rta;
    }


}
