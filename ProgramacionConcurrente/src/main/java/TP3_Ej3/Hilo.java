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
public class Hilo extends Thread{
    
    private final int miTurno;
    private final Compartido recurso;
    
    public Hilo(String nombre, int turno, Compartido recursoCompartido){
        super(nombre);
        miTurno = turno;
        recurso = recursoCompartido;
    }
    
    public void run(){
        while(true){
            if(recurso.getTurno() == miTurno){
                recurso.imprimir();
            }
            try{
                Thread.sleep((int) Math.random() * 10);
            } catch(InterruptedException E){
                System.out.println("ups");
            }
        }
    }
}
