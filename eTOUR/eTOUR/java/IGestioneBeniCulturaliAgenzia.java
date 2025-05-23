package unisa.gps.etour.control.GestioneBeniCulturali;

import java.rmi.RemoteException;
import java.util.ArrayList;
import unisa.gps.etour.bean.BeanBeneCulturale;
import unisa.gps.etour.bean.BeanVisitaBC;

/**
 * Interface for operations peculiar cultural heritage by
 * Operator Agency.
 *
 * @Author Michelangelo De Simone
 * @Version 0.1 © 2007 eTour Project - Copyright by DMI SE @ SA Lab --
 * University of Salerno
 */
public interface IGestioneBeniCulturaliAgenzia extends IGestioneBeniCulturaliComune {
    /**
     * Method for the insertion of a new cultural
     *
     * @param pBeneCulturale The raw bean to be included in the database
     * @return boolean The result of the operation; true if was successful, false otherwise
     * @throws RemoteException Exception flow
     */
    public boolean inserisciBeneCulturale(BeanBeneCulturale pBeneCulturale) throws RemoteException;

    /**
     * Method for the cancellation of a cultural object by id
     *
     * @param pBeneCulturaleID Id the bean to be deleted
     * @return boolean The result of the operation; true if was successful, false otherwise
     * @throws RemoteException Exception flow
     */
    public boolean cancellaBeneCulturale(int pBeneCulturaleID) throws RemoteException;

    /**
     * Method for the return of all cultural property in the
     * Database
     *
     * @return ArrayList all the beans in the database
     * @throws RemoteException Exception flow
     */
    public ArrayList<BeanBeneCulturale> ottieniBeniCulturali() throws RemoteException;

    /**
     * Method for updating (or change) the data of a cultural
     *
     * @param pBeneCulturale The bean with the new information of the cultural
     * @return boolean The result of the operation; true if was successful, false otherwise
     * @throws RemoteException Exception flow
     */
    public boolean modificaBeneCulturale(BeanBeneCulturale pBeneCulturale) throws RemoteException;

    /**
     * Method for setting a tag to a certain cultural
     *
     * @param pBeneCulturaleID The identifier of the cultural object to which to add a tag
     * @param pTagID The ID tag to add to the cultural indicated
     * @return boolean The result of the operation; true if was successful, false otherwise
     * @throws RemoteException Exception flow
     */
    public boolean aggiungiTagBeneCulturale(int pBeneCulturaleID, int pTagID) throws RemoteException;

    /**
     * Method for removing a tag from a certain cultural
     * To ensure that 'the operation is successful it is necessary that the cultural property has
     * Actually set the specified tag
     *
     * @param pBeneCulturaleID The identifier of the cultural object from which to remove the tag
     * @param pTagID The ID tag to be removed from the cultural indicated
     * @return boolean The result of the operation; true if was successful, false otherwise
     * @throws RemoteException Exception flow
     */
    public boolean rimuoviTagBeneCulturale(int pBeneCulturaleID, int pTagID) throws RemoteException;
}