/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package le2;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author kuus
 */
public class pane3 {

    private int secmin = 60;
    private int minuur = 60;
    private int uurdag = 24;
    private int dagjaar = 365;
    private int uitkomst = 0;
    private int leeftijd;
    private final Label labelmin;
    private final Button knop;
    private final TextField text;
    private final Label labeluur;
    private final Label labeldag;
    private final Label labelsec;
    private final Label labelweek;
    private final Label labeljaar;

    public pane3(FlowPane p) {

        labelmin = new Label();
        labeluur = new Label();
        labeldag = new Label();
        labelsec = new Label();
        labelweek = new Label();
        labeljaar = new Label();

        knop = new Button("klik");
        text = new TextField();
        knop.setOnAction(event -> {

            leeftijd = Integer.parseInt(text.getText());

            uitkomst = uurdag * dagjaar;
            uitkomst = uitkomst * leeftijd;
            labelsec.setText("uren in leeftijd" + uitkomst);
            uitkomst = secmin * minuur;
            uitkomst = uitkomst * uurdag;
            uitkomst = uitkomst * dagjaar;
            uitkomst = uitkomst * leeftijd;

            labelmin.setText("seconden in leeftijd: " + uitkomst);
            uitkomst = uurdag * dagjaar;
            uitkomst = uitkomst * leeftijd;
            labeluur.setText("dagen in leeftijd: " + uitkomst);
            uitkomst = minuur * uurdag;
            uitkomst = uitkomst * dagjaar;
            uitkomst = uitkomst * leeftijd;
            labeldag.setText("minuten in leeftijd: " + uitkomst);
            uitkomst = 52 * leeftijd;
            labelweek.setText("weken in leeftijd" + uitkomst);
            labeljaar.setText("jaren in leeftijd" + leeftijd);
        });

        p.getChildren().add(knop);
        p.getChildren().add(text);
        p.getChildren().add(labelmin);
        p.getChildren().add(labeluur);
        p.getChildren().add(labeldag);
        p.getChildren().add(labelsec);
        p.getChildren().add(labelweek);
        p.getChildren().add(labeljaar);

    }
}
