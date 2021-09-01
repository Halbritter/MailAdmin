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

import de.albritter.sql.MySQLHandler;
import de.albritter.utils.Options;
import de.albritter.utils.Profile;

import javax.swing.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Set;

public class Window extends JFrame {
    private JComboBox<String> comboServer;
    private JTextField txtDatabase;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private HashMap<Integer, Profile> proflist;

    public Window() {
        super("Login");
        setDefaultCloseOperation(3);
        setSize(new Dimension(320, 210));
        setMinimumSize(new Dimension(300, 200));
        setLocationRelativeTo(null);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        Component rigidArea = Box.createRigidArea(new Dimension(5, 5));
        GridBagConstraints gbc_rigidArea = new GridBagConstraints();
        gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
        gbc_rigidArea.gridx = 0;
        gbc_rigidArea.gridy = 0;
        getContentPane().add(rigidArea, gbc_rigidArea);

        JLabel lblServer = new JLabel("Server");
        GridBagConstraints gbc_lblServer = new GridBagConstraints();
        gbc_lblServer.insets = new Insets(0, 0, 5, 5);
        gbc_lblServer.anchor = GridBagConstraints.WEST;
        gbc_lblServer.gridx = 1;
        gbc_lblServer.gridy = 1;
        getContentPane().add(lblServer, gbc_lblServer);

        comboServer = new JComboBox<>();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.gridwidth = 3;
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 2;
        gbc_textField.gridy = 1;
        comboServer.setEditable(true);
        getContentPane().add(comboServer, gbc_textField);


        JLabel lblNewLabel_1 = new JLabel("Database");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 2;
        getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

        txtDatabase = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.gridwidth = 3;
        gbc_textField_1.insets = new Insets(0, 0, 5, 5);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 2;
        gbc_textField_1.gridy = 2;
        getContentPane().add(txtDatabase, gbc_textField_1);
        txtDatabase.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Username");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 1;
        gbc_lblNewLabel_2.gridy = 3;
        getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);

        txtUsername = new JTextField();
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.gridwidth = 3;
        gbc_textField_2.insets = new Insets(0, 0, 5, 5);
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.gridx = 2;
        gbc_textField_2.gridy = 3;
        getContentPane().add(txtUsername, gbc_textField_2);
        txtUsername.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Password");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 1;
        gbc_lblNewLabel_3.gridy = 4;
        getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);

        txtPassword = new JPasswordField();
        GridBagConstraints gbc_textField_3 = new GridBagConstraints();
        gbc_textField_3.gridwidth = 3;
        gbc_textField_3.insets = new Insets(0, 0, 5, 5);
        gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_3.gridx = 2;
        gbc_textField_3.gridy = 4;
        getContentPane().add(txtPassword, gbc_textField_3);
        txtPassword.setColumns(10);

        Component horizontalStrut = Box.createHorizontalStrut(10);
        GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
        gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
        gbc_horizontalStrut.gridx = 5;
        gbc_horizontalStrut.gridy = 1;
        getContentPane().add(horizontalStrut, gbc_horizontalStrut);

//        JCheckBox chckbxNewCheckBox = new JCheckBox("Save credentials");
//        GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
//        gbc_chckbxNewCheckBox.gridwidth = 3;
//        gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
//        gbc_chckbxNewCheckBox.anchor = GridBagConstraints.WEST;
//        gbc_chckbxNewCheckBox.gridx = 2;
//        gbc_chckbxNewCheckBox.gridy = 5;
//        getContentPane().add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);

        ActionListener loginActionListener = new LoginActionListener(this);
        JButton btnNewButton_1 = new JButton("Cancel");
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.anchor = GridBagConstraints.EAST;
        gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton_1.gridx = 3;
        gbc_btnNewButton_1.gridy = 6;
        btnNewButton_1.setActionCommand("Cancel");
        btnNewButton_1.addActionListener(loginActionListener);
        getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);

        JButton btnNewButton = new JButton("Login");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.anchor = GridBagConstraints.EAST;
        gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton.gridx = 4;
        gbc_btnNewButton.gridy = 6;
        btnNewButton.addActionListener(loginActionListener);
        btnNewButton.setActionCommand("Login");
        getContentPane().add(btnNewButton, gbc_btnNewButton);

        JButton btnRemoveButton = new JButton("Remove");
        GridBagConstraints gbc_btnRemoveButton = new GridBagConstraints();
        gbc_btnRemoveButton.anchor = GridBagConstraints.EAST;
        gbc_btnRemoveButton.insets = new Insets(0, 0, 0, 5);
        gbc_btnRemoveButton.gridx = 2;
        gbc_btnRemoveButton.gridy = 6;
        btnRemoveButton.addActionListener(loginActionListener);
        btnRemoveButton.setActionCommand("Remove");
        getContentPane().add(btnRemoveButton, gbc_btnRemoveButton);


        proflist = Options.getInstance().loadProfiles();
        Set<Integer> keys = proflist.keySet();
        final HashMap<String, Profile> profbyname = new HashMap<>();
        for (int i : keys) {
            comboServer.addItem(proflist.get(i).getServer());
            profbyname.put(proflist.get(i).getServer(), proflist.get(i));
        }
        comboServer.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                if (comboServer.getItemAt(comboServer.getSelectedIndex()) != null) {
                    txtDatabase.setText(profbyname.get(comboServer.getItemAt(comboServer.getSelectedIndex())).getDbname());
                    txtUsername.setText(profbyname.get(comboServer.getItemAt(comboServer.getSelectedIndex())).getUsername());
                }
            }
        });
        comboServer.getItemListeners()[0].itemStateChanged(null);

    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Window frame = new Window();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public boolean openMySQLConection() {
        if (comboServer.getItemAt(comboServer.getSelectedIndex()) == null) {
            MySQLHandler.setServer((String) comboServer.getEditor().getItem());
        } else {
            MySQLHandler.setServer(comboServer.getItemAt(comboServer.getSelectedIndex()));
        }
        MySQLHandler.setUser(this.txtUsername.getText());
        MySQLHandler.setDb(this.txtDatabase.getText());
        MySQLHandler.setPassword(this.txtPassword.getText());

        return MySQLHandler.openConnection();
    }

    public void saveNewProfile() {
        System.out.println("");
        Options o = Options.getInstance();
        Profile p = new Profile();
        p.setDbname(txtDatabase.getText());
        if (comboServer.getItemAt(comboServer.getSelectedIndex()) == null) {
            p.setServer((String) comboServer.getEditor().getItem());
            System.out.println("editor");
        } else {
            p.setServer(comboServer.getItemAt(comboServer.getSelectedIndex()));
            System.out.println("index");
        }
        System.out.println(p.getServer() + " :p");
        p.setUsername(txtUsername.getText());
        o.saveProfile(p);
    }

    public void removeProfileCurrent() {
        Profile p = new Profile();
        if (comboServer.getItemAt(comboServer.getSelectedIndex()) == null) {
            p.setServer((String) comboServer.getEditor().getItem());
            System.out.println("editor");
        } else {
            p.setServer(comboServer.getItemAt(comboServer.getSelectedIndex()));
            System.out.println("index");
        }
        Options.getInstance().removeProfile(p);
        proflist = Options.getInstance().loadProfiles();
        Set<Integer> keys = proflist.keySet();
        comboServer.removeAllItems();
        for (int i : keys) {
            comboServer.addItem(proflist.get(i).getServer());
        }
    }
}
