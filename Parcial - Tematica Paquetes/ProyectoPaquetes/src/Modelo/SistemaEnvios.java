package Modelo;

import java.util.ArrayList;

public class SistemaEnvios { //clase envoltorio
    private String nombre;
    private ArrayList <Paquete> listaPaquetes;

    public SistemaEnvios(String nombre) {
        this.nombre = nombre;
        listaPaquetes = new ArrayList<Paquete>();
    }

    /** implementar>
     * public String InformarCantidadPaquetes()
     * public String AgregarPaquete() //devuelve id en formato texto
     * public String EnviarPaquete()
     *
     * public String CrearPaquete() //con esto evito un new en el main
     * pero como pide equals, vamos a crear paquetes en el main, y en el equals q hagamos
     * lo hacemos segun id
     */


    /**-------------------------------------------
     * ENVIAR PAQUETE
     * ------------------------------------------**/
    public String EnviarPaquete(int id_paquete){
        String rta = "No se encontro paquete";
        Paquete p = LocalizarPaquete(id_paquete);
        if(p!=null){
            if(!p.isEnviado()){ //si no fue enviado lo puedo enviar
                p.setEnviado(true);
                rta = "El paquete con ID nro " + id_paquete + " pudo ser enviado exitosamente";
            }
            else{
                rta = "Ya fue enviado el paquete con ID nro " + id_paquete;
            }
        }
        return rta;
    }


    /**-------------------------------------------
     * CALCULAR PRECIO
     * ------------------------------------------**/
    public String CalcularPrecioPaquete(Paquete p){
        String rta = "Operacion no pudo ser realizada";
        double valor = 0;
        if(p!=null){
            if(p instanceof Paquete){ //me aseguro que no llega cualquier cosa al metodo
                valor = p.CalcularTotalPaquete();
                rta = "El paquete, de ser enviado, tendria un costo total de " + valor + " pesos";
            }
        }
        return rta;
    }


    /**-------------------------------------------
     * AGREGAR PAQUETE
     * ------------------------------------------**/
    public String AgregarPaquete(Paquete p){
        String rta = "El paquete no pudo ser agregado";
        boolean agregado = false;

        if(!ExistePaquete(p)){
            agregado = listaPaquetes.add(p);
        }
        if(agregado){
            rta = "Paquete agregado exitosamente con el ID "+ p.getId_paquete();
        }
        return rta;
    }

    /**-------------------------------------------
     * AUXILIARES DE BUSQUEDA
     * ------------------------------------------**/
    private boolean ExistePaquete(Paquete p){
        boolean encontrado = false;
        for(int i=0; i<listaPaquetes.size() && !encontrado;i++){
            if(listaPaquetes.get(i).equals(p)){
                encontrado = true;
            }
        }
        return encontrado;
    }

    private Paquete LocalizarPaquete(int id_paquete){
        Paquete p = null;
        for(int i=0; i<listaPaquetes.size() && p==null;i++){
            if(listaPaquetes.get(i).getId_paquete()==id_paquete){
                p = listaPaquetes.get(i);
            }
        }
        return p;
    }



    /**-------------------------------------------
     * LISTAR/CONTAR
     * ------------------------------------------**/
    public String InformarCantidadPaquetes(){
        return "Hay " + listaPaquetes.size() + "paquetes en total";
    }

    public String VerPaquetes(){
        String rta ="---PAQUETES--\n";
        for(Paquete p : listaPaquetes){
            rta += p.toString() + "\n";
        }
        return rta;
    }




}
