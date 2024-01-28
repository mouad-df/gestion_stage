
package Stagiaire;

import Abscence.BD_Abscence;
import Admin.*;
import Stage.BD_Stage;
import historique.BD_historique;
import historique.historique;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import forms.Authentification;
import forms.gestion_admin;
import static forms.gestion_admin.cinselected;
import static forms.gestion_admin.table1;
import forms.gestion_stagiaire;
import javaswingdev.swing.table.Table;
import javax.swing.table.DefaultTableModel;


public class message_supprimer_stagiaire extends javax.swing.JFrame {

    BD_stagiaire bd;
    BD_admin Bd;
    BD_Abscence bD;
    BD_historique BD;
    BD_Stage  bd_Stage;
    String currentuser;
    int indexrow;
    String cinselected;
    DefaultTableModel model;

    public message_supprimer_stagiaire() throws Exception {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        bd = new BD_stagiaire("localhost", 3306, "Gestion_Stages", "root", "");
         bD = new BD_Abscence("localhost", 3306, "Gestion_Stages", "root", "");
          Bd = new BD_admin("localhost", 3306, "Gestion_Stages", "root", "");
           BD = new BD_historique("localhost", 3306, "Gestion_Stages", "root", "");
           bd_Stage=new BD_Stage("localhost", 3306, "Gestion_Stages", "root", "");
        indexrow = gestion_stagiaire.table2.getSelectedRow();
        model = (DefaultTableModel) gestion_stagiaire.table2.getModel();
        cinselected = model.getValueAt(indexrow, 0).toString();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fermer = new com.k33ptoo.components.KButton();
        fermer1 = new com.k33ptoo.components.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Voulez-vous vraiment supprimer cette stagiaire");

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

        fermer1.setForeground(new java.awt.Color(0, 0, 0));
        fermer1.setText("Supprimer");
        fermer1.setBorderPainted(false);
        fermer1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        fermer1.setkAllowTab(true);
        fermer1.setkBackGroundColor(new java.awt.Color(143, 148, 251));
        fermer1.setkBorderRadius(50);
        fermer1.setkEndColor(new java.awt.Color(143, 148, 251));
        fermer1.setkForeGround(new java.awt.Color(0, 0, 0));
        fermer1.setkHoverColor(new java.awt.Color(143, 148, 251));
        fermer1.setkHoverEndColor(new java.awt.Color(143, 148, 251));
        fermer1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        fermer1.setkHoverStartColor(new java.awt.Color(143, 148, 251));
        fermer1.setkIndicatorColor(new java.awt.Color(143, 148, 251));
        fermer1.setkPressedColor(new java.awt.Color(143, 148, 251));
        fermer1.setkSelectedColor(new java.awt.Color(143, 148, 251));
        fermer1.setkStartColor(new java.awt.Color(143, 148, 251));
        fermer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fermer1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(fermer1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fermer, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fermer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fermer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addGap(30, 30, 30))
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

    private void fermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fermerActionPerformed
        this.hide();
       
    }//GEN-LAST:event_fermerActionPerformed

    private void fermer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fermer1ActionPerformed
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            bd.supprimerstagiaire(cinselected);
            bD.supprimer_abscence_stagiaire(cinselected);
            bd.supprimerstage(cinselected);
            this.hide();
            model.removeRow(indexrow);
            historique histo = new historique("Supprimer stagiaire", date);
            currentuser = Bd.getcurrentAdmin(Authentification.usercurrent);
            BD.inserthistorique(histo.getId(), currentuser.split("_")[0], histo);
        }catch(SQLException ex){
        }
    }//GEN-LAST:event_fermer1ActionPerformed

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
            java.util.logging.Logger.getLogger(message_supprimer_stagiaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(message_supprimer_stagiaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(message_supprimer_stagiaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(message_supprimer_stagiaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new message_supprimer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton fermer;
    private com.k33ptoo.components.KButton fermer1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
