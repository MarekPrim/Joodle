package modele;

import java.util.ArrayList;
import java.util.List;

public class Categorie {
    
    private int id;
    private String nom; //Méthodes de l'ingénieur / UE11
    private List<Matiere> cours;
    
    public Categorie(int id, String nom) {
        this.id = id;
        this.nom = nom;
        this.cours = new ArrayList<Matiere>();
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

	public List<Matiere> getCours() {
		return cours;
	}

	public void setCours(List<Matiere> cours) {
		this.cours = cours;
	}

    public boolean addCours(Matiere cours) {
        return this.cours.add(cours);
    }

    public boolean removeCours(Matiere cours) {
        return this.cours.remove(cours);
    }

    public boolean containsCours(Matiere cours) {
        return this.cours.contains(cours);
    }

    public int getNbCours() {
        return this.cours.size();
    }

    public Matiere getCours(int index) {
        return this.cours.get(index);
    }

    public void setCours(int index, Matiere cours) {
        this.cours.set(index, cours);
    }

    public void clearCours() {
        this.cours.clear();
    }

    public String toString() {
        return "Categorie [id=" + id + ", nom=" + nom + ", cours=" + cours + "]";
    }
    
    

}
