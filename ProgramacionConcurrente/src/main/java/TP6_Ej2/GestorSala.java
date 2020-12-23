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
public class GestorSala {                   //Recurso compartido, monitor.
    
    private int cantidadPersonas = 0;           //Variable para saber cuantas personas hay en cada momento en la sala.
    private final int capacidadInicial = 50;    //Determina la capacidad inicial y a la que se vuelve cuando no se supera el umbral de temperatura.
    private final int capacidadReducida = 35;   //Determina la capacidad a la que se reduce cuando se supera el umbral de temperatura.
    private int capacidad = capacidadInicial;   //Variable para guardar la capacidad actual.
    private int jubiladosEsperando = 0;         //Variable para saber si hay jubilados esperando.
    private final int tUmbral;                  //Determina el umbral de temperatura.
    
    public GestorSala(int umbralTemperatura){   //Método contructor, recibe el umbral por parámetro.
        tUmbral = umbralTemperatura;
    }
    
    public synchronized void entrarSala(String nombre){      //Se invoca cuando una persona quiere entrar en la sala.
        try{
            if((cantidadPersonas >= capacidad)||(jubiladosEsperando > 0)){   //Si no hay espacio o hay jubilados esperando.
                System.out.println("--" + nombre + ": Debo esperar.");
                do{
                    this.wait();                                            //Espera a que le avisen cuando puede que sea diferente.
                } while((cantidadPersonas >= capacidad)||(jubiladosEsperando > 0));
            }
            cantidadPersonas++;                                                 //Entra a la sala, por lo que hay una persona más.
            System.out.println("----" + nombre + ": Logré entrar a la sala.  (cantidad actual: " + cantidadPersonas + ").");
        } catch(InterruptedException E){
        }
    }
    
    public synchronized void entrarSalaJubilado(String nombre){  //Se invoca cuando una persona jubilada quiere entrar en la sala.
        try{
            if(cantidadPersonas >= capacidad){   //Si no hay espacio.
                System.out.println("--" + nombre + ": Debo esperar.");
                jubiladosEsperando++;                   //Agrega un jubilado esperando.
                do{
                    this.wait();                        //Espera a que le avisen cuando puede que haya espacio.
                } while(cantidadPersonas >= capacidad);
                jubiladosEsperando--;                   //Ya no está esperando.
            }
            cantidadPersonas++;                     //Entra a la sala, por lo que hay una persona más.
            System.out.println("----" + nombre + ": Logré entrar a la sala.  (cantidad actual: " + cantidadPersonas + ").");
        } catch(InterruptedException E){
        }
    }
    
    public synchronized void salirSala(){   //Se invoca cuando una persona, jubilada o no, quiere salir de la sala.
        cantidadPersonas--;                 //Sale de la sala, hay una persona menos.
        this.notifyAll();                   //Avisa a todos los que estén esperando que hay un espacio libre.
    }
    
    public synchronized void notificarTemperatura(int temperatura){ //Lo invoca la hebra que mide la temperatura de la sala para indicar el último valor medido.
        if(temperatura > tUmbral){              //Si se supera el umbral
            capacidad = capacidadReducida;      // se ajusta la capacidad a la reducida.
        } else {                                //Si no
            capacidad = capacidadInicial;       // se ajusta la capacidad a la inicial.
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("La temperatura actual es de: " + temperatura + ". La capacidad fue ajustada a " + capacidad + ".");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
