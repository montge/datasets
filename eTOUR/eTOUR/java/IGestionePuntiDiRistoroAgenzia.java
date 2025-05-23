package unisa.gps.etour.control.GestionePuntiDiRistoro;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import unisa.gps.etour.bean.BeanConvenzione;
import unisa.gps.etour.bean.BeanPuntoDiRistoro;
import unisa.gps.etour.bean.BeanVisitaPR;

/**
 * Interface for refreshments on the side of the agency
 *
 * @Author Joseph Morelli
 * @Version 0.1 © 2007 eTour Project - Copyright by DMI SE @ SA Lab - University
 * Of Salerno
 */
public interface IGestionePuntiDiRistoroAgenzia extends IGestionePuntiDiRistoroComune {

    /**
     * Method for inserting a new Refreshment
     *
     * @param pPuntoDiRistoro containing all the data from the Refreshment
     * Add
     * @throws RemoteException Exception Remote
     */
    public boolean inserisciPuntoDiRistoro(BeanPuntoDiRistoro pPuntoDiRistoro)
            throws RemoteException;

    /**
     * Method for deleting a refreshment bar with ID
     *
     * @param pIDPuntoDiRistoro for the unique identification of point
     * Refreshments
     * @throws RemoteException Exception Remote
     */
    public boolean cancellaPuntoDiRistoro(int pPuntoDiRistoroID)
            throws RemoteException;

    /**
     * Method to return all the refreshment of the DataBase
     *
     * @return ArrayList containing all the beans of the present Refreshments
     * In the DataBase
     * @throws RemoteException Exception Remote
     */
    public ArrayList<BeanPuntoDiRistoro> ottieniPuntiDiRistoro()
            throws RemoteException;

    /**
     * Method to return all the refreshment with convention
     * Active or not
     *
     * @param statoConvenzione Boolean for the type of eateries by
     * Get (contracted or not)
     * @return ArrayList containing all the beans of the present Refreshments
     * In the database depending on the status of the Convention
     * @throws RemoteException Exception Remote
     */
    public ArrayList<BeanPuntoDiRistoro> ottieniPuntiDiRistoro(
            boolean statoConvenzione) throws RemoteException;

    /**
     * Method for inserting a new convention for a certain point
     * Refreshments
     *
     * @param pPuntoDiRistoroID integer that uniquely identifies the point
     * Refreshments
     * @param pConv Convention that will enable (Parameter ID
     * Refreshment create redundancy but is useful for security
     * Data)
     * @return boolean for confirmation of operation
     * @throws RemoteException Exception Remote
     */
    public boolean attivaConvenzione(int pPuntoDiRistoroID,
            BeanConvenzione pConv) throws RemoteException;

    /**
     * Method to get all the feedback associated to a certain point
     * Refreshments
     *
     * @param pPuntoDiRistoroID unique identifier of the Refreshment
     * To get feedback
     * @return HashMap containing the bean as the key value of feedback and how
     * The tourist who issued the feedback
     * @throws RemoteException Exception Remote
     */
    public HashMap<BeanVisitaPR, String> ottieniFeedbackPuntoDiRistoro(
            int pPuntoDiRistoroID) throws RemoteException;

    /**
     * Method for updating (or change) the data of a Refreshment
     *
     * @param pPuntoDiRistoroAggiornato containing the new data to be saved
     * @return Boolean value-true if the operation went successfully,
     * False otherwise
     * @throws RemoteException Exception Remote
     */
    public boolean modificaPuntoDiRistoro(
            BeanPuntoDiRistoro pPuntoDiRistoroAggiornato)
            throws RemoteException;

    /**
     * Method which allows you to insert a tag to search for a useful point
     * Refreshments
     *
     * @param pPuntoDiRistoroId unique identifier of Refreshment
     * @param pTagId unique ID tags to be inserted
     * @return Boolean value-true if the operation went successfully,
     * False otherwise
     * @throws RemoteException Exception Remote
     */
    public boolean inserisciTagPuntoDiRistoro(int pPuntoDiRistoroId, int pTagId)
            throws RemoteException;

    /**
     * Method which allows you to delete a tag to search for a useful point
     * Refreshments
     *
     * @param pPuntoDiRistoroId unique identifier of Refreshment
     * @param pTagId unique ID tags to be inserted
     * @return Boolean value-true if the operation went successfully,
     * False otherwise
     * @throws RemoteException Exception Remote
     */
    public boolean cancellaTagPuntoDiRistoro(int pPuntoDiRistoroId, int pTagId)
            throws RemoteException;
}