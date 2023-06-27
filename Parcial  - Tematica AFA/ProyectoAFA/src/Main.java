import Enums.Puesto;
import Modelo.*;

public class Main {
    public static void main(String[] args) {
        //Instanciando sistema afa
        SistemaAFA miSistema = new SistemaAFA();

        //Instanciando miembros:
        Miembro f1 = new Futbolista("Lionel","Messi",35,10, Puesto.VOLANTE);
        Miembro f2 = new Futbolista("Emiliano","Martinez",45,23,Puesto.ARQUERO);
        Miembro m3 = new Masajista("Alejandro","Fantino",54,"Periodista",1);
        Miembro e4 = new Entrenador ("Lionel","Scaloni",30,"Perder el Primer Partido","Cara de buen tipo");
        Miembro a5 = new AyudanteDeCampo("Marcelo","Tinelli",65,"Televisiva");

        //Agregando miembros...
        System.out.println(miSistema.AgregarMiembro(f1));
        System.out.println(miSistema.AgregarMiembro(f2));
        System.out.println(miSistema.AgregarMiembro(m3));
        System.out.println(miSistema.AgregarMiembro(e4));
        System.out.println(miSistema.AgregarMiembro(a5));

        //Listar
        System.out.println(miSistema.ListarMiembros());

        //probando agregar un entrenador demas... Prueba ok

        Entrenador entrenador_extra = new Entrenador();
        System.out.println(miSistema.AgregarMiembro(entrenador_extra));
        System.out.println(miSistema.AgregarMiembro(entrenador_extra));

        //Quitar
        System.out.println(miSistema.EliminarMiembro(entrenador_extra)); //no presente en sistema

        System.out.println(miSistema.EliminarMiembro(f1)); //deberia poder

        //Listar
        System.out.println(miSistema.ListarMiembros());

        //Pruebas Ok
        //JSON!
        System.out.println(miSistema.getJSON_AFA());



    }
}