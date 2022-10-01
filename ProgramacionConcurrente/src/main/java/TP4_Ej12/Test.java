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
public class Test {
    public static void main (String[] args){
        Jaula jaula = new Jaula();
        int cantidadHamsters = 5;
        Hamster[] hamsters = new Hamster[cantidadHamsters];
        for(int i = 0; i < cantidadHamsters; i++){
            hamsters[i] = new Hamster("Hamster " + (i+1), jaula);
        }
        for(int i = 0; i < cantidadHamsters; i++){
            hamsters[i].start();
        }
    }
}
