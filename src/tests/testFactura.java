package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logneg.Factura;

/**
 * Esta es la clase que testea algunos métodos de la clase Factura
 * @author Nora
 * @author Víctor
 * 
 */
public class TestFactura {
	
	Factura fact1;
	Factura fact2;
	
	/**
	 * Inicializa la clase que tenemos que testear
	 */
	@Before
	public void setUp(){
		fact1= new Factura(15, 2);
		fact2= new Factura (10, 3);
		
	}
	@After
	public void tearDown() throws Exception{
		
		
	}
	/**
	 * Este método sirve para testear los Getters de precio y numCompraCLase de la clase Factura. 
	 * El método devuelve los atributos pedidos.
	 */
	@Test
	public void testGets(){
		assertEquals(15, fact1.getPrecio());
		assertEquals(2, fact1.getNumCompraClase());
		
		assertEquals(10, fact2.getPrecio());
		assertEquals(3, fact2.getNumCompraClase());
		
		
	}
	/**
	 * Este método sirve para testear los Setters de precio y numCompraCLase de la clase Factura. 
	 * Cambia los valores y comprueba si se han modificado correctamente.
	 */

	@Test
	public void testSets(){
		fact1.setNumCompraClase(4);
		fact1.setPrecio(8);
		assertEquals(4, fact1.getNumCompraClase());
		assertEquals(8, fact1.getPrecio());
		
		fact2.setNumCompraClase(5);
		fact2.setPrecio(9);
		assertEquals(5, fact2.getNumCompraClase());
		assertEquals(9, fact2.getPrecio());
	
	}
	
}
