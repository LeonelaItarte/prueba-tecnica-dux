package domain;

public class Set {

    private int puntoJugador1;
    private int puntoJugador2;
    private Jugador jugadorGanador;

    public Set() {


    }


    public int getPuntoJugador1() {
        return puntoJugador1;
    }


    public void setPuntoJugador1(int puntoJugador1) {
        this.puntoJugador1 = puntoJugador1;
    }


    public int getPuntoJugador2() {
        return puntoJugador2;
    }


    public void setPuntoJugador2(int puntoJugador2) {
        this.puntoJugador2 = puntoJugador2;
    }


    public Jugador getJugadorGanador() {
        return jugadorGanador;
    }


    public void setJugadorGanador(Jugador jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }
}
