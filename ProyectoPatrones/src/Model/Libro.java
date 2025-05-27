package model;

import java.util.ArrayList;
import java.util.List;

// Patrón: Referencia de tipo, Observador
public class Libro {
    private TipoInformacionLibro titulo;
    private boolean disponible = true;
    private List<Observador> observadores = new ArrayList<>();

    public Libro(String titulo) {
        this.titulo = new TipoInformacionLibro(titulo);
    }

    public String getTitulo() {
        return titulo.getValor();
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void prestar() {
        disponible = false;
    }

    public void devolver() {
        disponible = true;
        notificarDisponibilidad();
    }

    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    public void notificarDisponibilidad() {
        for (Observador o : observadores) {
            o.actualizar("Libro '" + getTitulo() + "' está disponible.");
        }
    }
}