package Modelo;

import Enums.Constelacion;
import Enums.TipoSangre;
import Interfaces.ITecnicaEspecialDragon;

public class Shiryu extends CaballeroDeBronce implements ITecnicaEspecialDragon {
    public Shiryu(int cantidad_de_vida, int poder_de_ataque) {
        super("Shiryu", Constelacion.DRAGON, 14, 172, 53, "4 de Octubre", TipoSangre.A, "Japon", "China (Roza, 5 viejos picos)", cantidad_de_vida, poder_de_ataque);
    }

    @Override
    public String Fuerza() {
        return "Aplicando tecnica de Fuerza de Dragon!";
    }

    @Override
    public String Furia() {
        return "Aplicando tecnica de Furia de Dragon!";
    }

    @Override
    public String Ascendente() {
        return "Aplicando tecnica de Dragon Ascendente!";
    }

    @Override
    public String Naciente() {
        return "Aplicando tecnica de Dragon Naciente!";
    }

    @Override
    public String Ascenso_MonteLu() {
        return "Procediendo al Ascenso del Monte Lu!";
    }

    @Override
    public String Ultimo() {
        return "Aplicando tecnica del ultimo dragon!";
    }
}
/*● Nombre: Shiryu
● Constelación: Dragón
● Edad: 14
● Altura: 172cm
● Peso: 53kg
● Nacimiento: 4 de Octubre
● Tipo de Sangre: A
● Lugar de origen: Japón
● Lugar de entrenamiento: China (Roza, 5 viejos
picos)*/