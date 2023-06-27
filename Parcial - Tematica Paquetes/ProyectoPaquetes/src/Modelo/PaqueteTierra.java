package Modelo;

public class PaqueteTierra extends Paquete {
    private double distancia_de_envio;
    private String tipo_de_vehiculo;



    public PaqueteTierra(double peso, String destino, boolean seguro_de_envio, boolean entrega_en_dia,double distancia_de_envio, String tipo_de_vehiculo) {
        super(peso, destino, seguro_de_envio, entrega_en_dia);
        this.distancia_de_envio = distancia_de_envio;
        this.tipo_de_vehiculo = tipo_de_vehiculo;
    }

    public PaqueteTierra(){

    }

    public double getDistancia_de_envio() {
        return distancia_de_envio;
    }

    public String getTipo_de_vehiculo() {
        return tipo_de_vehiculo;
    }

    @Override
    public void CalcularCostoAdicional() { //devuelve valor (total incluyendo el de la tarifa envio) y tambien setea
        if(isSeguro_de_envio()){
            setTarifa(getTarifa()+1500);
        }
        if(isEntrega_en_dia()){
            setTarifa(getTarifa() + (getTarifa()*0.25));
        }
    }

    @Override
    public double CalcularTarifaEnvio() { //devuelve valor y tambien setea

        /*El peso del paquete * 25$. Si es “camión” el tipo de vehículo +10%.
        Si la distancia es superior a los 100km, por cada kilómetro adicional, +5%*/
        double subtotal = 0;
        double distancia_extra = 0;

        subtotal = getPeso()*25;
            if(getTipo_de_vehiculo().equals("camion")){
                subtotal = subtotal + (subtotal*0.1);
            }
            if(getDistancia_de_envio()>100){
                distancia_extra = getDistancia_de_envio()-100;
                subtotal = subtotal + (subtotal*distancia_extra*0.05);
            }
            /**setear**/
            setTarifa(subtotal);

        return subtotal;
    }



    @Override
    public String toString() {
        return "PaqueteTierra{" +   super.toString() +
                "distancia_de_envio=" + distancia_de_envio +
                ", tipo_de_vehiculo='" + tipo_de_vehiculo + '\'' +
                "} ";
    }
}
