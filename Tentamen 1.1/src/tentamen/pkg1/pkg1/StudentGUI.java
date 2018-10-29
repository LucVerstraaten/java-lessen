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
public class StudentGUI {

    private TextField txtEmail = new TextField(), txtNaam = new TextField(),
            txtTel = new TextField(), txtNaamE = new TextField(), txtTelE = new TextField();
    private Text lblEmail = new Text("Email :"), lblNaam = new Text("Naam :"),
            lblTel = new Text("Telefoonnummer :"), lblEmailE = new Text("Student mail :"),
            lblNaamE = new Text("Naam :"), lblTelE = new Text("Telefoonnummer :"), lblStmail = new Text("Student mail: ");
    private Button opslaan = new Button("Toevoegen"), opslaanE = new Button("Oplsaan"), delete = new Button("Delete");
    private DbConnector connector = new DbConnector();
    private ComboBox<Student> cmbStudent = new ComboBox(), cmbStudentD = new ComboBox();
    private TableView table = new TableView();
    private final ObservableList<Student> data = FXCollections.observableArrayList();

    // het opbouwen van het gedeelte van de gui voor het toevoegen van Bazen.
    public StudentGUI(GridPane p) {

        opslaan.setOnAction(event -> {
            String email = txtEmail.getText();
            String naam = txtNaam.getText();
            String tele = txtTel.getText();
            String sql = "insert into STUDENT values('" + email + "','" + naam + "','" + tele + "')";

            int result = connector.executeDML(sql);
            fill_cmbs();
            fill_table();

            txtEmail.setText("");
            txtNaam.setText("");
            txtTel.setText("");
        });

        opslaanE.setOnAction(event -> {
            String email = cmbStudent.getValue().getEmail();
            String naamE = txtNaamE.getText();
            String telE = txtTelE.getText();
            String sql = "UPDATE STUDENT SET naam = '" + naamE + "', TELEFONNNUMMER = '" + telE + "'"
                    + " WHERE EMAIL = '" + email + "'";

            int result = connector.executeDML(sql);
            fill_cmbs();
            fill_table();

        });

        delete.setOnAction(event -> {
            String email = cmbStudentD.getValue().getEmail();
            String sql = "DELETE FROM STUDENT  WHERE EMAIL = '" + email + "'";

            int result = connector.executeDML(sql);
            fill_cmbs();
            fill_table();

        });

        cmbStudent.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            try {
                txtNaamE.setText(newValue.getNaam());
                txtTelE.setText(newValue.getTelefoonnummer());
            } catch (Exception e) {
                txtNaamE.setText("");
                txtTelE.setText("");
            }
        });

        fill_cmbs();
        fill_table();

        //Table
        final Label label = new Label("Overzicht Studenten");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Student, String>("email"));
        TableColumn naamCol = new TableColumn("Naam");
        naamCol.setMinWidth(200);
        naamCol.setCellValueFactory(
                new PropertyValueFactory<Student, String>("naam"));
        TableColumn telCol = new TableColumn("Telefoonnummer");
        telCol.setMinWidth(200);
        telCol.setCellValueFactory(
                new PropertyValueFactory<Student, String>("telefoonnummer"));

        table.getColumns().addAll(emailCol, naamCol, telCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        GridPane g = new GridPane();
        // aanmaken
        g.add(lblEmail, 0, 0);
        g.add(txtEmail, 1, 0);
        g.add(lblNaam, 0, 1);
        g.add(txtNaam, 1, 1);
        g.add(lblTel, 0, 2);
        g.add(txtTel, 1, 2);
        g.add(opslaan, 0, 3);
        // aanpassen        
        g.add(lblEmailE, 2, 0);
        g.add(cmbStudent, 3, 0);
        g.add(lblNaamE, 2, 1);
        g.add(txtNaamE, 3, 1);
        g.add(lblTelE, 2, 2);
        g.add(txtTelE, 3, 2);
        g.add(opslaanE, 3, 3);
        //Delete
        g.add(lblStmail, 0, 4);
        g.add(cmbStudentD, 1, 4);
        g.add(delete, 1, 5);

        //Overzicht
        g.add(vbox, 3, 6);
        p.getChildren().add(g);
    }

    public void fill_cmbs() {
        cmbStudent.getItems().clear();
        cmbStudentD.getItems().clear();
        String strSQL = "select * from STUDENT";
        ResultSet result = connector.getData(strSQL);
        try {
            while (result.next()) {
                String strEmail = result.getString("email");
                String strNaam = result.getString("naam");
                String strtel = result.getString("TELEFONNNUMMER");
                Student student = new Student(strEmail, strNaam, strtel);
                cmbStudent.getItems().addAll(student);
                cmbStudentD.getItems().addAll(student);
            }
        } catch (Exception e) {
            String error = e.getMessage();
            //error
        }
    }

    public void fill_table() {
        table.getItems().clear();
        String strSQL = "select * from STUDENT";
        ResultSet result = connector.getData(strSQL);
        try {
            while (result.next()) {
                String strEmail = result.getString("email");
                String strNaam = result.getString("naam");
                String strtel = result.getString("TELEFONNNUMMER");
                Student student = new Student(strEmail, strNaam, strtel);
                data.add(student);
            }
            table.setItems(data);
        } catch (Exception e) {
            String error = e.getMessage();
            //error
        }
    }
}
