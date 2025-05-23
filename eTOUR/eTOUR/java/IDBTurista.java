package unisa.gps.etour.repository;

import java.sql.SQLException;
import java.util.ArrayList;

import unisa.gps.etour.bean.BeanBeneCulturale;
import unisa.gps.etour.bean.BeanTurista;

/**
 * Interface for the management of tourists in the database
 *
 * @Author Mauro Miranda
 * @Version 0.1 2007 eTour Project - Copyright by SE @ SA Lab DMI University
 * Of Salerno
 */
public interface IDBTurista
{
    /**
     * Add a tourist
     *
     * @param pTurista Tourist to add
     * @throws SQLException
     */
    public boolean inserisciTurista(BeanTurista pTurista) throws SQLException;

    /**
     * Modify a tourist
     *
     * @param pTurista Tourist to change
     * @throws SQLException
     * @return True if and 'been changed otherwise false
     */
    public boolean modificaTurista(BeanTurista pTurista) throws SQLException;

    /**
     * Delete a tourist from the database
     *
     * @param pIdTurista Identificatie Tourist delete
     * @throws SQLException
     * @return True if and 'been changed otherwise false
     */
    public boolean delete(int pIdTurista) throws SQLException;

    /**
     * Returns the data of the Tourist
     *
     * @param pUsername Username tourists
     * @throws SQLException
     * @return Information about tourist
     */
    public BeanTurista ottieniTurista(String pUsername) throws SQLException;

    /**
     * Attach a cultural tourists preferred
     *
     * @param pIdTurista ID tourists
     * @param pIdBeneCulturale ID of the cultural
     * @throws SQLException
     */
    public boolean inserisciBeneCulturalePreferito(int pIdTurista,
            int pIdBeneCulturale) throws SQLException;

    /**
     * Attach a point of catering to the tourist favorite
     *
     * @param pIdTurista ID tourists
     * @param pIdPuntoDiRistoro ID of the cultural
     * @throws SQLException
     */
    public boolean inserisciPuntoDiRistoroPreferito(int pIdTurista,
            int pIdPuntoDiRistoro) throws SQLException;

    /**
     * Delete a cultural favorite
     *
     * @param pIdTurista ID tourists
     * @param pIdBeneCulturale ID of the cultural
     * @throws SQLException
     * @return True if and 'been changed otherwise false
     */
    public boolean cancellaBeneCulturalePreferito(int pIdTurista,
            int pIdBeneCulturale) throws SQLException;

    /**
     * Delete a favorite resting spot
     *
     * @param pIdTurista ID tourists
     * @param pIdPuntoDiRistoro ID of the cultural
     * @throws SQLException
     * @return True if and 'was deleted false otherwise
     */
    public boolean cancellaPuntoDiRistoroPreferito(int pIdTurista,
            int pIdPuntoDiRistoro) throws SQLException;

    /**
     * Returns an ArrayList of tourists who have a username like that
     * Given as argument
     *
     * @param pUsernameTurista Usrername tourists to search
     * @throws SQLException
     * @return data for Tourists
     */
    public ArrayList<BeanTurista> ottieniTuristi(String pUsernameTurista)
            throws SQLException;

    /**
     * Returns the list of tourists turned on or off
     *
     * @param condition True select active tourists False those tourists turned off
     * @return data for Tourists
     * @throws SQLException
     */
    public ArrayList<BeanTurista> ottieniTuristi(boolean condition)
            throws SQLException;

    /**
     * Returns the data of the tourist with ID equal to that given in
     * Input
     *
     * @param pIdTurista ID tourists to find
     * @return Tourists with id equal to the input, null if there is
     * @throws SQLException
     */
    public BeanTurista ottieniTurista(int pIdTurista) throws SQLException;

    /**
     * Returns the list of cultural favorites from a particular
     * Tourist
     *
     * @param pIdTurista ID tourists to find
     * @return List of Cultural Heritage Favorites
     * @throws SQLException
     */
    public ArrayList<Integer> ottieniBeniCulturaliPreferiti(int pIdTurista)
            throws SQLException;

    /**
     * Returns a list of favorite resting spot by a particular
     * Tourist
     *
     * @param pIdTurista ID tourists to find
     * @return List of Refreshment Favorites
     * @throws SQLException
     */
    public ArrayList<Integer> ottieniPuntoDiRistoroPreferiti(int pIdTurista)
            throws SQLException;
}