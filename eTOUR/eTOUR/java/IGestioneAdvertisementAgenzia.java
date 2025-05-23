/**
 * Interface that provides management services dell'advertisement
 * Operator agency.
 *
 * @Author author
 * @Version 0.1
 *
 * � 2007 eTour Project - Copyright by DMI SE @ SA Lab - University of Salerno
 */
package com.trapan.spg.control.GestioneAdvertisement;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.trapan.spg.bean.BeanNews;

public interface IGestioneAdvetisementAgenzia extends IGestioneAdvertisement
{
    /**
     * Method that inserts a new news system.
     *
     * @param Pnews Bean containing data news
     * @throws RemoteException
     */
    public boolean inserisciNews(BeanNews Pnews) throws RemoteException;
    
    /**
     * Method which removes from the news system.
     *
     * @param pNewsID ID news be erased.
     * @throws RemoteException
     */
    public boolean cancellaNews(int pNewsID) throws RemoteException;
    
    /**
     * Method amending the text of a news.
     *
     * @param Pnews Bean containing data news
     * @throws RemoteException
     */
    public boolean modificaNews(BeanNews Pnews) throws RemoteException;
    
    /**
     * Returns the list of active news.
     *
     * @return ArrayList of ArrayList News
     * @throws RemoteException
     */
    public ArrayList<BeanNews> ottieniAllNews() throws RemoteException;
}