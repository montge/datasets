/* ReportTableModel.java
*
* 1.0
*
* 21/05/2007
*
* © 2007 eTour Project - Copyright by SE @ SA Lab - DMI - University of Salerno
*/
package unisa.gps.etour.gui.operatoreagenzia;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

import unisa.gps.etour.bean.BeanBeneCulturale;
import unisa.gps.etour.bean.BeanPuntoDiRistoro;
import unisa.gps.etour.bean.util.Punto3D;

public class ReportTableModel extends AbstractTableModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static final String[] headers = 
        {"Name", "Description", "Address", "City", "Province"};
    private static final Class[] columnClasses = 
        {String.class, String.class, String.class, String.class, String.class};
    private Vector<Object[]> data;

    public ReportTableModel(BeanBeneCulturale[] bc, BeanPuntoDiRistoro[] pr) {
        data = new Vector<Object[]>();
        for (int i = 0; i < pr.length; i++) {
            Object[] newObj = new Object[5];
            newObj[0] = pr[i].getName();
            newObj[1] = pr[i].getDescrizione();
            newObj[2] = pr[i].getVar();
            newObj[3] = pr[i].getCitta();
            newObj[4] = pr[i].getProvincia();

            setValueAt(newObj, i);
        }
        for (int i = 0; i < bc.length; i++) {
            Object[] newObj = new Object[5];
            newObj[0] = bc[i].getName();
            newObj[1] = bc[i].getDescrizione();
            newObj[2] = bc[i].getVar();
            newObj[3] = bc[i].getCitta();
            newObj[4] = bc[i].getProvincia();
            setValueAt(newObj, pr.length + i);
        }
    }

    public int getColumnCount() {
        return headers.length;
    }

    public int GetRowCount() {
        return data.size();
    }
    
    public String getColumnName(int col) {
        return headers[col];
    }

    public Object getValueAt(int row, int col) {
        return data.get(row)[col];
    }
    
    public Class getColumnClass(int col) {
        return columnClasses[col];
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }
    
    public void setValueAt(Object value, int row, int col) {
        if (row >= GetRowCount()) {
            Object[] newObj = new Object[headers.length];
            newObj[col] = value;
            data.add(newObj);
        }
        else {
            data.get(row)[col] = value;
        }
    }
    
    public void setValueAt(Object[] value, int row) throws IllegalArgumentException {
        if (value.length != headers.length) {
            System.out.println(value.length);
            System.out.println(headers.length);
            throw new IllegalArgumentException();
        }
        if (row >= GetRowCount()) {
            data.add(value);
        }
        else {
            data.remove(row);
            data.add(row, value);
        }
    }
}