
package Stage;

public class Stage {
    private static int num=0;
    private int id;
    private String type;
    private String date_debut;
    private String date_fin;
    private int duree;
    private String  formation;
    private String projet;
    private String description;

    public Stage(String type,String date_debut, String date_fin, int duree, String projet, String description) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.type=type;
        this.duree = duree;
  
        this.projet = projet;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public int getDuree() {
        return duree;
    }

    public String getFormation() {
        return formation;
    }

    public String getProjet() {
        return projet;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Stage{" + "type=" + type + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", duree=" + duree + ", formation=" + formation + ", projet=" + projet + ", description=" + description + '}';
    }
    
}
