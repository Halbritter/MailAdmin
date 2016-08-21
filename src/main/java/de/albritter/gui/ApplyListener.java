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

import arlut.csd.crypto.Sha512Crypt;
import de.albritter.sql.MySQLHandler;
import de.albritter.sql.data.ADataObject;
import de.albritter.sql.data.Aliases;
import de.albritter.sql.data.Domain;
import de.albritter.sql.data.Mailbox;
import de.albritter.sql.data.TLSPolicy;
import de.albritter.utils.StringUtils;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by hhalbritter on 15.06.2016.
 */
public class ApplyListener implements ActionListener {
    private WindowMain src;

    public ApplyListener(WindowMain src) {

        this.src = src;
    }

    /**
     * Invoked when an action occurs.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ADataObject dataObject = null;
        switch (src.getTabbedPane().getSelectedIndex()) {
            case 0: //domain
                dataObject = new Domain();
                dataObject.setId((int) src.getPanelDomain().getSpinnerID().getValue());
                String domain = src.getPanelDomain().getTextDomain().getText();
                if (!domain.equals(""))
                    ((Domain) dataObject).setDomain(domain);
                else {

                    if (!e.getActionCommand().equals("Remove")) {
                        JOptionPane.showMessageDialog(src, "Ihre Eingabe in dem Feld Domain ist ung\u00fcltig", "Fehler", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                break;
            case 1: //mailbox
                if (e.getActionCommand().equals("Add"))
                    src.getPanelMailbox().getChckbxUpdatePassword().setSelected(true);
                dataObject = new Mailbox();
                dataObject.setId((int) src.getPanelMailbox().getSpinnerID().getValue());
                ((Mailbox) dataObject).setDomain((String) src.getPanelMailbox().getComboBoxDomain().getSelectedItem());
                if (src.getPanelMailbox().getChckbxUpdatePassword().isSelected()) {
                    if (src.getPanelMailbox().getPasswordField().getText().equals(src.getPanelMailbox().getPasswordField_1().getText())) {
                        ((Mailbox) dataObject).setPassword(Sha512Crypt.Sha512_crypt(src.getPanelMailbox().getPasswordField().getText(), null, 5000));
                    } else {
                        JOptionPane.showMessageDialog(src, "Passw\u00f6rter stimmen nicht \u00fcberein", "Fehler", JOptionPane.ERROR_MESSAGE);
                    }
                    ((Mailbox) dataObject).setChangePassword(true);

                } else {
                    ((Mailbox) dataObject).setChangePassword(false);
                }
                String user = src.getPanelMailbox().getTextMail().getText();
                if (!user.equals("")) {
                    ((Mailbox) dataObject).setUsername(user);
                } else {
                    if (!e.getActionCommand().equals("Remove")) {
                        JOptionPane.showMessageDialog(src, "Ihre Eingabe in dem Feld \"Mail Address\" ist ung\u00fcltig", "Fehler", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                ((Mailbox) dataObject).setActive(src.getPanelMailbox().getChckbxActive().isSelected() ? 1 : 0);
                ((Mailbox) dataObject).setSendonly(src.getPanelMailbox().getChckbxSendonly().isSelected() ? 1 : 0);
                if (!e.getActionCommand().equals("Remove"))
                    try {

                        src.getPanelMailbox().getSpinnerQuota().commitEdit();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                ((Mailbox) dataObject).setQuota(Integer.valueOf(String.valueOf( src.getPanelMailbox().getSpinnerQuota().getValue())));
                break;
            case 2: //Aliases
                dataObject = new Aliases();
                dataObject.setId((int) src.getPanelAliases().getSpinnerID().getValue());
                String sUser = src.getPanelAliases().getTextSourceUsername().getText();
                if (!sUser.equals("")) {
                    ((Aliases) dataObject).setSourceUsername(sUser);
                } else {
                    JOptionPane.showMessageDialog(src, "Ihre Eingabe in dem Feld \"Source\" ist ung\u00fcltig", "Fehler", JOptionPane.ERROR_MESSAGE);
                    if (!e.getActionCommand().equals("Remove"))
                        return;
                }
                ((Aliases) dataObject).setSourceDomain((String) src.getPanelAliases().getComboBoxDomain().getSelectedItem());
                String dUser = src.getPanelAliases().getTextDestination().getText();
                if (StringUtils.verifyEmailAddressFormat(dUser)) {
                    String dDomain = dUser.substring(dUser.indexOf('@') + 1, dUser.length());
                    dUser = dUser.substring(0, dUser.indexOf('@'));
                    ((Aliases) dataObject).setDestinationUsername(dUser);
                    ((Aliases) dataObject).setDestinationDomain(dDomain);
                } else {
                    if (!e.getActionCommand().equals("Remove")) {
                        JOptionPane.showMessageDialog(src, "Ihre Eingabe in dem Feld \"Destination\" ist ung\u00fcltig", "Fehler", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                ((Aliases) dataObject).setActive(src.getPanelAliases().getChckbxActive().isSelected() ? 1 : 0);
                break;
            case 3: //TLS
                dataObject = new TLSPolicy();
                dataObject.setId((int) src.getPanelTLS().getSpinnerID().getValue());
                ((TLSPolicy) dataObject).setDomain(src.getPanelTLS().getTextDomain().getText());
                ((TLSPolicy) dataObject).setPolicy((String) src.getPanelTLS().getComboBoxPolicy().getSelectedItem());
                ((TLSPolicy) dataObject).setParms(src.getPanelTLS().getTextArgument().getText());
                break;
        }
        switch (e.getActionCommand()) {
            case "Add":
                MySQLHandler.add(dataObject);
                break;
            case "Update":
                MySQLHandler.update(dataObject);
                break;
            case "Remove":
                MySQLHandler.remove(dataObject);
                break;
        }

        src.updateTables();
    }
}
