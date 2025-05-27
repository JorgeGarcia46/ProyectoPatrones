package model;

// Patrón: Estrategia
public class Usuario {
    private String nombre;
    private EstrategiaAcceso estrategia;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEstrategia(EstrategiaAcceso estrategia) {
        this.estrategia = estrategia;
    }

    public boolean puedeEditar() {
        return estrategia != null && estrategia.puedeEditarLibro();
    }
}
