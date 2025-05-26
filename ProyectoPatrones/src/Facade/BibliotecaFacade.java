package facade;

import model.Libro;
import model.Usuario;
import service.LibroService;
import service.UsuarioService;
import service.PrestamoService;

public class BibliotecaFacade {
    private LibroService libroService = new LibroService();
    private UsuarioService usuarioService = new UsuarioService();
    private PrestamoService prestamoService = new PrestamoService();

    public void agregarLibro(String titulo) {
        libroService.agregarLibro(new Libro(titulo));
    }

    public void registrarUsuario(String nombre) {
        usuarioService.registrarUsuario(new Usuario(nombre));
    }

    public void prestarLibro(String titulo, String nombreUsuario) {
        Libro libro = libroService.buscarPorTitulo(titulo);
        Usuario usuario = usuarioService.buscarPorNombre(nombreUsuario);

        if (libro != null && usuario != null) {
            prestamoService.prestarLibro(libro, usuario);
        } else {
            System.out.println("Libro o usuario no encontrado.");
        }
    }

    public void devolverLibro(String titulo) {
        Libro libro = libroService.buscarPorTitulo(titulo);
        if (libro != null) {
            prestamoService.devolverLibro(libro);
        } else {
            System.out.println("Libro no encontrado.");
        }
    }
}
