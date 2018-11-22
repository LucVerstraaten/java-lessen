/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesclass;

/**
 *
 * @author Luc Verstraaten
 */
public class Tijdstip {
    private String dag,uur;

    public Tijdstip(String dag, String uur) {
        this.dag = dag;
        this.uur = uur;
    }

    public String getDag() {
        return dag;
    }

    public String getUur() {
        return uur;
    }
    
    
}
