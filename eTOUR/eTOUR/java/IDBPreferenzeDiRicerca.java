package unisa.gps.etour.repository;

import java.sql.SQLException;
import java.util.ArrayList;

import unisa.gps.etour.bean.BeanPreferenzaDiRicerca;

/**
 * Interface for managing search preferences in database
 *
 * @Author Joseph Martone
 * @Version 0.1 2007 eTour Project - Copyright by SE @ SA Lab DMI University
 * Of Salerno
 */
public interface IDBPreferenzeDiRicerca
{
    /**
     * Add a preference of Search
     *
     * @param pPreferenza Search Preferences
     * @throws SQLException
     */
    public boolean inserisciPreferenzaDiRicerca(
            BeanPreferenzaDiRicerca pPreferenza) throws SQLException;

    /**
     * Delete a preference for research
     *
     * @param pPreferenza preference to eliminate
     * @throws SQLException
     * @return True if and 'have been deleted false otherwise
     */
    public boolean cancellaPreferenzaDiRicerca(int pIdPreferenza)
            throws SQLException;

    /**
     * Returns the list of preferences to find a tourist
     *
     * @param pIdTurista Id tourists
     * @throws SQLException
     * @return List Search Preferences
     */
    public ArrayList<BeanPreferenzaDiRicerca> ottieniPreferenzeDiRicercaDelTurista(
            int pIdTurista) throws SQLException;

    /**
     * Returns the list of preferences for research of a cultural
     *
     * @param pIdBeneCulturale ID of the cultural
     * @throws SQLException
     * @return list search preferences.
     */
    public ArrayList<BeanPreferenzaDiRicerca> ottieniPreferenzeDiRicercaDelBC(
            int pIdBeneCulturale) throws SQLException;

    /**
     * Returns the list of preferences to find a resting spot
     *
     * @param pIdPuntoDiRistoro identifier a refreshment
     * @throws SQLException
     * @return list search preferences.
     */
    public ArrayList<BeanPreferenzaDiRicerca> ottieniPreferenzeDiRicercaDelPR(
            int pIdPuntoDiRistoro) throws SQLException;

    /**
     * Add a preference for a cultural
     *
     * @param pIdBeneCulturale ID of the cultural
     * @param pIdPreferenzaDiRicerca ID PreferenzaDiRicerca
     * @throws SQLException
     * @param pPreferenza Search Preferences
     */
    public boolean inserisciPreferenzaDiRicercaDelBC(int pIdBeneCulturale,
            int pIdPreferenzaDiRicerca) throws SQLException;

    /**
     * Add a search preference to a tourist
     *
     * @param pIdTurista Id tourists
     * @param pIdPreferenzaDiRicerca ID PreferenzaDiRicerca
     * @throws SQLException
     * @param pPreferenza Search Preferences
     */
    public boolean inserisciPreferenzaDiRicercaDelTurista(int pIdTurista,
            int pIdPreferenzaDiRicerca) throws SQLException;

    /**
     * Add a preference research to a refreshment
     *
     * @param pIdPuntoDiRistoro point identification Refreshments
     * @param pIdPreferenzaDiRicerca ID PreferenzaDiRicerca
     * @throws SQLException
     * @param pPreferenza Search Preferences
     */
    public boolean inserisciPreferenzaDiRicercaDelPR(int pIdPuntoDiRistoro,
            int pIdPreferenzaDiRicerca) throws SQLException;

    /**
     * Deletes a preference to find a Tourist
     *
     * @param pIdTurista Id tourists
     * @param pIdPreferenza Search Preferences
     * @throws SQLException
     * @return True if and 'have been deleted false otherwise
     */
    public boolean cancellaPreferenzaDiRicercaTurista(int pIdTurista,
            int pIdPreferenza) throws SQLException;

    /**
     * Deletes a preference for research of a cultural
     *
     * @param pIdPreferenzaDiRicerca Search Preferences
     * @param pIdBeneCulturale ID of the cultural
     * @throws SQLException
     * @return True if and 'have been deleted false otherwise
     */
    public boolean cancellaPreferenzaDiRicercaBC(int pIdBeneCulturale,
            int pIdPreferenzaDiRicerca) throws SQLException;

    /**
     * Deletes a preference to find a resting spot
     *
     * @param pIdPreferenza Search Preferences
     * @param pIdPuntoDiistoro point identification Refreshments
     * @throws SQLException
     * @return True if and 'have been deleted false otherwise
     */
    public boolean cancellaPreferenzaDiRicercaPR(int pIdPuntoDiistoro,
            int pIdPreferenza) throws SQLException;

    /**
     * Returns a list of all search preferences in the DB
     *
     * @throws SQLException
     * @return List of search preferences in the DB
     */
    public ArrayList<BeanPreferenzaDiRicerca> ottieniPreferenzeDiRicerca()
            throws SQLException;
}