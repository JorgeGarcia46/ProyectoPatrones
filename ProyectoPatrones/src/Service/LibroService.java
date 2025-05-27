package service;

import model.Libro;
import factory.LibroFactory;
import java.util.ArrayList;
import java.util.List;

public class LibroService {
    private List<Libro> libros = new ArrayList<>();

    // Importa factory.LibroFactory
    public void agregarLibro(String titulo, LibroFactory factory) {
    libros.add(factory.crearLibro(titulo));
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
