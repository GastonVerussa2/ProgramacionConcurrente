/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6_Ej2;

import java.util.Random;

/**
 *
 * @author sebas
 */
public class Test {
    
    public static void main(String[] args){
        
        GestorSala SalaMuseo = new GestorSala(30);
        Termometro TermometroSala = new Termometro(SalaMuseo, 4000);
        int cantPersonas = 150;
        Persona Personas[] = new Persona[cantPersonas];
        
        Random rb = new Random();
        for(int i = 0; i < cantPersonas; i++){
            Personas[i] = new Persona(SalaMuseo, rb.nextBoolean(), String.valueOf(i));
        }
        
        TermometroSala.start();
        for(int i = 0; i < cantPersonas; i++){
            Personas[i].start();
        }
    }
}
