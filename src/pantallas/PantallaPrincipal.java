package pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logneg.Administrador;
import logneg.Factura;
import logneg.Recepcionista;
import logneg.UsuarioGym;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

import javax.swing.border.LineBorder;

import bbdd.AdminBD;
import bbdd.FacturaBD;
import bbdd.GestorBD;
import bbdd.UsuarioGymBD;

public class PantallaPrincipal extends JFrame {

	private JPanel contentPane;
	private ArrayList <UsuarioGym> usuario;
	private ArrayList <Administrador> admin;
	private ArrayList <Factura> fac;
	private ArrayList <Recepcionista> recep;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal frame = new PantallaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaPrincipal() {
		GestorBD base = new GestorBD("FinessCentre.db");
		base.conectarBD();
		base.inicioBD();
		
		usuario= UsuarioGymBD.todosLosUsuarios(base.getCon());
		admin= AdminBD.todosLosAdministradores(base.getCon());
		fac= FacturaBD.todasLasFacturas(base.getCon());
		//falta igual la base de datos de la recepcionista??
		
		base.desconectarBD();
		
		
		
		
		setBackground(new Color(255, 192, 203));
		setForeground(new Color(255, 182, 193));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdministrador = new JButton("Administrador");
		btnAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAdmin login = new LoginAdmin();
				login.setVisible(true);
				PantallaPrincipal.this.setVisible(false);
			}
		});
		btnAdministrador.setBorder(new LineBorder(new Color(176, 196, 222), 3));
		btnAdministrador.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnAdministrador.setBounds(48, 94, 162, 29);
		contentPane.add(btnAdministrador);
		
		JButton button = new JButton("Usuario");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBorder(new LineBorder(new Color(176, 196, 222), 3));
		button.setFont(new Font("Century Gothic", Font.BOLD, 16));
		button.setBounds(234, 95, 162, 29);
		contentPane.add(button);
	}
}
