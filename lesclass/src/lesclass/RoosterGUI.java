/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesclass;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author Luc Verstraaten
 */
public class RoosterGUI {

    public RoosterGUI(Stage primaryStage) {
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root, 600, 600);

        LesRooster lesr = new LesRooster();

        TextArea taRooster = new TextArea();
        taRooster.setMaxHeight(200);
        taRooster.setMaxWidth(200);
        Button knopje = new Button("Opslaan");
        knopje.setOnAction(e
                -> {

            lesr.addLes(new Les(new Tijdstip("17", "maandag"), new Vak("programeren"), "mb01"));
            lesr.addLes(new Les(new Tijdstip("17", "maandag"), new Vak("programeren"), "mb01"));
            lesr.addLes(new Les(new Tijdstip("17", "maandag"), new Vak("programeren"), "mb01"));
            lesr.print();
            lesr.printText(taRooster);

        });

        root.getChildren().add(taRooster);
        root.getChildren().add(knopje);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Rooster app");
        primaryStage.show();

    }

}
