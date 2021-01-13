package bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import logneg.UsuarioGym;
/**
 * Esta es la clase UsuarioGymBD. Se hayan los metodos de TABLE USUARIOGYM de la bbdd.
 * @author Victor y Nora
 *
 */

public class UsuarioGymBD {
	/**
	 * Este método crea la tabla de usuarios del gym
	 * @param con
	 */
	public static void crearTablaUsuario(Connection con){
		String sql = "CREATE TABLE IF NOT EXISTS USUARIOGYM (\n" 
				+ "    dniUsuario text PRIMARY KEY,\n"
				+ "    nombreUsuario text NOT NULL,\n" 
				+ "    nombreClase text NOT NULL,\n"
				+ "	   cantidadDeVezSolicitado text NOT NULL\n" 
				+ ");";
		try (Statement s=con.createStatement()){
			
			s.execute(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Este método mete usuarios en la tabla de usuarioGym
	 * @param con
	 * @param dniUsuario
	 * @param nombreUsuario
	 * @param nombreClase
	 */
	public static void insertarUsuarioGym(Connection con, String dniUsuario, String nombreUsuario, ArrayList<String> nombreClase,
			ArrayList <Integer>cantidadDeVezSolicitado){
		String sql= "INSERT INTO USUARIOGYM(dniUsuario,nombreUsuario,nombreClase) VALUES(?,?,?)";
		String clases=null;
		String counter= null;
		
		try(PreparedStatement ps=con.prepareStatement(sql)){
			for(int i=0;i<nombreClase.size();i++){
				if (i==nombreClase.size()-1){
					clases+=nombreClase.get(i);
				}
				clases+=nombreClase.get(i)+",";
			}
			for (int i = 0; i < cantidadDeVezSolicitado.size(); i++) {

				if (i == cantidadDeVezSolicitado.get(i) - 1) {
					counter += cantidadDeVezSolicitado.get(i);
				}

				counter += cantidadDeVezSolicitado.get(i) + ",";

			}
			ps.setString(1, dniUsuario);
			ps.setString(2, nombreUsuario);
			ps.setNString(2, clases);
			ps.setString(4, counter);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Este método selecciona los usuarios y nos devuelve una lista 
	 * @param con
	 * @return
	 */
	public static ArrayList<UsuarioGym> todosLosUsuarios(Connection con){
		String sql = "SELECT dniUsuario, nombreusuario, nombreClase, cantidadDeVezSolicitado FROM USUARIOGYM";
		ArrayList<UsuarioGym> listaUsuarios=new ArrayList<UsuarioGym>();
		try(Statement s= con.createStatement(); ResultSet rset=s.executeQuery(sql)){
			while (rset.next()){
				String dniUsuario=rset.getString("dniUsuario");
				String nombreUsuario=rset.getString("nombreUsuario");
				String[] clases=rset.getString("nombreClase").split(",");
				ArrayList<String> listaClases=new ArrayList<String>(Arrays.asList(clases));
				
				String[] veces = rset.getString("cantidadDeVezSolicitado").split(",");
				ArrayList<Integer> listaVecesSoli = new ArrayList<Integer>();

				for (int i = 0; i < veces.length; i++) {
					String obtained = veces[i];
					int when = Integer.parseInt(obtained);
					listaVecesSoli.add(when);
				
				UsuarioGym usuario=new UsuarioGym(nombreUsuario,dniUsuario,listaClases, listaVecesSoli);
				listaUsuarios.add(usuario);
			}
			}
		}
			
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaUsuarios;
		
	}
	/**
	 * Este método elimina usuarios de la tabla usuarioGym
	 * @param con
	 * @param dniUsuario
	 */
	public static void eliminar(Connection con, String dniUsuario){
		String sql = "DELETE FROM USUARIOGYM WHERE dniUsuario = ?";
		try(PreparedStatement ps=con.prepareStatement(sql)){
			ps.setString(1, dniUsuario);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
