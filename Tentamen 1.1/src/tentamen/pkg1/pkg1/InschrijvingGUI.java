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
public class InschrijvingGUI {

    private Text lbStudentmail = new Text("Student :"), lbVoorlichtingsronde = new Text("Voorlichtings ronde :"),
            lblOpleidingsnaam = new Text("Opleidings Naam :"),
            lblInschrijvingE = new Text("Inschrijving :"), lbStudentmailE = new Text("Student :"),
            lbVoorlichtingsrondeE = new Text("Voorlichtings ronde : "), lblOpleidingsnaamE = new Text("Opleidings Naam : "),
            lblInschrijvingD = new Text("Inschrijving :"), lblAlert = new Text(""), lblAlertE = new Text("");
    private Button opslaan = new Button("Toevoegen"), opslaanE = new Button("Oplsaan"), delete = new Button("Delete");
    private DbConnector connector = new DbConnector();
    private ComboBox<Student> cmbStudent = new ComboBox(), cmbStudentE = new ComboBox();
    private ComboBox<Opleiding> cmbOpleiding = new ComboBox(), cmbOpleidingE = new ComboBox();
    private ComboBox<Voorlichtingsmoment> cmbVoorlichtingsmoment = new ComboBox(), cmbVoorlichtingsmomentE = new ComboBox();
    private ComboBox<Inschrijving> cmbInschrijvingE = new ComboBox(), cmbInschrijvingD = new ComboBox();
    private TableView table = new TableView();
    private final ObservableList<Inschrijving> data = FXCollections.observableArrayList();
    private Boolean mag = true;

    public InschrijvingGUI(GridPane p) {
        opslaan.setOnAction(event -> {
            String studentmail = cmbStudent.getValue().getEmail();
            int voorlischtingsmomentronde = cmbVoorlichtingsmoment.getValue().getRonde();
            int opleidingsnaam = cmbOpleiding.getValue().getOpleidingsnaam();
            String sql = "select * from INSCHRIJVING";
            ResultSet result = connector.getData(sql);
            try {
                while (result.next()) {
                    String strEmail = result.getString("STUDENTEMAIL");
                    String strVoorlischtingsmomentronde = result.getString("VOORLICHTINGSMOMENTRONDE");
                    if (studentmail == strEmail || voorlischtingsmomentronde == Integer.parseInt(strVoorlischtingsmomentronde) || !mag) {
                        mag = false;
                    }
                }
            } catch (Exception e) {
                String error = e.getMessage();
                //error
            }

            if (mag) {
                sql = "insert into INSCHRIJVING values('" + studentmail + "'," + voorlischtingsmomentronde + "," + opleidingsnaam + ")";
            } else {
                lblAlert.setText("Deze Handeling mag niet");
            }
            int resulti = connector.executeDML(sql);
            mag = true;
            fill_cmbs();
            fill_table();
        });

        opslaanE.setOnAction(event -> {
            String studentmail = cmbInschrijvingE.getValue().getStudent().getEmail();
            int voorlischtingsmomentronde = cmbInschrijvingE.getValue().getVoorlichtingsmoment().getRonde();
            String studentmailE = cmbStudentE.getValue().getEmail();
            int voorlischtingsmomentrondeE = cmbVoorlichtingsmomentE.getValue().getRonde();
            int opleidingsnaam = cmbOpleidingE.getValue().getOpleidingsnaam();
            String sql = "select * from INSCHRIJVING";
            ResultSet result = connector.getData(sql);
            try {
                while (result.next()) {
                    String strEmail = result.getString("STUDENTEMAIL");
                    String strVoorlischtingsmomentronde = result.getString("VOORLICHTINGSMOMENTRONDE");
                    if (studentmail == strEmail || voorlischtingsmomentronde == Integer.parseInt(strVoorlischtingsmomentronde) || !mag) {
                        mag = false;
                    }
                }
            } catch (Exception e) {
                String error = e.getMessage();
                //error
            }

            if (mag) {
                sql = "UPDATE INSCHRIJVING SET STUDENTEMAIL = '" + studentmailE + "', VOORLICHTINGSMOMENTRONDE = " + voorlischtingsmomentrondeE + ", OPLEIDINGOPLEIDINGSNAAM = " + opleidingsnaam
                        + "WHERE STUDENTEMAIL = '" + studentmail + "' AND VOORLICHTINGSMOMENTRONDE =" + voorlischtingsmomentronde + "";
            } else {
                lblAlertE.setText("Deze Handeling mag niet");
            }
            int resulti = connector.executeDML(sql);
            mag = true;

            fill_cmbs();
            fill_table();

        });

        delete.setOnAction(event -> {
            String studentmail = cmbInschrijvingD.getValue().getStudent().getEmail();
            int voorlischtingsmomentronde = cmbInschrijvingD.getValue().getVoorlichtingsmoment().getRonde();
            String sql = "DELETE FROM INSCHRIJVING  WHERE STUDENTEMAIL = '" + studentmail + "' AND VOORLICHTINGSMOMENTRONDE =" + voorlischtingsmomentronde + "";

            int result = connector.executeDML(sql);
            fill_cmbs();
            fill_table();

        });

        cmbInschrijvingE.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            try {
                cmbStudentE.setValue(newValue.getStudent());
                cmbVoorlichtingsmomentE.setValue(newValue.getVoorlichtingsmoment());
                cmbOpleidingE.setValue(newValue.getOpleiding());
            } catch (Exception e) {

            }
        });

        fill_cmbs();
        fill_table();

        //Table
        final Label label = new Label("Overzicht Patienten");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn emailCol = new TableColumn("Email Student");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Inschrijving, String>("student"));
        TableColumn rondeCol = new TableColumn("Ronde");
        rondeCol.setMinWidth(200);
        rondeCol.setCellValueFactory(
                new PropertyValueFactory<Inschrijving, String>("voorlichtingsmoment"));
        TableColumn opleidingsnaamCol = new TableColumn("Opleidings Naam");
        opleidingsnaamCol.setMinWidth(200);
        opleidingsnaamCol.setCellValueFactory(
                new PropertyValueFactory<Inschrijving, String>("opleiding"));

        table.getColumns().addAll(emailCol, rondeCol, opleidingsnaamCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        GridPane g = new GridPane();
        // aanmaken
        g.add(lbStudentmail, 0, 0);
        g.add(cmbStudent, 1, 0);
        g.add(lbVoorlichtingsronde, 0, 1);
        g.add(cmbVoorlichtingsmoment, 1, 1);
        g.add(lblOpleidingsnaam, 0, 2);
        g.add(cmbOpleiding, 1, 2);
        g.add(opslaan, 0, 3);
        g.add(lblAlert, 0, 4);
        // aanpassen        
        g.add(lblInschrijvingE, 2, 0);
        g.add(cmbInschrijvingE, 3, 0);
        g.add(lbStudentmailE, 2, 1);
        g.add(cmbStudentE, 3, 1);
        g.add(lbVoorlichtingsrondeE, 2, 2);
        g.add(cmbVoorlichtingsmomentE, 3, 2);
        g.add(lblOpleidingsnaamE, 2, 3);
        g.add(cmbOpleidingE, 3, 3);
        g.add(opslaanE, 3, 4);
        g.add(lblAlertE, 3, 5);
        //Delete
        g.add(lblInschrijvingD, 0, 5);
        g.add(cmbInschrijvingD, 1, 5);
        g.add(delete, 0, 6);

        //Overzicht
        g.add(vbox, 3, 7);
        p.getChildren().add(g);
    }

    public void fill_cmbs() {
        cmbStudent.getItems().clear();
        cmbStudentE.getItems().clear();
        String strSQL = "select * from STUDENT";
        ResultSet result = connector.getData(strSQL);
        try {
            while (result.next()) {
                String strEmail = result.getString("email");
                String strNaam = result.getString("naam");
                String strtel = result.getString("TELEFONNNUMMER");
                Student student = new Student(strEmail, strNaam, strtel);
                cmbStudent.getItems().addAll(student);
                cmbStudentE.getItems().addAll(student);
            }
        } catch (Exception e) {
            String error = e.getMessage();
            //error
        }

        cmbVoorlichtingsmoment.getItems().clear();
        cmbVoorlichtingsmomentE.getItems().clear();
        strSQL = "select * from VOORLICHTINGSMOMENT";
        result = connector.getData(strSQL);
        try {
            while (result.next()) {
                String strRonde = result.getString("ronde");
                String strOmschrijving = result.getString("OMSCHRIJVING");
                Voorlichtingsmoment voorlichtingsmoment = new Voorlichtingsmoment(Integer.parseInt(strRonde), strOmschrijving);
                cmbVoorlichtingsmoment.getItems().addAll(voorlichtingsmoment);
                cmbVoorlichtingsmomentE.getItems().addAll(voorlichtingsmoment);
            }
        } catch (Exception e) {
            String error = e.getMessage();
            //error
        }

        cmbOpleiding.getItems().clear();
        cmbOpleidingE.getItems().clear();
        strSQL = "select * from OPLEIDING";
        result = connector.getData(strSQL);
        try {
            while (result.next()) {
                String strOpleidingsnaam = result.getString("OPLEIDINGSNAAM");
                String strKerndocent = result.getString("KERNDOCENT");
                Opleiding opleiding = new Opleiding(Integer.parseInt(strOpleidingsnaam), strKerndocent);
                cmbOpleiding.getItems().addAll(opleiding);
                cmbOpleidingE.getItems().addAll(opleiding);
            }
        } catch (Exception e) {
            String error = e.getMessage();
            //error
        }

        cmbInschrijvingE.getItems().clear();
        cmbInschrijvingD.getItems().clear();
        strSQL = "SELECT *"
                + "FROM INSCHRIJVING i JOIN STUDENT s ON (i.STUDENTEMAIL = s.EMAIL)"
                + "JOIN VOORLICHTINGSMOMENT v ON (i.VOORLICHTINGSMOMENTRONDE = v.RONDE)"
                + "JOIN OPLEIDING o ON (i.OPLEIDINGOPLEIDINGSNAAM = o.OPLEIDINGSNAAM)";
        result = connector.getData(strSQL);
        try {
            while (result.next()) {
                String strEmail = result.getString("email");
                String strNaam = result.getString("naam");
                String strtel = result.getString("TELEFONNNUMMER");
                Student student = new Student(strEmail, strNaam, strtel);
                String strRonde = result.getString("ronde");
                String strOmschrijving = result.getString("OMSCHRIJVING");
                Voorlichtingsmoment voorlichtingsmoment = new Voorlichtingsmoment(Integer.parseInt(strRonde), strOmschrijving);
                String strOpleidingsnaam = result.getString("OPLEIDINGSNAAM");
                String strKerndocent = result.getString("KERNDOCENT");
                Opleiding opleiding = new Opleiding(Integer.parseInt(strOpleidingsnaam), strKerndocent);
                Inschrijving inschrijving = new Inschrijving(student, voorlichtingsmoment, opleiding);
                cmbInschrijvingE.getItems().addAll(inschrijving);
                cmbInschrijvingD.getItems().addAll(inschrijving);
            }
        } catch (Exception e) {
            String error = e.getMessage();
            //error
        }
    }

    public void fill_table() {
        table.getItems().clear();
        String strSQL = "SELECT *"
                + "FROM INSCHRIJVING i JOIN STUDENT s ON (i.STUDENTEMAIL = s.EMAIL)"
                + "JOIN VOORLICHTINGSMOMENT v ON (i.VOORLICHTINGSMOMENTRONDE = v.RONDE)"
                + "JOIN OPLEIDING o ON (i.OPLEIDINGOPLEIDINGSNAAM = o.OPLEIDINGSNAAM)";
        ResultSet result = connector.getData(strSQL);
        try {
            while (result.next()) {
                String strEmail = result.getString("email");
                String strNaam = result.getString("naam");
                String strtel = result.getString("TELEFONNNUMMER");
                Student student = new Student(strEmail, strNaam, strtel);
                String strRonde = result.getString("ronde");
                String strOmschrijving = result.getString("OMSCHRIJVING");
                Voorlichtingsmoment voorlichtingsmoment = new Voorlichtingsmoment(Integer.parseInt(strRonde), strOmschrijving);
                String strOpleidingsnaam = result.getString("OPLEIDINGSNAAM");
                String strKerndocent = result.getString("KERNDOCENT");
                Opleiding opleiding = new Opleiding(Integer.parseInt(strOpleidingsnaam), strKerndocent);
                Inschrijving inschrijving = new Inschrijving(student, voorlichtingsmoment, opleiding);
                data.add(inschrijving);
            }
            table.setItems(data);
        } catch (Exception e) {
            String error = e.getMessage();
            //error
        }
    }
}
