package tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import modele.Classes;
import modele.NomClasseIntrouvableException;
import utils.Utils;

public class TestClasse {

	@Before
	public void prepare() throws NumberFormatException, IOException {
		Utils.chargerClasse();
	}
	
	@Test(expected = NomClasseIntrouvableException.class)
	public void testCodeClasseException() throws NomClasseIntrouvableException {
		int i = Classes.getCodeClasse("AAAAAASN-A");
	}
	
	@Test
	public void testCodeClasse() throws NomClasseIntrouvableException {
//		Utils.chargerClasse();
		int i = Classes.getCodeClasse("1SN-A");
		assertEquals(i, 124);
	}
	
	@Test
	public void testNomClasse() {
		String nom = Classes.getNomClasse(124);
		assertEquals(nom,"1SN-A");
	}

}
