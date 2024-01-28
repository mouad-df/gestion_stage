package pièce;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.swing.table.Table;

public class BD_pièce<pièce> {

    Connection cnx;

    public BD_pièce(String machine, int port, String bd, String utilisateur, String mdp)
            throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        // jdbc:mysql://machine:port/bd?serverTimezone=UTC
        cnx = (Connection) DriverManager.getConnection("jdbc:mysql://" + machine + ":" + port + "/" + bd + "?serverTimezone=UTC",
                utilisateur, mdp);
    }

    public Connection getCnx() {
        return cnx;
    }

    public void insertpiece(String id_Stage, pièce piece) throws SQLException {
        int count = 0;
        Statement state = cnx.createStatement();
        state.executeUpdate("INSERT INTO  `piece`  (`id`,`piece`,`type`,`chemin`) values ('" + id_Stage+ "','" + piece.getPiece() + "','" + piece.getType() + "','" + piece.getChemin() + "')");
        state.close();
    }

    public void rechercher(String id_Stage, Table table) throws SQLException {
        Statement state = cnx.createStatement();
        ResultSet resultat = state.executeQuery("SELECT   piece,type,chemin FROM  `piece`  WHERE   id  =  '" + id_Stage + "'");
        String piece, type,chemin;
        
        while (resultat.next()) {
            piece = resultat.getString("piece");
            type = resultat.getString("type");
            chemin = resultat.getString("chemin");
            chemin =chemin.replace("/","\\");
            table.addRow(new Object[]{piece, type,chemin});
        }
        resultat.close();
        state.close();
    }

    public void supprimerpiece(String   cin, String piece, String type, String chemin) {

        String query = "DELETE FROM  piece  WHERE  id = '" + cin + "' and  type = '" + type + "' and chemin = '" + chemin + "' and piece = '" + piece + "'";
        Statement state;
        try {
            state = cnx.createStatement();
            int result = state.executeUpdate(query);
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(BD_pièce.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modifier_piece(String id, String piece, String type, String chemin, String ch) throws SQLException {
        PreparedStatement statement = cnx.prepareStatement("UPDATE  piece  SET   piece=?, type=?,   chemin=?   WHERE    piece=? and cin=?");
        statement.setString(1, piece);
        statement.setString(2, type);
        statement.setString(3, chemin);
        statement.setString(4, ch);
        statement.setString(5, id);
        statement.executeUpdate();
        //Statement state = cnx.createStatement();
        //state.execute("UPDATE  admin  SET  cne="+cin+", nom="+nom+", email="+email+",telphone="+tel+" ,mot_de_pass="+mot_de_pass+" WHERE cne= "+anccin); 
        statement.close();
    }

}
