/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proeftoets;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Luc Verstraaten
 */
public class MainGui {

    private Button btnAanmelden, btnOverzicht;
    private ArrayList<Voertuig> voertuig = new ArrayList();


    private GridPane grid = new GridPane();
    private Parkeerplaatsen park = new Parkeerplaatsen();
    private GuiParkeren gPark = new GuiParkeren(park);
    private GuiOverzicht gOver = new GuiOverzicht();

    public MainGui(Stage primaryStage) {
        btnAanmelden = new Button("Aanmelden");
        btnOverzicht = new Button("Overzicht");
        btnAanmelden.setOnAction(event -> {
            grid.add(gPark.getGrid(), 1, 0);

        });

        btnOverzicht.setOnAction(event -> {
            //grid.add(gOver.getGrid(), 0, 1);

        });

        grid.add(btnAanmelden, 0, 0);
        grid.add(btnOverzicht, 0, 1);
        grid.add(gPark.getGrid(), 1, 0);
        //stackpane.getChildren().add(imgView);
        primaryStage.setScene(new Scene(grid, 1080, 1920));

        primaryStage.setTitle("Parkeren");
        primaryStage.show();
    }
    
        public ArrayList<Voertuig> getVoertuig() {
        return voertuig;
    }

    public void setVoertuig(ArrayList<Voertuig> voertuig) {
        this.voertuig = voertuig;
    }
}
