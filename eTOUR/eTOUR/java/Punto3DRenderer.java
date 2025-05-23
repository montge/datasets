package unisa.gps.etour.gui.operatoreagenzia.tables;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;
import unisa.gps.etour.util.Punto3D;

/**
 * <b> Punto3DRenderer </b>
 * <p> This class creates a custom renderer for
 * Objects of type Punto3D. </p>
 *
 * @see javax.swing.table.TableCellRenderer
 * @see unisa.gps.etour.util.Punto3D
 * @version 1.0
 * @author Mario Gallo
 */
public class Punto3DRenderer implements TableCellRenderer {
    /**
     * Method that returns the custom component for the
     * Display of the data contained in the cell of a table.
     *
     * @param pTable JTable - the table.
     * @param pValue Object - the data.
     * @param pSelected boolean --
     * <ul>
     * <li> <i> True </i> if the cell is selected.
     * <li> <i> False </i> otherwise.
     * </ul>
     * @param pHasFocus boolean --
     * <ul>
     * <li> <i> True </i> if the cell has the focus.
     * <li> <i> False </i> otherwise.
     * </ul>
     * @param pRow - the line number.
     * @param pColumn - the column number.
     * @return Component - the component that customizes render the cell.
     * @throws IllegalArgumentException - if the value of the cell can not
     * Be rendered by this renderer.
     */
    public Component getTableCellRendererComponent(JTable pTable,
            Object pValue, boolean pSelected, boolean pHasFocus, int pRow,
            int pColumn) {
        if (!(pValue instanceof Punto3D)) {
            throw new IllegalArgumentException("Value Cella unexpected.");
        }
        Punto3D aPoint = (Punto3D) pValue;
        String point = aPoint.getLatitudine() + ";"
                + aPoint.getLongitudine() + ";" + aPoint.getAltitudine();
        JLabel aLabel = new JLabel(point, SwingConstants.CENTER);
        if (pSelected) {
            aLabel.setForeground(pTable.getSelectionForeground());
            aLabel.setBackground(pTable.getSelectionBackground());
        }
        return aLabel;
    }
}