package service;

import model.Libro;
import model.Usuario;

public class PrestamoService {
    public boolean prestarLibro(Libro libro, Usuario usuario) {
        if (libro.isDisponible()) {
            libro.prestar();
            System.out.println("Libro prestado a: " + usuario.getNombre());
            return true;
        } else {
            System.out.println("El libro no está disponible.");
            return false;
        }
    }

    public void devolverLibro(Libro libro) {
        libro.devolver();
        System.out.println("Libro devuelto: " + libro.getTitulo());
    }
}
