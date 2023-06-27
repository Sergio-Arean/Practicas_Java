package Excepciones;

public class LimiteDeInstanciasException extends Exception{
    public LimiteDeInstanciasException(String materia) {
        super("La materia " + materia + " alcanzo el limite de instancias. No es posible agregar otra nota");
    }
}
