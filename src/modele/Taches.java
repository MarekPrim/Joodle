package modele;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

import utils.Utils;



public class Taches extends Observable implements Serializable{

	/**
	 * Permet la sérialisation et désérialisation des données pour les sauvegarder dans un fichier.
	 * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
	 */
	private static final long serialVersionUID = -2882072551330105119L;
	
	private final int MAX_TACHES_FINIS = 5;
	
	private ArrayList<String> a_faire;
	private ArrayList<String> fini = new ArrayList<String>(MAX_TACHES_FINIS);
	
	public Taches() throws LectureTachesException {
		lireSurDisque();
	}
	
	public void ajouter(String tache) {
		this.a_faire.add(tache);
		this.setChanged();
		this.notifyObservers(false);
		wrapperSauvegarde();
	}
	
	public void finir(String s) {
		String remo = null;
		for(String r : this.a_faire) {
			if (r.equals(s)){
				remo = r;
			}
		}
		this.a_faire.remove(remo);
		LocalDateTime l = LocalDateTime.now();
		DateTimeFormatter d = DateTimeFormatter.ofPattern("dd MMM uuuu', à' HH':'mm");
		fini.add("FINI ( le "+d.format(l)+" ) : "+s);
		this.setChanged();
		this.notifyObservers(true);
		wrapperSauvegarde();
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
		
		s = s.replace(s.split(":")[0],"").replace(s.split(":")[1], "");
		s = s.replace(":: ", "");
		a_faire.add(s.strip());
		this.setChanged();
		this.notifyObservers(true);
		wrapperSauvegarde();
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
		wrapperSauvegarde();
	}
	
	private void wrapperSauvegarde() {
		try {
			sauvegarderSurDisque();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
 	private void sauvegarderSurDisque() throws IOException {
		String cheminDossierJoodle = Utils.addresseDossierDonneesApplication();
		System.out.println(cheminDossierJoodle);
		
		File dossier = new File(cheminDossierJoodle);
		if (!dossier.exists()) {
			dossier.mkdir();
		}
		
		// Ouverture d'un flux d'écriture
		String cheminFichier = cheminDossierJoodle + File.separator + "a_faires.ser";
		File fichier = new File(cheminFichier);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier));
			 // sérialization de l'objet dans le flux
			oos.writeObject(this.a_faire);
			oos.close();
		} catch (IOException e) {
			throw new IOException("Une erreur est survenue lors de la sauvegarde des taches");
		}
		
		cheminFichier = cheminDossierJoodle + File.separator + "fini.ser";
		fichier = new File(cheminFichier);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier));
			 // sérialization de l'objet dans le flux
			oos.writeObject(this.fini);
			oos.close();
		} catch (IOException e) {
			throw new IOException("Une erreur est survenue lors de la sauvegarde des taches");
		}
	}
	
	private void lireSurDisque() throws LectureTachesException {
		String cheminDossierJoodle = Utils.addresseDossierDonneesApplication();
		// On vérifie que le dossier et le fichier des taches existent 
		File dossier = new File(cheminDossierJoodle);
		String cheminFichier = cheminDossierJoodle + File.separator + "a_faires.ser";
		File fichier = new File(cheminFichier);
		if (dossier.exists() && fichier.exists()) {
			try {
				// Ouverture d'un flux de lecture sur le fichier
				ObjectInputStream ois = new ObjectInputStream (new FileInputStream(fichier));
				
				 // désérialization de l'objet dans le flux
				this.a_faire = (ArrayList<String>)ois.readObject();
				ois.close();
			} catch (IOException | ClassNotFoundException e) {
				throw new LectureTachesException("Une erreur est survenue lors de la lecture des taches", e);
			}
		} else {
			this.a_faire = new ArrayList<String>();
		}
		
		cheminFichier = cheminDossierJoodle + File.separator + "fini.ser";
		fichier = new File(cheminFichier);
		if (dossier.exists() && fichier.exists() && fichier.length()>0) {
			try {
				// Ouverture d'un flux de lecture sur le fichier
				ObjectInputStream ois = new ObjectInputStream (new FileInputStream(fichier));
				
				 // désérialization de l'objet dans le flux
				this.fini = (ArrayList<String>)ois.readObject();
				ois.close();
			} catch (IOException | ClassNotFoundException e) {
				throw new LectureTachesException("Une erreur est survenue lors de la lecture des taches", e);
			}
		}
	}
}
