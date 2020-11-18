package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bbdd.GestorBD;

public class testGestorBD {

GestorBD g1;

	@Before
	public void setUp() throws Exception {
		
	}
		

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try{
			g1.iniciarBase("CREATE TABLE ADMINISTRADOR (CODIGO NUMBER PRIMARY KEY, NOMBRE VARCHAR2)");
			
			fail("Not yet implemented");
		}
		catch(Exception e)
		{
		
		}
	}
	
	
	
	@Test
	public void testAss() {
		g1.conexionBD("Hola");
		
		//CREAMOS LA TABLA
//		GestorBD.ejecutarSql("CREATE TABLE EMPLEADOS (CODIGO NUMBER PRIMARY KEY, NOMBRE VARCHAR2)");
//		//METEMOS LOS DATOS
//		GestorBD.ejecutarSql("INSERT INTO EMPLEADOS VALUES (1, 'Nora')");
		//SELECCIONAMOS LOS DATOS 		
		ResultSet rs = g1.equals(obj)GestorBD.selectSql("SELECT * FROM EMPLEADOS");
		//COMPARAR
		try {
			assertEquals("Nora", rs.getString("NOMBRE"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		}

}
