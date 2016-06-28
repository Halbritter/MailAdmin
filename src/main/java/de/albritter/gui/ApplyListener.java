package de.albritter.gui;

import arlut.csd.crypto.Sha512Crypt;
import de.albritter.sql.MySQLHandler;
import de.albritter.sql.data.ADataObject;
import de.albritter.sql.data.Aliases;
import de.albritter.sql.data.Domain;
import de.albritter.sql.data.Mailbox;
import de.albritter.sql.data.TLSPolicy;

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
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String domain, user;
        ADataObject dataObject = null;
        int dbug = 0;

        switch (src.getTabbedPane().getSelectedIndex()) {
            case 0:
                try {
                    dataObject = new Domain();
                    dataObject.setId((Integer) src.getPanelDomain().getSpinnerID().getValue());
                    ((Domain) dataObject).setDomain(src.getPanelDomain().getTextDomain().getText());
                    break;
                } catch (IndexOutOfBoundsException ex) {
                    if (src.getRdbtnAdd().isSelected() || src.getRdbtnUpadte().isSelected()) {
                        JOptionPane.showMessageDialog(src, "Bitte \u00fcberpr\u00fcfen Sie Ihre eingabe");
                        return;
                    }
                    dataObject.setId((Integer) src.getPanelDomain().getSpinnerID().getValue());
                }
            case 1://Mailbox
                try {
                    dataObject = new Mailbox();
                    domain = src.getPanelMailbox().getTextMail().getText();
                    user = domain.substring(0, domain.indexOf('@'));
                    domain = domain.substring(domain.indexOf('@') + 1);
                    ((Mailbox) dataObject).setDomain(domain);
                    ((Mailbox) dataObject).setUsername(user);
                    ((Mailbox) dataObject).setPassword(Sha512Crypt.Sha512_crypt(src.getPanelMailbox().getPasswordField().getText(), null, 5000));
                    dataObject.setActive((src.getPanelMailbox().getChckbxActive().isSelected()) ? 1 : 0);
                    ((Mailbox) dataObject).setQuota((Integer) src.getPanelMailbox().getSpinnerQuota().getValue());
                    dataObject.setId((Integer) src.getPanelMailbox().getSpinnerID().getValue());
                    ((Mailbox) dataObject).setSendonly((src.getPanelMailbox().getChckbxSendonly().isSelected()) ? 1 : 0);
                } catch (IndexOutOfBoundsException ex) {
                    if (src.getRdbtnAdd().isSelected() || src.getRdbtnUpadte().isSelected()) {
                        JOptionPane.showMessageDialog(src, "Bitte \u00fcberpr\u00fcfen Sie Ihre eingabe");
                        return;
                    }
                    dataObject.setId((Integer) src.getPanelMailbox().getSpinnerID().getValue());

                }

                break;
            case 2://Alias
                try {
                    dataObject = new Aliases();
                    domain = src.getPanelAliases().getTextDestination().getText();
                    user = domain.substring(0, domain.indexOf('@'));
                    domain = domain.substring(domain.indexOf('@') + 1);
                    dataObject.setId((Integer) src.getPanelAliases().getSpinnerID().getValue());
                    ((Aliases) dataObject).setDestinationUsername(user);
                    ((Aliases) dataObject).setDestinationDomain(domain);
                    ((Aliases) dataObject).setSourceDomain((String) src.getPanelAliases().getComboBoxDomain().getSelectedItem());
                    ((Aliases) dataObject).setSourceUsername(src.getPanelAliases().getTextSourceUsername().getText());
                    dataObject.setActive(src.getPanelAliases().getChckbxActive().isSelected() ? 1 : 0);
                    break;
                } catch (IndexOutOfBoundsException ex) {
                    if (src.getRdbtnAdd().isSelected() || src.getRdbtnUpadte().isSelected()) {
                        JOptionPane.showMessageDialog(src, "Bitte \u00fcberpr\u00fcfen Sie Ihre eingabe");
                        return;
                    }
                    dataObject.setId((Integer) src.getPanelAliases().getSpinnerID().getValue());
                }
            case 3: //TLS
                try {
                    dataObject = new TLSPolicy();

                    dataObject.setId((Integer) src.getPanelTLS().getSpinnerID().getValue());
                    ((TLSPolicy) dataObject).setParms(src.getPanelTLS().getTextArgument().getText());
                    ((TLSPolicy) dataObject).setPolicy((String) src.getPanelTLS().getComboBoxPolicy().getSelectedItem());
                    ((TLSPolicy) dataObject).setDomain(src.getPanelTLS().getTextDomain().getText());
                    break;
                } catch (IndexOutOfBoundsException ex) {
                    if (src.getRdbtnAdd().isSelected() || src.getRdbtnUpadte().isSelected()) {
                        JOptionPane.showMessageDialog(src, "Bitte \u00fcberpr\u00fcfen Sie Ihre eingabe");
                        return;
                    }
                    dataObject.setId((Integer) src.getPanelTLS().getSpinnerID().getValue());
                }
        }
        if (src.getRdbtnAdd().isSelected()) {
            MySQLHandler.add(dataObject);
        } else if (src.getRdbtnUpadte().isSelected()) {
            MySQLHandler.update(dataObject);
        } else {
            int result = JOptionPane.showConfirmDialog(null,
                    "Are you sure to delete id " + dataObject.getId(), null, JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                MySQLHandler.remove(dataObject);
            }
        }

    }
}
