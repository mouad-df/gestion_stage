package Admin;

import java.util.Random;

public class admin {
    String aleatoire= "abcdefghijklmnopqrstuvwxy123456789/@";
    private static int num=0;
    private int id;
    private String cne;
    private String nom;
    private String tel;
    private String email;
    private String nom_utilisateur;
    private String mot_de_pass;

    public admin(String cne,String nom , String email,String tel,String mot_de_pass) {
        this.cne = cne;
        this.nom = nom;
        this.email = email;
        this.tel=tel;
        this.nom_utilisateur = generatenom_utilisateur();
        this.mot_de_pass = mot_de_pass;
        id=num++;
    }

    public int getId() {
        return id;
    }

    public String getCne() {
        return cne;
    }

    public String getEmail() {
        return email;
    }

    public String getNom_utilisateur() {
        return nom_utilisateur;
    }

    public String getMot_de_pass() {
        return mot_de_pass;
    }

    public String getNom() {
        return nom;
    }

    public String getTel() {
        return tel;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMot_de_pass(String mot_de_pass) {
        this.mot_de_pass = mot_de_pass;
    }

    public String generatenom_utilisateur(){
        String name=this.nom ;
     if(name.contains(" ")){
             name = name.replaceAll(" ", "-");
          }
         String user_name= name+"."+aleatoire.charAt(new Random().nextInt(aleatoire.length()))+""
                 + ""+aleatoire.charAt(new Random().nextInt(aleatoire.length()))+""
                 + ""+aleatoire.charAt(new Random().nextInt(aleatoire.length()));
              return user_name;
    }
    @Override
    public String toString() {
        return "admin{" + "id=" + id + ", cne=" + cne + ", nom=" + nom + ", email=" + email + ", nom_utilisateur=" + nom_utilisateur + ", mot_de_pass=" + mot_de_pass + '}';
    }

}
