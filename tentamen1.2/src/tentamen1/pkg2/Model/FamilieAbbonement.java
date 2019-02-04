/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tentamen1.pkg2.Model;

/**
 *
 * @author Luc Verstraaten
 */
public class FamilieAbbonement extends Abbonement{
    private int aantalPersonen;

    public FamilieAbbonement(int aantalPersonen, String naam, String ContactInformarion) {
        super(naam, ContactInformarion);
        this.aantalPersonen = aantalPersonen;
    }

    public int getAantalPersonen() {
        return aantalPersonen;
    }

    public void setAantalPersonen(int aantalPersonen) {
        this.aantalPersonen = aantalPersonen;
    }
    
    
}
