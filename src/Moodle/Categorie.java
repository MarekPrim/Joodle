package Moodle;

import java.util.ArrayList;
import java.util.List;

public class Categorie {
    
    private int id;
    private String nom; //Méthodes de l'ingénieur / UE11
    private List<Cours> cours;
    
    public Categorie(int id, String nom) {
        this.id = id;
        this.nom = nom;
        this.cours = new ArrayList<Cours>();
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

	public List<Cours> getCours() {
		return cours;
	}

	public void setCours(List<Cours> cours) {
		this.cours = cours;
	}

    public boolean addCours(Cours cours) {
        return this.cours.add(cours);
    }

    public boolean removeCours(Cours cours) {
        return this.cours.remove(cours);
    }

    public boolean containsCours(Cours cours) {
        return this.cours.contains(cours);
    }

    public int getNbCours() {
        return this.cours.size();
    }

    public Cours getCours(int index) {
        return this.cours.get(index);
    }

    public void setCours(int index, Cours cours) {
        this.cours.set(index, cours);
    }

    public void clearCours() {
        this.cours.clear();
    }

    public String toString() {
        return "Categorie [id=" + id + ", nom=" + nom + ", cours=" + cours + "]";
    }
    
    

}
