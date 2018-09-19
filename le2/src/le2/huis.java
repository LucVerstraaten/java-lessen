/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package le2;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author kuus
 */
public class huis {

    private final Rectangle rec1, rec2, rec3;
    private final Polygon tri1;

    public huis(Pane p) {
        p.setStyle("-fx-background-color: Bisque;");
        tri1 = new Polygon();
        tri1.getPoints().addAll(new Double[]{
            50.0, 50.0,
            20.0, 100.0,
            80.0, 100.0});
        rec1 = new Rectangle(20, 100, 60, 60);
        rec2 = new Rectangle(30, 140, 10, 20);
        rec3 = new Rectangle(50, 130, 20, 20);

        tri1.setFill(Color.RED);
        rec1.setFill(Color.BLACK);
        rec2.setFill(Color.WHITE);
        rec3.setFill(Color.BLUE);
        p.getChildren().addAll(rec1, rec2, rec3,tri1);

    }
}
