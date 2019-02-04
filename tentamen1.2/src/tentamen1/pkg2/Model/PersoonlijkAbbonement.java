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
public class PersoonlijkAbbonement extends Abbonement {

    private String geboorteDatum;

    public PersoonlijkAbbonement(String geboorteDatum, String naam, String contactInformarion) {
        super(naam, contactInformarion);
        this.geboorteDatum = geboorteDatum;
    }

    public String getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(String geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

}
