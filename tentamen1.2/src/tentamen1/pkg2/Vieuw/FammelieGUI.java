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
import tentamen1.pkg2.Model.FamilieAbbonement;
import tentamen1.pkg2.Model.PersoonlijkAbbonement;

/**
 *
 * @author Luc Verstraaten
 */
public class FammelieGUI implements AbbonnementInterface {

    private GridPane grid = new GridPane();
    private ArrayList<Abbonement> abbonementen = new ArrayList();
    private Label lbTitel, lbNaam, lbConact, lbIdent, lbError;
    private TextField txtNaam, txtContact, txtIdent;
    private Button btnVerkoop = new Button("Verkoop");
    private TableView tableFam = new TableView();
    private final ObservableList<FamilieAbbonement> dataFam = FXCollections.observableArrayList();

    public FammelieGUI() {
        lbTitel = new Label("Familie Abbonement");
        lbNaam = new Label("Familie Naam: ");
        lbConact = new Label("Telefoonnummer of email: ");
        lbIdent = new Label("Aantal personen");
        lbError = new Label();

        txtNaam = new TextField();
        txtContact = new TextField();
        txtIdent = new TextField();

        btnVerkoop.setOnAction(event -> {
            if (txtNaam.getText() != null && !txtNaam.getText().trim().isEmpty()
                    && txtContact.getText() != null && !txtContact.getText().trim().isEmpty()
                    && txtIdent.getText() != null && !txtIdent.getText().trim().isEmpty()) {
                try {

                    verkoop(txtNaam.getText(), txtContact.getText(), txtIdent.getText());

                } catch (Exception e) {
                    /**
                     *
                     * hier wordt afgevangen of er daadwerkelijk een nummer is
                     * ingevoerd
                     */
                    lbError.setText("Vul een nummer bij aantal personen in");
                }
            } else {
                /**
                 *
                 * hier wordt afgevangen of alle velden zijn in gevoerd
                 *
                 */
                lbError.setText("Vul de velden in");
            }
            fill_table();
        });

        final Label label = new Label("Overzicht Familie Abbonementen");
        label.setFont(new Font("Arial", 20));

        tableFam.setEditable(true);

        TableColumn naamCol = new TableColumn("Naam");
        naamCol.setMinWidth(200);
        naamCol.setCellValueFactory(
                new PropertyValueFactory<FamilieAbbonement, String>("naam"));
        TableColumn persCol = new TableColumn("Aantal personen");
        persCol.setMinWidth(200);
        persCol.setCellValueFactory(
                new PropertyValueFactory<FamilieAbbonement, String>("aantalPersonen"));
        TableColumn contactCol = new TableColumn("Contact informatie");
        contactCol.setMinWidth(200);
        contactCol.setCellValueFactory(
                new PropertyValueFactory<FamilieAbbonement, String>("contactInformarion"));

        tableFam.getColumns().addAll(naamCol, persCol, contactCol);

        fill_table();
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, tableFam);

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
        String invoer = ident;
        Double invoerGetal = Double.parseDouble(invoer);
        abbonementen.add(new FamilieAbbonement(invoerGetal.intValue(), naam, contact));
    }

    public void fill_table() {
        dataFam.clear();
        try {

            for (Abbonement f : abbonementen) {

                if (f instanceof FamilieAbbonement) {
                    FamilieAbbonement fam = ((FamilieAbbonement) f);
                    dataFam.add(fam);

                }

            }
            tableFam.setItems(dataFam);
        } catch (Exception e) {
            /**
             *
             * mocht er iets fout gaan bij het genereren van het overzicht wordt
             * er hier voor gezorgt dat de rest van het programma blijft werken
             *
             */
            String error = e.getMessage();
            //error
        }

    }
}
