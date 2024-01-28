
package pièce;

import java.io.FileInputStream;

public class pièce {
    private static int num=0;
    private int  id;
    private String piece;
    private String type;
    private String chemin;

    public pièce(String piece, String type, String chemin) {
        this.piece = piece;
        this.type = type;
        this.chemin = chemin;
    }

    public int getId() {
        return id;
    }

    public String getPiece() {
        return piece;
    }

    public String getType() {
        return type;
    }

    public String getChemin() {
        return chemin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setChemin(String chemin){
        this.chemin = chemin;
    }

    @Override
    public String toString() {
        return "pièce{" + "id=" + id + ", piece=" + piece + ", type=" + type + ", chemin=" + chemin + '}';
    }
    
    
    
}
