package tests;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bbdd.GestorBD;
import bbdd.UsuarioGymBD;
import logneg.UsuarioGym;
/**
 * Esta clase TestUsuarioGymBD testea la clase UsuarioGymBD
 * 
 * @author Nora
 * @author Victor
 *
 */
public class TestUsuarioGymBD {
	
	private GestorBD gestorBD= null;
	
	/**
	 * Este método inicializa la clase que queremos testear
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		gestorBD= new GestorBD("FitnessCentre.db");
		gestorBD.conectarBD();
	}
	/**
	 * Este método indica lo que hacer después del testeo de la clase
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception{
		gestorBD.desconectarBD();
		
	}
	
//	@Test
//	public void test() throws SQLException{
//		UsuarioGymBD.crearTablaUsuario(gestorBD.getCon());
//		fail("Not implemented");
//	}
	
	@Test
	public void testInsertarUsuarioGym() {	
		UsuarioGymBD.crearTablaUsuario(gestorBD.getCon());
		ArrayList<String> clase = new ArrayList<>();
		clase.add("Zumba");
		clase.add("Yoga");
		clase.add("Pilates");
		
		UsuarioGymBD.insertarUsuarioGym(gestorBD.getCon(), "111111111A", "Nora", clase);
		ArrayList<UsuarioGym> r =UsuarioGymBD.todosLosUsuarios(gestorBD.getCon());
		
		// SUSTITUIR EL FOR POR UNA EXPRESIÓN LAMBDA
		r.forEach (e -> {
			if(e.getDni().equals("111111111A")){
				assertEquals(e.getNombre(), "Nora");
				
				ArrayList<String>claser =e.getNombreClase();
				assertEquals(claser.get(0), "Zumba");
				assertEquals(claser.get(1), "Yoga");
				assertEquals(claser.get(2), "Pilates");				
			}
		}
		);
		
//FOR EACH CONVENCIONAL		
//		for(UsuarioGym usuario : r){
//			if(usuario.getDni().equals("111111111A")){
//				assertEquals(usuario.getNombre(), "Nora");
//				
//				ArrayList<String>claser =usuario.getNombreClase();
//				assertEquals(claser.get(0), "Zumba");
//				assertEquals(claser.get(1), "Yoga");
//				assertEquals(claser.get(2), "Pilates");				
//			}
//		}
		UsuarioGymBD.insertarUsuarioGym(gestorBD.getCon(), "111111111A", null, clase);
		ArrayList<UsuarioGym> re =UsuarioGymBD.todosLosUsuarios(gestorBD.getCon());
		
		
		for (UsuarioGym usuario : r){
			if(usuario.getDni().equals("111111111A")){
				assertNull(usuario.getNombre());
				
				ArrayList<String>claser =usuario.getNombreClase();
				assertNotEquals(claser.get(0), "Zumba");
				assertNotEquals(claser.get(1), "Yoga");
				assertNotEquals(claser.get(2), "Pilates");	
			}
			
		}

	}
	
	@Test
	public void testSeleccionarUsuarioGym() {	
		UsuarioGymBD.crearTablaUsuario(gestorBD.getCon());
		ArrayList<String> clase = new ArrayList<>();
		clase.add("Zumba");
		clase.add("Yoga");
		clase.add("Pilates");
		
		UsuarioGymBD.insertarUsuarioGym(gestorBD.getCon(), "111111111A", "Nora", clase);
		ArrayList<UsuarioGym> r =UsuarioGymBD.todosLosUsuarios(gestorBD.getCon());
		
		
		
		
		for(UsuarioGym usuario : r){
			if(usuario.getDni().equals("111111111A")){
				assertEquals(usuario.getNombre(), "Nora");
				
				ArrayList<String>claser =usuario.getNombreClase();
				assertEquals(claser.get(0), "Zumba");
				assertEquals(claser.get(1), "Yoga");
				assertEquals(claser.get(2), "Pilates");		
		}
		}
		UsuarioGymBD.insertarUsuarioGym(gestorBD.getCon(), "111111111A", null, clase);
		ArrayList<UsuarioGym> re =UsuarioGymBD.todosLosUsuarios(gestorBD.getCon());
		
		
		for (UsuarioGym usuario : r){
			if(usuario.getDni().equals("111111111A")){
				assertNull(usuario.getNombre());
				
				ArrayList<String>claser =usuario.getNombreClase();
				assertNotEquals(claser.get(0), "Zumba");
				assertNotEquals(claser.get(1), "Yoga");
				assertNotEquals(claser.get(2), "Pilates");	
			}
			
		}
	
	}
	
	
	@Test
	public void testBorrarUsuarioGym() {	
		UsuarioGymBD.crearTablaUsuario(gestorBD.getCon());
		ArrayList<String> clase = new ArrayList<>();
		clase.add("Zumba");
		clase.add("Yoga");
		clase.add("Pilates");
		
		UsuarioGymBD.insertarUsuarioGym(gestorBD.getCon(), "111111111A", "Nora", clase);
		UsuarioGymBD.eliminar(gestorBD.getCon(), "111111111A");
		ArrayList<UsuarioGym> r =UsuarioGymBD.todosLosUsuarios(gestorBD.getCon());
		
		for(UsuarioGym usuario : r){
			assertNotEquals(usuario.getDni(), "111111111A");
		}
	
	}

}
