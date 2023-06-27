package Genericos;

import java.util.HashSet;
import java.util.Iterator;

public class Generic <T>{
    /*Está de más decir que debemos almacenar, contener todos los miembros de la selección bajo nuestra federación.
     No podemos tener más de 23 futbolistas, el 24vo que desea ingresar no podrá y podremos gestionarlo con una excepción.
      Al igual que cuando quisiéramos ingresar un segundo entrenador principal.
Nuestro sistema debería exportar todos los datos a un objeto JSON que contenga los datos de la federación
(nombre, fecha de fundación, cantidad de copas mundiales) y la lista de miembros. Si modulariza bien, es sencillo.

Para implementar el listado o mapa según prefiera no podrá hacerlo directamente sino con una pila,
mapa o colección genérica como atributo y métodos para agregar, quitar y listar que si bien serán invocados
desde la federación estarán dentro de la colección genérica.
*/
    //Lo implemento a traves de un HashSet
    private HashSet <T> listado;

    public Generic() {
        listado = new HashSet<T>();
    }

    public boolean AgregarElemento(T elemento){
        return listado.add(elemento);
    }

    public boolean QuitarElemento(T elemento){
        return listado.remove(elemento);
    }

    public int ContarElementos(){
        return listado.size();
    }

    public String ListarElementos(){
        Iterator it = listado.iterator();
        String rta = "";

        while(it.hasNext()){
            T elemento = (T)it.next();
            rta += elemento.toString() + "\n";
        }
        return rta;
    }

    public boolean SeEncuentra(T elemento){
        boolean rta = false;
        if(listado.contains(elemento)){
            rta = true;
        }
        return rta;
    }

    public Iterator DevuelveRecorredor(){
        return listado.iterator();
    }

}

