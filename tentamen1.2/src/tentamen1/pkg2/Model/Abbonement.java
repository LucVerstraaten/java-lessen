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
public class Abbonement  {
    protected String naam;
    protected String contactInformarion;

    public Abbonement(String naam, String contactInformarion) {
        this.naam = naam;
        this.contactInformarion = contactInformarion;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getContactInformarion() {
        return contactInformarion;
    }

    public void setContactInformarion(String contactInformarion) {
        this.contactInformarion = contactInformarion;
    }
    
    
}
