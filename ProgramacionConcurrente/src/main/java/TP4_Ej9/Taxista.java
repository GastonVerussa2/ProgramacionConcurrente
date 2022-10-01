package TP4_Ej9;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gastón
 */
public class Taxista extends Thread{
    
    Recurso Taxi;
    String cliente = "";
    
    public Taxista(String nombre, Recurso compartido){
        super(nombre);
        Taxi = compartido;
    }
    
    private void manejar(){
        try{
            Thread.sleep((int) (Math.random() * 6000));
        } catch (InterruptedException E){
            System.out.println("Choqué");
        }
    }
    
    public void run(){
        while(true){
            System.out.println(Thread.currentThread().getName() + ": me voy a descansar.");
            cliente = Taxi.esperarCliente();
            System.out.println(Thread.currentThread().getName() + ": A donde lo llevo " + cliente + "?");
            this.manejar();
            System.out.println(Thread.currentThread().getName() + ": Llegamos!");
            Taxi.cobrarCliente();
        }
    }
}
