package unisa.gps.etour.control.GestioneBeniCulturali;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import unisa.gps.etour.bean.BeanBeneCulturale;
import unisa.gps.etour.bean.BeanTag;
import unisa.gps.etour.bean.BeanVisitaBC;
import unisa.gps.etour.repository.DBTag;
// import unisa.gps.etour.repository.DBBeneCulturale;
// import unisa.gps.etour.repository.DBTurista;
// import unisa.gps.etour.repository.DBVisitaBC;
import unisa.gps.etour.repository.IDBBeneCulturale;
import unisa.gps.etour.repository.IDBTag;
import unisa.gps.etour.repository.IDBTurista;
import unisa.gps.etour.repository.IDBVisitaBC;
import unisa.gps.etour.util.CostantiGlobali;
import unisa.gps.etour.util.MessaggiErrore;

// Stub
import unisa.gps.etour.control.GestioneBeniCulturali.test.stub.DBBeneCulturale; // ***
import unisa.gps.etour.control.GestioneBeniCulturali.test.stub.DBTurista; // ***
import unisa.gps.etour.control.GestioneBeniCulturali.test.stub.DBVisitaBC; // ***

/**
 * Class management of cultural heritage for operations common to all actors
 *
 * @Author Michelangelo De Simone
 * @Version 0.1
 *
 * © 2007 eTour Project - Copyright by DMI SE @ SA Lab - University of Salerno
 */
/**
 *
 */
public class GestioneBeniCulturaliComune extends UnicastRemoteObject implements
        IGestioneBeniCulturaliComune
{
    // Connect to DB for Cultural Heritage
    protected IDBBeneCulturale dbbc;

    // Connect to DB Tag
    protected IDBTag dbtag;

    // Connect to DB for the Feedback / Visits
    protected IDBVisitaBC dbvisita;

    // Connect to DB for Tourists
    protected IDBTurista dbturista;

    /**
     * Constructor; you instantiate all fields relevant to data management;
     * Fields are initialized for each instance of the class.
     *
     * @throws RemoteException Exception flow
     */
    public GestioneBeniCulturaliComune() throws RemoteException
    {
        // Class Supercostruttore UnicastRemoteObject
        super();

        // We instantiate objects
        try
        {
            dbbc = new DBBeneCulturale();
            dbtag = new DBTag();
            dbvisita = new DBVisitaBC();
            dbturista = new DBTurista();
        }
        catch (Exception e)
        {
            throw new RemoteException(MessaggiErrore.ERRORE_SCONOSCIUTO);
        }
    }

    /*
     * Implements the method for obtaining a cultural object by Id
     *
     * @see unisa.gps.etour.control.GestioneBeniCulturali.IGestioneBeniCulturaliComune#ottieniBeneCulturale(int)
     */
    public BeanBeneCulturale ottieniBeneCulturale(int pBeneCulturaleID) throws RemoteException
    {
        if (!ControlloBeniCulturali.controllaIdBeneCulturale(pBeneCulturaleID))
            throw new RemoteException(MessaggiErrore.ERRORE_DATI);

        BeanBeneCulturale bbc = null;

        try
        {
            bbc = dbbc.ottieniBeneCulturale(pBeneCulturaleID);
        }
        catch (SQLException e)
        {
            throw new RemoteException(MessaggiErrore.ERRORE_DBMS);
        }
        catch (Exception e)
        {
            throw new RemoteException(MessaggiErrore.ERRORE_SCONOSCIUTO);
        }

        return bbc;
    }

    /*
     * Implements the method for obtaining all the tags of a cultural object.
     *
     * @see unisa.gps.etour.control.GestioneBeniCulturali.IGestioneBeniCulturaliComune#ottieniTagBeneCulturale(int)
     */
    public ArrayList<BeanTag> ottieniTagBeneCulturale(int pBeneCulturaleID) throws RemoteException
    {
        if (!ControlloBeniCulturali.controllaIdBeneCulturale(pBeneCulturaleID))
            throw new RemoteException(MessaggiErrore.ERRORE_DATI);

        ArrayList<BeanTag> btag = null;

        try
        {
            btag = dbtag.ottieniTagBeneCulturale(pBeneCulturaleID);
        }
        catch (SQLException e)
        {
            throw new RemoteException(MessaggiErrore.ERRORE_DBMS);
        }
        catch (Exception e)
        {
            throw new RemoteException(MessaggiErrore.ERRORE_SCONOSCIUTO);
        }

        return btag;
    }

    /*
     * Implements the method to obtain the list of feedback and their username on a property
     * Cultural specified by Id
     *
     * @see unisa.gps.etour.control.GestioneBeniCulturali.IGestioneBeniCulturaliComune#ottieniFeedbackBeneCulturale(int)
     */
    public HashMap<BeanVisitaBC, String> ottieniFeedbackBeneCulturale(int pBeneCulturaleID) throws RemoteException
    {
        if (!ControlloBeniCulturali.controllaIdBeneCulturale(pBeneCulturaleID))
            throw new RemoteException(MessaggiErrore.ERRORE_DATI);

        HashMap<BeanVisitaBC, String> mappaRitorno;

        try
        {
            // Instantiate the map of the same size as the list of BeanVisitaBC
            mappaRitorno = new HashMap<BeanVisitaBC, String>(dbvisita.ottieniListaVisitaBC(pBeneCulturaleID).size());

            // For each visit by adding their username
            // Here we begin to iterate to add to any visit their username
            for (BeanVisitaBC b: dbvisita.ottieniListaVisitaBC(pBeneCulturaleID))
                mappaRitorno.put(b, dbturista.ottieniTurista(b.getIdTurista()).GetUserName());

        }
        catch (SQLException e)
        {
            throw new RemoteException(MessaggiErrore.ERRORE_DBMS);
        }
        catch (Exception e)
        {
            throw new RemoteException(MessaggiErrore.ERRORE_SCONOSCIUTO);
        }

        return mappaRitorno;
    }

    /*
     * Implements the method to obtain statistics about a cultural past
     * Through Id
     *
     * @see unisa.gps.etour.control.GestioneBeniCulturali.IGestioneBeniCulturaliComune#ottieniStatisticheBeneCulturale(int)
     */
    public ArrayList<Integer> ottieniStatisticheBeneCulturale(int pBeneCulturaleID) throws RemoteException
    {
        /*
         * This method returns an ArrayList containing 5 elements (0 .. 4).
         * For each index more 'one is the number of equivalent value your feedback
         * Index number more 'one.
         * Even in this case the method is not 'particularly attractive but it does its dirty work
         * Fine.
         */

        if (!ControlloBeniCulturali.controllaIdBeneCulturale(pBeneCulturaleID))
            throw new RemoteException(MessaggiErrore.ERRORE_DATI);

        ArrayList<Integer> listaRisultati = new ArrayList<Integer>(5);

        // Set all the indices to 0
        for (int i = 0; i < 5; i++)
            listaRisultati.add(i, Integer.valueOf(0));

        // Calculate the date for the last thirty days
        Date ultimiTrentaGiorni = new Date(new Date().getTime() - CostantiGlobali.TRENTA_GIORNI);

        try
        {
            // Get all visits of a certain cultural
            // Loop looking for the requests / feedback obtained within the last thirty days
            for (BeanVisitaBC b: dbvisita.ottieniListaVisitaBC(pBeneCulturaleID))
                if (b.getDataVisita().after(ultimiTrentaGiorni))
                    listaRisultati.set(b.getVoto() - 1, Integer.valueOf(listaRisultati.get(b.getVoto() - 1).intValue() + 1));
        }
        catch (SQLException e)
        {
            throw new RemoteException(MessaggiErrore.ERRORE_DBMS);
        }
        catch (Exception e)
        {
            throw new RemoteException(MessaggiErrore.ERRORE_SCONOSCIUTO);
        }

        return listaRisultati;
    }

    /*
     * Implement the method for changing a feedback on a cultural past
     * Through Id
     *
     * @see unisa.gps.etour.control.GestioneBeniCulturali.IGestioneBeniCulturaliComune#modificaFeedbackBeneCulturale(int, unisa.gps.etour.bean.BeanVisitaBC)
     */
    public boolean modificaFeedbackBeneCulturale(int pBeneCulturaleID, BeanVisitaBC pBeanVisitaBC) throws RemoteException
    {
        if (!ControlloBeniCulturali.controllaIdBeneCulturale(pBeneCulturaleID) ||
                !ControlloVisiteBeniCulturali.controllaDatiVisitaBeneCulturale(pBeanVisitaBC))
            throw new RemoteException(MessaggiErrore.ERRORE_DATI);

        /*
         * Please check that the vote has not changed.
         * If the vote is changed to an exception is raised
         */
        boolean votoOk = true;

        try
        {
            votoOk = dbvisita.ottieniVisitaBC(pBeneCulturaleID, pBeanVisitaBC.getIdTurista()).getVoto() == pBeanVisitaBC.getVoto();
        }
        catch (SQLException e)
        {
            throw new RemoteException(MessaggiErrore.ERRORE_DBMS);
        }
        catch (Exception e)
        {
            throw new RemoteException(MessaggiErrore.ERRORE_SCONOSCIUTO);
        }

        /*
         * If the vote is not changed we proceed to send the message to the method of
         * Change the layer's database.
         */
        if (votoOk)
            try
            {
                return (dbvisita.modificaVisitaBC(pBeanVisitaBC));
            }
            catch (SQLException e)
            {
                throw new RemoteException(MessaggiErrore.ERRORE_DBMS);
            }
            catch (Exception e)
            {
                throw new RemoteException(MessaggiErrore.ERRORE_SCONOSCIUTO);
            }

        return false;
    }
}