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
import java.util.concurrent.locks.*;

public class Jaula {
    Lock rueda = new ReentrantLock();
    Lock plato = new ReentrantLock();
    Lock hamaca = new ReentrantLock();
    
    public Jaula(){
    }
    
    public void entrarRueda(){
        rueda.lock();
    }
    
    public void salirRueda(){
        rueda.unlock();
    }
    
    public void empezarComer(){
        plato.lock();
    }
    
    public void terminarComer(){
        plato.unlock();
    }
    
    public void entrarHamaca(){
        hamaca.lock();
    }
    
    public void salirHamaca(){
        hamaca.unlock();
    }
}
