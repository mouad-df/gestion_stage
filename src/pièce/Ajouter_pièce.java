
package pièce;

import Admin.BD_admin;

import historique.BD_historique;
import historique.historique;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import forms.Authentification;
import forms.gestion_stage;
import static forms.gestion_stagiaire.table1;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.util.ImageIOUtil;
import javax.swing.border.EmptyBorder;
public class Ajouter_pièce extends javax.swing.JFrame {

    BD_pièce bd;
    String currentuser = null;
    BD_admin Bd;
    BD_historique BD;
    DefaultTableModel model;
    int indexrow;
String path;
    public Ajouter_pièce() throws Exception {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        setDefaultCloseOperation(Ajouter_pièce.DISPOSE_ON_CLOSE);
        bd = new BD_pièce("localhost", 3306, "Gestion_Stages", "root", "");
        Bd = new BD_admin("localhost", 3306, "Gestion_Stages", "root", "");
        BD = new BD_historique("localhost", 3306, "Gestion_Stages", "root", "");
        bd.rechercher(gestion_stage.idselected, table1);
        supprimer.setVisible(false);
        /*Image getAbsolutePath = null;
        ImageIcon icon = new ImageIcon("‪C:\\Users\\HP\\OneDrive\\Bureau\\webagency\\image\\Email-marketing.jpg");
        Image img = icon.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        jLabel1.setIcon(icon);*/
       //  jLabel3.setBorder(new EmptyBorder(30, 30, 30, 30));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Ajouter = new com.k33ptoo.components.KButton();
        supprimer = new com.k33ptoo.components.KButton();
        jLabel2 = new javax.swing.JLabel();
        kButton1 = new com.k33ptoo.components.KButton();
        roundPanel2 = new javaswingdev.swing.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javaswingdev.swing.table.Table();
        piece = new javaswingdev.swing.rounde();
        type1 = new javaswingdev.swing.rounde();
        chemin1 = new javaswingdev.swing.rounde();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Browse");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        kButton1.setText("X");
        kButton1.setToolTipText("");
        kButton1.setBorderPainted(false);
        kButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        kButton1.setkBackGroundColor(new java.awt.Color(240, 240, 240));
        kButton1.setkBorderRadius(0);
        kButton1.setkEndColor(new java.awt.Color(240, 240, 240));
        kButton1.setkForeGround(new java.awt.Color(255, 0, 0));
        kButton1.setkHoverColor(new java.awt.Color(255, 0, 0));
        kButton1.setkHoverEndColor(new java.awt.Color(255, 0, 0));
        kButton1.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        kButton1.setkHoverStartColor(new java.awt.Color(255, 0, 0));
        kButton1.setkIndicatorColor(new java.awt.Color(255, 0, 0));
        kButton1.setkPressedColor(new java.awt.Color(255, 0, 0));
        kButton1.setkStartColor(new java.awt.Color(240, 240, 240));
        kButton1.setOpaque(false);
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom_Piece", "Type", "Chemin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addContainerGap())
        );

        piece.setText("Nom_Pièce");
        piece.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pieceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pieceFocusLost(evt);
            }
        });
        piece.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pieceActionPerformed(evt);
            }
        });

        type1.setText("Type Pièce");
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

        chemin1.setText("Chemin");
        chemin1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                chemin1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                chemin1FocusLost(evt);
            }
        });
        chemin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chemin1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(type1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(piece, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chemin1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)))
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(652, 652, 652))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(piece, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(type1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chemin1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(Ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)))
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(273, 273, 273))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterActionPerformed
        Date date = new Date();
        try {
            if   (piece.getText().equals("")||piece.getText().equals("Nom_Pièce")){
                JOptionPane.showMessageDialog(null, "Nom_Pièce !",
                        "", JOptionPane.INFORMATION_MESSAGE);
            } else if (type1.getText().equals("") || type1.getText().equals("Type Pièce")) {
                JOptionPane.showMessageDialog(null, "Type  !",
                        "", JOptionPane.INFORMATION_MESSAGE);
            } else if (chemin1.getText().equals("") || chemin1.getText().equals("Chemin")) {
                JOptionPane.showMessageDialog(null, "Chemin !",
                        "", JOptionPane.INFORMATION_MESSAGE);
            }else{
                String   image_chemin=chemin1.getText();
                table1.addRow(new Object[]{piece.getText(), type1.getText(),image_chemin});
                image_chemin = image_chemin.replace("\\","/");
                pièce pièce = new pièce(piece.getText(), type1.getText(),image_chemin);
                bd.insertpiece(gestion_stage.idselected, pièce);
                historique histo = new historique("Ajouter Pièce", date);
                currentuser = Bd.getcurrentAdmin(Authentification.usercurrent);
                BD.inserthistorique(histo.getId(), currentuser.split("_")[0], histo);
                piece.setText("Nom_Pièce");
                type1.setText("Type Pièce");
                chemin1.setText("Chemin");
            }
        }catch (SQLException ex){
            Logger.getLogger(Ajouter_pièce.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AjouterActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        Date date = new Date();
        model = (DefaultTableModel) table1.getModel();
        indexrow = table1.getSelectedRow();
        if (indexrow < 0) {
            JOptionPane.showMessageDialog(null, "Vueillez de selectionner une pièce !",
                    "", JOptionPane.INFORMATION_MESSAGE);
        }else{
            String imageurl=model.getValueAt(indexrow, 2).toString().replace("\\","/");
            try {
                bd.supprimerpiece(gestion_stage.idselected, model.getValueAt(indexrow, 0).toString(), model.getValueAt(indexrow, 1).toString(), imageurl);
                table1.removerow(indexrow);
                historique histo = new historique("Supprimer Pièce", date);
                currentuser = Bd.getcurrentAdmin(Authentification.usercurrent);
                BD.inserthistorique(histo.getId(), currentuser.split("_")[0], histo);
                piece.setText("Nom_Pièce");
                type1.setText("Type Pièce");
                chemin1.setText("Chemin");
            } catch (SQLException ex) {
                Logger.getLogger(Ajouter_pièce.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_supprimerActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        model = (DefaultTableModel) table1.getModel();
        indexrow = table1.getSelectedRow();
        if(indexrow>=0){
            supprimer.setVisible(true);
            piece.setText(model.getValueAt(indexrow, 0).toString());
            type1.setText(model.getValueAt(indexrow, 1).toString());
            chemin1.setText(model.getValueAt(indexrow, 2).toString());
            String image_chemin=model.getValueAt(indexrow, 2).toString();
            ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(image_chemin));
            Image img = icon.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon icon2 = new ImageIcon(img);
            jLabel1.setIcon(icon2);
        }else{
        }
    }//GEN-LAST:event_table1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        try{
            String DIR = "C:\\Users\\HP\\OneDrive\\Bureau\\images\\";
            String  fileimage =null;
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter =new FileNameExtensionFilter("Images files", "jpge","png","jpg");
            chooser.setFileFilter(filter);
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
             path = f.getAbsolutePath();
            //path=path.replace("\\", "\\\\");
            /*if(path.contains(".pdf")){
                PDDocument pdf = PDDocument.load(new File(path));
                PDFRenderer pdfrenderer = new PDFRenderer(pdf);
                for(int page=0 ; page<pdf.getNumberOfPages() ; ++page){
                    BufferedImage bim = pdfrenderer.renderImageWithDPI(page, 300, ImageType.RGB);
                    fileimage=  DIR+"image-"+page+".png";
                    ImageIOUtil.writeImage(bim,fileimage,300);
                }
            chemin.setText(path );
            Image getAbsolutePath = null;
            ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(path));
            Image img = icon.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
           ImageIcon icon2 = new ImageIcon(img);
            jLabel1.setIcon(icon2);          
            }else{*/
            chemin1.setText(path);
            Image getAbsolutePath = null;
            ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(path));
            Image img = icon.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon icon2 = new ImageIcon(img);
            jLabel1.setIcon(icon2);
           // }
            
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void piece1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pieceFocusGained
        if (piece.getText().equals("Nom_Pièce")) {
            piece.setText("");
        }
    }//GEN-LAST:event_pieceFocusGained

    private void piece1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pieceFocusLost
        if (piece.getText().equals("")) {
            piece.setText("Nom_Pièce");
        }
    }//GEN-LAST:event_pieceFocusLost

    private void type1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_type1FocusGained
        if (type1.getText().equals("Type Pièce")) {
            type1.setText("");
        }
    }//GEN-LAST:event_type1FocusGained

    private void type1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_type1FocusLost
        if (type1.getText().equals("")) {
            type1.setText("Type Pièce");
        }
    }//GEN-LAST:event_type1FocusLost

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_kButton1ActionPerformed

    private void chemin1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_chemin1FocusLost
        if (chemin1.getText().equals("")) {
            chemin1.setText("Chemin");
        }
    }//GEN-LAST:event_chemin1FocusLost

    private void chemin1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_chemin1FocusGained
        if (chemin1.getText().equals("Chemin")) {
            chemin1.setText("");
        }
    }//GEN-LAST:event_chemin1FocusGained

    private void pieceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomFocusGained
        if (piece.getText().equals("Nom_Pièce")) {
            piece.setText("");
        }
    }//GEN-LAST:event_nomFocusGained

    private void pieceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomFocusLost
        if (piece.getText().equals("")) {
            piece.setText("Nom_Pièce");
        }
    }//GEN-LAST:event_nomFocusLost

    private void pieceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pieceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pieceActionPerformed

    private void typeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_piece1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_piece1FocusGained

    private void typeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_piece1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_piece1FocusLost

    private void type1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_type1ActionPerformed

    private void cheminFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_type2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_type2FocusGained

    private void cheminFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_type2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_type2FocusLost

    private void chemin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chemin1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chemin1ActionPerformed

 
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
            java.util.logging.Logger.getLogger(Ajouter_pièce.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ajouter_pièce.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ajouter_pièce.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ajouter_pièce.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Ajouter_pièce().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton Ajouter;
    public static javaswingdev.swing.rounde chemin1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.k33ptoo.components.KButton kButton1;
    public static javaswingdev.swing.rounde piece;
    private javaswingdev.swing.RoundPanel roundPanel2;
    private com.k33ptoo.components.KButton supprimer;
    private javaswingdev.swing.table.Table table1;
    public static javaswingdev.swing.rounde type1;
    // End of variables declaration//GEN-END:variables
}
