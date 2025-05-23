package unisa.gps.etour.gui.operatoreagenzia;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.*;
import unisa.gps.etour.bean.BeanBeneCulturale;
import unisa.gps.etour.bean.BeanTag;
import unisa.gps.etour.control.GestioneBeniCulturali.IGestioneBeniCulturaliAgenzia;
import unisa.gps.etour.control.GestioneBeniCulturali.IGestioneBeniCulturaliComune;
import unisa.gps.etour.control.GestioneTag.IGestioneTagComune;
import unisa.gps.etour.gui.DeskManager;
import unisa.gps.etour.gui.HelpManager;
import unisa.gps.etour.gui.operatoreagenzia.tables.MediaVotiRenderer;
import unisa.gps.etour.gui.operatoreagenzia.tables.Punto3DRenderer;
import unisa.gps.etour.gui.operatoreagenzia.tables.ScrollableTable;
import unisa.gps.etour.gui.operatoreagenzia.tables.SitoTableModel;
import unisa.gps.etour.util.Punto3D;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 * Class that implements the interface for the management of cultural side
 * Operator Agency.
 *
 * @Author Mario Gallo
 * @Version 0.8
 * © 2007 eTour Project - Copyright by DMI SE @ SA Lab --
 * University of Salerno
 */
public class Beniculturali extends JInternalFrame {
    private JDesktopPane jDesktopPane;
    private JPanel jContentPane = null;
    private JToolBar BCToolbar = null;
    private JButton btnNuovoBC = null;
    private JButton btnSchedaBC = null;
    private JButton btnEliminaBC = null;
    private JButton btnModificaBC = null;
    private JPanel rightPanel = null;
    private JPanel searchPanel = null;
    private JPanel helpPanel = null;
    private JScrollPane JScrollPane = null;
    private JTable tableBC = null;
    private TagPanel pannelloTag = null;
    private JTextPane textGuida = null;
    private JTextField nomeBC = null;
    private JButton btnRicerca = null;
    private JButton btnAzzera = null;
    private DeskManager desktopManager;
    private ArrayList<SchedaBC> figli;
    private SitoTableModel tableModel;
    private HelpManager bcHelp;
    private IGestioneBeniCulturaliAgenzia gestioneBC;
    private IGestioneTagComune tags;
    protected IGestioneBeniCulturaliComune ricercaBC;

    /**
     * This is the default constructor.
     */
    public Beniculturali() {
        super("Cultural Heritage");
        setPreferredSize(Home.CHILD_SIZE);
        frameIcon = new ImageIcon(getClass().getResource(
                Home.URL_IMAGES + "BC.png"));
        setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
        closable = true;
        resizable = true;
        iconable = true;
        maximizable = true;

        // Setting up dell'help manager for cultural.
        textGuida = new JTextPane();
        try {
            bcHelp = new HelpManager(Home.URL_HELP + "BeniCulturali.txt",
                    textGuida);
        } catch (FileNotFoundException e) {
            textGuida.setText("<html><b>Help not available</b></html>");
        }
        setContentPane(getJContentPane());
        figli = new ArrayList<SchedaBC>();
        addInternalFrameListener(new InternalFrameAdapter() {
            /**
             * Inclusion of the frame on the desktop desktop retrieves bread bread
             * And desktop manager and initializes the remote objects
             * Management of cultural heritage.
             */
            public void internalFrameOpened(InternalFrameEvent pEvent) {
                JInternalFrame frame = pEvent.getInternalFrame();
                jDesktopPane = frame.getDesktopPane();
                desktopManager = (DeskManager) jDesktopPane.getDesktopManager();

                // Setting up objects for remote asset management
                // Cultural.
                try {
                    Registry reg = LocateRegistry.getRegistry(Home.HOST);
                    gestioneBC = (IGestioneBeniCulturaliAgenzia) reg
                            .lookup("GestioneBeniCulturaliAgenzia");
                    tags = (IGestioneTagComune) reg.lookup("GestioneTagComune");
                    ricercaBC = (IGestioneBeniCulturaliComune) reg
                            .lookup("GestioneBeniCulturaliComune");
                    // Load data.
                    caricaTabella(false);
                    caricaTags();
                }
                /**
                 * Two exceptions: RemoteException and NotBoundException. The
                 * Result is the same. The management is not operable and
                 * After the error message window closes.
                 */
                catch (Exception ex) {
                    JLabel error = new JLabel(
                            "<html><h2>Unable to communicate with the server eTour.</h2>"
                                    + "<h3><u>The dialog management request is closed.</u></h3>"
                                    + "<p><b>Possible Causes:</b>"
                                    + "<ul><li>No connection to the network.</li>"
                                    + "<li>Server inactive.</li>"
                                    + "<li>Server clogged.</li></ul>"
                                    + "<p>Please try again later.</p>"
                                    + "<p>If the error persists, please contact technical support.</p>"
                                    + "<p>We apologize for the inconvenience.</html>");
                    ImageIcon err = new ImageIcon(getClass().getResource(
                            Home.URL_IMAGES + "error48.png"));
                    JOptionPane.showMessageDialog(jDesktopPane, error,
                            "Error!", JOptionPane.ERROR_MESSAGE, err);
                    frame.dispose();
                }
            }

            /**
             * At the end of the frame displays the dialog
             * Confirmation.
             */
            public void internalFrameClosing(InternalFrameEvent pEvent) {
                // Create the confirmation dialog.
                JPanel root = new JPanel(new BorderLayout());
                JLabel message = new JLabel(
                        "Are you sure you want to close the management of cultural heritage?");
                message.setFont(new Font("Dialog", Font.BOLD, 14));
                JLabel avviso = new JLabel(
                        "NB will be closed all the windows opened by this administration.",
                        SwingConstants.CENTER);
                avviso.setIcon(new ImageIcon(getClass().getResource(
                        Home.URL_IMAGES + "warning16.png")));
                root.add(message, BorderLayout.NORTH);
                root.add(avviso, BorderLayout.CENTER);
                String[] options = {"Close", "Cancel"};
                int choice = JOptionPane.showInternalOptionDialog(jContentPane,
                        root, "Confirm closing of Cultural Heritage",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE, frameIcon, options,
                        options[1]);
                /**
                 * If it is confirmed the closing of management, all
                 * Classes "daughters" are closed.
                 */
                if (choice == JOptionPane.OK_OPTION) {
                    for (int i = 0; i < figli.size(); i++) {
                        figli.get(i).dispose();
                    }
                    pEvent.getInternalFrame().dispose();
                }
            }
        });
    }

    /**
     * Update the current model of the table of cultural property with the bean
     * Of the cultural supplied input.
     *
     * @param pbc BeanBeneCulturale - the bean with which to update the
     * Model.
     */
    protected void updateTableModel(BeanBeneCulturale pbc) {
        tableModel.updateBC(pbc);
    }

    /**
     * Closes the tab cultural selected.
     *
     * @param pScheda SchedaBC - the cultural card to close.
     */
    protected void closeScheda(SchedaBC pScheda) {
        figli.remove(pScheda);
        pScheda.dispose();
    }

    /**
     * This method initializes the content pane of the frame.
     *
     * @return javax.swing.JPanel - the content pane.
     */
    private JPanel getJContentPane() {
        if (null == jContentPane) {
            jContentPane = new JPanel();
            jContentPane.setLayout(new BorderLayout());
            jContentPane.add(getBCToolbar(), BorderLayout.NORTH);
            jContentPane.add(getPannelloDestro(), BorderLayout.EAST);
            jContentPane.add(getJScrollPane(), BorderLayout.CENTER);
        }
        return jContentPane;
    }

    /**
     * This method initializes the toolbar for features on
     * Management of cultural heritage.
     *
     * @return javax.swing.JToolBar - the toolbar for managing assets
     * Cultural.
     */
    private JToolBar getBCToolbar() {
        if (null == BCToolbar) {
            BCToolbar = new JToolBar();
            BCToolbar.setPreferredSize(new Dimension(1, 50));
            BCToolbar.setFloatable(false);
            BCToolbar.setOrientation(JToolBar.HORIZONTAL);
            BCToolbar.setLayout(null);
            BCToolbar.add(getBtnNuovoBC());
            BCToolbar.addSeparator();
            BCToolbar.add(getBtnModificaBC());
            BCToolbar.addSeparator();
            BCToolbar.add(getBtnSchedaBC());
            BCToolbar.addSeparator();
            BCToolbar.add(getBtnEliminaBC());
        }
        return BCToolbar;
    }

    /**
     * This method initializes the button to insert a new good
     * Cultural.
     *
     * @return javax.swing.JButton - the button for the insertion.
     */
    private JButton getBtnNuovoBC() {
        if (null == btnNuovoBC) {
            btnNuovoBC = new JButton();
            btnNuovoBC.setText("<html>New<br>Cultural Heritage</html>");
            btnNuovoBC.setBounds(5, 5, 140, 40);
            btnNuovoBC.setIcon(new ImageIcon(getClass().getResource(
                    Home.URL_IMAGES + "nuovoBC.png")));
            btnNuovoBC.setName("btnNuovoBC");
            btnNuovoBC.addMouseListener(bcHelp);
            btnNuovoBC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            btnNuovoBC.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent pEvent) {
                    // Opens a form for entering a new good
                    // Cultural.
                    OpenOffice.org Messenger MSN Gaim(null, false);
                }
            });
        }
        return btnNuovoBC;
    }

    /**
     * This method initializes the button to access to details of property
     * Cultural selected.
     *
     * @return javax.swing.JButton - the button for the card.
     */
    private JButton getBtnSchedaBC() {
        if (null == btnSchedaBC) {
            btnSchedaBC = new JButton();
            btnSchedaBC.setBounds(305, 5, 140, 40);
            btnSchedaBC.setText("<html>Card<br>Cultural Heritage</html>");
            btnSchedaBC.setVerticalTextPosition(SwingConstants.TOP);
            btnSchedaBC.setIcon(new ImageIcon(getClass().getResource(
                    Home.URL_IMAGES + "scheda.png")));
            btnSchedaBC.setEnabled(false);
            btnSchedaBC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            btnSchedaBC.setName("btnSchedaBC");
            btnSchedaBC.addMouseListener(bcHelp);
            btnSchedaBC.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent pEvent) {
                    int selectedRow = tableBC.getSelectedRow();
                    BeanBeneCulturale todo = null;
                    try {
                        todo = gestioneBC.ottieniBeneCulturale(tableModel.getID(selectedRow));
                        // Open the card with the change of the cultural
                        // Disabled.
                        OpenOffice.org Messenger MSN Gaim(todo, false);
                    } catch (Exception ex) {
                        JLabel error = new JLabel(
                                "<html><h2>Unable to communicate with the server eTour.</h2>"
                                        + "<h3><u>The card request can not be loaded.</u></h3>"
                                        + "<p>Please try again later.</p>"
                                        + "<p>If the error persists, please contact technical support.</p>"
                                        + "<p>We apologize for the inconvenience.</html>");
                        ImageIcon err = new ImageIcon(getClass().getResource(
                                Home.URL_IMAGES + "error48.png"));
                        JOptionPane.showMessageDialog(jDesktopPane, error,
                                "Error!", JOptionPane.ERROR_MESSAGE, err);
                    }
                }
            });
        }
        return btnSchedaBC;
    }

    /**
     * This method initializes the button to access the modification of a
     * Cultural.
     *
     * @return javax.swing.JButton - the button for the card.
     */
    private JButton getBtnModificaBC() {
        if (null == btnModificaBC) {
            btnModificaBC = new JButton();
            btnModificaBC.setBounds(155, 5, 140, 40);
            btnModificaBC.setText("<html>Edit Data<br>Cultural Heritage</html>");
            btnModificaBC.setEnabled(false);
            btnModificaBC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            btnModificaBC.setIcon(new ImageIcon(getClass().getResource(
                    Home.URL_IMAGES + "ModificaBC32.png")));
            btnModificaBC.setName("btnModificaBC");
            btnModificaBC.addMouseListener(bcHelp);
            btnModificaBC.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent pEvent) {
                    int selectedRow = tableBC.getSelectedRow();
                    BeanBeneCulturale todo = null;
                    try {
                        todo = gestioneBC.ottieniBeneCulturale(tableModel.getID(selectedRow));
                        // Open the card with the change of the cultural
                        // Enabled.
                        OpenOffice.org Messenger MSN Gaim(todo, true);
                    } catch (Exception ex) {
                        JLabel error = new JLabel(
                                "<html><h2>Unable to communicate with the server eTour.</h2>"
                                        + "<h3><u>The card request can not be loaded.</u></h3>"
                                        + "<p>Please try again later.</p>"
                                        + "<p>If the error persists, please contact technical support.</p>"
                                        + "<p>We apologize for the inconvenience.</html>");
                        ImageIcon err = new ImageIcon(getClass().getResource(
                                Home.URL_IMAGES + "error48.png"));
                        JOptionPane.showMessageDialog(jDesktopPane, error,
                                "Error!", JOptionPane.ERROR_MESSAGE, err);
                    }
                }
            });
        }
        return btnModificaBC;
    }

    /**
     * This method initializes the button for the elimination of property
     * Cultural selected.
     *
     * @return javax.swing.JButton - the delete button for.
     */
    private JButton getBtnEliminaBC() {
        if (null == btnEliminaBC) {
            btnEliminaBC = new JButton();
            btnEliminaBC.setBounds(455, 5, 140, 40);
            btnEliminaBC.setText("<html>Delete<br>Cultural Heritage</html>");
            btnEliminaBC.setVerticalTextPosition(SwingConstants.TOP);
            btnEliminaBC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            btnEliminaBC.setIcon(new ImageIcon(getClass().getResource(
                    Home.URL_IMAGES + "EliminaBC32.png")));
            btnEliminaBC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            btnEliminaBC.setEnabled(false);
            btnEliminaBC.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent pEvent) {
                    int selectedRow = tableBC.getSelectedRow();
                    String name = (String) tableModel.getValueAt(selectedRow, 0);

                    // Create the delete confirmation dialog.
                    JPanel root = new JPanel(new BorderLayout());
                    JLabel message = new JLabel(
                            "Are you sure you want to delete the cultural heritage"
                                    + name + "?");
                    message.setFont(new Font("Dialog", Font.BOLD, 14));
                    JLabel avviso = new JLabel(
                            "The deleted data can not be filled again.",
                            SwingConstants.CENTER);
                    avviso.setIcon(new ImageIcon(getClass().getResource(
                            Home.URL_IMAGES + "warning16.png")));
                    root.add(message, BorderLayout.NORTH);
                    root.add(avviso, BorderLayout.CENTER);
                    String[] options = {"Delete", "Cancel"};
                    int choice = JOptionPane.showInternalOptionDialog(
                            jContentPane, root, "Confirm Delete",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            new ImageIcon(getClass().getResource(
                                    Home.URL_IMAGES + "EliminaBC48.png")),
                            options, options[1]);
                    // If the deletion is confirmed, remove the well
                    // Cultural selected.
                    if (choice == JOptionPane.YES_OPTION) {
                        try {
                            gestioneBC.cancellaBeneCulturale(tableModel.getID(selectedRow));
                            tableModel.removeSito(selectedRow);
                            JLabel confirm = new JLabel("The cultural heritage"
                                    + name + "was deleted.");
                            confirm.setFont(new Font("Dialog", Font.BOLD, 14));
                            JOptionPane.showInternalMessageDialog(jContentPane,
                                    confirm, "Cultural Heritage",
                                    JOptionPane.OK_OPTION, new ImageIcon(
                                            getClass().getResource(
                                                    Home.URL_IMAGES
                                                            + "Ok32.png")));
                        } catch (Exception ex) {
                            JLabel error = new JLabel(
                                    "<html><h2>Unable to communicate with the server eTour.</h2>"
                                            + "<h3><u>Delete operation request can not be completed.</u></h3>"
                                            + "<p>Please try again later.</p>"
                                            + "<p>If the error persists, please contact technical support.</p>"
                                            + "<p>We apologize for the inconvenience.</html>");
                            ImageIcon err = new ImageIcon(getClass()
                                    .getResource(
                                            Home.URL_IMAGES + "error48.png"));
                            JOptionPane.showMessageDialog(jDesktopPane, error,
                                    "Error!", JOptionPane.ERROR_MESSAGE, err);
                        }
                    }
                }
            });
            btnEliminaBC.setName("btnEliminaBC");
            btnEliminaBC.addMouseListener(bcHelp);
        }
        return btnEliminaBC;
    }

    /**
     * This method initializes the right side of the interface.
     *
     * @return javax.swing.JPanel - the right pane of the interface.
     */
    private JPanel getPannelloDestro() {
        if (null == rightPanel) {
            rightPanel = new JPanel();
            rightPanel.setLayout(new BorderLayout());
            rightPanel.add(getHelpPanel(), BorderLayout.CENTER);
            rightPanel.add(getSearchPanel(), BorderLayout.CENTER);
        }
        return rightPanel;
    }

    /**
     * This method initializes the panel for finding property
     * Cultural.
     *
     * @return javax.swing.JPanel - the search panel.
     */
    private JPanel getSearchPanel() {
        if (null == searchPanel) {
            GridBagConstraints g = new GridBagConstraints();
            searchPanel = new JPanel(new GridBagLayout());
            searchPanel.setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createLineBorder(new Color(51, 102, 255), 3),
                    "Search for Cultural Heritage",
                    TitledBorder.DEFAULT_JUSTIFICATION,
                    TitledBorder.DEFAULT_POSITION, new Font("Dialog",
                            Font.BOLD, 12), new Color(0, 102, 204)));
            g.anchor = GridBagConstraints.CENTER;
            // Top - Left - Bottom - Right
            g.insets = new Insets(5, 5, 5, 5);
            g.gridwidth = 2;
            g.gridx = 0;
            g.gridy = 0;
            searchPanel.add(new JLabel("Name of Cultural Heritage"), g);
            g.gridy = 1;
            nomeBC = new JTextField();
            nomeBC.setColumns(12);
            nomeBC.setName("nomeBC");
            nomeBC.addMouseListener(bcHelp);
            searchPanel.add(nomeBC, g);
            g.gridy = 2;
            searchPanel.add(new JLabel("Select search tags:"), g);
            g.fill = GridBagConstraints.VERTICAL;
            g.gridy = 3;
            g.weightx = 1.0;
            g.weighty = 1.0;
            g.insets = new Insets(5, 5, 10, 5);
            pannelloTag = new TagPanel();
            pannelloTag.setPreferredSize(new Dimension(180, 40));
            pannelloTag.setName("pannelloTag");
            pannelloTag.addMouseListener(bcHelp);
            searchPanel.add(pannelloTag, g);
            g.insets = new Insets(5, 5, 5, 5);
            g.weightx = 0;
            g.weighty = 0;
            g.gridwidth = 1;
            g.gridy = 4;
            g.fill = GridBagConstraints.NONE;
            searchPanel.add(getBtnRicerca(), g);
            g.gridx = 1;
            searchPanel.add(getBtnAzzera(), g);
        }
        return searchPanel;
    }

    /**
     * This method initializes the panel containing the online help.
     *
     * @return javax.swing.JPanel - the panel of the guide.
     */
    private JPanel getHelpPanel() {
        if (null == helpPanel) {
            helpPanel = new JPanel();
            helpPanel.setLayout(new BorderLayout());
            helpPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory
                    .createLineBorder(new Color(51, 102, 255), 3),
                    "Help", TitledBorder.DEFAULT_JUSTIFICATION,
                    TitledBorder.DEFAULT_POSITION, new Font("Dialog",
                            Font.BOLD, 12), new Color(0, 102, 204)));
            textGuida.setPreferredSize(new Dimension(100, 80));
            textGuida.setContentType("text/html");
            textGuida.setText("<html>Move your mouse pointer over a control"
                    + "Of interest to display the context-sensitive help.</html>");
            textGuida.setEditable(false);
            textGuida.setOpaque(false);
            helpPanel.add(textGuida, BorderLayout.CENTER);
        }
        return helpPanel;
    }

    /**
     * This method initializes the bread and table scroll of cultural heritage.
     *
     * @return javax.swing.JScrollPane - the scrollPane.
     */
    private JScrollPane getJScrollPane() {
        if (JScrollPane == null) {
            if (null == tableBC) {
                tableModel = new SitoTableModel();
                tableBC = new ScrollableTable(tableModel);
                tableBC.setRowHeight(32);
                tableBC.setDefaultRenderer(Double.class,
                        new MediaVotiRenderer());
                tableBC.setDefaultRenderer(Punto3D.class,
                        new Punto3DRenderer());
                tableBC.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                tableBC.setSelectionForeground(Color.RED);
                tableBC.setSelectionBackground(Color.white);
                tableBC.setShowVerticalLines(false);
                tableBC.setColumnSelectionAllowed(false);
                tableBC.addMouseListener(bcHelp);
                tableBC.setName("tableBC");
                /**
                 * SelectionListener - if a selected row, the buttons
                 * Tab, edit and delete are active. Otherwise, are
                 * Disabled.
                 */
                ListSelectionModel selectionModel = tableBC.getSelectionModel();
                selectionModel.addListSelectionListener(new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent pEvent) {
                        if (tableBC.getSelectedRow() != -1) {
                            btnEliminaBC.setEnabled(true);
                            btnSchedaBC.setEnabled(true);
                            btnModificaBC.setEnabled(true);
                        } else {
                            btnEliminaBC.setEnabled(false);
                            btnSchedaBC.setEnabled(false);
                            btnModificaBC.setEnabled(false);
                        }
                    }
                });
                /**
                 * KeyListener <ENTER> - Details of the cultural selected.
                 * <Backspace> - Delete the selected cultural. <space> --
                 * Modify the cultural selected.
                 */
                tableBC.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent pEvent) {
                        int keyCode = pEvent.getKeyCode();
                        if (keyCode == KeyEvent.VK_ENTER) {
                            btnSchedaBC.doClick();
                        } else if (keyCode == KeyEvent.VK_BACK_SPACE) {
                            btnEliminaBC.doClick();
                        } else if (keyCode == KeyEvent.VK_SPACE) {
                            btnModificaBC.doClick();
                        }
                    }
                });
            }

            JScrollPane = new JScrollPane(tableBC);
            JScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            JScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        }
        return JScrollPane;
    }

    /**
     * This method initializes the button to search for a good
     * Cultural.
     *
     * @return javax.swing.JButton - the search button.
     */
    private JButton getBtnRicerca() {
        if (null == btnRicerca) {
            btnRicerca = new JButton();
            btnRicerca.setText("Search");
            btnRicerca.setPreferredSize(new Dimension(98, 26));
            btnRicerca.setIcon(new ImageIcon(getClass().getResource(
                    Home.URL_IMAGES + "Ricerca16.png")));
            btnRicerca.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            btnRicerca.setName("btnRicerca");
            btnRicerca.addMouseListener(bcHelp);
        }
        return btnRicerca;
    }

    /**
     * This method initializes the button to clear the form
     * Cultural research.
     *
     * @return javax.swing.JButton - the button to reset the form.
     */
    private JButton getBtnAzzera() {
        if (null == btnAzzera) {
            btnAzzera = new JButton();
            btnAzzera.setText("Clear");
            btnAzzera.setHorizontalTextPosition(SwingConstants.LEADING);
            btnAzzera.setPreferredSize(new Dimension(98, 26));
            btnAzzera.setIcon(new ImageIcon(getClass().getResource(
                    Home.URL_IMAGES + "Azzera16.png")));
            btnAzzera.setName("btnAzzera");
            btnAzzera.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            btnAzzera.addMouseListener(bcHelp);
            btnAzzera.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    nomeBC.setText("");
                    pannelloTag.azzera();
                }
            });
        }
        return btnAzzera;
    }

    /**
     * This method opens a tab of the selected cultural or opens the
     * Window for entering a new cultural object.
     *
     * @param pbc BeanBeneCulturale - the bean of the cultural property of which
     * Want to see the card.
     * @param pModifica boolean --
     * <ul>
     * <li><i>True</i> - indicates that you are making a change
     * Data cultural.
     * <li><i>False</i> indicates that you are viewing the card
     * The cultural property.
     */
    private void OpenOffice.org Messenger MSN Gaim(BeanBeneCulturale pbc, boolean pModifica) {
        SchedaBC nuova;
        if (pbc == null) {
            nuova = new SchedaBC(this);
        } else {
            for (int i = 0; i < figli.size(); i++) {
                SchedaBC corrente = figli.get(i);
                if (pbc.getId() == corrente.getId()) {
                    desktopManager.activateFrame(corrente);
                    return;
                }
            }
            nuova = new SchedaBC(this, pbc, pModifica);
        }
        jDesktopPane.add(nuova, Integer.MAX_VALUE);
        desktopManager.centerFrame(nuova);
        nuova.setVisible(true);
        figli.add(nuova);
    }

    /**
     * This method imports the cultural downloaded from the server in
     * Table.
     *
     * @param pRicerca boolean
     * <ul>
     * <li><i>True</i> - include the search parameters.
     * <li><i>False</i> otherwise.
     * </ul>
     */
    private void caricaTabella(boolean pRicerca) {
        ArrayList<BeanBeneCulturale> beniculturali = null;
        try {
            if (pRicerca) {
                
            } else {
                beniculturali = gestioneBC.ottieniBeniCulturali();
            }
        }
        // If an error displays an error message.
        catch (RemoteException e) {
            JLabel error = new JLabel(
                    "<html><h2>Unable to communicate with the server eTour.</h2>"
                            + "<h3><u>The list of cultural goods has been loaded.</u></h3>"
                            + "<p>Please try again later.</p>"
                            + "<p>If the error persists, please contact technical support.</p>"
                            + "<p>We apologize for the inconvenience.</html>");
            ImageIcon err = new ImageIcon(getClass().getResource(
                    Home.URL_IMAGES + "error48.png"));
            JOptionPane.showInternalMessageDialog(this, error, "Error!",
                    JOptionPane.ERROR_MESSAGE, err);
        } finally {
            tableModel = new SitoTableModel(beniculturali);
            tableBC.setModel(tableModel);
            organizzaRiga();
        }
    }

    /**
     * This method loads the tags available in the system and import them into
     * Panel tag.
     */
    private void caricaTags() {
        ArrayList<BeanTag> beanTags = null;
        try {
            beanTags = tags.ottieniTags();
            for (BeanTag b : beanTags) {
                pannelloTag.insertTag(b);
            }
            pannelloTag.repaint();
        }
        // If an error panel tag remains blank.
        catch (RemoteException e) {
        }
    }

    /**
     * This method sets the size of columns for the data assets
     * Cultural.
     */
    private void organizzaRiga() {
        // Name
        tableBC.getColumnModel().getColumn(0).setPreferredWidth(120);
        // Address
        tableBC.getColumnModel().getColumn(1).setPreferredWidth(120);
        // Phone
        tableBC.getColumnModel().getColumn(2).setPreferredWidth(80);
        // Location
        tableBC.getColumnModel().getColumn(3).setPreferredWidth(80);
        // City
        tableBC.getColumnModel().getColumn(4).setPreferredWidth(80);
        // CAP
        tableBC.getColumnModel().getColumn(5).setPreferredWidth(50);
        // Test
        tableBC.getColumnModel().getColumn(6).setPreferredWidth(30);
        // RATINGS
        tableBC.getColumnModel().getColumn(7).setPreferredWidth(80);
        // POSGEO
        tableBC.getColumnModel().getColumn(8).setPreferredWidth(120);
    }
}