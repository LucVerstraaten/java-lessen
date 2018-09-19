/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package le2;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author kuus
 */
public class huis {

    private final Line lijn1, lijn2, lijn3;
    private final Rectangle rec1, rec2, rec3;

    public huis(Pane p) {
        p.setStyle("-fx-background-color: Bisque;");
        lijn1 = new Line(50, 20, 20, 100);
        lijn2 = new Line(20, 100, 80, 100);
        lijn3 = new Line(80, 100, 50, 20);
        rec1 = new Rectangle(20, 100, 60, 60);
        rec2 = new Rectangle(30, 140, 10, 20);
        rec3 = new Rectangle(50, 130, 20, 20);

        lijn1.setStrokeWidth(3);
        lijn2.setStrokeWidth(3);
        lijn3.setStrokeWidth(3);
        lijn1.setStroke(Color.RED);
        lijn2.setStroke(Color.GREEN);
        lijn3.setStroke(Color.BLUE);
        rec1.setFill(Color.BLACK);
        rec2.setFill(Color.WHITE);
        rec3.setFill(Color.BLUE);
        p.getChildren().addAll(rec1, rec2, rec3, lijn1, lijn2, lijn3);

    }
}
