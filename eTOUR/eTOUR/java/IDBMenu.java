package unisa.gps.etour.repository;

import java.sql.SQLException;
import java.util.ArrayList;

import unisa.gps.etour.bean.BeanMenu;

/**
 * Interface for managing the menu in the database
 *
 * @Author Joseph Martone
 * @Version 0.1 2007 eTour Project - Copyright by SE @SA Lab DMI University
 * Of Salerno
 */
public interface IDBMenu
{
    /**
     * Adds a menu in the database
     *
     * @param pMenu menu to add
     * @throws SQLException
     */
    public boolean inserisciMenu(BeanMenu pMenu) throws SQLException;

    /**
     * Modify a menu in the database
     *
     * @param pMenu Contains the data to change
     * @throws SQLException
     * @return True if there 'was a modified false otherwise
     */
    public boolean modificaMenu(BeanMenu pMenu) throws SQLException;

    /**
     * Delete a menu from database
     *
     * @param pIdMenu ID menu to delete
     * @throws SQLException
     * @return True if and 'was deleted false otherwise
     */
    public boolean cancellaMenu(int pIdMenu) throws SQLException;

    /**
     * Returns the menu of the day of a refreshment
     *
     * @param pIdPuntoDiRistoro point identification Refreshments
     * @param pGiorno Day of the week in which the menu
     * Daily
     * @throws SQLException
     * @return Day menu de Refreshment
     */
    public BeanMenu ottieniMenuDelGiorno(int pIdPuntoDiRistoro, String pGiorno)
            throws SQLException;

    /**
     * Returns a list of the menu of a refreshment
     *
     * @param pIdPuntoDiRistoro point identification Refreshment
     * @throws SQLException
     * @return List of menus
     */
    public ArrayList<BeanMenu> ottieniMenu(int pIdPuntoDiRistoro)
            throws SQLException;
}