package unisa.gps.etour.repository;

import Java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import unisa.gps.etour.bean.BeanOperatorePuntoDiRistoro;

/**
 * Class that implements the interface Operator Refreshment
 *
 * @Author Joseph Martone
 * @Version 0.1 2007 eTour Project - Copyright by SE @SA Lab DMI University
 * Of Salerno
 */
public class DBOperatorePuntoDiRistoro implements IDBOperatorePuntoDiRistoro {
    // Empty constructor
    public DBOperatorePuntoDiRistoro() {

    }

    public boolean cancellaOperatorePuntoDiRistoro(int pIdOperatore)
            throws SQLException {
        // Variables for database connection
        Connection conn = null;
        // Variable for the query
        Statement stat = null;
        try {
            // Get connection
            conn = DBConnessionePool.ottieniConnessione();
            // Create the Statement
            stat = conn.createStatement();
            // Query cancellation
            String query = "DELETE FROM operatorepuntodiristoro WHERE Id ="
                    + pIdOperatore;
            // You run the query Cancellation
            int i = stat.executeUpdate(query);
            // This returns the backup
            return (i == 1);
        }
        // Always runs and takes care of closing the Statement and the
        // Connect
        finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                DBConnessionePool.rilasciaConnessione(conn);
            }
        }
    }

    public boolean inserisciOperatorePuntoDiRistoro(
            BeanOperatorePuntoDiRistoro pOperatore) throws SQLException {
        // Variables for database connection
        Connection conn = null;
        // Variable for the query
        Statement stat = null;
        // Variable for the query results
        ResultSet unico = null;
        try {
            // Get the connection
            conn = DBConnessionePool.ottieniConnessione();
            // Create the Statement
            stat = conn.createStatement();
            // Query for the insertion
            String query = "INSERT INTO operatorepuntodiristoro (Name, Surname,"
                    + "Username, Password, Email, IdPuntoDiRistoro) VALUES ('"
                    + pOperatore.getNome() + "','" + pOperatore.getCognome()
                    + "','" + pOperatore.getUsername() + "','"
                    + pOperatore.getPassword() + "','" + pOperatore.getEmail()
                    + "'," + pOperatore.getIdPuntoDiRistoro() + ")";
            // Query for checking the ID of the PuntoDiRistoro as
            // The association is 1 to 1 between OPPR and PR
            String shops = "SELECT IdPuntoDiRistoro FROM operatorepuntodiristoro WHERE IdPuntoDiRistoro ="
                    + pOperatore.getIdPuntoDiRistoro();
            // Execute the query to control
            unico = stat.executeQuery(shops);
            int j = 0;
            // Check if there are tuples
            while (unico.next())
                j++;
            // If it is empty
            if (j == 0) {
                // You run the insert query
                int i = stat.executeUpdate(query);
                // This returns the backup
                System.out.println("If you include the PR");
                return (i == 1);
            }
            // If not already exist
            else {
                System.out.println("Operator PR already exists for the PR");
                return false;
            }
        }
        // Always runs and takes care of closing the Statement and the
        // Connect
        finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                DBConnessionePool.rilasciaConnessione(conn);
            }
            if (unico != null) {
                unico.close();
            }
        }
    }

    public boolean modificaOperatorePuntoDiRistoro(
            BeanOperatorePuntoDiRistoro pOperatore) throws SQLException {
        // Variables for database connection
        Connection conn = null;
        // Variable for the query
        Statement stat = null;
        try {
            // Get the connection
            conn = DBConnessionePool.ottieniConnessione();
            // Create the Statement
            stat = conn.createStatement();
            // Query for amendment
            String query = "UPDATE operatorepuntodiristoro SET" + "Name = '"
                    + pOperatore.getNome() + "', Name ='"
                    + pOperatore.getCognome() + "', password ='"
                    + pOperatore.getPassword() + "', Email ='"
                    + pOperatore.getEmail() + "' WHERE IdPuntoDiRistoro ="
                    + pOperatore.getIdPuntoDiRistoro();
            // You run the query for Change
            int i = stat.executeUpdate(query);
            // This returns the backup
            return (i == 1);
        }
        // Always runs and takes care of closing the Statement and the
        // Connect
        finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                DBConnessionePool.rilasciaConnessione(conn);
            }
        }
    }

    public BeanOperatorePuntoDiRistoro ottieniOperatorePuntoDiRistoro(
            int pIdOperatore) throws SQLException {

        // Variables for database connection
        Connection conn = null;
        // Variable for the query
        Statement stat = null;
        // Variable for the query results
        ResultSet result = null;
        try {
            // Get the connection
            conn = DBConnessionePool.ottieniConnessione();
            // Create the Statement
            stat = conn.createStatement();
            // Query for the extraction of the dot Refreshments required
            String query = "SELECT * FROM WHERE id = operatorepuntodiristoro"
                    + pIdOperatore;
            // The query is executed
            result = stat.executeQuery(query);
            // Get the bean Operator refreshment passing the id
            BeanOperatorePuntoDiRistoro beanTemp = null;
            if (result.next()) {
                // Built on BeanOPR
                beanTemp = new BeanOperatorePuntoDiRistoro(result.getInt("Id"),
                        result.getString("Name"), result.getString("Name"),
                        result.getString("Username"), result
                                .getString("Password"), result
                                .getString("Email"), result
                                .getInt("IdPuntoDiRistoro"));
            }
            return beanTemp;
        }
        // Exception if there is an error
        catch (Exception e) {
            throw new SQLException();
        }
        // Always runs and takes care to close the Result, the Statement
        // And Connection
        finally {
            if (result != null) {
                result.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                DBConnessionePool.rilasciaConnessione(conn);
            }
        }
    }
}