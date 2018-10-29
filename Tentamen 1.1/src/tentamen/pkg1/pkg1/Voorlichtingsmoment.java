/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tentamen.pkg1.pkg1;

/**
 *
 * @author Luc Verstraaten
 */
public class Voorlichtingsmoment {
    
    private int ronde;
    private String omschrijving;

    public Voorlichtingsmoment(int ronde, String omschrijving) {
        this.ronde = ronde;
        this.omschrijving = omschrijving;
    }

    public Voorlichtingsmoment(int ronde) {
        this.ronde = ronde;
    }

    public int getRonde() {
        return ronde;
    }

    public void setRonde(int ronde) {
        this.ronde = ronde;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    @Override
    public String toString() {
        return "" + ronde ;
    }
    
    
}
