package logneg;

import java.util.ArrayList; 

/**
 * Esta es la clase de los usuarios del Fitness Centre
 * 
 * @author Nora y Víctor 
 *
 */

public class UsuarioGym {
	private ArrayList<String> nombreClase;
	private String nombreUsuario;
	private String dniUsuario;
	
	
	public UsuarioGym(){
		
	}
	
	/**
	 * Artibutos de la clase UsuarioGym
	 * 
	 * @param nombreUsuario
	 * @param dniUsuario
	 * @param nombreClase
	 */
	public UsuarioGym(String nombre, String dniUsuario, ArrayList<String> nombreClase) {
		super();
		this.nombreUsuario = nombre;
		this.dniUsuario = dniUsuario;
		this.nombreClase = nombreClase;
	}
	
	
	/**
	 * Este método obtiene el nombre del usuario correspondiente
	 * 
	 * @return nombreUsuario
	 */
	public String getNombre() {
		return nombreUsuario;
	}
	
	/**
	 * Este método fija el nombre del usuario correspondiente
	 * @param nombreUsuario
	 */
	public void setNombre(String nombre) {
		this.nombreUsuario = nombre;
	}
	
	/**
	 * Este método obtiene el dni del usuario correspondiente
	 * @return dniUsuario
	 */
	public String getDni() {
		return dniUsuario;
	}
	
	/**
	 * Este método fija el dni del usuario correspondiente
	 * 
	 * @param dniUsuario
	 */
	public void setDni(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}
	
	/**
	 * Este método obtiene el nombre de la clase solicitado por el usuario correspondiente
	 * 
	 * @return nombreClase
	 */
	public ArrayList<String> getNombreClase() {
		return nombreClase;
	}
	
	/**
	 * Este método fija el nombre de la clase solicitado por el usuario correspondiente
	 * 
	 * @param nombreClase
	 */
	public void setNombreClase(ArrayList<String> nombreClase) {
		this.nombreClase = nombreClase;
	}
	
	
}