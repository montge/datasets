/**
 * Implementing the management dell'advertisement
 * For the operator agency. Contains methods for managing
 * News.
 *
 * @Author Fabio Palladino
 * @Version 0.1
 *
 * 2007 eTour Project - Copyright by SE @ SA Lab DMI University of Salerno
 */
package unisa.gps.etour.control.GestioneAdvertisement;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import unisa.gps.etour.bean.BeanNews;
/* Import the stub */
// import unisa.gps.etour.control.GestioneAdvertisement.test.stubs.DBNews;
import unisa.gps.etour.repository.DBNews;
import unisa.gps.etour.repository.IDBNews;
import unisa.gps.etour.util.ControlloDati;
import unisa.gps.etour.util.CostantiGlobali;
import unisa.gps.etour.util.MessaggiErrore;


public class GestioneAdvertisementAgenzia extends GestioneAdvertisement
        implements IGestioneAdvertisementAgenzia
{
    private static final long serialVersionUID = 1L;
    /** Contains the methods for collecting news in the database */
    private IDBNews dbNews;

    /**
     * Constructor. Instantiates an object of type (@link unisa.gps.etour.repository.DBNews).
     *
     * @throws RemoteException
     */
    public GestioneAdvertisementAgenzia() throws RemoteException
    {
        super();
        dbNews = new DBNews();
    }

    /**
     * Method which removes news from the database. Uses the
     * (@Link Boolean unisa.gps.etour.repository.IDBNews # cancellaNews (int))
     *
     * @param pNewsID news be erased.
     * @return true if the cancellation was successful or FALSE otherwise.
     * @throws RemoteException
     *
     */
    public boolean cancellaNews(int pNewsID) throws RemoteException
    {
        try
        {
            /* Check that the ID is valid */
            if (pNewsID > 0) {
                return (dbNews.cancellaNews(pNewsID));
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RemoteException(MessaggiErrore.ERRORE_CONNESSIONE_DBMS);
        }
    }

    /**
     * Insert a new news in the database.
     * Use the method (@link unisa.gps.etour.repository.IDBNews # inserisciNews (BeanNews))
     * To insert the news and the method (@link unisa.gps.etour.repository.IDBNews # ottieniNews ())
     * To count the number of news in the system.
     *
     * @param Pnews bean containing data news.
     * @return true if the insertion is successful, false if it was
     * Reached the maximum number of news stored or if the insertion fails.
     * @throws RemoteException
     */
    public boolean inserisciNews(BeanNews Pnews) throws RemoteException
    {
        try
        {
            /* Check the data of the news */
            if (!ControlloDati.checkBeanNews(Pnews)) {
                throw new RemoteException(MessaggiErrore.ERRORE_DATI);
            }
            /* Check that has not been exceeded the no. Max news presets */
            int numNews = dbNews.ottieniNews().size();
            if (numNews < CostantiGlobali.MAX_NEWS_ATTIVE) {
                /* Possible inclusion */
                return (dbNews.inserisciNews(Pnews));
            } else {
                /* Insertion is not possible */
                return false;
            }
        } catch (SQLException e) {
            throw new RemoteException(MessaggiErrore.ERRORE_CONNESSIONE_DBMS);
        }
    }

    /**
     * Method to change data of a news.
     * Use the method (@link unisa.gps.etour.repository.IDBNews # modificaNews (BeanNews)).
     *
     * @param Pnews bean containing the data of news changed.
     * @return true if the change goes through.
     * @throws RemoteException
     */
    public boolean modificaNews(BeanNews Pnews) throws RemoteException
    {
        try
        {
            /* Check the data of the news */
            if (!ControlloDati.checkBeanNews(Pnews)) {
                throw new RemoteException(MessaggiErrore.ERRORE_DATI);
            }
            return (dbNews.modificaNews(Pnews));
        } catch (SQLException e) {
            throw new RemoteException(MessaggiErrore.ERRORE_CONNESSIONE_DBMS);
        }
    }

    /**
     * Method that returns an array containing all the news stored in the system.
     * Use the method (@link unisa.gps.etour.repository.IDBNews # ottieniNews ()).
     *
     * @return ArrayList containing beans of news.
     * @throws RemoteException
     */
    public ArrayList<BeanNews> ottieniAllNews() throws RemoteException
    {
        try
        {
            return (dbNews.ottieniNews());
        } catch (SQLException e) {
            throw new RemoteException(MessaggiErrore.ERRORE_CONNESSIONE_DBMS);
        }
    }
}