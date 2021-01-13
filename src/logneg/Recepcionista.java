package logneg;
/**
 * Esta es la clase de l@s trabajadores, recepcionistas del Fitness Centre. Esta clase es hija de TrabajadorGym.
 * 
 * @author Nora y V�ctor
 *
 */
public class Recepcionista extends TrabajadorGym{
	private int numCompraClase;
	private int sueldo;
	
	public Recepcionista(){
		
	}
	/**
	 * Atributos del recepcionista
	 * 
	 * @param numCompraClase
	 */
	public Recepcionista(String dniTrabajador, String emailTrabajador ,int numCompraClase, int sueldo) {
		super(dniTrabajador, emailTrabajador);
		this.numCompraClase = numCompraClase;
		this.sueldo=sueldo;
	}
	public int getSueldo() {
		return sueldo;
	}
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	/**
	 * Este m�todo obtiene el n�mero de facturas (compra de una clase del gym)
	 * 
	 * @return numCompraClase
	 */
	public int getNumCompraClase() {
		return numCompraClase;
	}
	/**
	 * Este m�todo fija el n�mero de facturas (compra de una clase del gym)
	 * 
	 * @param numCompraClase
	 */
	public void setNumCompraClase(int numCompraClase) {
		this.numCompraClase = numCompraClase;
	}
	
}
