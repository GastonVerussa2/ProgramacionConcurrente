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
public class Persona extends Thread{    //Hilo para simular a las personas que van al museo.
    
    private final GestorSala SalaMuseo; //Recurso compartido.
    private final boolean jubilado;     //Boolean para saber si es o no jubilado.
    private final String nombre;        //Variable para guardar el nombre y acceder al mismo más facilmente.
    
    public Persona(GestorSala SalaMuseo, boolean jubilado, String nombre){  //Metodo contructor, recibe recurso, si es jubilado y nombre.
        this.SalaMuseo = SalaMuseo;
        this.jubilado = jubilado;
        if(jubilado){                               //Define su nombre dependiendo si es jubilado o no.
            this.nombre = "Jubilado " + nombre;
        } else {
            this.nombre = "Visitante " + nombre;
        }
        this.setName(this.nombre);
    }
    
    private void caminarAlMuseo(){              //Método para simular que camina al museo y separar la llegada de cada persona.
        try{
            Thread.sleep((int) (Math.random() * 40000));
        } catch(InterruptedException E){
            
        }
    }
    
    private void pasearSala(){              //Método para simular que pasea dentro de la sala.
        try{
            Thread.sleep(10000 + (int) (Math.random() * 5000));
        } catch(InterruptedException E){
            
        }
    }
    
    public void run(){          //Método run.
        this.caminarAlMuseo();
        System.out.println(nombre + ": Llegué al museo.");      //Carteles para hacer seguimiento.
        if(jubilado){                                           //If para diferenciar que metodo de entrada debe usar.
            SalaMuseo.entrarSalaJubilado(nombre);                     //Luego usa su respectivo método para entrar.
        } else {
            SalaMuseo.entrarSala(nombre);
        }
        this.pasearSala();
        SalaMuseo.salirSala();                                 //Sale de la sala.
        System.out.println("------" + nombre + ": Salí de la sala.");
    }
}
