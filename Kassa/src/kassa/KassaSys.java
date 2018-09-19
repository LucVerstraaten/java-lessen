/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kassa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author Luc Verstraaten
 */
public class KassaSys extends Application {

    private TextField invoer1, invoer2;
    private Button btn1;

    @Override
    public void start(Stage primaryStage) {

        FlowPane root = new FlowPane();
        invoer1 = new TextField();
        invoer2 = new TextField();
        Scene scene = new Scene(root, 300, 250);

        root.getChildren().addAll(invoer1, invoer2, btn1);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
