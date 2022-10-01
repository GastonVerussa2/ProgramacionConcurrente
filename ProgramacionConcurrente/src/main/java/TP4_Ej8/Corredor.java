package TP4_Ej8;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gastón
 */
public class Corredor extends Thread{
    Recurso recursoCompartido;
    
    public Corredor(String nombre, Recurso compartido){
        super(nombre);
        recursoCompartido = compartido;
    }
    
    private void correr(){
        try{
            long tiempoInicio = System.currentTimeMillis();
            Thread.sleep(9000 + (int) (Math.random() * 2000));
            System.out.println(Thread.currentThread().getName() + ": termine de correr, tardé: " + ((float) ((System.currentTimeMillis() - tiempoInicio) / 100) / 10) + " segundos.");
        } catch(InterruptedException E){
            System.out.println(Thread.currentThread().getName() + " se cayó.");
        }
    }
    
    
    public void run(){
        recursoCompartido.empezarCorrer();
        System.out.println(Thread.currentThread().getName() + ": agarro el testigo.");
        correr();
        System.out.println(Thread.currentThread().getName() + ": dejo el testigo.");
        System.out.println();
        recursoCompartido.terminarCorrer();
    }
}
