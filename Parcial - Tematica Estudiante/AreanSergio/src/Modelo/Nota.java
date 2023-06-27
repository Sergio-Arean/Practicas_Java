package Modelo;
import Enum.*;
import org.json.JSONException;
import org.json.JSONObject;

public class Nota implements Comparable{
    private double numero;
    Instancia instancia;

    String fecha;

    public Nota(double numero, Instancia instancia, String fecha) {
        this.numero = numero;
        this.instancia = instancia;
        this.fecha = fecha;
    }

    public Nota(){
        this(0,null,"");
    }

    public double getNumero() {
        return numero;
    }

    public Instancia getInstancia() {
        return instancia;
    }

    public String getFecha() {
        return fecha;
    }



    public void toJSON(JSONObject jsonObject) throws JSONException {
        jsonObject.put("numero",getNumero());
        jsonObject.put("instancia",getInstancia());
        jsonObject.put("fecha",getFecha());
    }

    @Override
    public int compareTo(Object obj) {
        if(obj instanceof Nota){
            Nota recibida = (Nota)obj;
            if(getNumero()==recibida.getNumero()){
                return 0;
            }
            else if(getNumero()> recibida.getNumero()){
                return 1;
            }
            else{
                return -1;
            }
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        boolean rta = false;
        if(obj instanceof Nota){
            Nota recibida = (Nota)obj;
            if(getNumero()==recibida.getNumero() && getInstancia()==recibida.getInstancia() && getFecha().equals(recibida.getFecha())){
                rta = true;
            }
        }
        return rta;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "numero=" + numero +
                ", instancia=" + instancia +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
