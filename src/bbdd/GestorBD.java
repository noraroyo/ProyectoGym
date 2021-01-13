package bbdd;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Esta es la clase GestorBD que sirve para preparar la bbdd en nuestra app Fitness Centre.
 * @author Nora Royo
 * @author Víctor Martínez
 *
 */
public class GestorBD {
	
	private Connection con;
	private final String localizador="jdbc:sqlite:";
	private String nombreBase;
	
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public GestorBD(String nombreBase){
		this.nombreBase=this.localizador + nombreBase;
		
	}
	/**
	 * Este método inicializa la base de datos, una vez haya sido creada la conexión
	 */
	
	public void inicioBD(){
		try{
			AdminBD.crearTablaAdmin(this.con);
			UsuarioGymBD.crearTablaUsuario(this.con);
			FacturaBD.crearTablaFactura(this.con);
			
			AdminBD.insertarAdmin(this.con, "72601036H", "vmtzmtz@gmail.com", "victormtzliz", "programaprobado123");
			AdminBD.insertarAdmin(this.con, "72601036H", "vmtzmtz@gmail.com", "victormtzliz", "programaprobado123");
			AdminBD.insertarAdmin(this.con, "72601036H", "vmtzmtz@gmail.com", "victormtzliz", "programaprobado123");
			AdminBD.insertarAdmin(this.con, "72601036H", "vmtzmtz@gmail.com", "victormtzliz", "programaprobado123");
			AdminBD.insertarAdmin(this.con, "72601036H", "vmtzmtz@gmail.com", "victormtzliz", "programaprobado123");
			
			ArrayList<String> clases=new ArrayList<String>();
			clases.add("zumba");
			clases.add("Spinning");
			
			ArrayList<String> clases2=new ArrayList<String>();
			clases2.add("pilates");
			clases2.add("spinning");
			
			ArrayList<Integer> cantidadDeVezSolicitado = new ArrayList<Integer>();
			cantidadDeVezSolicitado.add(1);
			cantidadDeVezSolicitado.add(3);
			
			ArrayList<Integer> cantidadDeVezSolicitado2 = new ArrayList<Integer>();
			cantidadDeVezSolicitado2.add(4);
			cantidadDeVezSolicitado2.add(2);
			cantidadDeVezSolicitado2.add(6);
			
			UsuarioGymBD.insertarUsuarioGym(this.con, "72601035H", "Pitxford Ordorika", clases, cantidadDeVezSolicitado);
			UsuarioGymBD.insertarUsuarioGym(this.con, "72601034H", "Norix Royus", clases2, cantidadDeVezSolicitado2);
			
			ArrayList<String> clases3=new ArrayList<String>();
			clases3.add("zumba");
			clases3.add("spinning");
			ArrayList<String> clases4=new ArrayList<String>();
			clases4.add("pilates");
			clases4.add("spinning");
			FacturaBD.facturitaUsuario(this.con, 1, "11-11-2011", 34, clases3);
			FacturaBD.facturitaUsuario(this.con, 2, "11-11-2011", 36, clases4);
			
			this.desconectarBD();
			
		} catch(SQLException e){
			System.out.println("Errores.");
		}
	}
	/**
	 * Este método hace la conexión a la bbdd
	 * 
	 */
	public void conectarBD(){
		try{
			this.con=DriverManager.getConnection(this.nombreBase);
		}catch (SQLException e) {
			System.out.println("Error al conectar. " + e.getMessage());
		}
	}
	public static void nuevaBD(String archivo){
		String url="jdbc:sqlite:" + archivo;
		try (Connection con = DriverManager.getConnection(url)) {
			if (con != null) {
				DatabaseMetaData metaData = con.getMetaData();
				System.out.println("El driver name es " + metaData.getDriverName());
				System.out.println("Se ha creado la base de datos");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Este método cierra la conexión con la bbdd
	 * 
	 */
	public void desconectarBD(){
		try {
			if (this.con != null) {

				this.con.close();
			}
		} catch (SQLException ex) {
			System.out.println("No se ha podido desconectar");
		}

	}
	
	public void crearBase(String nombreArchivo){
		String loc = "jdbc:sqlite:" + nombreArchivo;
		
		try (Connection con= DriverManager.getConnection(loc)){
			if(con != null){
				DatabaseMetaData m = con.getMetaData(); //base de datos creada
				System.out.println("Nueva base de datos creada con nombre: " + m.getDriverName());
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}
		

	}

}