package Modelo;

import Excepciones.CaballeroNoAptoException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.Iterator;

public class SistemaOrdenDeCaballeros { //Clase envoltorio
   /* Al momento de agregar un Caballero nos debemos asegurar que tenga la vida cargada y por lo
    menos un punto de ataque. Si no es así, lanzar una excepción especificando el error*/
    HashSet<CaballeroDeBronce> caballeros;
    public SistemaOrdenDeCaballeros(){
        caballeros = new HashSet<CaballeroDeBronce>();
    }

    public String AgregarCaballero (CaballeroDeBronce c){ //metodo que invoca a quien agrega propiamente y atrapa la excepcion
        String rta = "El Caballero " + c.getNombre() + " que intenta ingresar ya se encuentra en el sistema.";
        try {
            boolean agregado = Agregar(c);
            if(agregado){
                rta = "El Caballero " + c.getNombre() + " fue agregado exitosamente!";
            }
        } catch (CaballeroNoAptoException e) {
            rta = e.getMessage();
        }

        return rta;
    }

    private boolean Agregar(CaballeroDeBronce c) throws CaballeroNoAptoException { //metodo que agrega propiamente y lanza excepcion
        boolean agregado = false;
        if(c.VidaCargada() && c.AptoAtaque()){
            if(caballeros.add(c)){
                agregado = true;
            }
        }
        else{
            throw new CaballeroNoAptoException(c.getNombre());
        }

            return agregado;
    }

    public String EliminarCaballero(CaballeroDeBronce c){
        String rta = "El Caballero " + c.getNombre() + " que intenta eliminar no se encuentra presente en el sistema.";
        if(caballeros.remove(c)){
            rta = "El Caballero " + c.getNombre() + " fue eliminado exitosamente!";
        }
        return rta;
    }

    public String ListarCaballleros(){
        String rta = "<<Caballeros de Bronce>>";
        Iterator it = caballeros.iterator();
        while(it.hasNext()){
            CaballeroDeBronce caballero = (CaballeroDeBronce) it.next();
            rta += "\n" + caballero.toString();
        }
        return rta;
    }

    public String toJson() throws JSONException {
        JSONArray jsonArray_caballeros = new JSONArray();
        Iterator it = caballeros.iterator();
        while(it.hasNext()){
            CaballeroDeBronce caballero = (CaballeroDeBronce) it.next();
            JSONObject jsonObject_caballero = new JSONObject();
            caballero.toJSON(jsonObject_caballero);
            jsonArray_caballeros.put(jsonObject_caballero);
        }
            return  jsonArray_caballeros.toString();
    }

}
