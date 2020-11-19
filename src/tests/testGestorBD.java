package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bbdd.GestorBD;

public class testGestorBD {

GestorBD gestorBD;

	@Before
	public void setUp() throws Exception {
		gestorBD = new GestorBD("Fitness.bd");
		
		
	}
		

	@After
	public void tearDown() throws Exception {
		
	}
	

	@Test
	public void test() {
		try{
			gestorBD.inicioBD();
			
			fail("Not yet implemented");
		}
		catch(Exception e)
		{
		
		}
	}
	
	
	
	@Test
	public void testAss() {
	
	}
	}
		
