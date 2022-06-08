package modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;



public class Taches extends Observable{

	private final int MAX_TACHES_FINIS = 5;
	
	private ArrayList<String> a_faire;
	private ArrayList<String> fini = new ArrayList<String>(MAX_TACHES_FINIS);
	
	public Taches() {
		this.a_faire = new ArrayList<String>();
	}
	
	public void ajouter(String tache) {
		this.a_faire.add(tache);
		this.setChanged();
		this.notifyObservers(false);
	}
	
	public void finir(String s) {
		String remo = null;
		for(String r : this.a_faire) {
			if (r.equals(s)){
				remo = r;
			}
		}
		this.a_faire.remove(remo);
		fini.add("FINI : "+s);
		this.setChanged();
		this.notifyObservers(true);
	}
	
	public ArrayList<String> getToDo(){
		return this.a_faire;
	}
	
	public ArrayList<String> getDone(){
		return this.fini;
	}

	public void reprendre(String s) {
		String remo = null;
		for(String r : this.getDone()) {
			if (r.equals(s)){
				remo = r;
			}
		}
		this.getDone().remove(remo);
		s = s.replace("FINI : ", "");
		a_faire.add(s);
		this.setChanged();
		this.notifyObservers(true);
	}
	
	public void reorder(String s, boolean up) {
		int sIndex = this.a_faire.indexOf(s);
		try {
			Collections.swap(a_faire, sIndex, up ? sIndex-1 : sIndex+1);
		} catch(IndexOutOfBoundsException e) {
			//L'utilisateur tente de faire remonter une tache qui est déjà au début
			//ou descendre la dernière tache
		}
		this.setChanged();
		this.notifyObservers(false);
	}
}
