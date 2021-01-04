package pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logneg.ClaseGym;
import logneg.UsuarioGym;

/**
 * 
 * @author Nora Royo
 * @author Víctor Martínez
 *
 */
public class PantallaFacturaClases extends JFrame {

	private JPanel contentPane;

private static ArrayList<UsuarioGym> usuariosBD=new ArrayList<UsuarioGym>();
private static ArrayList<ClaseGym> compra= new  ArrayList<ClaseGym>();
	/**
	 * Create the frame.
	 */
	public PantallaFacturaClases(int precioTotalClases, ArrayList<ClaseGym>compraClases , ArrayList <UsuarioGym>usuarios) {
		
		this.usuariosBD= usuarios;
		this.compra= compraClases;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
