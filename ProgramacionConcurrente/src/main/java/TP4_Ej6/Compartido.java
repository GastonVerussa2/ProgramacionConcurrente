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

public class Compartido {
    private String cadena = "";
    
    public Compartido(){
    }

    public void imprimir(Semaphore semEntrada, Semaphore semSalida){
        try{
            semEntrada.acquire();
            char letra = Thread.currentThread().getName().charAt(0);
            for(char c = 'A'; c <= letra ; c++){
                cadena = cadena + letra;
            }
            System.out.println(cadena);
            semSalida.release();
        } catch(InterruptedException e){
            System.out.println("error imprimir");
        }
    }
}
