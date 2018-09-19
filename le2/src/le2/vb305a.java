/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package le2;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 *
 * @author kuus
 */
public class vb305a {

    private final Button plusknop, productknop, deelknop, restknop, verschilknop, clearknop;
    private final TextField invoervak1, invoervak2, resultaatvak;

    public vb305a(Pane p) {
        plusknop = new Button("+");
        productknop = new Button("*");
        deelknop = new Button("/");
        restknop = new Button("%");
        verschilknop = new Button("verschil");
        clearknop = new Button("clear");
        invoervak1 = new TextField();
        invoervak2 = new TextField();
        resultaatvak = new TextField();

        invoervak1.relocate(20, 20);
        invoervak2.relocate(20, 50);
        plusknop.relocate(20, 80);
        productknop.relocate(40, 80);
        deelknop.relocate(40, 80);
        restknop.relocate(60, 80);
        verschilknop.relocate(80, 80);
        clearknop.relocate(100, 80);
        resultaatvak.relocate(20, 110);

        invoervak1.setAlignment(Pos.CENTER_RIGHT);
        invoervak2.setAlignment(Pos.CENTER_RIGHT);
        resultaatvak.setAlignment(Pos.CENTER_RIGHT);

        plusknop.setOnAction(event
                -> {
            String invoer1 = invoervak1.getText();
            int getal1 = Integer.parseInt(invoer1);
            String invoer2 = invoervak1.getText();
            int getal2 = Integer.parseInt(invoer2);

            int resultaat = getal1 + getal2;
            resultaatvak.setText("" + resultaat);
        });
        productknop.setOnAction(event
                -> {
            String invoer1 = invoervak1.getText();
            int getal1 = Integer.parseInt(invoer1);
            String invoer2 = invoervak1.getText();
            int getal2 = Integer.parseInt(invoer2);

            int resultaat = getal1 * getal2;
            resultaatvak.setText("" + resultaat);
        });

        deelknop.setOnAction(event
                -> {
            String invoer1 = invoervak1.getText();
            int getal1 = Integer.parseInt(invoer1);
            String invoer2 = invoervak1.getText();
            int getal2 = Integer.parseInt(invoer2);

            int resultaat = getal1 / getal2;
            resultaatvak.setText("" + resultaat);
        });
        restknop.setOnAction(event
                -> {
            String invoer1 = invoervak1.getText();
            int getal1 = Integer.parseInt(invoer1);
            String invoer2 = invoervak1.getText();
            int getal2 = Integer.parseInt(invoer2);

            int  resultaat = getal1 % getal2;
            resultaatvak.setText("" + Math.abs( resultaat));
        });
        verschilknop.setOnAction(event
                -> {
            String invoer1 = invoervak1.getText();
            int getal1 = Integer.parseInt(invoer1);
            String invoer2 = invoervak1.getText();
            int getal2 = Integer.parseInt(invoer2);

            int resultaat = getal1 - getal2;
            resultaatvak.setText("" + resultaat);
        });
        clearknop.setOnAction(event
                -> {
            
            invoervak1.clear();
            invoervak2.clear();
            resultaatvak.clear();
        });

        p.getChildren().addAll(invoervak1, invoervak2, plusknop, productknop, resultaatvak);

    }
}
