
package forms;

import Abscence.BD_Abscence;
import Abscence.abscence;
import Abscence.message_supprimer_abscence;
import Abscence.modifier_abscence;
import Admin.BD_admin;

import historique.BD_historique;
import historique.historique;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import static forms.gestion_admin.table1;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class gestion_abscence extends javax.swing.JPanel {

    String currentuser = null;
    abscence abcent;
    BD_Abscence bd;
    BD_admin BD;
    BD_historique Bd;
    Date date;
    DefaultTableModel model;
    public static int idselected=0;
    public gestion_abscence() throws Exception {
        initComponents();
        bd = new BD_Abscence("localhost", 3306, "Gestion_Stages", "root", "");
        BD = new BD_admin("localhost", 3306, "Gestion_Stages", "root", "");
        Bd = new BD_historique("localhost", 3306, "Gestion_Stages", "root", "");
        table1.fixTable(jScrollPane2);
        bd.getCIN_Nom(box);
        bd.getAbscences(table1);
        date = new Date();
        debut.setDate(date);
        fin.setDate(date);
        modifier.setVisible(false);
        supprimer.setVisible(false);
   currentuser = BD.getcurrentAdmin(Authentification.usercurrent);
   //jLabel3.setText(currentuser.split("_")[0]+"//"+currentuser.split("_")[1]);
        DocumentListener dl;
        dl = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                model = (DefaultTableModel) table1.getModel();
                if (!(rechercher.getText().equals("Rechercher"))) {
                    try {
                        if(rechercher.getText().isEmpty() == false) {
                            table1.removeall(table1);
                            bd.rechercher(rechercher.getText(), table1);
                        }else{
                            table1.removeall(table1);
                            bd.getAbscences(table1);
                        }
                    }catch(SQLException ex){
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
                            bd.getAbscences(table1);
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
        //
       

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        box = new javax.swing.JComboBox<>();
        debut = new com.toedter.calendar.JDateChooser();
        fin = new com.toedter.calendar.JDateChooser();
        Ajouter = new com.k33ptoo.components.KButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        supprimer = new com.k33ptoo.components.KButton();
        modifier = new com.k33ptoo.components.KButton();
        cause = new javaswingdev.swing.rounde();
        rechercher = new javaswingdev.swing.rounde();
        roundPanel1 = new javaswingdev.swing.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javaswingdev.swing.table.Table();

        jPanel1.setPreferredSize(new java.awt.Dimension(1297, 722));

        box.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        box.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(204, 204, 204)));
        box.setOpaque(false);

        debut.setDateFormatString("yyyy-MM-dd");
        debut.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        fin.setDateFormatString("yyyy-MM-dd");
        fin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Date début");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Date Fin");

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

        cause.setText("Cause");
        cause.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                causeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                causeFocusLost(evt);
            }
        });
        cause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                causeActionPerformed(evt);
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
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CIN", "NOM", "DATE_DEBUT", "DATE_FIN", " JOURS", "CAUSE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.getTableHeader().setReorderingAllowed(false);
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1185, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cause, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                                .addGap(119, 119, 119)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fin, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(debut, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(345, 345, 345)
                                .addComponent(Ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(debut, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fin, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cause, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                        .addGap(3, 3, 3)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(Ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)))
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1293, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterActionPerformed
        String cin = box.getSelectedItem().toString().split(" ")[0];
        String nom = box.getSelectedItem().toString().split(" ")[1];
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String date1 = dateFormat.format(debut.getDate());
        String date2 = dateFormat.format(fin.getDate());
        int nbr_jour = this.nbrjour(date1, date2);
        if (cause.getText().equals("") || cause.getText().equals("Cause")) {
            JOptionPane.showMessageDialog(null, "Cause !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try{
                if(fin.getDate().before(debut.getDate())){
                    JOptionPane.showMessageDialog(null, "La date début doit inférieure de la date fin !",
                            "", JOptionPane.INFORMATION_MESSAGE);
                } else{
                    abcent = new abscence(cause.getText(), nbr_jour);
                    bd.Ajouter_abscence(cin, date1, date2, nbr_jour, abcent);
                    table1.addRow(new Object[]{cin, nom, date1, date2, nbr_jour, abcent.getCause()});
                    historique histo = new historique("Ajouter Abscence", date);
                    currentuser = BD.getcurrentAdmin(Authentification.usercurrent);
                    Bd.inserthistorique(histo.getId(),currentuser.split("_")[0],histo);
                    cause.setText("Cause");
                    debut.setDate(date);
                    fin.setDate(date);
                }
            } catch (ClassNotFoundException ex) {
            } catch (SQLException ex) {
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_AjouterActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed

        int indexrow = table1.getSelectedRow();
        if (indexrow < 0) {
            JOptionPane.showMessageDialog(null, "Vuiellez de selectionner une ligne !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        }else{
            try{
                new message_supprimer_abscence().show();
            }catch(Exception ex){
            }
        }

    }//GEN-LAST:event_supprimerActionPerformed

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
      int indexrow=table1.getSelectedRow();
        if(indexrow < 0){
            JOptionPane.showMessageDialog(null, "Vuiellez de selectionner une ligne !",
            "", JOptionPane.INFORMATION_MESSAGE);
        }else{
            try{
                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                new modifier_abscence().show();
                modifier_abscence.cin.setText(model.getValueAt(indexrow, 0).toString());
                modifier_abscence.nom.setText(model.getValueAt(indexrow, 1).toString());
                modifier_abscence.cause.setText(model.getValueAt(indexrow, 5).toString());
                java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(indexrow, 2).toString());
                modifier_abscence.debut.setDate(date2);
                java.util.Date date3 = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(indexrow, 3).toString());
                modifier_abscence.fin.setDate(date3);
                idselected=bd.getid(model.getValueAt(indexrow, 0).toString(),model.getValueAt(indexrow, 2).toString(),model.getValueAt(indexrow, 3).toString(),model.getValueAt(indexrow, 4).toString(),model.getValueAt(indexrow, 5).toString());
            }catch(Exception ex){
            }
        }
    }//GEN-LAST:event_modifierActionPerformed

    private void causeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_causeFocusGained
            if (cause.getText().equals("Cause")) {
            cause.setText("");
        }
    }//GEN-LAST:event_causeFocusGained

    private void causeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_causeFocusLost
         if (cause.getText().equals("")) {
            cause.setText("Cause");
        }
    }//GEN-LAST:event_causeFocusLost

    private void rechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechercherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rechercherActionPerformed

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

    private void causeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_causeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_causeActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        if (table1.getSelectedRow() >= 0) {
            modifier.setVisible(true);
            supprimer.setVisible(true);
        }
    }//GEN-LAST:event_table1MouseClicked
    private int nbrjour(String date1, String date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int res = 0;
        try {
            /*Date dateAvant = sdf.parse(date1);
            Date dateApres = sdf.parse(date2);
            int diff = (int) (dateApres.getTime() - dateAvant.getTime());
            res = (diff / (1000 * 60 * 60 * 24));*/
             DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd");
              LocalDate d1=LocalDate.parse(date1,format);
              LocalDate d2=LocalDate.parse(date2,format);
             Period period=Period.between(d1,d2);
            res=period.getDays();
        }catch(Exception e) {
        }
        return res;
    }
  
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton Ajouter;
    private javax.swing.JComboBox<String> box;
    private javaswingdev.swing.rounde cause;
    private com.toedter.calendar.JDateChooser debut;
    private com.toedter.calendar.JDateChooser fin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.k33ptoo.components.KButton modifier;
    private javaswingdev.swing.rounde rechercher;
    private javaswingdev.swing.RoundPanel roundPanel1;
    private com.k33ptoo.components.KButton supprimer;
    public static javaswingdev.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
