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
public class Opleiding {
    
    private int opleidingsnaam;
    private String kerndocent;

    public Opleiding(int Opleidingsnaam) {
        this.opleidingsnaam = Opleidingsnaam;
    }

    public Opleiding(int Opleidingsnaam, String kerndocent) {
        this.opleidingsnaam = Opleidingsnaam;
        this.kerndocent = kerndocent;
    }

    public int getOpleidingsnaam() {
        return opleidingsnaam;
    }

    public void setOpleidingsnaam(int Opleidingsnaam) {
        this.opleidingsnaam = Opleidingsnaam;
    }

    public String getKerndocent() {
        return kerndocent;
    }

    public void setKerndocent(String kerndocent) {
        this.kerndocent = kerndocent;
    }

     public String toString() {
        return ""+this.getOpleidingsnaam();

    }
    
}
