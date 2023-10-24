/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wordlejuego;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Carlo
 */
public class Tablero {
    private ArrayList<Square> cuadradosTeclado;
    private Square[][] tablero;
    private Square square;
    private Canvas fondo;
    private String[] letras;

    public Tablero() {
        tablero = new Square[6][6];
        fondo = new Canvas("Wordle", 500, 800, Color.white);
        
    }

    public void crearTablero() {
        fondo.setVisible(true);
        int cuadrosPorFila = 5;
        int cuadrosPorColumna = 6; // Dos filas
        int cuadroSize = 35;
        int espacioEntreCuadros = 10;
        int inicioX = 140;
        int inicioY = 50;

        for (int fila = 0; fila < cuadrosPorColumna; fila++) {
            for (int columna = 0; columna < cuadrosPorFila; columna++) {
                int x = inicioX + (cuadroSize + espacioEntreCuadros) * columna;
                int y = inicioY + (cuadroSize + espacioEntreCuadros) * fila;

                Square square = new Square(cuadroSize, x, y, "background");
                square.makeVisible();
                square.drawOnCanvas(fondo); // Dibuja el cuadro en el Canvas
                tablero[fila][columna] = square;
            }
        }
    }

public void crearTeclado() {
    cuadradosTeclado = new ArrayList();
    int valor = 0; // Comenzar en 0 para acceder al array de letras correctamente
    int numColumnas = 7;
    int numFilas = 4;
    int cuadroSize = 35; // Tamaño de cada cuadro
    int paddingX = 20; // Espacio horizontal entre cuadros
    int paddingY = 20; // Espacio vertical entre cuadros

    int xInicio = 100; // Posición inicial en el eje X
    int yInicio = 340; // Posición inicial en el eje Y

    // Array de letras
    String[] letras = {
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
        "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };
    
    // Primero, dibuja todos los cuadrados
    for (int i = 0; i < numFilas; i++) {
        for (int j = 0; j < numColumnas; j++) {
            if (valor < letras.length) { // Asegúrate de no desbordar el array de letras
                Square square = new Square(cuadroSize, 0, 0, "background");
                cuadradosTeclado.add(square);
                int x = xInicio + j * (cuadroSize + paddingX);
                int y = yInicio + i * (cuadroSize + paddingY);
                square.moveHorizontal(x);
                square.moveVertical(y);
                square.makeVisible();
                square.drawOnCanvas(fondo);
                valor++;
            }
        }
    }

    // Luego, dibuja todo el texto
    valor = 0;
    for (int i = 0; i < numFilas; i++) {
        for (int j = 0; j < numColumnas; j++) {
            if (valor < letras.length) { // Asegúrate de no desbordar el array de letras
                int x = xInicio + j * (cuadroSize + paddingX);
                int y = yInicio + i * (cuadroSize + paddingY);
                fondo.drawString(letras[valor], x + cuadroSize / 2, y + cuadroSize / 2, "black", 20);
                valor++;
            }
        }
    }
}

public Square[][] obtenerMatrizTablero(){
    return tablero;
}

public void compararPalabra(String cadena, String palabraSecreta, int turno) {
     int cuadrosPorColumna = 6; // Dos filas
        int cuadroSize = 35;
        int espacioEntreCuadros = 10;
        int inicioX = 140;
        int inicioY = 50;
    if (cadena.length() != palabraSecreta.length()) {
        System.out.println("Las cadenas tienen longitudes diferentes.");
        return; 
    }

    String[] letras = new String[5];
    
    for (int i = 0; i < cadena.length(); i++) {
            letras[i] = String.valueOf(cadena.charAt(i));
        }
    
    for (int j = 0; j < cadena.length(); j++) {
         Square square = new Square();
         square.changeSize(cuadroSize);
         int x = inicioX + (cuadroSize + espacioEntreCuadros) * j;
         int y = inicioY + (cuadroSize + espacioEntreCuadros) * turno;
        if (palabraSecreta.charAt(j) == cadena.charAt(j)) {
            square.changeColor("green");
        } else if (palabraSecreta.indexOf(cadena.charAt(j)) != -1) {
            square.changeColor("yellow");
        } else {
            square.changeColor("gray");
        }
        square.cambiarPosicion(x, y);
        square.makeVisible();
       // square.drawOnCanvas(fondo);
        tablero[turno][j] = square;
       // fondo.redraw();
        /*int letraX = x + cuadroSize / 2 - 5; // Ajusta las coordenadas para centrar horizontalmente
        int letraY = y + cuadroSize / 2 + 5; // Ajusta las coordenadas para centrar verticalmente
        fondo.drawString(letras[j], letraX, letraY, "black", 20);*/
        
    }

}
}
