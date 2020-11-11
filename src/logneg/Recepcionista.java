package logneg;
/**
 * Esta es la clase de l@s trabajadores, recepcionistas del Fitness Centre. Esta clase es hija de TrabajadorGym.
 * 
 * @author Nora y Víctor
 *
 */
public class Recepcionista extends TrabajadorGym{
	private int numCompraClase;
	
	public Recepcionista(){
		
	}
	/**
	 * Atributos del recepcionista
	 * 
	 * @param numCompraClase
	 */
	public Recepcionista(String dniTrabajador, String emailTrabajador ,int numCompraClase) {
		super(dniTrabajador, emailTrabajador);
		this.numCompraClase = numCompraClase;
	}
	/**
	 * Este método obtiene el número de facturas (compra de una clase del gym)
	 * 
	 * @return numCompraClase
	 */
	public int getNumCompraClase() {
		return numCompraClase;
	}
	/**
	 * Este método fija el número de facturas (compra de una clase del gym)
	 * 
	 * @param numCompraClase
	 */
	public void setNumCompraClase(int numCompraClase) {
		this.numCompraClase = numCompraClase;
	}
	
}
