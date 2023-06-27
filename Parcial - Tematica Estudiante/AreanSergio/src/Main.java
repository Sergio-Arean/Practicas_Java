import Excepciones.MateriaYaExisteException;
import Excepciones.NotaYaAgregadaException;
import Modelo.*;
import Enum.*;



public class Main {
    public static void main(String[] args) {
        SistemaGestionEstudiante miSistema = new SistemaGestionEstudiante("Alan","Turing","01-01-1990","842","elquecortotodalaloooz@utn.com.ar");


        //Agregando Materias
        Materia programacion = new Materia("prog","Programacion I","Gonzalo Benoffi","Emmanuel Etcheber","Sabados de 04 a 05 AM",4);
        Materia laboratorio = new Materia("lab", "Laboratorio I","Gonzalo Benoffi","Emmanuel Etcheber","Domingos de 04 a 07 AM",5);

        Materia materiaX = new Materia("prog","Programacion II","Gonzalo Benoffi","Emmanuel Etcheber","Sabados de 04 a 05 AM",4);

        System.out.println(miSistema.AgregarMateria(programacion));
        System.out.println(miSistema.AgregarMateria(laboratorio));
        System.out.println(miSistema.AgregarMateria(materiaX)); //No debe agregarse. Prueba ok

        System.out.println(miSistema.ListarMaterias());

        /**Prueba Extra de Excepcion MateriaYaExisteException**/
        System.out.println(MateriaYaExisteException.ListarCodigosRepetidos());


        Espacio();
        //Agregando Notas a Materias
        Nota parcial_laboratorio = new Nota(4,Instancia.PRIMER_PARCIAL,"01-04-2023");

        System.out.println(miSistema.AgregarNota(laboratorio,parcial_laboratorio));
        System.out.println(miSistema.AgregarNota(laboratorio,parcial_laboratorio)); //prueba de agregar una repetida. Prueba ok

        /**Prueba Extra de Excepcion NotaYaAgregadaException**/
        System.out.println(NotaYaAgregadaException.VerInstanciasRepetidas());
        System.out.println(miSistema.ListarMaterias());

        Espacio();Espacio();

        //Agregando varias instancias de evaluacion
        /**Alan obtuvo las siguientes notas:
         * Lab I
         * 1er Parcial = 4
         * Recup 1er Parcial = 10
         *
         * 2do Parcial = 3
         * Recup 2do Parcial = 10
         * TP = 10
         *
         * Progra I
         * 1er Parcial = 2
         * Recup 1er Parcial = 10
         *
         * 2doParcial = 1
         * Recup 2do Parcial = 10
         */
        //la 1era nota ya fue instanciada, instanciamos las siguientes:
       Nota recuperatorio1_lab = new Nota(10,Instancia.RECUP_PRIMER_PARCIAL,"2 de Abril de 2023");
       Nota segundo_lab = new Nota(3,Instancia.SEGUNDO_PARCIAL,"1 de Mayo de 2023");
       Nota recuperatorio2_lab = new Nota(10,Instancia.RECUP_SEGUNDO_PARCIAL,"2 de Mayo de 2023");
       Nota tp_laboratorio = new Nota(10,Instancia.TP_1,"1 de Julio de 2023");

       Nota parcial1_progra = new Nota(2,Instancia.PRIMER_PARCIAL,"1 de Marzo de 2023");
       Nota recuperatorio1_progra = new Nota(10,Instancia.RECUP_PRIMER_PARCIAL,"2 de Marzo de 2023");
       Nota parcial2_progra = new Nota(1,Instancia.SEGUNDO_PARCIAL,"1 de Junio de 2023");
       Nota recuperatorio2_progra = new Nota(10,Instancia.RECUP_SEGUNDO_PARCIAL,"2 de Junio de 2023");

       //Agregamos cada instancia (cada nota) a nuestro sistema
       System.out.println(miSistema.AgregarNota(laboratorio,recuperatorio1_lab));
       System.out.println(miSistema.AgregarNota(laboratorio,segundo_lab));
        System.out.println(miSistema.AgregarNota(laboratorio,recuperatorio2_lab));
        System.out.println(miSistema.AgregarNota(laboratorio,tp_laboratorio));

        System.out.println(miSistema.AgregarNota(programacion,parcial1_progra));
        System.out.println(miSistema.AgregarNota(programacion,recuperatorio1_progra));
        System.out.println(miSistema.AgregarNota(programacion,parcial2_progra));
        System.out.println(miSistema.AgregarNota(programacion,recuperatorio2_progra));

        //A esta altura los cupos(instancias) definidos en cada materia estan completos...
        //Listamos materias...
        System.out.println(miSistema.ListarMaterias());

        //Prueba de que si quiero agregar una instancia mas... aparece la excepcion por limite de instancias....prueba ok
        Nota nota_extra1 = new Nota();
        Nota nota_extra2 = new Nota();
        System.out.println(miSistema.AgregarNota(laboratorio,nota_extra1));
        System.out.println(miSistema.AgregarNota(programacion,nota_extra2));

        //Prueba de Generacion de JSON
        System.out.println(miSistema.toJson());





    }
    public static void Espacio(){
        System.out.println("\n\n");
    }
}