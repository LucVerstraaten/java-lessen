/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les3;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Luc Verstraaten
 */
public class Oef4_3 {

    private TextField invoervak;
    private Button btnover;
    private Label uitvoervak;
    private long jaar;
    private double mensen;

    public Oef4_3(GridPane p) {
        mensen = 3e9;
        jaar = 1960;
        invoervak = new TextField("" + mensen);
        uitvoervak = new Label("" + jaar);
        btnover = new Button("nieuw jaar");;
        invoervak.setAlignment(Pos.CENTER_RIGHT);
        uitvoervak.setAlignment(Pos.CENTER_RIGHT);

        btnover.setOnAction(event -> {
            mensen = mensen * 1.0165;
            jaar++;

            invoervak.setText("" + mensen);
            uitvoervak.setText("" + jaar);
        });
        p.add(invoervak, 0, 0);
        p.add(btnover, 1, 0);
        p.add(uitvoervak, 0, 1);

    }
}
