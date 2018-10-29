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
public class Student {
    
    private String email, naam, telefoonnummer;

    public Student(String email, String naam, String telefoonnummer) {
        this.email = email;
        this.naam = naam;
        this.telefoonnummer = telefoonnummer;
    }

    public Student(String email, String naam) {
        this.email = email;
        this.naam = naam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    
         public String toString() {
        return this.getEmail();

    }
    
}
