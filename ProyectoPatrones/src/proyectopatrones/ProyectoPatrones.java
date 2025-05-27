package proyectopatrones;

import facade.BibliotecaFacade;
import factory.EstudianteFactory;
import factory.LibroPrestadoFactory;
import model.Usuario;
import vista.VistaConsola;

public class ProyectoPatrones {
    public static void main(String[] args) {
        BibliotecaFacade biblioteca = new BibliotecaFacade();
        VistaConsola vista = new VistaConsola();

        // FACTORY METHOD: Agregar libros
        biblioteca.agregarLibro("1984");
        biblioteca.agregarLibro("El Principito");
        biblioteca.agregarLibroConFactory("Libro Prestado", new LibroPrestadoFactory());

        // ABSTRACT FACTORY: Registrar usuarios
        biblioteca.registrarUsuario("Ana", new EstudianteFactory());
        biblioteca.registrarUsuario("Luis", new EstudianteFactory());

        // COMANDO: Préstamo del libro a Ana
        biblioteca.prestarLibro("1984", "Ana");
        vista.mostrarMensaje("→ Patrón Comando: Se ejecuta `PrestarLibroCommand`.\n");

        // OBSERVER: Luis intenta tomar el libro ya prestado
        biblioteca.prestarLibro("1984", "Luis");
        vista.mostrarMensaje("→ Patrón Observador: Luis se registró como observador del libro \"1984\".\n");

        // DEVOLUCIÓN: Se notifica automáticamente a Luis
        biblioteca.devolverLibro("1984");
        vista.mostrarMensaje("→ Patrón Observador: Se notifica automáticamente cuando el libro es devuelto.\n");

        // Luis ahora toma el libro
        biblioteca.prestarLibro("1984", "Luis");
        vista.mostrarMensaje("→ Luis toma el libro ahora disponible.\n");

        vista.mostrarMensaje("Fin de prueba de patrones.");
    }
}