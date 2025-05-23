package unisa.gps.etour.control.GestioneUtentiRegistrati;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface relating to operations performed by the User login and logout
 * Register
 *
 * @Author Joseph Penna
 * @Version 0.1 2007 eTour Project - Copyright by SE @SA Lab University of DMI
 * Salerno
 */
public interface IAutenticazione extends Remote
{

    // Static constants that identify the type of users who
    // True
    public static final byte VISITORS = 0;
    public static final byte OP_PUNTO_DI_RISTORO = 1;

    /**
     * Method to authenticate a registered user (Turista - Operator
     * Refreshment)
     *
     * @param pUsername Username on a Registered User
     * @param pPassword password for Registered User
     * @param pTipologiaUtente type user is authenticated
     * @return If the data are correct user ID logged in the event
     * Otherwise -1
     */
    public int login(String pUsername, String pPassword, byte pTipologiaUtente)
            throws RemoteException;

}