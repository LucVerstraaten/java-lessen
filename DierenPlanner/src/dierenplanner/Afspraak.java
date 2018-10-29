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
public class Afspraak {

    private int id, idDier, idBaas;
    private String datum, soort;

    public Afspraak()
    {}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDier() {
        return idDier;
    }

    public void setIdDier(int idDier) {
        this.idDier = idDier;
    }

    public int getIdBaas() {
        return idBaas;
    }

    public void setIdBaas(int idBaas) {
        this.idBaas = idBaas;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }
    
    
}
