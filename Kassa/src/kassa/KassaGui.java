/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kassa;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Luc Verstraaten
 */
public class KassaGui {

    private Label label1, label2, label3, label4, label5;
    private TextField txtbedrag, txtsub, txtbtw, txttotexbtw, txttot;
    private Button btntot, btnreset;

    public KassaGui(GridPane p) {
        txtbedrag = new TextField();
        txtsub = new TextField();
        txtbtw = new TextField();
        txttotexbtw = new TextField();
        txttot = new TextField();

        btntot = new Button("Totaal");
        btnreset = new Button("Reset");

        txtbedrag.setAlignment(Pos.CENTER_RIGHT);
        txtsub.setAlignment(Pos.CENTER_RIGHT);
        txtbtw.setAlignment(Pos.CENTER_RIGHT);
        txttotexbtw.setAlignment(Pos.CENTER_RIGHT);
        txttot.setAlignment(Pos.CENTER_RIGHT);

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
