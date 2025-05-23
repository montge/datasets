package unisa.gps.etour.repository;

import java.sql.SQLException;
import java.util.ArrayList;

import unisa.gps.etour.bean.BeanConvenzione;
import unisa.gps.etour.bean.BeanPuntoDiRistoro;

/**
 * Interface for managing the database Business
 *
 * @Author Joseph Martone
 * @Version 0.1 2007 eTour Project - Copyright by SE @SA Lab DMI University
 * Of Salerno
 */
public interface IDBConvenzione {

    /**
     * Add a convention in the database
     *
     * @param pConvenzione Convention by adding
     * @throws SQLException
     */
    public boolean inserisciConvenzione(BeanConvenzione pConvenzione)
            throws SQLException;

    /**
     * Modify a convention in the database
     *
     * @param pConvenzione Convention data of the Convention to be updated
     * @return True if there was a modified false otherwise
     * @throws SQLException
     */
    public boolean modificaConvenzione(BeanConvenzione pConvenzione)
            throws SQLException;

    /**
     * Delete an agreement by the database
     *
     * @param pIdConvenzione ID of the Convention by removing
     * @return True if been deleted false otherwise
     * @throws SQLException
     */
    public boolean cancellaConvenzione(int pIdConvenzione) throws SQLException;

    /**
     * Returns the historical conventions of a refreshment
     *
     * @param idPuntoDiRistoro point identification Refreshments
     * @return List of conventions of Refreshment given as argument
     * @throws SQLException
     */
    public ArrayList<BeanConvenzione> ottieniStoricoConvenzione(
            int idPuntoDiRistoro) throws SQLException;

    /**
     * Returns the Convention active a refreshment
     *
     * @param pIdPuntoDiRistoro point identification Refreshments
     * @return Convention Turns
     * @throws SQLException
     */
    public BeanConvenzione ottieniConvezioneAttiva(int pIdPuntoDiRistoro)
            throws SQLException;

    /**
     * Returns a list of all the PR that have a Convention active
     *
     * @return list of all the PR with the Convention active
     * @throws SQLException
     */
    public ArrayList<BeanPuntoDiRistoro> ottieniListaConvenzioneAttivaPR()
            throws SQLException;

}