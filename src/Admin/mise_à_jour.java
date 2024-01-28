
package Admin;

import static Admin.modifier_admin.email;
import static Admin.modifier_admin.nom;
import static Admin.modifier_admin.password;
import static Admin.modifier_admin.tel;
import Stagiaire.BD_stagiaire;
import historique.BD_historique;
import historique.historique;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import forms.Authentification;
import forms.gestion_admin;
import javax.swing.JOptionPane;

import com.k33ptoo.components.KButton;

public class mise_à_jour extends javax.swing.JFrame {
BD_stagiaire bd;
    BD_admin Bd;
    BD_historique BD;

    String currentuser;
    public mise_à_jour() throws Exception {
        initComponents();
          Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        
        Bd = new BD_admin("localhost", 3306, "Gestion_Stages", "root", "");
        bd = new BD_stagiaire("localhost", 3306, "Gestion_Stages", "root", "");
         setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        BD = new BD_historique("localhost", 3306, "Gestion_Stages", "root", "");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        fermer = new com.k33ptoo.components.KButton();
        KButton mise_�_jour = new com.k33ptoo.components.KButton();
        nom = new javaswingdev.swing.rounde();
        tel = new javaswingdev.swing.rounde();
        password = new javaswingdev.swing.rounde();
        email = new javaswingdev.swing.rounde();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

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

        mise_�_jour.setForeground(new java.awt.Color(0, 0, 0));
        mise_à_jour.setText("Mise à jour");
        mise_à_jour.setBorderPainted(false);
        mise_à_jour.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mise_à_jour.setkAllowTab(true);
        mise_à_jour.setkBackGroundColor(new java.awt.Color(143, 148, 251));
        mise_à_jour.setkBorderRadius(50);
        mise_à_jour.setkEndColor(new java.awt.Color(143, 148, 251));
        mise_à_jour.setkForeGround(new java.awt.Color(0, 0, 0));
        mise_à_jour.setkHoverColor(new java.awt.Color(143, 148, 251));
        mise_à_jour.setkHoverEndColor(new java.awt.Color(143, 148, 251));
        mise_à_jour.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        mise_à_jour.setkHoverStartColor(new java.awt.Color(143, 148, 251));
        mise_à_jour.setkIndicatorColor(new java.awt.Color(143, 148, 251));
        mise_à_jour.setkPressedColor(new java.awt.Color(143, 148, 251));
        mise_à_jour.setkSelectedColor(new java.awt.Color(143, 148, 251));
        mise_à_jour.setkStartColor(new java.awt.Color(143, 148, 251));
        mise_à_jour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	mise_à_jourjourActionPerformed(evt);
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

        password.setText("Mot de pass");
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFocusLost(evt);
            }
        });

        email.setText("Email");
        email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(fermer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mise_à_jour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fermer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mise_�_jour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
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

    private void mise_à_jourjourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mise_à_jourActionPerformed
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
                    Bd.modifier_currentAdmin(Authentification.usercurrent, nom.getText(), email.getText(), tel.getText(), password.getText());
                    gestion_admin.table1.removeall(gestion_admin.table1);
                    Bd.getAdmins(gestion_admin.table1);
                    historique histo = new historique("Mise à jour  utilisateur", date);
                    currentuser = Bd.getcurrentAdmin(Authentification.usercurrent);
                    BD.inserthistorique(histo.getId(), currentuser.split("_")[0], histo);
                    this.hide();
                    /*nom.setText("Nom complet");
                    tel.setText("Télephone");
                    cin1.setText("CIN ");
                    email.setText("Email");
                    password.setText("Mot de pass");*/
                }
            } catch (SQLException ex) {
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_mise_à_jourActionPerformed

    private void emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email1FocusGained
if (email.getText().equals("Email")) {
            email.setText("");
        }
    }//GEN-LAST:event_email1FocusGained

    private void emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusLost
        if (email.getText().equals("")) {
            email.setText("Email");
        }
    }//GEN-LAST:event_emailFocusLost

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
            java.util.logging.Logger.getLogger(mise_à_jour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mise_à_jour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mise_à_jour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mise_à_jour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new mise_à_jour().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javaswingdev.swing.rounde email;
    private com.k33ptoo.components.KButton fermer;
    private javax.swing.JPanel jPanel1;
    private com.k33ptoo.components.KButton mise_�_jour;
    public static javaswingdev.swing.rounde nom;
    public static javaswingdev.swing.rounde password;
    public static javaswingdev.swing.rounde tel;
    // End of variables declaration//GEN-END:variables
}
