package logneg;
/**
 * Los monitores, recepcionistas y administradores heredan de esta clase TrabajadorGym
 * 
 * @author Nora y Víctor 
 *
 */
public abstract class TrabajadorGym {
	private String dniTrabajador;
	private String emailTrabajador;
	
	public TrabajadorGym(){
		
	}
/**
 * Los atributos de la clase TrabajadorGym
 * 
 * @param dniTrabajador
 * @param emailTrabajador
 */
	public TrabajadorGym(String dni, String email) {
		super();
		this.dniTrabajador = dni;
		this.emailTrabajador = email;
	}
	/**
	 * Este método obtiene el dni del trabajador del gym
	 * 
	 * @return dniTrabajador
	 */
	public String getDni() {
		return dniTrabajador;
	}
	
	/**
	 * Este método fija el dni del trabajador del gym
	 * 
	 * @param dniTrabajador
	 */
	
	public void setDni(String dni) {
		this.dniTrabajador = dni;
	}
	
	/**
	 * Este método obtiene el correo electrónico del trabajador del gym
	 * 
	 * @return email del trabajador
	 */
	public String getEmail() {
		return emailTrabajador;
	}
	
	/**
	 * Este método fija el correo electrónico del trabajador del gym
	 * 
	 * @param emailTrabajador
	 */
	
	public void setEmail(String email) {
		this.emailTrabajador = email;
	}
	
}
