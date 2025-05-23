package unisa.gps.etour.control.GestioneTag;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import unisa.gps.etour.bean.BeanTag;
/*
 * For imported text unisa.gps.etour.control.GestioneTag.test.stub.DBTag;
 */
import unisa.gps.etour.repository.DBTag;
import unisa.gps.etour.repository.IDBTag;
import unisa.gps.etour.util.MessaggiErrore;

/**
 * Class that implements the common tasks for the use of tags
 *
 * @Author Joseph Morelli
 * @Version 0.1 2007 eTour Project - Copyright by SE @ SA Lab DMI University
 * Of Salerno
 */
public class GestioneTagComune extends UnicastRemoteObject implements IGestioneTagComune {

    private static final long serialVersionUID = 1L;
    // Object for the database connection
    protected IDBTag tags;

    public GestioneTagComune() throws RemoteException {
        super();
        // Connect to the Database
        try {
            tag = new DBTag();
        }
        catch (Exception e) {
            throw new RemoteException(MessaggiErrore.ERRORE_SCONOSCIUTO);
        }
    }

    // Method that returns all tags
    public ArrayList<BeanTag> ottieniTags() throws RemoteException {
        // ArrayList to fill with the tags to return
        ArrayList<BeanTag> toReturn;
        // Retrieve data from Database
        try {
            // Get the information from the Database
            toReturn = tag.ottieniListaTag();
        }
        // Exception in the execution of database operations
        catch (SQLException e) {
            System.out.println("Error in method ottieniTags:" + e.toString());
            throw new RemoteException(MessaggiErrore.ERRORE_DBMS);
        }
        // Unexpected exceptions caused by other factors
        catch (Exception ee) {
            System.out.println("Error in method ottieniTags" + ee.toString());
            throw new RemoteException(MessaggiErrore.ERRORE_SCONOSCIUTO);
        }
        // Check the data back in order not to return null values
        // Caller
        if (null == toReturn)
            throw new RemoteException(MessaggiErrore.ERRORE_FORMATO_BEAN);
        return toReturn;
    }
}