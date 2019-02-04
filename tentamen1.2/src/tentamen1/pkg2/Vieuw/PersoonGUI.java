/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tentamen1.pkg2.Vieuw;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import tentamen1.pkg2.Interfaces.AbbonnementInterface;
import tentamen1.pkg2.Model.Abbonement;
import tentamen1.pkg2.Model.PersoonlijkAbbonement;

/**
 *
 * @author Luc Verstraaten
 */
public class PersoonGUI implements AbbonnementInterface {

    private GridPane grid = new GridPane();
    private ArrayList<Abbonement> abbonementen = new ArrayList();
    private Label lbTitel, lbNaam, lbConact, lbIdent, lbError;
    private TextField txtNaam, txtContact, txtIdent;
    private Button btnVerkoop = new Button("Verkoop");
    private TableView tablePer = new TableView();
    private final ObservableList<PersoonlijkAbbonement> dataPer = FXCollections.observableArrayList();

    public PersoonGUI() {
        lbTitel = new Label("Persoonlijk Abbonement");
        lbNaam = new Label("Naam: ");
        lbConact = new Label("Telefoonnummer of email: ");
        lbIdent = new Label("GeboorteDatum: ");
        lbError = new Label();

        txtNaam = new TextField();
        txtContact = new TextField();
        txtIdent = new TextField();

        btnVerkoop.setOnAction(event -> {
            if (txtNaam.getText() != null && !txtNaam.getText().trim().isEmpty()
                    && txtContact.getText() != null && !txtContact.getText().trim().isEmpty()
                    && txtIdent.getText() != null && !txtIdent.getText().trim().isEmpty()) {
                verkoop(txtNaam.getText(), txtContact.getText(), txtIdent.getText());

            } else {
                lbError.setText("Vul de velden in");
            }
            fill_table();
        });

        final Label label = new Label("Overzicht persoonlijke abbonementen");
        label.setFont(new Font("Arial", 20));

        tablePer.setEditable(true);

        TableColumn naamCol = new TableColumn("Naam");
        naamCol.setMinWidth(200);
        naamCol.setCellValueFactory(
                new PropertyValueFactory<PersoonlijkAbbonement, String>("naam"));
        TableColumn gbCol = new TableColumn("Geboortedatum");
        gbCol.setMinWidth(200);
        gbCol.setCellValueFactory(
                new PropertyValueFactory<PersoonlijkAbbonement, String>("geboorteDatum"));
        TableColumn contactCol = new TableColumn("Contact informatie");
        contactCol.setMinWidth(200);
        contactCol.setCellValueFactory(
                new PropertyValueFactory<PersoonlijkAbbonement, String>("contactInformarion"));

        tablePer.getColumns().addAll(naamCol, gbCol, contactCol);

        fill_table();
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, tablePer);

        grid.add(lbTitel, 0, 0);
        grid.add(lbNaam, 0, 1);
        grid.add(lbConact, 0, 2);
        grid.add(lbIdent, 0, 3);
        grid.add(txtNaam, 1, 1);
        grid.add(txtContact, 1, 2);
        grid.add(txtIdent, 1, 3);
        grid.add(btnVerkoop, 1, 4);
        grid.add(lbError, 1, 5);
        grid.add(vbox, 1, 6);

    }

    public GridPane getGrid() {
        return grid;
    }

    @Override
    public void verkoop(String naam, String contact, String ident) {
        abbonementen.add(new PersoonlijkAbbonement(ident, naam, contact));

    }

    public void fill_table() {
        dataPer.clear();
        try {
            for (Abbonement p : abbonementen) {

                if (p instanceof PersoonlijkAbbonement) {
                    PersoonlijkAbbonement per = ((PersoonlijkAbbonement) p);
                    dataPer.add(per);

                }
            }
            tablePer.setItems(dataPer);
        } catch (Exception e) {
            String error = e.getMessage();
            //error
        }

    }
}
