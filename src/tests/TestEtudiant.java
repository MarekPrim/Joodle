package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Test;

import modele.Etudiant;
import modele.LectureProfilException;
import modele.SauvegardeProfilException;
import utils.Utils;

public class TestEtudiant {

	@Test
	public void testGetEtudiantNotNull() {
		try {
			assertNotNull(Etudiant.getInstanceEtudiant());
		} catch (LectureProfilException e) {
			// TODO Auto-generated catch block
			fail(e.getLocalizedMessage());
		}
	}
	
	@Test
	public void testGetEtudiantSameTwoInARow() {
		try {
			Etudiant e1 = Etudiant.getInstanceEtudiant();
			Etudiant e2 = Etudiant.getInstanceEtudiant();
			assertEquals(e1, e2);
		} catch (LectureProfilException e) {
			// TODO Auto-generated catch block
			fail(e.getLocalizedMessage());
		}
	}
	
	@Test
	public void testEtudiantAbsentDisque() {
		String cheminDossierJoodle = Utils.addresseDossierDonneesApplication();
		
		// Création du dossier joodle s'il n'existe pas
		File dossier = new File(cheminDossierJoodle);
		assertFalse(dossier.exists());
	}
	
	@Test(expected = SauvegardeProfilException.class)
	public void testSauvegardeEtudiantException() throws SauvegardeProfilException, LectureProfilException {
		Etudiant e1 = Etudiant.getInstanceEtudiant();
		e1.sauvegarderProfilEtudiant();
	}
	
	@Test(expected = LectureProfilException.class)
	public void testLectureEtudiantException() throws LectureProfilException {
		String cheminDossierJoodle = Utils.addresseDossierDonneesApplication();
		
		// Création du dossier joodle s'il n'existe pas
		File dossier = new File(cheminDossierJoodle);
		if(!dossier.exists()) {
			Etudiant.getInstanceEtudiant();
		}
	}
	
	

}
