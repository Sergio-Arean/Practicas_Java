import Modelo.*;
public class Main {
    public static void main(String[] args) {
        //Prueba
        //crear sistema
        SistemaBiblioteca miSistema = new SistemaBiblioteca("Palito Ortega");

        //crear 4 libros y 4 clientes (solo vamos a tener 3)
        // agregarlos (que 1 de cada 1 no se pueda por repetido para probar esa funcion)
        Comic libro1 = new Comic("El hombre que arania","Denzel Washington",1999,2,1,true,1,true,"Spiderman");
        Novela libro2 = new Novela("El retrato de Dorian Gray","Oscar Wilde",1890,2,1,true,1,true,"Paidos");
        Revista libro3 = new Revista("El Grafico", "Un tipo futbolero",2001,40,0,true,0,true,false);
        Revista libro4 = new Revista("El Grafico", "Un tipo futbolero",2001,40,0,true,0,true,false);//!

        Particular cliente1 = new Particular("Julio Barbaro","123456","Peron 12","123456");
        Estudiante cliente2 = new Estudiante("Sergio Arean", "222222","Corbet 11","464","UTN");
        Jubilado cliente3 = new Jubilado("Don Gervasio", "12", "Instituto del Mar Habitacion 1", "480-1010");
        Jubilado cliente4 = new Jubilado("Don Gervasio", "12", "Instituto del Mar Habitacion 1", "480-1010"); //!


        System.out.println(miSistema.AgregarLibro(libro1));
        System.out.println(miSistema.AgregarLibro(libro2));
        System.out.println(miSistema.AgregarLibro(libro3));
        System.out.println(miSistema.AgregarLibro(libro4));


        System.out.println(miSistema.AgregarCliente(cliente1));
        System.out.println(miSistema.AgregarCliente(cliente2));
        System.out.println(miSistema.AgregarCliente(cliente3));
        System.out.println(miSistema.AgregarCliente(cliente4));

        //calculo previo de presupuesto (todos los libros tienen promo vigente)
        System.out.println(miSistema.InformarPresupuesto("El hombre que arania","123456",1));
        System.out.println(miSistema.InformarPresupuesto("El retrato de Dorian Gray","93250393",2));
        System.out.println(miSistema.InformarPresupuesto("El Grafico","12",3));





    }
}