package bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import logneg.Factura;
/**
 * 
 * @author Victor y Nora
 *
 */

public class FacturaBD {
	/**
	 * Este método crea la tabla facturaUsuario
	 * @param con
	 */
	public static void crearTablaFactura(Connection con)  {
		
		String sql = "CREATE TABLE IF NOT EXISTS facturaUsuario (\n"
				+ "    numCompraClase integer PRIMARY KEY,\n"
				+ "    dia text NOT NULL,\n" 
				+ "    precio integer NOT NULL,\n" 
				+ "    nombreClase text NOT NULL,\n"
				+ ");";

		try (Statement s = con.createStatement()) {

			s.execute(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		} 
	}
	/**
	 * Este metodo mete las facturas en la tabla FacturasUsuario
	 * @param con
	 * @param numCompraClase
	 * @param dia
	 * @param precio
	 * @param clases
	 */
	public static void facturitaUsuario(Connection con, int numCompraClase, String dia, int precio, ArrayList<String> clases){
		String sql="INSERT INTO facturaUsuario(numCompraClase,dia,precio,clases) VALUES(?,?,?,?)";
		
		String nombreClase=null;
		
		try(PreparedStatement ps=con.prepareStatement(sql)){
			for(int i=0;i<clases.size();i++){
				if(i==clases.size()-1){
					nombreClase+=clases.get(i);
				}
				nombreClase+=clases.get(i)+",";
			}
			ps.setInt(1, numCompraClase);
			ps.setString(2, dia);
			ps.setInt(3, precio);
			ps.setString(4, nombreClase);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Este método seleciona las facturas y devuelve la lista de facturas
	 * @param con
	 * @return
	 */
	public static ArrayList<Factura> todasLasFacturas(Connection con){
		String sql="SELECT numCompraClase,dia,precio,clases FROM facturaUsuario";
		ArrayList<Factura> listaFacturas=new ArrayList<Factura>();
		String dia=null;
		int numCompraClase=0;
		int precio=0;
		ArrayList<String> listaClases=new ArrayList<String>();
		
		try(Statement s=con.createStatement(); ResultSet rset=s.executeQuery(sql)){
			while (rset.next()){
				numCompraClase=rset.getInt("numCompraClase");
				dia=rset.getString("dia");
				precio=rset.getInt("precio");
				
				String[] clases=rset.getString("clases").split(",");
				listaClases=(ArrayList<String>) Arrays.asList(clases);
			}
			Date diaFac=null;
			try{
				
				diaFac=(Date) new SimpleDateFormat("dd-MM-yyyy").parse(dia);
			} catch(ParseException e){
				
				e.printStackTrace();
				
			}
			Factura factura=new Factura(listaClases, diaFac, precio, numCompraClase);
			listaFacturas.add(factura);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaFacturas;
	}


}
