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
import java.util.concurrent.Semaphore;

public class Recurso {
    
    String cliente = "";
    Semaphore semTaxista = new Semaphore(0),
              semCliente = new Semaphore(0),
              semTaxi = new Semaphore(1, true);
              
    public Recurso(){
    }
    
    public void despertarTaxista(){
        try{
            semTaxi.acquire();
            cliente = Thread.currentThread().getName();
            semTaxista.release();
        } catch (InterruptedException E){
            System.out.println("Malio sal subirse");
        }
    } 
    
    public void pagarTaxista(){
        try{
            semCliente.acquire();
            semTaxi.release();
        } catch(InterruptedException E){
            System.out.println("Error pago");
        }
    }
    
    public String esperarCliente(){
        try{
            semTaxista.acquire();
        } catch (InterruptedException E){
            System.out.println("Error espera");
        }
        return cliente;
    }
    
    public void cobrarCliente(){
        semCliente.release();
    }
}
