/**
 * PrioritaRenderer.java
 *
 * 1.0
 *
 * 22/05/2007
 *
 * 2007 eTour Project - Copyright by SE @ SA Lab - DMI University of Salerno
 */
package unisa.gps.etour.gui.operatoreagenzia.tables;

import java.awt.Component;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * <b> PrioritRenderer </b>
 * <p> This class creates a custom renderer JSlider as
 * Of the priorities in the table of news. </p>
 *
 * @version 1.0
 * @see javax.swing.JSlider
 * @see javax.swing.table.TableCellRenderer
 * @author Mario Gallo
 *
 */
public class PrioritaRenderer extends JSlider implements TableCellRenderer {
    /**
     * This default constructor.
     *
     */
    public PrioritaRenderer() {
        setOpaque(true);
        setOrientation(HORIZONTAL);
        setMinimum(1);
        setMaximum(5);
        setLabelTable(createStandardLabels(1));
        setMajorTickSpacing(1);
        setPaintTicks(true);
    }

    /**
     * This method returns the display component of the cell identified
     * From the row and column provided input.
     *
     * @param pTable JTable - the table.
     * @param pValue Object - the object contained in the selected cell.
     * @param pIsSelected boolean - true if the object selected.
     * False otherwise.
     * @param pHasFocus boolean - true if the object has the focus.
     * False otherwise.
     * @param pRow int - the row index.
     * @param pColumn int - the index of the column.
     * @return Component - the component to display
     */
    public Component getTableCellRendererComponent(JTable pTable, Object pValue,
            boolean pIsSelected, boolean pHasFocus, int pRow, int pColumn) throws IllegalArgumentException {
        if (!(pValue instanceof Integer)) {
            throw new IllegalArgumentException("unexpected value cell");
        }
        int value = (Integer) pValue;
        if (value < 1 || value > 5) {
            throw new IllegalArgumentException("Illegal value cell.");
        }
        if (pIsSelected) {
            setBackground(pTable.getSelectionBackground());
        } else {
            setBackground(pTable.getBackground());
        }
        setValue(value);
        return this;
    }
}