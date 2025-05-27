/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author danal
 */
public class AccesoAdministrador implements EstrategiaAcceso {
    @Override
    public boolean puedeEditarLibro() {
        return true;
    }
}