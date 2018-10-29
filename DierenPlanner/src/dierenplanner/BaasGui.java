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
public class BaasGui {

    private TextField txtId = new TextField(), txtNaam = new TextField(),
            txtTel = new TextField(), txtAdres = new TextField();
    private Text lblId = new Text("Id :"), lblNaam = new Text("Naam :"),
            lblTel = new Text("Telefoonnummer :"), lblAdres = new Text("Adres :");
    private Button opslaan = new Button("Toevoegen");
    private DbConnector connector = new DbConnector();

    // het opbouwen van het gedeelte van de gui voor het toevoegen van Bazen.
    public BaasGui(GridPane p) {
        opslaan.setOnAction(event -> {
            int id = Integer.parseInt(txtId.getText());
            String naam = txtNaam.getText();
            String tele = txtTel.getText();
            String adres = txtAdres.getText();
            String sql = "insert into BAAS values(" + id + ",'" + naam + "','" + tele + "','" + adres + "')";

            int result = connector.executeDML(sql);

        });

        GridPane g = new GridPane();
        g.add(lblId, 0, 0);
        g.add(txtId, 1, 0);
        g.add(lblNaam, 0, 1);
        g.add(txtNaam, 1, 1);
        g.add(lblTel, 0, 2);
        g.add(txtTel, 1, 2);
        g.add(lblAdres, 0, 3);
        g.add(txtAdres, 1, 3);
        g.add(opslaan, 0, 4);
        p.getChildren().add(g);
    }
}
