/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tentamen1.pkg2.Vieuw;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import tentamen1.pkg2.Model.Abbonement;

/**
 *
 * @author Luc Verstraaten
 */
public class MainGui {

    private FlowPane flow = new FlowPane();
    private FammelieGUI gFam = new FammelieGUI();
    private PersoonGUI gPer = new PersoonGUI();

    public MainGui(Stage primaryStage) {

        flow.getChildren().addAll(gFam.getGrid(),gPer.getGrid());
        primaryStage.setScene(new Scene(flow,1920 , 1080));

        primaryStage.setTitle("Abbonementen");
        primaryStage.show();
    }

    

}
