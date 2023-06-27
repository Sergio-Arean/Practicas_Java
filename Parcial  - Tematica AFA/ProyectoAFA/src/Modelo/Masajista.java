package Modelo;

import Interfaces.IAsistencia;

public class Masajista extends Miembro implements IAsistencia {
    private String titulo;
    private int anios_experiencia;

    public Masajista(String nombre, String apellido, int edad, String titulo, int anios_experiencia) {
        super(nombre, apellido, edad);
        this.titulo = titulo;
        this.anios_experiencia = anios_experiencia;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnios_experiencia() {
        return anios_experiencia;
    }

    @Override
    public String toString() {
        return "Masajista{" + super.toString() +
                "titulo='" + titulo + '\'' +
                ", anios_experiencia=" + anios_experiencia +
                "} " ;
    }

    @Override
    public String DarAsistencia() {
        return "Soy masasjista y estoy dando asistencia!";
    }

    @Override
    public boolean equals(Object obj) {
      boolean rta = false;
      if(obj instanceof Masajista){
          Masajista recibido = (Masajista) obj;
          if( super.equals(obj) && getTitulo().equals(recibido.getTitulo()) && getAnios_experiencia()==recibido.anios_experiencia){
              rta = true;
          }
      }
      return rta;
    }
}
