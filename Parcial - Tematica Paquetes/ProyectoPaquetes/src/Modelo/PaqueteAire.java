package Modelo;

public class PaqueteAire extends Paquete{
    private String aerolinea;
    private String clase_de_envio;

    public PaqueteAire(double peso, String destino, boolean seguro_de_envio, boolean entrega_en_dia,String aerolinea, String clase_de_envio) {
        super(peso, destino, seguro_de_envio, entrega_en_dia);
        this.aerolinea = aerolinea;
        this.clase_de_envio = clase_de_envio;
    }

    public PaqueteAire(){

    }

    public String getAerolinea() {
        return aerolinea;
    }

    public String getClase_de_envio() {
        return clase_de_envio;
    }

    @Override
    public void CalcularCostoAdicional() { // calcular y setear
        if(isSeguro_de_envio()){
            setTarifa(getTarifa()+2500);
        }
        if(isEntrega_en_dia()){
            setTarifa(getTarifa()+(getTarifa()*0.5));
        }
    }

    @Override
    public double CalcularTarifaEnvio() { //calcula , devuelve valor , y setea
        double subtotal=0;

        subtotal = getPeso()*30;
        if(getAerolinea().equals("AA")){
            subtotal = subtotal + (subtotal*0.5);
        }
        if(getClase_de_envio().equals("express")){
            subtotal = subtotal + 1000;
        }

        /**setear**/
        setTarifa(subtotal);

        return subtotal;
    }


    @Override
    public String toString() {
        return "PaqueteAire{" +  super.toString() +
                "aerolinea='" + aerolinea + '\'' +
                ", clase_de_envio='" + clase_de_envio + '\'' +
                "} ";

    }
}
