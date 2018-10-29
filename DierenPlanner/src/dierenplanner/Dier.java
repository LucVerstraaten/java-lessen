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
//dit is de data klasse voor dier
public class Dier {

    private int id;
    private String naam, soort, datum;

    public Dier(int i, String n, String s, String d) {
        id = i;
        naam = n;
        soort = s;
        datum = d;

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

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String toString() {
        return this.getNaam();

    }
}
