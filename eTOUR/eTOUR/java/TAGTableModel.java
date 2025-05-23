/*
* TAGTableModel.java
*
* 1.0
*
* 28/05/2007
*
* © 2007 eTour Project - Copyright by SE @ SA Lab - DMI - University of Salerno
*/
package unisa.gps.etour.gui.operatoreagenzia;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import unisa.gps.etour.bean.BeanTag;
/**
* <p>
* <B> Title: </B> TagTableModel
* </p>
* <p>
* <B> Description: </B> TableModel for dynamic management of Table
* Within the section GestioneTag
* </p>
*
* @Author _Lello_
* @Version 1.0
*/

public class TAGTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private static final String[] headers = {"Name", "Description"};
    private static final Class[] columnClasses = {String.class, String.class};
    private Vector<Object[]> data;

    /**
     * Constructor for class TagTableModel
     *
     * @param tags BeanTag[]
     *
     */
    public TAGTableModel(BeanTag[] tags) {
        data = new Vector<Object[]>();
        for (int i = 0; i < tags.length; i++) {
            Object[] newRow = new Object[10];
            newRow[0] = tags[i].getId();
            newRow[1] = tags[i].getName();
            newRow[2] = tags[i].getDescrizione();
        }
    }

    /**
     * Returns the number of columns
     *
     */
    public int getColumnCount() {
        return headers.length;
    }

    /**
     * Returns the number of rows
     *
     */
    public int GetRowCount() {
        return data.size();
    }

    /**
     * Returns the column heading i_esima
     *
     * @param pCol
     *
     */
    public String getColumnName(int pCol) {
        return headers[pCol];
    }

    /**
     * Returns the coordinates given by the pair of row, column
     *
     * @param pRow
     * @param pCol
     *
     */
    public Object getValueAt(int pRow, int pCol) {
        return data.get(pRow)[pCol];
    }

    /**
     * Returns the column pCol
     *
     * @param pCol
     *
     */
    public Class getColumnClass(int pCol) {
        return columnClasses[pCol];
    }

    /**
     * Always returns false because the cells in the table are not editable
     *
     * @param row
     * @param col
     *
     * @return false
     *
     */
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    /**
     * This method is empty.
     * Can not be included an element within a cell
     *
     * @deprecated
     *
     */
    public void setValueAt(Object value, int row, int col) {

    }
}