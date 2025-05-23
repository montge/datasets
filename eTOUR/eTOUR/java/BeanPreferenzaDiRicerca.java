package unisa.gps.etour.bean;
import java.io.Serializable;

/**
 * Bean which contains data search preferences
 *
 * @author Joseph Martone
 * @version 0.1 2007 eTour Project - Copyright by SE @ SA Lab DMI University
 * Of Salerno
 */
public class BeanPreferenzaDiRicerca implements Serializable
{
    private static final long serialVersionUID = 7576354037868937929L;
    private int id;
    private String name;

    /**
     * Parameterized constructor
     *
     * @param pId
     * @param Pnom
     */
    public BeanPreferenzaDiRicerca(int pid, String Pnom)
    {
        setId(pid);
        setNome(Pnom);
    }

    /**
     * Empty Constructor
     *
     */
    public BeanPreferenzaDiRicerca()
    {

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
     * Sets the new name value
     *
     * @param Pnom New value Pnom.
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
     * @param pid New value for id.
     */
    public void setId(int pid)
    {
        id = pid;
    }
}