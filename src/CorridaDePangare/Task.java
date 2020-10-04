/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorridaDePangare;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ro7Rinke
 */
public class Task implements Runnable{
    
    private int M;
    private int id;
    private Data data;
    private ThreadList tl;
    
    public Task(int id, int M, Data data, ThreadList tl){
        this.id = id;
        this.M = M;
        this.data = data;
        this.tl = tl;
    }
    
    private synchronized void exec(){
        if(this.M > 0){
            int points = data.getSetPoints();
            App.values[this.id] += points;
            System.out.println("points "+points+" id:"+this.id);
            this.M--;
            
            if(points == 1){
                data.reset();
                while(tl.threadsLocked() < 9){
                    
                }
//                System.out.println("notify"+this.id);
                synchronized(data){
                    data.notifyAll();
                }
                
            }else{
                try {
//                    System.out.println("sleep"+this.id);
                    synchronized(data){
                        data.wait();
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
//            System.out.println("acordou "+this.id);
            this.exec();
        }
//        System.out.println("fora if"+this.id);
    }
    
    @Override
    public void run(){
        this.exec();
    }
}
