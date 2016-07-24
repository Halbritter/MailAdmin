
/*
 * This file is part of MailAdmin.
 *
 *     MailAdmin is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 2 of the License, or
 *     (at your option) any later version.
 *
 *     MailAdmin is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with MailAdmin.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.albritter.gui;


import de.albritter.gui.tables.DataTable;
import de.albritter.utils.EventHandler;
import de.albritter.utils.TableSelectionEvent;
import lombok.Getter;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class PanelMailbox extends JPanel implements TableSelectionEvent {
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
    private JCheckBox chckbxUpdatePassword;
    @Getter
    private Box horizontalBox;
    @Getter
    private JSpinner spinnerQuota;
    @Getter
    private JComboBox comboBoxDomain;

    /**
     * Create the panel.
     */
    public PanelMailbox() {
        EventHandler.registerForSelectionChangeEvent(this);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0, 1.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel lblId = new JLabel("ID");
        GridBagConstraints gbc_lblId = new GridBagConstraints();
        gbc_lblId.anchor = GridBagConstraints.EAST;
        gbc_lblId.insets = new Insets(0, 0, 5, 5);
        gbc_lblId.gridx = 0;
        gbc_lblId.gridy = 0;
        add(lblId, gbc_lblId);

        spinnerID = new JSpinner();
        //spinnerID.setModel(new SpinnerNumberModel(1, 1, null, 1));
        // spinnerID.setEditor(new JSpinner.NumberEditor(spinnerID, "####"));
        //((JSpinner.DefaultEditor)
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
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 1;
        add(textMail, gbc_textField);
        textMail.setColumns(4);

        JLabel lblMailAddressDoamin = new JLabel("@");
        GridBagConstraints gbc_lblMailAddressDomain = new GridBagConstraints();
        gbc_lblMailAddressDomain.anchor = GridBagConstraints.EAST;
        gbc_lblMailAddressDomain.insets = new Insets(0, 0, 5, 5);
        gbc_lblMailAddressDomain.gridx = 2;
        gbc_lblMailAddressDomain.gridy = 1;
        add(lblMailAddressDoamin, gbc_lblMailAddressDomain);

        comboBoxDomain = new JComboBox(new String[]{"asdasd", "asda"});
        GridBagConstraints gbc_validDomainList = new GridBagConstraints();
        gbc_validDomainList.insets = new Insets(0, 0, 5, 5);
        gbc_validDomainList.gridx = 3;
        gbc_validDomainList.gridy = 1;
        gbc_validDomainList.fill = GridBagConstraints.HORIZONTAL;
        add(comboBoxDomain, gbc_validDomainList);

        JLabel lblPassword = new JLabel("Password");
        GridBagConstraints gbc_lblPassword = new GridBagConstraints();
        gbc_lblPassword.anchor = GridBagConstraints.EAST;
        gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
        gbc_lblPassword.gridx = 0;
        gbc_lblPassword.gridy = 2;
        add(lblPassword, gbc_lblPassword);

        passwordField = new JPasswordField();
        GridBagConstraints gbc_passwordField = new GridBagConstraints();
        gbc_passwordField.insets = new Insets(0, 0, 5, 5);
        gbc_passwordField.fill = GridBagConstraints.EAST;
        gbc_passwordField.gridx = 1;
        gbc_passwordField.gridy = 2;
        gbc_passwordField.gridwidth = 3;
        gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
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
        gbc_passwordField_1.insets = new Insets(0, 0, 5, 5);
        gbc_passwordField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_passwordField_1.gridx = 1;
        gbc_passwordField_1.gridy = 3;
        gbc_passwordField_1.gridwidth = 3;
        gbc_passwordField_1.fill = GridBagConstraints.HORIZONTAL;
        add(passwordField_1, gbc_passwordField_1);

        JLabel lblQuota = new JLabel("Quota (mb)");
        GridBagConstraints gbc_lblQuota = new GridBagConstraints();
        gbc_lblQuota.anchor = GridBagConstraints.EAST;
        gbc_lblQuota.insets = new Insets(0, 0, 5, 5);
        gbc_lblQuota.gridx = 0;
        gbc_lblQuota.gridy = 4;
        add(lblQuota, gbc_lblQuota);

        spinnerQuota = new JSpinner();
        spinnerQuota.setEditor(new JSpinner.NumberEditor(spinnerQuota, "#"));
        GridBagConstraints gbc_spinnerQuota = new GridBagConstraints();
        gbc_spinnerQuota.ipadx = 20;
        gbc_spinnerQuota.anchor = GridBagConstraints.WEST;
        gbc_spinnerQuota.insets = new Insets(0, 0, 5, 5);
        gbc_spinnerQuota.gridx = 1;
        gbc_spinnerQuota.gridy = 4;
        add(spinnerQuota, gbc_spinnerQuota);


        chckbxSendonly = new JCheckBox("Sendonly");
        chckbxSendonly.setActionCommand("Sendonly");
        GridBagConstraints gbc_chckbxSendonly = new GridBagConstraints();
        gbc_chckbxSendonly.anchor = GridBagConstraints.WEST;
        gbc_chckbxSendonly.insets = new Insets(0, 0, 5, 5);
        gbc_chckbxSendonly.gridx = 1;
        gbc_chckbxSendonly.gridy = 5;
        add(chckbxSendonly, gbc_chckbxSendonly);

        chckbxUpdatePassword = new JCheckBox("Change Password");
        chckbxUpdatePassword.setActionCommand("Change Password");
        GridBagConstraints gbc_chckbxUpdatePassword = new GridBagConstraints();
        gbc_chckbxUpdatePassword.anchor = GridBagConstraints.WEST;
        gbc_chckbxUpdatePassword.insets = new Insets(0, 0, 5, 0);
        gbc_chckbxUpdatePassword.gridx = 1;
        gbc_chckbxUpdatePassword.gridy = 7;
        add(chckbxUpdatePassword, gbc_chckbxUpdatePassword);

        chckbxActive = new JCheckBox("Active");
        chckbxActive.setActionCommand("Active");
        GridBagConstraints gbc_chckbxActive = new GridBagConstraints();
        gbc_chckbxActive.anchor = GridBagConstraints.WEST;
        gbc_chckbxActive.insets = new Insets(0, 0, 5, 0);
        gbc_chckbxActive.gridx = 1;
        gbc_chckbxActive.gridy = 6;
        add(chckbxActive, gbc_chckbxActive);

    }

    public void updateCombobox(String[] domains) {
        comboBoxDomain.setModel(new DefaultComboBoxModel<>(domains));
    }

    @Override
    public void selectionChange(DataTable table) {
        for (int i = 0; i < table.getColumnCount(); i++) {
            int selectedRow = table.getSelectedRow();
            switch ((String) table.getColumnModel().getColumn(i).getHeaderValue()) {
                case "ID":
                    spinnerID.setValue(table.getValueAt(selectedRow, i));
                    break;
                case "Domain":
                    comboBoxDomain.setSelectedItem(table.getValueAt(selectedRow, i));
                    break;
                case "Username":
                    textMail.setText((String) table.getValueAt(selectedRow, i));
                    break;
                case "Active":
                    chckbxActive.setSelected((Boolean) table.getValueAt(selectedRow, i));
                    break;
                case "Quota":
                    spinnerQuota.setValue(table.getValueAt(selectedRow, i));
                    break;
                case "Sendonly":
                    chckbxSendonly.setSelected((Boolean) table.getValueAt(selectedRow, i));
                    break;
            }
        }
    }
}
