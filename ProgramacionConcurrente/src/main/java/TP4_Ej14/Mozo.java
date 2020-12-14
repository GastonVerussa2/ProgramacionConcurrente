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
public class Mozo extends Thread{
    
    private final Confiteria confiteria;
    private final String nombre;
    
    public Mozo(String name, Confiteria confCompartida){
        super("Mozo " + name);
        nombre = "Mozo " + name;
        confiteria = confCompartida;
    }
    
    private void buscarBebida() throws InterruptedException{
        Thread.sleep(1000 + (int) (Math.random() * 500));
    }
    
    public void run(){
        System.out.println(nombre + ": Otro dia, listo para atender");
        try{
        while(true){
            confiteria.esperarEmpleado();
            System.out.println("----" + nombre + ": Claro que sí, ya se lo traigo.");
            this.buscarBebida();
            System.out.println("--------" + nombre + ": Aquí tiene su bebida. Si quiere algo para comer hable con un cocinero.");
            confiteria.entregarBebida();
            System.out.println("--------------" + nombre + ": Ahora a esperar... que tipo de pollo no existe?....");
        }
        } catch (InterruptedException E){
            System.out.println(nombre + ": Tuve un problema");
        }
    }
}
