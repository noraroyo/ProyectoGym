package pantallas;

import java.util.ArrayList;


import javax.swing.JFrame;
import javax.swing.JPanel;

import logneg.ClaseGym;
import logneg.UsuarioGym;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;

/**
 * 
 * @author Nora Royo
 * @author Víctor Martínez
 * 
 *
 */
public class PantallaUsuarioFCentre extends JFrame {
	private JPanel contentPane;
	private ArrayList<ClaseGym> clases=null;
	ArrayList<UsuarioGym> usuariosBD=new ArrayList<UsuarioGym>();
	private PantallaPrincipal father;
	
	public PantallaUsuarioFCentre(ArrayList<UsuarioGym> usuarios, PantallaPrincipal padre){
		getContentPane().setBackground(new Color(240, 248, 255));
		father=padre;
		this.usuariosBD=usuarios;
		getContentPane().setLayout(null);
		
		JLabel lblCursosFitness = new JLabel("CLASES - FITNESS CENTRE");
		lblCursosFitness.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblCursosFitness.setBounds(29, 16, 272, 20);
		getContentPane().add(lblCursosFitness);
		
		JLabel lblPilates = new JLabel("Pilates");
		lblPilates.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblPilates.setBounds(88, 52, 69, 20);
		getContentPane().add(lblPilates);
		
		JLabel label = new JLabel("10");
		label.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		label.setBounds(88, 73, 49, 20);
		getContentPane().add(label);
		
		JButton btnInscribirme = new JButton("Inscribirme");
		btnInscribirme.setBorder(new LineBorder(new Color(0, 51, 102), 1, true));
		btnInscribirme.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnInscribirme.setBounds(37, 99, 105, 27);
		getContentPane().add(btnInscribirme);
		
		JComboBox comboBox1 = new JComboBox();
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"Individual", "En pareja", "Grupo"}));
		comboBox1.setBounds(172, 52, 100, 26);
		getContentPane().add(comboBox1);
		
		btnInscribirme.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					String precio = label.getText();
					int precioNumero= Integer.parseInt(precio);
					String tipo = (String) comboBox1.getSelectedItem();
					ClaseGym compraClases = new ClaseGym("Pilates", precioNumero, tipo);
					clases.add(compraClases);
			}
		});
			
		
		
		JLabel lblZumba = new JLabel("Zumba");
		lblZumba.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblZumba.setBounds(88, 156, 125, 20);
		getContentPane().add(lblZumba);
		
		JLabel label_2 = new JLabel("12");
		label_2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		label_2.setBounds(88, 180, 49, 20);
		getContentPane().add(label_2);
		
		JComboBox comboBox2 = new JComboBox();
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"Individual", "En pareja", "Grupo"}));
		comboBox2.setBounds(172, 154, 100, 26);
		getContentPane().add(comboBox2);
		
		JButton button = new JButton("Inscribirme");
		button.setFont(new Font("Century Gothic", Font.BOLD, 13));
		button.setBorder(new LineBorder(new Color(0, 51, 102), 1, true));
		button.setBounds(37, 207, 105, 27);
		getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String precio= label.getText();
				int precioNumero= Integer.parseInt(precio);
				String tipo = (String) comboBox1.getSelectedItem();
				ClaseGym compraClases = new ClaseGym("Zumba", precioNumero, tipo);
				clases.add(compraClases);
			}
		});
			
		
		JLabel lblSpinning = new JLabel("Spinning");
		lblSpinning.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblSpinning.setBounds(88, 263, 125, 20);
		getContentPane().add(lblSpinning);
		
		JLabel label_4 = new JLabel("9");
		label_4.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		label_4.setBounds(88, 285, 49, 20);
		getContentPane().add(label_4);
		
		JComboBox comboBox3 = new JComboBox();
		comboBox3.setModel(new DefaultComboBoxModel(new String[] {"Individual", "En pareja", "Grupo"}));
		comboBox3.setBounds(172, 261, 100, 26);
		getContentPane().add(comboBox3);
		
		JButton button_1 = new JButton("Inscribirme");
		button_1.setFont(new Font("Century Gothic", Font.BOLD, 13));
		button_1.setBorder(new LineBorder(new Color(0, 51, 102), 1, true));
		button_1.setBounds(29, 317, 105, 27);
		getContentPane().add(button_1);
		
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String precio= label.getText();
				int precioNumero= Integer.parseInt(precio);
				String tipo = (String) comboBox1.getSelectedItem();
				ClaseGym compraClases = new ClaseGym("Spinning", precioNumero, tipo);
				clases.add(compraClases);
			}
		});
			
		
		JButton btnRealizarCompra = new JButton("Realizar compra");
		btnRealizarCompra.setBounds(117, 383, 155, 29);
		getContentPane().add(btnRealizarCompra);
		
		btnRealizarCompra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (clases!= null){
					
					int precioTotalClases =0;
					for(int i=0; i<clases.size();i++){
						precioTotalClases= precioTotalClases + clases.get(i).getPrecioClase();
						
					}
					
					PantallaFacturaClases p = new PantallaFacturaClases(precioTotalClases, clases, usuariosBD);
					p.setVisible(true);
				}
				
			}
		});
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(305, 383, 115, 29);
		getContentPane().add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PantallaUsuarioFCentre.this.dispose();
				father.setVisible(true);
			}
		});
		
		
		
		
		
		
		
		
	}
}
