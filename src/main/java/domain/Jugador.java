package domain;

public class Jugador {
    private String nombre;

    private int probabilidadDeGanar;

    public Jugador(String nombre,int probabilidadDeGanar){

        this.nombre=nombre;
        this.probabilidadDeGanar=probabilidadDeGanar;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getProbabilidadDeGanar() {
        return probabilidadDeGanar;
    }

    public void setProbabilidadDeGanar(int probabilidadDeGanar) {
        this.probabilidadDeGanar = probabilidadDeGanar;
    }
}
