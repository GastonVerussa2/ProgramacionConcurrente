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
import java.util.concurrent.Semaphore;

public class Recurso {
    Semaphore testigo = new Semaphore(1);
    
    public Recurso(){
    }
    
    public void empezarCorrer(){
        try{
            testigo.acquire();
        } catch(InterruptedException E){
            System.out.println(Thread.currentThread().getName() + "no pudo empezar");
        }
    }
    
    public void terminarCorrer(){
        testigo.release();
    }
}
