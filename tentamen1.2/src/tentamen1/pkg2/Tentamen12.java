/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tentamen1.pkg2;

import javafx.application.Application;
import javafx.stage.Stage;
import tentamen1.pkg2.Vieuw.MainGui;

/**
 *
 * @author Luc Verstraaten
 */
public class Tentamen12 extends Application {
    
        @Override
    public void start(Stage primaryStage) {
        MainGui main = new MainGui(primaryStage);
  
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
