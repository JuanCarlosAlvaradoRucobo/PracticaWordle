/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wordlejuego;
import java.util.Random;
/**
 *
 * @author Carlo
 */
public class JuegoLogico {
 private String[] bancoPalabras={"queso", "troya", "Hello", "metro", "carro"};;
 private int[] tablero;
    public JuegoLogico(){
      this.tablero = new int[5];
    }
    
    public void mostrarBienvenida(){
        System.out.println("                WORDLE");
        System.out.println("Ingresa la palabra a adivinar: ");
    }
    
    public int seleccionarPalabraSecreta(){
        int i;
        Random rmd = new Random();
        i=rmd.nextInt(bancoPalabras.length);
        return i;
    }
    
   
    
    public void compararPalabra(String cadena, int num){
        for(int e:tablero ){
            e=0;
        }
        
        String palabraSecreta = bancoPalabras[num];
        

    for(int i= 0; i < palabraSecreta.length(); i++) {
        if(palabraSecreta.charAt(i) == cadena.charAt(i)) {
            tablero[i]=2;
        }else if (palabraSecreta.indexOf(cadena.charAt(i)) != -1){
            tablero[i]=1;
        }else{
            tablero[i]=0;
        }
    }
    }
    
    public void mostrarTablero(){
        String wordle="";
        System.out.println("0=No existe esta letra, 2=Letra Correcta, 1=Se encuentra pero no aqui");
        for (int i = 0; i < tablero.length; i++) {
            wordle += "["+ tablero[i]+"]"+" ";
}
        
        System.out.println(wordle);
        
        
    }
    
    public int verfificarWin(String cadena, int num){
       String palabraSecreta=bancoPalabras[num];
       int v;
        if (palabraSecreta==cadena){
            v=1;
        }else{
            v=0;
        }
        return v;
    }
    
}
