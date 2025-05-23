package unisa.gps.etour.gui.operatoreagenzia;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.border.*;

import unisa.gps.etour.gui.operatoreagenzia.Home;

/**
 * This class realizes the panel for the dialog for entering a
 * New banner or a banner for replacing selected.
 *
 * @Version 1.0
 * @Author Mario Gallo
 *
 * © 2007 eTour Project - Copyright by DMI SE @ SA Lab --
 * University of Salerno
 */
public class BannerDialog extends JPanel {
    private final static Dimension bannerSize = new Dimension(140, 40);
    private JLabel anteprima = null;
    private JButton btnCarica = null;
    private JPanel that;

    /**
     * This is the default constructor.
     */
    public BannerDialog() {
        super(null);
        this.that = this;
        setPreferredSize(new Dimension(420, 160));
        anteprima = new JLabel();
        anteprima.setBounds(new Rectangle(40, 20, 250, 60));
        anteprima.setBorder(BorderFactory.createTitledBorder(BorderFactory
                .createLineBorder(new Color(51, 102, 255), 3),
                "Preview Banner", TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("Dialog", Font.BOLD, 12), new Color(0, 102, 204)));
        btnCarica = new JButton();
        btnCarica.setBounds(new Rectangle(320, 30, 50, 40));
        btnCarica.setIcon(new ImageIcon(getClass().getResource(
                Home.URL_IMAGES + "ApriFile.png")));
        btnCarica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                File f = apriFileDialog();

                if (f == null) {
                    return;
                }

                BufferedImage img = null;
                try {
                    img = ImageIO.read(f);
                    if (img.getWidth() > bannerSize.width
                            || img.getHeight() > bannerSize.height) {
                        img = img.getSubimage(0, 0, bannerSize.width,
                                bannerSize.height);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ImageIcon n = new ImageIcon(img);
                anteprima.setIcon(n);
                anteprima.repaint();
            }
        });

        JLabel txtAttenzione = new JLabel("Warning!");
        txtAttenzione.setIcon(new ImageIcon(getClass().getResource(
                Home.URL_IMAGES + "warning16.png")));
        txtAttenzione.setBounds(10, 85, 100, 30);
        JLabel txtTesto = new JLabel(
                "<html> <ul> <li> image for the banner can not exceed <b> <font color=\"red\">"
                        + bannerSize.width
                        + "X"
                        + bannerSize.height
                        + "</font></b> pixels."
                        + "<li> Images of magnitude larger will be resized.</ul></html>");
        txtTesto.setBounds(0, 90, 420, 80);
        add(txtTesto, null);
        add(txtAttenzione, null);
        add(anteprima, null);
        add(btnCarica, null);
    }

    /**
     * This method initializes the image contained in the preview.
     *
     * @param pBanner ImageIcon - an image of a banner.
     */
    public void setSelectedBanner(ImageIcon pBanner) {
        anteprima.setIcon(pBanner);
    }

    /**
     * This method returns the image contained in the preview.
     *
     * @return ImageIcon - the image of the banner.
     */
    public ImageIcon getSelectedBanner() {
        return (ImageIcon) anteprima.getIcon();
    }

    /**
     * This method opens the dialog for selecting a file from disk.
     *
     * @return
     * <ul>
     * <li> Files - the selected file.
     * <li> Null - if you have not selected any files.
     * </ul>
     */
    private File apriFileDialog() {
        JFileChooser apriFile = new JFileChooser();
        apriFile.setDialogTitle("Select a new image");
        apriFile.setAcceptAllFileFilterUsed(false);
        apriFile.setMultiSelectionEnabled(false);

        // File Filter for the window to open the file.
        apriFile.setFileFilter(new FileFilter() {
            public boolean accept(File arg0) {
                if (arg0.isDirectory())
                    return true;
                String nome = arg0.getName().toLowerCase();
                if (nome.endsWith("jpg") || nome.endsWith("gif")
                        || nome.endsWith("png"))
                    return true;
                else
                    return false;
            }

            public String getDescription() {
                return "Images (*.PNG, *.GIF, *.JPG)";
            }
        });
        int returnVal = apriFile.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return apriFile.getSelectedFile();
        } else
            return null;
    }
}