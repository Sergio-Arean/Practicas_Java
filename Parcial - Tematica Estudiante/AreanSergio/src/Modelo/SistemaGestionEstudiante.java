package Modelo;
import Excepciones.LimiteDeInstanciasException;
import Excepciones.MateriaYaExisteException;
import Excepciones.NotaYaAgregadaException;
import Generico.*;
import JsonUtiles.JsonUtiles;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class SistemaGestionEstudiante {
    private String nombre;
    private String apellido;
    private String fecha_de_nacimiento;
    private String legajo;
    private String mail_de_contacto;

    private Generic <Materia> materias;

    public SistemaGestionEstudiante(String nombre, String apellido, String fecha_de_nacimiento, String legajo, String mail_de_contacto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        this.legajo = legajo;
        this.mail_de_contacto = mail_de_contacto;
        materias = new Generic<>();
    }

    public String AgregarMateria(Materia m){ //metodo que atrapa la excepcion
        String rta = "";
        try {
            boolean agregado = Agregar(m);
            if(agregado){
                rta = "La materia " + m.getNombre_completo() + " fue agregada exitosamente!";
            }
        } catch (MateriaYaExisteException e) {
            rta = e.getMessage();
        }
            return rta;
    }

    private boolean Agregar(Materia m) throws MateriaYaExisteException { //metodo que agrega propiamente y arroja excepcion
        boolean agregado = materias.Agregar(m);
        if(agregado){
            return true;
        }
        else{
            throw new MateriaYaExisteException(m.getCodigo_materia());
        }
    }

    public String ListarMaterias(){
        return materias.Listar();
    }

    public String AgregarNota(Materia m,Nota n){
        String rta = "La nota " + n.toString() + " fue agregada exitosamente a la materia " + m.getNombre_completo();
        Materia encontrada = materias.GetElemento(m);
        if(encontrada!=null){
            try {
                encontrada.AgregarNota(n);
            } catch (NotaYaAgregadaException e) {
                rta = e.getMessage();
            }catch (LimiteDeInstanciasException e){
                rta = e.getMessage();
            }
        }
        return rta;
    }


    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFecha_de_nacimiento() {
        return fecha_de_nacimiento;
    }

    public String getLegajo() {
        return legajo;
    }

    public String getMail_de_contacto() {
        return mail_de_contacto;
    }

    public String toJson(){
        /*Vamos a guardar en un archivo .json toda la información del estudiante, sus materias y notas.*/
        String rta = "El archivo JSON fue generado exitosamente";
        JSONObject jsonObject_principal = new JSONObject();

        try{
            jsonObject_principal.put("nombre",getNombre());
            jsonObject_principal.put("apellido",getApellido());
            jsonObject_principal.put("fecha_de_nacimiento",getFecha_de_nacimiento());
            jsonObject_principal.put("legajo",getLegajo());
            jsonObject_principal.put("mail_de_contacto",getMail_de_contacto());

            JSONArray jsonArray_materias = new JSONArray();
            Iterator it = materias.GetRecorredor();
            while(it.hasNext()){
                Materia materia = (Materia) it.next();
                JSONObject jsonObject_materia = new JSONObject();
                materia.toJSON(jsonObject_materia);
                jsonArray_materias.put(jsonObject_materia);
            }
            jsonObject_principal.put("materias",jsonArray_materias);
            JsonUtiles.grabar(jsonObject_principal,"Sistema de Un Estudiante");

        }catch(JSONException e){
            rta = e.getMessage();
        }
            return rta;
    }
}
