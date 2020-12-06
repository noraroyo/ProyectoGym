package tests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bbdd.GestorBD;

public class testGestorBD {

GestorBD gestorBD;

/**
 * Este método inicializa la clase que queremos testear: crea el link e inicializa
 * @throws Exception
 */
	@Before
	public void setUp() throws Exception {
		gestorBD = new GestorBD("Fitness.bd");
		gestorBD.crearBase("Fitness.bd");
		gestorBD.conectarBD();
		
	}
	/**
	 * Este método cierra la conexión con la base de datos, después del testeo de la clase
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception{
		gestorBD.desconectarBD();
		
	}
	
/**
 * Este método testea la clase GestorBD
 */
	@Test
	public void testGestor(){
		fail("Sin implementar");
	}
	

	
}
