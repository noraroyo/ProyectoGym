package logneg;

/**
 * 
 * @author Nora y Víctor
 *
 */

public class ClaseGym {
	private String nombreClase;
	private int precioClase;
	private String tipoClase;
	
	/**
	 * Los atributos clase ClaseGym 
	 * @param nombreClase          
	 * @param precioClase
	 * @param tipoClase
	 */
	
	public ClaseGym(String nombreClase, int precioClase, String tipoClase) {
	
		this.nombreClase = nombreClase;
		this.precioClase = precioClase;
		this.tipoClase = tipoClase;
	}
	
	/**
	 * Este método obtiene nombre de la clase del Fitness Centre
	 * 
	 * @return nombreClase
	 */

	public String getNombreClase() {
		return nombreClase;
	}
	
	/**
	 * Este método fija nombre de la clase
	 * 
	 * @param nombreClase
	 */

	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}
	
	/**
	 * Este método obtiene precio de la clase de gym correspondiente
	 * 
	 * @return precioClase
	 */

	public int getPrecioClase() {
		return precioClase;
	}
	
	/**
	 * Este método fija precio de la clase de gym correspondiente
	 * 
	 * @param precioClase 
	 * 
	 */
	public void setPrecioClase(int precioClase) {
		this.precioClase = precioClase;
	}
	
	/**
	 * Este método obtiene el tipo de la clase del gym correspondiente
	 * 
	 * @return tipoClase 
	 */

	public String getTipoClase() {
		return tipoClase;
	}
	/**
	 * Este método fija el tipo de clase del gimnasio
	 * 
	 * @param tipoClase
	 */

	public void setTipoClase(String tipoClase) {
		this.tipoClase = tipoClase;
	}

	public ClaseGym(){
		
	}
	
	

}
