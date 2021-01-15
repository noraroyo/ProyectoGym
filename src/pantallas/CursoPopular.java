package pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import logneg.UsuarioGym;
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
import java.awt.Color;
import java.awt.SystemColor;

/**
 * Esta es la clase CursoPopular que sirve para obtener el curso más solicitado por los usuarios.
 * @author Nora 
 * @author Victor
 *
 */

public class CursoPopular extends JFrame {

	private JPanel contentPane;
	private ArrayList <UsuarioGym> listaUsuarios;
	private PantallaAdmin padre;


	/**
	 * Create the frame.
	 */
	public CursoPopular(ArrayList<UsuarioGym> usuarioGymBD, PantallaAdmin papi) {
		padre=papi;
		listaUsuarios= usuarioGymBD;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblPopular = new JLabel ("Curso más Solicitado");
		lblPopular.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblPopular.setBounds(114, 33, 350, 50);
		contentPane.add(lblPopular);
		
		
		
		JButton btn = new JButton("Volver");
		btn.setFont(new Font("Century Gothic", Font.BOLD, 16));
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
		textPane.setBackground(SystemColor.menu);
		textPane.setFont(new Font("Century Gothic", Font.BOLD, 16));
		textPane.setBounds(90, 125, 420, 85);
		contentPane.add(textPane);

		LinkedList<String> curso = cursoPopCalcular();
		String c = null;
		for (int i = 0; i < curso.size(); i++) {
			c = curso.get(i) + "\n";
		}
		textPane.setText(c);
	}

	public  LinkedList<String> cursoPopCalcular(){
		LinkedList<String> cursos = new LinkedList<String>();
		
		cursos.add("Pilates");
		cursos.add("Zumba");
		cursos.add("Spinning");
		
		LinkedList<Integer> zenbat = new LinkedList<Integer>();
		int contadorPilates = 0;
		int contadorZumba = 0;
		int contadorSpinning =0;
		
		for (UsuarioGym u : listaUsuarios) {
			for (int i=0; i<u.getNombreClase().size(); i++){
				if (u.getNombreClase().get(i).equals("Pilates")){
					contadorPilates = contadorPilates + u.getCantidadDeVecesSolicitado().get(i);
					
				}
				else if (u.getNombreClase().equals("Pilates")){
					contadorPilates = contadorPilates + u.getCantidadDeVecesSolicitado().get(i);
				}
				else if (u.getNombreClase().equals("Zumba")){
					contadorZumba = contadorZumba + u.getCantidadDeVecesSolicitado().get(i);
				}
				else if (u.getNombreClase().equals("Spinning")){
					contadorSpinning = contadorSpinning + u.getCantidadDeVecesSolicitado().get(i);
			}
			}
	}
		zenbat.add(contadorPilates);
		zenbat.add(contadorZumba);
		zenbat.add(contadorSpinning);
		
		//Streams
		
		int cursoMasSolicitado = zenbat.stream().mapToInt(e -> e).max().getAsInt();
		int pos=0;
		
		LinkedList <Integer> batBGehio = new LinkedList<Integer>();
		LinkedList<String> batBGehio1 = new LinkedList<String>();
		
		String curso = null;
		for (int i = 0; i < zenbat.size(); i++){
			if (zenbat.get(i)== cursoMasSolicitado){
				pos= i +1;
				batBGehio.add(pos);
				
			}
		}
		
		for (int i = 0; i < batBGehio.size(); i++){
			if (batBGehio.get(i)== 1){
				curso= "Pilates";
				batBGehio1.add(curso);
				
			}else if (batBGehio.get(i)==2){
				curso = "Zumba";
				batBGehio1.add(curso);
				
			}else if (batBGehio.get(i)==3){
				curso = "Spinning";
				batBGehio1.add(curso);
			}
		}
		return batBGehio1;
	}
	
}