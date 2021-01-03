package pantallas;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logneg.Administrador;
import logneg.Factura;
import logneg.UsuarioGym;

public class PantallaAdmin extends JFrame{
	private JPanel panel;
	private JList lista;
	private ArrayList<UsuarioGym> usuarioGymBD= new ArrayList<UsuarioGym>();
	private ArrayList<Administrador> administradorBD= new ArrayList<Administrador>();
	private ArrayList<Factura> facturaBD= new ArrayList<Factura>();
	private String usuario;
	private String contra;
	private PantallaPrincipal father;
	
	public PantallaAdmin (String user, String password, ArrayList<UsuarioGym> usuarios, ArrayList<Administrador> admins,
			ArrayList<Factura> facturas, PantallaPrincipal papa){
		usuario=user;
		contra=password;
		this.father=papa;
		this.usuarioGymBD=usuarios;
		this.administradorBD=admins;
		this.facturaBD=facturas;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 552);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
	}

}
