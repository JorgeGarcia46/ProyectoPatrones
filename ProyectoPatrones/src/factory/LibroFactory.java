/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import model.Libro;

/**
 *
 * @author danal
 */
// Patrón: Factory Method
public abstract class LibroFactory {
    public abstract Libro crearLibro(String titulo);
}
