package forms;

import Admin.BD_admin;
import Stagiaire.BD_stagiaire;
import Stagiaire.message_supprimer_stagiaire;
import historique.BD_historique;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static forms.gestion_admin.table1;
import static forms.gestion_stagiaire.table1;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class gestion_historique extends javax.swing.JPanel {

    DefaultTableModel model;
    BD_historique Bd;
    BD_stagiaire BD;
    BD_admin bd;
    String currentuser = null;
    Date date;

    public gestion_historique() throws Exception, SQLException {
        initComponents();
        date = new Date();
        model = (DefaultTableModel) gestion_historique.table1.getModel();
        Bd = new BD_historique("localhost", 3306, "Gestion_Stages", "root", "");
        BD = new BD_stagiaire("localhost", 3306, "Gestion_Stages", "root", "");
        bd = new BD_admin("localhost", 3306, "Gestion_Stages", "root", "");
        table1.fixTable(jScrollPane1);
        jDateChooser1.setDate(date);
        jDateChooser2.setDate(date);
        currentuser = bd.getcurrentAdmin(Authentification.usercurrent);
        //
        if (Authentification.usercurrent.equals("p1520") || Authentification.usercurrent.equals("Younes Berrada .j6s")) {
            Bd.getAllhistoriques(table1);
        } else {
            Bd.gethistoriques(currentuser.split("_")[0], table1);
        }
        //
        DocumentListener dl;
        dl = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                model = (DefaultTableModel) table1.getModel();
                if (!(rechercher.getText().equals("Rechercher"))) {
                    try {
                        if (rechercher.getText().isEmpty() == false) {
                            if (Authentification.usercurrent.equals("p1520") || Authentification.usercurrent.equals("Younes Berrada .j6s")) {
                                table1.removeall(table1);
                                Bd.rechercher_user_admin(rechercher.getText(), table1);
                            } else {
                                table1.removeall(table1);
                                Bd.rechercher(currentuser.split("_")[0], rechercher.getText(), table1);
                            }

                        } else {
                            if (Authentification.usercurrent.equals("p1520") || Authentification.usercurrent.equals("Younes Berrada .j6s")) {
                                table1.removeall(table1);
                                Bd.getAllhistoriques(table1);
                            } else {
                                table1.removeall(table1);
                                Bd.gethistoriques(currentuser.split("_")[0], table1);
                            }
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
                            if (Authentification.usercurrent.equals("p1520") || Authentification.usercurrent.equals("Younes Berrada .j6s")) {
                                table1.removeall(table1);
                                Bd.rechercher_user_admin(rechercher.getText(), table1);
                            } else {
                                table1.removeall(table1);
                                Bd.rechercher(currentuser.split("_")[0], rechercher.getText(), table1);
                            }
                        } else {
                            if (Authentification.usercurrent.equals("p1520") || Authentification.usercurrent.equals("Younes Berrada .j6s")) {
                                table1.removeall(table1);
                                Bd.getAllhistoriques(table1);
                            } else {
                                table1.removeall(table1);
                                Bd.gethistoriques(currentuser.split("_")[0], table1);
                            }
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
        jDateChooser1.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if (e.getPropertyName().equals("date")) {
                    model = (DefaultTableModel) table1.getModel();
                    SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
                    String date1 = Date_Format.format(jDateChooser1.getDate());
                    String date2 = Date_Format.format(jDateChooser2.getDate());
                    try {
                        int response = JOptionPane.showConfirmDialog(null, "La liste des Historique entre "+date1+" et"+date2, "", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if (response == JOptionPane.YES_OPTION) {
                            gestion_historique.table1.removeall(gestion_historique.table1);
                            if (currentuser.split("_")[0].equals("p1520") || currentuser.split("_")[1].equals("Younes Berrada .j6s")) {
                                Bd.rechercherparDate1(date1, date2, gestion_historique.table1);
                            } else {
                                Bd.rechercherparDate(currentuser.split("_")[0], date1, date2, gestion_historique.table1);
                            }
                        } else if (response == JOptionPane.NO_OPTION) {

                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        jDateChooser2.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if (e.getPropertyName().equals("date")) {
                    try {
                        model = (DefaultTableModel) table1.getModel();
                        SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
                        String date1 = Date_Format.format(jDateChooser1.getDate());
                        String date2 = Date_Format.format(jDateChooser2.getDate());

                        int response = JOptionPane.showConfirmDialog(null, "La liste des Historique entre "+date1+" et"+date2, "", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if (response == JOptionPane.YES_OPTION) {
                            gestion_historique.table1.removeall(gestion_historique.table1);
                            if (currentuser.split("_")[0].equals("p1520") || currentuser.split("_")[1].equals("Younes Berrada .j6s")) {
                                Bd.rechercherparDate1(date1, date2, gestion_historique.table1);
                            } else {
                                Bd.rechercherparDate(currentuser.split("_")[0], date1, date2, gestion_historique.table1);
                            }
                        } else if (response == JOptionPane.NO_OPTION) {

                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        supp_tout = new com.k33ptoo.components.KButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rechercher = new javaswingdev.swing.rounde();
        roundPanel1 = new javaswingdev.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javaswingdev.swing.table.Table();

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.setPreferredSize(new java.awt.Dimension(1297, 722));

        supp_tout.setForeground(new java.awt.Color(0, 0, 0));
        supp_tout.setText("Supprimer Tout");
        supp_tout.setBorderPainted(false);
        supp_tout.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        supp_tout.setkAllowTab(true);
        supp_tout.setkBackGroundColor(new java.awt.Color(143, 148, 251));
        supp_tout.setkBorderRadius(50);
        supp_tout.setkEndColor(new java.awt.Color(143, 148, 251));
        supp_tout.setkForeGround(new java.awt.Color(0, 0, 0));
        supp_tout.setkHoverColor(new java.awt.Color(143, 148, 251));
        supp_tout.setkHoverEndColor(new java.awt.Color(143, 148, 251));
        supp_tout.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        supp_tout.setkHoverStartColor(new java.awt.Color(143, 148, 251));
        supp_tout.setkIndicatorColor(new java.awt.Color(143, 148, 251));
        supp_tout.setkPressedColor(new java.awt.Color(143, 148, 251));
        supp_tout.setkSelectedColor(new java.awt.Color(143, 148, 251));
        supp_tout.setkStartColor(new java.awt.Color(143, 148, 251));
        supp_tout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supp_toutActionPerformed(evt);
            }
        });

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel2.setText("Filtrer entre deux Date");

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sync_64px.png"))); // NOI18N
        jLabel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
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
                "CIN", "USER NAME", "ACTION", "TEMP"
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addComponent(supp_tout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(287, 287, 287)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(supp_tout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)))
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1289, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked

    }//GEN-LAST:event_table1MouseClicked

    private void supp_toutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supp_toutActionPerformed

        try {
            table1.removeall(table1);
            if (Authentification.usercurrent.equals("p1520") || Authentification.usercurrent.equals("Younes Berrada .j6s")) {
                Bd.supprimertout();
            } else {
                Bd.supprimertoutcin(currentuser.split("_")[0]);
            }
            //
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_supp_toutActionPerformed

    private void jLabel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel1AncestorAdded

    }//GEN-LAST:event_jLabel1AncestorAdded

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

        try {
            table1.removeall(table1);
            if (Authentification.usercurrent.equals("p1520") || Authentification.usercurrent.equals("Younes Berrada .j6s")) {
                Bd.getAllhistoriques(table1);
            } else {
                Bd.gethistoriques(currentuser.split("_")[0], table1);
            }

        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_jLabel1MouseClicked

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private javaswingdev.swing.rounde rechercher;
    private javaswingdev.swing.RoundPanel roundPanel1;
    private com.k33ptoo.components.KButton supp_tout;
    public static javaswingdev.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
