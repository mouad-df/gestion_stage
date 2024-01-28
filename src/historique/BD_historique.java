
package historique;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.swing.table.Table;
import javax.swing.JLabel;

public class BD_historique {

    Connection cnx;

    public BD_historique(String machine, int port, String bd, String utilisateur, String mdp)
            throws Exception {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        // jdbc:mysql://machine:port/bd?serverTimezone=UTC
        cnx = (Connection) DriverManager.getConnection("jdbc:mysql://" + machine + ":" + port + "/" + bd + "?serverTimezone=UTC",
                utilisateur, mdp);
    }

    public void inserthistorique(int id, String cin, historique histo) throws SQLException {
        int count = 0;
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("SELECT  MAX(id)  as  count FROM  `historique`  ");
        while (resultat.next()) {
            count = resultat.getInt("count");
        }
        state.executeUpdate("INSERT INTO  `historique`   ( `id`,`action`,`time`,`cne`) values ('" + (count + 1) + "','" + histo.getAction() + "','" + new java.sql.Timestamp(new java.util.Date().getTime()) + "','" + cin + "')");
        state.close();
    }
public   void countAllhistorique(String user,JLabel  actions,String  usercin ) throws SQLException {
        int count = 0;
        Statement state = cnx.createStatement();
        if(user.equals("p1520") ||user.equals("Younes Berrada .j6s")){
            ResultSet resultat = state.executeQuery("SELECT  COUNT(*)  as  count FROM  `historique` ");
        while (resultat.next()) {
            count = resultat.getInt("count");
        }
            actions.setText(String.valueOf(count));
        } else {
            ResultSet resultat = state.executeQuery("SELECT  COUNT(*)  as  count FROM  `historique`   WHERE   h.cne = '"+  usercin+"'  ");
        while (resultat.next()) {
            count = resultat.getInt("count");
        }
            actions.setText(String.valueOf(count));
        }
        
        state.close();
        
    }

    public void rechercher(String cin_user, String text, Table table) throws SQLException {
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("SELECT u.user_name,h.action,h.time,h.cne  FROM  `historique`h    JOIN   `utilisateur`  u   on  h.cne=u.cne   WHERE  h.action  LIKE  '"+ text +"%' and h.cne ='" + cin_user + "'");
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
public  int countStage() throws SQLException {
        int count = 0;
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("SELECT  COUNT(*)  as  count FROM  `stage` ");
        while (resultat.next()) {
            count = resultat.getInt("count");
        }
        state.close();
        return count;
    }
    public void gethistoriques(String cin_user, Table table) throws SQLException{
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("select  u.user_name,h.action,h.time,h.cne      from      `historique` h   join    `utilisateur` u   on   h.cne=u.cne   WHERE    h.cne='" + cin_user + "' ORDER BY  h.time  DESC ");
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
    public void getAllhistoriques(Table table) throws SQLException {
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("select  u.user_name,h.action,h.time,h.cne   from    `historique` h ,  `utilisateur` u   WHERE    h.cne=u.cne   ORDER BY  h.time   DESC ");
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
    public void supprimertout() throws SQLException {
        Statement state = cnx.createStatement();
        state.executeUpdate("DELETE  FROM   `historique`");
        state.close();
    }
    public void supprimertoutcin(String user_cin) throws SQLException {
        Statement state = cnx.createStatement();
        state.executeUpdate("DELETE   FROM  `historique`   WHERE    cne = '" +user_cin+ "'");
        state.close();
    }

    public void rechercherparDate(String cin_user, String date1, String date2, Table table) throws SQLException  {
        Statement state;
        state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("SELECT  h.cne,u.user_name,h.action,h.time  FROM  `historique`  h  join `utilisateur` u    on   h.cne=u.cne   WHERE     h.cne='"+cin_user+"'   and   h.time   BETWEEN  '" +date1+"' and  '" +date2+"' ORDER BY  h.time DESC");
        String cin, user_name, action, time;
        while (resultat.next()) {
            cin = resultat.getString("cne");
            user_name = resultat.getString("user_name");
            action = resultat.getString("action");
            time = resultat.getString("time");
            table.addRow(new Object[]{cin, user_name, action, time});
            System.out.println(cin+" "+ time);
        }
        resultat.close();
        state.close();
    }
    public void rechercherparDate1(String date1, String date2, Table table) throws SQLException  {
        Statement state;
        state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("SELECT    h.cne,u.user_name,h.action,h.time  FROM  `historique`  h  join  `utilisateur`  u on h.cne=u.cne WHERE    h.time   BETWEEN  '" +date1+"' and  '" +date2+"'  ORDER BY  h.time DESC");
        String cin, user_name, action, time;
        while (resultat.next()){
            cin = resultat.getString("cne");
            user_name = resultat.getString("user_name");
            action = resultat.getString("action");
            time = resultat.getString("time");
            table.addRow(new Object[]{cin, user_name, action, time});
            System.out.println(cin+" "+ time);
        }
        resultat.close();
        state.close();
    }
    public void recherhcerpardatecurrent(String cin_user, String date1,Table table) throws SQLException{
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("SELECT cne,user_name,action,time  FROM  `historique`  WHERE  cne='"+cin_user+"'  and  time  LIKE '"+date1+"' ");
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
    public void recherhcerpardatecurrent1(String date1,Table table) throws SQLException{
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("SELECT cne,user_name,action,time  FROM  `historique`  WHERE     time  = '"+date1+"' ");
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
    public void rechercher1(String cin ,Table table) throws SQLException{
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("SELECT cne,user_name,action,time  FROM  `historique`  WHERE     cne = '"+cin+"' ");
        String id, user_name, action, time;
        while (resultat.next()) {
           id = resultat.getString("cne");
            user_name = resultat.getString("user_name");
            action = resultat.getString("action");
            time = resultat.getString("time");
            table.addRow(new Object[]{id, user_name, action, time});
        }
        resultat.close();
        state.close();
    }
    public void rechercher_user_admin(String text,Table table) throws SQLException{
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("SELECT u.user_name,h.action,h.time,h.cne  FROM  `historique`h    JOIN   `utilisateur`  u   on  h.cne=u.cne   WHERE  h.action  LIKE  '"+ text +"%'");
        String id, user_name, action, time;
        while (resultat.next()) {
           id = resultat.getString("cne");
            user_name = resultat.getString("user_name");
            action = resultat.getString("action");
            time = resultat.getString("time");
            table.addRow(new Object[]{id, user_name, action, time});
        }
        resultat.close();
        state.close();
    }
}
