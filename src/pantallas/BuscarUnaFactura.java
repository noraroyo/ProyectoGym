package pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import excepciones.AdminNotFound;
import logneg.Factura;


public class BuscarUnaFactura extends JFrame {

	private JPanel contentPane;
	private JTextField txtFechaFactura;
	private ArrayList <Factura> facturas= new ArrayList <Factura>();
	private PantallaAdmin papi;
	private JLabel lblBuscarUnaFactura;	

	public PantallaAdmin getPapi() {
		return papi;
	}

	public void setPapi(PantallaAdmin papi) {
		this.papi = papi;
	}
	
	/**
	 * Create the frame. La funcion de esta ventana es que permitira al Admin buscar la factura que quiera en cuestion de un clic.
	 */
	public BuscarUnaFactura(ArrayList<Factura>facturasBD, PantallaAdmin papi, String dato) {
		this.facturas=facturasBD;
		this.papi=papi;
		lblBuscarUnaFactura=new JLabel("BUSCAR UNA FACTURA POR FECHA");
		mostrarVentana();
	}
	public void mostrarVentana(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblBuscarUnaFactura.setForeground(Color.WHITE);
		lblBuscarUnaFactura.setFont(new Font("Century Gothic", Font.BOLD, 21));
		lblBuscarUnaFactura.setBounds(106, 31, 456, 57);
		
		contentPane.add(lblBuscarUnaFactura);

		txtFechaFactura = new JTextField();
		txtFechaFactura.setBounds(188, 159, 209, 31);
		contentPane.add(txtFechaFactura);
		txtFechaFactura.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String fechaFactura = txtFechaFactura.getText();
				DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

				ArrayList<Factura> seleccionada = facturas.stream().filter(w -> (formatter.format(w.getDia())).equals(fechaFactura)).collect(Collectors.toCollection(() -> new ArrayList<Factura>()));
				
				if (seleccionada.isEmpty()) {

					BuscarUnaFactura.this.dispose();
					VerFacturaDeseada verFac = new VerFacturaDeseada(BuscarUnaFactura.this, fechaFactura, seleccionada);
					verFac.setVisible(true);

				} else {
					AdminNotFound e1 = null;
					JOptionPane.showMessageDialog(BuscarUnaFactura.this, e1.getMessage());

					}
				}
			
		});
		
		btnOk.setBounds(357, 256, 103, 30);
		contentPane.add(btnOk);

		JLabel lblFecha = new JLabel("FECHA: ");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblFecha.setBounds(50, 138, 103, 70);
		contentPane.add(lblFecha);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ACCION SALIR
				BuscarUnaFactura.this.dispose();
				papi.setVisible(true);

			}
		});
		btnSalir.setBounds(146, 256, 126, 29);
		contentPane.add(btnSalir);

	}
		
		
	
}