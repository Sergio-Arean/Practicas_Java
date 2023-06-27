import Modelo.*;
import org.json.JSONException;

public class Main {
    public static void main(String[] args) {
        //Pruebas
        SistemaOrdenDeCaballeros miSistema = new SistemaOrdenDeCaballeros();

        //instanciando caballeros... (prueba de que si estan en 0 no pasan) ok
        /*
        CaballeroDeBronce seiya = new Seiya(0,0);
        CaballeroDeBronce shiryu = new Shiryu(0,0);
        CaballeroDeBronce hyoga = new Hyoga(0,0);*/

        CaballeroDeBronce seiya = new Seiya(10,10);
        CaballeroDeBronce shiryu = new Shiryu(10,10);
        CaballeroDeBronce hyoga = new Hyoga(10,10);

        CaballeroDeBronce otro = new Seiya(100,100);

        System.out.println(miSistema.AgregarCaballero(seiya));
        System.out.println(miSistema.AgregarCaballero(shiryu));
        System.out.println(miSistema.AgregarCaballero(hyoga));
       // System.out.println(miSistema.AgregarCaballero(otro));

        System.out.println(miSistema.ListarCaballleros());

        //System.out.println(miSistema.EliminarCaballero(seiya));

        System.out.println(miSistema.ListarCaballleros());

        try {
            System.out.println(miSistema.toJson());
        } catch (JSONException e) {
            System.out.println(e.getMessage());
        }

    }
}