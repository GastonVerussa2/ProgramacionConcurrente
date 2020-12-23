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
public class Termometro extends Thread{             //Hilo que sirve para medir la temperatura y notificar al gestor.
              
    private final int espera;                       //Variable para modificar más facilmente la espera entre medida y medida.
    private final GestorSala SalaMuseo;             //Recurso compartido
    
    public Termometro(GestorSala sala, int espera){ //Metodo constructor, recibe como parametro el recurso compartido y la espera.
        SalaMuseo = sala;
        this.espera = espera;
    }
    
    private void esperar(){                 //Espera entre medida y medida
        try{
            Thread.sleep(espera);
        } catch(InterruptedException E){
            
        }
    }
    
    private int medirTemperatura(){                     //Metodo que simula la medición de la temperatura.
        return 20 + (int) (Math.random() * 15);
    }
    
    public void run(){                                                  //Metodo run.
        while(true){                                                    //Repite indefinidamente.
            SalaMuseo.notificarTemperatura(this.medirTemperatura());    //Mide la temperatura y le notifica al gestor.
            this.esperar();                                             //Espera para volver a medir.
        }
    }
}
