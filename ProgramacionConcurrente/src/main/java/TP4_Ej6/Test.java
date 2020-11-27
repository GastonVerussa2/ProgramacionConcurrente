package TP4_Ej6;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gastón
 */
import java.util.concurrent.Semaphore;

public class Test {
    public static void main (String[] args){      
        int cantidad = 5;
        Compartido recursoCompartido = new Compartido();
        char letra = 'A';
        Hilo[] Hilos = new Hilo[cantidad];
        Semaphore semEntrada = new Semaphore(1), semSalida = new Semaphore(0), primerSem = semEntrada;
        for(int i = 0; i < cantidad; i++){
            if(i < cantidad - 1){
                Hilos[i] = new Hilo(String.valueOf(letra), recursoCompartido, semEntrada, semSalida); //Inicializo los hilos
                letra++;
                semEntrada = semSalida;
                semSalida = new Semaphore(0);
            } else {
                Hilos[i] = new Hilo(String.valueOf(letra), recursoCompartido, semEntrada, primerSem);
            }
        }
        for(int n = 0; n < cantidad; n++){
            Hilos[n].start();
        }
    }
}
