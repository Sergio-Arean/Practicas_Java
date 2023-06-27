package Excepciones;

public class CaballeroNoAptoException extends Exception{
    public CaballeroNoAptoException(String nombre) {
        super("El caballero " + nombre + " debe tener vida cargada y al menos un punto de ataque para poder ser aceptado.");
    }
}
