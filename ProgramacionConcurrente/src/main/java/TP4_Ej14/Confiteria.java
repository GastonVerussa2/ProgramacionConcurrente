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
import java.util.concurrent.Semaphore;

public class Confiteria {
    
    private final Semaphore semMozo = new Semaphore(0);     
    private final Semaphore[] semCocinero;
    private final Semaphore[] semCocineroLibre;     //Cambiar a arreglo de boolean, mas eficiente
    private final int cantidadCocineros;
    private final Semaphore[] semEmpleado;
    private final Semaphore mutexConfiteria;
    private final Semaphore semBebidaInicial = new Semaphore(0);
    private final Semaphore semBebidaFinal = new Semaphore(0);
    
    public Confiteria(int cantCocineros){
        cantidadCocineros = cantCocineros;
        mutexConfiteria = new Semaphore(cantCocineros);
        semCocinero = new Semaphore[cantCocineros];
        semCocineroLibre = new Semaphore[cantCocineros];
        semEmpleado = new Semaphore[cantCocineros];
        for(int i = 0; i < cantCocineros; i++){
            semCocinero[i] = new Semaphore(0);
            semCocineroLibre[i] = new Semaphore(1);
            semEmpleado[i] = new Semaphore(0);
        }
    }
    
    //Metodos para el empleado
    
    public boolean entrarConfiteria(){
        return mutexConfiteria.tryAcquire();
    }
    
    public void pedirBebida() throws InterruptedException{
        semMozo.release();
        semBebidaInicial.acquire();
    }
    
    public void esperarBebida() throws InterruptedException{
        semBebidaFinal.acquire();
    }
    
    public int pedirComida(){
        int cocinero = 0;
        for(int i = 0; i < cantidadCocineros; i++){
            if(semCocineroLibre[i].tryAcquire()){
                cocinero = i;
                semCocinero[cocinero].release();
                System.out.println(Thread.currentThread().getName() + ": Me atendió el cocinero número " + cocinero);
                break;      //NO usar break, usar variable de control boolean.
            }
        }
        return cocinero;
    }
    
    public void esperarComida(int cocinero) throws InterruptedException {
        semEmpleado[cocinero].acquire();
        semCocineroLibre[cocinero].release();
    }
    
    public void salirConfiteria(){
        mutexConfiteria.release();
    }
    
    //Metodos para el mozo
    
    public void esperarEmpleado() throws InterruptedException {
        semMozo.acquire();
        semBebidaInicial.release();
    }

    public void entregarBebida(){
        semBebidaFinal.release();
    }
    
    //Metodos para el cocinero
    
    public void esperarPedido(int cocinero) throws InterruptedException{
        semCocinero[cocinero].acquire();
    }
    
    public void entregarComida(int cocinero){
        semEmpleado[cocinero].release();
    }
}
