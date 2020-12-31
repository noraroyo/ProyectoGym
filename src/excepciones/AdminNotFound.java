package excepciones;
/**
 * 
 * @author Victor y Nora y es donde se van a guardas todas las excepciones, en este caso
 * la que en el Login no encuentra al Admin se llama AdminNotFound
 *
 */
public class AdminNotFound extends Exception{
	
	public AdminNotFound(String mensaje){
		super(mensaje);
	}

}
