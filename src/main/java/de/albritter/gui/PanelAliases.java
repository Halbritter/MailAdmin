package de.albritter.gui;

import javax.swing.*;
import java.awt.*;

public class PanelAliases extends JPanel {
    private JTextField textField;
    private JTextField textField_1;
    private JCheckBox chckbxActive;
    private JComboBox comboBox;
    private JSpinner spinnerID;

    /**
     * Create the panel.
     */
    public PanelAliases() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 29, 0};
        gridBagLayout.rowHeights = new int[]{20, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel lblId = new JLabel("ID");
        GridBagConstraints gbc_lblId = new GridBagConstraints();
        gbc_lblId.anchor = GridBagConstraints.EAST;
        gbc_lblId.insets = new Insets(0, 0, 5, 5);
        gbc_lblId.gridx = 0;
        gbc_lblId.gridy = 0;
        add(lblId, gbc_lblId);

        spinnerID = new JSpinner();
        GridBagConstraints gbc_spinnerID = new GridBagConstraints();
        gbc_spinnerID.insets = new Insets(0, 0, 5, 5);
        gbc_spinnerID.ipadx = 20;
        gbc_spinnerID.anchor = GridBagConstraints.NORTHWEST;
        gbc_spinnerID.gridx = 1;
        gbc_spinnerID.gridy = 0;
        add(spinnerID, gbc_spinnerID);

        JLabel lblSourceMailadress = new JLabel("Source");
        GridBagConstraints gbc_lblSourceMailadress = new GridBagConstraints();
        gbc_lblSourceMailadress.anchor = GridBagConstraints.EAST;
        gbc_lblSourceMailadress.insets = new Insets(0, 0, 5, 5);
        gbc_lblSourceMailadress.gridx = 0;
        gbc_lblSourceMailadress.gridy = 1;
        add(lblSourceMailadress, gbc_lblSourceMailadress);

        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 1;
        add(textField, gbc_textField);
        textField.setColumns(10);

        JLabel lblAT1 = new JLabel("@");
        GridBagConstraints gbc_lblAT1 = new GridBagConstraints();
        gbc_lblAT1.insets = new Insets(0, 0, 5, 5);
        gbc_lblAT1.anchor = GridBagConstraints.EAST;
        gbc_lblAT1.gridx = 2;
        gbc_lblAT1.gridy = 1;
        add(lblAT1, gbc_lblAT1);

        comboBox = new JComboBox();
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.insets = new Insets(0, 0, 5, 5);
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.gridx = 3;
        gbc_comboBox.gridy = 1;
        add(comboBox, gbc_comboBox);

        JLabel lblDestination = new JLabel("Destination");
        GridBagConstraints gbc_lblDestination = new GridBagConstraints();
        gbc_lblDestination.anchor = GridBagConstraints.EAST;
        gbc_lblDestination.insets = new Insets(0, 0, 5, 5);
        gbc_lblDestination.gridx = 0;
        gbc_lblDestination.gridy = 2;
        add(lblDestination, gbc_lblDestination);

        textField_1 = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.gridwidth = 3;
        gbc_textField_1.insets = new Insets(0, 0, 5, 5);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 1;
        gbc_textField_1.gridy = 2;
        add(textField_1, gbc_textField_1);
        textField_1.setColumns(10);

        chckbxActive = new JCheckBox("Active");
        GridBagConstraints gbc_chckbxActive = new GridBagConstraints();
        gbc_chckbxActive.anchor = GridBagConstraints.WEST;
        gbc_chckbxActive.insets = new Insets(0, 0, 0, 5);
        gbc_chckbxActive.gridx = 1;
        gbc_chckbxActive.gridy = 3;
        add(chckbxActive, gbc_chckbxActive);

    }

    public JCheckBox getChckbxActive() {
        return chckbxActive;
    }

    public JTextField getTextField_1() {
        return textField_1;
    }

    public JTextField getTextField() {
        return textField;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public JSpinner getSpinnerID() {
        return spinnerID;
    }
}
