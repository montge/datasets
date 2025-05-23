package unisa.gps.etour.repository;

import java.sql.SQLException;
import java.util.ArrayList;

import unisa.gps.etour.bean.BeanVisitaPR;

/**
 * Interface for managing feedback related to a specific point
 * Refreshments
 *
 * @Author Joseph Martone
 * @Version 0.1 2007 eTour Project - Copyright by SE @SA Lab DMI University
 * Of Salerno
 */
public interface IDBVisitaPR
{

    /**
    * Add a visit to a refreshment
    *
    * @param PVIS visit to add
    * @throws SQLException
    */
    public boolean inserisciVisitaPR(BeanVisitaPR PVIS) throws SQLException;

    /**
    * Modify a visit
    *
    * @param PVIS Visit to edit
    * @throws SQLException
    * @return True if and 'been changed otherwise false
    */
    public boolean modificaVisitaPR(BeanVisitaPR PVIS) throws SQLException;

    /**
    * Extract the list of visits to a refreshment
    *
    * @param pIdPuntoDiRistoro point identification Refreshments
    * @throws SQLException
    * @return List of visits
    */
    public ArrayList<BeanVisitaPR> ottieniListaVisitaPR(int pIdPuntoDiRistoro)
        throws SQLException;

    /**
    * Extract a visit by a tourist at a refreshment
    *
    * @param pIdPuntoDiRistoro point identification Refreshments
    * @param pIdTurista ID tourists
    * @throws SQLException
    * @return visit
    */
    public BeanVisitaPR ottieniVisitaPR(int pIdPuntoDiRistoro, int pIdTurista)
        throws SQLException;

    /**
    * Extract the list of visits of a tourist
    *
    * @param pIdTurista ID tourists
    * @return List of visits
    * @throws SQLException
    */
    public ArrayList<BeanVisitaPR> ottieniListaVisitaPRTurista(int pIdTurista)
        throws SQLException;

}