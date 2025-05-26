package service;

import model.Libro;
import java.util.ArrayList;
import java.util.List;

public class LibroService {
    private List<Libro> libros = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public Libro buscarPorTitulo(String titulo) {
        for (Libro l : libros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                return l;
            }
        }
        return null;
    }
}
