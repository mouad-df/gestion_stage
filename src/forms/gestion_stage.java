package forms;

import Stage.Ajouter_Stage;
import Stage.Attestation;
import Stage.BD_Stage;
import Stage.message_supprimer_stage;
import Stage.modifier_stage;
import Stagiaire.modifier_stagiaire;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.BorderLayout;
import java.awt.Desktop;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import static forms.gestion_abscence.table1;
import static forms.gestion_historique.table1;
import static forms.gestion_stagiaire.cinselected1;
import static forms.gestion_stagiaire.table1;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import pièce.Ajouter_pièce;

public class gestion_stage extends javax.swing.JPanel {

    public static String idselected, cinselected;

    DefaultTableModel model;
    int indexrow;
    BD_Stage Bd;
    Date date;

    public gestion_stage() throws Exception {
        initComponents();
        supprimer.setVisible(false);
        modifier.setVisible(false);
        piece.setVisible(false);
        Bd = new BD_Stage("localhost", 3306, "Gestion_Stages", "root", "");
        Bd.getstage(table1);
        model = (DefaultTableModel) gestion_stage.table1.getModel();
        indexrow = gestion_stage.table1.getSelectedRow();
        date = new Date();
      debut.setDate(date);
           fin.setDate(date);
        DocumentListener dl;
        dl = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!(rechercher.getText().equals("Rechercher"))){
                    try{
                        if(rechercher.getText().isEmpty() == false){
                            table1.removeall(table1);
                            Bd.rechercher(rechercher.getText(),table1);
                        } else {
                            table1.removeall(table1);
                            Bd.getstage(table1);
                        }
                    } catch (SQLException ex) {
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!(rechercher.getText().equals("Rechercher"))) {
                    try {
                        if (rechercher.getText().isEmpty() == false) {
                            table1.removeall(table1);
                            Bd.rechercher(rechercher.getText(), table1);
                        } else {
                            table1.removeall(table1);
                            Bd.getstage(table1);
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
       debut.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if ("date".equals(e.getPropertyName())) {
                    try {
                        SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
                        String date1 = Date_Format.format(debut.getDate());
                        String date2 = Date_Format.format(fin.getDate());
                        
                        int response = JOptionPane.showConfirmDialog(null, "La liste des Stages  entre "+date1+" et "+date2, "", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if (response == JOptionPane.YES_OPTION) {
                            if (date1.equals(Date_Format.format(date)) && date2.equals(Date_Format.format(date))) {
                            table1.removeall(table1);
                            Bd.getstage(table1);
                        } else {
                            table1.removeall(table1);
                            Bd.rechercherparDate( date1, date2, table1);
                        }
                        } else if (response == JOptionPane.NO_OPTION) {
                        }
                    } catch (SQLException ex) {

                    }
                }
            }
        });
        fin.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if ("date".equals(e.getPropertyName())) {
                    try {
                        SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
                        String date1 = Date_Format.format(debut.getDate());
                        String date2 = Date_Format.format(fin.getDate());
                        int response = JOptionPane.showConfirmDialog(null, "La liste des Stages  entre "+date1+" et "+date2, "", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if (response == JOptionPane.YES_OPTION) {
                            if (date1.equals(Date_Format.format(date)) && date2.equals(Date_Format.format(date))) {
                            table1.removeall(table1);
                            Bd.getstage(table1);
                        } else {
                            table1.removeall(table1);
                            Bd.rechercherparDate( date1, date2, table1);
                        }
                        } else if (response == JOptionPane.NO_OPTION) {
                        }
                    } catch (SQLException ex) {
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        Ajouter = new com.k33ptoo.components.KButton();
        supprimer = new com.k33ptoo.components.KButton();
        modifier = new com.k33ptoo.components.KButton();
        jLabel1 = new javax.swing.JLabel();
        piece = new com.k33ptoo.components.KButton();
        attestation = new com.k33ptoo.components.KButton();
        debut = new com.toedter.calendar.JDateChooser();
        fin = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        rechercher = new javaswingdev.swing.rounde();
        roundPanel1 = new javaswingdev.swing.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javaswingdev.swing.table.Table();

        jCheckBox1.setText("jCheckBox1");

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sync_64px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        piece.setForeground(new java.awt.Color(0, 0, 0));
        piece.setText("Pièce");
        piece.setBorderPainted(false);
        piece.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        piece.setkAllowTab(true);
        piece.setkBackGroundColor(new java.awt.Color(143, 148, 251));
        piece.setkBorderRadius(50);
        piece.setkEndColor(new java.awt.Color(143, 148, 251));
        piece.setkForeGround(new java.awt.Color(0, 0, 0));
        piece.setkHoverColor(new java.awt.Color(143, 148, 251));
        piece.setkHoverEndColor(new java.awt.Color(143, 148, 251));
        piece.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        piece.setkHoverStartColor(new java.awt.Color(143, 148, 251));
        piece.setkIndicatorColor(new java.awt.Color(143, 148, 251));
        piece.setkPressedColor(new java.awt.Color(143, 148, 251));
        piece.setkSelectedColor(new java.awt.Color(143, 148, 251));
        piece.setkStartColor(new java.awt.Color(143, 148, 251));
        piece.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pieceActionPerformed(evt);
            }
        });

        attestation.setForeground(new java.awt.Color(0, 0, 0));
        attestation.setText("Attestation");
        attestation.setBorderPainted(false);
        attestation.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        attestation.setkAllowTab(true);
        attestation.setkBackGroundColor(new java.awt.Color(143, 148, 251));
        attestation.setkBorderRadius(50);
        attestation.setkEndColor(new java.awt.Color(143, 148, 251));
        attestation.setkForeGround(new java.awt.Color(0, 0, 0));
        attestation.setkHoverColor(new java.awt.Color(143, 148, 251));
        attestation.setkHoverEndColor(new java.awt.Color(143, 148, 251));
        attestation.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        attestation.setkHoverStartColor(new java.awt.Color(143, 148, 251));
        attestation.setkIndicatorColor(new java.awt.Color(143, 148, 251));
        attestation.setkPressedColor(new java.awt.Color(143, 148, 251));
        attestation.setkSelectedColor(new java.awt.Color(143, 148, 251));
        attestation.setkStartColor(new java.awt.Color(143, 148, 251));
        attestation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attestationActionPerformed(evt);
            }
        });

        debut.setDateFormatString("yyyy-MM-dd");
        debut.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        fin.setDateFormatString("yyyy-MM-dd");
        fin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setText("Filtrer entre deux Date");

        rechercher.setText("Rechercher");
        rechercher.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rechercherFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rechercherFocusLost(evt);
            }
        });
        rechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechercherActionPerformed(evt);
            }
        });

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "CIN", "Type", "Projet", "date_debut", "date_fin", "Jours"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true, true, false
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1132, Short.MAX_VALUE)
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
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(73, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(debut, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fin, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(piece, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(attestation, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(124, 124, 124))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(debut, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(61, 61, 61)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(piece, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(attestation, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
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

    private void AjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterActionPerformed
        try {
            new Ajouter_Stage().show();
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_AjouterActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        try {
            new    message_supprimer_stage().show();
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_supprimerActionPerformed

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
        int i = 0;
        model = (DefaultTableModel) gestion_stage.table1.getModel();
        indexrow = gestion_stage.table1.getSelectedRow();
        try {
            idselected = model.getValueAt(indexrow, 0).toString();
            cinselected = model.getValueAt(indexrow, 1).toString();
            //Bd.getNom(cinselected, modifier_stage.Box2);
            String Text = Bd.getdate(idselected);
            java.util.Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(indexrow, 4).toString());
            java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(indexrow, 5).toString());
            if (indexrow < 0) {
                JOptionPane.showMessageDialog(null, " Vuiellez de selectionner une ligne !",
                        "", JOptionPane.INFORMATION_MESSAGE);
            }else{
                new modifier_stage().show();
                Bd.getNom(cinselected, modifier_stage.Box2);
                modifier_stage.type1.setText(model.getValueAt(indexrow, 2).toString());
                modifier_stage.projet1.setText(model.getValueAt(indexrow, 3).toString());
                modifier_stage.text.setText(Text);
                modifier_stage.debut.setDate(date1);
                modifier_stage.fin.setDate(date2);
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_modifierActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        if (table1.getSelectedRow() >= 0) {
            modifier.setVisible(true);
            supprimer.setVisible(true);
            piece.setVisible(true);
        }
    }//GEN-LAST:event_table1MouseClicked

    private void pieceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pieceActionPerformed
        model = (DefaultTableModel) gestion_stage.table1.getModel();
        indexrow = gestion_stage.table1.getSelectedRow();
        if (indexrow < 0) {
            JOptionPane.showMessageDialog(null, "Vueillez de selectionner un stage !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                //cinselected = model.getValueAt(indexrow, 0).toString();
                idselected = model.getValueAt(indexrow, 0).toString();
                new Ajouter_pi�ce().show();
            } catch (Exception ex) {
                Logger.getLogger(gestion_stage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_pieceActionPerformed

    private void attestationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attestationActionPerformed
        model = (DefaultTableModel) gestion_stage.table1.getModel();
        indexrow = gestion_stage.table1.getSelectedRow();
        try {
            /*     Document doc = new Document();
            try {
            PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\HP\\OneDrive\\Bureau\\java\\Gestion Stage\\Stagiaire.pdf"));
            doc.open();
            doc.add(new Paragraph("khalid"));
            Image img = Image.getInstance("C:\\Users\\HP\\OneDrive\\Bureau\\webagency\\image\\backlink.jpg");
            img.scaleAbsoluteHeight(100);
            img.scaleAbsoluteWidth(100);
            img.setAlignment(Image.ALIGN_RIGHT);
            doc.add(img);
            doc.close();
            Desktop.getDesktop().open(new File("C:\\Users\\HP\\OneDrive\\Bureau\\java\\Gestion Stage\\Stagiaire.pdf"));
            } catch (DocumentException ex) {
            Logger.getLogger(gestion_stage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
            Logger.getLogger(gestion_stage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
            Logger.getLogger(gestion_stage.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            if (indexrow < 0) {
                JOptionPane.showMessageDialog(null, "Vueillez de selectionner un stage !",
                        "", JOptionPane.INFORMATION_MESSAGE);
            } else {
                HashMap h = new HashMap();
                h.put("id", model.getValueAt(indexrow, 0).toString());
                h.put("cin", model.getValueAt(indexrow, 1).toString());
                JasperDesign d = JRXmlLoader.load("C:\\Users\\HP\\OneDrive\\Bureau\\java\\GESTION-Stage\\src\\Stage\\Attestation.jrxml");
                JasperReport js = JasperCompileManager.compileReport(d);
                JasperPrint pr = JasperFillManager.fillReport(js, h, Bd.cnx);
                //JRViewer VIEW = new JRViewer(pr);
                JasperViewer viewer = new JasperViewer(pr, false);
                viewer.setTitle("ATTESTATION DE STAGE");
                viewer.setVisible(true);
                /*VIEW.remove(0);
                JasperViewer.viewReport(pr);*/
            
                /*Attestation.attestation.setLayout(new BorderLayout());
                //jPanel2.add(VIEW);*/
                /*Attestation   attestation= new Attestation();
                attestation.getContentPane().add(VIEW);
                attestation.pack();
                attestation.setVisible(true);
                /*JasperExportManager.exportReportToPdfFile(pr, "C:\\Users\\HP\\OneDrive\\Bureau\\java\\GESTION-Stage\\src\\Tache\\test.pdf");
           new Attestation().getContentPane().add(VIEW);
           new Attestation().pack();
          new Attestation().setVisible(true);*/
            }
        }catch(Exception ex){
           ex.printStackTrace();
        }
    }//GEN-LAST:event_attestationActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        try {
            table1.removeall(table1);
            Bd.getstage(table1);
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

    private void rechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechercherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rechercherActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton Ajouter;
    private com.k33ptoo.components.KButton attestation;
    private com.toedter.calendar.JDateChooser debut;
    private com.toedter.calendar.JDateChooser fin;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.k33ptoo.components.KButton modifier;
    private com.k33ptoo.components.KButton piece;
    private javaswingdev.swing.rounde rechercher;
    private javaswingdev.swing.RoundPanel roundPanel1;
    private com.k33ptoo.components.KButton supprimer;
    public static javaswingdev.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
