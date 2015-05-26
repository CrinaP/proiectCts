

package model;

import com.sun.jmx.defaults.JmxProperties;
import interfete.Subject;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observer;


public class Produs implements Subject {
    private int id;
    private String nume;
    private double pret;
    private int depozit;
    private ArrayList<Produs> listaProduse;
    
    public String mesaj="";
    
    public Produs(ArrayList<Produs> listaNoua) throws Exception{
	if(listaNoua!=null){
		listaProduse = new ArrayList<>();
		for(int i=0;i<listaNoua.size();i++)
			listaProduse.add(listaNoua.get(i));
        }
        else
        {
		throw new Exception("Lista data ca parametru este nula");
	}
	}
    
    
    public Produs() {
    }

    public Produs(String nume)
    {
        this.nume=nume;
    }
    public Produs(String nume, double pret, int depozit) {
        this.nume = nume;
        this.pret = pret;
        this.depozit = depozit;
    }

    public Produs(int id, String nume, double pret, int depozit) {
        this.id = id;
        this.nume = nume;
        this.pret = pret;
        this.depozit = depozit;
        this.listaProduse = new ArrayList<>();
    }

    
    public void esteInDepozit()
    {
        this.mesaj="Produsul"+id+"este in depozit";
        notifica();
    }
    public void nuEsteInDepozit()
    {
        this.mesaj="Produsul"+id+"nu este in depozit";
        notifica();
    }
   
    public Produs(int id)
    {
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        if(Character.isUpperCase(nume.charAt(0)))
        return nume;
        return 
                "Numele trebuie sa inceapa cu litera mare.";
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getPret() {
        if(pret>0)
        {
            return pret;
        }
        else
            return 0;
        
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getDepozit() {
        return depozit;
    }

    public void setDepozit(int depozit) {
        this.depozit = depozit;
    }
    
     public ArrayList<Produs> getListaProduse() {
        return listaProduse;
    }

    public void setListaProduse(ArrayList<Produs> listaProduse) {
        this.listaProduse = listaProduse;
    }


    @Override
    public String toString() {
        return nume+" "+pret+" "+listaProduse;
    }

    public void notifica() {
        throw new UnsupportedOperationException("Not supported yet."); 
        
    }

    
    private ArrayList<Produs> listaProduse(Produs a, Produs b)
    {
        ArrayList<Produs> lista = null;
		if(a.length()>10 || a.length()>10){
			lista.add(a);
			lista.add(b);
		}
		return lista;
    }
    
    public Produs returneaza (Produs pro, int depozit)
    {
        pro.depozit=depozit;
        return pro;
    }
    
    //CITIRE DIN FISIER
        public String getProduse(int n)  
        {
            HashMap<Integer, String> produse = new HashMap<Integer, String>();
		
		try
		{
			FileReader citire = new FileReader("Date.txt");
			BufferedReader buffercitire = new BufferedReader(citire);
			String linie = null;
			
			while((linie = buffercitire.readLine()) != null && linie.length() >0)
			{
				produse.put(Integer.parseInt(linie.split("	")[0]), linie.split("	")[1]);
			}
		}
		catch(FileNotFoundException error)
		{
			error.printStackTrace();
		}
		catch(IOException error)
		{
			error.printStackTrace();
		}
		return produse.get(Integer.parseInt(""+nume.charAt(0)));
        }

    
    
    @Override
    public void adaugaObserver(interfete.Produse pr) {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stergeObserver(interfete.Produse pr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int length() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   
   



  
   
    
    
    
}
