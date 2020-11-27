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
import java.util.concurrent.Semaphore;

public class Confiteria {
    
    private final Semaphore semMozo = new Semaphore(0);     
    private final Semaphore semCocinero = new Semaphore(0);
    private final Semaphore semEmpleado = new Semaphore(0);
    private final Semaphore mutexConfiteria = new Semaphore(1);
    
    public void Confiteria(){
    }
    
    //Metodos para el empleado
    
    public boolean entrarConfiteria(){
        return mutexConfiteria.tryAcquire();
    }
    
    public void pedirAtencion() throws InterruptedException{
        semMozo.release();
        semEmpleado.acquire();
    }
    
    public void realizarPedido(){              
        semMozo.release();
    }
    
    public void esperarSentado() throws InterruptedException {
        semEmpleado.acquire();                                  
    }
    
    public void salirConfiteria(){
        mutexConfiteria.release();
    }
    
    //Metodos para el mozo
    
    public void esperarEmpleado() throws InterruptedException {
        semMozo.acquire();
        semEmpleado.release();
    }
    
    public void esperarDecision() throws InterruptedException {
        semMozo.acquire();
    }
    
    public void pedirComida(){
        semCocinero.release();
    }
    
    public void esperarCocinero() throws InterruptedException {
        semMozo.acquire();
    }
    
    public void entregarPedido(){
        semEmpleado.release();
    }
    
    //Metodos para el cocinero
    
    public void esperarPedido() throws InterruptedException{
        semCocinero.acquire();
    }
    
    public void entregarComida(){
        semMozo.release();
    }
}
