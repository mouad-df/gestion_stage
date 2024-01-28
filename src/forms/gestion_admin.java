package forms;


import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import Admin.BD_admin;
import Admin.admin;
import Admin.message_supprimer;
import Admin.mise_�_jour;
import Admin.modifier_admin;
import Stagiaire.BD_stagiaire;
import historique.BD_historique;
import historique.historique;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class gestion_admin extends javax.swing.JPanel {

    ArrayList<String> CIN = new ArrayList<String>();
    BD_admin bd;
    BD_stagiaire Bd;
    BD_historique BD;
    String pass = null;
    String currentuser;
    public static String cinselected = null;
    DefaultTableModel model;

    public gestion_admin() throws SQLException, Exception {
        initComponents();
        bd = new BD_admin("localhost", 3306, "Gestion_Stages", "root", "");
        Bd = new BD_stagiaire("localhost", 3306, "Gestion_Stages", "root", "");
        BD = new BD_historique("localhost", 3306, "Gestion_Stages", "root", "");
        this.setFocusable(true);
        table1.fixTable(jScrollPane1);
        bd.getAdmins(table1);
        supprimer.setVisible(false);
        modifier.setVisible(false);
        model = (DefaultTableModel) table1.getModel();
        currentuser = bd.getcurrentAdmin(Authentification.usercurrent);
        DocumentListener dl;
        dl = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                model = (DefaultTableModel) table1.getModel();
                if (!(rechercher.getText().equals("Rechercher"))) {
                    try {
                        if (rechercher.getText().isEmpty() == false) {
                            //model.setNumRows(0); 
                            table1.removeall(table1);
                            bd.rechercher(rechercher.getText(), table1);
                        } else {
                            table1.removeall(table1);
                            bd.getAdmins(table1);
                        }
                    } catch (SQLException ex) {
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                model = (DefaultTableModel) table1.getModel();
                if (!(rechercher.getText().equals("Rechercher"))) {
                    try {
                        if (rechercher.getText().isEmpty() == false) {
                            table1.removeall(table1);
                            bd.rechercher(rechercher.getText(), table1);
                        } else {
                            table1.removeall(table1);
                            bd.getAdmins(table1);
                        }
                    } catch (SQLException ex) {
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        };
        rechercher.getDocument().addDocumentListener(dl);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        mise = new com.k33ptoo.components.KButton();
        Ajouter = new com.k33ptoo.components.KButton();
        modifier = new com.k33ptoo.components.KButton();
        supprimer = new com.k33ptoo.components.KButton();
        nom = new javaswingdev.swing.rounde();
        tel = new javaswingdev.swing.rounde();
        cin = new javaswingdev.swing.rounde();
        email1 = new javaswingdev.swing.rounde();
        password = new javaswingdev.swing.rounde();
        rechercher = new javaswingdev.swing.rounde();
        roundPanel1 = new javaswingdev.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javaswingdev.swing.table.Table();

        jSeparator1.setForeground(new java.awt.Color(204, 102, 255));

        mise.setForeground(new java.awt.Color(0, 0, 0));
        mise.setText("Mise à jour");
        mise.setBorderPainted(false);
        mise.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mise.setkAllowTab(true);
        mise.setkBackGroundColor(new java.awt.Color(143, 148, 251));
        mise.setkBorderRadius(50);
        mise.setkEndColor(new java.awt.Color(143, 148, 251));
        mise.setkForeGround(new java.awt.Color(0, 0, 0));
        mise.setkHoverColor(new java.awt.Color(143, 148, 251));
        mise.setkHoverEndColor(new java.awt.Color(143, 148, 251));
        mise.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        mise.setkHoverStartColor(new java.awt.Color(143, 148, 251));
        mise.setkIndicatorColor(new java.awt.Color(143, 148, 251));
        mise.setkPressedColor(new java.awt.Color(143, 148, 251));
        mise.setkSelectedColor(new java.awt.Color(143, 148, 251));
        mise.setkStartColor(new java.awt.Color(143, 148, 251));
        mise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miseActionPerformed(evt);
            }
        });

        Ajouter.setForeground(new java.awt.Color(0, 0, 0));
        Ajouter.setText("Ajouter");
        Ajouter.setBorderPainted(false);
        Ajouter.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Ajouter.setkAllowTab(true);
        Ajouter.setkBackGroundColor(new java.awt.Color(143, 148, 251));
        Ajouter.setkBorderRadius(50);
        Ajouter.setkEndColor(new java.awt.Color(143, 148, 251));
        Ajouter.setkForeGround(new java.awt.Color(0, 0, 0));
        Ajouter.setkHoverColor(new java.awt.Color(143, 148, 251));
        Ajouter.setkHoverEndColor(new java.awt.Color(143, 148, 251));
        Ajouter.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        Ajouter.setkHoverStartColor(new java.awt.Color(143, 148, 251));
        Ajouter.setkIndicatorColor(new java.awt.Color(143, 148, 251));
        Ajouter.setkPressedColor(new java.awt.Color(143, 148, 251));
        Ajouter.setkSelectedColor(new java.awt.Color(143, 148, 251));
        Ajouter.setkStartColor(new java.awt.Color(143, 148, 251));
        Ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterActionPerformed(evt);
            }
        });

        modifier.setForeground(new java.awt.Color(0, 0, 0));
        modifier.setText("Modifier");
        modifier.setBorderPainted(false);
        modifier.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        modifier.setkAllowTab(true);
        modifier.setkBackGroundColor(new java.awt.Color(143, 148, 251));
        modifier.setkBorderRadius(50);
        modifier.setkEndColor(new java.awt.Color(143, 148, 251));
        modifier.setkForeGround(new java.awt.Color(0, 0, 0));
        modifier.setkHoverColor(new java.awt.Color(143, 148, 251));
        modifier.setkHoverEndColor(new java.awt.Color(143, 148, 251));
        modifier.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        modifier.setkHoverStartColor(new java.awt.Color(143, 148, 251));
        modifier.setkIndicatorColor(new java.awt.Color(143, 148, 251));
        modifier.setkPressedColor(new java.awt.Color(143, 148, 251));
        modifier.setkSelectedColor(new java.awt.Color(143, 148, 251));
        modifier.setkStartColor(new java.awt.Color(143, 148, 251));
        modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierActionPerformed(evt);
            }
        });

        supprimer.setForeground(new java.awt.Color(0, 0, 0));
        supprimer.setText("Supprimer");
        supprimer.setBorderPainted(false);
        supprimer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        supprimer.setkAllowTab(true);
        supprimer.setkBackGroundColor(new java.awt.Color(143, 148, 251));
        supprimer.setkBorderRadius(50);
        supprimer.setkEndColor(new java.awt.Color(143, 148, 251));
        supprimer.setkForeGround(new java.awt.Color(0, 0, 0));
        supprimer.setkHoverColor(new java.awt.Color(143, 148, 251));
        supprimer.setkHoverEndColor(new java.awt.Color(143, 148, 251));
        supprimer.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        supprimer.setkHoverStartColor(new java.awt.Color(143, 148, 251));
        supprimer.setkIndicatorColor(new java.awt.Color(143, 148, 251));
        supprimer.setkPressedColor(new java.awt.Color(143, 148, 251));
        supprimer.setkSelectedColor(new java.awt.Color(143, 148, 251));
        supprimer.setkStartColor(new java.awt.Color(143, 148, 251));
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        nom.setText("Nom complet");
        nom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nomFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nomFocusLost(evt);
            }
        });

        tel.setText("Télephone");
        tel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                telFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                telFocusLost(evt);
            }
        });
        tel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telActionPerformed(evt);
            }
        });

        cin.setText("CIN ");
        cin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cinFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cinFocusLost(evt);
            }
        });

        email1.setText("Email");
        email1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                email1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                email1FocusLost(evt);
            }
        });

        password.setText("Mot de pass");
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFocusLost(evt);
            }
        });

        rechercher.setText("Rechercher");
        rechercher.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rechercherFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rechercherFocusLost(evt);
            }
        });

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "cin", "Nom Complet", "Email", "Telephone", "user name"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(cin, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(email1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mise, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(68, 68, 68)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked

        if (table1.getSelectedRow() >= 0) {
            supprimer.setVisible(true);
            modifier.setVisible(true);
        }
    }//GEN-LAST:event_table1MouseClicked

    private void miseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miseActionPerformed

        try {
            new Admin.mise_à_jour().show();
            bd.getcurrentuser(Authentification.usercurrent,Admin.mise_à_jour.nom,Admin.mise_à_jour.email, Admin.mise_à_jour.tel,Admin.mise_à_jour.password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) { 
        }
    }//GEN-LAST:event_miseActionPerformed

    private void AjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterActionPerformed
        DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        if (cin.getText().equals("") || cin.getText().equals("CIN ")) {
            JOptionPane.showMessageDialog(null, "CIN !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        } else if (nom.getText().equals("") || nom.getText().equals("Nom complet")) {
            JOptionPane.showMessageDialog(null, "Le Nom !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        } else if (email1.getText().equals("") || email1.getText().equals("Email")) {
            JOptionPane.showMessageDialog(null, "Email !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        } else if (tel.getText().equals("") || tel.getText().equals("Télephone")) {
            JOptionPane.showMessageDialog(null, "Télephone !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        } else if (password.getText().equals("") || password.getText().equals("Mot de pass")) {
            JOptionPane.showMessageDialog(null, "Mot de pass !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                bd = new BD_admin("localhost", 3306, "Gestion_Stages", "root", "");
                if (!(email1.getText().contains("@gmail.com"))) {
                    JOptionPane.showMessageDialog(null, "Entrer valid Email !",
                            "", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    CIN = bd.getCIN();
                    for (int i = 0; i < CIN.size(); i++) {
                        if (cin.getText().equals(CIN.get(i))) {
                            JOptionPane.showMessageDialog(null, "CIN déja existe!",
                                    "", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    admin compte = new admin(cin.getText(), nom.getText(), email1.getText(),tel.getText(), password.getText());
                    bd.Ajouter_Admin(compte);
                    table1.addRow(new Object[]{cin.getText(), nom.getText(), email1.getText(),tel.getText(), compte.getNom_utilisateur()});
                    historique histo = new historique("Ajouter Admin", date);
                    currentuser = bd.getcurrentAdmin(Authentification.usercurrent);
                    BD.inserthistorique(histo.getId(), currentuser.split("_")[0], histo);

                    nom.setText("Nom complet");
                    tel.setText("Télephone");
                    cin.setText("CIN ");
                    email1.setText("Email");
                    password.setText("Mot de pass");
                }
            } catch (ClassNotFoundException ex) {
            } catch (SQLException ex) {
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_AjouterActionPerformed

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
        try{
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
               currentuser = bd.getcurrentAdmin(Authentification.usercurrent);
        int indexrow = table1.getSelectedRow();
        cinselected = model.getValueAt(indexrow, 0).toString();
        String pass=null;
        
        if (indexrow < 0){
            JOptionPane.showMessageDialog(null, "Vueillez de selectionner un compte !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        }else{
            if(!(currentuser.split("_")[0].equals("p1520"))  && cinselected.equals("p1520") ){
            JOptionPane.showMessageDialog(null, " Modification de l'admin impossible !",
                    "", JOptionPane.INFORMATION_MESSAGE);
            }else{
            new modifier_admin().show();
            pass = bd.getpassword(model.getValueAt(indexrow, 0).toString());
            modifier_admin.password.setText(pass);
            cinselected = model.getValueAt(indexrow, 0).toString();
            modifier_admin.nom.setText(model.getValueAt(indexrow, 1).toString());
            modifier_admin.email.setText(model.getValueAt(indexrow, 2).toString());
            modifier_admin.tel.setText(model.getValueAt(indexrow, 3).toString());
            }
            }
           }catch (Exception ex){ 
           }
    }//GEN-LAST:event_modifierActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        
                  try {int indexrow = table1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        if (indexrow < 0) {
            JOptionPane.showMessageDialog(null, "Vueillez de selectionner un compte !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        } else {
              if(model.getValueAt(indexrow, 0).toString().equals("p1520")  ){
                    JOptionPane.showMessageDialog(null, "Vous etes Admin !",
                    "", JOptionPane.WARNING_MESSAGE);
              }else{
               new message_supprimer().show();
              }
        }   
             }  catch (Exception ex) { 
            }
    }//GEN-LAST:event_supprimerActionPerformed

    private void cinFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cinFocusGained
    if (cin.getText().equals("CIN ")) {
            cin.setText("");
        }
    }//GEN-LAST:event_cinFocusGained

    private void cinFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cinFocusLost
          if (cin.getText().equals("")) {
            cin.setText("CIN ");
        }
    }//GEN-LAST:event_cinFocusLost

    private void nomFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomFocusGained
   if (nom.getText().equals("Nom complet")) {
            nom.setText("");
        }      
    }//GEN-LAST:event_nomFocusGained

    private void nomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomFocusLost
          if (nom.getText().equals("")) {
            nom.setText("Nom complet");
          }
    }//GEN-LAST:event_nomFocusLost

    private void emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusGained
         
    }//GEN-LAST:event_emailFocusGained

    private void emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusLost
        
    }//GEN-LAST:event_emailFocusLost

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void rechercherFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rechercherFocusGained
            if (rechercher.getText().equals("Rechercher")) {
            rechercher.setText("");
        }   
    }//GEN-LAST:event_rechercherFocusGained

    private void rechercherFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rechercherFocusLost
         if (rechercher.getText().equals("")) {
            rechercher.setText("Rechercher");
        }   
    }//GEN-LAST:event_rechercherFocusLost

    private void rechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechercherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rechercherActionPerformed

    private void passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusGained
         if (password.getText().equals("Mot de pass")) {
            password.setText("");
        }
    }//GEN-LAST:event_passwordFocusGained

    private void passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusLost
     if (password.getText().equals("")) {
            password.setText("Mot de pass");
        }
    }//GEN-LAST:event_passwordFocusLost

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void telFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telFocusGained
        if (tel.getText().equals("Télephone")) {
            tel.setText("");
        }
    }//GEN-LAST:event_telFocusGained

    private void telFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telFocusLost
        if (tel.getText().equals("")) {
            tel.setText("Télephone");
        }
    }//GEN-LAST:event_telFocusLost

    private void telActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telActionPerformed

    private void email1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email1FocusGained
        if (email1.getText().equals("Email")) {
            email1.setText("");
        }
    }//GEN-LAST:event_email1FocusGained

    private void email1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email1FocusLost
         if (email1.getText().equals("")) {
            email1.setText("Email");
        }
    }//GEN-LAST:event_email1FocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton Ajouter;
    private javaswingdev.swing.rounde cin;
    private javaswingdev.swing.rounde email1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private com.k33ptoo.components.KButton mise;
    private com.k33ptoo.components.KButton modifier;
    private javaswingdev.swing.rounde nom;
    private javaswingdev.swing.rounde password;
    private javaswingdev.swing.rounde rechercher;
    private javaswingdev.swing.RoundPanel roundPanel1;
    private com.k33ptoo.components.KButton supprimer;
    public static javaswingdev.swing.table.Table table1;
    private javaswingdev.swing.rounde tel;
    // End of variables declaration//GEN-END:variables

}
