
package Stagiaire;
import Admin.admin;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javaswingdev.swing.table.Table;

public class BD_stagiaire {
    
    Connection cnx;
    ArrayList<String> CIN = new ArrayList<String>();
       ArrayList<String> CINStage = new ArrayList<String>();
    admin Admin;
    public BD_stagiaire(String machine, int port, String bd, String utilisateur, String mdp)
            throws Exception {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        // jdbc:mysql://machine:port/bd?serverTimezone=UTC
        cnx = (Connection) DriverManager.getConnection("jdbc:mysql://" + machine + ":" + port + "/" + bd + "?serverTimezone=UTC",
                utilisateur, mdp);
    }
    
    public Connection getCnx() {
        return cnx;
    }
    public void Ajouter_Stagiaire(stagiaire stagiair) throws SQLException, ClassNotFoundException {

        Statement state = cnx.createStatement();
        state.executeUpdate("INSERT INTO  `stagiaire`  ( `cne`,`nom`,`email`,`telphone`,`adresse`,`etablissement`) values ('" + stagiair.getCne() + "','" + stagiair.getNom() + "','" +stagiair.getEmail() + "','" + stagiair.getTel() + "','" + stagiair.getAdresse()+ "','" + stagiair.getEtablissement() + "')");
        state.close();
    }

    public ArrayList<String> getCIN() throws SQLException {
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("select  cne from `stagiaire` ");
        String cin;
        while (resultat.next()) {
            cin = resultat.getString("cne");
            CIN.add(cin);
        }
        resultat.close();
        state.close();
        return CIN;
    }
    public ArrayList<String> getCINSTAGE() throws SQLException {
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("select  cne from `stage` ");
        String cin;
        while (resultat.next()) {
           cin = resultat.getString("cne");
           CINStage.add(cin);
        }
        resultat.close();
        state.close();
        return CINStage;
    }

    public void getStagiaire(Table table) throws SQLException {
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("select   cne , nom , email, telphone ,adresse,etablissement from `stagiaire` ");
        String cin, nom, email, tel, ettab,adresse;
        while (resultat.next()) {
            cin = resultat.getString("cne");
            nom = resultat.getString("nom");
            email = resultat.getString("email");
            tel = resultat.getString("telphone");
              ettab = resultat.getString("etablissement");
              adresse = resultat.getString("adresse");
            //Admin = new admin(cin,nom,email,tel,password);
            //table.addRow(new Object[]{Admin.getCne(),Admin.getNom(),Admin.getEmail(),Admin.getTel(),Admin.getNom_utilisateur()});
            table.addRow(new Object[]{cin, nom, email, tel,adresse,ettab});
        }
        resultat.close();
        state.close();
    }

    public String getpassword(String cin) throws SQLException {
        Statement state = cnx.createStatement();
        //PreparedStatement pstmt = cnx.prepareStatement("SELECT   mot_de_pass  FROM `admin`  WHERE   cne = ? ");
        ResultSet resultat = state.executeQuery("SELECT   *  FROM `stagiaire`  WHERE   cne = '" + cin + "'");
        //pstmt.setString(1, cin);
        // ResultSet resultat = pstmt.executeQuery();
        String pass = null;
        while (resultat.next()) {
            //modifier_admin.password.setText(resultat.getString("mot_de_pass"));
            pass = resultat.getString("mot_de_pass");
        }
        resultat.close();
        state.close();
        return pass;
    }

    public void modifier_stagiaire(String cin, String nom, String email, String tel, String adresse,String etab) throws SQLException {
        PreparedStatement statement = cnx.prepareStatement("UPDATE  stagiaire  SET nom=?,email=?,telphone=?,adresse=?,etablissement=?  WHERE cne=?");
        statement.setString(1, nom);
        statement.setString(2, email);
        statement.setString(3, tel);
        statement.setString(4, adresse);
        statement.setString(5, etab);
        statement.setString(6, cin);
        statement.executeUpdate();
        //Statement state = cnx.createStatement();
        //state.execute("UPDATE  admin  SET  cne="+cin+", nom="+nom+", email="+email+",telphone="+tel+" ,mot_de_pass="+mot_de_pass+" WHERE cne= "+anccin); 
        statement.close();
    }

    public void supprimerstagiaire(String cne) throws SQLException {
        
        String query = "DELETE FROM stagiaire WHERE  cne = '" + cne + "'"; 
        Statement state = cnx.createStatement();
        int result=state.executeUpdate(query);
        if (result == 0) { 
           
        } else { 
            
        } 
       state.close();
     }
    public void supprimerstage(String cne) throws SQLException {
        
        String query = "DELETE FROM stage WHERE  cne = '" + cne + "'"; 
        Statement state = cnx.createStatement();
        int result=state.executeUpdate(query);
        if (result == 0) { 
            System.out.println("nadi");
        } else { 
            System.out.println("9awad");
        } 
       state.close();
     }
    
    public void rechercher(String text ,Table table) throws SQLException{
         Statement state = cnx.createStatement();
         ResultSet resultat = state.executeQuery("SELECT cne,nom,email,telphone,adresse,etablissement FROM  `stagiaire`  WHERE    cne  LIKE  '"+text+"%'  or  nom LIKE '"+text+"%'");
        String cin, nom, email, tel, adresse,etab;
        while (resultat.next()) {
            cin = resultat.getString("cne");
            nom = resultat.getString("nom");
            email = resultat.getString("email");
            tel = resultat.getString("telphone");
            adresse = resultat.getString("adresse");
            etab = resultat.getString("etablissement");
            table.addRow(new Object[]{cin, nom, email, tel, adresse,etab});
        }
        resultat.close();
        state.close();
    }
}
