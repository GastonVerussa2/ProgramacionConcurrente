package TP4_Ej8;

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
    public static void main(String[] args){
        Recurso recursoCompartido = new Recurso();
        Corredor hilo1 = new Corredor("Corredor 1", recursoCompartido);
        Corredor hilo2 = new Corredor("Corredor 2", recursoCompartido);
        Corredor hilo3 = new Corredor("Corredor 3", recursoCompartido);
        Corredor hilo4 = new Corredor("Corredor 4", recursoCompartido);
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
    }
}
