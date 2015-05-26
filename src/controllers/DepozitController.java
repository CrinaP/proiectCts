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
import model.Depozit;

/**
 *
 * @author student
 */
public class DepozitController {
    private Connection con;
    private PreparedStatement ps1, ps2;
    
    public DepozitController(Connection con){
        try {
            this.con = con;
            ps1 = con.prepareStatement("INSERT INTO depozite VALUES (NULL, ?)");
            ps2 = con.prepareStatement("SELECT * FROM depozite");
        } catch (SQLException ex) {
            Logger.getLogger(DepozitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void adaugaDepozit(Depozit d){
        try {
            ps1.setString(1, d.getNume());
            ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DepozitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Depozit> getDepozite(){
        ArrayList<Depozit> depozite = new ArrayList<Depozit>();
        try {
            ResultSet rs = ps2.executeQuery();
            while(rs.next()){
                depozite.add(new Depozit(rs.getInt("id"), rs.getString("nume")));
            }
        } catch (SQLException ex) {//stai ca te sun
            Logger.getLogger(DepozitController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return depozite;
    }
}
