/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t2.igor.guilherme;

/**
 *
 * @author Ro7Rinke
 */
public class Task implements Runnable{
    
    private int[][] matriz;
    private int i;
    private int total;
    
    public Task(int[][] matriz, int i){
        this.matriz = matriz;
        this.i = i;
        this.total = 0;
    }
    
    @Override
    public void run(){
        for (int j = 0; j < 10; j++){
            this.total += this.matriz[this.i][j];
        }
        System.out.println("Line " + this.i + ": " + this.total);
    }
}
