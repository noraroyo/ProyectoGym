package logneg;

import java.util.ArrayList;

/**
 * Esta es la clase de monitores del Fitness Centre
 * 
 * @author Nora y Víctor
 *
 */
public class Monitor extends TrabajadorGym{
	private ArrayList<String> rutinas;
	public Monitor(){
		
	}
	/**
	 * Atributos del monitor
	 * 
	 * @param dniTrabajador
	 * @param emailTrabajador
	 * @param rutinas
	 */
	public Monitor(String dniTrabajador, String emailTrabajador ,ArrayList<String> rutinas) {
		super(emailTrabajador,dniTrabajador);
		this.rutinas = rutinas;
	}
	
	/**
	 * Este método obtiene las rutinas del monitor
	 * 
	 * @return rutinas
	 */
	public ArrayList<String> getRutinas() {
		return rutinas;
	}
	
	/**
	 * Este método fija las rutinas del monitor
	 * 
	 * @param rutinas
	 */
	public void setRutinas(ArrayList<String> rutinas) {
		this.rutinas = rutinas;
	}
	
}
