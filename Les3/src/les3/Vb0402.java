/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les3;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author kuus
 */
public class Vb0402 {

    private TextField invoervak, uitvoervak;
    private Button btnover, btnwis;

    public Vb0402(GridPane p) {
        invoervak = new TextField();
        uitvoervak = new TextField();
        btnover = new Button("transfer");
        btnwis = new Button("wis");

        uitvoervak.setEditable(false);
        invoervak.setAlignment(Pos.CENTER_RIGHT);
        uitvoervak.setAlignment(Pos.CENTER_RIGHT);

        btnover.setOnAction(event -> {
            if (invoervak.getText() != null && !invoervak.getText().trim().isEmpty()) {
                try {
                    String invoer = invoervak.getText();
                    double invoerGetal = Double.parseDouble(invoer);

                    double uitvoergetal = 12 * invoerGetal;
                    uitvoervak.setText(String.format("%.2f", uitvoergetal));
                } catch (Exception e) {
                      uitvoervak.setText("VUL EEN NUMMER IN");
                }
            } else {
                uitvoervak.setText("VUL IETS IN");
            }
        });

        btnwis.setOnAction(event -> {
            invoervak.clear();
            uitvoervak.clear();
        });

        p.add(invoervak, 0, 0);
        p.add(btnover, 1, 0);
        p.add(uitvoervak, 0, 1);
        p.add(btnwis, 1, 1);

    }

}
