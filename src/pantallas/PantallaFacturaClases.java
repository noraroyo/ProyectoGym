package pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import bbdd.GestorBD;
import logneg.ClaseGym;
import logneg.UsuarioGym;
import java.awt.Color;


/**
 * 
 * @author Nora Royo
 * @author Víctor Martínez
 *
 */
public class PantallaFacturaClases extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumFactura;
	private JTextField txtFechaFactura;
	private JTextField txtPrecio;
	private JTextField txtDni;
	private JTextField nombreUsuario;

	private static ArrayList<UsuarioGym> usuariosBD=new ArrayList<UsuarioGym>();
	private static ArrayList<ClaseGym> compra= new  ArrayList<ClaseGym>();
	private static ArrayList<String> nombreClases=new ArrayList<String>();
	private static ArrayList<Integer> cantidadClases=new ArrayList<Integer>();
	private static String dniUsuarioGym;
	private static int cuentaSpinning=0;
	private static int cuentaPilates=0;
	private static int cuentaZumba=0;
	
	/**
	 * Create the frame PantallaFacturaClases que te muestra el precio total y clases a las que se ha apuntado el usuario
	 * @param precioTotalClases
	 * @param compraClases
	 * @param usuarios
	 */
	
	public PantallaFacturaClases(int precioTotalClases, ArrayList<ClaseGym>compraClases , ArrayList <UsuarioGym>usuarios) {
		
		this.usuariosBD= usuarios;
		this.compra= compraClases;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599,699);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFactura = new JLabel("FACTURA");
		
		lblFactura.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblFactura.setBounds(208, 33, 117, 38);
		contentPane.add(lblFactura);

		JLabel lblNumeroFactura = new JLabel("Numero Factura:");
		lblNumeroFactura.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNumeroFactura.setBounds(33, 211, 160, 20);
		contentPane.add(lblNumeroFactura);
		
		txtNumFactura = new JTextField();
		txtNumFactura.setBounds(208, 208, 144, 26);
		contentPane.add(txtNumFactura);
		txtNumFactura.setColumns(10);
		// metemos un numero de factura aleatorio
		int n = 100;
		int numero = (int) (Math.random() * n) + 1;
		txtNumFactura.setText("" + numero);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblFecha.setBounds(33, 273, 69, 20);
		contentPane.add(lblFecha);

		txtFechaFactura = new JTextField();
		txtFechaFactura.setBounds(206, 270, 146, 26);
		contentPane.add(txtFechaFactura);
		txtFechaFactura.setColumns(10);
		Date fecha = new Date();
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String fechaFac = formatter.format(fecha);
		// Añadimos la fecha de hoy
		txtFechaFactura.setText(fechaFac);
		
		JLabel lblPedido = new JLabel("Pedido:");
		lblPedido.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblPedido.setBounds(33, 346, 69, 20);
		contentPane.add(lblPedido);
		
		JLabel lblPrecioTotal = new JLabel("Coste total:");
		lblPrecioTotal.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblPrecioTotal.setBounds(45, 523, 127, 20);
		contentPane.add(lblPrecioTotal);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(208, 520, 69, 26);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		// añadir el coste total
		String total = " " + precioTotalClases;
		txtPrecio.setText(total);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblDni.setBounds(33, 114, 69, 20);
		contentPane.add(lblDni);

		txtDni = new JTextField();
		txtDni.setBounds(206, 111, 146, 26);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblUsu = new JLabel("USUARIO:");
		lblUsu.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblUsu.setBounds(33, 168, 93, 20);
		contentPane.add(lblUsu);

		nombreUsuario = new JTextField();
		nombreUsuario.setBounds(206, 165, 146, 26);
		contentPane.add(nombreUsuario);
		nombreUsuario.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(208, 346, 327, 158);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(textPane);
		scroll.setBounds(208, 346, 327, 158);
		contentPane.add(scroll);
		
		String pedido="";
		for (int i=0;i<compraClases.size();i++){
			pedido+= "-> " +compraClases.get(i).getNombreClase() +", tipo: " + compraClases.get(i).getTipoClase() + " ---> " + compraClases.get(i).getPrecioClase() + "€\n";
		}
		textPane.setText(pedido);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PantallaFacturaClases.this.dispose();
			}
		});
		btnCancelar.setBounds(103, 576, 133, 29);
		contentPane.add(btnCancelar);
		
		JButton btnConfirmarPedido = new JButton("CONFIRMAR PEDIDO");
		btnConfirmarPedido.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnConfirmarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String dni = null;
				String usuario=null;
				dni = txtDni.getText();
				usuario=nombreUsuario.getText();
				dniUsuarioGym = dni;

				if (dni != null && usuario!=null) {

					contarClases();

					for (UsuarioGym u : usuariosBD) {

						if (u.getDni().equals(dniUsuarioGym)) {

							ArrayList<String> clasesAntes = u.getNombreClase();
							ArrayList<Integer> cantidadAntes = u.getCantidadDeVecesSolicitado();
							GestorBD mybd1 = new GestorBD("FitnessCentre.db");
							mybd1.conectarBD();
							bbdd.UsuarioGymBD.eliminar(mybd1.getCon(), dniUsuarioGym);
							mybd1.desconectarBD();

							juntarArrays(clasesAntes, cantidadAntes);

						}

					}
					

					GestorBD mybd = new GestorBD("FitnessCentre.db");
					mybd.conectarBD();
					bbdd.UsuarioGymBD.insertarUsuarioGym(mybd.getCon(), dni, usuario , nombreClases, cantidadClases); 
					mybd.desconectarBD();

				

					GestorBD mybd2 = new GestorBD("FitnessCentre.db");
					mybd2.conectarBD();
					bbdd.FacturaBD.facturitaUsuario(mybd2.getCon(), numero, fechaFac, precioTotalClases, nombreClases);
					mybd2.desconectarBD();

					JOptionPane.showMessageDialog(PantallaFacturaClases.this, "Su pedido se ha procesado correctamente, muchas gracias!!");
					PantallaFacturaClases.this.dispose();

				}

			}
		});
		btnConfirmarPedido.setBounds(276, 576, 216, 29);
		contentPane.add(btnConfirmarPedido);
	}
	/**
	 * contarClases cuenta las clases a las que se ha apuntado el usuario
	 */
	public static void contarClases(){
		cuentaZumba= (int) compra.stream().filter(w -> w.getNombreClase().equals("Zumba")).count();
		cuentaPilates= (int) compra.stream().filter(w -> w.getNombreClase().equals("Pilates")).count();
		cuentaSpinning= (int) compra.stream().filter(w -> w.getNombreClase().equals("Spinning")).count();
		
		if (cuentaZumba !=0){
			nombreClases.add("Zumba");
			cantidadClases.add(cuentaZumba);
			}
		if (cuentaPilates !=0){
			nombreClases.add("Pilates");
			cantidadClases.add(cuentaPilates);
			}
		if (cuentaSpinning !=0){
			nombreClases.add("Spinning");
			cantidadClases.add(cuentaSpinning);
			}
	}
	public static void juntarArrays(ArrayList<String> clasesAntes, ArrayList<Integer> cantidadAntes){
		for (int i=0; i<clasesAntes.size();i++){
			if(clasesAntes.get(i).equals("Pilates")){
				cuentaPilates+=cantidadAntes.get(i);
			}
			if(clasesAntes.get(i).equals("Zumba")){
				cuentaZumba+=cantidadAntes.get(i);
			}
			if(clasesAntes.get(i).equals("Spinning")){
				cuentaSpinning+=cantidadAntes.get(i);
			}
		}
		if (cuentaZumba !=0){
			nombreClases.add("Zumba");
			cantidadClases.add(cuentaZumba);
			}
		if (cuentaPilates !=0){
			nombreClases.add("Pilates");
			cantidadClases.add(cuentaPilates);
			}
		if (cuentaSpinning !=0){
			nombreClases.add("Spinning");
			cantidadClases.add(cuentaSpinning);
			}
	}
}
