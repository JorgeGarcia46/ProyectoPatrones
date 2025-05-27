/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.AccesoEstudiante;

/**
 *
 * @author danal
 */
// Subclase para Abstract Factory + Estrategia
public class Estudiante extends Usuario {
    public Estudiante(String nombre) {
        super(nombre);
        setEstrategia(new AccesoEstudiante());
    }
}
