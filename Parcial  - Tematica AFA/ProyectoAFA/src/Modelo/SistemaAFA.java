package Modelo;
import Excepciones.TopeEntrenadoresException;
import Excepciones.TopeFutbolistasException;
import Genericos.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class SistemaAFA { //AGREGAR / QUITAR / LISTAR
    private Generic <Miembro> miembros;
    private int capacidad_futbolistas = 23;
    private int cantidad_futbolistas;

    private int capacidad_entrenador = 1;
    private int cantidad_entrenadores;

    //(nombre, fecha de fundación, cantidad de copas mundiales)

    private String nombre = "Asociacion de Futbol Argentino";

    private String fecha_de_fundacion = "Cuando nacio Julio Grondona";

    private int cantidad_copas_mundiales = 3;

        public SistemaAFA(){
            miembros = new Generic<Miembro>();
            cantidad_futbolistas=0;
            cantidad_entrenadores=0;
        }

        private boolean Agregar(Miembro m) throws TopeFutbolistasException,TopeEntrenadoresException{ //Funcion que agrega propiamente
            boolean agregado = false;
            //estoy usando un hashset
            if(m instanceof Futbolista){
                if (cantidad_futbolistas<capacidad_futbolistas){
                    agregado = miembros.AgregarElemento(m);
                    if(agregado){
                        cantidad_futbolistas++;
                    }
                }
                else{
                    throw new TopeFutbolistasException("El tope de jugadores esta completo. No es posible agregar a futbolista");
                }
            }
            else if(m instanceof Entrenador){
                if(cantidad_entrenadores<capacidad_entrenador){
                    agregado = miembros.AgregarElemento(m);
                    if(agregado){
                        cantidad_entrenadores++;
                    }
                }
                else{
                    throw new TopeEntrenadoresException("\"El tope de entrenadores esta completo. No es posible agregar a entrenador\"");
                }
            }
            else{
                agregado = miembros.AgregarElemento(m);
            }

                return agregado;
        }

        public String AgregarMiembro(Miembro m){ //funcion q llama a la que agrega propiamente, atrapanado excepcion
            String rta = "";
            boolean agregado = false;
            try{
                agregado = Agregar(m);
                if(agregado){
                    rta = "Se ha agregado el miembro exitosamente!";
                }
                else{
                    rta = "El miembro no pudo ser agregado";
                }
            }catch(TopeFutbolistasException e){
                rta = e.getMessage() + " - Fecha: " + e.getFecha() + " - Este error se produjo " + e.getContador() + " veces. ";
            }catch(TopeEntrenadoresException e){
                rta = e.getMessage() + " - Fecha: " + e.getFecha() + " - Este error se produjo " + e.getContador() + " veces. ";
            }
            return rta;
        }

        public String EliminarMiembro(Miembro m){
            String rta = "";
            if(miembros.QuitarElemento(m)){ //no verifico si se encuentra ya que el remove del generico solo devuelve true si el elemento se encuentra
                rta = "La persona fue eliminada exitosamente!";
            }
            else{
                rta = "La persona que desea eliminar no se encuentra en el sistema";
            }
                return rta;
        }

        public String ListarMiembros(){
            return miembros.ListarElementos();
        }

    public String getNombre() {
        return nombre;
    }

    public String getFecha_de_fundacion() {
        return fecha_de_fundacion;
    }

    public int getCantidad_copas_mundiales() {
        return cantidad_copas_mundiales;
    }


        /*Nuestro sistema debería exportar todos los datos a un objeto JSON que contenga
        los datos de la federación (nombre, fecha de fundación, cantidad de copas mundiales) y la lista de miembros.
        Si modulariza bien, es sencillo. */

        ///1 Objeto json que incluya : 1 string con el nombre, 1 string con fecha de fundacion
        // 1 int con cantidad d ecopas mundiales y un arreglo de la lista de miembros

        public String getJSON_AFA(){
            String rta = "";
            JSONObject objetoPrincipal = new JSONObject();
            JSONArray arrayMiembros = new JSONArray();

            try {
                objetoPrincipal.put("nombre",getNombre());
                objetoPrincipal.put("fecha de fundacion", getFecha_de_fundacion());
                objetoPrincipal.put("cantidad copas mundiales", getCantidad_copas_mundiales());

                miembrosToArray(arrayMiembros);
                objetoPrincipal.put("miembros",arrayMiembros);
                rta = objetoPrincipal.toString();

            } catch (JSONException e) {
                rta = "Error";
            }
            return rta;
        }

        private void miembrosToArray (JSONArray jsonArray) throws JSONException {
            Iterator it = miembros.DevuelveRecorredor();
            while(it.hasNext()){
                Miembro m = (Miembro)it.next();
                JSONObject jsonObjectMiembro = new JSONObject();
                jsonObjectMiembro.put("nombre",m.getNombre());
                jsonObjectMiembro.put("apellido",m.getApellido());
                jsonObjectMiembro.put("edad",m.getEdad());

                jsonArray.put(jsonObjectMiembro);
            }
        }
}
