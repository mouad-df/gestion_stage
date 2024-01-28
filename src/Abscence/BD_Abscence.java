package Abscence;

import Admin.admin;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javaswingdev.swing.table.Table;
import javax.swing.JComboBox;

public class BD_Abscence {

    Connection cnx;

    public BD_Abscence(String machine, int port, String bd, String utilisateur, String mdp)
            throws Exception {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        // jdbc:mysql://machine:port/bd?serverTimezone=UTC
        cnx = (Connection) DriverManager.getConnection("jdbc:mysql://" + machine + ":" + port + "/" + bd + "?serverTimezone=UTC",
                utilisateur, mdp);
    }

    public Connection getCnx() {
        return cnx;
    }

    public void Ajouter_abscence(String cin, String date1, String date2, int nbr_jour, abscence abscense) throws SQLException, ClassNotFoundException {
        int count=0;
        Statement state = cnx.createStatement();
        state.executeUpdate("INSERT INTO  `abscence`  (`date_debut`,`date_fin`,`nbr_jour`,`cause`,`cne`) values ('" + date1 + "','" + date2 + "', '" + nbr_jour + "'  ,'" + abscense.getCause() + "','" + cin + "')");
        state.close();
    }

    public void getCIN_Nom(JComboBox box) throws SQLException {
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("select   cne , nom  from `stagiaire` ");
        String cin, nom;
        while (resultat.next()) {
            cin = resultat.getString("cne");
            nom = resultat.getString("nom");
            box.addItem(cin + " " + nom);
        }
        resultat.close();
        state.close();
    }

    public void getAbscences(Table table) throws SQLException {
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("select   a.cne,s.nom,a.date_debut,a.date_fin,a.nbr_jour,a.cause  from `abscence`    a  join   `stagiaire`  s  on   a.cne=s.cne  ");
        String cin, nom, debut, fin, cause;
        int nbr;
        while (resultat.next()) {
            cin = resultat.getString("cne");
            nom = resultat.getString("nom");
            debut = resultat.getString("date_debut");
            fin = resultat.getString("date_fin");
            nbr = resultat.getInt("nbr_jour");
            cause = resultat.getString("cause");
            table.addRow(new Object[]{cin, nom, debut, fin, nbr, cause});
        }
        resultat.close();
        state.close();
    }

    public void rechercher(String text, Table table) throws SQLException {
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("SELECT a.cne,s.nom,a.date_debut,a.date_fin,a.nbr_jour,a.cause  FROM  `abscence`    a join  `stagiaire`   s   on a.cne=s.cne  WHERE    a.cne  LIKE  '" + text + "%'  or  s.nom LIKE '" + text + "%'");
        String cin, nom, debut, fin, cause;
        int nbr;
        while (resultat.next()) {
            cin = resultat.getString("cne");
            nom = resultat.getString("nom");
            debut = resultat.getString("date_debut");
            fin = resultat.getString("date_fin");
            nbr = resultat.getInt("nbr_jour");
            cause = resultat.getString("cause");
            table.addRow(new Object[]{cin, nom, debut, fin, nbr, cause});
        }
        resultat.close();
        state.close();
    }

    public void supprimerAbscence(String cin, String nom, String debut, String fin, String nbr, String cause) throws SQLException {

        String query = "DELETE FROM  abscence  WHERE  cne = '" + cin + "' and  date_debut='" + debut + "' and date_fin = '" + fin + "' and  nbr_jour = '" + nbr + "' and   cause= '" + cause + "'";
        Statement state = cnx.createStatement();
        int result = state.executeUpdate(query);
        state.close();
    }

    public void supprimer_abscence_stagiaire(String cne) throws SQLException {
        
        String query = "DELETE FROM abscence  WHERE  cne = '" + cne + "'"; 
        Statement state = cnx.createStatement();
        int result=state.executeUpdate(query);
        if (result == 0) { 
           
        } else { 
            
        } 
       state.close();
     }
    public int getid(String cin, String debut, String fin, String nbr, String cause) throws SQLException {
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("SELECT  id   from `abscence`  WHERE     cne = '" + cin + "' and   date_debut='" + debut + "' and date_fin = '" + fin + "' and  nbr_jour = '" + nbr + "' and   cause= '" + cause + "'");
        int id = 0;
        while (resultat.next()) {
            id = resultat.getInt("id");
        }
        resultat.close();
        state.close();
        return id;
    }

    public void modifier_abscence(int id,String debut, String fin, int nbr, String cause) throws SQLException {
        PreparedStatement statement = cnx.prepareStatement("UPDATE  abscence  SET   date_debut=?,date_fin=?,nbr_jour=?,cause=?  WHERE  id=?");

        statement.setString(1, debut);
        statement.setString(2, fin);
        statement.setInt(3, nbr);
        statement.setString(4, cause);
        statement.setInt(5, id);
        statement.executeUpdate();
        //Statement state = cnx.createStatement();
        //state.execute("UPDATE  admin  SET  cne="+cin+", nom="+nom+", email="+email+",telphone="+tel+" ,mot_de_pass="+mot_de_pass+" WHERE cne= "+anccin); 
        statement.close();
    }
}
