package model;

import java.util.ArrayList;
import java.util.List;

// Patrón: Referencia de tipo, Observador
public class Libro {
    private String titulo;
    private String autor;
    private TipoInformacionLibro tipo;
    private int anio; // Campo nuevo para el año
    private boolean disponible = true;
    private List<Observador> observadores = new ArrayList<>();

    // Constructor actualizado
    public Libro(String titulo, String autor, TipoInformacionLibro tipo, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.tipo = tipo;
        this.anio = anio;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public TipoInformacionLibro getTipo() {
        return tipo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    // Setters (para modificar libro)
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTipo(TipoInformacionLibro tipo) {
        this.tipo = tipo;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getAnio() {
      return anio;
    }

    // Métodos de préstamo
    public void prestar() {
        disponible = false;
    }

    public void devolver() {
        disponible = true;
        notificarDisponibilidad();
    }

    // Observador
    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    public void notificarDisponibilidad() {
        for (Observador o : observadores) {
            o.actualizar("Libro '" + getTitulo() + "' está disponible.");
        }
    }
}