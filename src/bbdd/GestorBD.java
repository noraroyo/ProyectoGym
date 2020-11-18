package bbdd;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta es la clase GestorBD que sirve para preparar la bbdd en nuestra app Fitness Centre.
 * @author Nora Royo
 * @author Víctor Martínez
 *
 */
public class GestorBD {
	private String nombreBase;
	private Connection con;
	
	/**
	 * Este método inicializa la base de datos, una vez haya sido creada la conexión
	 */
	public void iniciarBase(){
		AdminBD.crearTablaAdmin(con);
		
		try {
			AdminBD.insertarAdmin(con, "11111111A", "nora@gmail.com", "nora", "nora1");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Este método hace la conexión con la bbdd.
	 * @param nombreBD
	 */
	public void conexionBD(String nombreBase){
		this.nombreBase = nombreBase; 
		boolean bdHay= false;
		File bd = new File(this.nombreBase+".db");

		if(bd.exists() && !bd.isDirectory()) { 
			bdHay = true;
		}
		try 
		{
			con = DriverManager.getConnection("jdbc:sqlite:"+nombreBase+".db");
		} 
		catch (SQLException e) 
		{
        	e.printStackTrace();
		}
    
		if(!bdHay)
		{
			iniciarBase();
		}
		
	}
	/** 
	 * Este método cierra la conexión con la BBDD.
	 * 
	 */
	public void desconexionBD(){
		try {
			this.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al desconectar la BBDD");
			e.printStackTrace();
		}
	}
}
