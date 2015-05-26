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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author student
 */
public class UserController {
    private Connection con;
    
    private PreparedStatement ps1, ps2;
    
    public UserController(Connection con){
        try {
            this.con = con;
            ps1 = con.prepareStatement("INSERT INTO users VALUES (NULL,?,?)");
            ps2 = con.prepareStatement("SELECT * FROM users WHERE username = ?");
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public User getUserByUsername(String username){
        try {
            ps2.setString(1, username);
            ResultSet rs = ps2.executeQuery();
            if(rs.next()){
                return new User(rs.getInt("id"), 
                            rs.getString("username"), 
                            rs.getString("parola"),
                  rs.getString("CNP"));
            }else{
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void adaugaUtilizator(User user){
        try {
            ps1.setString(1, user.getUsername());
            ps1.setString(2, user.getParola());
            ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
