/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t2.igor.guilherme;

import java.util.Random;

/**
 *
 * @author Igor Rinke - 23840-2
 * @author Guilherme Machado - 23839-4
 */
public class T2IgorGuilherme {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // ex 6 da lista
        
        int[][] matriz  = new int[10][10];
        ThreadList tl = new ThreadList();
        
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                Random rand = new Random();
                matriz[i][j] = rand.nextInt(1000);
//                  matriz[i][j] = i + j;
            }
        }
        
        for (int i = 0; i < 10; i++){
            Thread task = new Thread(new Task(matriz, i));
            task.start();
            tl.add(task);
        }
        
        while(tl.verifyAlive()){
            
        }
    }
    
}
