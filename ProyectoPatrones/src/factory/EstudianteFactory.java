/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import model.Estudiante;
import model.Usuario;

public class EstudianteFactory implements UsuarioFactory {
    @Override
    public Usuario crearUsuario(String nombre) {
        return new Estudiante(nombre);
    }
}
