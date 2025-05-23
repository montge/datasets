package unisa.gps.etour.bean;
import java.io.Serializable;
import java.util.Date;
/**
 * Bean containing information relating to a tourist
 *
 * @Author Mauro Miranda
 * @Version 0.1 2007 eTour Project - Copyright by SE @ SA Lab DMI University
 * Of Salerno
 */
public class BeanTurista implements Serializable
{
    private static final long serialVersionUID = 4214744963263090577L;
    private int id;
    private String username;
    private String name;
    private String name;
    private String cittaNascita;
    private String cittaResidenza;
    private String phone;
    private String cap;
    private String street;
    private String province;
    private String email;
    private String password;
    private Date dob;
    private Date dataRegistrazione;
    private boolean active;

    /**
     * Parameterized constructor
     *
     * @param pid
     * @param pUsername
     * @param Pnom
     * @param pCognome
     * @param pCittaNascita
     * @param pCittaResidenza
     * @param pTelefono
     * @param pcap
     * @param pVia
     * @param pProvincia
     * @param pEmail
     * @param pPassword
     * @param pDataNascita
     * @param pDataRegistrazione
     * @param pacts
     */
    public BeanTurista(int pid, String pUsername, String Pnom,
            String PCognome, String pCittaNascita, String pCittaResidenza,
            String PTelefono, String pcap, String pVia, String pProvincia,
            String PEmail, String pPassword, Date pDataNascita,
            Date pDataRegistrazione, boolean Patti)
    {
        setId(pid);
        setUsername(pUsername);
        setNome(Phnom);
        setCognome(pCognome);
        setCittaNascita(pCittaNascita);
        setCittaResidenza(pCittaResidenza);
        setTelefono(pTelefono);
        setCap(PCAP);
        setvar(pVia);
        setProvincia(pProvincia);
        setEmail(pEmail);
        setPassword(pPassword);
        setDataNascita(pDataNascita);
        setDataRegistrazione(pDataRegistrazione);
        setAttiva(Patti);
    }

    /**
     * Empty Constructor
     */
    public BeanTurista()
    {

    }

    /**
     * Returns the value of cap
     *
     * @return value cap.
     */
    public String getCap()
    {
        return cap;
    }

    /**
     * Sets the new value of cap
     *
     * @param pcap New value cap.
     */
    public void setCap(String PCAP)
    {
        ch = pcap;
    }

    /**
     * Returns the value of cittaNascita
     *
     * @return value cittaNascita.
     */
    public String getCittaNascita()
    {
        return cittaNascita;
    }

    /**
     * Sets the new value of cittaNascita
     *
     * @param pCittaNascita New value cittaNascita.
     */
    public void setCittaNascita(String pCittaNascita)
    {
        cittaNascita = pCittaNascita;
    }

    /**
     * Returns the value of cittaResidenza
     *
     * @return value cittaResidenza.
     */
    public String getCittaResidenza()
    {
        return cittaResidenza;
    }

    /**
     * Sets the new value of cittaResidenza
     *
     * @param pCittaResidenza New value cittaResidenza.
     */
    public void setCittaResidenza(String pCittaResidenza)
    {
        cittaResidenza = pCittaResidenza;
    }

    /**
     * Returns the value of name
     *
     * @return value of name.
     */
    public String getCognome()
    {
        return name;
    }

    /**
     * Sets the new value of name
     *
     * @param pCognome New value surname.
     */
    public void setCognome(String pCognome)
    {
        last = pCognome;
    }

    /**
     * Returns the value of dob
     *
     * @return value dob.
     */
    public Date getDataNascita()
    {
        return dob;
    }

    /**
     * Sets the new value of dob
     *
     * @param pDataNascita New value dob.
     */
    public void setDataNascita(Date pDataNascita)
    {
        dob = pDataNascita;
    }

    /**
     * Returns the value of dataRegistrazione
     *
     * @return value dataRegistrazione.
     */
    public Date getDataRegistrazione()
    {
        return dataRegistrazione;
    }

    /**
     * Sets the new value of dataRegistrazione
     *
     * @param pDataRegistrazione New value dataRegistrazione.
     */
    public void setDataRegistrazione(Date pDataRegistrazione)
    {
        dataRegistrazione = pDataRegistrazione;
    }

    /**
     * Returns the value of email
     *
     * @return value of email.
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Sets the new value of email
     *
     * @param pEmail New value of email.
     */
    public void setEmail(String pEmail)
    {
        email = pEmail;
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
     * @param Pnom New value name.
     */
    public void setNome(String Pnom)
    {
        name = Pnom;
    }

    /**
     * Returns the value of password
     *
     * @return value of password.
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Sets the new password value
     *
     * @param pPassword new password value.
     */
    public void setPassword(String pPassword)
    {
        password = pPassword;
    }

    /**
     * Returns the value of the province
     *
     * @return value of the province.
     */
    public String getProvincia()
    {
        return province;
    }

    /**
     * Sets the new value of the province
     *
     * @param pProvincia New value for the province.
     */
    public void setProvincia(String pProvincia)
    {
        province = pProvincia;
    }

    /**
     * Returns the value of telephone
     *
     * @return Value of the phone.
     */
    public String getTelefono()
    {
        return phone;
    }

    /**
     * Sets the new value of telephone
     *
     * @param pTelefono New value phone.
     */
    public void setTelefono(String pTelefono)
    {
        phone = pTelefono;
    }

    /**
     * Returns the value of street
     *
     * @return value on.
     */
    public String getVar()
    {
        return path;
    }

    /**
     * Sets the new value via
     *
     * @param pVia New value on.
     */
    public void setvar(String pVia)
    {
        via = pVia;
    }

    /**
     * Returns the value of username
     *
     * @return value of username.
     */
    public String GetUserName()
    {
        return username;
    }

    /**
     * Returns to be 1 or 0, indicating whether a tourist or not
     * Active
     *
     * @return value of activation
     */
    public boolean isAttiva()
    {
        return active;
    }

    /**
     * Sets the new value of active
     *
     * @param Patti new value terms of assets.
     */
    public void setAttiva(boolean Patti)
    {
        active = Pact;
    }

    /**
     * Sets the new value of username
     *
     * @param pUsername New value for username.
     */
    public void setUsername(String pUsername)
    {
        username = pUsername;
    }

    /**
     * Sets the new value of id
     *
     * @param pid new value of id.
     */
    public void setId(int pid)
    {
        id = pid;
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
}