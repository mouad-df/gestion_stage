package Admin;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javaswingdev.swing.table.Table;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BD_admin {

    Connection cnx;
    ArrayList<String> CIN = new ArrayList<String>();
    admin Admin;

    public BD_admin(String machine, int port, String bd, String utilisateur, String mdp)
            throws Exception {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        // jdbc:mysql://machine:port/bd?serverTimezone=UTC
        cnx = (Connection) DriverManager.getConnection("jdbc:mysql://" + machine + ":" + port + "/" + bd + "?serverTimezone=UTC",
                utilisateur, mdp);
    }

    public Connection getCnx() {
        return cnx;
    }

    public void Ajouter_Admin(admin compte) throws SQLException, ClassNotFoundException {
        Statement state = cnx.createStatement();
        state.executeUpdate("INSERT INTO  `utilisateur`   ( `cne`,`nom`,`email`,`telphone`,`mot_de_pass`,`user_name`) values ('" + compte.getCne() + "','" + compte.getNom() + "','" + compte.getEmail() + "','" + compte.getTel() + "','" + compte.getMot_de_pass() + "','" + compte.getNom_utilisateur() + "')");
        state.close();
    }

    public ArrayList<String> getCIN() throws SQLException {
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("select  cne from `utilisateur` ");
        String cin;
        while (resultat.next()) {
            cin = resultat.getString("cne");
            CIN.add(cin);
        }
        resultat.close();
        state.close();
        return CIN;
    }

    public void getAdmins(Table table) throws SQLException {
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("select   cne , nom , email, telphone,user_name  from `utilisateur` ");
        String cin, nom, email, tel, user_name;
        while (resultat.next()) {
           cin = resultat.getString("cne");
           nom = resultat.getString("nom");
           email = resultat.getString("email");
           tel = resultat.getString("telphone");
           user_name = resultat.getString("user_name");
           //Admin = new admin(cin,nom,email,tel,password);
           //table.addRow(new Object[]{Admin.getCne(),Admin.getNom(),Admin.getEmail(),Admin.getTel(),Admin.getNom_utilisateur()});
          table.addRow(new Object[]{cin, nom, email, tel, user_name});
        }
        resultat.close();
        state.close();
    }

    public String getpassword(String cin) throws SQLException {
        Statement state = cnx.createStatement();
        //PreparedStatement pstmt = cnx.prepareStatement("SELECT   mot_de_pass  FROM `admin`  WHERE   cne = ? ");
        ResultSet resultat = state.executeQuery("SELECT   *  FROM `utilisateur`  WHERE   cne = '" + cin + "'");
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

    public void modifier_Admin(String cin, String nom, String email, String tel, String mot_de_pass) throws SQLException {
        PreparedStatement statement = cnx.prepareStatement("UPDATE  utilisateur  SET nom=?,email=?,telphone=?,mot_de_pass=?  WHERE cne=?");
        statement.setString(1, nom);
        statement.setString(2, email);
        statement.setString(3, tel);
        statement.setString(4, mot_de_pass);
        statement.setString(5, cin);
        statement.executeUpdate();
        //Statement state = cnx.createStatement();
        //state.execute("UPDATE  admin  SET  cne="+cin+", nom="+nom+", email="+email+",telphone="+tel+" ,mot_de_pass="+mot_de_pass+" WHERE cne= "+anccin); 
        statement.close();
    }

    public void supprimerAdmin(String cne) throws SQLException {
        
        String query = "DELETE FROM utilisateur WHERE  cne = '" + cne + "'"; 
       
        Statement state = cnx.createStatement();
        int result=state.executeUpdate(query);
        if (result == 0) { 
           
        } else { 
            
        } 
       state.close();
     }
    public void supprimerHistoriques(String cne) throws SQLException {
        
        String query = "DELETE FROM historique WHERE  cne = '" + cne + "'"; 
       
        Statement state = cnx.createStatement();
        int result=state.executeUpdate(query);
        if (result == 0) { 
           
        } else { 
            
        } 
       state.close();
     }
    
    public void rechercher(String text ,Table table) throws SQLException{
         Statement state = cnx.createStatement();
         ResultSet resultat = state.executeQuery("SELECT cne,nom,email,telphone,user_name  FROM  `utilisateur`  WHERE    cne  LIKE  '"+text+"%'  or  nom LIKE '"+text+"%'");
        String cin, nom, email, tel, user_name;
        while (resultat.next()) {
            cin = resultat.getString("cne");
            nom = resultat.getString("nom");
            email = resultat.getString("email");
            tel = resultat.getString("telphone");
            user_name = resultat.getString("user_name");
            table.addRow(new Object[]{cin, nom, email, tel, user_name});
        }
        resultat.close();
        state.close();
    }
    
    public boolean authentifier(String input1 ,String pass) throws SQLException{
        boolean nn=false;
     Statement state = cnx.createStatement();
         ResultSet resultat = state.executeQuery("SELECT   cne ,mot_de_pass , user_name  FROM  `utilisateur` ");
        String  cne, password, user_name;
        while (resultat.next()){
            cne  = resultat.getString("cne");
            password = resultat.getString("mot_de_pass");
            user_name = resultat.getString("user_name");
            if(input1.equals(cne) && pass.equals(password) || input1.equals(user_name) && pass.equals(password)){
             nn= true;
             break;
            }else{
            nn=false;
            }
        }
        resultat.close();
        state.close();
        if(nn==false){
        return false;
        }else{
        return true;
        }
    }
    
    public String getcurrentAdmin(String currentuser) throws SQLException{
       String info=null;
       Statement state = cnx.createStatement(); 
        ResultSet resultat = state.executeQuery("SELECT  cne,user_name  FROM  `utilisateur`  WHERE    cne ='"+currentuser+"'  or  user_name ='"+currentuser+"'");
        String cin,user_name;
        while (resultat.next()){
            cin = resultat.getString("cne");
            user_name = resultat.getString("user_name");
            info =cin+"_"+user_name;
        }
        resultat.close();
        state.close();
        return info;
    }
     public void getcurrentuser(String currentuser ,JTextField nom,JTextField email,JTextField  tel, JTextField pass) throws SQLException{
       Statement state = cnx.createStatement();    
         ResultSet resultat = state.executeQuery("SELECT  nom,telphone,mot_de_pass,email  FROM  `utilisateur`  WHERE    cne ='"+currentuser+"'  or  user_name ='"+currentuser+"'");
        while (resultat.next()) {
           nom.setText(resultat.getString("nom"));
           email.setText(resultat.getString("email"));
           tel.setText(resultat.getString("telphone"));
         pass.setText(resultat.getString("mot_de_pass"));
        }
        resultat.close();
        state.close();    
    }
     public void modifier_currentAdmin(String currentuser, String nom, String email, String tel, String mot_de_pass) throws SQLException {
        PreparedStatement statement = cnx.prepareStatement("UPDATE  utilisateur  SET nom=?,email=?,telphone=?,mot_de_pass=?  WHERE cne=?  or user_name=?");
        statement.setString(1, nom);
        statement.setString(2, email);
        statement.setString(3, tel);
        statement.setString(4, mot_de_pass);
        statement.setString(5, currentuser);
        statement.setString(6, currentuser);
        statement.executeUpdate();  
        statement.close();
    }
}
