/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxvb0201;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author kuus
 */
public class FXVb0201 extends Application 
{
    
    @Override
    public void start(Stage primaryStage) 
    {
      FlowPane root = new FlowPane();
      Scene scene = new Scene(root, 600, 600);
      
      new Vb0202(root);
      
      primaryStage.setScene(scene);
      primaryStage.setTitle("Eerste App");
      primaryStage.setFullScreen(true);
      primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
