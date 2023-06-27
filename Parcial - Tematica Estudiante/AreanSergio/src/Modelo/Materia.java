package Modelo;

import Excepciones.*;
import Generico.Generic;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Materia implements Comparable {
    private String codigo_materia; //dato unico
    private String nombre_completo;
    private String docente_titular;
    private String ayudante;
    private String dias_de_cursada;

    private Generic<Nota> notas;

    private int limite_instancias;

    public Materia(String codigo_materia, String nombre_completo, String docente_titular, String ayudante, String dias_de_cursada, int limite_instancias) {
        this.codigo_materia = codigo_materia;
        this.nombre_completo = nombre_completo;
        this.docente_titular = docente_titular;
        this.ayudante = ayudante;
        this.dias_de_cursada = dias_de_cursada;
        this.limite_instancias = limite_instancias;
        notas = new Generic<>();
    }

    public String getCodigo_materia() {
        return codigo_materia;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public String getDocente_titular() {
        return docente_titular;
    }

    public String getAyudante() {
        return ayudante;
    }

    public String getDias_de_cursada() {
        return dias_de_cursada;
    }



    public int getLimite_instancias() {
        return limite_instancias;
    }

    public boolean AgregarNota(Nota n) throws NotaYaAgregadaException, LimiteDeInstanciasException {
        if(getLimite_instancias()==notas.Contar()){
            throw new LimiteDeInstanciasException(getNombre_completo());
        }
        if(!notas.Agregar(n)) {
            throw new NotaYaAgregadaException(n.toString());
        }
        return true;
    }

    public void toJSON(JSONObject jsonObject) throws JSONException {
        jsonObject.put("nombre_completo",getNombre_completo());
        jsonObject.put("docente_titular",getDocente_titular());
        jsonObject.put("ayudante",getAyudante());
        jsonObject.put("dias_de_cursada",getDias_de_cursada());
        jsonObject.put("limite_instancias",getLimite_instancias());

        //las notas son una lista generica
        JSONArray jsonArray_notas = new JSONArray();
        Iterator it = notas.GetRecorredor();
        while(it.hasNext()){
            Nota nota =(Nota) it.next();
            JSONObject jsonObject_nota = new JSONObject();
            nota.toJSON(jsonObject_nota);
            jsonArray_notas.put(jsonObject_nota);
        }

        //agrego el arreglo al objeto materia
        jsonObject.put("notas",jsonArray_notas);

    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public int compareTo(Object obj) {
        if(obj instanceof Materia){
            Materia recibida = (Materia)obj;
            return getNombre_completo().compareTo(recibida.nombre_completo);
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object obj) {
        boolean rta = false;
        if(obj instanceof Materia){
            Materia recibida = (Materia)obj;
            if(getCodigo_materia().equals(recibida.codigo_materia)){
                rta = true;
            }
        }
        return rta;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "codigo_materia='" + codigo_materia + '\'' +
                ", nombre_completo='" + nombre_completo + '\'' +
                ", docente_titular='" + docente_titular + '\'' +
                ", ayudante='" + ayudante + '\'' +
                ", dias_de_cursada='" + dias_de_cursada + '\'' +
                ", notas=" + notas.Listar() +
                ", limite_instancias=" + limite_instancias +
                '}'+ "\n";
    }


}
