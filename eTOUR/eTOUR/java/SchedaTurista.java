package unisa.gps.etour.gui.operatoreagenzia;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.*;
import unisa.gps.etour.bean.BeanTurista;
import unisa.gps.etour.util.Data;

/**
 * Class that models the interface for displaying the card and
 * Modify the data of an account tourist.
 *
 * @Version 1.0
 * @Author Mario Gallo
 *
 * © 2007 eTour Project - Copyright by DMI SE @ SA Lab --
 * University of Salerno
 */
public class SchedaTurista extends JInternalFrame implements ISchedaTurista {

    private static final String[] help = {"", "", "", "", "", "", "", "",
            "", "", "", "", ""};
    private JPanel jContentPane = null;
    private JToolBar toolbarscheda = null;
    private JToggleButton btnModifica = null;
    private JButton btnSalva = null;
    private JButton btnReimposta = null;
    private JTabbedPane jTabbedPane = null;
    private JTextField indirizzo2 = null;
    private JComboBox indirizzo1 = null;
    private JTextField citta = null;
    private JTextField cap = null;
    private JTextField telefono = null;
    private JComboBox provincia = null;
    private JPanel datiTurista = null;
    private JTextField cognome = null;
    private Vector<JLabel> suggerimenti;
    private BeanTurista turista;
    private JTextField nome;
    private JComboBox giorno;
    private JComboBox mese;
    private JComboBox anno;
    private JTextField luogoNascita;
    private JTextField email;
    private JTextField username;
    private JPasswordField password;
    private JLabel dataRegistrazione;
    private Turisti parent;

    /**
     * The only card manufacturer model of a tourist or modification of data
     * From the bean.
     *
     * @param pParent unisa.gps.etour.gui.operatoreagenzia.Turisti - the window "father."
     * @param pTurista unisa.gps.etour.bean.BeanTurista - the bean contentente data
     * Of the tourist.
     * @param pModifica <ul> <li> true - if amendments are made to the
     * Data. <li> False - if you are viewing the card.
     */
    public SchedaTurista(Turisti pParent, BeanTurista pTurista,
            boolean pModifica) {
        super();
        this.parent = pParent;
        setIconifiable(true);
        setSize(560, 520);
        suggerimenti = new Vector<JLabel>();
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setClosable(true);
        turista = pTurista;
        if (turista.isAttiva()) {
            frameIcon = new ImageIcon(
                    getClass().getResource(
                            "/unisa/gps/etour/gui/operatoreagenzia/images/tab_turista.png"));
        } else {
            frameIcon = new ImageIcon(
                    getClass().getResource(
                            "/unisa/gps/etour/gui/operatoreagenzia/images/DisattivaTurista32.png"));
        }
        initialize();
        if (pModifica) {
            btnModifica.setSelected(true);
            btnSalva.setVisible(true);
            btnReimposta.setVisible(true);
        } else {
            mostraNascondiSuggerimenti();
            attivaDisattivaEdit();
        }
        addInternalFrameListener(new InternalFrameAdapter() {
            public void internalFrameClosing(InternalFrameEvent pEvent) {
                if (btnModifica.isSelected()) {
                    JPanel root = new JPanel(new BorderLayout());
                    JLabel message = new JLabel(
                            "Are you sure you want to close the tab of this tourist?");
                    message.setFont(new Font("Dialog", Font.BOLD, 14));
                    JLabel avviso = new JLabel(
                            "Warning! Unsaved data will be lost.", SwingConstants.CENTER);
                    avviso.setIcon(new ImageIcon(getClass().getResource(
                            "/unisa/gps/etour/gui/operatoreagenzia/images/warning16.png")));
                    root.add(message, BorderLayout.NORTH);
                    root.add(avviso, BorderLayout.CENTER);
                    String[] options = {"Close", "Cancel"};
                    int choice = JOptionPane.showInternalOptionDialog(jContentPane, root,
                            "Confirm closing Tourist Card" + turista.getNome() + " " + turista.getCognome(),
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, frameIcon, options, options[1]);
                    if (choice == JOptionPane.OK_OPTION) {
                        parent.closeScheda((SchedaTurista) pEvent.getInternalFrame());
                    }
                } else {
                    parent.closeScheda((SchedaTurista) pEvent.getInternalFrame());
                }
            }
        });
    }

    /**
     * This method initializes the interface card for tourists.
     *
     * @return void
     */
    private void initialize() {
        jContentPane = new JPanel();
        jContentPane.setLayout(new BorderLayout());
        jContentPane.add(getToolbarscheda(), BorderLayout.NORTH);
        jTabbedPane = new JTabbedPane();
        jTabbedPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jTabbedPane.addTab("Tourist Information", frameIcon, getDatiTuristaForm(),
                null);
        jContentPane.add(jTabbedPane, BorderLayout.CENTER);
        setContentPane(jContentPane);
        caricaDatiForm();
    }

    /**
     * This method loads the bean data provided tourist camps
     * Of the form.
     *
     * @return void
     */
    private void caricaDatiForm() {
        setTitle("Profile Tourist - " + turista.getNome() + " "
                + turista.getCognome());
        nome.setText(turista.getNome());
        cognome.setText(turista.getCognome());
        Date dataNascita = turista.getDataNascita();
        giorno.setSelectedIndex(dataNascita.getDate());
        mese.setSelectedIndex(dataNascita.getMonth());
        anno.setSelectedIndex(dataNascita.getYear());
        StringTokenizer tokenizer = new StringTokenizer(turista.getVia());
        String stringa = tokenizer.nextToken();
        indirizzo1.setSelectedItem(stringa);
        indirizzo2.setText(turista.getVia().substring(stringa.length()));
        luogoNascita.setText(turista.getCittaNascita());
        telefono.setText(turista.getTelefono());
        citta.setText(turista.getCittaResidenza());
        password.setText(turista.getPassword());
        provincia.setSelectedItem(turista.getProvincia());
        username.setText(turista.getUsername());
        cap.setText(turista.getCap());
        email.setText(turista.getEmail());
        dataRegistrazione.setText(Data.toEstesa(turista.getDataRegistrazione()));
    }

    /**
     * This method shows or hides the suggestions relating to the form fields.
     *
     * @return void
     */
    private void mostraNascondiSuggerimenti() {
        Iterator<JLabel> s = suggerimenti.iterator();
        while (s.hasNext()) {
            JLabel corrente = s.next();
            corrente.setVisible(corrente.isVisible() ? false : true);
        }
    }

    /**
     * This method makes it or not editable form fields.
     *
     * @return void
     */
    private void attivaDisattivaEdit() {
        Component[] componenti = datiTurista.getComponents();
        for (int i = 0; i < componenti.length; i++) {
            Component corrente = componenti[i];
            if (corrente instanceof JTextField) {
                JTextField textbox = (JTextField) corrente;
                textbox.setEditable(textbox.isEditable() ? false : true);
                textbox.setBackground(Color.white);
            } else if (corrente instanceof JComboBox) {
                JComboBox combobox = (JComboBox) corrente;
                combobox.setEnabled(combobox.isEnabled() ? false : true);
            }
        }
    }

    /**
     * This method initializes the toolbar for the functionality of the card
     * Tourist.
     *
     * @return javax.swing.JToolBar
     */
    private JToolBar getToolbarscheda() {
        if (toolbarscheda == null) {
            toolbarscheda = new JToolBar();
            toolbarscheda.setFloatable(false);
            toolbarscheda.add(getBtnModifica());
            toolbarscheda.addSeparator();
            toolbarscheda.add(getBtnSalva());
            toolbarscheda.addSeparator();
            toolbarscheda.add(getBtnReimposta());
            toolbarscheda.addSeparator();
        }
        return toolbarscheda;
    }

    /**
     * This method initializes the button for editing data.
     *
     * @return javax.swing.JToggleButton
     */
    private JToggleButton getBtnModifica() {
        if (null == btnModifica) {
            btnModifica = new JToggleButton();
            btnModifica.setText("Change Data");
            btnModifica.setIcon(new ImageIcon(
                    getClass().getResource(
                            "/unisa/gps/etour/gui/operatoreagenzia/images/ModificaTurista32.png")));
            btnModifica.setToolTipText("Enable or disable data modification tourists selected.");
            btnModifica.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    mostraNascondiSuggerimenti();
                    attivaDisattivaEdit();
                    btnSalva.setVisible((btnModifica.isSelected() ? true : false));
                    btnReimposta.setVisible((btnModifica.isSelected() ? true : false));
                }
            });
        }
        return btnModifica;
    }

    /**
     * This method initializes the button to save the changes
     * Made to the data of the tourist.
     *
     * @return javax.swing.JButton
     */
    private JButton getBtnSalva() {
        if (null == btnSalva) {
            btnSalva = new JButton();
            btnSalva.setText("Save");
            btnSalva.setIcon(new ImageIcon(getClass().getResource(
                    "/unisa/gps/etour/gui/operatoreagenzia/images/salva.png")));
            btnSalva.setToolTipText("Save changes to the tourist profile selected.");
            btnSalva.setVisible(false);
            btnSalva.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent pEvent) {
                    // Construction of the dialog for confirmation of the change
                    JPanel root = new JPanel(new BorderLayout());
                    JLabel message = new JLabel(
                            "Updating the tourist profile of"
                            + turista.getNome() + " "
                            + turista.getCognome() + " with"
                            + " data form?");
                    message.setFont(new Font("Dialog", Font.BOLD, 14));
                    JLabel avviso = new JLabel(
                            "The previous data can not be more recovered.",
                            SwingConstants.CENTER);
                    avviso.setIcon(new ImageIcon(
                            getClass().getResource(
                                    "/unisa/gps/etour/gui/operatoreagenzia/images/warning16.png")));
                    root.add(message, BorderLayout.NORTH);
                    root.add(avviso, BorderLayout.CENTER);
                    String[] options = {"Edit", "Cancel"};
                    // The dialog screen appears
                    int choice = JOptionPane.showInternalOptionDialog(
                            jContentPane,
                            root,
                            "Commit Changes tourist figures",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            new ImageIcon(
                                    getClass().getResource(
                                            "/unisa/gps/etour/gui/operatoreagenzia/images/ModificaTurista48.png")),
                            options, options[1]);
                    // If you chose to confirm the change
                    if (choice == JOptionPane.YES_OPTION) {
                        turista.setNome(nome.getText());
                        turista.setCognome(cognome.getText());
                        turista.setCap(cap.getText());
                        turista.setCittaNascita(luogoNascita.getText());
                        turista.setDataNascita(new Date(
                                anno.getSelectedIndex(), mese.getSelectedIndex(), giorno.getSelectedIndex()));
                        turista.setCittaResidenza(citta.getText());
                        turista.setUsername(username.getText());
                        turista.setEmail(email.getText());
                        turista.setTelefono(telefono.getText());
                        turista.setVia(indirizzo1.getSelectedItem().toString()
                                + " " + indirizzo2.getText());
                        turista.setProvincia(provincia.getSelectedItem().toString());
                        String pass = "";
                        char[] passWord = password.getPassword();
                        for (int i = 0; i < passWord.length; i++) {
                            pass += passWord[i];
                        }
                        turista.setPassword(pass);
                        caricaDatiForm();
                        attivaDisattivaEdit();
                        btnSalva.setVisible(false);
                        btnReimposta.setVisible(false);
                        btnModifica.setSelected(false);
                        mostraNascondiSuggerimenti();
                        parent.updateTableModel(turista);
                        JOptionPane.showInternalMessageDialog(
                                jContentPane,
                                "The data of tourists have been updated successfully.",
                                "Modified Profile Tourist!",
                                JOptionPane.OK_OPTION,
                                new ImageIcon(
                                        getClass().getResource(
                                                "/unisa/gps/etour/gui/operatoreagenzia/images/ok48.png")));
                    }
                }
            });
        }
        return btnSalva;
    }

    /**
     * This method initializes the button to reset the data of the tourist
     * In the form.
     *
     * @return javax.swing.JButton
     */
    private JButton getBtnReimposta() {
        if (null == btnReimposta) {
            btnReimposta = new JButton();
            btnReimposta.setText("Reset");
            btnReimposta.setIcon(new ImageIcon(
                    getClass().getResource(
                            "/unisa/gps/etour/gui/operatoreagenzia/images/Annulla32.png")));
            btnReimposta.setToolTipText("Reload the selected tourist information.");
            btnReimposta.setVisible(false);
            btnReimposta.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    caricaDatiForm();
                }
            });
        }
        return btnReimposta;
    }

    /**
     * This method initializes the form contentente data of the tourist.
     *
     * @return javax.swing.JPanel
     */
    private JPanel getDatiTuristaForm() {
        if (null == datiTurista) {
            datiTurista = new JPanel(null);
            datiTurista.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
            // Creation Tips
            String[] txts = {"Name", "Name", "Date of Birth",
                    "Place of Birth", "Phone", "Address", "City",
                    "CPC", "Province", "E-Mail", "Username", "Password",
                    "Save"};

            for (int i = 0; i < help.length; i++) {
                JLabel nuova = new JLabel();
                nuova.setIcon(new ImageIcon(getClass().getResource(
                        "/unisa/gps/etour/gui/images/Info16.png")));
                nuova.setBounds(145, 8 + 30 * i, 24, 24);
                nuova.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                nuova.setToolTipText(help[i]);
                suggerimenti.add(nuova);
                datiTurista.add(nuova);
            }

            for (int i = 0; i < txts.length; i++) {
                JLabel nuova = new JLabel(txts[i], SwingConstants.RIGHT);
                nuova.setBounds(25, 10 + 30 * i, 120, 20);
                nuova.repaint();
                datiTurista.add(nuova, null);
            }
            // Name
            nome = new JTextField(12);
            nome.setBounds(185, 10, 136, 20);
            nome.setName("Name");
            datiTurista.add(nome, null);

            // Surname
            cognome = new JTextField(12);
            cognome.setBounds(185, 40, 136, 20);
            cognome.setName("Name");
            datiTurista.add(cognome, null);

            // Date of Birth
            giorno = new JComboBox();
            giorno.setBounds(185, 70, 40, 20);
            for (int i = 1; i <= 31; i++) {
                giorno.addItem(i);
            }
            mese = new JComboBox();
            mese.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent pEvent) {
                    int number = giorno.getItemCount();
                    switch (mese.getSelectedIndex()) {
                        case 0:
                        case 2:
                        case 4:
                        case 6:
                        case 7:
                        case 9:
                        case 11:
                            for (int i = number + 1; i <= 31; i++) {
                                giorno.addItem(i);
                            }
                            break;

                        case 1:
                            int year = (Integer) anno.getSelectedItem();
                            boolean leap = ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
                            if (number != 28) {
                                for (int i = number - 1; i > 27; i--) {
                                    giorno.removeItemAt(i);
                                }
                            }
                            if (leap && number != 29) {
                                giorno.addItem("29");
                            }
                            break;

                        case 3:
                        case 5:
                        case 8:
                        case 10:
                            if (number == 31) {
                                giorno.removeItemAt(30);
                            } else {
                                for (int i = number + 1; i <= 30; i++) {
                                    giorno.addItem(i);
                                }
                            }
                            break;
                    }
                }
            });
            mese.setBounds(245, 70, 40, 20);
            for (int i = 1; i <= 12; i++) {
                mese.addItem(i);
            }
            anno = new JComboBox();
            anno.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if (mese.getSelectedIndex() == 1) {
                        int year = (Integer) anno.getSelectedItem();
                        boolean leap = ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
                        int number = giorno.getItemCount();
                        if (leap && number != 29) {
                            giorno.addItem("29");
                        } else if (leap && number == 29) {
                            giorno.removeItemAt(28);
                        }
                    }
                }
            });
            anno.setBounds(305, 70, 80, 20);
            Date odierna = new Date();
            for (int i = 0; i <= odierna.getYear() - 14; i++) {
                anno.addItem(1900 + i);
            }
            datiTurista.add(giorno, null);
            datiTurista.add(mese, null);
            datiTurista.add(anno, null);

            // Place of Birth
            luogoNascita = new JTextField(12);
            luogoNascita.setBounds(185, 100, 136, 20);
            luogoNascita.setName("Birth Place");
            datiTurista.add(luogoNascita, null);

            // Phone
            telefono = new JTextField(12);
            telefono.setBounds(185, 130, 136, 20);
            telefono.setName("Phone");
            datiTurista.add(telefono, null);

            // Address
            indirizzo2 = new JTextField(12);
            indirizzo2.setBounds(270, 160, 136, 20);
            indirizzo1 = new JComboBox();
            indirizzo1.setSelectedIndex(-1);
            indirizzo1.setBounds(185, 160, 60, 20);
            datiTurista.add(indirizzo2, null);
            datiTurista.add(indirizzo1, null);

            // City
            citta = new JTextField(12);
            citta.setBounds(185, 190, 136, 20);
            citta.setName("City");
            datiTurista.add(citta, null);

            // CAP
            cap = new JTextField(8);
            cap.setBounds(185, 220, 92, 20);
            datiTurista.add(cap, null);

            // State
            provincia = new JComboBox();
            provincia.setSelectedIndex(-1);
            provincia.setBounds(185, 250, 50, 20);
            datiTurista.add(provincia, null);

            // E-Mail
            email = new JTextField();
            email.setBounds(185, 280, 200, 20);
            email.setName("E-Mail");
            datiTurista.add(email, null);

            // Username
            username = new JTextField();
            username.setBounds(185, 310, 136, 20);
            username.setName("Username");
            datiTurista.add(username, null);

            // Password
            password = new JPasswordField(12);
            password.setBounds(185, 340, 136, 20);
            password.setName("Password");
            datiTurista.add(password, null);

            // Data entry
            dataRegistrazione = new JLabel();
            dataRegistrazione.setBounds(185, 370, 140, 20);
            datiTurista.add(dataRegistrazione, null);
        }
        return datiTurista;
    }

    /**
     * This method returns the id of the tourist who is viewing /
     * Edit.
     *
     * @return int - the id of the tourist.
     */
    public int getId() {
        return turista.getId();
    }
}