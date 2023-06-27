package Modelo;

public abstract class Libro {
    private String titulo;
    private String autor;
    private int anio_publicacion;
    private int cantidad; //cantidad que tengo.. quizas ejemplares seria un mejor nombre
    private int cantidad_prestados; //se aumenta en cada prestamo, su comparacion con la cantidad es lo que va a definir su disponibilidad
    private boolean disponible;
    private int prestamos_realizados; //contador para definir popularidad
    private boolean promocion_vigente;

    abstract double DefinirValorAlquilerDiario();
    abstract double DefinirPorcentajeDescuentoPromoVigente();


    public Libro(String titulo, String autor, int anio_publicacion, int cantidad, int cantidad_prestados, boolean disponible, int prestamos_realizados, boolean promocion_vigente) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio_publicacion = anio_publicacion;
        this.cantidad = cantidad;
        this.cantidad_prestados = cantidad_prestados;
        this.disponible = disponible;
        this.prestamos_realizados = prestamos_realizados;
        this.promocion_vigente = promocion_vigente;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getCantidad_prestados() {
        return cantidad_prestados;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public int getPrestamos_realizados() {
        return prestamos_realizados;
    }

    public boolean isPromocion_vigente() {
        return promocion_vigente;
    }

    @Override
    public String toString() {
        return "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anio_publicacion=" + anio_publicacion +
                ", cantidad=" + cantidad +
                ", cantidad_prestados=" + cantidad_prestados +
                ", disponible=" + Disponible() +
                ", prestamos_realizados=" + prestamos_realizados +
                ", promocion_vigente=" + PromocionVigente() +
                '}';
    }

    private String Disponible(){
        String rta = " Si ";
        if(!disponible){
            rta = " No ";
        }
        return rta;
    }

    private String PromocionVigente(){
        String rta = " Si ";
        if(!promocion_vigente){
            rta = " No ";
        }
        return rta;
    }

    public boolean PrestarLibro(){
        boolean respuesta = false;
        if(disponible){
            if(cantidad_prestados<cantidad){ //si tengo mas copias que la cantidad total, lo puedo prestar
                cantidad_prestados++; //ahora preste uno mas
                prestamos_realizados++;  //el libro suma un alquiler (p/popularidad)
                respuesta = true;

                    if(cantidad_prestados==cantidad){ //si no me quedan mas ejemplares, el libro ya no esta disponible pal prestamo
                        disponible = false;
                    }
            }
        }
        return respuesta;
    }

    public void DevolverLibro(){
        cantidad_prestados--;
        if(cantidad_prestados<cantidad){ //vuelve a estar disponible si todavia m quedan ejemplares para prestar
            disponible = true;
        }
    }



    @Override
    public boolean equals(Object obj) {
        boolean rta = false;
        if(obj!=null){
            if(obj instanceof Libro){
                Libro recibido = (Libro) obj;
                if(getTitulo().equals(((Libro) obj).getTitulo())){
                    rta = true;
                }
            }
        }
        return rta;
    }
}
