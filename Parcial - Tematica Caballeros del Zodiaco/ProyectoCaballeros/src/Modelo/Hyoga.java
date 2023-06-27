package Modelo;

import Enums.Constelacion;
import Enums.TipoSangre;
import Interfaces.ITecnicaEspecialCisne;

public class Hyoga extends CaballeroDeBronce implements ITecnicaEspecialCisne {
    public Hyoga(int cantidad_de_vida, int poder_de_ataque) {
        super("Hyoga", Constelacion.CISNE, 14, 173, 60, "23 de Enero", TipoSangre._0, "Rusia", "Siberia", cantidad_de_vida, poder_de_ataque);
    }
/*● Nombre: Hyoga
● Constelación: Cisne
● Edad: 14
● Altura: 173cm
● Peso: 60kg
● Nacimiento: 23 de Enero
● Tipo de Sangre: O
● Lugar de origen: Rusia
● Lugar de entrenamiento: Siberia
*/
    @Override
    public String PolvoDeDiamantes() {
        return null;
    }

    @Override
    public String RayoDeAurora() {
        return null;
    }

    @Override
    public String RayoDeHielo() {
        return null;
    }

    @Override
    public String CirculoDeHielo() {
        return null;
    }

    @Override
    public String AuroraBoreal() {
        return null;
    }

    @Override
    public String EjecucionAurora() {
        return null;
    }
}
