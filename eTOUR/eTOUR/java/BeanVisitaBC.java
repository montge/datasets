package unisa.gps.etour.bean;
import java.io.Serializable;
import java.util.Date;
/**
 * Bean containing information relating to the feedback of a cultural
 *
 * @Author Joseph Martone
 * @Version 0.1 2007 eTour Project - Copyright by SE @SA Lab DMI University
 * Of Salerno
 */
public class BeanVisitaBC implements Serializable
{
    private static final long serialVersionUID = 3331567128449243852L;
    private int rating;
    private int idBeneCulturale;
    private String comment;
    private int IdTurista;
    private Date dataVisita;

    /**
     * Parameterized constructor
     *
     * @param pVoto
     * @param pIdBeneCulturale
     * @param pCommento
     * @param pIdTurista
     * @param pDataVisita
     */
    public BeanVisitaBC(int pVoto, int pIdBeneCulturale,
            String pCommento, int pIdTurista, Date pDataVisita)
    {
        setVoto(pVoto);
        setIdBeneCulturale(pIdBeneCulturale);
        setCommento(pCommento);
        setIdTurista(pIdTurista);
        setDataVisita(pDataVisita);
    }

    /**
     * Empty Constructor
     */
    public BeanVisitaBC()
    {

    }

    /**
     * Returns the value of comment
     *
     * @return value of comment.
     */
    public String getCommento()
    {
        return comment;
    }

    /**
     * Sets the new value of comment
     *
     * @param pCommento New value comment.
     */
    public void setCommento(String pCommento)
    {
        comment = pCommento;
    }

    /**
     * Returns the value of dataVisita
     *
     * @return value dataVisita.
     */
    public Date getDataVisita()
    {
        return dataVisita;
    }

    /**
     * Sets the new value of dataVisita
     *
     * @param pDataVisita New value dataVisita.
     */
    public void setDataVisita(Date pDataVisita)
    {
        dataVisita = pDataVisita;
    }

    /**
     * Returns the value of idBeneCulturale
     *
     * @return value idBeneCulturale.
     */
    public int getIdBeneCulturale()
    {
        return idBeneCulturale;
    }

    /**
     * Sets the new value of idBeneCulturale
     *
     * @param pIdBeneCulturale New value idBeneCulturale.
     */
    public void setIdBeneCulturale(int pIdBeneCulturale)
    {
        idBeneCulturale = pIdBeneCulturale;
    }

    /**
     * Returns the value of IdTurista
     *
     * @return value IdTurista.
     */
    public int getIdTurista()
    {
        return IdTurista;
    }

    /**
     * Sets the new value of IdTurista
     *
     * @param pIdTurista New value IdTurista.
     */
    public void setIdTurista(int pIdTurista)
    {
        IdTurista = pIdTurista;
    }

    /**
     * Returns the value of voting
     *
     * @return value of vote.
     */
    public int getVoto()
    {
        return rating;
    }

    /**
     * Sets the new value of voting
     *
     * @param pVoto New value to vote.
     */
    public void setVoto(int pVoto)
    {
        rating = pVoto;
    }
}