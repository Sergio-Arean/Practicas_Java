package Modelo;

import Enums.Constelacion;
import Enums.TipoSangre;
import Interfaces.ITecnicaEspecialPegaso;

public class Seiya extends CaballeroDeBronce implements ITecnicaEspecialPegaso {
    public Seiya(int cantidad_de_vida, int poder_de_ataque) {
        super("Seiya", Constelacion.PEGASO, 13, 165, 53, "1 de Diciembre", TipoSangre.B, "Japon", "Santuario (Grecia)", cantidad_de_vida, poder_de_ataque);
    }

    @Override
    public String Meteoros() {
        return "Aplicando tecnica de Meteoros de Pegaso!";
    }

    @Override
    public String Cometa() {
        return "Aplicando tecnica de Cometa Pegaso!";
    }

    @Override
    public String Punio_de_Estrella_Rodante() {
        return "Aplicando tecnica de Punio de Estrella Rodante de Pegaso!";
    }
}
