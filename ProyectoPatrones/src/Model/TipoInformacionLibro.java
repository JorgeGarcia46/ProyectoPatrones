/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

// Patrón: Referencia de Tipo
public enum TipoInformacionLibro {
    DISPONIBLE("Disponible"),
    PRESTADO("Prestado");

    private final String valor;

    TipoInformacionLibro(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}