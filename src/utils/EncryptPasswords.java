/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public final class EncryptPasswords {
    private EncryptPasswords(){
        
    }
    
    public static String encryptWithMD5(String parola){
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte [] input = parola.getBytes();
            byte [] digested = md.digest(input);
            
            for(int i=0;i<digested.length;i++){
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncryptPasswords.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();
    }
}
