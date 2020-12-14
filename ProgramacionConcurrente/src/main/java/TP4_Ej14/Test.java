package TP4_Ej14;

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
        
        int cantidadCocineros = 2;
        Confiteria confiteria = new Confiteria(cantidadCocineros);
        Cocinero[] cocineros = new Cocinero[cantidadCocineros];       
        Mozo mozo = new Mozo("1", confiteria);
        int cantidadEmpleados = 6;
        Empleado[] empleados = new Empleado[cantidadEmpleados];
        
                
        for(int i = 0; i < cantidadCocineros; i++){
            cocineros[i] = new Cocinero(String.valueOf(i), confiteria, i);
        }
        
        for(int i = 0; i < cantidadEmpleados; i++){
            empleados[i] = new Empleado(String.valueOf(i), confiteria);
        }
        
        mozo.start();
        
        for(int i = 0; i < cantidadCocineros; i++){
            cocineros[i].start();
        }
        
        for(int i = 0; i < cantidadEmpleados; i++){
            empleados[i].start();
        }
    }
}
