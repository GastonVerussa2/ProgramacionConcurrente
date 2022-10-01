package TP4_Ej9;

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
        
        Recurso Taxi = new Recurso();
        Taxista hiloTaxista = new Taxista("Taxista", Taxi);
        Cliente Cliente1 = new Cliente("Cliente 1", Taxi);
        Cliente Cliente2 = new Cliente("Cliente 2", Taxi);
        Cliente Cliente3 = new Cliente("Cliente 3", Taxi);
        Cliente Cliente4 = new Cliente("Cliente 4", Taxi);
        Cliente Cliente5 = new Cliente("Cliente 5", Taxi);
        
        hiloTaxista.start();
        Cliente1.start();
        Cliente2.start();
        Cliente3.start();
        Cliente4.start();
        Cliente5.start();
    }
}
