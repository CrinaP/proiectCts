

package model;

import controllers.MainController;
import interfete.Produse;
import java.util.Calendar;


public class User implements Produse{
    private int id;
    private String username;
    private String parola;
    public String CNP;

    public User() {
    }

    public User(String username, String parola) {
        this.username = username;
        this.parola = parola;
    }

    public User(int id, String username, String parola, String CNP) {
        this.id = id;
        this.username = username;
        this.parola = parola;
        this.CNP=CNP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParola() {
        if(parola.length()>3)
        return parola;
        else
            return "Parola prea scurta.";
    }

    public void setParola(String parola) {
        this.parola = parola;
    }
    
      public String getCNP() {
        return CNP;
    }

    public void setCNP(String parola) {
        this.CNP = parola;
    }
    
    public String getSex(){
        switch(CNP.charAt(0))
        {
            case '1': return "M";
            case '2': return "F";
            case '3': return "M";
            case '4': return "F";
            case '5': return "M";
            case '6': return "F";
	}
	return "N/A";
    }
    
    public int getVarsta(){
	return Calendar.getInstance().get((1)) - (1900 + Integer.parseInt("" + CNP.charAt(1) + CNP.charAt(2)));
	}
    
    public boolean checkCNP(){
		int s=0;
		 String number="279146358279";
		for(int i=0;i<12;i++){
			s+=Integer.parseInt(""+number.charAt(i))*Integer.parseInt(""+CNP.charAt(i));			
		}
		int cifra=s%11;
		if(cifra==10)
			cifra=1;
		return cifra==Integer.parseInt(""+CNP.charAt(12));
	}

    
    
  
    
    @Override
    public void update(String mesaj) {
        throw new UnsupportedOperationException("Not supported yet.");
        //System.out.println(username+" ai un mesaj: "+mesaj);//To change body of generated methods, choose Tools | Templates.
    }

   
   
}
    
    

