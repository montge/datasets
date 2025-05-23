package unisa.gps.etour.repository;

import java.sql.SQLException;
import java.util.ArrayList;

import unisa.gps.etour.bean.BeanBanner;

/**
 * Interface for managing the banner on the database
 *
 * @Author Mauro Miranda
 * @Version 0.1 2007 eTour Project - Copyright by SE @SA Lab DMI University
 * Of Salerno
 */

public interface IDBBanner
{
    /**
     * Add a banner in the database
     *
     * @param pBanner bean containing the information of the banner
     * @throws SQLException
     */
    public boolean inserisciBanner(BeanBanner pBanner) throws SQLException;

    /**
     * Modify the contents of the advertisement, and returns the contents before
     * Edit
     *
     * @param pBanner Bean that contains the new information of the banner
     * @return True if there 'was a modified false otherwise
     * @throws SQLException
     */
    public boolean modificaBanner(BeanBanner pBanner) throws SQLException;

    /**
     * Delete a banner from the database and returns
     *
     * @param pIdBanner ID BeanBanner
     * @return True if and 'was deleted false otherwise
     * @throws SQLException
     */
    public boolean cancellaBanner(int pIdBanner) throws SQLException;

    /**
     * Returns a list of banners for a refreshment point, if the id of
     * Refreshment and 'equal to -1 will' return the complete list
     * Banners
     *
     * @param pIdPuntoDiRistoro Id of refreshment point from which to obtain the list
     * Banner
     * @return list of banners linked to Refreshment
     * @throws SQLException
     */
    public ArrayList<BeanBanner> ottieniBanner(int pIdPuntoDiRistoro)
            throws SQLException;

    /**
     * Method which returns a banner given its id
     *
     * @param pIdBanner ID the banner to return
     * @return Banner found in the database, null if there is' match
     * @throws SQLException
     */
    public BeanBanner ottieniBannerDaID(int pIdBanner) throws SQLException;
}