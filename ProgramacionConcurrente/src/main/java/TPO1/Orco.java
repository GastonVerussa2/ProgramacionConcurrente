/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gastón
 */
public class Orco extends Thread{
    //clase Thread que se va a encargar de simular al orco
    private final Vida vidaPersonaje;
    
    public Orco(String nombre, Vida vidaPJ){
        super(nombre);
        vidaPersonaje = vidaPJ; //recurso compartido
    }
    
    public void run(){
        for(int i = 1; i <= 10; i++){
                vidaPersonaje.golpear();
            try{
                Thread.sleep((int) (Math.random() * 10));
            }catch(InterruptedException e){}
        }
    }
}
