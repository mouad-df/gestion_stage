
package Stagiaire;

public class stagiaire {
    private static int num=0;
    private int id;
    private String cne;
    private String nom;
    private String tel;
    private String email;
    private String adresse;
    private String etablissement;
    private String sexe;

    public stagiaire(String cne, String nom, String tel, String email, String adresse, String etablissement) {
        this.cne = cne;
        this.nom = nom;
        this.tel = tel;
        this.email = email;
        this.adresse = adresse;
        this.etablissement = etablissement;
        this.sexe = sexe;
         id=num++;
    }

    

    public String getCne() {
        return cne;
    }

    public String getNom() {
        return nom;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public String getSexe() {
        return sexe;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    @Override
    public String toString() {
        return "stagiaire{" + "cne=" + cne + ", nom=" + nom + ", tel=" + tel + ", email=" + email + ", adresse=" + adresse + ", etablissement=" + etablissement + ", sexe=" + sexe + '}';
    }
  
   
}
