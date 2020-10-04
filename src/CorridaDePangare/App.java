/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorridaDePangare;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Igor Rinke - 23840-2
 * @author Guilherme Machado - 23839-4
 */
public class App {
    
    //ex 8 da lista
    public static void main(String[] args) {
        
        for(int i = 0; i < 10; i++){
            App.values[i] = 0;
        }
        
        ThreadList tl = new ThreadList();
        
        int M = 11;
        
        Data data = new Data();
        
        for(int id = 0; id < 10; id++){
            Thread thread = new Thread(new Task(id, M, data, tl));
            thread.start();
            tl.add(thread);
        }
        
        while(tl.verifyAlive()){
            
        }
        
        int threadId = 0;
        int higherValue = 0;
        
        for(int id = 0; id < 10; id++){
            if(App.values[id] > higherValue){
                threadId = id;
                higherValue = App.values[id];
            }
        }
        
        System.out.println("Thread number: "+threadId+" with "+higherValue+" points");
    }
    
    public static int[] values = new int[10];
}
