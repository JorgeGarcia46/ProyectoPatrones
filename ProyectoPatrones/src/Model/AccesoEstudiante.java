/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.EstrategiaAcceso;

public class AccesoEstudiante implements EstrategiaAcceso {
    @Override
    public boolean puedeEditarLibro() {
        return false;
    }
}
