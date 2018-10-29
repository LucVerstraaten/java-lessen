/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dierenplanner;

/**
 *
 * @author Luc Verstraaten
 */
// dit is de data klasse voor baas
public class Baas {
    
    
    private int id;
    private String naam, telefoonnummer, adres;

    public Baas(int i, String n, String t, String a)
    {
    
        id=i;
        naam=n;
        telefoonnummer=t;
        adres=a;
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String toString() {
        return this.getNaam();

    }
}
