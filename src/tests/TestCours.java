package tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import utils.ICSParser;
import utils.ListeCours;

public class TestCours {

	ListeCours edt;
	
	@Before
	public void prepare() throws IOException {
		ICSParser parser = new ICSParser();
		edt = parser.recoverData(); 
	}
	
	@Test
	public void testPremierCours() {
		assertEquals(edt.get(0).getSalle(),"C008");
	}

}
