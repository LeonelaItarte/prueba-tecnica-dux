package main;
import domain.Jugador;
import domain.Partido;

import java.util.Scanner;
public class SimuladorPartidoTenis {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("** BIENVENIDO AL SIMULADOR DE TENIS **");

        boolean bandera=true;

        while (bandera) {
            // Código que se repetirá mientras la condición sea verdadera
            System.out.print("Ingrese 1 para comenzar: ");

            int numeroIngreso = Integer.parseInt( scanner.nextLine());

            if(numeroIngreso != 1) {

                continue;
            }else {
                bandera= false;
            }


        }

        boolean banderaJugador1=true;

        String nombreJugador1="";

        int probabilidadJugador1=0;

        boolean banderaProbabilidad1=true;

        while(banderaJugador1) {

            System.out.print("Ingrese el nombre del jugador 1: ");

            nombreJugador1 = scanner.nextLine();

            if(nombreJugador1 == "") {
                continue;
            }else {
                banderaJugador1=false;
            }

        }


        while(banderaProbabilidad1) {

            System.out.print("Ingrese la probabilidad de ganar el partido para " + nombreJugador1 + " (%): ");

            probabilidadJugador1 = Integer.parseInt( scanner.nextLine());

            if(probabilidadJugador1 > 100) {

                System.out.println("La probabilidad no de puede ser mayor al % 100 ");

                continue;

            }else {
                banderaProbabilidad1=false;
            }
        }


        boolean banderaJugador2=true;

        String nombreJugador2="";

        int probabilidadJugador2=0;

        boolean banderaProbabilidad2=true;

        while(banderaJugador2) {

            System.out.print("Ingrese el nombre del jugador 2: ");

            nombreJugador2 = scanner.nextLine();

            if(nombreJugador2 == "") {
                continue;
            }else {
                banderaJugador2=false;
            }

        }

        while(banderaProbabilidad2) {

            System.out.print("Ingrese la probabilidad de ganar el partido para " + nombreJugador2 + " (%): ");

            probabilidadJugador2 =Integer.parseInt( scanner.nextLine());

            if(probabilidadJugador2 + probabilidadJugador1  != 100  ) {

                System.out.println("Error la suma de las probabilidades debe ser el 100% ! ingrese nuevamente");

                continue;

            }else {
                banderaProbabilidad2=false;
            }
        }

        boolean banderaTorneo=true;

        String nombreTorneo="";

        while(banderaTorneo) {

            System.out.print("Ingrese el nombre del torneo: ");

            nombreTorneo = scanner.nextLine();


            if(nombreTorneo == "") {
                System.out.print("Debes ingresar un nombre ");

                continue;
            }else {
                banderaTorneo=false;
            }

        }

        boolean banderaModalidad=true;

        int modalidad=0;

        int mejorDeTres=3;

        int mejorDeCinco=5;

        int sets=0;

        while(banderaModalidad) {
            System.out.print("Ingrese la modalidad de juego: 1 para 'el mejor de '3' - 2 para 'el mejor de 5'");

            modalidad = Integer.parseInt(scanner.nextLine());

            if(modalidad == 0) {
                System.out.println("Debe ingresar una modalidad de juego");
                continue;
            }

            if(modalidad != 1 && modalidad != 2) {

                System.out.println("Error modalidad de juego incorrecta, vuelva a ingresar una modalidad correcta");
                continue;
            }

            if(modalidad == 1) {

                sets=mejorDeTres;
            }else {

                banderaModalidad= false;
            }

            if(modalidad == 2) {

                sets=mejorDeCinco;
            }else {

                banderaModalidad= false;
            }

            System.out.println(" Datos ingresados correctamente. Que comienze el torneo " + nombreTorneo +" !");
        }





        Jugador jugador1 = new Jugador(nombreJugador1, probabilidadJugador1);
        Jugador jugador2 = new Jugador(nombreJugador2, probabilidadJugador2);

        Partido partido = new Partido(jugador1, jugador2, nombreTorneo, sets);

        partido.simularPartido();



        while (true) {
            System.out.println("Desea jugar la revancha? 1 para 'SI' - 2 para 'NO' ");

            int jugarRevancha = Integer.parseInt(scanner.nextLine());

            if (jugarRevancha == 1) {

                partido.simularPartido();

            } else if (jugarRevancha == 2) {
                System.out.println("Gracias por jugar, adios!");
                break;
            } else {
                System.out.println("Error, vuelva a ingresar las opciones");
                continue;
            }

        }



        scanner.close();



    }

}