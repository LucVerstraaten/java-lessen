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
public class Les {
    
    private Tijdstip tijd;
    private String  lokaal;
    private Vak vak;

    public Les(Tijdstip tijd, Vak vak, String lokaal) {
        this.tijd = tijd;
        this.vak = vak;
        this.lokaal = lokaal;
    }

    public Tijdstip getTijd() {
        return tijd;
    }

    public String getLokaal() {
        return lokaal;
    }

    public Vak getVak() {
        return vak;
    }
    
    public String toString()
    {
    
    return "Lokaal: " + getLokaal() + " vak: "+getVak().getNaam()+ " Dag: " + getTijd().getDag()+" Tijdstip: "+ getTijd().getUur();
    }

}
