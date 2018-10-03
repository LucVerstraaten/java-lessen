/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les4;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Luc Verstraaten
 */
public class Rechthoeken {

    private Canvas canvas;
    private GraphicsContext gc;

    public Rechthoeken(Pane p) {
        canvas = new Canvas(250, 250);
        gc = canvas.getGraphicsContext2D();
        p.getChildren().addAll(canvas);
        for (int x = 1; x < 11; x++) {
            gc.strokeRect(20, 20, 20 + 2 * x, 20 + 2 * x);
        }

    }
}
