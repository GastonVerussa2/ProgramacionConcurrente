package TP4_Ej14;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gastón
 */
public class Cocinero extends Thread{
    
    private final Confiteria confiteria;
    private final String nombre;
    private final int numeroCocinero;
    
    public Cocinero(String name, Confiteria confCompartida, int numCocinero){
        super("Cocinero " + name);
        nombre = "Cocinero " + name;
        confiteria = confCompartida;
        numeroCocinero = numCocinero;
    }
    
    private void cocinar() throws InterruptedException{
        Thread.sleep(3000 + (int) (Math.random() * 2000));
    }
    
    public void run(){
        System.out.println(nombre + ": Listo para trabajar, a esperar. Soy el cocinero número " + numeroCocinero + ".");
        try{
            while(true){
                confiteria.esperarPedido(numeroCocinero);
                System.out.println("------" + nombre + ": Ya lo hago");
                this.cocinar();
                System.out.println("----------" + nombre + ": El pedido está listo");
                confiteria.entregarComida(numeroCocinero);
                System.out.println("--------------" + nombre + ": A esperar otro pedido");
            }
        }catch(InterruptedException E){
            System.out.println(nombre + ": Tuve un problema");
        }
    }
}
