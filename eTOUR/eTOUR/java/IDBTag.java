package unisa.gps.etour.repository;

import java.sql.SQLException;
import java.util.ArrayList;

import unisa.gps.etour.bean.BeanTag;

/**
 * Interface for managing the database Tag
 *
 * @Author Mauro Miranda
 * @Version 0.1 2007 eTour Project - Copyright by SE @SA Lab DMI University
 * Of Salerno
 */
public interface IDBTag
{
    /**
     * Add a tag
     *
     * @param ptagi Tag to add
     * @throws SQLException
     */
    public boolean inserisciTag(BeanTag ptagi) throws SQLException;

    /**
     * Modify the data in a tag
     *
     * @param ptagi Tag to modify
     * @throws SQLException
     * @return True if and 'been changed otherwise false
     */
    public boolean modificaTag(BeanTag ptagi) throws SQLException;

    /**
     * Delete a tag from the database
     *
     * @param pIdTag ID Tag to be deleted
     * @throws SQLException
     * @return True if and 'was deleted false otherwise
     */
    public boolean cancellaTag(int pIdTag) throws SQLException;

    /**
     * Returns the list of tags in the database
     *
     * @throws SQLException
     * @return List containing the tags
     */
    public ArrayList<BeanTag> ottieniListaTag() throws SQLException;

    /**
     * Returns a single tag
     *
     * @param pId ID tag
     * @throws SQLException
     * @return Tags
     */
    public BeanTag ottieniTag(int pid) throws SQLException;

    /**
     * Tag with immovable cultural
     *
     * @param pIdBeneCulturale ID of Cultural Heritage
     * @param pIdTag ID tag
     * @throws SQLException
     */
    public boolean aggiungeTagBeneCulturale(int pIdBeneCulturale, int pIdTag)
        throws SQLException;

    /**
     * Tag to a refreshment
     *
     * @param pIdPuntoDiRistoro point identification Refreshments
     * @param pIdTag ID tag
     * @throws SQLException
     */
    public boolean aggiungeTagPuntoDiRistoro(int pIdPuntoDiRistoro, int pIdTag)
        throws SQLException;

    /**
     * Returns the list of tags of a cultural
     *
     * @param pIdBeneCulturale ID of Cultural Heritage
     * @throws SQLException
     * @return list of tags
     */
    public ArrayList<BeanTag> ottieniTagBeneCulturale(int pIdBeneCulturale)
        throws SQLException;

    /**
     * Returns a list of tags of a refreshment
     *
     * @param pIdPuntoDiRistoro point identification Refreshments
     * @throws SQLException
     * @return list of tags
     */
    public ArrayList<BeanTag> ottieniTagPuntoDiRistoro(int pIdPuntoDiRistoro)
        throws SQLException;

    /**
     * Delete a tag to a cultural
     *
     * @param pIdBeneCulturale ID of Cultural Heritage
     * @param pIdTag ID tag
     * @throws SQLException
     * @return True if and 'was deleted false otherwise
     */
    public boolean cancellaTagBeneCulturale(int pIdBeneCulturale, int pIdTag)
        throws SQLException;

    /**
     * Delete a tag to a refreshment
     *
     * @param pIdPuntoDiRistoro ID
     * @param pIdTag ID tag
     * @throws SQLException
     * @return True if and 'was deleted false otherwise
     */
    public boolean cancellaTagPuntoDiRistoro(int pIdPuntoDiRistoro, int pIdTag)
        throws SQLException;
}