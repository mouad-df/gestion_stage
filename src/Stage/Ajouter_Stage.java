package Stage;

import Abscence.BD_Abscence;
import Admin.BD_admin;
import static Admin.modifier_admin.nom;
import Stagiaire.BD_stagiaire;
import Stagiaire.stagiaire;
import historique.BD_historique;
import historique.historique;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import forms.Authentification;
import static forms.gestion_historique.table1;
import forms.gestion_stage;
import static forms.gestion_stagiaire.table1;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class Ajouter_Stage extends javax.swing.JFrame {

    String currentuser = null;
    BD_Abscence bd;
    BD_Stage Bd;
    BD_historique BD;
    BD_admin base;
    DefaultTableModel model1;
    int indexrow = 0;
    String date_fin;

    public Ajouter_Stage() throws Exception {
        initComponents();
        this.setFocusable(true);
        bd = new BD_Abscence("localhost", 3306, "Gestion_Stages", "root", "");
        Bd = new BD_Stage("localhost", 3306, "Gestion_Stages", "root", "");
        BD = new BD_historique("localhost", 3306, "Gestion_Stages", "root", "");
        base = new BD_admin("localhost", 3306, "Gestion_Stages", "root", "");
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        model1 = (DefaultTableModel) gestion_stage.table1.getModel();
        bd.getCIN_Nom(Box2);
        Date date = new Date();
        debut.setDate(date);
        fin.setDate(date);
        DocumentListener dh;
        dh = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {

                if(!(stagiaire.getText().equals("Stagiaire"))){
                    try {
                        if (stagiaire.getText().isEmpty() == false) {
                            Box2.removeAllItems();
                            Bd.getCIN_Nom(stagiaire.getText(), Box2);
                        }else{
                            Box2.removeAllItems();
                            Bd.getCIN_Nom(stagiaire.getText(), Box2);
                        }
                    }catch(SQLException   ex){
                    }
                }
            }
            public void removeUpdate(DocumentEvent e) {
                if (!(stagiaire.getText().equals("Stagiaire"))) {
                    try {
                        if (stagiaire.getText().isEmpty() == false) {
                            Box2.removeAllItems();
                            Bd.getCIN_Nom(stagiaire.getText(), Box2);
                        } else {
                            Box2.removeAllItems();
                            Bd.getCIN_Nom(stagiaire.getText(), Box2);
                        }
                    } catch (SQLException ex) {
                    }
                }
            }

            public void changedUpdate(DocumentEvent e) {
            }
        };
        stagiaire.getDocument().addDocumentListener(dh);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        debut = new com.toedter.calendar.JDateChooser();
        fin = new com.toedter.calendar.JDateChooser();
        Box2 = new javax.swing.JComboBox<>();
        Ajouter = new com.k33ptoo.components.KButton();
        fermer = new com.k33ptoo.components.KButton();
        type1 = new javaswingdev.swing.rounde();
        projet1 = new javaswingdev.swing.rounde();
        stagiaire = new javaswingdev.swing.rounde();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

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
        jLabel1.setText("Date début");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Date Fin");

        debut.setDateFormatString("yyyy-MM-dd");
        debut.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        fin.setDateFormatString("yyyy-MM-dd");
        fin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Box2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Box2.setOpaque(false);

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

        stagiaire.setText("Stagiaire");
        stagiaire.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stagiaireFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                stagiaireFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(fermer, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(type1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(projet1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(stagiaire, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Box2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(debut, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fin, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1))))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(debut, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(type1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(projet1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stagiaire, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Box2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fermer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))))
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

    private void AjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterActionPerformed
        int cin1 = 0;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String date1 = dateFormat.format(debut.getDate());
        String date2 = dateFormat.format(fin.getDate());
        int nbr_jour = this.nbrjour(date1, date2);
        if (type1.getText().equals("") || type1.getText().equals("Type")) {
            JOptionPane.showMessageDialog(null, " Type !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        } else if (projet1.getText().equals("") || projet1.getText().equals("Projet")) {
            JOptionPane.showMessageDialog(null, "Projet !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        } else if (date1.equals(date2)) {
            JOptionPane.showMessageDialog(null, "Vuiellez de varie les dates !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        }else if(Box2.getSelectedIndex() < 0){
            JOptionPane.showMessageDialog(null, "Vuiellez sélectionner un stagiaire !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                date_fin = Bd.Rechercher_Stage(Box2.getSelectedItem().toString().split(" ")[0]);
                if (date_fin != null) {
                    if (dateFormat.parse(date1).before(dateFormat.parse(date_fin))) {
                        JOptionPane.showMessageDialog(null, " Vuiellez d'enter une date debut  Superieur a " + date_fin, "", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        Stage stage = new Stage(type1.getText(), date1, date2, nbr_jour, projet1.getText(), text.getText());
                        Bd.Ajouter_Stage(Box2.getSelectedItem().toString().split(" ")[0], stage);
                        //gestion_stage.table1.addRow(new Object[]{" ",Box2.getSelectedItem().toString().split(" ")[0], type.getText(), projet.getText(),date1,date2, nbr_jour});
                        gestion_stage.table1.removeall(gestion_stage.table1);
                        Bd.getstage(gestion_stage.table1);
                        historique histo = new historique("Ajouter Stage", date);
                        currentuser = base.getcurrentAdmin(Authentification.usercurrent);
                        BD.inserthistorique(histo.getId(), currentuser.split("_")[0], histo);
                        this.hide();
                    }
                }else{
                    Stage stage = new Stage(type1.getText(), date1, date2, nbr_jour, projet1.getText(), text.getText());
                    Bd.Ajouter_Stage(Box2.getSelectedItem().toString().split(" ")[0],stage);
                    //gestion_stage.table1.addRow(new Object[]{" ",Box2.getSelectedItem().toString().split(" ")[0], type.getText(), projet.getText(),date1,date2, nbr_jour});
                    gestion_stage.table1.removeall(gestion_stage.table1);
                    Bd.getstage(gestion_stage.table1);
                    historique histo = new historique("Ajouter Stage", date);
                    currentuser = base.getcurrentAdmin(Authentification.usercurrent);
                    BD.inserthistorique(histo.getId(), currentuser.split("_")[0], histo);
                    this.hide();
                }
            } catch (SQLException ex) {
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_AjouterActionPerformed

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

    private void stagiaireFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stagiaireFocusGained
        if(stagiaire.getText().equals("Stagiaire")){
            stagiaire.setText("");
        }
    }//GEN-LAST:event_stagiaireFocusGained

    private void stagiaireFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stagiaireFocusLost
        if (stagiaire.getText().equals("")) {
            stagiaire.setText("Stagiaire");
        }
    }//GEN-LAST:event_stagiaireFocusLost

    private void fermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fermerActionPerformed
        this.hide();

    }//GEN-LAST:event_fermerActionPerformed

    private void typeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cin2FocusGained

    }//GEN-LAST:event_cin2FocusGained

    private void typeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cin2FocusLost

    }//GEN-LAST:event_cin2FocusLost

    private void projetFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomFocusGained
        if(projet1.getText().equals("Nom complet")){
            projet1.setText("");
        }
    }//GEN-LAST:event_nomFocusGained

    private void projetFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomFocusLost
        if (projet1.getText().equals("")) {
            projet1.setText("Nom complet");
        }
    }//GEN-LAST:event_nomFocusLost

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
    private int nbrjour(String date1, String date2){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int res = 0;
        try {
            /*Date dateAvant = sdf.parse(date1);
            Date dateApres = sdf.parse(date2);
            int diff = (int) (dateAvant.getTime() - dateApres.getTime());
            res = (diff / (1000 * 60 * 60 * 24));*/
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate d1 = LocalDate.parse(date1, format);
            LocalDate d2 = LocalDate.parse(date2, format);
            Period period = Period.between(d1, d2);
            res = period.getDays();
        } catch (Exception e) {
        }
        return res;
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Ajouter_Stage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton Ajouter;
    private javax.swing.JComboBox<String> Box2;
    private com.toedter.calendar.JDateChooser debut;
    private com.k33ptoo.components.KButton fermer;
    private com.toedter.calendar.JDateChooser fin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javaswingdev.swing.rounde projet1;
    private javaswingdev.swing.rounde stagiaire;
    private javax.swing.JTextArea text;
    public static javaswingdev.swing.rounde type1;
    // End of variables declaration//GEN-END:variables
}
