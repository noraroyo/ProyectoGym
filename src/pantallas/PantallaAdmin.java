package pantallas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import logneg.ClaseGym;
import logneg.UsuarioGym;

import logneg.Administrador;
import logneg.Factura;

/**
 * 
 * @author Nora
 * @author Victor
 *
 */
public class PantallaAdmin extends JFrame{
	private JPanel contentPane;
	private JList list;
	private ArrayList<UsuarioGym> usuarioBD= new ArrayList<UsuarioGym>();
	private ArrayList<Administrador> administradorBD= new ArrayList<Administrador>();
	private ArrayList<Factura> facturaBD= new ArrayList<Factura>();
	private String usuario;
	private String contra;
	private PantallaPrincipal father;
/**
 * Creación del Frame PantallaAdmin
 * @param user
 * @param password
 * @param usuarios
 * @param admins
 * @param facturas
 * @param papa
 */
	public PantallaAdmin (String user, String password, ArrayList<UsuarioGym> usuarios, ArrayList<Administrador> admins,
			ArrayList<Factura> facturas, PantallaPrincipal papa){
		usuario=user;
		contra=password;
		this.father=papa;
		this.usuarioBD=usuarios;
		this.administradorBD=admins;
		this.facturaBD=facturas;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Century Gothic", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String []{"Añadir un Curso", "Modificar un curso", "Curso más solicitado","Email enviar"}) );
		comboBox.setBounds(99, 62, 223, 26);
		contentPane.add(comboBox);
		
		JLabel lblBienvenido = new JLabel("BIENVENIDO");
		lblBienvenido.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblBienvenido.setBounds(99, 34, 223, 20);
		contentPane.add(lblBienvenido);
		
		JList list = new JList();
		list.setBounds(99, 104, 234, 94);
		contentPane.add(list);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				String aukera = (String) comboBox.getSelectedItem();
				if (aukera.equals("Añadir un Curso")) {
					int auk1=1;
					NuevoCurso nc= new NuevoCurso(PantallaAdmin.this, auk1);
					nc.setVisible(true);
					
					
				}else if (aukera.equals("Modificar un curso")) {
					
					
				}else if (aukera.equals("Curso más solicitado")){
					 CursoPopular cp= new CursoPopular(usuarioBD, PantallaAdmin.this);
					 cp.setVisible(true);
					 PantallaAdmin.this.dispose();
				}
				
			}
		});
		
		btnAceptar.setBounds(109, 214, 115, 29);
		contentPane.add(btnAceptar);
	}
	}


