/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author danal
 */
// Patrón: Modelo de Vistas (consola)
public class VistaConsola {
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarLibroPrestado(String titulo, String usuario) {
        System.out.println("Libro '" + titulo + "' prestado a " + usuario);
    }
}
