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
public class Vrachtwagen extends Voertuig{
    private String Lading;

    public Vrachtwagen(String Lading, String ketneken, String merk, String kleur, int parkkeerplaats) {
        super(ketneken, merk, kleur, parkkeerplaats);
        this.Lading = Lading;
    }



    public String getLading() {
        return Lading;
    }

    public void setLading(String Lading) {
        this.Lading = Lading;
    }
    
    
}
