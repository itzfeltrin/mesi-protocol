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
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        Memoria MP = new Memoria();
        MP.setRandomValues();
        
        Thread pc1 = new Thread(MP.caches[0]);
        Thread pc2 = new Thread(MP.caches[1]);
        Thread pc3 = new Thread(MP.caches[2]);
        
        pc1.setName("PC1");
        pc2.setName("PC2");
        pc3.setName("PC3");
        
        pc1.start();
        pc2.start();
        pc3.start();
       
        MP.caches[0].setValue(13, 1);
        
        for(Cache obj : MP.caches) {
            obj.printValues();
        }
    }
    
}
