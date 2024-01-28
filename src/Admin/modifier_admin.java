
package Admin;

import Stagiaire.BD_stagiaire;
import historique.BD_historique;
import historique.historique;
import java.awt.Dimension;
import java.awt.Toolkit;
import static java.nio.file.Files.size;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import forms.Authentification;
import forms.gestion_admin;

import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class modifier_admin extends javax.swing.JFrame {

    BD_stagiaire bd;
    BD_admin Bd;
    BD_historique BD;

    String currentuser;
    ArrayList<String> CIN = new ArrayList<String>();

    public modifier_admin() throws Exception {
        initComponents();
        this.setFocusable(true);
        Bd = new BD_admin("localhost", 3306, "Gestion_Stages", "root", "");
        bd = new BD_stagiaire("localhost", 3306, "Gestion_Stages", "root", "");
        BD = new BD_historique("localhost", 3306, "Gestion_Stages", "root", "");
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
 setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        panel1 = new javax.swing.JPanel();
        fermer = new com.k33ptoo.components.KButton();
        enregistrer = new com.k33ptoo.components.KButton();
        nom = new javaswingdev.swing.rounde();
        password = new javaswingdev.swing.rounde();
        tel = new javaswingdev.swing.rounde();
        email = new javaswingdev.swing.rounde();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        fermer.setForeground(new java.awt.Color(0, 0, 0));
        fermer.setText("Fermer");
        fermer.setBorderPainted(false);
        fermer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        fermer.setkAllowTab(true);
        fermer.setkBackGroundColor(new java.awt.Color(143, 148, 251));
        fermer.setkBorderRadius(50);
        fermer.setkEndColor(new java.awt.Color(143, 148, 251));
        fermer.setkForeGround(new java.awt.Color(0, 0, 0));
        fermer.setkHoverColor(new java.awt.Color(143, 148, 251));
        fermer.setkHoverEndColor(new java.awt.Color(143, 148, 251));
        fermer.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        fermer.setkHoverStartColor(new java.awt.Color(143, 148, 251));
        fermer.setkIndicatorColor(new java.awt.Color(143, 148, 251));
        fermer.setkPressedColor(new java.awt.Color(143, 148, 251));
        fermer.setkSelectedColor(new java.awt.Color(143, 148, 251));
        fermer.setkStartColor(new java.awt.Color(143, 148, 251));
        fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fermerActionPerformed(evt);
            }
        });

        enregistrer.setForeground(new java.awt.Color(0, 0, 0));
        enregistrer.setText("Enregistrer");
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

        nom.setText("Nom complet");
        nom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nomFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nomFocusLost(evt);
            }
        });

        password.setText("Mot de pass");
        password.setToolTipText("");
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFocusLost(evt);
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

        email.setText("Email");
        email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFocusLost(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(fermer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(enregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nom, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(114, 114, 114)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fermer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomFocusGained
        if (nom.getText().equals("Nom complet")) {
            nom.setText("");
        }
    }//GEN-LAST:event_nomFocusGained

    private void nomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomFocusLost
        if(nom.getText().equals("")){
            nom.setText("Nom complet");
        }
    }//GEN-LAST:event_nomFocusLost

    private void emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusGained
        if (email.getText().equals("Email")) {
            email.setText("");
        }
    }//GEN-LAST:event_emailFocusGained

    private void emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusLost
        if (email.getText().equals("")) {
            email.setText("Email");
        }
    }//GEN-LAST:event_emailFocusLost

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

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

    private void fermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fermerActionPerformed
       this.hide();
    }//GEN-LAST:event_fermerActionPerformed

    private void enregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enregistrerActionPerformed
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        if (nom.getText().equals("") || nom.getText().equals("Nom complet")) {
            JOptionPane.showMessageDialog(null, "Le Nom !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        } else if (email.getText().equals("") || email.getText().equals("Email")) {
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

                if (!(email.getText().contains("@gmail.com"))) {
                    JOptionPane.showMessageDialog(null, "Entrer valid Email !",
                            "", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    Bd.modifier_Admin(gestion_admin.cinselected, nom.getText(), email.getText(), tel.getText(), password.getText());
                    gestion_admin.table1.removeall(gestion_admin.table1);
                    Bd.getAdmins(gestion_admin.table1);
                    historique histo = new historique("Modifier  utilisateur", date);
                    currentuser = Bd.getcurrentAdmin(Authentification.usercurrent);
                    BD.inserthistorique(histo.getId(), currentuser.split("_")[0], histo);
                    this.hide();
                }
            } catch (SQLException ex) {
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_enregistrerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(modifier_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modifier_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modifier_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modifier_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new modifier_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javaswingdev.swing.rounde email;
    private com.k33ptoo.components.KButton enregistrer;
    private com.k33ptoo.components.KButton fermer;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    public static javaswingdev.swing.rounde nom;
    private javax.swing.JPanel panel1;
    public static javaswingdev.swing.rounde password;
    public static javaswingdev.swing.rounde tel;
    // End of variables declaration//GEN-END:variables
}
