package unisa.gps.etour.repository;

import java.sql.SQLException;
import java.util.ArrayList;

import unisa.gps.etour.bean.BeanNews;

/**
 * Interface for the management of news in the Database
 *
 * @Author Mauro Miranda
 * @Version 0.1 2007 eTour Project - Copyright by SE @ SA Lab DMI University
 * Of Salerno
 */
public interface IDBNews
{
    /**
     * Add a news database
     *
     * @param Pnews News to add
     * @throws SQLException
     */
    public boolean inserisciNews(BeanNews Pnews) throws SQLException;

    /**
     * Modify a news database
     *
     * @param Pnews News to change with the new data
     * @throws SQLException
     * @return True if there 'was a modified false otherwise
     */
    public boolean modificaNews(BeanNews Pnews) throws SQLException;

    /**
     * Delete a database from news
     *
     * @param pIdNews ID News to eliminate
     * @throws SQLException
     * @return True if and 'have been deleted false otherwise
     */
    public boolean cancellaNews(int pIdNews) throws SQLException;

    /**
     * Returns the active news
     *
     * @throws SQLException
     * @return list of active news
     */
    public ArrayList<BeanNews> ottieniNews() throws SQLException;
}