package de.albritter.gui;

import javax.swing.*;
import java.awt.*;

public class PanelDomain extends JPanel {
    private JTextField textField;

    /**
     * Create the panel.
     */
    public PanelDomain() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel lblId = new JLabel("ID");
        GridBagConstraints gbc_lblId = new GridBagConstraints();
        gbc_lblId.insets = new Insets(0, 0, 5, 5);
        gbc_lblId.gridx = 0;
        gbc_lblId.gridy = 0;
        add(lblId, gbc_lblId);

        JSpinner spinner = new JSpinner();
        GridBagConstraints gbc_spinner = new GridBagConstraints();
        gbc_spinner.ipadx = 20;
        gbc_spinner.anchor = GridBagConstraints.WEST;
        gbc_spinner.insets = new Insets(0, 0, 5, 0);
        gbc_spinner.gridx = 1;
        gbc_spinner.gridy = 0;
        add(spinner, gbc_spinner);

        JLabel lblDomain = new JLabel("Domain");
        GridBagConstraints gbc_lblDomain = new GridBagConstraints();
        gbc_lblDomain.ipadx = 10;
        gbc_lblDomain.insets = new Insets(0, 0, 5, 5);
        gbc_lblDomain.gridx = 0;
        gbc_lblDomain.gridy = 1;
        add(lblDomain, gbc_lblDomain);

        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 0);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 1;
        add(textField, gbc_textField);
        textField.setColumns(10);

        JCheckBox chckbxActiv = new JCheckBox("Active");
        GridBagConstraints gbc_chckbxActiv = new GridBagConstraints();
        gbc_chckbxActiv.anchor = GridBagConstraints.WEST;
        gbc_chckbxActiv.gridx = 1;
        gbc_chckbxActiv.gridy = 2;
        add(chckbxActiv, gbc_chckbxActiv);

    }

}
