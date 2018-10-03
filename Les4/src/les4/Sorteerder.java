/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les4;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Luc Verstraaten
 */
public class Sorteerder {

    private TextField txtGetal1, txtGetal2, txtGetal3;
    private Button btnVergelijk;

    public Sorteerder(GridPane p) {
        txtGetal1 = new TextField();
        txtGetal2 = new TextField();
        txtGetal3 = new TextField();
        btnVergelijk = new Button("Sorteer");

        txtGetal1.setAlignment(Pos.CENTER_RIGHT);
        txtGetal2.setAlignment(Pos.CENTER_RIGHT);
        txtGetal3.setAlignment(Pos.CENTER_RIGHT);

        btnVergelijk.setOnAction(event -> {
            if (txtGetal1.getText() != null && !txtGetal1.getText().trim().isEmpty() && txtGetal2.getText() != null && !txtGetal2.getText().trim().isEmpty()) {
                try {
                    String invoer1 = txtGetal1.getText();
                    double invoerGetal1 = Double.parseDouble(invoer1);

                    String invoer2 = txtGetal2.getText();
                    double invoerGetal2 = Double.parseDouble(invoer2);

                    String invoer3 = txtGetal3.getText();
                    double invoerGetal3 = Double.parseDouble(invoer3);

                    if (invoerGetal1 > invoerGetal2) {
                        if (invoerGetal2 > invoerGetal3) {
                            System.out.println("" + invoerGetal1 + " " + invoerGetal2 + " " + invoerGetal3);
                        } else if (invoerGetal1 > invoerGetal3) {
                            System.out.println("" + invoerGetal1 + " " + invoerGetal3 + " " + invoerGetal2);
                        } else {
                            System.out.println("" + invoerGetal3 + " " + invoerGetal1 + " " + invoerGetal2);
                        }
                    } else if (invoerGetal2 > invoerGetal3) {
                        if (invoerGetal1 > invoerGetal3) {
                            System.out.println("" + invoerGetal2 + " " + invoerGetal1 + " " + invoerGetal3);
                        } else {
                            System.out.println("" + invoerGetal2 + " " + invoerGetal3 + " " + invoerGetal1);
                        }
                    } else {
                        System.out.println("" + invoerGetal3 + " " + invoerGetal2 + " " + invoerGetal1);
                    }

                } catch (Exception e) {
                    System.out.println("VUL EEN NUMMER IN");
                }
            } else {
                System.out.println("VUL IETS IN");
            }
        }
        );

        p.add(txtGetal1,
                0, 0);
        p.add(txtGetal2,
                1, 0);
        p.add(txtGetal3,
                2, 0);
        p.add(btnVergelijk,
                3, 0);

    }
}
