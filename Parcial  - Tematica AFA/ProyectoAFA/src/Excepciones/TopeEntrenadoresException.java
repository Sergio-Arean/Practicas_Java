package Excepciones;

import java.time.LocalDate;

public class TopeEntrenadoresException extends Exception{
    private static int contador=0;
    private LocalDate fecha;

    public TopeEntrenadoresException(String message) {
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

    public LocalDate getFecha() {
        return fecha;
    }
}
