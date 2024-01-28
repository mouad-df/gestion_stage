
package forms;
import Admin.BD_admin;
import Admin.message_supprimer;
import Admin.modifier_admin;
import static Admin.modifier_admin.password;
import Stagiaire.BD_stagiaire;
import Stagiaire.message_supprimer_stagiaire;
import Stagiaire.modifier_stagiaire;
import Stagiaire.stagiaire;
import historique.BD_historique;
import historique.historique;
import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import static forms.gestion_admin.cinselected;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;


public class gestion_stagiaire extends javax.swing.JPanel {
    String currentuser=null;
    BD_stagiaire bd;
    BD_admin BD;
    BD_historique Bd;
    ArrayList<String> CIN = new ArrayList<String>();
    String pass = null;
    public static String cinselected1 = null;
DefaultTableModel model;
    public gestion_stagiaire() throws Exception {
          initComponents();
          modifier.setVisible(false);
          supprimer.setVisible(false);
          bd = new BD_stagiaire("localhost", 3306, "Gestion_Stages", "root", "");
          BD = new BD_admin("localhost", 3306, "Gestion_Stages", "root", "");
          Bd = new BD_historique("localhost", 3306, "Gestion_Stages", "root", "");
          table2.fixTable(jScrollPane2);
          bd.getStagiaire(table2);
      
        DocumentListener dl;
        dl = new DocumentListener() {
            @Override
       public void insertUpdate(DocumentEvent e) {
               model = (DefaultTableModel)  table2.getModel();
                if ( !(rechercher1.getText().equals("Rechercher"))){
                    try {
                        if (rechercher1.getText().isEmpty() == false) {
                             //model.setNumRows(0);
                             table2.removeall(table2);
                            bd.rechercher(rechercher1.getText(), table2);
                        }else{
                            table2.removeall(table2);
                            bd.getStagiaire(table2);
                        }
                    } catch (SQLException ex) {
                    }
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
               model = (DefaultTableModel)  table2.getModel();
                if (!(rechercher1.getText().equals("Rechercher"))) {
                    try {
                        if (rechercher1.getText().isEmpty() == false ) {
                            table2.removeall(table2);
                            bd.rechercher(rechercher1.getText(), table2);  
                        }else{
                           table2.removeall(table2);
                            bd.getStagiaire(table2);
                        }
                    }catch (SQLException ex) {
                    }
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        };
        rechercher1.getDocument().addDocumentListener(dl);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jSeparator2 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        roundPanel1 = new javaswingdev.swing.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javaswingdev.swing.table.Table();
        email1 = new javaswingdev.swing.rounde();
        rechercher = new javaswingdev.swing.rounde();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        Ajouter = new com.k33ptoo.components.KButton();
        modifier = new com.k33ptoo.components.KButton();
        supprimer = new com.k33ptoo.components.KButton();
        roundPanel2 = new javaswingdev.swing.RoundPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table2 = new javaswingdev.swing.table.Table();
        cin = new javaswingdev.swing.rounde();
        nom = new javaswingdev.swing.rounde();
        tel = new javaswingdev.swing.rounde();
        email5 = new javaswingdev.swing.rounde();
        adresse = new javaswingdev.swing.rounde();
        etab1 = new javaswingdev.swing.rounde();
        rechercher1 = new javaswingdev.swing.rounde();

        jTextField1.setText("jTextField1");

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CIN", "NOM", "Email", "TELEPHONE", "ADRESSE", "ETABLISSEMENT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table1);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addContainerGap())
        );

        email1.setText("Email");
        email1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                email1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                email1FocusLost(evt);
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

        jSeparator1.setForeground(new java.awt.Color(204, 102, 255));

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

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel2.setRound(10);

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CIN", "NOM", "Email", "TELEPHONE", "ADRESSE", "ETABLISSEMENT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table2);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1132, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );

        cin.setText("CIN ");
        cin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cinFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cinFocusLost(evt);
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
        nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomActionPerformed(evt);
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

        email5.setText("Email");
        email5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                email5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                email5FocusLost(evt);
            }
        });

        adresse.setText("Adresse");
        adresse.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                adresseFocusGained(evt);
            }
        });

        etab1.setText("Etablissement");
        etab1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                etab1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                etab1FocusLost(evt);
            }
        });

        rechercher1.setText("Rechercher");
        rechercher1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rechercher1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rechercher1FocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rechercher1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(97, 97, 97))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cin, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(email5, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(adresse, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(etab1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tel, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(nom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adresse, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etab1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(59, 59, 59)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rechercher1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked

        if (table2.getSelectedRow() >= 0){
            supprimer.setVisible(true);
            modifier.setVisible(true);
        }
    }//GEN-LAST:event_table1MouseClicked

    private void AjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterActionPerformed
     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
     Date date = new Date();
        
        if (cin.getText().equals("") || cin.getText().equals("CIN ")) {
            JOptionPane.showMessageDialog(null, "CIN !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        } else if (nom.getText().equals("") || nom.getText().equals("Nom complet")) {
            JOptionPane.showMessageDialog(null, "Le Nom !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        } else if (email5.getText().equals("") || email5.getText().equals("Email")) {
            JOptionPane.showMessageDialog(null, "Email !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        } else if (adresse.getText().equals("") || adresse.getText().equals("Télephone")) {
            JOptionPane.showMessageDialog(null, "Télephone !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        }  else if (adresse.getText().equals("") || adresse.getText().equals("Adresse")) {
            JOptionPane.showMessageDialog(null, "Adresse !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        } else if (etab1.getText().equals("") || etab1.getText().equals("Etablissement")) {
            JOptionPane.showMessageDialog(null, "Adresse !",
                    "",JOptionPane.INFORMATION_MESSAGE);
        }else {
            try {
                bd = new BD_stagiaire("localhost", 3306, "Gestion_Stages", "root", "");
                if(!(email5.getText().contains("@gmail.com"))) {
                    JOptionPane.showMessageDialog(null, "Entrer valid Email !",
                            "", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    CIN=bd.getCIN();
                    for(int i = 0; i < CIN.size(); i++) {
                        if(cin.getText().equals(CIN.get(i))) {
                            JOptionPane.showMessageDialog(null, "CIN déja existe!",
                                    "", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                     stagiaire stag = new stagiaire(cin.getText(), nom.getText(),  adresse.getText(), email5.getText(), adresse.getText(),etab1.getText());
                     bd.Ajouter_Stagiaire(stag);
                     table2.addRow(new Object[]{cin.getText(), nom.getText(), email5.getText(), adresse.getText(), adresse.getText(),etab1.getText()});
                     historique histo =new historique("Ajouter Stagiaire",date);
                     currentuser=BD.getcurrentAdmin(Authentification.usercurrent);
                     Bd.inserthistorique(histo.getId(),currentuser.split("_")[0], histo);
                    nom.setText("Nom complet");
                   tel.setText("Télephone");
                    cin.setText("CIN ");
                    email5.setText("Email");
                    adresse.setText("Adresse");
                    etab1.setText("Etablissement");
                }
            } catch (ClassNotFoundException ex) {
            } catch (SQLException ex) {
            } catch (Exception ex) {
            }
        }       
    }//GEN-LAST:event_AjouterActionPerformed

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
      
        int indexrow = table2.getSelectedRow();
        if(indexrow<0){
        JOptionPane.showMessageDialog(null, "Vuiellez de selectionner une ligne !",
                                    "", JOptionPane.INFORMATION_MESSAGE);
        }else{
                        try {
        DefaultTableModel model = (DefaultTableModel) table2.getModel();
                new modifier_stagiaire().show(); 
        cinselected1 = model.getValueAt(indexrow, 0).toString();
        modifier_stagiaire.nom.setText(model.getValueAt(indexrow, 1).toString());
        modifier_stagiaire.email1.setText(model.getValueAt(indexrow, 2).toString());
        modifier_stagiaire.tel.setText(model.getValueAt(indexrow, 3).toString());
         modifier_stagiaire.adresse.setText(model.getValueAt(indexrow, 4).toString());
         modifier_stagiaire.etab1.setText(model.getValueAt(indexrow, 5).toString());
                            }catch(Exception ex){
            }}  
    }//GEN-LAST:event_modifierActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
           try{
            new message_supprimer_stagiaire().show();
        }catch (Exception ex) {
        }
    }//GEN-LAST:event_supprimerActionPerformed

    private void rechercherFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rechercherFocusGained
        if (rechercher1.getText().equals("Rechercher")) {
            rechercher1.setText("");
        }
    }//GEN-LAST:event_rechercherFocusGained

    private void rechercherFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rechercherFocusLost
        if (rechercher1.getText().equals("")) {
            rechercher1.setText("Rechercher");
        }
    }//GEN-LAST:event_rechercherFocusLost

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

    private void emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email2FocusGained
        if (email1.getText().equals("Email")) {
            email1.setText("");
        }
    }//GEN-LAST:event_email2FocusGained

    private void emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email2FocusLost
        if (email1.getText().equals("")) {
            email1.setText("Email");
        }
    }//GEN-LAST:event_email2FocusLost

    private void etabFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email3FocusGained
       
    }//GEN-LAST:event_email3FocusGained

    private void etabFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email3FocusLost
    
    }//GEN-LAST:event_email3FocusLost

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked

        if(table2.getSelectedRow() >= 0){
            supprimer.setVisible(true);
            modifier.setVisible(true);
        }
    }//GEN-LAST:event_table2MouseClicked

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

    private void email4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusGained
       
    }//GEN-LAST:event_emailFocusGained

    private void email5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email5FocusGained
         if(email5.getText().equals("Email")){
            email5.setText("");
        }
    }//GEN-LAST:event_email5FocusGained

    private void email5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email5FocusLost
      if(email5.getText().equals("")) {
            email5.setText("Email");
        }
    }//GEN-LAST:event_email5FocusLost

    private void adresseFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adresseFocusGained
       if(adresse.getText().equals("Adresse")) {
            adresse.setText("");
        }
    }//GEN-LAST:event_adresseFocusGained

    private void etab1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_etab1FocusGained
      if(etab1.getText().equals("Etablissement")) {
            etab1.setText("");
        }
    }//GEN-LAST:event_etab1FocusGained

    private void etab1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_etab1FocusLost
 if(etab1.getText().equals("")) {
            etab1.setText("Etablissement");
        }
    }//GEN-LAST:event_etab1FocusLost

    private void rechercher1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rechercher1FocusGained
        if(rechercher1.getText().equals("Rechercher")) {
            rechercher1.setText("");
        }
    }//GEN-LAST:event_rechercher1FocusGained

    private void rechercher1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rechercher1FocusLost
        if(rechercher1.getText().equals("")) {
            rechercher1.setText("Rechercher");
        }
    }//GEN-LAST:event_rechercher1FocusLost

    private void nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton Ajouter;
    private javaswingdev.swing.rounde adresse;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javaswingdev.swing.rounde cin;
    private javaswingdev.swing.rounde email1;
    private javaswingdev.swing.rounde email5;
    private javaswingdev.swing.rounde etab1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private com.k33ptoo.components.KButton modifier;
    private javaswingdev.swing.rounde nom;
    private javaswingdev.swing.rounde rechercher;
    private javaswingdev.swing.rounde rechercher1;
    private javaswingdev.swing.RoundPanel roundPanel1;
    private javaswingdev.swing.RoundPanel roundPanel2;
    private com.k33ptoo.components.KButton supprimer;
    public static javaswingdev.swing.table.Table table1;
    public static javaswingdev.swing.table.Table table2;
    private javaswingdev.swing.rounde tel;
    // End of variables declaration//GEN-END:variables
}
