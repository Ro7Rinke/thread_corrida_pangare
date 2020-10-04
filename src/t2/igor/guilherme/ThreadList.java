/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t2.igor.guilherme;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Ro7Rinke
 */
public class ThreadList {
    
    /*
        essa lista serve para armazenar as atuais trheads que precisam
        terminar antes de prosseguir o codigo
    */
    
    private ArrayList<Thread> threads = new ArrayList();//ja inicia com uma lista vazia

    public synchronized ArrayList<Thread> getThreads() {
        return threads;
    }

    public synchronized void setThreads(ArrayList<Thread> threads) {
        this.threads = threads;
    }
    
    public synchronized void add(Thread t){
        threads.add(t);//adiciona uma novo elemento na lista de forma sincronizada
    }
    
    public synchronized boolean verifyAlive(){
        Iterator iterator = getThreads().iterator();
        while(iterator.hasNext()){//percorre a lista de threads
            Thread t = (Thread) iterator.next();
            if(t.isAlive())//verifica se a thread ainda esta viva
                return true;//caso encontre alguma thread viva retorna true, 
                //nao há necessidade de verifacar as outras
        }
        return false;//ao chegar neste trecho a lista inteira foi percorrida
        //e nenhuma thread viva foi encontrada
    }
    
    
}