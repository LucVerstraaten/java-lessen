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
public class Flag {
        private final Rectangle rec1, rec2, rec3;
    public Flag(Pane p)
    {
        p.setStyle("-fx-background-color: Bisque;");
        rec1 = new Rectangle(20, 20, 60, 20);
        rec2 = new Rectangle(20, 40, 60, 20);
        rec3 = new Rectangle(20, 60, 60, 20);


        rec1.setFill(Color.BLACK);
        rec2.setFill(Color.WHITE);
        rec3.setFill(Color.BLUE);
        p.getChildren().addAll(rec1, rec2, rec3);
    }
    
}
