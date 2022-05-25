package com.geovany.juego;

import com.geovany.opciones.Opciones;
import com.geovany.opciones.Marcador;

import java.util.Random;
import java.util.Scanner;

public class Juego {

    private Scanner input = new Scanner(System.in);
    private Random random = new Random();

    public void jugar() {
        imprimirReglas();

        Marcador marcador = new Marcador();
        String eleccion = input.nextLine().toUpperCase();

        while (!eleccion.equals("SALIR"))
        {
            Opciones elegirMenu = getChoiceNum(eleccion);
            while(elegirMenu == null)
            {
                System.out.println("No es uan entrada correcta, vuelva a seleccionar una opcion");
                eleccion = input.nextLine().toUpperCase();
                elegirMenu = getChoiceNum(eleccion);
            }

            Opciones pc = seleccionPC();
            compararElecciones(marcador, elegirMenu, pc);
            mostrarResultados(marcador);

            eleccion = input.nextLine().toUpperCase();
        }
    }

    private void mostrarResultados(Marcador marcador) {
        System.out.println("Victorias:" + marcador.getWins() + "\nDerrotas:" + marcador.getLosses() + "\nEmpates:" + marcador.getTie());
        System.out.println("Jugar otra vez! \n \n");
        System.out.println("Elige \"PIEDRA\", \"PAPEL\" o \"TIJERAS\" para continuar. Si quieres salir escribe \"SALIR\" para finalizar el juego");
    }

    private void compararElecciones(Marcador marcador, Opciones elegirMenu, Opciones pc) {
        if(elegirMenu == pc) {
            tie(marcador);
        }
        else if (elegirMenu == Opciones.PIEDRA && pc == Opciones.TIJERAS
                || elegirMenu == Opciones.TIJERAS && pc == Opciones.PAPEL
                || (elegirMenu == Opciones.PAPEL && pc == Opciones.PIEDRA)) {
            wins(marcador);
        } else {
            lose(marcador);
        }
    }

    private void lose(Marcador marcador) {
        System.out.println("Pierdes");
        marcador.incrementarDerrotas();
    }

    private void tie(Marcador marcador) {
        System.out.println("Es un empate");
        marcador.incrementarEmpates();
    }

    private void wins(Marcador marcador) {
        System.out.println("Ganas!");
        marcador.incrementarVictorias();
    }

    private Opciones getChoiceNum(String eleccion) {
        Opciones seleccionarOpcion = null;

        if (eleccion.equals("SALIR"))
            System.exit(0);

        try {
            seleccionarOpcion = Opciones.valueOf(eleccion);
        } catch (Exception e) {
            return null;
        }
        return seleccionarOpcion;
    }

    private Opciones seleccionPC() {
        Opciones opcion = Opciones.values()[random.nextInt(3)];
        System.out.println("la computadora eligio " + opcion.toString().toLowerCase());
        return opcion;
    }

    private void imprimirReglas() {
        System.out.println("Juego Piedra, Papel o Tijeras");
        System.out.println("Elige \"PIEDRA\", \"PAPEL\" o \"TIJERAS\" para continuar. Si quieres salir escribe \"SALIR\" para finalizar el juego");
    }
}
