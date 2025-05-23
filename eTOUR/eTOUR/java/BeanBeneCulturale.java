package unisa.gps.etour.bean;

/**
 * Bean containing information relating to a cultural heritage
 *
 * @Author Mauro Miranda
 * @Version 0.1 2007 eTour Project - Copyright by SE @ SA Lab DMI University
 * Of Salerno
 */

import java.io.Serializable;
import java.util.Date;

import unisa.gps.etour.util.Punto3D;

public class BeanBeneCulturale implements Serializable
{

    private static final long serialVersionUID = -460705346474984466L;

    private int id;
    private int numeroVoti;
    private String name;
    private String city;
    private String phone;
    private String description;
    private String location;
    private String street;
    private String cap;
    private String province;
    private String giornoChiusura;
    private Punto3D position;
    private Date orarioApertura;
    private Date orarioChiusura;
    private double costoBiglietto;
    private double mediaVoti;

    /**
     * Parameterized constructor
     *
     * @param pId
     * @param pNumeroVoti
     * @param Pnom
     * @param pCitta
     * @param pTelefono
     * @param pDescrizione
     * @param pLocalita
     * @param pVia
     * @param pcap
     * @param pProvincia
     * @param pPosizione
     * @param pOrarioApertura
     * @param pOrarioChiusura
     * @param pGiornoChiusura
     * @param pCostoBiglietto
     * @param pMediaVoti
     */
    public BeanBeneCulturale(int pid, int pNumeroVoti, String Pnom,
            String pCitta, String pTelefono, String pDescrizione,
            String pLocalita, String pVia, String pcap, String pProvincia,
            Punto3D pPosizione, Date pOrarioApertura, Date pOrarioChiusura,
            String pGiornoChiusura, double pCostoBiglietto, double pMediaVoti)
    {
        setId(pid);
        setNumeroVoti(pNumeroVoti);
        setNome(Pnom);
        setCitta(pCitta);
        setTelefono(pTelefono);
        setDescrizione(pDescrizione);
        setLocale(pLocalita);
        setvar(pVia);
        setCap(pcap);
        setProvincia(pProvincia);
        setPosizione(pPosizione);
        setOrarioApertura(pOrarioApertura);
        setOrarioChiusura(pOrarioChiusura);
        setGiornoChiusura(pGiornoChiusura);
        setCostoBiglietto(pCostoBiglietto);
        setMediaVoti(pMediaVoti);
    }

    /**
     * Empty Constructor
     */
    public BeanBeneCulturale()
    {

    }

    /**
     * Returns the value of giornoChiusura
     *
     * @return value giornoChiusura.
     */
    public String getGiornoChiusura()
    {
        return giornoChiusura;
    }

    /**
     * Sets the new value of giornoChiusura
     *
     * @param pGiornoChiusura New value giornoChiusura.
     */
    public void setGiornoChiusura(String pGiornoChiusura)
    {
        giornoChiusura = pGiornoChiusura;
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
    public void setCap(String pcap)
    {
        cap = pcap;
    }

    /**
     * Returns the value of city
     *
     * @return Value of city.
     */
    public String getCitta()
    {
        return city;
    }

    /**
     * Sets the new value of city
     *
     * @param pCitta New value city.
     */
    public void setCitta(String pCitta)
    {
        city = pCitta;
    }

    /**
     * Returns the value of costoBiglietto
     *
     * @return value costoBiglietto.
     */
    public double getCostoBiglietto()
    {
        return costoBiglietto;
    }

    /**
     * Sets the new value of costoBiglietto
     *
     * @param pCostoBiglietto New value costoBiglietto.
     */
    public void setCostoBiglietto(double pCostoBiglietto)
    {
        costoBiglietto = pCostoBiglietto;
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
     * Returns the value of location
     *
     * @return locale values.
     */
    public String getLocal()
    {
        return location;
    }

    /**
     * Sets the new value of location
     *
     * @param pLocalita New locale values.
     */
    public void setLocale(String pLocalita)
    {
        location = pLocalita;
    }

    /**
     * Returns the value of mediaVoti
     *
     * @return value mediaVoti.
     */
    public double getMediaVoti()
    {
        return mediaVoti;
    }

    /**
     * Sets the new value of mediaVoti
     *
     * @param pMediaVoti New value mediaVoti.
     */
    public void setMediaVoti(double pMediaVoti)
    {
        mediaVoti = pMediaVoti;
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
     * Returns the value of numeroVoti
     *
     * @return value numeroVoti.
     */
    public int getNumeroVoti()
    {
        return numeroVoti;
    }

    /**
     * Sets the new value of numeroVoti
     *
     * @param pNumeroVoti New value numeroVoti.
     */
    public void setNumeroVoti(int pNumeroVoti)
    {
        numeroVoti = pNumeroVoti;
    }

    /**
     * Returns the value of orarioApertura
     *
     * @return value orarioApertura.
     */
    public Date getOrarioApertura()
    {
        return orarioApertura;
    }

    /**
     * Sets the new value of orarioApertura
     *
     * @param pString New value orarioApertura.
     */
    public void setOrarioApertura(Date pString)
    {
        orarioApertura = pString;
    }

    /**
     * Returns the value of orarioChiusura
     *
     * @return value orarioChiusura.
     */
    public Date getOrarioChiusura()
    {
        return orarioChiusura;
    }

    /**
     * Sets the new value of orarioChiusura
     *
     * @param pOrarioChiusura New value orarioChiusura.
     */
    public void setOrarioChiusura(Date pOrarioChiusura)
    {
        orarioChiusura = pOrarioChiusura;
    }

    /**
     * Returns the value of position
     *
     * @return value of position.
     */
    public Punto3D getPosizione()
    {
        return position;
    }

    /**
     * Sets the new position value
     *
     * @param pPosizione New position value.
     */
    public void setPosizione(Punto3D pPosizione)
    {
        position = pPosizione;
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
        return street;
    }

    /**
     * Sets the new value via
     *
     * @param pVia New value on.
     */
    public void setvar(String pVia)
    {
        street = pVia;
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