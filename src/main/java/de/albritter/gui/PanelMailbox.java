package de.albritter.gui;


import de.albritter.utils.EventHandler;
import de.albritter.utils.UseRadioSelection;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public class PanelMailbox extends JPanel implements UseRadioSelection {
    @Getter
    private JTextField textMail;
    @Getter
    private JPasswordField passwordField;
    @Getter
    private JPasswordField passwordField_1;
    @Getter
    private JSpinner spinnerID;
    @Getter
    private JCheckBox chckbxSendonly;
    @Getter
    private JCheckBox chckbxActive;
    @Getter
    private Box horizontalBox;
    @Getter
    private JSpinner spinnerQuota;

    /**
     * Create the panel.
     */
    public PanelMailbox() {
        EventHandler.registerForRadioEvent(this);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel lblId = new JLabel("ID");
        GridBagConstraints gbc_lblId = new GridBagConstraints();
        gbc_lblId.anchor = GridBagConstraints.EAST;
        gbc_lblId.insets = new Insets(0, 0, 5, 5);
        gbc_lblId.gridx = 0;
        gbc_lblId.gridy = 0;
        add(lblId, gbc_lblId);

        spinnerID = new JSpinner();
        spinnerID.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
        // spinnerID.setEditor(new JSpinner.NumberEditor(spinnerID, "####"));
        // ((JSpinner.DefaultEditor)
        // spinnerID.getEditor()).getTextField().setColumns(3);
        GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
        gbc_spinner_1.ipadx = 20;
        gbc_spinner_1.anchor = GridBagConstraints.WEST;
        gbc_spinner_1.insets = new Insets(0, 0, 5, 0);
        gbc_spinner_1.gridx = 1;
        gbc_spinner_1.gridy = 0;
        add(spinnerID, gbc_spinner_1);

        JLabel lblMailAddress = new JLabel("Mail address");
        GridBagConstraints gbc_lblMailAddress = new GridBagConstraints();
        gbc_lblMailAddress.anchor = GridBagConstraints.EAST;
        gbc_lblMailAddress.insets = new Insets(0, 0, 5, 5);
        gbc_lblMailAddress.gridx = 0;
        gbc_lblMailAddress.gridy = 1;
        add(lblMailAddress, gbc_lblMailAddress);

        textMail = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 0);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 1;
        add(textMail, gbc_textField);
        textMail.setColumns(10);

        JLabel lblPassword = new JLabel("Password");
        GridBagConstraints gbc_lblPassword = new GridBagConstraints();
        gbc_lblPassword.anchor = GridBagConstraints.EAST;
        gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
        gbc_lblPassword.gridx = 0;
        gbc_lblPassword.gridy = 2;
        add(lblPassword, gbc_lblPassword);

        passwordField = new JPasswordField();
        GridBagConstraints gbc_passwordField = new GridBagConstraints();
        gbc_passwordField.insets = new Insets(0, 0, 5, 0);
        gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
        gbc_passwordField.gridx = 1;
        gbc_passwordField.gridy = 2;
        add(passwordField, gbc_passwordField);

        JLabel lblRetypePassword = new JLabel("Retype Password");
        GridBagConstraints gbc_lblRetypePassword = new GridBagConstraints();
        gbc_lblRetypePassword.anchor = GridBagConstraints.EAST;
        gbc_lblRetypePassword.insets = new Insets(0, 0, 5, 5);
        gbc_lblRetypePassword.gridx = 0;
        gbc_lblRetypePassword.gridy = 3;
        add(lblRetypePassword, gbc_lblRetypePassword);

        passwordField_1 = new JPasswordField();
        GridBagConstraints gbc_passwordField_1 = new GridBagConstraints();
        gbc_passwordField_1.insets = new Insets(0, 0, 5, 0);
        gbc_passwordField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_passwordField_1.gridx = 1;
        gbc_passwordField_1.gridy = 3;
        add(passwordField_1, gbc_passwordField_1);

        JLabel lblQuota = new JLabel("Quota");
        GridBagConstraints gbc_lblQuota = new GridBagConstraints();
        gbc_lblQuota.anchor = GridBagConstraints.EAST;
        gbc_lblQuota.insets = new Insets(0, 0, 5, 5);
        gbc_lblQuota.gridx = 0;
        gbc_lblQuota.gridy = 4;
        add(lblQuota, gbc_lblQuota);

        spinnerQuota = new JSpinner();
        GridBagConstraints gbc_spinnerQuota = new GridBagConstraints();
        gbc_spinnerQuota.ipadx = 20;
        gbc_spinnerQuota.anchor = GridBagConstraints.WEST;
        gbc_spinnerQuota.insets = new Insets(0, 0, 5, 0);
        gbc_spinnerQuota.gridx = 1;
        gbc_spinnerQuota.gridy = 4;
        add(spinnerQuota, gbc_spinnerQuota);


        chckbxSendonly = new JCheckBox("Sendonly");
        chckbxSendonly.setActionCommand("Sendonly");
        GridBagConstraints gbc_chckbxSendonly = new GridBagConstraints();
        gbc_chckbxSendonly.anchor = GridBagConstraints.WEST;
        gbc_chckbxSendonly.insets = new Insets(0, 0, 5, 0);
        gbc_chckbxSendonly.gridx = 1;
        gbc_chckbxSendonly.gridy = 5;
        add(chckbxSendonly, gbc_chckbxSendonly);

        chckbxActive = new JCheckBox("Active");
        chckbxActive.setActionCommand("Active");
        GridBagConstraints gbc_chckbxActive = new GridBagConstraints();
        gbc_chckbxActive.anchor = GridBagConstraints.WEST;
        gbc_chckbxActive.gridx = 1;
        gbc_chckbxActive.gridy = 6;
        add(chckbxActive, gbc_chckbxActive);

    }

    @Override
    public void selectAdd() {
        spinnerID.setEnabled(false);
        textMail.setEnabled(true);
        passwordField.setEnabled(true);
        passwordField_1.setEnabled(true);
        spinnerQuota.setEnabled(true);
        chckbxActive.setEnabled(true);
        chckbxSendonly.setEnabled(true);
    }

    @Override
    public void selectUpdate() {
        spinnerID.setEnabled(true);
        textMail.setEnabled(true);
        passwordField.setEnabled(true);
        passwordField_1.setEnabled(true);
        spinnerQuota.setEnabled(true);
        chckbxActive.setEnabled(true);
        chckbxSendonly.setEnabled(true);

    }

    @Override
    public void selectRemove() {
        spinnerID.setEnabled(true);
        textMail.setEnabled(false);
        passwordField.setEnabled(false);
        passwordField_1.setEnabled(false);
        spinnerQuota.setEnabled(false);
        chckbxActive.setEnabled(false);
        chckbxSendonly.setEnabled(false);

    }
}
