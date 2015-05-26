/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import interfete.Produse;

/**
 *
 * @author student
 */
public class Depozit {
    private int id;
    private String nume;
   
    

    public Depozit() {
    }

    public Depozit(String nume) {
        this.nume = nume;
       
    }

    public Depozit(int id, String nume) {
        this.id = id;
        this.nume = nume;
        
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        if(nume.length()>3&& nume.length()<10)
        return nume;
        else
            return "Numele este prea scurt sau prea mare.";
        
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
    
    
   
        
       

    @Override
    public String toString() {
        return nume;
    }

    
}
