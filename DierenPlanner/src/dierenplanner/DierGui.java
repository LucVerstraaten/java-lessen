/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dierenplanner;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author Luc Verstraaten
 */
public class DierGui {

    private TextField txtId = new TextField(), txtNaam = new TextField(),
            txtSoort = new TextField(), txtGeboorteDatum = new TextField();
    private Text lblId = new Text("Id :"), lblNaam = new Text("Naam :"),
            lblSoort = new Text("Soort :"), lblGeboorte = new Text("GeboorteDatum :");
    private Button opslaan = new Button("Toevoegen");
    private DbConnector connector = new DbConnector();

    
    // het opbouwen van het gedeelte van de gui voor het toevoegen van dieren.
    public DierGui(GridPane p) {
        opslaan.setOnAction(event -> {
            int id = Integer.parseInt(txtId.getText());
            String naam = txtNaam.getText();
            String soort = txtSoort.getText();
            String geboorte = txtGeboorteDatum.getText();
            String sql = "insert into DIER values(" + id + ",'" + naam + "','" + soort + "','" + geboorte + "')";

            int result = connector.executeDML(sql);

        });

        GridPane g = new GridPane();
        g.add(lblId, 0, 0);
        g.add(txtId, 1, 0);
        g.add(lblNaam, 0, 1);
        g.add(txtNaam, 1, 1);
        g.add(lblSoort, 0, 2);
        g.add(txtSoort, 1, 2);
        g.add(lblGeboorte, 0, 3);
        g.add(txtGeboorteDatum, 1, 3);
        g.add(opslaan, 0, 4);
        p.getChildren().add(g);

    }
}
