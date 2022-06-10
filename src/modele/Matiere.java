package modele;

public class Matiere {

    /*
    Exemple :
    Nom : CPO
    id = $url/id=1187
    intitule : Conception et Programmation Objet
    */

    private int id;
    private String nom;
    private String intitule;

    public Matiere(int id, String nom, String intitule) {
        this.id = id;
        this.nom = nom;
        this.intitule = intitule;
    }

    public int getId() {
        return id;
    }
    
    public String getNom() {
        return nom;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String toString() {
        return "Matiere [id=" + id + ", nom=" + nom + ", intitule=" + intitule + "]";
    }

}
