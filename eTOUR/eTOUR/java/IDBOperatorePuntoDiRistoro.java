package unisa.gps.etour.repository;

import java.sql.SQLException;

import unisa.gps.etour.bean.BeanOperatorePuntoDiRistoro;

/**
 * Interface for the operator to the point of comfort in the database
 *
 * @Author Joseph Martone
 * @Version 0.1 2007 eTour Project - Copyright by SE @ SA Lab DMI University
 * Of Salerno
 */
public interface IDBOperatorePuntoDiRistoro
{
    /**
     * Adds an operator refreshment
     *
     * @param popera Additional operating
     * @throws SQLException
     */
    public boolean inserisciOperatorePuntoDiRistoro(
            BeanOperatorePuntoDiRistoro popera) throws SQLException;

    /**
     * Modify an operator in the database
     *
     * @param popera New data Operator
     * @throws SQLException
     * @return True if there 'was a modified false otherwise
     */
    public boolean modificaOperatorePuntoDiRistoro(
            BeanOperatorePuntoDiRistoro popera) throws SQLException;

    /**
     * Delete an operator
     *
     * @param pIdOperatore Operator ID to delete
     * @throws SQLException
     * @return True if and 'was deleted false otherwise
     */
    public boolean cancellaOperatorePuntoDiRistoro(int pIdOperatore)
            throws SQLException;

    /**
     * Returns data operator
     *
     * @param pIdOperatore Operation ID
     * @throws SQLException
     * @return Operator refreshment
     */
    public BeanOperatorePuntoDiRistoro ottieniOperatorePuntoDiRistoro(
            int pIdOperatore) throws SQLException;
}