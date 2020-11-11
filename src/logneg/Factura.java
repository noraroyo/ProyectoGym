package logneg;

import java.util.ArrayList;
import java.util.Date;

/**
 * Esta es la clase de las facturas por la compra de clases en el Fitness Centre
 * 
 * @author Nora y Víctor
 *
 */
public class Factura {
	private ArrayList<String> nombreClase;
	private Date dia;
	private int precio;
	private int numCompraClase;
	public Factura(){
		
	}
	
	/**
	 * Atributos de la factura
	 * 
	 * @param nombreClase
	 * @param dia
	 * @param precio
	 * @param numCompraClase
	 */
	public Factura(ArrayList<String> nombreClase, Date dia, int precio, int numCompraClase) {
		super();
		this.nombreClase = nombreClase;
		this.dia = dia;
		this.precio = precio;
		this.numCompraClase = numCompraClase;
	}
	
	/**
	 * Este método obtiene el nombre de la clase
	 * 
	 * @return
	 */
	public ArrayList<String> getNombreClase() {
		return nombreClase;
	}
	
	/**
	 * Este método fija el nombre de la clase
	 * @param nombreClase
	 */
	public void setNombreClase(ArrayList<String> nombreClase) {
		this.nombreClase = nombreClase;
	}
	
	/**
	 * Este método obtiene el día de la clase
	 * 
	 * @return
	 */
	public Date getDia() {
		return dia;
	}
	
	/**
	 * Este método fija el día de la clase
	 * 
	 * @param dia
	 */
	public void setDia(Date dia) {
		this.dia = dia;
	}
	
	/**
	 * Este método obtiene el precio de la clase
	 * 
	 * @return precio
	 */
	public int getPrecio() {
		return precio;
	}
	
	/**
	 * Este método fija el precio de la clase
	 * 
	 * @param precio
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	/**
	 * Este método obtiene el numero de compra de la clase
	 * 
	 * @return
	 */
	public int getNumCompraClase() {
		return numCompraClase;
	}
	
	/**
	 * Este método fija el numero de compra de la clase
	 * 
	 * @param numCompraClase
	 */
	public void setNumCompraClase(int numCompraClase) {
		this.numCompraClase = numCompraClase;
	}
	
	
}
