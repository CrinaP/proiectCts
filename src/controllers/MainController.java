/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Depozit;
import model.Produs;
import model.User;
import utils.EncryptPasswords;

/**
 *
 * @author student
 */
public class MainController {
    private static MainController singleton = null;
    
    private UserController userController;
    private ProdusController produsController;
    private DepozitController depozitController;
    private Connection con;
    
    private MainController(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/produse",
                    "root","");
            this.userController = new UserController(con);
            this.produsController = new ProdusController(con);
            this.depozitController = new DepozitController(con);
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static MainController getInstance(){
        if(singleton == null){
            singleton = new MainController();
        }
        return singleton;
    }
    
    public boolean inregistrare(String username,String parola){
        User user = userController.getUserByUsername(username);
        
        if(user == null){
            userController.adaugaUtilizator(new User(username, parola));
            return true;
        }else{
            return false;
        }
    }
    
    public User conectare(String username, String parola){
        User user = userController.getUserByUsername(username);
        
        if(user != null){
            if(user.getParola().equals(EncryptPasswords.encryptWithMD5(parola))){
                return user;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }
    
    public void adaugaDepozit(String nume){
        depozitController.adaugaDepozit(new Depozit(nume));
    }
    
    public ArrayList<Depozit> getDepozite(){
        return depozitController.getDepozite();
    }
    
    public void adaugaProdus(String nume, double pret, int depozit){
        produsController.adaugaProdus(new Produs(nume, pret, depozit));
    }
    
    public ArrayList<Produs> getProduseFromDepozit(int depozit){
        return produsController.getProduseFromDepozit(depozit);
    }
    
    public void stergeProdus(int produs){
        produsController.stergeProdus(produs);
    }
}
