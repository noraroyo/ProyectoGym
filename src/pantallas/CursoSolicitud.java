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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import logneg.ClaseGym;
import logneg.UsuarioGym;
import javax.swing.UIManager;

/**
 * Esta es la clase curso solicitud, que sirve para sacar la cantidad de solicitudes por usuario de los cursos.
 * 
 * @author Nora 
 * @author Victor
 *
 */
public class CursoSolicitud extends JFrame {

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
	 * Create the frame: Su funcion es aportar las clases a las que se ha apuntado el usuarioObjetivo y su numero
	 */
	public CursoSolicitud(ArrayList<UsuarioGym> usuarioGymBD, PantallaAdmin papi) {
		this.padre=papi;
		this.listaUsuarios= usuarioGymBD;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("info"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblDniUsuario = new JLabel("DNI:");
		lblDniUsuario.setForeground(Color.BLACK);
		lblDniUsuario.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblDniUsuario.setBounds(83, 100, 72, 20);
		contentPane.add(lblDniUsuario);
		
		textField = new JTextField();
		textField.setBounds(145, 97, 192, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblBusquedaUsuario = new JLabel("Búsqueda usuario:");
		lblBusquedaUsuario.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblBusquedaUsuario.setBounds(117, 47, 246, 26);
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
					cantidadClases=usuarioObjetivo.getCantidadDeVecesSolicitado();
					
					cantidadClases=mergeSort(cantidadClases, clases);
					
					String textoObjetivo=null;
					for (int i=0;i<clases.size();i++){
						for (int j=0;j<cantidadClases.size();j++){
							textoObjetivo +="-> "+ clases.get(i) + " " + cantidadClases.get(j) + " veces\n";
						}
					}
					JOptionPane.showInputDialog(textoObjetivo);
				}catch (AdminNotFound e) {

					JOptionPane.showMessageDialog(CursoSolicitud.this, e.getMessage());
				}
			
			}});
		
		JButton btn = new JButton("Volver");
		btn.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CursoSolicitud.this.dispose();
				papi.setVisible(true);
			}
		});
		btn.setBounds(145, 159, 99, 35);
		contentPane.add(btn);
		
	}
	/**
	 * ¿Esta el dni o no? Eso nos resuelve
	 * @param dni  el dni del usuarioGym
	 * @return si no existe el dni devolvera false y si existe true
	 * @throws AdminNotFound la clase que salta la excepcion si el usuario no existe
	 */
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
	
	/**
	 * Ordena de menor a mayor las clases a las que se han apuntado los usuarios del Gym y la cantidad
	 * @param arrayInput arrayList de la cantidad de veces de cada clase a la que se han apunto
	 * @param clases arrayList de las clases a las que se han apuntado los usuarios
	 * @return devuelve ordenada la cantidad, es un arrayList
	 */
	public static ArrayList<Integer> mergeSort(ArrayList<Integer> arrayInput,ArrayList<String> clases){
		if (arrayInput.size()==1){
			return arrayInput;
		}else{
			int middle=arrayInput.size()/2;
			ArrayList<Integer> left = new ArrayList<Integer>(middle);
			ArrayList<Integer> right = new ArrayList<Integer>(arrayInput.size() - middle);
			ArrayList<String> leftC = new ArrayList<String>(middle);
			ArrayList<String> rightC = new ArrayList<String>(arrayInput.size() - middle);
			
			for (int i=0;i<middle;i++){
				left.add(arrayInput.get(i));
				leftC.add(clases.get(i));
			}
			for (int i=middle;i< arrayInput.size();i++){
				right.add(arrayInput.get(i));
				rightC.add(clases.get(i));
			}
			left=mergeSort(left,leftC);
			right=mergeSort(right,rightC);
			return merge(left,right,leftC,rightC);
		}
	}
	/**
	 * Ordena de menor a mayor las clases a las que se han apuntado los usuarios del Gym y la cantidad
	 * @param left parte izda del arrayList de la cantidad de clases de los usuarios
	 * @param right parte dcha del arrayList de la cantidad de clases de los usuarios
	 * @param leftC parte izda del arrayList de las clases a las que se han apuntado los usuarios 
	 * @param rightC parte dcha del arrayList de las clases a las que se han apuntado los usuarios
	 * @return devuelve ordenada la cantidad, es un arrayList
	 */
	public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<String> leftC,
			ArrayList<String> rightC) {
		ArrayList<Integer> ayu=new ArrayList<>();
		ArrayList<String> ayuClases=new ArrayList<>();
		
		while (!left.isEmpty() && !right.isEmpty()){
			if (left.get(0)>right.get(0)){
				ayu.add(right.get(0));
				right.remove(0);
				ayuClases.add(rightC.get(0));
				rightC.remove(0);
			}else{
				ayu.add(left.get(0));
				left.remove(0);
				ayuClases.add(leftC.get(0));
				leftC.remove(0);
			}
		}
		
		while (!left.isEmpty()){
			ayu.add(left.get(0));
			left.remove(0);
			ayuClases.add(leftC.get(0));
			leftC.remove(0);
			
		}
		while (!right.isEmpty()){
			ayu.add(right.get(0));
			right.remove(0);
			ayuClases.add(rightC.get(0));
			rightC.remove(0);
			
		}
		
		clases=ayuClases;
		return ayu;
	}
	
	
}
