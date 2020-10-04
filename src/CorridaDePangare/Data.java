/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorridaDePangare;

/**
 *
 * @author Ro7Rinke
 */
public class Data {
    private int points = 10;
    
    public synchronized int getSetPoints(){
        this.points--;
        return this.points + 1;
    }
    
    public void reset(){
        this.points = 10;
    }
}
