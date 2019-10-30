/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

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
    
    public void setValue(int valor, int ind) {
        this.valores[ind] = valor;
        this.tags[ind] = 'M';
        for(Cache obj : this.MP.caches) {
            if(!obj.equals(this)) {
                if(obj.valores[ind] != valor) obj.tags[ind] = 'I';
            }
        }
    }
    
    public void printValues() {
        System.out.println("");
        for(int i = 0; i < 3; i++) {
            System.out.println("Valor: " + this.valores[i] + " Índice: " + this.tags[i]);
        }
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
