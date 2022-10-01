package TP3_Ej3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gastón
 */
public class Compartido {
    private int turno = 1, ultimoTurno;
    private String cadena = "";
    
    public Compartido(int maxTurno){
        ultimoTurno = maxTurno;
    }
    
    public int getTurno(){
        return turno;
    }
    
    public synchronized void imprimir(){
        for(int i = 0; i < turno; i++){
            cadena = cadena + Thread.currentThread().getName();
        }
        System.out.println(cadena);
        if(turno == ultimoTurno){
            turno = 1;
        } else {
            turno++;
        }
        System.out.println(turno);
    }
}
