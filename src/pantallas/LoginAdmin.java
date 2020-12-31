package pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excepciones.AdminNotFound;
import logneg.Administrador;
import logneg.Factura;
import logneg.UsuarioGym;


import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Nora Royo
 * @author Victor Martinez
 *
 */
public class LoginAdmin extends JFrame {
	private ArrayList<UsuarioGym> usuarioBD = new ArrayList<UsuarioGym>();
	private ArrayList<Administrador> adminBD = new ArrayList<Administrador>();
	private ArrayList<Factura> facturasBD = new ArrayList<Factura>();
	private PantallaPrincipal padre;
	private JPanel contentPane;
	private JTextField textUser;
	private JPasswordField passwordField;
	
	


	/**
	 * Crear el Frame LoginAdmin, es donde los administradores introducen usuario y contraseña.
	 * Se les abre su menu.
	 */
	public LoginAdmin(ArrayList<UsuarioGym> usuario, ArrayList<Factura> fac,ArrayList<Administrador> admin, PantallaPrincipal padre) {
		this.usuarioBD=usuario;
		this.facturasBD=fac;
		this.adminBD=admin;
		this.padre= padre;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textUser = new JTextField();
		textUser.setBounds(62, 80, 146, 26);
		textUser.setFont(new Font("Century Gothic", Font.BOLD, 12));
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(62, 151, 146, 26);
		passwordField.setFont(new Font("Century Gothic", Font.BOLD, 12));
		contentPane.add(passwordField);
		
		JLabel lblUsuario = new JLabel("Usuario ");
		lblUsuario.setBounds(62, 59, 69, 20);
		lblUsuario.setFont(new Font("Century Gothic", Font.BOLD, 16));
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrasenya ");
		
		lblContrasea.setBounds(62, 132, 146, 20);
		lblContrasea.setFont(new Font("Century Gothic", Font.BOLD, 16));
		contentPane.add(lblContrasea);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=textUser.getText();
				String pass=passwordField.getText();
				
				try{
					boolean found=checkLogin(user,pass);
					if (found){
						
					}
			}catch(AdminNotFound e1){
				JOptionPane.showMessageDialog(LoginAdmin.this, e1.getMessage());
			}
			}
		});
		btnOK.setBounds(298, 35, 115, 29);
		contentPane.add(btnOK);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAdmin.this.dispose();
			}
		});
		btnCancelar.setBounds(298, 188, 115, 29);
		contentPane.add(btnCancelar);
	}
	/**
	 * El metodo checkLogin sirve para comprobar si el admin y su contrasenya introducidas
	 * existen en la base de datos y coinciden, o no. Si coincide pues pasa a la siguiente pantalla y sino
	 * mensajito de excepcion.
	 * 
	 * @param usuario el usuario que es introducido
	 * 
	 * @param contrasenya la contrasenya que se ha introducido por pantalla
	 * 
	 * @return devuelve true o false en caso de que exista o no
	 * 
	 * @throws AdminNotFound clase que tiene la excepcion
	 * 
	 */
	public boolean checkLogin(String usuario, String contrasenya) throws AdminNotFound {

		boolean check = false;

		for (Administrador ad : adminBD) {

			if (ad.getNombre().equals(usuario)) {
				check = true;
				break;

			} else {
				if (ad.getContrasenya().equals(contrasenya)) {

					check = true;
					break;
				}

			}
		}

		if (check == true) {

			return true;

		} else {

			throw new AdminNotFound("No existe el usuario o la contrasenya");

		}

	}
}
