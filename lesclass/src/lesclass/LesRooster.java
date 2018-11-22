/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesclass;

import java.util.ArrayList;
import javafx.scene.control.TextArea;

/**
 *
 * @author Luc Verstraaten
 */
public class LesRooster {

    ArrayList<Les> lijst;

    public LesRooster() {
        lijst = new ArrayList<Les>();

    }

    public void addLes(Les l) {

        lijst.add(l);

    }

    public void print() {
        for (Les l : lijst) {

            System.out.println("Lokaal: " + l.getLokaal() + " vak:" + l.getVak().getNaam() + "Dag" + l.getTijd().getDag() + " Tijdstip" + l.getTijd().getUur());

        }

    }

    public void printText(TextArea t) {
        String s = new String("");
        for (Les l : lijst) {

            s += l + System.lineSeparator();

        }
        t.setText(s);
        
        
        Les l = lijst.get(1);
    }
    
    

}
