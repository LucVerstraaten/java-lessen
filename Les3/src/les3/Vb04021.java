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
 * @author kuus
 */
public class Vb04021 {

    private TextField invoervak1, invoervak2, uitvoervak;
    private Label label1, label2, label3;
    private Button btnover, btnwis;

    public Vb04021(GridPane p) {
        invoervak1 = new TextField();
        invoervak2 = new TextField();
        uitvoervak = new TextField();
        btnover = new Button("claculate");
        btnwis = new Button("wis");
        label1 = new Label("invoer1:");
        label2 = new Label("invoer2:");
        label3 = new Label("uitvoer:");

        uitvoervak.setEditable(false);
        invoervak1.setAlignment(Pos.CENTER_RIGHT);
        invoervak2.setAlignment(Pos.CENTER_RIGHT);
        uitvoervak.setAlignment(Pos.CENTER_RIGHT);

        btnover.setOnAction(event -> {
            if (invoervak1.getText() != null && !invoervak1.getText().trim().isEmpty()
                    && invoervak2.getText() != null && !invoervak2.getText().trim().isEmpty()) {
                try {
                    String invoer1 = invoervak1.getText();
                    double invoerGetal1 = Double.parseDouble(invoer1);
                    String invoer2 = invoervak2.getText();
                    double invoerGetal2 = Double.parseDouble(invoer2);

                    double uitvoergetal = (invoerGetal1 + invoerGetal2) / 2;
                    uitvoervak.setText(String.format("%.2f", uitvoergetal));
                } catch (Exception e) {
                    uitvoervak.setText("VUL EEN NUMMER IN");
                }
            } else {
                uitvoervak.setText("VUL IETS IN");
            }
        });

        btnwis.setOnAction(event -> {
            invoervak1.clear();
            uitvoervak.clear();
        });

        p.add(label1, 0, 0);
        p.add(invoervak1, 1, 0);
        p.add(label2, 0, 1);
        p.add(invoervak2, 1, 1);
        p.add(btnover, 2, 0);
        p.add(label3, 0, 2);
        p.add(uitvoervak, 1, 2);
        p.add(btnwis, 2, 1);

    }

}
