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

public class Cliente extends Thread{
    
    Recurso Taxi;
    
    public Cliente(String nombre, Recurso taxi){
        super(nombre);
        Taxi = taxi;
    }
    
    private void caminarHastaTaxi(){
        try{
            Thread.sleep((int) (Math.random() * 35000));
        } catch(InterruptedException E){
            System.out.println(Thread.currentThread().getName() + ": Me torcí el tobillo");
        }
    }
    
    public void run(){
        System.out.println(Thread.currentThread().getName() + ": Voy a buscar un taxi");
        this.caminarHastaTaxi();
        System.out.println(Thread.currentThread().getName() + ": Estoy esperando el taxi");
        Taxi.despertarTaxista();
        System.out.println(Thread.currentThread().getName() + ": Ya desperté al taxista y entré");
        Taxi.pagarTaxista();
        System.out.println(Thread.currentThread().getName() + ": Tome su pago, adiós");
    }
    
}
