package domain;

import junit.framework.TestCase;
import org.junit.Test;

public class PartidoTest extends TestCase {

    private Jugador jugador1 = new Jugador("Jugador1", 45);
    private Jugador jugador2 = new Jugador("Jugador2", 55);

    private Partido partidoTest = new Partido(jugador1, jugador2, "Dux Open", 5);

    @Test
    public void testNoHayGanador() {
        // los jugadores tienen menos de 6 puntos
        Jugador ganador = partidoTest.getJugadorGanadorSet(3, 4);
        assertNull(ganador);
    }

    @Test
    public void testGanadorPorDiferencia() {
        // Jugador 1 alcanza 6 puntos,y Jugador 2 tiene 4
        Jugador ganador = partidoTest.getJugadorGanadorSet(6, 4);
        assertEquals(jugador1, ganador);
    }

    @Test
    public void testEmpate() {
        // Ambos jugadores empatan a 6 puntos
        Jugador ganador = partidoTest.getJugadorGanadorSet(6, 6);
        assertNull(ganador);
    }

}