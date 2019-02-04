/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proeftoets;

import java.util.ArrayList;

/**
 *
 * @author Luc Verstraaten
 */
public class Parkeerplaatsen {

    private ArrayList<String> aPark = new ArrayList();
    private ArrayList<String> vPark = new ArrayList();

    public Parkeerplaatsen() {
        int x = 1;
        while (x < 51) {
            if (x < 10) {
                aPark.add("A0" + x);
            } else {
                aPark.add("A" + x);
            }
            x++;
        }
        x = 1;
        while (x < 21) {
            if (x < 10) {
                vPark.add("V0" + x);
            } else {
                vPark.add("V" + x);
            }
             x++;
        }
    }

    public ArrayList<String> getaPark() {
        return aPark;
    }

    public ArrayList<String> getvPark() {
        return vPark;
    }

}
