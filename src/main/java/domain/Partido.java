package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Partido {
    private Jugador jugador1;
    private Jugador jugador2;
    private String nombreTorneo;
    private int setsTotales;


    public Partido(Jugador jugador1,Jugador jugador2,String nombreTorneo,int setsTotales) {

        this.jugador1=jugador1;
        this.jugador2=jugador2;
        this.nombreTorneo=nombreTorneo;
        this.setsTotales=setsTotales;
    }

    public void mostrarGanadorDelPartido(List<Set> listaSets) {


        System.out.print(jugador1.getNombre());
        for(Set set: listaSets) {


            System.out.print(set.getPuntoJugador1() + " ");


        }

        System.out.println("");
        System.out.print(jugador2.getNombre());
        for(Set set: listaSets) {


            System.out.print(set.getPuntoJugador2() + " ");


        }

    }

    public Jugador simularPartido() {

        int setJugador1=0;
        int setJugador2=0;
        List<Set> setJugados = new ArrayList<>();



        while(true) {
            Set set =simularSet();

            if(set.getJugadorGanador() == jugador1) {
                setJugador1++;
            }
            if(set.getJugadorGanador() == jugador2) {
                setJugador2++;
            }

            setJugados.add(set);


            if(setsTotales == 3) {
                if (setJugador1 == 2) {
                    System.out.println("¡" + jugador1.getNombre() + " gana el torneo " + nombreTorneo + " !");
                    mostrarGanadorDelPartido(setJugados);
                    return jugador1;
                }
                if (setJugador2 == 2) {
                    System.out.println("¡" + jugador2.getNombre() + " gana el torneo " + nombreTorneo + " !");
                    mostrarGanadorDelPartido(setJugados);
                    return jugador2;
                }

            }
            if(setsTotales == 5) {
                if (setJugador1 == 3) {
                    System.out.println("¡" + jugador1.getNombre() + " gana el partido!");
                    mostrarGanadorDelPartido(setJugados);
                    return jugador1;
                }
                if (setJugador2 == 3) {
                    System.out.println("¡" + jugador2.getNombre() + " gana el partido!");
                    mostrarGanadorDelPartido(setJugados);
                    return jugador2;
                }

            }


        }


    }

    public Set simularSet() {

        int gameJugador1=0;
        int gameJugador2=0;

        Set set= new Set();

        while(true) {
            Jugador ganadorGame=simularGame();

            System.out.println("************************");
            System.out.println("Realiza el saque el jugador "+ ganadorGame.getNombre());
            System.out.println("************************");

            if(ganadorGame == jugador1) {
                gameJugador1++;
                set.setPuntoJugador1(gameJugador1);
            }
            if(ganadorGame == jugador2) {
                gameJugador2++;
                set.setPuntoJugador2(gameJugador2);
            }


            Jugador jugadorGanador = getJugadorGanadorSet(gameJugador1, gameJugador2);

            if (jugadorGanador !=null) {
                set.setJugadorGanador(jugadorGanador);
                return set;
            }


        }
    }


    public Jugador getJugadorGanadorSet(int gameJugador1, int gameJugador2) {

        if(gameJugador1 >= 6 || gameJugador2 >= 6) {
            int diferencia= gameJugador1 - gameJugador2;

            if (diferencia >= 2) {

                return jugador1;
            }else if (diferencia <= -2) {
                return jugador2;

            }

        }
        return null;

    }

    public void mostrarResultadoParcialDelGame(int puntosJugador1, int puntosJugador2) {

        String resultadoJugador1 = "";
        String resultadoJugador2 = "";
        String[] puntajes = {"0", "15", "30", "40"};

        if (puntosJugador1 >= 4) {
            resultadoJugador1 = "40";
        }else {
            resultadoJugador1 = puntajes[puntosJugador1];
        }

        if (puntosJugador2 >= 4) {
            resultadoJugador2 = "40";
        }else {
            resultadoJugador2 = puntajes[puntosJugador2];
        }

        System.out.println(jugador1.getNombre() + " " + resultadoJugador1);
        System.out.println(jugador2.getNombre() + " " + resultadoJugador2);

    }

    public Jugador simularGame() {
        int puntosJugador1=0;
        int puntosJugador2=0;




        while(true) {

            Jugador ganadorPunto=ganadorDelPunto(jugador1.getProbabilidadDeGanar(),jugador2.getProbabilidadDeGanar());

            System.out.println("************************");
            System.out.println("Ganador del punto "+ ganadorPunto.getNombre());
            System.out.println("************************");

            if(ganadorPunto == jugador1) {
                puntosJugador1++;
            }
            if(ganadorPunto == jugador2) {
                puntosJugador2++;
            }


            mostrarResultadoParcialDelGame(puntosJugador1,puntosJugador2);

            // CONDICIONESZ EN LAS QUE SE GANA UN GAME

            // Que el jugador 1 tenga 4 puntos y el 2 tenga menos de 3
            // Que el jugador 2 tenga 4 puntos y el 1 tenga menos de 3
            // Que los dos tengan mas de 3 puntos entonces la diferencia tiene que ser de 2
            if(puntosJugador1 == 4 && puntosJugador2 < 3) {
                return jugador1;
            }
            if(puntosJugador2 == 4 && puntosJugador1 < 3) {
                return jugador2;
            }
            if(puntosJugador1 >= 3 && puntosJugador2 >= 3) {
                int diferencia= puntosJugador1 - puntosJugador2;

                if (diferencia == 2) {
                    return jugador1;
                }else if (diferencia == -2) {
                    return jugador2;
                }


            }

        }

    }



    public Jugador ganadorDelPunto(int probabilidadJugador1, int probabilidadJugador2) {
        Random random = new Random();
        int resultadoPunto = random.nextInt(100) + 1;

        if (resultadoPunto <= probabilidadJugador1) {

            return jugador1;
        } else {

            return jugador2;
        }
    }

}
