/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.wordlejuego;

import java.util.Scanner;

/**
 *
 * @author Carlo
 */
public class WordleJuego {

    public static void main(String[] args) {
        int i;
        JuegoLogico juego = new JuegoLogico();
        juego.mostrarBienvenida();
        String cadena;
        Scanner cadenas = new Scanner(System.in);
        cadena = cadenas.nextLine();
        
        int turno=1;
        
        while(turno!=5){
        i = juego.seleccionarPalabraSecreta();
        juego.compararPalabra(cadena, i);
        juego.mostrarTablero();
        int v = juego.verfificarWin(cadena, i);
        turno++;
        cadena = cadenas.nextLine();
        if(v==1){
            turno=5;
            System.out.println("Felicidades Ganaste");
        }
        
        
        }
        
    }
}
