package pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logneg.Factura;

public class BuscarUnaFactura extends JFrame {

	private JPanel contentPane;
	private ArrayList <Factura> facturas= new ArrayList <Factura>();
	private PantallaAdmin papi;
	


	

	/**
	 * Create the frame.
	 */
	public BuscarUnaFactura(ArrayList<Factura>facturasBD, PantallaAdmin papi, String dato) {
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
}

