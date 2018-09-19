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
    private Kassa kas = new Kassa();

    public KassaGui(GridPane p) {
        txtbedrag = new TextField();
        txtsub = new TextField();
        txtbtw = new TextField();
        txttotexbtw = new TextField();
        txttot = new TextField();

        btntot = new Button("Totaal");
        btnreset = new Button("Reset");

        label1 = new Label("Voer bedrag in");
        label2 = new Label("Subtotaal");
        label3 = new Label("btw");
        label4 = new Label("totaal ex Btw");
        label5 = new Label("totaal");

        txtbedrag.setAlignment(Pos.CENTER_RIGHT);
        txtsub.setAlignment(Pos.CENTER_RIGHT);
        txtbtw.setAlignment(Pos.CENTER_RIGHT);
        txttotexbtw.setAlignment(Pos.CENTER_RIGHT);
        txttot.setAlignment(Pos.CENTER_RIGHT);

        btntot.setOnAction(event -> {
            if (txtbedrag.getText() != null && !txtbedrag.getText().trim().isEmpty()) {
                try {
                    String invoer = txtbedrag.getText();
                    double invoerGetal = Double.parseDouble(invoer);

                    txtsub.setText("" + kas.getSubtotaal());
                    kas.telOp(invoerGetal);
                    txtbtw.setText("" + kas.berekenBTW());
                    txttotexbtw.setText("" + kas.berekenSubtotaalExBTW());
                    txttot.setText("" + kas.getSubtotaal());

                } catch (Exception e) {
                    txtbedrag.setText("VUL EEN NUMMER IN");
                }
            } else {
                txtbedrag.setText("VUL IETS IN");
            }
        });

        btnreset.setOnAction(event -> {
            txtbedrag.clear();
            txtsub.clear();
            txtbtw.clear();
            txttotexbtw.clear();
            txttot.clear();

        });

        p.add(label1, 0, 0);
        p.add(txtbedrag, 1, 0);
        p.add(label2, 0, 1);
        p.add(txtsub, 1, 1);
        p.add(btntot, 2, 1);
        p.add(label3, 0, 2);
        p.add(txtbtw, 1, 2);
        p.add(label4, 0, 3);
        p.add(txttotexbtw, 1, 3);
        p.add(label5, 0, 4);
        p.add(txttot, 1, 4);
        p.add(btnreset, 2, 4);
    }

}
