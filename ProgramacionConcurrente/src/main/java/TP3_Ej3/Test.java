package TP3_Ej3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gastón
 */
public class Test {
    public static void main (String[] args){
        int turnos = 3;
        Compartido recursoCompartido = new Compartido(turnos);
        char letra = 'A';
        Hilo[] Hilos = new Hilo[turnos];
        for(int i = 0; i < turnos; i++){
            Hilos[i] = new Hilo(String.valueOf(letra), i + 1, recursoCompartido); //Inicializo los hilos
            letra++;
        }
        for(int n = 0; n < turnos; n++){
            Hilos[n].start();
        }
    }
}
