package bbdd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Esta es la clase FacturaBD. Se hayan los metodos de TABLE FACTURA de la bbdd.
 * @author Victor y Nora
 *
 */

public class FacturaBD {
	/**
	 * 
	 * @param con
	 */
	public static void createFacturaTable(Connection con)  {
		
		String sql = "CREATE TABLE IF NOT EXISTS FACTURA (\n"
				+ "    numCompraClase integer PRIMARY KEY,\n"
				+ "    dia text NOT NULL,\n" 
				+ "    precio integer NOT NULL,\n" 
				+ "    nombreClase text NOT NULL,\n"
				+ ");";

		try (Statement s = con.createStatement()) {
			// create a new table
			s.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}


}
