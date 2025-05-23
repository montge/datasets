package unisa.gps.etour.bean;

/**
 * Bean that contains the data for a Tag
 *
 * @author Mauro Miranda
 * @version 0.1 2007 eTour Project - Copyright by SE @SA Lab DMI University
 * Of Salerno
 */

import java.io.Serializable;

public class BeanTag implements Serializable
{
    private static final long serialVersionUID = -6320421006595188597L;
    private int id;
    private String name;
    private String description;

    /**
     * Parameterized constructor
     *
     * @param pId
     * @param Pnom
     * @param pDescrizione
     */
    public BeanTag(int pid, String Phnom, String pDescrizione)
    {
        setId(pid);
        setNome(Phnom);
        setDescrizione(pDescrizione);
    }

    /**
     * Empty Constructor
     */
    public BeanTag()
    {

    }

    /**
     * Returns the value of description
     *
     * @return value of description.
     */
    public String getDescrizione()
    {
        return description;
    }

    /**
     * Sets the new value of description
     *
     * @param pDescrizione New value of description.
     */
    public void setDescrizione(String pDescrizione)
    {
        description = pDescrizione;
    }

    /**
     * Returns the value of name
     *
     * @return value of name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the new value of name
     *
     * @param Pnom New value for name.
     */
    public void setNome(String Pnom)
    {
        name = Pnom;
    }

    /**
     * Returns the value of id
     *
     * @return value id.
     */
    public int getId()
    {
        return id;
    }

    /**
     * Sets the new value of id
     *
     * @param pId New value for id.
     */
    public void setId(int pid)
    {
        id = pid;
    }
}