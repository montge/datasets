package unisa.gps.etour.control.GestioneBeniCulturali;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import unisa.gps.etour.bean.BeanBeneCulturale;
import unisa.gps.etour.bean.BeanTag;
import unisa.gps.etour.bean.BeanVisitaBC;
import unisa.gps.etour.util.MessaggiErrore;

/**
 * Class management of cultural heritage unique to Agency
 *
 * @Author Michelangelo De Simone
 * @Version 0.1
 *
 * © 2007 eTour Project - Copyright by DMI SE @ SA Lab - University of Salerno
 */
public class GestioneBeniCulturaliAgenzia extends GestioneBeniCulturaliComune
        implements IGestioneBeniCulturaliAgenzia {
    /*
     * Constructor of class, richicama and initializes the class of common management
     */
    public GestioneBeniCulturaliAgenzia() throws RemoteException {
        super();
    }

    /*
     * Implements the method for the elimination of a cultural system.
     *
     * @see unisa.gps.etour.control.GestioneBeniCulturali.IGestioneBeniCulturaliAgenzia#cancellaBeneCulturale(int)
     */
    public boolean cancellaBeneCulturale(int pBeneCulturaleID)
            throws RemoteException {
        if (!ControlloBeniCulturali.controllaIdBeneCulturale(pBeneCulturaleID))
            throw new RemoteException(MessaggiErrore.ERRORE_DATI);

        try {
            return (dbbc.cancellaBeneCulturale(pBeneCulturaleID));
        }
        catch (SQLException e) {
            throw new RemoteException(MessaggiErrore.ERRORE_DBMS);
        }
        catch (Exception e) {
            throw new RemoteException(MessaggiErrore.ERRORE_SCONOSCIUTO);
        }
    }

    /*
     * Implement the method for the insertion of a new cultural object.
     *
     * @see unisa.gps.etour.control.GestioneBeniCulturali.IGestioneBeniCulturaliAgenzia#inserisciBeneCulturale(unisa.gps.etour.bean.BeanBeneCulturale)
     */
    public boolean inserisciBeneCulturale(BeanBeneCulturale pBeneCulturale)
            throws RemoteException {
        if (!ControlloBeniCulturali.controllaDatiBeneCulturale(pBeneCulturale))
            throw new RemoteException(MessaggiErrore.ERRORE_FORMATO_BEAN);

        try {
            return (dbbc.inserisciBeneCulturale(pBeneCulturale));
        }
        catch (SQLException e) {
            throw new RemoteException(MessaggiErrore.ERRORE_DBMS);
        }
        catch (Exception e) {
            throw new RemoteException(MessaggiErrore.ERRORE_SCONOSCIUTO);
        }
    }

    /*
     * Implements the method for obtaining all the cultural assets currently in the system.
     *
     * @see unisa.gps.etour.control.GestioneBeniCulturali.IGestioneBeniCulturaliAgenzia#ottieniBeniCulturali()
     */
    public ArrayList<BeanBeneCulturale> ottieniBeniCulturali() throws RemoteException {
        try {
            return (dbbc.ottieniListaBC());
        }
        catch (SQLException e) {
            throw new RemoteException(MessaggiErrore.ERRORE_DBMS);
        }
        catch (Exception e) {
            throw new RemoteException(MessaggiErrore.ERRORE_SCONOSCIUTO);
        }
    }

    /*
     * Implement the method for changing a cultural asset in the system.
     *
     * @see unisa.gps.etour.control.GestioneBeniCulturali.IGestioneBeniCulturaliAgenzia#modificaBeneCulturale(unisa.gps.etour.bean.BeanBeneCulturale)
     */
    public boolean modificaBeneCulturale(BeanBeneCulturale pBeneCulturale)
            throws RemoteException {
        if (!ControlloBeniCulturali.controllaDatiBeneCulturale(pBeneCulturale))
            throw new RemoteException(MessaggiErrore.ERRORE_FORMATO_BEAN);

        try {
            return (dbbc.modificaBeneCulturale(pBeneCulturale));
        }
        catch (SQLException e) {
            throw new RemoteException(MessaggiErrore.ERRORE_DBMS);
        }
        catch (Exception e) {
            throw new RemoteException(MessaggiErrore.ERRORE_SCONOSCIUTO);
        }
    }

    /*
     * Implements the method for adding a tag to a cultural object.
     *
     * @see unisa.gps.etour.control.GestioneBeniCulturali.IGestioneBeniCulturaliAgenzia#aggiungiTagBeneCulturale(int, int)
     */
    public boolean aggiungiTagBeneCulturale(int pBeneCulturaleID, int pTagID) throws RemoteException {
        if (!ControlloBeniCulturali.controllaIdBeneCulturale(pBeneCulturaleID) || !(pTagID > 0))
            throw new RemoteException(MessaggiErrore.ERRORE_DATI);

        /*
         * This segment of code that actually controls the cultural speficiato
         * Have the tag defined.
         */

        /*
         * Get all tags to the cultural past for parameter
         */
        ArrayList<BeanTag> tempTag = null;

        boolean contieneTag = false;

        try {
            tempTag = dbtag.ottieniTagBeneCulturale(pBeneCulturaleID);
        }
        catch (SQLException e) {
            throw new RemoteException(MessaggiErrore.ERRORE_DBMS);
        }

        /*
         * Here we iterate to find the tag that speficiato, if it is you set a sentry
         * In order not to add a tag twice for the same cultural object.
         */
        for (BeanTag t : tempTag)
            if (t.getId() == pTagID)
                contieneTag = true;

        if (!contieneTag)
            try {
                return (dbtag.aggiungeTagBeneCulturale(pBeneCulturaleID, pTagID));
            }
            catch (SQLException e) {
                throw new RemoteException(MessaggiErrore.ERRORE_DBMS);
            }
            catch (Exception e) {
                throw new RemoteException(MessaggiErrore.ERRORE_SCONOSCIUTO);
            }

        return false;
    }

    /*
     * Implement the method for removing a tag from a cultural object.
     *
     * @see unisa.gps.etour.control.GestioneBeniCulturali.IGestioneBeniCulturaliAgenzia#rimuoviTagBeneCulturale(int, int)
     */
    public boolean rimuoviTagBeneCulturale(int pBeneCulturaleID, int pTagID) throws RemoteException {
        if (!ControlloBeniCulturali.controllaIdBeneCulturale(pBeneCulturaleID) || !(pTagID > 0))
            throw new RemoteException(MessaggiErrore.ERRORE_DATI);

        /*
         * This segment of code that actually controls the cultural speficiato
         * Has the specified tag.
         */

        /*
         * Get all tags to the cultural past for parameter
         */
        ArrayList<BeanTag> tempTag = null;

        try {
            tempTag = dbtag.ottieniTagBeneCulturale(pBeneCulturaleID);
        }
        catch (SQLException e) {
            throw new RemoteException(MessaggiErrore.ERRORE_DBMS);
        }

        /*
         * Here we iterate to find the tag that speficiato, if you found the transaction is made
         * Removal of the tag and returns control
         */
        for (BeanTag t : tempTag) {
            if (t.getId() == pTagID) {
                try {
                    return (dbtag.cancellaTagBeneCulturale(pBeneCulturaleID, pTagID));
                }
                catch (SQLException e) {
                    throw new RemoteException(MessaggiErrore.ERRORE_DBMS);
                }
                catch (Exception e) {
                    throw new RemoteException(MessaggiErrore.ERRORE_SCONOSCIUTO);
                }
            }
        }

        return false;
    }
}