/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dierenplanner;

import java.sql.ResultSet;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author Luc Verstraaten
 */
public class AfspraakGui {

    private TextField txtId = new TextField(), txtDatum = new TextField(),
            txtSoort = new TextField();
    private Text lblId = new Text("Id :"), lblDatum = new Text("Datum :"),
            lblSoort = new Text("Soort :"), lblDier = new Text("Dier :"),
            lblBaas = new Text("Baas :"), lblAlert=new Text("");
    private Button opslaan = new Button("Toevoegen");
    private ComboBox<Dier> cmbDier = new ComboBox();
    private ComboBox<Baas> cmbBaas = new ComboBox();
    private DbConnector connector = new DbConnector();

    // het opbouwen van het gedeelte van de gui voor het toevoegen van Afspraken.
    public AfspraakGui(GridPane p) {

        String strSQL = "select * from DIER";
        ResultSet result = connector.getData(strSQL);
        try {
            while (result.next()) {
                String strId = result.getString("id");
                String strNaam = result.getString("naam");
                String strSoort = result.getString("soort");
                String strGeboorte = result.getString("geboortedatum");
                Dier dier = new Dier(Integer.parseInt(strId), strNaam, strSoort, strGeboorte);
                cmbDier.getItems().addAll(dier);
            }
        } catch (Exception e) {
            String error = e.getMessage();
            //error
        }
        strSQL = "select * from BAAS";
        result = connector.getData(strSQL);
        try {
            while (result.next()) {
                String strId = result.getString("id");
                String strNaam = result.getString("naam");
                String strTel = result.getString("telefoonnummer");
                String strAdres = result.getString("adres");
                Baas baas = new Baas(Integer.parseInt(strId), strNaam, strTel, strAdres);
                cmbBaas.getItems().addAll(baas);
            }
        } catch (Exception e) {
            String error = e.getMessage();
            //error
        }

        opslaan.setOnAction(event -> {
            int id = Integer.parseInt(txtId.getText());
            String datum = txtDatum.getText();
            String soort = txtSoort.getText();
            int dID = cmbDier.getValue().getId();
            int bID = cmbBaas.getValue().getId();
            String sql = "insert into AFSPRAAK values(" + id + ",'" + datum + "','" + soort + "'," + dID + "," + bID + ")";

            int result2 = connector.executeDML(sql);
            lblAlert.setText("het is gedaan");

        });

        GridPane g = new GridPane();
        g.add(lblId, 0, 0);
        g.add(txtId, 1, 0);
        g.add(lblDatum, 0, 1);
        g.add(txtDatum, 1, 1);
        g.add(lblSoort, 0, 2);
        g.add(txtSoort, 1, 2);
        g.add(lblDier, 0, 3);
        g.add(cmbDier, 1, 3);
        g.add(lblBaas, 0, 4);
        g.add(cmbBaas, 1, 4);
        g.add(opslaan, 0, 5);
        g.add(lblAlert,1,5);
        p.getChildren().add(g);

    }
}
