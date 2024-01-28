package Stage;

import Abscence.abscence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.swing.table.Table;
import javax.swing.JComboBox;

public class BD_Stage {

    ArrayList<String> CINStage = new ArrayList<String>();
    public static Connection cnx;

    public BD_Stage(String machine, int port, String bd, String utilisateur, String mdp)
            throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        // jdbc:mysql://machine:port/bd?serverTimezone=UTC
        cnx = (Connection) DriverManager.getConnection("jdbc:mysql://" + machine + ":" + port + "/" + bd + "?serverTimezone=UTC",
                utilisateur, mdp);
    }

    public Connection getCnx() throws Exception {
        return cnx;
    }

    public void Ajouter_Stage(String cin, Stage stage) throws SQLException, ClassNotFoundException {
        int count = 0;
        Statement state = cnx.createStatement();
        /*ResultSet resultat = state.executeQuery("SELECT  MAX(id)  as  count FROM  `stage`");
        while (resultat.next()) {
            count = resultat.getInt("count");
        }*/
        state.executeUpdate("INSERT INTO  `stage`  (`type`,`date_debut`,`date_fin`,`duree`,`projet`,`description`,`cne`) values ('" + stage.getType() + "','" + stage.getDate_debut() + "','" + stage.getDate_fin() + "','" + stage.getDuree() + "' ,'" + stage.getProjet() + "','" + stage.getDescription() + "','" + cin + "')");
        state.close();
    }

    public void getstage(Table table) throws SQLException {
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("select   id,cne,type,projet,date_debut,date_fin,duree    from  `stage`");
        String cin, type, projet, date_debut, date_fin;
        int duree, id;
        while (resultat.next()) {
            id = resultat.getInt("id");
            cin = resultat.getString("cne");
            type = resultat.getString("type");
            projet = resultat.getString("projet");
            duree = resultat.getInt("duree");
            date_fin = resultat.getString("date_fin");
            date_debut = resultat.getString("date_debut");
            table.addRow(new Object[]{id, cin, type, projet, date_debut, date_fin, duree});
        }
        resultat.close();
        state.close();
    }

    public void supprimerstage(String cin) throws SQLException {
        String query = "DELETE FROM  stage  WHERE  id = '" + cin + "' ";
        Statement state = cnx.createStatement();
        int result = state.executeUpdate(query);
        state.close();
    }

    public void supprimer_piece(String cin) throws SQLException {
        String query = "DELETE FROM  piece  WHERE  id = '" + cin + "' ";
        Statement state = cnx.createStatement();
        int result = state.executeUpdate(query);
        state.close();
    }

    public void rechercher(String text, Table table) throws SQLException {
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("SELECT  id ,cne,type,projet,date_debut,date_fin,duree  FROM  `stage`  WHERE    cne  LIKE  '" + text + "%'  or  type LIKE '" + text + "%' or projet LIKE '" + text + "%'");
        String cin, type, projet, date_debut, date_fin;
        int duree, id;
        while (resultat.next()) {
            cin = resultat.getString("cne");
            type = resultat.getString("type");
            projet = resultat.getString("projet");
            date_debut = resultat.getString("date_debut");
            date_fin = resultat.getString("date_fin");
            duree = resultat.getInt("duree");
            id = resultat.getInt("id");
            table.addRow(new Object[]{id, cin, type, projet, date_debut, date_fin, duree});
        }
        resultat.close();
        state.close();
    }

    public String getdate(String id) throws SQLException {
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("SELECT description  FROM  `stage`  WHERE    id  =  '" + id + "'");
        String debut, fin, desc = null;
        while (resultat.next()) {

            desc = resultat.getString("description");

        }
        resultat.close();
        state.close();
        return desc;
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

    public void modifier_Stage(int id, String type, String debut, String fin, int nbr, String projet, String desc) throws SQLException {
        PreparedStatement statement;
        statement = cnx.prepareStatement("UPDATE  stage  SET  type=? , date_debut=? , date_fin=?,duree=? ,projet=? ,description=?   WHERE  id=?");
        statement.setString(1, type);
        statement.setString(2, debut);
        statement.setString(3, fin);
        statement.setInt(4, nbr);
        statement.setString(5, projet);
        statement.setString(6, desc);
        statement.setInt(7, id);
        statement.executeUpdate();
        statement.close();
    }

    public void getNom(String cin, JComboBox box) throws SQLException {
        Statement state;
        state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("select   nom  from `stagiaire`  WHERE  cne LIKE '" + cin + "'");
        String nom;
        while (resultat.next()) {
            nom = resultat.getString("nom");
            box.addItem(cin + " " + nom);
        }
        resultat.close();
        state.close();
    }

    public void recherhcerpardatecurrent(String cin_user, String date1, Table table) throws SQLException {
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("SELECT cne,user_name,action,time  FROM  `stage`  WHERE    cne='" + cin_user + "'  and  time  LIKE '" + date1 + "%'  ORDER BY time DESC");
        String cin, user_name, action, time;
        while (resultat.next()) {
            cin = resultat.getString("cne");
            user_name = resultat.getString("user_name");
            action = resultat.getString("action");
            time = resultat.getString("time");
            table.addRow(new Object[]{cin, user_name, action, time});
        }
        resultat.close();
        state.close();
    }

    public void rechercherparDate(String date1, String date2, Table table) throws SQLException {
        Statement state;
        state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("SELECT   id,cne,type,projet,date_debut,date_fin,duree   FROM  `stage`  WHERE   date_debut  >= '" + date1 + "'  and  date_fin <= '" + date2 + "'");
        String cin, type, projet,date_debut,date_fin;
        int duree,id;
        while (resultat.next()) {
            id = resultat.getInt("id");
            cin = resultat.getString("cne");
            type = resultat.getString("type");
            projet = resultat.getString("projet");
            date_debut = resultat.getString("date_debut");
            date_fin = resultat.getString("date_fin");
            duree = resultat.getInt("duree");
            System.out.println(date_debut+" "+date_fin);
            table.addRow(new Object[]{id,cin, type, projet, date_debut,date_fin,duree});
        }
        resultat.close();
        state.close();
    }

    public void gettache(String text, JComboBox box) throws SQLException {
        Statement state;
        state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("select   tache  from `tache`  WHERE  tache LIKE '" + text + "%'");
        String tache;
        while (resultat.next()) {
            tache = resultat.getString("tache");
            box.addItem(tache);
        }
        resultat.close();
        state.close();

    }

    public void getCIN_Nom(String text, JComboBox box) throws SQLException {
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("select   cne , nom  from `stagiaire`  where cne LIKE '" + text + "%'");
        String cin, nom;
        while (resultat.next()) {
            cin = resultat.getString("cne");
            nom = resultat.getString("nom");
            box.addItem(cin + " " + nom);
        }
        resultat.close();
        state.close();
    }

    public int countstagiaire() throws SQLException {
        int count = 0;
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("SELECT  COUNT(*)  as  count FROM  `stagiaire` ");
        while (resultat.next()) {
            count = resultat.getInt("count");
        }

        state.close();
        return count;
    }

    public int countadmin() throws SQLException {
        int count = 0;
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("SELECT  COUNT(*)  as  count FROM  `utilisateur` ");
        while (resultat.next()) {
            count = resultat.getInt("count");
        }
        state.close();
        return count;
    }



    public int countabscence() throws SQLException {
        int count = 0;
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("SELECT  COUNT(*)  as  count FROM  `abscence` ");
        while (resultat.next()) {
            count = resultat.getInt("count");
        }
        state.close();
        return count;
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

    public String Rechercher_Stage(String cin) throws SQLException {
        Statement state;
        state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("select    date_fin   from `stage`  WHERE  cne   LIKE '" + cin + "'    ORDER BY date_fin  DESC    LIMIT   1");
        String date_fin = null;
        while (resultat.next()) {
            date_fin = resultat.getString("date_fin");
        }
        resultat.close();
        state.close();
        return date_fin;
    }
}
