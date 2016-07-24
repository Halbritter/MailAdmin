
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

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class PanelDomain extends JPanel implements TableSelectionEvent {
    @Getter
    private JTextField textDomain;
    @Getter
    private JSpinner spinnerID;

    /**
     * Create the panel.
     */
    public PanelDomain() {
        EventHandler.registerForSelectionChangeEvent(this);
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

        spinnerID = new JSpinner();
        GridBagConstraints gbc_spinner = new GridBagConstraints();
        gbc_spinner.ipadx = 20;
        gbc_spinner.anchor = GridBagConstraints.WEST;
        gbc_spinner.insets = new Insets(0, 0, 5, 0);
        gbc_spinner.gridx = 1;
        gbc_spinner.gridy = 0;
        add(spinnerID, gbc_spinner);

        JLabel lblDomain = new JLabel("Domain");
        GridBagConstraints gbc_lblDomain = new GridBagConstraints();
        gbc_lblDomain.ipadx = 10;
        gbc_lblDomain.insets = new Insets(0, 0, 5, 5);
        gbc_lblDomain.gridx = 0;
        gbc_lblDomain.gridy = 1;
        add(lblDomain, gbc_lblDomain);

        textDomain = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 0);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 1;
        add(textDomain, gbc_textField);
        textDomain.setColumns(10);

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
                    textDomain.setText((String) table.getValueAt(selectedRow, i));
            }
        }
    }
}
