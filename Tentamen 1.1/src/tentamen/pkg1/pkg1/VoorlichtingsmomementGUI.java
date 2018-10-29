/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tentamen.pkg1.pkg1;

import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Luc Verstraaten
 */
public class VoorlichtingsmomementGUI {

    private TextField txtRonde = new TextField(), txtOmschrijving = new TextField(),
            txtOmschrijvingE = new TextField();
    private Text lblRonde = new Text("Ronde :"), lblNaam = new Text("Omschrijving :"),
            lblRondeE = new Text("Ronde :"), lblOmschrijvingE = new Text("Omschrijving :"), lblRondeD = new Text("Ronde: ");
    private Button opslaan = new Button("Toevoegen"), opslaanE = new Button("Oplsaan"), delete = new Button("Delete");
    private DbConnector connector = new DbConnector();
    private ComboBox<Voorlichtingsmoment> cmbVoorlichtingsmoment = new ComboBox(), cmbVoorlichtingsmomentD = new ComboBox();
    private TableView table = new TableView();
    private final ObservableList<Voorlichtingsmoment> data = FXCollections.observableArrayList();

    // het opbouwen van het gedeelte van de gui voor het toevoegen van Bazen.
    public VoorlichtingsmomementGUI(GridPane p) {

        opslaan.setOnAction(event -> {
            int ronde = Integer.parseInt(txtRonde.getText());
            String omschrijving = txtOmschrijving.getText();
            String sql = "insert into VOORLICHTINGSMOMENT values(" + ronde + ",'" + omschrijving + "')";

            int result = connector.executeDML(sql);
            fill_cmbs();
            fill_table();

            txtRonde.setText("");
            txtOmschrijving.setText("");
        });

        opslaanE.setOnAction(event -> {
            int ronde = cmbVoorlichtingsmoment.getValue().getRonde();
            String omschrijvingE = txtOmschrijvingE.getText();
            String sql = "UPDATE VOORLICHTINGSMOMENT SET OMSCHRIJVING = '" + omschrijvingE + "'"
                    + " WHERE RONDE = " + ronde + "";

            int result = connector.executeDML(sql);
            fill_cmbs();
            fill_table();

        });

        delete.setOnAction(event -> {
            int rondeD = cmbVoorlichtingsmomentD.getValue().getRonde();
            String sql = "DELETE FROM VOORLICHTINGSMOMENT  WHERE RONDE =" + rondeD + "";

            int result = connector.executeDML(sql);
            fill_cmbs();
            fill_table();

        });

        cmbVoorlichtingsmoment.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            try {
                txtOmschrijvingE.setText(newValue.getOmschrijving());
            } catch (Exception e) {
                txtOmschrijvingE.setText("");
            }
        });

        fill_cmbs();
        fill_table();

        //Table
        final Label label = new Label("Overzicht Rondes");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn rondeCol = new TableColumn("Ronde");
        rondeCol.setMinWidth(200);
        rondeCol.setCellValueFactory(
                new PropertyValueFactory<Voorlichtingsmoment, String>("ronde"));
        TableColumn omschrijvingCol = new TableColumn("Omschrijving");
        omschrijvingCol.setMinWidth(200);
        omschrijvingCol.setCellValueFactory(
                new PropertyValueFactory<Voorlichtingsmoment, String>("omschrijving"));
        table.getColumns().addAll(rondeCol, omschrijvingCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        GridPane g = new GridPane();
        // aanmaken
        g.add(lblRonde, 0, 0);
        g.add(txtRonde, 1, 0);
        g.add(lblNaam, 0, 1);
        g.add(txtOmschrijving, 1, 1);
        g.add(opslaan, 0, 2);
        // aanpassen        
        g.add(lblRondeE, 2, 0);
        g.add(cmbVoorlichtingsmoment, 3, 0);
        g.add(lblOmschrijvingE, 2, 1);
        g.add(txtOmschrijvingE, 3, 1);
        g.add(opslaanE, 3, 2);
        //Delete
        g.add(lblRondeD, 0, 3);
        g.add(cmbVoorlichtingsmomentD, 1, 3);
        g.add(delete, 1, 4);

        //Overzicht
        g.add(vbox, 3, 5);
        p.getChildren().add(g);
    }

    public void fill_cmbs() {
        cmbVoorlichtingsmoment.getItems().clear();
        cmbVoorlichtingsmomentD.getItems().clear();
        String strSQL = "select * from VOORLICHTINGSMOMENT";
        ResultSet result = connector.getData(strSQL);
        try {
            while (result.next()) {
                String strRonde = result.getString("ronde");
                String strOmschrijving = result.getString("OMSCHRIJVING");
                Voorlichtingsmoment voorlichtingsmoment = new Voorlichtingsmoment(Integer.parseInt(strRonde), strOmschrijving);
                cmbVoorlichtingsmoment.getItems().addAll(voorlichtingsmoment);
                cmbVoorlichtingsmomentD.getItems().addAll(voorlichtingsmoment);
            }
        } catch (Exception e) {
            String error = e.getMessage();
            //error
        }
    }

    public void fill_table() {
        table.getItems().clear();
        String strSQL = "select * from VOORLICHTINGSMOMENT";
        ResultSet result = connector.getData(strSQL);
        try {
            while (result.next()) {
                String strRonde = result.getString("ronde");
                String strOmschrijving = result.getString("OMSCHRIJVING");
                Voorlichtingsmoment voorlichtingsmoment = new Voorlichtingsmoment(Integer.parseInt(strRonde), strOmschrijving);
                data.add(voorlichtingsmoment);
            }
            table.setItems(data);
        } catch (Exception e) {
            String error = e.getMessage();
            //error
        }
    }
}
