package model;

public class Libro {
    private String titulo;
    private boolean disponible = true;

    public Libro(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void prestar() {
        disponible = false;
    }

    public void devolver() {
        disponible = true;
    }
}
