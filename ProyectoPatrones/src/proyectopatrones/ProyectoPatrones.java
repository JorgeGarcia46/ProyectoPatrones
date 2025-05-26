package proyectopatrones;

import facade.BibliotecaFacade;

public class ProyectoPatrones {

    public static void main(String[] args) {
         BibliotecaFacade biblioteca = new BibliotecaFacade();

        biblioteca.agregarLibro("1984");
        biblioteca.agregarLibro("El Principito");
        biblioteca.registrarUsuario("Ana");

        biblioteca.prestarLibro("1984", "Ana");
        biblioteca.prestarLibro("1984", "Ana"); // no disponible
        biblioteca.devolverLibro("1984");
        biblioteca.prestarLibro("1984", "Ana");
    }
    
}
