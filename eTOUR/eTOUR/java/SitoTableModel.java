/*
 * SitoTableModel.java
 *
 * 1.0
 *
 * 21/05/2007
 *
 * © 2007 eTour Project - Copyright by SE @ SA Lab - DMI - University of Salerno
 */
package Handheld;

import Bean.BeanPuntoDiRistoro;
import javax.swing.table.AbstractTableModel;
import Bean.*;
import Util.Punto3D;

/**
 * <b>SitoTableModel</b>
 * Serves as a data container <p> of cultural or refreshment areas that need
 * Be displayed in a JTable.</p>
 * @see javax.swing.table.AbstractTableModel
 * @see javax.swing.JTable
 * @see unisa.gps.etour.bean.BeanBeneCulturale
 * @see unisa.gps.etour.bean.BeanPuntoDiRistoro
 * @version 1.0
 * @author Raphael Landi
 */

public class SitoTableModel extends AbstractTableModel {
     String[] columnNames = {"Name", "City", "Distance"};
     Object[][] cells;
     Punto3D posizioneSito;
     Punto3D myLocation;
    
     SitoTableModel(BeanPuntoDiRistoro[] pr, Punto3D myLocation) {
         super();
         cells = new Object[pr.length][3]; // First value = rows, second = columns
         for (int i = 0; i < pr.length; i++) {
             cells[i][0] = pr[i].getName();
             cells[i][1] = pr[i].getCitta();
         }
     }
    
     SitoTableModel(BeanBeneCulturale[] bc, Punto3D myLocation) {
         super();
         cells = new Object[bc.length][3]; // First value = rows, second = columns
         for (int i = 0; i < bc.length; i++) {
             cells[i][0] = bc[i].getName();
             cells[i][1] = bc[i].getCitta();
         }
     }
    
     public int getRowCount() {
         return cells.length;
     }
    
     public int getColumnCount() {
         return columnNames.length;
     }
    
     public Object getValueAt(int r, int c) {
         if (c < columnNames.length - 1)
             return cells[r][c];
         else {
             double value = miaPosizione.distanza(posizioneSito);
             return new Double(value);
         }
     }
    
     public String getColumnName(int c) {
         return columnNames[c];
     }
}