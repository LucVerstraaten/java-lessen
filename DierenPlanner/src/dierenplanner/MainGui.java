/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dierenplanner;

import javafx.scene.layout.GridPane;

/**
 *
 * @author Luc Verstraaten
 */
public class MainGui {

    private DierGui dier;
    private BaasGui baas;
    private AfspraakGui afspraak;

    
    // hier worden alle gedeeltes van het scherm samengevoegd
    public MainGui(GridPane p) {
        GridPane d = new GridPane();
        dier = new DierGui(d);
        GridPane b = new GridPane();
        baas = new BaasGui(b);
        GridPane a = new GridPane();
        afspraak = new AfspraakGui(a);

        p.add(d, 0, 0);
        p.add(b, 1, 0);
        p.add(a, 0, 1);

    }
}
