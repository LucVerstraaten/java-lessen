/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proeftoets;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Luc Verstraaten
 */
public class GuiParkeren {

    private GridPane grid = new GridPane();
    private Parkeerplaatsen park;
    private RadioButton rAuto, rVracht;


    public GuiParkeren(Parkeerplaatsen park) {
        this.park = park;
        final ToggleGroup group = new ToggleGroup();

        rAuto = new RadioButton("Auto");
        rAuto.setToggleGroup(group);
        rAuto.setSelected(true);

        rVracht = new RadioButton("Vrachtwagen");
        rVracht.setToggleGroup(group);

        rAuto.setUserData("Auto");
        rVracht.setUserData("Vrachtwagen");

        rAuto.setOnAction(event -> {
           if(rAuto.isSelected())
           {};

        });
    }

    public GridPane getGrid() {
        return grid;
    }

}
