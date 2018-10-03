/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les4;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Luc Verstraaten
 */
public class Rechthoeken2 {

    private Label lb;
    private TextField txtInvoer;
    private Canvas canvas;
    private GraphicsContext gc;
    private HBox hbox;
    private int aantal;

    public Rechthoeken2(VBox p) {
        lb = new Label("aantal Rechthoeken:");
        txtInvoer = new TextField();
        txtInvoer.setAlignment(Pos.CENTER_RIGHT);
        txtInvoer.setPrefWidth(40);

        hbox = new HBox();
        hbox.setAlignment(Pos.BASELINE_CENTER);
        hbox.getChildren().addAll(lb, txtInvoer);

        canvas = new Canvas(250, 250);
        gc = canvas.getGraphicsContext2D();
        p.getChildren().addAll(hbox, canvas);
        txtInvoer.setOnAction(event -> {
            String invoer = txtInvoer.getText();
            aantal = Integer.parseInt(invoer);
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            for (int x = 1; x < aantal; x++) {
                gc.strokeRect(20, 20, 20 + 2 * x, 20 + 2 * x);
            }
        });

    }
}
