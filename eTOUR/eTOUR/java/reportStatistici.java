package unisa.gps.etour.gui.operatoreagenzia;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import unisa.gps.etour.bean.BeanBeneCulturale;
import unisa.gps.etour.bean.BeanPuntoDiRistoro;
import unisa.gps.etour.bean.util.Punto3D;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

public class reportStatistici extends JInternalFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Vector<String> data;
    private JPanel jContentPane = null;
    private JToolBar jToolBar = null;
    private JComboBox jComboBox = null;
    private JPanel centralPanel = null;
    private JScrollPane jScrollPane = null;
    private JTable tabellas = null;
    private JPanel southPanel = null;
    private JTabbedPane jTabbedPane = null;
    private JPanel guidainlinea = null;
    private JTextPane jTextPane = null;
    private JPanel genStat = null;
    private JPanel evdStat = null;
    private JPanel stat = null;
    private JPanel jPanel = null;
    private JButton jButton = null;
    private JButton jButton1 = null;
    private JButton jButton2 = null;
    private JLabel jLabel1 = null;
    private JLabel jLabel2 = null;
    private JLabel jLabel3 = null;
    private JLabel jLabel4 = null;
    private JLabel jLabel5 = null;
    private JLabel jLabel6 = null;
    private JLabel jLabel7 = null;
    private JLabel jLabel8 = null;
    private JLabel jLabel9 = null;
    private JPanel jPanel1 = null;
    private JLabel jLabel10 = null;
    private JLabel jLabel11 = null;
    private JLabel jLabel12 = null;
    private JLabel jLabel13 = null;
    private JLabel jLabel14 = null;
    private JLabel jLabel15 = null;
    private JLabel jLabel16 = null;
    private JLabel jLabel17 = null;
    private JLabel jLabel18 = null;
    private JLabel jLabel19 = null;
    private JLabel jLabel20 = null;
    private JLabel jLabel21 = null;
    private JLabel jLabel22 = null;
    private JButton btnVisualizza = null;
    private JLabel jLabel = null;

    /**
     * This is the default constructor xxx
     */
    public reportStatistici() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     *
     * @return void
     */
    private void initialize() {
        this.setSize(700, 480);
        this.setPreferredSize(new Dimension(790, 520));
        this.setFrameIcon(new ImageIcon(getClass().getResource("/interfacceAgenzia/immagini/statistics-32x32.png")));
        this.setIconifiable(true);
        this.setMaximizable(true);
        this.setClosable(true);
        this.setTitle("Statistical Report");
        this.setContentPane(getJContentPane());
        caricaCombo(this.getJComboBox());
    }

    /**
     * This method initializes jContentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            BorderLayout borderLayout = new BorderLayout();
            borderLayout.setHgap(0);
            borderLayout.setVgap(5);
            jContentPane = new JPanel();
            jContentPane.setLayout(borderLayout);
            jContentPane.add(getJToolBar(), BorderLayout.NORTH);
            jContentPane.add(getCentralPanel(), BorderLayout.CENTER);
            jContentPane.add(getSouthPanel(), BorderLayout.CENTER);
        }
        return jContentPane;
    }

    /**
     * This method initializes JToolBar
     *
     * @return javax.swing.JToolBar
     */
    private JToolBar getJToolBar() {
        if (jToolBar == null) {
            jLabel = new JLabel();
            jLabel.setText("Select Location");
            jLabel.setLocation(new Point(16, 6));
            jToolBar = new JToolBar();
            jToolBar.setFloatable(false);
            jToolBar.setLayout(new GridBagLayout());
            jToolBar.setPreferredSize(new Dimension(1, 30));
            jToolBar.add(jLabel);
            jToolBar.addSeparator();
            jToolBar.add(getJComboBox());
        }
        return jToolBar;
    }

    /**
     * This method initializes JComboBox
     *
     * @return javax.swing.JComboBox
     */
    private JComboBox getJComboBox() {
        if (jComboBox == null) {
            jComboBox = new JComboBox();
            jComboBox.setLocation(new Point(140, 4));
            jComboBox.setPreferredSize(new Dimension(150, 20));
            jComboBox.setSize(new Dimension(140, 20));
            //jComboBox.addItem("Salerno");

            this.setTitle("Statistical Report - Salerno");
        }
        return jComboBox;
    }

    public void caricaCombo(JComboBox combo) {
        BeanPuntoDiRistoro[] pr = new BeanPuntoDiRistoro[5];
        for (int i = 0; i < 5; i++) {
            pr[i] = new BeanPuntoDiRistoro(1, 12, 3.5,
                    "Arturo", "Vicno the sea, great view, romantic and Miao",
                    "089203202", "mountains", "Amalfi", "Via Principe 35", "84123",
                    "NA", "1234567898741", new Punto3D(12, 324, 3),
                    new Date(2, 23, 3), new Date(3, 3, 4), "Monday");
        }

        BeanBeneCulturale[] bc = new BeanBeneCulturale[5];
        for (int i = 0; i < 5; i++) {
            bc[i] = new BeanBeneCulturale(0.120, "Castle Arechi", "Salerno", "089,723,088", 
                    "The castle stands on balbalblalbalbla, blablalblalba, balblalballab",
                    "Salerno", "Largo castles 12", "84100", "SA", new Punto3D(10, 30, 40), 
                    new Date(0, 0, 0, 9, 0), new Date(0, 0, 0, 23, 0), "Monday",
                    12.5, 4.5);
        }

        ArrayList<String> list = null;
        for (int i = 0; i < pr.length; i++) {
            if (pù(combo, pr[i].getLocal())) {
                jComboBox.addItem(pr[i].getLocal());
            }
        }
        
        for (int i = 0; i < bc.length; i++) {
            if (pù(combo, bc[i].getLocal())) {
                jComboBox.addItem(bc[i].getLocal());
            }
        }
        tabellaSiti.setModel(new ReportTableModel(bc, pr));
    }
    
    private boolean pù(JComboBox combo, String loc) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            if (combo.getItemAt(i) == loc) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method initializes centralPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getCentralPanel() {
        if (centralPanel == null) {
            centralPanel = new JPanel();
            centralPanel.setLayout(new BorderLayout());
            centralPanel.add(getJScrollPane(), BorderLayout.CENTER);
            centralPanel.add(getJPanel(), BorderLayout.EAST);
        }
        return centralPanel;
    }

    /**
     * This method initializes JScrollPane
     *
     * @return javax.swing.JScrollPane
     */
    private JScrollPane getJScrollPane() {
        if (jScrollPane == null) {
            jScrollPane = new JScrollPane();
            jScrollPane.setViewportView(getTabellaSiti());
        }
        return jScrollPane;
    }

    /**
     * This method initializes tabellas
     *
     * @return javax.swing.JTable
     */
    private JTable getTabellaSiti() {
        if (tabellas == null) {
            tabellas = new JTable();
        }
        return tabellas;
    }

    /**
     * This method initializes southPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getSouthPanel() {
        if (southPanel == null) {
            GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
            gridBagConstraints11.anchor = GridBagConstraints.SOUTH;
            gridBagConstraints11.insets = new Insets(0, 0, 5, 0);
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.fill = GridBagConstraints.BOTH;
            gridBagConstraints.weighty = 1.0;
            gridBagConstraints.insets = new Insets(5, 5, 5, 5);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.weightx = 1.0;
            southPanel = new JPanel();
            southPanel.setLayout(new GridBagLayout());
            southPanel.add(getJTabbedPane(), gridBagConstraints);
            southPanel.add(getGuidainlinea(), gridBagConstraints11);
        }
        return southPanel;
    }

    /**
     * This method initializes JTabbedPane
     *
     * @return javax.swing.JTabbedPane
     */
    private JTabbedPane getJTabbedPane() {
        if (jTabbedPane == null) {
            jTabbedPane = new JTabbedPane();
            jTabbedPane.setPreferredSize(new Dimension(100, 200));
            jTabbedPane.setName("");
            jTabbedPane.setTabPlacement(JTabbedPane.TOP);
            jTabbedPane.addTab("General Statistics", null, getGenStat(), null);
            jTabbedPane.addTab("Site Statistics", null, getEvdStat(), null);
            jTabbedPane.addTab("Additional Statistics", null, getStat(), null);
        }
        return jTabbedPane;
    }

    /**
     * This method initializes guidainlinea
     *
     * @return javax.swing.JPanel
     */
    private JPanel getGuidainlinea() {
        if (guidainlinea == null) {
            GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
            gridBagConstraints1.fill = GridBagConstraints.BOTH;
            gridBagConstraints1.weighty = 1.0;
            gridBagConstraints1.weightx = 1.0;
            guidainlinea = new JPanel();
            guidainlinea.setLayout(new GridBagLayout());
            guidainlinea.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(51, 102, 255), 3), "Help", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 153, 255)));
            guidainlinea.setPreferredSize(new Dimension(180, 200));
            guidainlinea.add(getJTextPane(), gridBagConstraints1);
        }
        return guidainlinea;
    }

    /**
     * This method initializes jTextPane
     *
     * @return javax.swing.JTextPane
     */
    private JTextPane getJTextPane() {
        if (jTextPane == null) {
            jTextPane = new JTextPane();
            jTextPane.setPreferredSize(new Dimension(160, 100));
        }
        return jTextPane;
    }

    /**
     * This method initializes genStat
     *
     * @return javax.swing.JPanel
     */
    private JPanel getGenStat() {
        if (genStat == null) {
            GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
            gridBagConstraints14.gridx = 2;
            gridBagConstraints14.insets = new Insets(5, 5, 5, 5);
            gridBagConstraints14.gridy = 3;
            jLabel9 = new JLabel();
            jLabel9.setText("Bells");
            GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
            gridBagConstraints13.gridx = 1;
            gridBagConstraints13.insets = new Insets(5, 5, 5, 5);
            gridBagConstraints13.gridy = 3;
            jLabel8 = new JLabel();
            jLabel8.setText("3.5");
            GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
            gridBagConstraints12.gridx = 0;
            gridBagConstraints12.insets = new Insets(5, 5, 5, 5);
            gridBagConstraints12.gridy = 3;
            jLabel7 = new JLabel();
            jLabel7.setText("Media Ratings:");
            GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
            gridBagConstraints10.gridx = 1;
            gridBagConstraints10.insets = new Insets(5, 5, 5, 5);
            gridBagConstraints10.gridy = 2;
            jLabel6 = new JLabel();
            jLabel6.setText("90");
            GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
            gridBagConstraints9.gridx = 0;
            gridBagConstraints9.insets = new Insets(5, 5, 5, 5);
            gridBagConstraints9.gridy = 2;
            jLabel5 = new JLabel();
            jLabel5.setText("Number of votes not enough");
            GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
            gridBagConstraints8.gridx = 1;
            gridBagConstraints8.insets = new Insets(5, 5, 5, 5);
            gridBagConstraints8.gridy = 1;
            jLabel4 = new JLabel();
            jLabel4.setText("99");
            GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
            gridBagConstraints7.gridx = 0;
            gridBagConstraints7.insets = new Insets(5, 5, 5, 5);
            gridBagConstraints7.gridy = 1;
            jLabel3 = new JLabel();
            jLabel3.setText("Number enough votes:");
            GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
            gridBagConstraints6.gridx = 1;
            gridBagConstraints6.insets = new Insets(5, 5, 5, 5);
            gridBagConstraints6.gridy = 0;
            jLabel2 = new JLabel();
            jLabel2.setText("189");
            GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
            gridBagConstraints5.gridx = 0;
            gridBagConstraints5.insets = new Insets(5, 5, 5, 5);
            gridBagConstraints5.anchor = GridBagConstraints.CENTER;
            gridBagConstraints5.gridy = 0;
            jLabel1 = new JLabel();
            jLabel1.setText("Number of votes issued:");
            genStat = new JPanel();
            genStat.setLayout(new GridBagLayout());
            genStat.add(jLabel1, gridBagConstraints5);
            genStat.add(jLabel2, gridBagConstraints6);
            genStat.add(jLabel3, gridBagConstraints7);
            genStat.add(jLabel4, gridBagConstraints8);
            genStat.add(jLabel5, gridBagConstraints9);
            genStat.add(jLabel6, gridBagConstraints10);
            genStat.add(jLabel7, gridBagConstraints12);
            genStat.add(jLabel8, gridBagConstraints13);
            genStat.add(jLabel9, gridBagConstraints14);
        }
        return genStat;
    }

    /**
     * This method initializes evdStat
     *
     * @return javax.swing.JPanel
     */
    private JPanel getEvdStat() {
        if (evdStat == null) {
            GridBagConstraints gridBagConstraints25 = new GridBagConstraints();
            gridBagConstraints25.gridx = 2;
            gridBagConstraints25.insets = new Insets(0, 80, 0, 5);
            gridBagConstraints25.ipadx = 1;
            gridBagConstraints25.gridy = 3;
            GridBagConstraints gridBagConstraints28 = new GridBagConstraints();
            gridBagConstraints28.gridx = 3;
            gridBagConstraints28.anchor = GridBagConstraints.WEST;
            gridBagConstraints28.insets = new Insets(0, 5, 0, 5);
            gridBagConstraints28.gridy = 3;
            jLabel22 = new JLabel();
            jLabel22.setText("6");
            GridBagConstraints gridBagConstraints27 = new GridBagConstraints();
            gridBagConstraints27.gridx = 3;
            gridBagConstraints27.anchor = GridBagConstraints.WEST;
            gridBagConstraints27.insets = new Insets(5, 5, 5, 5);
            gridBagConstraints27.gridy = 0;
            jLabel21 = new JLabel();
            jLabel21.setText("29");
            GridBagConstraints gridBagConstraints26 = new GridBagConstraints();
            gridBagConstraints26.gridx = 1;
            gridBagConstraints26.anchor = GridBagConstraints.WEST;
            gridBagConstraints26.gridwidth = 1;
            gridBagConstraints26.insets = new Insets(5, 5, 5, 5);
            gridBagConstraints26.gridy = 0;
            jLabel20 = new JLabel();
            jLabel20.setText("35");
            jLabel19 = new JLabel();
            jLabel19.setText("Feedback link under the sufficiency:");
            GridBagConstraints gridBagConstraints24 = new GridBagConstraints();
            gridBagConstraints24.gridx = 2;
            gridBagConstraints24.insets = new Insets(5, 5, 5, 5);
            gridBagConstraints24.anchor = GridBagConstraints.EAST;
            gridBagConstraints24.gridy = 0;
            jLabel18 = new JLabel();
            jLabel18.setText("Feedback enough:");
            GridBagConstraints gridBagConstraints23 = new GridBagConstraints();
            gridBagConstraints23.gridx = 0;
            gridBagConstraints23.gridwidth = 1;
            gridBagConstraints23.insets = new Insets(5, 5, 5, 5);
            gridBagConstraints23.gridy = 0;
            jLabel17 = new JLabel();
            jLabel17.setText("Feedback received in full:");
            GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
            gridBagConstraints15.gridx = 0;
            gridBagConstraints15.gridwidth = 4;
            gridBagConstraints15.gridy = 4;
            evdStat = new JPanel();
            evdStat.setLayout(new GridBagLayout());
            evdStat.setEnabled(false);
            evdStat.add(getJPanel1(), gridBagConstraints15);
            evdStat.add(jLabel17, gridBagConstraints23);
            evdStat.add(jLabel18, gridBagConstraints24);
            evdStat.add(jLabel20, gridBagConstraints26);
            evdStat.add(jLabel21, gridBagConstraints27);
            evdStat.add(jLabel22, gridBagConstraints28);
            evdStat.add(jLabel19, gridBagConstraints25);
        }
        return evdStat;
    }

    /**
     * This method initializes stat
     *
     * @return javax.swing.JPanel
     */
    private JPanel getStat() {
        if (stat == null) {
            stat = new JPanel();
            stat.setLayout(new GridBagLayout());
            stat.setEnabled(false);
        }
        return stat;
    }

    /**
     * This method initializes JPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel() {
        if (jPanel == null) {
            GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
            gridBagConstraints4.insets = new Insets(5, 5, 5, 5);
            GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
            gridBagConstraints3.gridx = 0;
            gridBagConstraints3.insets = new Insets(5, 5, 5, 5);
            gridBagConstraints3.gridy = 2;
            GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
            gridBagConstraints2.gridx = 0;
            gridBagConstraints2.insets = new Insets(5, 5, 5, 5);
            gridBagConstraints2.gridy = 1;
            jPanel = new JPanel();
            jPanel.setLayout(new GridBagLayout());
            jPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 51, 255), 3), "Show for:", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(0, 51, 255)));
            jPanel.add(getJButton(), gridBagConstraints4);
            jPanel.add(getJButton1(), gridBagConstraints2);
            jPanel.add(getJButton2(), gridBagConstraints3);
        }
        return jPanel;
    }

    /**
     * This method initializes JButton
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton() {
        if (jButton == null) {
            jButton = new JButton();
            jButton.setText("<html>Well<br>Cultural</html>");
            jButton.setIcon(new ImageIcon(getClass().getResource("/interfacceAgenzia/images/Sphinx-icon.gif")));
        }
        return jButton;
    }

    /**
     * This method initializes jButton1
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton1() {
        if (jButton1 == null) {
            jButton1 = new JButton();
            jButton1.setText("<html>point<br>Refreshments</html>");
            jButton1.setPreferredSize(new Dimension(121, 42));
            jButton1.setIcon(new ImageIcon(getClass().getResource("/interfacceAgenzia/images/Java.png")));
        }
        return jButton1;
    }

    /**
     * This method initializes jButton2
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton2() {
        if (jButton2 == null) {
            jButton2 = new JButton();
            jButton2.setText("All");
            jButton2.setPreferredSize(new Dimension(121, 42));
            jButton2.setIcon(new ImageIcon(getClass().getResource("/interfacceAgenzia/immagini/Globe_32x32.png")));
        }
        return jButton2;
    }

    /**
     * This method initializes jPanel1
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel1() {
        if (jPanel1 == null) {
            GridBagConstraints gridBagConstraints29 = new GridBagConstraints();
            gridBagConstraints29.gridx = 2;
            gridBagConstraints29.gridy = 4;
            GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
            gridBagConstraints22.gridx = 1;
            gridBagConstraints22.insets = new Insets(5, 5, 5, 5);
            gridBagConstraints22.gridy = 3;
            jLabel16 = new JLabel();
            jLabel16.setText("Comment deleted by moderator feedback");
            GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
            gridBagConstraints21.gridx = 0;
            gridBagConstraints21.insets = new Insets(5, 5, 5, 5);
            gridBagConstraints21.gridy = 3;
            jLabel15 = new JLabel();
            jLabel15.setText("Bells");
            GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
            gridBagConstraints20.gridx = 1;
            gridBagConstraints20.insets = new Insets(5, 5, 5, 5);
            gridBagConstraints20.anchor = GridBagConstraints.WEST;
            gridBagConstraints20.gridy = 2;
            jLabel14 = new JLabel();
            jLabel14.setText("We eat good, bad beer");
            GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
            gridBagConstraints19.gridx = 3;
            gridBagConstraints19.gridy = 2;
            jLabel13 = new JLabel();
            jLabel13.setText("");
            GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
            gridBagConstraints18.gridx = 0;
            gridBagConstraints18.insets = new Insets(5, 5, 5, 5);
            gridBagConstraints18.gridy = 2;
            jLabel12 = new JLabel();
            jLabel12.setText("Bells");
            GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
            gridBagConstraints17.gridx = 1;
            gridBagConstraints17.insets = new Insets(5, 5, 5, 5);
            gridBagConstraints17.anchor = GridBagConstraints.WEST;
            gridBagConstraints17.gridy = 0;
            jLabel11 = new JLabel();
            jLabel11.setText("Really a nice place, we'll be back!");
            GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
            gridBagConstraints16.gridx = 0;
            gridBagConstraints16.insets = new Insets(5, 5, 5, 5);
            gridBagConstraints16.gridy = 0;
            jLabel10 = new JLabel();
            jLabel10.setText("Bells");
            jPanel1 = new JPanel();
            jPanel1.setLayout(new GridBagLayout());
            jPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 51, 255), 3), "Last feedback issued:", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(0, 102, 255)));
            jPanel1.add(jLabel10, gridBagConstraints16);
            jPanel1.add(jLabel11, gridBagConstraints17);
            jPanel1.add(jLabel12, gridBagConstraints18);
            jPanel1.add(jLabel13, gridBagConstraints19);
            jPanel1.add(jLabel14, gridBagConstraints20);
            jPanel1.add(jLabel15, gridBagConstraints21);
            jPanel1.add(jLabel16, gridBagConstraints22);
            jPanel1.add(getBtnVisualizza(), gridBagConstraints29);
        }
        return jPanel1;
    }

    /**
     * This method initializes btnVisualizza
     *
     * @return javax.swing.JButton
     */
    private JButton getBtnVisualizza() {
        if (btnVisualizza == null) {
            btnVisualizza = new JButton();
            btnVisualizza.setText("View All");
            btnVisualizza.setMnemonic(KeyEvent.VK_UNDEFINED);
            btnVisualizza.setIcon(new ImageIcon(getClass().getResource("/interfacceAgenzia/images/Forward 216.png")));
        }
        return btnVisualizza;
    }
} // @jve:decl-index=0:visual-constraint="-7, -61"