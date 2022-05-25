package com.geovany.opciones;

public class Marcador {

    private Integer empates;
    private Integer victorias;
    private Integer derrotas;

    public Marcador() {
        empates = 0;
        victorias = 0;
        derrotas = 0;
    }

    public Integer getTie() {
        return empates;
    }

    public Integer getWins() {
        return victorias;
    }

    public Integer getLosses() {
        return derrotas;
    }

    public void incrementarVictorias() {
        victorias++;
    }

    public void incrementarDerrotas() {
        derrotas++;
    }

    public void incrementarEmpates() {
        empates++;
    }
}
