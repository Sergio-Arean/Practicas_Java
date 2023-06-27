import Modelo.*;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
       //Prueba
        SistemaEnvios miSistema = new SistemaEnvios("Sistema 2023");

        //creacion de 2 paquetes por tierra, 2 deben poder agregarse y el 3er intento debe ser impedido por el sistema.
        PaqueteTierra paquete1 = new PaqueteTierra(100,"Buenos Aires",true,true,400,"camion");
        PaqueteTierra paquete2 = new PaqueteTierra(50,"Miramar",false,false,30,"bicimoto");
;

        System.out.println(miSistema.AgregarPaquete(paquete1));
        System.out.println(miSistema.AgregarPaquete(paquete2));
        System.out.println(miSistema.AgregarPaquete(paquete2)); //!



        //creacion de 2 paquetes por aire, 2 deben poder agregarse y el 3er intento debe ser impedido por el sistema.
        PaqueteAire paquete3 = new PaqueteAire(100,"Cordoba",true,true,"AA","express");
        PaqueteAire paquete4 = new PaqueteAire(50,"San Luis", false,false,"AeroSol","normal");


        System.out.println(miSistema.AgregarPaquete(paquete3));
        System.out.println(miSistema.AgregarPaquete(paquete4));
        System.out.println(miSistema.AgregarPaquete(paquete4)); //!

        //calculo de tarifas de estos paquetes
        System.out.println(miSistema.CalcularPrecioPaquete(paquete1));
        System.out.println(miSistema.CalcularPrecioPaquete(paquete2));
        System.out.println(miSistema.CalcularPrecioPaquete(paquete3));
        System.out.println(miSistema.CalcularPrecioPaquete(paquete4));

        System.out.println(miSistema.VerPaquetes());



        //suponiendo que el usuario acepta los valores, se envian los respectivos paquetes
        System.out.println(miSistema.EnviarPaquete(1));
        System.out.println(miSistema.EnviarPaquete(2));
        System.out.println(miSistema.EnviarPaquete(3));
        System.out.println(miSistema.EnviarPaquete(4));

        System.out.println(miSistema.VerPaquetes());

        //Lo siguiente deberia ser erroneo o informar que fueron enviados
        System.out.println(miSistema.EnviarPaquete(1));
        System.out.println(miSistema.EnviarPaquete(2));
        System.out.println(miSistema.EnviarPaquete(3));
        System.out.println(miSistema.EnviarPaquete(4));

        //hasta aca 1 hora 45 min + 18.30 min

    }
}