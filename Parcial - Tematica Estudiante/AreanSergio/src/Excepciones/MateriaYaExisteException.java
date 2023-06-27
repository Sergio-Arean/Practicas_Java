package Excepciones;

import java.util.ArrayList;

public class MateriaYaExisteException extends Exception{
    private static ArrayList<String> codigos_materias_repetidas = new ArrayList<>();
    public MateriaYaExisteException(String codigo_materia_repetida) {
        super("La materia con el codigo " + codigo_materia_repetida + " ya se encuentra presente en el sistema");
        AgregarCodigoALista(codigo_materia_repetida);
    }

    public void AgregarCodigoALista(String codigo_repetido){//este metodo guarda en una lista propia de la clase, aquellos codigos que intentaron agregarse y no pudieron hacerlo, dando origen a la presente excepcion
        codigos_materias_repetidas.add(codigo_repetido);
    }
    public static String ListarCodigosRepetidos(){ //metodo que muestra aquellos codigos que dieron origen a la aparicion de la excepcion...
        String rta = "Los codigos que intentaron agregarse han sido los siguientes: \n";
        for(String codigo:codigos_materias_repetidas){
            rta += "\n" + codigo.toString();
        }
        return rta;
    }
}
