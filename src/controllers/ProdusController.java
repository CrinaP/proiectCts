/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Produs;

/**
 *
 * @author student
 */
public class ProdusController {
    private Connection con;
    private PreparedStatement ps1, ps2, ps3;
    
    public ProdusController(Connection con){
        try {
            this.con = con;
            ps1 = con.prepareStatement("INSERT INTO produse VALUES (NULL,?,?,?)");
            ps2 = con.prepareStatement("SELECT * FROM produse WHERE depozit = ?");
            ps3 = con.prepareStatement("DELETE FROM produse WHERE id = ?");
        } catch (SQLException ex) {
            Logger.getLogger(ProdusController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void adaugaProdus(Produs p){
        try {
            ps1.setString(1, p.getNume());
            ps1.setDouble(2, p.getPret());
            ps1.setInt(3, p.getDepozit());
            ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdusController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Produs> getProduseFromDepozit(int depozit){
        ArrayList<Produs> produse = new ArrayList<>();
        try {
            ps2.setInt(1, depozit);
            ResultSet rs = ps2.executeQuery();
            
            while(rs.next()){
                produse.add(new Produs(rs.getInt("id"),
                                       rs.getString("nume"),
                                       rs.getDouble("pret"), 
                                       rs.getInt("depozit")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdusController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return produse;
    }
    
    public void stergeProdus(int produs){
        try {
            ps3.setInt(1, produs);
            ps3.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdusController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
