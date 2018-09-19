/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package le2;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author kuus
 */
public class Le2 extends Application 
{
    
    @Override
    public void start(Stage primaryStage) 
    {
      Pane root = new Pane();
      Scene scene = new Scene(root, 300, 450);
      
      new huis(root);
      
      primaryStage.setScene(scene);
      primaryStage.setTitle("les2 App");
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
