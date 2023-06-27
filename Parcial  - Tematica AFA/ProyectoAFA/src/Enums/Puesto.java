package Enums;

public enum Puesto {
    ARQUERO(1),
    DEFENSOR(2),
    VOLANTE(3),
    DELANTERO(4);


    Puesto(int numero) {
        this.numero = numero;
    }

    private int numero;

    public int getNumero() {
        return numero;
    }
}
