package pantallas;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import logneg.ClaseGym;
import logneg.UsuarioGym;

public class PantallaUsuarioFCentre extends JFrame {
	private JPanel contentPane;
	private ArrayList<ClaseGym> clases=null;
	ArrayList<UsuarioGym> usuariosBD=new ArrayList<UsuarioGym>();
	private PantallaPrincipal father;
	
	public PantallaUsuarioFCentre(ArrayList<UsuarioGym> usuarios, PantallaPrincipal padre){
		father=padre;
		this.usuariosBD=usuarios;
	}
}
