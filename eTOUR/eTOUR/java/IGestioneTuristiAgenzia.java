package unisa.gps.etour.control.GestioneUtentiRegistrati;

import java.rmi.RemoteException;
import java.util.ArrayList;

import unisa.gps.etour.bean.BeanTurista;
import unisa.gps.etour.bean.BeanVisitaBC;
import unisa.gps.etour.bean.BeanVisitaPR;

/**
 * Interface for handling tourists from the side of the transaction Agency
 *
 * @Author Joseph Morelli
 * @Version 0.1 2007 eTour Project - Copyright by SE @ SA Lab DMI University
 * Of Salerno
 */
public interface IGestioneTuristiAgenzia extends IGestioneTuristaComune
{

    /**
     * Method for the cancellation of a tourist from the Database
     *
     * @param pIdTurista Identifier Tourist delete
     * @return Boolean: true if the operation is successful, false otherwise
     * @throws RemoteException Exception Remote
     */
    public boolean delete(int pIdTurista) throws RemoteException;

    /**
     * Method to activate a registered tourists
     *
     * @param pIdTurista ID to activate the Tourist
     * @return Boolean: true if the operation is successful, false otherwise
     * @throws RemoteException Exception Remote
     */
    public boolean attivaTurista(int pIdTurista) throws RemoteException;

    /**
     * Method to disable an active tourists
     *
     * @param pIdTurista to disable Identifier Tourist
     * @return Boolean: true if the operation is successful, false otherwise
     * @throws RemoteException Exception Remote
     */
    public boolean disattivaTurista(int pIdTurista) throws RemoteException;

    /**
     * Method to obtain a collection of Tourists
     *
     * @return ArrayList of BeanTurista
     * @throws RemoteException Exception Remote
     */
    public ArrayList<BeanTurista> ottieniTuristi() throws RemoteException;

    /**
     * Method to obtain a collection of active tourists or not
     *
     * @param statoAccount boolean Tourists can choose
     * On whether
     * @return ArrayList of BeanTurista
     * @throws RemoteException Exception Remote
     */
    public ArrayList<BeanTurista> ottieniTuristi(boolean statoAccount)
            throws RemoteException;

    /**
     * Method to get all the feedback issued by a tourist for the points
     * Refreshments
     *
     * @param pIdTurista ID to pick up the tourists in
     * Feedback
     * @return ArrayList containing all the beans Feedback released
     * @throws RemoteException Exception Remote
     */
    public ArrayList<BeanVisitaPR> ottieniFeedbackPR(int pIdTurista)
            throws RemoteException;

    /**
     * Method to get all the feedback issued by a tourist for Heritage
     * Cultural
     *
     * @param pIdTurista ID to pick up the tourists in
     * Feedback
     * @return ArrayList containing all the beans Feedback released
     * @throws RemoteException Exception Remote
     */
    public ArrayList<BeanVisitaBC> ottieniFeedbackBC(int pIdTurista)
            throws RemoteException;

}