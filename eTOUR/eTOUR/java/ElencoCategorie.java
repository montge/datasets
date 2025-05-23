package unisa.gps.etour.control.fuzzy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class ElencoCategorie implements Serializable {

    /**
     * Keeps track of data in each category
     */
    private static final long serialVersionUID = 1L;
    private Hashtable<String, Categoria> categorie; // hash table that keeps
                                                    // For each category a
                                                    // Class category
    private Hashtable<String, float[]> totTermini; // hash table that keeps
                                                   // The terms of all
                                                   // Categories
    float maxDist; // contains the maximum distances

    /**
     * The constructor initializes the two hash tables that contain
     * Categories and terms of all categories
     */
    public ElencoCategorie() {
        categorie = new Hashtable<String, Categoria>();
        totTermini = new Hashtable<String, float[]>();
    }

    /**
     * Access method attribute maxDist
     *
     * @return the maximum distance of all the terms in all categories
     */
    public float getMaxDist() {
        return maxDist;
    }

    /**
     * Access method to the table of categories
     *
     * @return categories
     */
    public Hashtable<String, Categoria> getAllCategorie() {
        return categorie;
    }

    /**
     * Method of accessing the table of total time
     *
     * @return totTermini
     */
    public Hashtable<String, float[]> getTotTermini() {
        return totTermini;
    }

    /**
     * Method to access a category in the table of
     * Categories
     *
     * @param pNomeCategoria
     * @return object categories representing the category name
     * pNomeCategoria
     */
    public Categoria getCategoria(String pNomeCategoria) {
        if (esisteCategoria(pNomeCategoria)) // if there is the appropriate category
            return categorie.get(pNomeCategoria); // returns the
                                                  // Assciato to pNomeCategoria

        return null; // otherwise null
    }

    /**
     * Method of accessing the values of a particular term in this
     * Category table
     *
     * @param pTermine
     * @return Returns the values associated with the term pTermine
     */
    public float[] getTermine(String pTermine) {
        if (esisteTermine(pTermine)) // if the term is present in tebella
                                     // Terms of total
            return (float[]) totTermini.get(pTermine); // return the vaolre
                                                       // Associate

        return null; // null otherwise
    }

    /**
     * Method which allows you to add a category to the table of
     * Categories
     *
     * @param pNomeCategoria category name to add
     * @param pCategoria object associated category
     * @return true if the operation was successfully carried out false
     * Otherwise
     */
    public boolean addCategoria(String pNomeCategoria, Categoria pCategoria) {
        if (!esisteCategoria(pNomeCategoria)) // if the category exists
            return false; // returns false

        categorie.put(pNomeCategoria, pCategoria); // otherwise load the
                                                  // Category in the table

        return true; // returns true
    }

    /**
     * Edit a category of the category table
     *
     * @param pNomeCategoria category name to edit
     * @param pCategoria object to be associated with this category
     * @return true if the operation was successfully carried out false
     * Otherwise
     */
    public boolean setCategoria(String pNomeCategoria, Categoria pCategoria) {
        if (esisteCategoria(pNomeCategoria)) // if the category does not exist
            return false; // returns false

        categorie.put(pNomeCategoria, pCategoria); // update the table of
                                                  // Catogorie

        return true; // returns true
    }

    /**
     * Method which allows you to set the value of a term in the tables
     * Total time
     *
     * @param pTermine name term
     * @param pVal value to associate with the term
     */
    public void setTermine(String pTermine, float[] pVal) {
        totTermini.put(pTermine, pVal);
    }

    /**
     * Method which allows the value of the seven kings of the maximum distance of
     * Terms from one category
     *
     * @param pMaxDist
     */
    public void setMaxDist(float pMaxDist) {
        maxDist = pMaxDist;
    }

    /**
     * Method which allows to derive a collection of names of iterable
     * All categories in the categories tabela
     *
     * @return string iterable Collection
     */
    public Iterable<String> Categories() {
        List<String> toReturn = new ArrayList<String>();// create a new list
        for (Enumeration<String> val = categorie.keys(); val.hasMoreElements();)// iterates
                                                                              // N
                                                                              // Times
                                                                              // Where
                                                                              // N is
                                                                              // The
                                                                              // Number
                                                                              // By
                                                                              // Categories
                                                                              // Current
                                                                              // In
                                                                              // Table
        {
            toReturn.add(val.nextElement());// adds to the list the name of
                                           // A category
        }

        return toReturn;
    }

    /**
     * Method aids to verify the existence of a category
     * In the table of categories
     *
     * @param pKey name of the category
     * @return true if the category exists false otherwise
     */
    public boolean esisteCategoria(String pKey) {
        try {
            categorie.get(pKey); // try to extract the category name pKey
                                // The table of categories
            return true; // if the transaction does not raise exceptions category
                         // Exists and returns true
        }
        catch (NullPointerException e) {
            return false; // false otherwise
        }
    }

    /**
     * Method aids to verify the existence of a term
     * In the table of total time
     *
     * @param pKey term
     * @return true if the term exists false otherwise
     */
    public boolean esisteTermine(String pKey) {
        // see esisteCategoria
        try {
            if (totTermini.get(pKey) != null)
                return true;
        }
        catch (NullPointerException e) {
            return false;
        }

        return false;
    }
}