
package historique;

import java.util.Date;
import java.util.Date;
import java.util.logging.Logger;


public class historique {
    private static int num=0;
    private int id;
    private String Action;
    private Date date;

    public historique(String Action,Date date) {
        this.Action = Action;
        this.date = date;
        id=num++;
    }

    public String getAction() {
        return Action;
    }

    public Date getDate() {
        return date;
    }

    public void setAction(String Action) {
        this.Action = Action;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "historique{" + "Action=" + Action + ", date=" + date + '}';
    }
}
