package unisa.gps.etour.repository;

import java.sql.SQLException;
import java.util.ArrayList;

import unisa.gps.etour.bean.BeanVisitaBC;

/**
 * Interface for handling feedback on a given asset
 * Cultural
 *
 * @Author Joseph Martone
 * @Version 0.1 2007 eTour Project - Copyright by SE @ SA Lab DMI University
 * Of Salerno
 */
public interface IDBVisitaBC {

    /**
     * Inserts a visit
     *
     * @param PVIS Visit to insert
     * @throws SQLException
     */
    public boolean inserisciVisitaBC(BeanVisitaBC PVIS) throws SQLException;

    /**
     * Modify a visit
     *
     * @param PVIS Visit to edit
     * @throws SQLException
     * @return True if and 'been changed otherwise false
     */
    public boolean modificaVisitaBC(BeanVisitaBC PVIS) throws SQLException;

    /**
     * Extract the list of visits to a cultural
     *
     * @param pIdBeneCulturale ID of the cultural
     * @throws SQLException
     * @return list of visits of the cultural
     */
    public ArrayList<BeanVisitaBC> ottieniListaVisitaBC(int pIdBeneCulturale)
            throws SQLException;

    /**
     * Extract the list of cultural visited by a tourist
     *
     * @param pIdTurista ID tourists
     * @throws SQLException
     * @return ArrayList of all feedback issued by a tourist for a
     * Specified cultural
     */
    public ArrayList<BeanVisitaBC> ottieniListaVisitaBCTurista(int pIdTurista)
            throws SQLException;

    /**
     * Extract a visit by a tourist to a cultural
     *
     * @param pIdBeneCulturale ID of the cultural
     * @param pIdTurista ID tourists
     * @throws SQLException
     * @return visit
     */
    public BeanVisitaBC ottieniVisitaBC(int pIdBeneCulturale, int pIdTurista)
            throws SQLException;
}