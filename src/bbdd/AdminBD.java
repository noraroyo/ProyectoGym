package bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logneg.Administrador;

/**
 * Esta es la clase AdministradorBD. Se hayan los metodos de TABLE ADMINISTRADORES de la bbdd.
 * 
 * @author Víctor 
 * @author Nora
 */
public class AdminBD {
/**
 * Metodo para crear tabla ADMINISTRADOR, donde se encuentran los datos de los administradores.
 * @param con
 */
	public static void crearTablaAdmin(Connection con){
		String sql = "CREATE TABLE IF NOT EXISTS ADMINISTRADOR (\n"
				+ "    dniTrabajador text PRIMARY KEY,\n"
				+ "    emailTrabajador text NOT NULL,\n" 
				+ "    nombreAdmin text NOT NULL,\n" 
				+ "    contrasenya text NOT NULL\n" + ");";
		
		try (Statement s= con.createStatement();){
			
			s.execute(sql);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		/** 
		 * Método que para nuestra bbdd, inserta administradores
		 * @param con
		 * @param emailTrabajador
		 * @param dniTrabajador
		 * @param nombreAdmin
		 * @param contrasenya
		 */
		public static void insertarAdmin(Connection con, String dniTrabajador, String emailTrabajador, String nombreAdmin, String contrasenya) throws SQLException {
			String sql= "INSERT INTO ADMINISTRADOR(dniTrabajador, emailTrabajador, nombreAdmin, contrasenya)	VALUES(?,?,?,?)";
			
			try(PreparedStatement ps= con.prepareStatement(sql)){
				ps.setString(1, dniTrabajador);
				ps.setString(2, emailTrabajador);
				ps.setString(3, nombreAdmin);
				ps.setString(4, contrasenya);
				
				ps.execute();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
				
			}
		public static ArrayList<Administrador> todosLosAdministradores(Connection con){
			String sql= "SELECT dniTrabajador,emailTrabajador,nombreAdmin,contrasenya FROM ADMINISTRADOR";
			ArrayList<Administrador> listaAdministradores=new ArrayList<Administrador>();
			
			try (Statement s=con.createStatement(); ResultSet rset=s.executeQuery(sql)){
				while (rset.next()){
					Administrador admin=new Administrador(rset.getString("dniTrabajador"),rset.getString("emailTrabajador"),rset.getString("nombreAdmin"),rset.getString("contrasenya"));
					listaAdministradores.add(admin);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listaAdministradores;
			
		}
		}
		
		
		
	
	

