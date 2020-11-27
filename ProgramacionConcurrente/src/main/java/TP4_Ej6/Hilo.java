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

public class Hilo extends Thread{
    
    private final Compartido recurso;
    private final Semaphore semEntrada, semSalida;
    public Hilo(String nombre, Compartido recursoCompartido, Semaphore entrada, Semaphore salida){
        super(nombre);
        recurso = recursoCompartido;
        semEntrada = entrada;
        semSalida = salida;
    }
    
    public void run(){
        while(true){
            recurso.imprimir(semEntrada, semSalida);
            try{
                Thread.sleep((int) Math.random() * 10);
            } catch(InterruptedException E){
                System.out.println("ups");
            }
        }
    }
}
