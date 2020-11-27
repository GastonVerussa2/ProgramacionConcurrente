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
    public static void main(String[] args){
        
        Vida recursoVida = new Vida(); //recurso compartido
        
        //Genero los hilos
        Orco t1 = new Orco("Orco", recursoVida);
        Curandero t2 = new Curandero("Curandero", recursoVida);
        
        //Inicio los hilos
        t1.start();
        t2.start();
        
        //Espero que los hilos terminen
        try{
        t1.join();
        t2.join();
        }catch(InterruptedException e){}
        
        //Cartel final para saber los puntos de vida con el que terminó el personaje
        System.out.println("La vida final del personaje es: " + recursoVida.getPuntosVida());
    }
}
