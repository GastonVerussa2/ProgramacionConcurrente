package TP4_Ej12;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gastón
 */
public class Hamster extends Thread{
    
    Jaula jaula;
    String nombre;
    
    public Hamster(String name, Jaula recursoCompartido){
        super(name);
        nombre = name;
        jaula = recursoCompartido;
    }
    
    private void comer(){
        try{
            Thread.sleep((int) (Math.random() * 1000));
        } catch(InterruptedException E){}
    }
    
    private void correr(){
        try{
            Thread.sleep(10000 + (int) (Math.random() * 2000));
        } catch(InterruptedException E){}
    }
    
    private void descansar(){
        try{
            Thread.sleep(3000 + (int) (Math.random() * 1000));
        } catch(InterruptedException E){}
    }

    public void run(){
        jaula.empezarComer();
        System.out.println(nombre + ": Empiezo a comer");
        this.comer();
        System.out.println("--" + nombre + ": Termine de comer");
        jaula.terminarComer();
        jaula.entrarRueda();
        System.out.println("------" +nombre + ": Entro a la rueda");
        this.correr();
        System.out.println("---------" + nombre + ": Salgo de la rueda");
        jaula.salirRueda();
        jaula.entrarHamaca();
        System.out.println("---------------" +nombre + ": Entro a la hamaca");
        this.descansar();
        System.out.println("----------------------------------" + nombre + ": Salgo de la hamaca, TERMINE!");
        jaula.salirHamaca();
    }
}
