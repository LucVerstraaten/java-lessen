/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les4;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Luc Verstraaten
 */
public class Tot1000 {

    private Label lbUitkomst;
    private int i;

    public Tot1000(GridPane p) {
        lbUitkomst = new Label();
        i = 0;

        for (int x = 1; x < 1001; x++) {
            //if (x % 2 == 0) {
                i += x;
           // }
        }
        lbUitkomst.setText("" + i);
        p.add(lbUitkomst, 0, 0);
    }

}
