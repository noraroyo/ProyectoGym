package pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import excepciones.AdminNotFound;

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


public class CursoPopular extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private ArrayList<UsuarioGym> listaUsuarios=new ArrayList<UsuarioGym>();
	private UsuarioGym usuarioObjetivo=new UsuarioGym();
	private static ArrayList<String> clases=new ArrayList<>();
	private PantallaAdmin padre;


	public ArrayList<UsuarioGym> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<UsuarioGym> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	/**
	 * Create the frame: Su funcion es aportar las clases a las que se ha apuntado el usuarioObjetivo y su numero.
	 */
	public CursoPopular(ArrayList<UsuarioGym> usuarioGymBD, PantallaAdmin papi) {
		this.padre=papi;
		this.listaUsuarios= usuarioGymBD;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblPopular = new JLabel ("Clase más Solicitado");
		lblPopular.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblPopular.setBounds(114, 33, 350, 50);
		contentPane.add(lblPopular);
		
		JLabel lblDniUsuario = new JLabel("DNI:");
		lblDniUsuario.setForeground(Color.BLACK);
		lblDniUsuario.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblDniUsuario.setBounds(104, 121, 72, 20);
		contentPane.add(lblDniUsuario);
		
		textField = new JTextField();
		textField.setBounds(176, 121, 192, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblBusquedaUsuario = new JLabel("BUSQUEDA USUARIO");
		lblBusquedaUsuario.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblBusquedaUsuario.setBounds(190, 27, 246, 26);
		contentPane.add(lblBusquedaUsuario);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String dni=textField.getText();
				ArrayList<String> clases=new ArrayList<String>();
				ArrayList<Integer> cantidadClases=new ArrayList<Integer>();
				try{
					boolean foundy=comprobarUsuario(dni);
					clases=usuarioObjetivo.getNombreClase();
				}
			
			}});
		
		JButton btn = new JButton("Volver");
		btn.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CursoPopular.this.dispose();
				papi.setVisible(true);
			}
		});
		btn.setBounds(50, 350, 110, 30);
		contentPane.add(btn);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CursoPopular.this.dispose();
			}
		});
		btnSalir.setBounds(49, 354, 115, 29);
		contentPane.add(btnSalir);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Century Gothic", Font.BOLD, 16));
		textPane.setBounds(90, 125, 420, 85);
		contentPane.add(textPane);
		

		LinkedList<String> curso = cursoPopCalc();
		String c = null;
		for (int i = 0; i < curso.size(); i++) {
			c = curso.get(i) + "\n";
		}
		textPane.setText(c);
	}
	
	public boolean comprobarUsuario(String dni) throws AdminNotFound{
		boolean found=false;
		for(UsuarioGym u:listaUsuarios){
			if (u.getDni().equals(dni)){
				found=true;
				usuarioObjetivo=u;
			}
		}
		if (found=true){
			return true;
		}else{
			throw new AdminNotFound("Dni no existe");
		}
		
	}

	public  LinkedList<String> cursoPopCalc(){
		LinkedList<String> cursos = new LinkedList<String>();
		
		cursos.add("Pilates");
		cursos.add("Zumba");
		return;
	}
	
	
}
