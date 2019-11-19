/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;
import java.util.Scanner;
import screen.MainScreen;

/**
 *
 * @author Administrador
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        try {
            Random random = new Random();
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

            MP.printValues();
            
            System.out.print("Estado inicial");
            for(Cache obj : MP.caches) {
                obj.printValues();
            }
            Scanner sc = new Scanner(System.in);
            for(int i = 0; i < 5; i++) {
                System.out.print("\nEstágio " + i);
                int cache = random.nextInt(3);
                int ind = random.nextInt(3);
                int valor = random.nextInt(20) + 1;
                System.out.println("\nCache: " + cache + " - Endereço: " + ind + " - Valor: " + valor);
                MP.caches[cache].setValue(valor, ind);
                for(Cache obj : MP.caches) {
                    obj.printValues();                    
                }
                sc.next();
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
