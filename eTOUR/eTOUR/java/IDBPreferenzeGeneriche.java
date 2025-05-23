package unisa.gps.etour.repository;

import java.sql.SQLException;

import unisa.gps.etour.bean.BeanPreferenzeGeneriche;

/**
 * Interface for handling general preferences in database
 *
 * @Author Mauro Miranda
 * @Version 0.1 2007 eTour Project - Copyright by SE @SA Lab DMI University
 * Of Salerno
 */
public interface IDBPreferenzeGeneriche
{
    /**
     * Add a preference General
     *
     * @param pPreferenza preference to be added
     * @throws SQLException
     */
    public boolean inserisciPreferenzaGenenerica(
            BeanPreferenzeGeneriche pPreferenza) throws SQLException;

    /**
     * Edit a general preference
     *
     * @param pPreferenza preference to change
     * @throws SQLException
     * @return True if and 'been changed otherwise false
     */
    public boolean modificaPreferenzaGenerica(
            BeanPreferenzeGeneriche pPreferenza) throws SQLException;

    /**
     * Delete a general preference
     *
     * @param pIdPreferenza ID preference to delete
     * @throws SQLException
     * @return True if and 'have been deleted false otherwise
     */
    public boolean cancellaPreferenzaGenerica(int pIdPreferenza)
            throws SQLException;

    /**
     * Returns the generic preference for tourists
     *
     * @param pIdTurista Id tourists
     * @throws SQLException
     * @return generic preference
     */
    public BeanPreferenzeGeneriche ottieniPreferenzaGenerica(int pIdTurista)
            throws SQLException;
}