package Excepciones;

import java.util.ArrayList;

public class NotaYaAgregadaException extends Exception{
    private static ArrayList<String> descripcion_instancias_repetidas = new ArrayList<String>();
    public NotaYaAgregadaException(String descripcion_nota) {
        super("La instancia de evaluacion que desea agregar ya se encuentra presente en el sistema");
        AgregarDescripcionInstanciaRepetida(descripcion_nota);
    }

    private void AgregarDescripcionInstanciaRepetida(String descripcion_nota){ //metodo que permite almacenar los datos de las excepciones arrojadas
        descripcion_instancias_repetidas.add(descripcion_nota);
    }

    public static String VerInstanciasRepetidas(){ //metodo que brinda informacion de las instancias que se intentaron agregar y fueron repetidas, originando la presente excepcion
        String rta = "Las instancias que quisieron agregarse, estando ya presentes, son las siguientes:\n";
        for(String descripcion:descripcion_instancias_repetidas){
            rta += "\n" + descripcion.toString();
        }
        return rta;
    }
}
