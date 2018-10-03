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
public class Vergelijker {

    private TextField txtGetal1, txtGetal2;
    private Button btnVergelijk;
    private Label lbUitkomst;

    public Vergelijker(GridPane p) {
        txtGetal1 = new TextField();
        txtGetal2 = new TextField();
        btnVergelijk = new Button("Vergelijk");
        lbUitkomst = new Label();

        txtGetal1.setAlignment(Pos.CENTER_RIGHT);
        txtGetal2.setAlignment(Pos.CENTER_RIGHT);

        btnVergelijk.setOnAction(event -> {
            if (txtGetal1.getText() != null && !txtGetal1.getText().trim().isEmpty() && txtGetal2.getText() != null && !txtGetal2.getText().trim().isEmpty()) {
                try {
                    String invoer1 = txtGetal1.getText();
                    double invoerGetal1 = Double.parseDouble(invoer1);

                    String invoer2 = txtGetal2.getText();
                    double invoerGetal2 = Double.parseDouble(invoer2);

                    if (invoerGetal1 == invoerGetal2) {
                        lbUitkomst.setText("Ze zijn gelijk");
                    } else if (invoerGetal1 < invoerGetal2) {
                        lbUitkomst.setText("Rechts is groter");
                    } else if (invoerGetal1 > invoerGetal2) {
                        lbUitkomst.setText("Links is groter");
                    }

                } catch (Exception e) {
                    lbUitkomst.setText("VUL EEN NUMMER IN");
                }
            } else {
                lbUitkomst.setText("VUL IETS IN");
            }
        });

        p.add(txtGetal1, 0, 0);
        p.add(txtGetal2, 1, 0);
        p.add(btnVergelijk, 2, 0);
        p.add(lbUitkomst, 1, 1);

    }

}
