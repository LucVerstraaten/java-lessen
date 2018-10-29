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
public class OpleidingGUI {

    private TextField txtOpleidingsnaam = new TextField(), txtKerndocent = new TextField(),
            txtKerndocentE = new TextField();
    private Text lblOpleidingsnaam = new Text("Opleidings Naam :"), lblKerndocent = new Text("Kerndocent :"),
            lblOpleidingsnaamE = new Text("Opleidings Naam :"), lblKerndocentE = new Text("Kerndocent :"), lblOpleidingsnaamD = new Text("Opleidings Naam: ");
    private Button opslaan = new Button("Toevoegen"), opslaanE = new Button("Oplsaan"), delete = new Button("Delete");
    private DbConnector connector = new DbConnector();
    private ComboBox<Opleiding> cmbOpleiding = new ComboBox(), cmbOpleidingD = new ComboBox();
    private TableView table = new TableView();
    private final ObservableList<Opleiding> data = FXCollections.observableArrayList();

    // het opbouwen van het gedeelte van de gui voor het toevoegen van Bazen.
    public OpleidingGUI(GridPane p) {

        opslaan.setOnAction(event -> {
            int opleidingsNaam = Integer.parseInt(txtOpleidingsnaam.getText());
            String kerndocent = txtKerndocent.getText();
            String sql = "insert into OPLEIDING values(" + opleidingsNaam + ",'" + kerndocent + "')";

            int result = connector.executeDML(sql);
            fill_cmbs();
            fill_table();

            txtOpleidingsnaam.setText("");
            txtKerndocent.setText("");
        });

        opslaanE.setOnAction(event -> {
            int opleidingsNaam = cmbOpleiding.getValue().getOpleidingsnaam();
            String kerndocentE = txtKerndocentE.getText();
            String sql = "UPDATE OPLEIDING SET KERNDOCENT = '" + kerndocentE + "'"
                    + " WHERE OPLEIDINGSNAAM = " + opleidingsNaam + "";

            int result = connector.executeDML(sql);
            fill_cmbs();
            fill_table();

        });

        delete.setOnAction(event -> {
            int OpleidingsNaamD = cmbOpleidingD.getValue().getOpleidingsnaam();
            String sql = "DELETE FROM OPLEIDING  WHERE OPLEIDINGSNAAM =" + OpleidingsNaamD + "";

            int result = connector.executeDML(sql);
            fill_cmbs();
            fill_table();

        });

        cmbOpleiding.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            try {
                txtKerndocentE.setText(newValue.getKerndocent());
            } catch (Exception e) {
                txtKerndocentE.setText("");
            }
        });

        fill_cmbs();
        fill_table();

        //Table
        final Label label = new Label("Opleidingen Rondes");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn opleidingsnaamCol = new TableColumn("Opleidings Naam");
        opleidingsnaamCol.setMinWidth(200);
        opleidingsnaamCol.setCellValueFactory(
                new PropertyValueFactory<Opleiding, String>("opleidingsnaam"));
        TableColumn kerndocentCol = new TableColumn("Kerndocent");
        kerndocentCol.setMinWidth(200);
        kerndocentCol.setCellValueFactory(
                new PropertyValueFactory<Opleiding, String>("kerndocent"));
        table.getColumns().addAll(opleidingsnaamCol, kerndocentCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        GridPane g = new GridPane();
        // aanmaken
        g.add(lblOpleidingsnaam, 0, 0);
        g.add(txtOpleidingsnaam, 1, 0);
        g.add(lblKerndocent, 0, 1);
        g.add(txtKerndocent, 1, 1);
        g.add(opslaan, 0, 2);
        // aanpassen        
        g.add(lblOpleidingsnaamE, 2, 0);
        g.add(cmbOpleiding, 3, 0);
        g.add(lblKerndocentE, 2, 1);
        g.add(txtKerndocentE, 3, 1);
        g.add(opslaanE, 3, 2);
        //Delete
        g.add(lblOpleidingsnaamD, 0, 3);
        g.add(cmbOpleidingD, 1, 3);
        g.add(delete, 1, 4);

        //Overzicht
        g.add(vbox, 3, 5);
        p.getChildren().add(g);
    }

    public void fill_cmbs() {
        cmbOpleiding.getItems().clear();
        cmbOpleidingD.getItems().clear();
        String strSQL = "select * from OPLEIDING";
        ResultSet result = connector.getData(strSQL);
        try {
            while (result.next()) {
                String strOpleidingsnaam = result.getString("OPLEIDINGSNAAM");
                String strKerndocent = result.getString("KERNDOCENT");
                Opleiding opleiding = new Opleiding(Integer.parseInt(strOpleidingsnaam), strKerndocent);
                cmbOpleiding.getItems().addAll(opleiding);
                cmbOpleidingD.getItems().addAll(opleiding);
            }
        } catch (Exception e) {
            String error = e.getMessage();
            //error
        }
    }

    public void fill_table() {
        table.getItems().clear();
        String strSQL = "select * from OPLEIDINg";
        ResultSet result = connector.getData(strSQL);
        try {
            while (result.next()) {
                String strOpleidingsnaam = result.getString("OPLEIDINGSNAAM");
                String strKerndocent = result.getString("KERNDOCENT");
                Opleiding opleiding = new Opleiding(Integer.parseInt(strOpleidingsnaam), strKerndocent);
                data.add(opleiding);
            }
            table.setItems(data);
        } catch (Exception e) {
            String error = e.getMessage();
            //error
        }
    }
}
