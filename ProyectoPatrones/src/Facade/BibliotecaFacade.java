package facade;

import factory.LibroFactory;
import factory.LibroDisponibleFactory;
import factory.UsuarioFactory;
import model.Usuario;
import factory.UsuarioFactory;
import model.Libro;
import model.Observador;
import model.UsuarioObservador;
import service.LibroService;
import service.PrestamoService;
import service.UsuarioService;
import comando.ComandoPrestamo;
import comando.PrestarLibroCommand;
import java.util.List;
import model.TipoInformacionLibro;


// Patrón: Fachada
public class BibliotecaFacade {
    private LibroService libroService = new LibroService();
    private UsuarioService usuarioService = new UsuarioService();
    private PrestamoService prestamoService = new PrestamoService();

    // Agregar libro con Factory Method
    public void agregarLibro(String titulo, String autor, TipoInformacionLibro tipo, int anio) {
        LibroFactory factory = new LibroDisponibleFactory();
        Libro libro = factory.crearLibro(titulo, autor, tipo, anio);
        libroService.agregarLibro(libro);
    }

    // Agregar libro usando Factory pasada por parámetro (opcional)
    public void agregarLibroConFactory(String titulo, String autor, TipoInformacionLibro tipo, int anio, LibroFactory factory) {
        Libro libro = factory.crearLibro(titulo, autor, tipo, anio);
        libroService.agregarLibro(libro);
    }

    // Registrar usuario con Abstract Factory
    public void registrarUsuario(String nombre, UsuarioFactory factory) {
        Usuario usuario = factory.crearUsuario(nombre);
        usuarioService.registrarUsuario(usuario);
    }

    // Prestar libro con patrón Comando
    public void prestarLibro(String titulo, String nombreUsuario) {
        Libro libro = libroService.buscarPorTitulo(titulo);
        Usuario usuario = usuarioService.buscarPorNombre(nombreUsuario);

        if (libro != null && usuario != null) {
            // Patrón Observer: el usuario se registra como observador si el libro no está disponible
            if (!libro.isDisponible()) {
                Observador observador = new UsuarioObservador(usuario.getNombre());
                libro.agregarObservador(observador);
                System.out.println("Libro no disponible. Se agregó observador.");
                return;
            }

            // Patrón Comando: ejecutar préstamo
            ComandoPrestamo comando = new PrestarLibroCommand(prestamoService, libro, usuario);
            comando.ejecutar();
        } else {
            System.out.println("Libro o usuario no encontrado.");
        }
    }

    // Devolver libro (se notifica al observador)
    public void devolverLibro(String titulo) {
        Libro libro = libroService.buscarPorTitulo(titulo);
        if (libro != null) {
            prestamoService.devolverLibro(libro);
            // La notificación a observadores ya está en libro.devolver()
        } else {
            System.out.println("Libro no encontrado.");
        }
    }
    public List<Libro> obtenerLibros() {
        return libroService.obtenerLibros();
    }
    
    public Libro buscarPorTitulo(String titulo) {
        return libroService.buscarPorTitulo(titulo);
    }
}