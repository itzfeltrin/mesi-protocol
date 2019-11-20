/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Administrador
 */
public class Memoria {
    public int[] valores = new int[3];
    public Cache[] caches = new Cache[3];
    
    public Memoria() {
        for(int i = 0; i < this.caches.length; i++) {
            this.caches[i] = new Cache(this);
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
        for(Cache obj : this.caches) {
            for(int i = 0; i < 3; i++) {
                obj.valores[i] = this.valores[i];
                obj.tags[i] = 'S';
            }
        }
    }
    
    public ArrayList<String[]> getValues(){
        ArrayList<String[]> aux = new ArrayList<>();
        for(int i = 0; i < this.valores.length; i++) {
            String[] vet = new String[2];
            vet[0] = String.valueOf(i);
            vet[1] = String.valueOf(this.valores[i]);
            aux.add(vet);
        }
        return aux;
    }
}
