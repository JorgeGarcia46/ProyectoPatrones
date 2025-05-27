/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comando;

import model.Libro;
import model.Usuario;
import service.PrestamoService;
/**
 *
 * @author danal
 */
public class PrestarLibroCommand implements ComandoPrestamo {
    private PrestamoService servicio;
    private Libro libro;
    private Usuario usuario;

    public PrestarLibroCommand(PrestamoService servicio, Libro libro, Usuario usuario) {
        this.servicio = servicio;
        this.libro = libro;
        this.usuario = usuario;
    }

    @Override
    public void ejecutar() {
        servicio.prestarLibro(libro, usuario);
    }
}