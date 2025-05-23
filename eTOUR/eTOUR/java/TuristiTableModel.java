/*
 * TuristiTableModel.java
 *
 * 1.0
 *
 * 27/05/2007
 *
 * 2007 eTour Project - Copyright by SE @ SA Lab - DMI University of Salerno
 */
package unisa.gps.etour.gui.operatoreagenzia.tables;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

import unisa.gps.etour.bean.BeanTurista;


/**
 * <b> TuristiTableModel </b>
 * <p> Acts as a container of data from the tourists who have
 * Be displayed in a JTable. </p>
 * @see javax.swing.table.AbstractTableModel
 * @see javax.swing.JTable
 * @see unisa.gps.etour.bean.BeanTurista
 * @version 1.0
 * @author Mario Gallo
 */
public class TuristiTableModel extends AbstractTableModel {
    private static final String[] headers = {"Status", "Name", "Name", "E-Mail", "Phone",
            "Date of Birth", "City of Birth",
            "Address", "City", "CPC", "test", "Save"};
    private static final Class[] columnClasses = {Boolean.class, String.class, String.class,
            String.class, String.class, Date.class, String.class, String.class, String.class, String.class, String.class,
            Date.class};
    private Vector<Object[]> data;

    /**
    * Default Constructor. We only provide the template without loading
    * No data in it.
    */
    public TuristiTableModel() {
        data = new Vector<Object[]>();
    }

    /**
    * Create a model of the table and loads the data provided through an array of BeanBeneCulturale.
    *
    * @param pTuristi java.util.ArrayList<BeanTurista> - an ArrayList of BeanTurista.
    */
    public TuristiTableModel(ArrayList<BeanTurista> pTuristi) {
        this();
        if (null == pTuristi) {
            return;
        }
        for (int i = 0; i < pTuristi.size(); i++) {
            insertTurista(pTuristi.get(i));
        }
    }

    /**
    * Returns the number of columns provided by the model.
    *
    * @return int - the number of columns.
    */
    public int getColumnCount() {
        return headers.length;
    }

    /**
    * Returns the number of rows currently in the model.
    *
    * @return int - the number of rows.
    */
    public int GetRowCount() {
        return data.size();
    }

    /**
    * Returns the column name from the index provided.
    *
    * @return String - the name of the column.
    * @exception IllegalArgumentException - if the column index is not provided
    * In the model.
    */
    public String getColumnName(int pColumn) throws IllegalArgumentException {
        if (pColumn >= getColumnCount() || pColumn < 0) {
            throw new IllegalArgumentException(
                "The column index is not provided in the model.");
        }
        return headers[pColumn];
    }

    /**
    * Returns the object in the model to the row and column provided.
    *
    * @param pRow - the line number.
    * @param pColumn - the column number.
    * @return Object - the object contained in the selected cell.
    * @exception IllegalArgumentException - if the index or the row or column not provided
    * Are present in the model.
    */
    public Object getValueAt(int pRow, int pColumn)
        throws IllegalArgumentException {
        if (pRow >= GetRowCount() || pRow < 0) {
            throw new IllegalArgumentException(
                "The row index is not provided in the model.");
        }
        if (pColumn >= getColumnCount() || pColumn < 0) {
            throw new IllegalArgumentException(
                "The column index is not provided in the model.");
        }
        return data.get(pRow)[pColumn];
    }

    /**
    * Returns the class of objects in the column of which is provided in the index.
    *
    * @param pColumn - the column number.
    * @return Class - the class of objects of the selected column.
    * @exception IllegalArgumentException - if the index column does not pro
    * In the model.
    */
    public Class getColumnClass(int pColumn) throws IllegalArgumentException {
        if (pColumn >= getColumnCount() || pColumn < 0) {
            throw new IllegalArgumentException(
                "The column index is not provided in the model.");
        }
        return columnClasses[pColumn];
    }

    /**
    * Returns whether the selected cell editable.
    *
    * @return boolean - true if the cell editable
    * False otherwise
    * @param pRow - the line number.
    * @param pColumn - the column number.
    * @exception IllegalArgumentException - if the index or the row or column are not provided
    * In the model.
    */
    public boolean isCellEditable(int pRow, int pColumn)
        throws IllegalArgumentException {
        return false;
    }

    /**
    * The method is inherited by the TableModel not setValueAt
    * Necessary because not provided for the possibility of amending a
    * Single cell.
    *
    * @deprecated
    */
    public void setValueAt(Object value, int row, int col) {

    }

    /**
    * Enables or disables the tourist in the selected row.
    *
    * @param pRow int - the selected row.
    * @return int - the id of the tourist on / off.
    */
    public int attivaTurista(int pRow) throws IllegalArgumentException {
        data.get(pRow)[0] = (isAttivato(pRow)) ? false : true;
        fireTableDataChanged();
        return getID(pRow);
    }

    /**
    * Determines if a visitor to the selected row is enabled or disabled.
    *
    * @param pRow int - the selected row.
    * @return <ul> <li> <i> true </i> - enabled </li>
    * <li> <i> False </i> - disabled </li> </ul>
    */
    public boolean isAttivato(int pRow) throws IllegalArgumentException {
        return (Boolean) getValueAt(pRow, 0);
    }

    /**
    *
    * Enter data for a tourist in the model since its Bean.
    *
    * @param pTurista BeanTurisa - the bean that contains the data of the tourist.
    */
    public void insertTurista(BeanTurista pTurista) throws IllegalArgumentException {
        if (null == pTurista) {
            throw new IllegalArgumentException(
                "The bean provided can not be null.");
        }
        Object[] aRow = new Object[13];
        aRow[0] = pTurista.isAttiva();
        aRow[1] = pTurista.getNome();
        aRow[2] = pTurista.getCognome();
        aRow[3] = pTurista.getEmail();
        aRow[4] = pTurista.getTelefono();
        aRow[5] = pTurista.getDataNascita();
        aRow[6] = pTurista.getCittaNascita();
        aRow[7] = pTurista.getVia();
        aRow[8] = pTurista.getCittaResidenza();
        aRow[9] = pTurista.getCap();
        aRow[10] = pTurista.getProvincia();
        aRow[11] = pTurista.getDataRegistrazione();
        aRow[12] = pTurista.getId();
        data.add(aRow);
    }

    /**
    *
    * Update the information of the tourist in the model (if any)
    * With the bean supplied input.
    *
    * @param pTurista BeanTurista - the bean that contains the data of the tourist.
    */
    public void updateTurista(BeanTurista pTurista) throws IllegalArgumentException {
        if (null == pTurista) {
            throw new IllegalArgumentException(
                "The bean provided can not be null.");
        }
        int i;
        for (i = 0; i < data.size(); i++) {
            int id = (Integer) data.get(i)[12];
            if (id == pTurista.getId()) {
                break;
            }
        }
        if (i != data.size()) // Found
        {
            Object[] aRow = new Object[13];
            aRow[0] = pTurista.isAttiva();
            aRow[1] = pTurista.getNome();
            aRow[2] = pTurista.getCognome();
            aRow[3] = pTurista.getEmail();
            aRow[4] = pTurista.getTelefono();
            aRow[5] = pTurista.getDataNascita();
            aRow[6] = pTurista.getCittaNascita();
            aRow[7] = pTurista.getVia();
            aRow[8] = pTurista.getCittaResidenza();
            aRow[9] = pTurista.getCap();
            aRow[10] = pTurista.getProvincia();
            aRow[11] = pTurista.getDataRegistrazione();
            aRow[12] = pTurista.getId();
            data.set(i, aRow);
            fireTableDataChanged();
        }
    }

    /**
    *
    * Returns the id of the visitor whose data are displayed in row
    * Provided input.
    *
    * @param pRow - the line number.
    * @return - the id of the tourist.
    * @exception IllegalArgumentException - if the row index does not pro
    * In the model.
    */
    public int getID(int pRow) throws IllegalArgumentException {
        if (pRow >= GetRowCount() || pRow < 0) {
            throw new IllegalArgumentException(
                "The row index is not provided in the model.");
        }
        return (Integer) data.get(pRow)[12];
    }

    /**
    *
    * Returns the id of the tourist at the line number provided as input and removes it from the model.
    *
    * @param pRow - the line number.
    * @return - the id of the tourist.
    * @exception IllegalArgumentException - if the row index does not pro
    * In the model.
    */
    public int removeTurista(int pRow) throws IllegalArgumentException {
        int id = getID(pRow);
        data.remove(pRow);
        return id;
    }
}