package TP4_Ej13;

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
        
        Confiteria confiteria = new Confiteria();
        Cocinero cocinero = new Cocinero("1", confiteria);
        Mozo mozo = new Mozo("1", confiteria);
        int cantidadEmpleados = 6;
        Empleado[] empleados = new Empleado[cantidadEmpleados];
        
        for(int i = 0; i < cantidadEmpleados; i++){
            empleados[i] = new Empleado(String.valueOf(i), confiteria);
        }
        
        cocinero.start();
        mozo.start();
        
        for(int i = 0; i < cantidadEmpleados; i++){
            empleados[i].start();
        }
    }
}
