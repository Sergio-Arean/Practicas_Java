package Modelo;

import Interfaces.ICalculaServiciosAdicionales;

public abstract class Paquete implements ICalculaServiciosAdicionales {
    private double peso;
    private String destino;
    private boolean seguro_de_envio;
    private boolean entrega_en_dia;
    private double tarifa;

    private boolean enviado;

    private static int cantidad_creados; //para autogeneracion de id

    private int id_paquete;


    public Paquete(double peso, String destino, boolean seguro_de_envio, boolean entrega_en_dia) {
        this.peso = peso;
        this.destino = destino;
        this.seguro_de_envio = seguro_de_envio;
        this.entrega_en_dia = entrega_en_dia;
        /**cuando se crea un paquete, este no lleva tarifa, o bien vale 0, ya que  esta se calcula
         * en el/los respectivos metodos, lo mismo rige para el enviado. al crearse estan por defecto no enviados
         */
        tarifa = 0;
        enviado = false;
        cantidad_creados++;
        id_paquete = cantidad_creados;
    }

    public Paquete(){

    }

    public void setEnviado(boolean enviado) {
        this.enviado = enviado;
    }

    public abstract double CalcularTarifaEnvio();
    public double CalcularTotalPaquete() {
        CalcularTarifaEnvio();
        CalcularCostoAdicional();
        return getTarifa();
    }

    @Override
    public String toString() {
        return "peso=" + peso +
                ", destino='" + destino + '\'' +
                ", seguro_de_envio=" + InformaSeguroDeEnvio() +
                ", entrega_en_dia=" + InformaEntregaEnDia() +
                ", tarifa=" + tarifa +
                ", enviado=" + enviado +
                ", id_paquete=" + id_paquete +
                '}';
    }
    private String InformaEntregaEnDia(){
        String rta = " Contratado";
        if(!entrega_en_dia){
             rta = " No Contratado";
        }
        return rta;
    }

    private String InformaSeguroDeEnvio(){
        String rta = " Contratado";
        if(!seguro_de_envio){
            rta = " No Contratado";
        }
        return rta;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public double getPeso() {
        return peso;
    }

    public boolean isSeguro_de_envio() {
        return seguro_de_envio;
    }

    public boolean isEntrega_en_dia() {
        return entrega_en_dia;
    }

    public double getTarifa() {
        return tarifa;
    }

    public boolean isEnviado() {
        return enviado;
    }

    public int getId_paquete() {
        return id_paquete;
    }

    @Override
    public boolean equals(Object obj) {
        boolean rta = false;
            if(obj!=null){
                if(obj instanceof Paquete){
                    Paquete recibido = (Paquete) obj;
                    if(getId_paquete()==recibido.getId_paquete()){
                        rta = true;
                    }
                }
            }
            return rta;
    }
}
