package unisa.gps.etour.repository;

import java.sql.SQLException;
import java.util.ArrayList;

import unisa.gps.etour.bean.BeanPiatto;

/**
 * Interface for the management of food in the database
 *
 * @Author Joseph Martone
 * @Version 0.1 2007 eTour Project - Copyright by SE @ SA Lab DMI University
 * Of Salerno
 */
public interface IDBPiatto
{
    /**
     * Add a dish
     *
     * @param pPiatti plate add
     */
    public boolean inserisciPiatto(BeanPiatto pPiatto) throws SQLException;

    /**
     * Modify the data in a flat in the database
     *
     * @param pPiatti data plate to be inserted in database
     * @return True if there 'was a modified false otherwise
     */
    public boolean modificaPiatto(BeanPiatto pPiatto) throws SQLException;

    /**
     * Delete a dish from the database
     *
     * @param pIdPiatto ID plate eliminre
     * @throws SQLException
     * @return True if and 'was deleted false otherwise
     */
    public boolean cancellaPiatto(int pIdPiatto) throws SQLException;

    /**
     * Returns a list of dishes on a menu
     *
     * @param pIdMenu ID menu
     * @throws SQLException
     * @return list of dishes in the menu
     */
    public ArrayList<BeanPiatto> ottieniPiatto(int pIdMenu) throws SQLException;
}