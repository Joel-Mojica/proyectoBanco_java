/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author HP
 */
public class Cuenta{
    
    
    public int balance;

    public Cuenta(){
       
    }
    
    public Cuenta(int balance) {
        this.balance = balance;
    }
    

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    
    public void depositar(int a){
        balance += a;
        
    }
    
    public int retirar(int b){
        return balance = balance - b;
    }
}
