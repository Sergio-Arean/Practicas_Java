import Modelo.*;
public class Main {
    public static void main(String[] args) {
        //Prueba
        //creacion de sistema
        SistemaJuego2D juegazo2023 = new SistemaJuego2D("Juego 2023");

        //creacion de 2 personajes jugables (joel y ellie)
        Joel player1 = new Joel(1,1,"Sergio","Que se yo",100,"Todas",5,5);
        Ellie player2 = new Ellie (2,2,"Andrea","Morocha",100,"La palabra",10,10);


        //creacion de los 4 zombies
        Runner zombie1 = new Runner(1,1,"Zombie Runner","Ni idea",5,"Sus manos",5);
        Stalker zombie2 = new Stalker(2,2,"Stalcker","Jefe",10,"Su toxicidad",10);
        Clicker zombie3 = new Clicker(3,3,"Juan El Cliqueador","Cara de mouse",15,"Su cara de raton",15);
        Bloater zombie4 = new Bloater(4,4,"Valor","Hinchado",20,"Su hinchazon",20);



        //creacion de 1 muro y una plataforma
        Muro muro1 = new Muro(1,1,100,100,100);
        Plataforma plataforma1 = new Plataforma(2,2,200,200,"Durlock","Tecnico");

        //agregar todos los objetos (1 personaje y 1 objeto no deberia dejar a partir de repetirse)
        System.out.println(juegazo2023.AgregarPersonaje(player1));
        System.out.println(juegazo2023.AgregarPersonaje(player2));
        System.out.println(juegazo2023.AgregarPersonaje(zombie1));
        System.out.println(juegazo2023.AgregarPersonaje(zombie2));
        System.out.println(juegazo2023.AgregarPersonaje(zombie3));
        System.out.println(juegazo2023.AgregarPersonaje(zombie4));
        System.out.println(juegazo2023.AgregarPersonaje(zombie4)); //!

        System.out.println(juegazo2023.AgregarObjeto(muro1));
        System.out.println(juegazo2023.AgregarObjeto(plataforma1));
        System.out.println(juegazo2023.AgregarObjeto(plataforma1));//!



        //mostrar info (mostrar personajes y objetos)
        System.out.println(juegazo2023.VerPersonajes());
        System.out.println(juegazo2023.VerObjetos());

        System.out.println(player1.Atacar());



    }
}