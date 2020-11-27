package TP4_Ej13;

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
    
    private void comer() throws InterruptedException{
        Thread.sleep(4000 + (int) (Math.random() * 2000));
    }
    
    private void verLista() throws InterruptedException{
        Thread.sleep(1000 + (int) (Math.random() * 500));
    }
    
    public void run(){
        System.out.println(nombre + ": Llegué a Los Pollos Hermanos, a trabajar");
        try{
            while(true){
                this.trabajar();
                System.out.println(nombre + ": Ah... necesito un descanso, a ver si la confiteria esta libre?");
                if(confiteria.entrarConfiteria()){
                    System.out.println("--" + nombre + ": Bien, está vacía, voy a sentarme");
                    System.out.println("----" + nombre + ": Buenos días, puede atenderme?");
                    confiteria.pedirAtencion();
                    System.out.println("----" + nombre + ": A ver...");
                    this.verLista();
                    System.out.println("----" + nombre + ": Hmmm quiero esto y esto por favor");
                    confiteria.realizarPedido();
                    confiteria.esperarSentado();
                    System.out.println("----------" + nombre + ": Hm se ve muy bueno");
                    this.comer();
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
