/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6_Ej2;

/**
 *
 * @author sebas
 */
public class GestorSala {
    
    private int cantidadPersonas = 0;
    private int capacidad;
    private int jubiladosEsperando = 0;
    private final int tUmbral;
    
    public GestorSala(int capacidad, int umbralTemperatura){
        this.capacidad = capacidad;
        tUmbral = umbralTemperatura;
    }
    
    public synchronized void entrarSala(){
        // se invoca cuando una persona quiere entrar en la sala.
        try{
            while((cantidadPersonas >= capacidad)||(jubiladosEsperando > 0)){
                this.wait();
            }
            cantidadPersonas++;
        } catch(InterruptedException E){
        }
    }
    
    public synchronized void entrarSalaJubilado(){
        // se invoca cuando una persona jubilada quiere entrar en la sala.
        try{
            jubiladosEsperando++;
            while(cantidadPersonas >= capacidad){
                this.wait();
            }
            cantidadPersonas++;
            jubiladosEsperando--;
        } catch(InterruptedException E){
        }
    }
    
    public synchronized void salirSala(){
        // se invoca cuando una persona, jubilada o no, quiere salir de la sala
        cantidadPersonas--;
        this.notifyAll();
    }
    
    public synchronized void notificarTemperatura(int temperatura){
        // lo invoca la hebra que mide la temperatura de la sala para indicar el último valor medido
        if(temperatura > tUmbral){
            capacidad = 35;
        } else {
            capacidad = 50;
        }
    }
}
