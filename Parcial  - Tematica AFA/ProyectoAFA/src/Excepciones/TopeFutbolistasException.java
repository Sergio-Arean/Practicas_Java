package Excepciones;

import java.time.LocalDate;

public class TopeFutbolistasException extends Exception{
    private static int contador=0;
    private LocalDate fecha;

    public TopeFutbolistasException(String message) {
        super(message);
        EstableceFechayHora();
        contador++;
    }

    private void EstableceFechayHora(){
        fecha = LocalDate.now();
    }

    public static int getContador() {
        return contador;
    }

    public String getFecha() {
        return fecha.toString();
    }
}
