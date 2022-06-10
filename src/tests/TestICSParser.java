package tests;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import utils.ICSParser;

public class TestICSParser {

	ICSParser parser;
	
	@Before
	public void prepare() throws IOException {
		parser = new ICSParser();
	}
	
	@Test
	public void testICSValide() {
		assertTrue(parser.isValidICSFile());
	}
	
	@Test(expected=IOException.class)
	public void testLectureException() throws IOException {
		parser = new ICSParser(new File("./donotexit.ics"));
	}

}
