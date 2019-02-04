/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proeftoets;

/**
 *
 * @author Luc Verstraaten
 */
public class Voertuig {
    
    protected String  ketneken,merk ,kleur;
    protected int parkeerplaats;



    public String getKetneken() {
        return ketneken;
    }

    public void setKetneken(String ketneken) {
        this.ketneken = ketneken;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    public int getParkeerplaats() {
        return parkeerplaats;
    }

    public void setParkeerplaats(int parkkeerplaats) {
        this.parkeerplaats = parkkeerplaats;
    }

    public Voertuig( String ketneken, String merk, String kleur, int parkkeerplaats) {
        this.parkeerplaats = parkeerplaats;
        this.ketneken = ketneken;
        this.merk = merk;
        this.kleur = kleur;
    }

}
