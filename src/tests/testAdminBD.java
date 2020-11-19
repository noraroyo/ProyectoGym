package tests;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bbdd.AdminBD;
import bbdd.GestorBD;
import logneg.Administrador;

/**
 * Esta clase testAdminBD testea la clase AdminBD
 * 
 * @author Nora
 * @author Victor
 *
 */
public class testAdminBD {
	GestorBD gestor;
	
	/**
	 * Este método inicializa la clase que queremos testear
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception{
		
		gestor = new GestorBD("FitnessCentre.db");
		gestor.conectarBD();
	}
	/**
	 * Este método indica lo que hacer después del testeo de la clase
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception{
		
		gestor.desconectarBD();
	}
	
/**
 * Este método es el primer test
 * @throws SQLException
 */
	@Test
	public void test1() throws SQLException{
		AdminBD.insertarAdmin(gestor.getCon(), "11111111A", "nora@gmail.com", "nora", "noradeusto");
		fail("Error con la tabla ADMINISTRADOR");
	}
	/**
	 * Este método hace un test del insert
	 * @throws SQLException
	 */
	@Test
	public void test2() throws SQLException{
		AdminBD.crearTablaAdmin(gestor.getCon());
		AdminBD.insertarAdmin(gestor.getCon(), "22222222B", "n@gmail.com", "nori", "royo");
		ArrayList<Administrador> beenRead =AdminBD.todosLosAdministradores(gestor.getCon());
		for(Administrador admin : beenRead){
			
			if (admin.getDni().equals("22222222B")){
				assertEquals(admin.getContrasenya(),"royo");
				assertEquals(admin.getEmail(),"n@gmail.com");
				assertEquals(admin.getNombre(),"nori");
			}	
		}
	
	}
	/**
	 * Este método hace un test de select
	 * @throws SQLException
	 */
	@Test
	public void test3() throws SQLException{
		AdminBD.crearTablaAdmin(gestor.getCon());
		AdminBD.insertarAdmin(gestor.getCon(), "22222222B", "n@gmail.com", "nori", "royo");
		ArrayList<Administrador> beenRead =AdminBD.todosLosAdministradores(gestor.getCon());
		for(Administrador admin : beenRead){
			
			if (admin.getDni().equals("22222223C")){
				assertNotEquals(admin.getContrasenya(),"royi");
				assertNotEquals(admin.getEmail(),"no@gmail.com");
				assertNotEquals(admin.getNombre(),"noru");
			}	
		}
		
	}

}
