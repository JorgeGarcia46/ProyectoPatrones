package proyectopatrones;

import facade.BibliotecaFacade;
import factory.EstudianteFactory;
import factory.LibroPrestadoFactory;
import factory.LibroDisponibleFactory;
import factory.LibroFactory;
import model.TipoInformacionLibro;
import vista.VistaConsola;


public class ProyectoPatrones {
    public static void main(String[] args) {
        BibliotecaFacade biblioteca = new BibliotecaFacade();
        VistaConsola vista = new VistaConsola();

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