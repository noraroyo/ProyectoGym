package logneg;
/**
 * 
 * @author Nora y Víctor
 * 
 */
public class Administrador extends TrabajadorGym{
	private String nombreAdmin;
	private String contrasenya;
	
	
	public Administrador(){
		super();
	}
	/**
	 * Atributos del administrador
	 * @param dni
	 * 			del Administrador
	 * @param email
	 * 			del Administrador
	 * @param nombreAdmin
	 * 			del Administrador
	 * @param contrasenya
	 * 			del Administrador
	 */
	
	public Administrador(String dni, String email, String nombreAdmin, String contrasenya) {
		super(dni, email);
		this.nombreAdmin = nombreAdmin;
		this.contrasenya = contrasenya;
	}
	
	/**
	 * Este método obtiene el nombre del administrador
	 * 
	 * @return nombreAdmin
	 */
	public String getNombre() {
		return nombreAdmin;
	}
	
	/**
	 * Este método fija el nombre del administrador
	 * @param nombreAdmin
	 */
	public void setNombre(String nombre) {
		this.nombreAdmin = nombre;
	}
	
	/**
	 * Este método obtiene la contraseña del administrador
	 * 
	 * @return contrasenya
	 */
	public String getContrasenya() {
		return contrasenya;
	}
	
	/**
	 * Este método fija la contraseña del administrador
	 * @param contrasenya
	 */
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
	
}
