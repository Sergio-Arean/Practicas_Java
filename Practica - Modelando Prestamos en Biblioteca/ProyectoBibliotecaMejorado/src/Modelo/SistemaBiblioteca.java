package Modelo;

import java.util.ArrayList;

public class SistemaBiblioteca { //clase envoltorio

    private String nombre;
    private ArrayList <Libro> listaDeLibros;
    private ArrayList<Cliente> listaDeClientes;
    private ArrayList<Prestamo> listaDePrestamos;

    public SistemaBiblioteca(String nombre) {
        this.nombre = nombre;
        listaDeLibros = new ArrayList<Libro>();
        listaDeClientes = new ArrayList<Cliente>();
        listaDePrestamos = new ArrayList<Prestamo>();
    }

    //listar : VerLibros()    VerClientes()    VerPrestamos()    VerPrestamosPendientes() //los que estan pendientes de devol
    // VerUnLibro(String titulo)

    /**--------------------------------------
     * LISTADOS
     * --------------------------------------**/

    public String VerUnLibro(String titulo){
        String rta = "El libro solicitado no fue encontrado en el sistema";
        Libro encontrado = null;
        encontrado = LocalizarLibro(titulo);
            if(encontrado!=null){
                rta = encontrado.toString();
            }
            return rta;
    }

    public String VerLibros(){
        String rta = "--LIBROS--\n";
        int cantidad =1;
        for(Libro libro : listaDeLibros){
            rta+= cantidad + libro.toString() + "\n";
            cantidad++;
        }
        return rta;
    }

    public String VerClientes(){
        String rta = "--CLIENTES--\n";
        int cantidad =1;
        for(Cliente cliente : listaDeClientes){
            rta+= cantidad + cliente.toString() + "\n";
            cantidad++;
        }
        return rta;
    }

    public String VerPrestamos(){
        String rta = "--PRESTAMOS--\n";
        int cantidad =1;
        for(Prestamo p : listaDePrestamos){
            rta+= cantidad + p.toString() + "\n";
            cantidad++;
        }
        return rta;
    }

    public String VerPrestamosVigentes(){
        String rta = "--PRESTAMOS VIGENTES--\n";
        int cantidad =1;
        for(Prestamo p : listaDePrestamos){
            if(p.isActivo()){
                rta+= cantidad + p.toString() + "\n";
                cantidad++;
            }

        }
        return rta;
    }


    /**--------------------------------------
     * DEVOLVER LIBRO
     * --------------------------------------**/
    public String DevolverLibro(int id_prestamo){
        Prestamo prestamo_encontrado = LocalizarPrestamo(id_prestamo);
        String rta = "No pudo concretarse operacion";
        Cliente cliente_encontrado = null;
        Libro libro_encontrado = null;

        if(prestamo_encontrado!=null){
            if(prestamo_encontrado.isActivo()){
                cliente_encontrado = LocalizarCliente(prestamo_encontrado.getDni_de_cliente());
                libro_encontrado = LocalizarLibro(prestamo_encontrado.getTitulo_de_libro());
                if(cliente_encontrado!=null && libro_encontrado!=null){
                    if(cliente_encontrado.isDebe_libro()){ //x seguridad.. si bien ya se verifico
                        cliente_encontrado.setDebe_libro(false); //cliente ya no debe
                        libro_encontrado.DevolverLibro();
                        prestamo_encontrado.setActivo(false); //prestamo ya quedo inactivo en la devolucion
                        rta = "El libro " + libro_encontrado.getTitulo() + " fue devuelo exitosamente a " + cliente_encontrado.getNombre();
                    }
                }
            }
            else{ //hay un prestamo pero ya no vigente
               rta = "El prestamo fue encontrado, pero no se encuentra vigente";
            }

        }
        return rta;
    }

    private Prestamo LocalizarPrestamo(int id_prestamo){
        Prestamo localizado = null;
        for(int i=0; i<listaDePrestamos.size() && localizado==null;i++){
            if(listaDePrestamos.get(i).getId_prestamo()==id_prestamo){
                localizado = listaDePrestamos.get(i);
            }
        }
        return localizado;

    }

    /**--------------------------------------
     * PRESTAR LIBRO
     * --------------------------------------**/
    public String PrestarLibro(String titulo, String dni, int dias){
        String rta = "No fue posible realizar operacion";
        Prestamo nuevo_prestamo = null;
        Libro libro = LocalizarLibro(titulo);
        Cliente cliente = LocalizarCliente(dni);
        boolean libro_prestado = false;
        double tarifa = CalcularPresupuesto(titulo,dni,dias);
        boolean prestamo_agregado = false;

            if(libro!=null && cliente!=null){
                if(libro.isDisponible()){
                    libro_prestado = libro.PrestarLibro();
                }
                    if(libro_prestado){ //si el libro pudo prestarse....
                        cliente.setDebe_libro(true);
                        nuevo_prestamo = new Prestamo(cliente.getNombre(),cliente.getDni(),libro.getTitulo(),tarifa,dias);
                        prestamo_agregado = listaDePrestamos.add(nuevo_prestamo);
                        if(prestamo_agregado){
                            rta = nuevo_prestamo.toString();
                        }
                    }
            }

        return rta;
    }

    /**--------------------------------------
     * PRESUPUESTO - CALCULOS DE VALOR
     * --------------------------------------**/

    //public String CalcularPresupuesto(String titulo, String dni, int dias) //informa el presupuesto

    //public String
    // PrestarLibro(String titulo, String dni, int dias)
    // considera el presupuesto pero ademas concreta la operacion..
    //generando el prestamo y seteando que el cliente debe libro
    private double CalcularPresupuesto(String titulo, String dni, int dias){
        Cliente cliente = LocalizarCliente(dni);
        Libro libro = LocalizarLibro(titulo);
        double subtotal =0;

            if(cliente!=null && libro!=null){ //si se encontro libro y cliente
                subtotal = dias * libro.DefinirValorAlquilerDiario();
                subtotal = subtotal - (subtotal*cliente.DefinirPorcentajeDeDescuento());

                if(libro.isPromocion_vigente()){
                    subtotal = subtotal - (subtotal*libro.DefinirPorcentajeDescuentoPromoVigente());
                }
            }
            return subtotal;
    }

    public String InformarPresupuesto(String titulo, String dni, int dias){
        String rta = "No fue posible realizar operacion. Cliente y/o libro no encontrado en sistema";
        double presupuesto = - 1;
        presupuesto = CalcularPresupuesto(titulo,dni,dias);

            if(presupuesto!=-1){
                rta = "El prespuesto calculado por el prestamo a realizar es de " + presupuesto + " pesos";
            }
        return rta;
    }

    private Cliente LocalizarCliente(String dni){
        Cliente localizado = null;
        for(int i=0; i<listaDeClientes.size() && localizado==null;i++){
            if(listaDeClientes.get(i).getDni().equals(dni)){
                localizado = listaDeClientes.get(i);
            }
        }
        return localizado;
    }

    private Libro LocalizarLibro(String titulo){
        Libro localizado = null;
        for(int i=0; i<listaDeLibros.size() && localizado==null;i++){
            if(listaDeLibros.get(i).getTitulo().equals(titulo)){
                localizado = listaDeLibros.get(i);
            }
        }
        return localizado;
    }



    /**--------------------------------------
     * AGREGAR
     * --------------------------------------**/

    public String AgregarCliente(Cliente cliente){
        String rta = "El cliente no pudo ser agregado";
        boolean existe_cliente = ExisteCliente(cliente);
        boolean agregado = false;

        if(!existe_cliente){
            agregado = listaDeClientes.add(cliente);
        }
        if(agregado){
            rta = "El cliente " + cliente.getNombre() + " fue agregado exitosamente";
        }
        return rta;
    }

    private boolean ExisteCliente(Cliente cliente){
        boolean encontrado = false;
        for(int i =0; i<listaDeClientes.size() && !encontrado;i++){
            if(listaDeClientes.get(i).equals(cliente)){
                encontrado = true;
            }
        }
        return encontrado;
    }

    public String AgregarLibro(Libro libro){
        String rta = "El libro no pudo ser agregado";
        boolean agregado = false;
        boolean existe_libro = ExisteLibro(libro);

        if(!existe_libro){
            agregado = listaDeLibros.add(libro);
        }
        if(agregado){
            rta = "El libro " + libro.getTitulo() + " ha sido agregado exitosamente";
        }

        return rta;
    }

    private boolean ExisteLibro(Libro libro){
        boolean encontrado = false;
        for(int i =0; i<listaDeLibros.size() && !encontrado;i++){
            if(listaDeLibros.get(i).equals(libro)){
                encontrado = true;
            }
        }
        return encontrado;
    }


}
