package unisa.gps.etour.control.GestioneAdvertisement;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

import javax.swing.ImageIcon;

import unisa.gps.etour.bean.BeanBanner;

/**
 * Interface General Manager of Banner and news.
 *
 * @Author Fabio Palladino
 * @Version 0.1
 *
 * 2007 eTour Project - Copyright by SE @SA Lab DMI University of Salerno
 */
public interface IGestioneAdvertisement extends Remote 
{
    /**
     * Inserts a new banner.
     *
     * @param pBanner Bean contains the data of the banner
     * @throws RemoteException
     */
    public boolean inserisciBanner(int pIdPuntoDiRistoro, ImageIcon pImmagineBanner)
            throws RemoteException;
    
    /**
     * Delete a banner from the system.
     *
     * @param pBannerID ID banner to be deleted.
     * @Return true if the operation is successful false otherwise.
     * @throws RemoteException
     */
    public boolean cancellaBanner(int pBannerID) throws RemoteException;
    
    /**
     * Modify the data of the banner or the image associated.
     *
     * @param pBanner Bean contains the data of the banner.
     * @Return true if the operation is successful, false otherwise.
     * @throws RemoteException
     */
    public boolean modificaBanner(int pBannerID, ImageIcon pImmagine)
            throws RemoteException;
    
    /**
     * Returns a list of Banner of a particular point of comfort.
     *
     * @param pPuntoDiRistoroID Id of refreshment owner of banner
     * @Return ArrayList containing the list of banner refreshment
     * @throws RemoteException
     */
    public HashMap<BeanBanner, ImageIcon> ottieniBannersDaID(int pIdPuntoDiRistoro)
            throws RemoteException;
}