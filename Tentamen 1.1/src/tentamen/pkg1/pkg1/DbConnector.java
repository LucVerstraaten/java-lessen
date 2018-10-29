/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tentamen.pkg1.pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Luc Verstraaten
 */
public class DbConnector {
    
    public DbConnector() {

    }

    private Connection createConnection() {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String strConnectionString = "jdbc:oracle:thin:@localhost:1521:xe";
            conn = DriverManager.getConnection(strConnectionString, "LUC4", "3Poten32");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return conn;
    }

    // methode om data uit de databse te halen
    public ResultSet getData(String strSQL) {
        ResultSet result = null;
        try {
            Statement stmt = createConnection().createStatement();
            result = stmt.executeQuery(strSQL);
        } catch (Exception e) {

        }
        return result;
    }

    // methode om data naar de database te schrijven.
    public int executeDML(String strSQL) {
        int result = 0;
        try {
            Statement stmt = createConnection().createStatement();
            result = stmt.executeUpdate(strSQL);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
}
