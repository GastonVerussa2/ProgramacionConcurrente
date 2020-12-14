package TP4_Ej14;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gastón
 */
public class Empleado extends Thread{
    
    private final Confiteria confiteria;
    private final String nombre;
    
    public Empleado(String name, Confiteria confCompartida){
        super("Empleado " + name);
        nombre = "Empleado " + name;
        confiteria = confCompartida;
    }
    
    private void trabajar() throws InterruptedException{
        Thread.sleep(5000 + (int) (Math.random() * 20000));
    }
    
    private void tomarYComer() throws InterruptedException{
        Thread.sleep(4000 + (int) (Math.random() * 3000));
    }
    
    public void run(){
        System.out.println(nombre + ": Llegué a Los Pollos Hermanos, a trabajar");
        try{
            while(true){
                this.trabajar();
                System.out.println(nombre + ": Ah... necesito un descanso, a ver si la confiteria esta libre?");
                if(confiteria.entrarConfiteria()){
                    System.out.println("--" + nombre + ": Bien, hay espacio, voy a sentarme");
                    Random rd = new Random();
                    boolean quiereTomar = rd.nextBoolean();
                    boolean quiereComer = rd.nextBoolean();
                    if(quiereTomar){
                        System.out.println("----" + nombre + ": Buenos días mozo, me da algo para tomar por favor?");
                        confiteria.pedirBebida();
                        confiteria.esperarBebida();
                        System.out.println("------" + nombre + ": Muchas gracias por la bebida.");
                    } else {
                        quiereComer = true;             //Si no quiere tomar, entonces al menos debe comer, ya que no tendría sentido que no haga ninguna.
                    }
                    if(quiereComer){
                        System.out.println("----" + nombre + ": Buenas, puede cocinarme unos de estos?");
                        int cocinero = confiteria.pedirComida();
                        confiteria.esperarComida(cocinero);
                        System.out.println("------" + nombre + ": Muchas gracias por la comida");
                    }
                    System.out.println("----------" + nombre + ": Ya tengo lo que buscaba, ahora a disfrutar.");
                    this.tomarYComer();
                    System.out.println("------------" + nombre + ": Adiós, muchas gracias por atenderme");
                    confiteria.salirConfiteria();
                    System.out.println("--------------" + nombre + ": Uff, nuevamente a trabajar");
                } else {
                    System.out.println("--------------" + nombre + ": Uh ya hay alguien, que lástima, a volver a trabajar.");
                }
            }
        } catch(InterruptedException E){
            System.out.println(nombre + ": Tuve un problema");
        }
    }
}
