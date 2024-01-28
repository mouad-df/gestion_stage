
package Stagiaire;

import Admin.BD_admin;
import historique.BD_historique;
import historique.historique;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import forms.Authentification;
import forms.gestion_stagiaire;
import javax.swing.JOptionPane;

public class modifier_stagiaire extends javax.swing.JFrame {

    BD_stagiaire bd;
    BD_admin Bd;
    BD_historique BD;
String currentuser;
    public modifier_stagiaire() throws Exception {
        initComponents();
        this.setFocusable(true);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
         bd = new BD_stagiaire("localhost", 3306, "Gestion_Stages", "root", "");
         Bd = new BD_admin("localhost", 3306, "Gestion_Stages", "root", "");
         BD = new BD_historique("localhost", 3306, "Gestion_Stages", "root", "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        enregistrer = new com.k33ptoo.components.KButton();
        supprimer1 = new com.k33ptoo.components.KButton();
        nom = new javaswingdev.swing.rounde();
        tel = new javaswingdev.swing.rounde();
        email1 = new javaswingdev.swing.rounde();
        adresse = new javaswingdev.swing.rounde();
        etab1 = new javaswingdev.swing.rounde();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        enregistrer.setForeground(new java.awt.Color(0, 0, 0));
        enregistrer.setText("Enregister");
        enregistrer.setBorderPainted(false);
        enregistrer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enregistrer.setkAllowTab(true);
        enregistrer.setkBackGroundColor(new java.awt.Color(143, 148, 251));
        enregistrer.setkBorderRadius(50);
        enregistrer.setkEndColor(new java.awt.Color(143, 148, 251));
        enregistrer.setkForeGround(new java.awt.Color(0, 0, 0));
        enregistrer.setkHoverColor(new java.awt.Color(143, 148, 251));
        enregistrer.setkHoverEndColor(new java.awt.Color(143, 148, 251));
        enregistrer.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        enregistrer.setkHoverStartColor(new java.awt.Color(143, 148, 251));
        enregistrer.setkIndicatorColor(new java.awt.Color(143, 148, 251));
        enregistrer.setkPressedColor(new java.awt.Color(143, 148, 251));
        enregistrer.setkSelectedColor(new java.awt.Color(143, 148, 251));
        enregistrer.setkStartColor(new java.awt.Color(143, 148, 251));
        enregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enregistrerActionPerformed(evt);
            }
        });

        supprimer1.setForeground(new java.awt.Color(0, 0, 0));
        supprimer1.setText("Fermer");
        supprimer1.setBorderPainted(false);
        supprimer1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        supprimer1.setkAllowTab(true);
        supprimer1.setkBackGroundColor(new java.awt.Color(143, 148, 251));
        supprimer1.setkBorderRadius(50);
        supprimer1.setkEndColor(new java.awt.Color(143, 148, 251));
        supprimer1.setkForeGround(new java.awt.Color(0, 0, 0));
        supprimer1.setkHoverColor(new java.awt.Color(143, 148, 251));
        supprimer1.setkHoverEndColor(new java.awt.Color(143, 148, 251));
        supprimer1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        supprimer1.setkHoverStartColor(new java.awt.Color(143, 148, 251));
        supprimer1.setkIndicatorColor(new java.awt.Color(143, 148, 251));
        supprimer1.setkPressedColor(new java.awt.Color(143, 148, 251));
        supprimer1.setkSelectedColor(new java.awt.Color(143, 148, 251));
        supprimer1.setkStartColor(new java.awt.Color(143, 148, 251));
        supprimer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimer1ActionPerformed(evt);
            }
        });

        nom.setText("Nom Complet");
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
        tel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telActionPerformed(evt);
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
        email1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email1ActionPerformed(evt);
            }
        });

        adresse.setText("Adresse");
        adresse.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                adresseFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                adresseFocusLost(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(email1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nom, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(supprimer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(enregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(etab1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))))
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(adresse, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(tel, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etab1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(adresse, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supprimer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enregistrerActionPerformed
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        if (nom.getText().equals("") || nom.getText().equals("Nom complet")) {
            JOptionPane.showMessageDialog(null, "Le Nom !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        } else if (email1.getText().equals("") || email1.getText().equals("Email")) {
            JOptionPane.showMessageDialog(null, "Email !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        } else if (tel.getText().equals("") || tel.getText().equals("Télephone")) {
            JOptionPane.showMessageDialog(null, "Télephone !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        } else if (adresse.getText().equals("") || adresse.getText().equals("Adresse")) {
            JOptionPane.showMessageDialog(null, "Adresse !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        } else if (etab1.getText().equals("") || etab1.getText().equals("Etablissement")) {
            JOptionPane.showMessageDialog(null, "Etablissement !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                bd = new BD_stagiaire("localhost", 3306, "Gestion_Stages", "root", "");
                if (!(email1.getText().contains("@gmail.com"))) {
                    JOptionPane.showMessageDialog(null, "Entrer valid Email !",
                            "", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    bd.modifier_stagiaire(gestion_stagiaire.cinselected1, nom.getText(), email1.getText(), tel.getText(), adresse.getText(), etab1.getText());
                    gestion_stagiaire.table2.removeall(gestion_stagiaire.table2);
                    bd.getStagiaire(gestion_stagiaire.table2);
                    historique histo = new historique("Modifier Stagiaire", date);
                    currentuser = Bd.getcurrentAdmin(Authentification.usercurrent);
                    BD.inserthistorique(histo.getId(), currentuser.split("_")[0], histo);
                    this.hide();

                    /*nom.setText("Nom complet");
                    tel.setText("Télephone");
                    cin1.setText("CIN ");
                    email.setText("Email");
                    password.setText("Mot de pass");*/
                }
            } catch (ClassNotFoundException ex) {
            } catch (SQLException ex) {
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_enregistrerActionPerformed

    private void supprimer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimer1ActionPerformed
        this.hide();
    }//GEN-LAST:event_supprimer1ActionPerformed

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

    private void adresseFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adresseFocusGained
        if(adresse.getText().equals("Adresse")) {
            adresse.setText("");
        }
    }//GEN-LAST:event_adresseFocusGained

    private void adresseFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adresseFocusLost
        if (adresse.getText().equals("")) {
            adresse.setText("Adresse");
        }
    }//GEN-LAST:event_adresseFocusLost

    private void etab1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_etabFocusGained
         if (etab1.getText().equals("Etablissement")) {
            etab1.setText("");
        }
    }//GEN-LAST:event_etabFocusGained

    private void etab1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_etabFocusLost
          if (etab1.getText().equals("")) {
            etab1.setText("Etablissement");
        }
    }//GEN-LAST:event_etabFocusLost

    private void nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomActionPerformed

    private void telActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telActionPerformed

    private void emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email5FocusGained
        if(email1.getText().equals("Email")){
            email1.setText("");
        }
    }//GEN-LAST:event_email5FocusGained

    private void emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email5FocusLost
        if(email1.getText().equals("")) {
            email1.setText("Email");
        }
    }//GEN-LAST:event_email5FocusLost

    private void email1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_email1ActionPerformed

    private void etabFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_etab1FocusGained
        if(etab1.getText().equals("Etablissement")) {
            etab1.setText("");
        }
    }//GEN-LAST:event_etab1FocusGained

    private void etabFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_etab1FocusLost
        if(etab1.getText().equals("")) {
            etab1.setText("Etablissement");
        }
    }//GEN-LAST:event_etab1FocusLost

    private void email1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email1FocusGained
      if(email1.getText().equals("Email")) {
            email1.setText("");
        }
    }//GEN-LAST:event_email1FocusGained

    private void email1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email1FocusLost
if(email1.getText().equals("")) {
            email1.setText("Email");
        }
    }//GEN-LAST:event_email1FocusLost

    /*public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(modifier_stagiaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modifier_stagiaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modifier_stagiaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modifier_stagiaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new modifier_stagiaire().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javaswingdev.swing.rounde adresse;
    public static javaswingdev.swing.rounde email1;
    private com.k33ptoo.components.KButton enregistrer;
    public static javaswingdev.swing.rounde etab1;
    private javax.swing.JPanel jPanel1;
    public static javaswingdev.swing.rounde nom;
    private com.k33ptoo.components.KButton supprimer1;
    public static javaswingdev.swing.rounde tel;
    // End of variables declaration//GEN-END:variables
}
