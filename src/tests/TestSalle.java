package tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import modele.Salle;
import utils.Utils;

public class TestSalle {
	
	@Before
	public void prepare() throws NumberFormatException, IOException {
		Utils.chargerSalles();
	}

	@Test
	public void testSalleNonExistante() {
		Salle s = Salle.getSalleNomDonne("DONOTEXIST");
		assertNull(s);
	}
	
	@Test
	public void testSalleExistante() {
		Salle s = Salle.getSalleNomDonne("A201");
		assertEquals(s.getBatiment(),'A');
		assertNotEquals(s.getBatiment(), 'C');
		assertEquals(s.getNumeroSalle(), "201");
		assertEquals(s.getNomSalle(),"A201");
		assertEquals(s.getCodeSalle(), 241);
	}

}
