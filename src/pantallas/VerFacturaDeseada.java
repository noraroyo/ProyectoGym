package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import logneg.Factura;


public class VerFacturaDeseada extends JFrame {
	
	private JPanel contentPane;
	private PantallaAdmin papi;
	private BuscarUnaFactura mami;
	private String fechaFactura;
	private ArrayList<Factura> seleccionada;
	private JLabel lblFactura;
	
	public VerFacturaDeseada(BuscarUnaFactura padre, String fechaF, ArrayList<Factura> seleccionadas){
		seleccionada=seleccionadas;
		mami=padre;
		papi=padre.getPapi();
		fechaFactura=fechaF;
		lblFactura=new JLabel("FACTURAS: ");
		
		mostrarVentana();
	}
	public void mostrarVentana(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		lblFactura.setForeground(new Color(0, 0, 0));
		lblFactura.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		lblFactura.setBounds(25, 33, 258, 57);
		contentPane.add(lblFactura);
		
		JLabel lblFecha = new JLabel(fechaFactura);
		lblFecha.setBounds(313, 39, 132, 51);
		contentPane.add(lblFecha);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(48, 103, 421, 222);
		
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setBounds(48, 103, 421, 222);
		contentPane.add(scrollPane);
		
		String facturitas=null;
		
		for(Factura fac:seleccionada){
			facturitas=fac.getNumCompraClase()+" ->" + fac.getPrecio() + "\n";
		}
		textPane.setText(facturitas);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				VerFacturaDeseada.this.dispose();
				papi.setVisible(true);
			}
		});
		btnSalir.setBounds(438, 364, 115, 29);
		contentPane.add(btnSalir);
	}
}
