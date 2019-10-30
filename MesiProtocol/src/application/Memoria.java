/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author Administrador
 */
public class Memoria {
    public int[] valores = new int[3];
    public Cache[] caches = new Cache[3];
    
    public Memoria() {
        for(Cache obj : this.caches) {
            obj = new Cache();
        }
    }
    
    public int getValue(int ind) {
        return this.valores[ind];
    }
    
    public void setValue(int valor, int ind) {
        this.valores[ind] = valor;
    }
    
    public void setRandomValues() {
        Random x = new Random();
        for(int i = 0; i < 3; i++) {
            this.valores[i] = x.nextInt(9) + 1;
        }
    }
    
}
