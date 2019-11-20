/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class Cache implements Runnable {
    public Memoria MP;
    public int valores[] = new int[3];
    public char tags[] = new char[3];
    
    public Cache(Memoria mem) {        
        this.MP = mem;
    }
    
    public void writeValue(int valor, int ind) {
        this.valores[ind] = valor;
        switch (this.tags[ind]) {
            case 'S':
                this.MP.valores[ind] = valor;
                this.tags[ind] = 'E';
                break;
            case 'E':
                this.tags[ind] =  'M';
                break;
            case 'I':
                for(Cache obj : this.MP.caches) {
                    if(!obj.equals(this)) {
                        if(obj.tags[ind] == 'E' || obj.tags[ind] == 'M') {
                            this.MP.valores[ind] = valor;
                            this.valores[ind] = this.MP.valores[ind];
                            obj.tags[ind] = 'I';
                            this.tags[ind] = 'E';                        
                            break;
                        }
                    }
                }
                break;
            default:
                break;
        }
        for(Cache obj : this.MP.caches) {
            if(!obj.equals(this)) {
                if(obj.valores[ind] != valor) obj.tags[ind] = 'I';
            }
        }
    }
    
    public void readValue(int ind) {
        switch(this.tags[ind]) {
            case 'I':
                for(Cache obj : this.MP.caches) {
                    if(!obj.equals(this)) {
                        if(obj.tags[ind] == 'E' || obj.tags[ind] == 'M') {
                            this.MP.valores[ind] = obj.valores[ind];
                            obj.tags[ind] = 'S';                                                    
                        }
                        this.tags[ind] = 'S';
                        this.valores[ind] = this.MP.valores[ind];
                        break;
                    }
                }
                break;
            default:
                break;
        }
    }
    
    public void printValues() {
        System.out.println("");
        for(int i = 0; i < 3; i++) {
            System.out.println("Valor: " + this.valores[i] + " Tag: " + this.tags[i]);
        }
    }
    
    public ArrayList<String[]> getValues(){
        ArrayList<String[]> aux = new ArrayList<>();
        for(int i = 0; i < this.valores.length; i++) {
            String[] vet = new String[3];
            vet[0] = String.valueOf(i);
            vet[1] = String.valueOf(this.tags[i]);
            vet[2] = String.valueOf(this.valores[i]);
            aux.add(vet);
        }
        return aux;
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(10);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
