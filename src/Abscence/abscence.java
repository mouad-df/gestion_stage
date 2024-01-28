
package Abscence;

import java.util.Date;


public class abscence{
    
    private static int num=0;
    private int id;
    private String cause;
    private Date date_debut;
    private Date  date_fin;   
    private int  nbr_jour;   

    public abscence(String cause, Date date_debut, Date date_fin) {
        this.cause = cause;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        id=num++;
    }

    public abscence(String cause, int nbr_jour) {
        this.cause = cause;
        this.nbr_jour = nbr_jour;
    }

    public String getCause() {
        return cause;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public int getNbr_jour() {
        return nbr_jour;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public void setNbr_jour(int nbr_jour) {
        this.nbr_jour = nbr_jour;
    }

    @Override
    public String toString() {
        return "abscence{" + "id=" + id + ", cause=" + cause + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", nbr_jour=" + nbr_jour + '}';
    }  
}
