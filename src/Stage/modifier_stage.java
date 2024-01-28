package Stage;

import Admin.*;
import Stagiaire.BD_stagiaire;
import historique.BD_historique;
import historique.historique;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import static java.nio.file.Files.size;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import forms.Authentification;
import forms.gestion_abscence;
import forms.gestion_admin;
import forms.gestion_stage;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
public class   modifier_stage    extends javax.swing.JFrame{

    BD_stagiaire bd;
    BD_admin Bd;
    BD_historique BD;
    BD_Stage base;
    String currentuser;
    ArrayList<String> CIN = new ArrayList<String>();
int indexrow;
    public modifier_stage() throws Exception{
        initComponents();
        this.setFocusable(true);
        Bd = new BD_admin("localhost", 3306, "Gestion_Stages", "root", "");
        bd = new BD_stagiaire("localhost", 3306, "Gestion_Stages", "root", "");
        BD = new BD_historique("localhost", 3306, "Gestion_Stages", "root", "");
        base = new BD_Stage("localhost", 3306, "Gestion_Stages", "root", "");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        debut = new com.toedter.calendar.JDateChooser();
        fin = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        Box2 = new javax.swing.JComboBox<>();
        enregistrer = new com.k33ptoo.components.KButton();
        fermer = new com.k33ptoo.components.KButton();
        type1 = new javaswingdev.swing.rounde();
        projet1 = new javaswingdev.swing.rounde();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        text.setColumns(20);
        text.setRows(5);
        text.setText("Description de Stage");
        text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(text);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Type");

        debut.setDateFormatString("yyyy-MM-dd");

        fin.setDateFormatString("yyyy-MM-dd");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Date Fin");

        Box2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

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

        type1.setText("Type");
        type1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                type1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                type1FocusLost(evt);
            }
        });
        type1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type1ActionPerformed(evt);
            }
        });

        projet1.setText("Projet");
        projet1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                projet1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                projet1FocusLost(evt);
            }
        });
        projet1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projet1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Date début");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Projet");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Propriétaire");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 659, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(type1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(projet1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                                .addGap(49, 49, 49))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Box2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(debut, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fin, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
                        .addGap(46, 46, 46))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fermer, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(enregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(debut, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(type1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(projet1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(16, 16, 16)
                        .addComponent(Box2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fermer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFocusGained
        if (text.getText().equals("Description de Stage")) {
            text.setText("");
        }
    }//GEN-LAST:event_textFocusGained

    private void textFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFocusLost
        if (text.getText().equals("")) {
            text.setText("Description de Stage");
        }
    }//GEN-LAST:event_textFocusLost

    private void enregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enregistrerActionPerformed
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        String date1=dateFormat.format(debut.getDate());
        String date2=dateFormat.format(fin.getDate());
        int nbr_jour = this.nbrjour(date1, date2);
        if (type1.getText().equals("")  || type1.getText().equals("Type")){
            JOptionPane.showMessageDialog(null, " Type !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        } else if (projet1.getText().equals("")||projet1.getText().equals("Projet")){
            JOptionPane.showMessageDialog(null, "Projet !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        }  else if (date1.equals(date2)) {
            JOptionPane.showMessageDialog(null, "Viuellez de varie les dates!",
                    "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                base.modifier_Stage(Integer.parseInt(gestion_stage.idselected),type1.getText(),date1,date2,nbr_jour,projet1.getText(),text.getText());
                gestion_stage.table1.removeall(gestion_stage.table1);
                base.getstage(gestion_stage.table1);
                historique histo = new historique("Modifer Stage", date);
                currentuser = Bd.getcurrentAdmin(Authentification.usercurrent);
                BD.inserthistorique(histo.getId(), currentuser.split("_")[0], histo);
                this.hide();
            }catch(SQLException ex){
            }catch (Exception ex){
            }
        }
    }//GEN-LAST:event_enregistrerActionPerformed

    private void fermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fermerActionPerformed
        this.hide();
    }//GEN-LAST:event_fermerActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked

    }//GEN-LAST:event_table1MouseClicked

    private void typeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_typeFocusGained
          if (type1.getText().equals("Type")) {
            type1.setText("");
        }
    }//GEN-LAST:event_typeFocusGained

    private void typeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_typeFocusLost
       if (type1.getText().equals("Type")) {
            type1.setText("Type");
        }
    }//GEN-LAST:event_typeFocusLost

    private void projetFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_projetFocusGained
        if (projet1.getText().equals("Projet")) {
            projet1.setText("");
        }
    }//GEN-LAST:event_projetFocusGained

    private void projetFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_projetFocusLost
       if (projet1.getText().equals("")) {
            projet1.setText("Projet");
        }
    }//GEN-LAST:event_projetFocusLost

    private void type1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_type1FocusGained
        if (type1.getText().equals("Type")) {
            type1.setText("");
        }
    }//GEN-LAST:event_type1FocusGained

    private void type1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_type1FocusLost
        if (type1.getText().equals("")) {
            type1.setText("Type");
        }
    }//GEN-LAST:event_type1FocusLost

    private void projet1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_projet1FocusGained
        if (projet1.getText().equals("Projet")) {
            projet1.setText("");
        }
    }//GEN-LAST:event_projet1FocusGained

    private void projet1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_projet1FocusLost
        if(projet1.getText().equals("")) {
            projet1.setText("Projet");
        }
    }//GEN-LAST:event_projet1FocusLost

    private void projet1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projet1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_projet1ActionPerformed

    private void type1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_type1ActionPerformed
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
        } catch (Exception e) {
        }
        return res;
    }

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
            java.util.logging.Logger.getLogger(modifier_stage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modifier_stage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modifier_stage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modifier_stage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                 //   new modifier_stage().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(modifier_stage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> Box2;
    public static com.toedter.calendar.JDateChooser debut;
    private com.k33ptoo.components.KButton enregistrer;
    private com.k33ptoo.components.KButton fermer;
    public static com.toedter.calendar.JDateChooser fin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel1;
    public static javaswingdev.swing.rounde projet1;
    public static javax.swing.JTextArea text;
    public static javaswingdev.swing.rounde type1;
    // End of variables declaration//GEN-END:variables
}
