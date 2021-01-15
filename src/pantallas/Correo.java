package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Esta es la clase Correo que sirve para enviar correos electrónicos. Hace uso de una librería externa javax.mail.
 * @author Nora 
 * @author Victor
 *
 */
public class Correo extends JFrame {
	private JPanel contentPane;
	private JTextField txtLoEnvia;
	private JTextField txtDestino;
	private JTextField txtCuerpoMensaje;
	private JLabel lblRedactor;
	private JLabel lblReceptor;
	private JLabel lblCuerpo;
	
	/**
	 * Esta clase permitira al Admin enviar correos
	 * @param papa es la clase anterior, en nuestro caso PantallaAdmin
	 * @param usuario nombre del Admin
	 * @param password su contraseña
	 */
	public Correo (PantallaAdmin papa, String usuario, String password){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 483);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 218, 185));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnviarCorreo = new JLabel("Enviar Email");
		lblEnviarCorreo.setFont(new Font("Century Gothic", Font.BOLD, 33));
		lblEnviarCorreo.setForeground(new Color(0, 0, 0));
		lblEnviarCorreo.setBounds(144, 29, 348, 49);
		contentPane.add(lblEnviarCorreo);

		txtLoEnvia = new JTextField();
		txtLoEnvia.setBounds(133, 113, 289, 33);
		contentPane.add(txtLoEnvia);
		txtLoEnvia.setColumns(10);

		txtDestino = new JTextField();
		txtDestino.setBounds(133, 162, 289, 33);
		contentPane.add(txtDestino);
		txtDestino.setColumns(10);

		txtCuerpoMensaje = new JTextField();
		txtCuerpoMensaje.setBounds(132, 215, 290, 113);
		txtCuerpoMensaje.setColumns(10);
		
		//Convertimos el scrollpane en txt para facilitar
		JScrollPane scroll = new JScrollPane();
		scroll.setColumnHeaderView(txtCuerpoMensaje);
		scroll.setBounds(132, 215, 290, 113);
		contentPane.add(scroll);
		
		JButton btnEnviar = new JButton("Send");
		btnEnviar.setFont(new Font("Century Gothic", Font.BOLD, 17));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// aCCION ENVIAR

				String loEnvia = txtLoEnvia.getText();
				String destino = txtDestino.getText();
				String cuerpoMensaje = txtCuerpoMensaje.getText();

				if (loEnvia != null || destino != null || cuerpoMensaje != null) {

					JOptionPane.showMessageDialog(null, "No se puede enviar el correo si no rellenas todos los campos");

				} else {
					
					if(Correo.enviarGmail(usuario, password, destino, cuerpoMensaje)==true) {
						
						JOptionPane.showMessageDialog(null, "Email enviado con éxito");
						
							papa.setVisible(true);
							Correo.this.dispose();
						
					}
					else {
						JOptionPane.showMessageDialog(null, "No se ha podido enviar el email");
					}

				}

			}
		});
		btnEnviar.setBounds(407, 366, 115, 29);
		contentPane.add(btnEnviar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Century Gothic", Font.BOLD, 17));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				papa.setVisible(true);
				Correo.this.dispose();
			}
		});
		btnCancelar.setBounds(42, 366, 115, 29);
		contentPane.add(btnCancelar);
		
		lblRedactor = new JLabel("From: ");
		lblRedactor.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblRedactor.setBounds(27, 118, 91, 20);
		contentPane.add(lblRedactor);
		
		lblReceptor = new JLabel("To: ");
		lblReceptor.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblReceptor.setBounds(27, 171, 105, 20);
		contentPane.add(lblReceptor);
		
		lblCuerpo = new JLabel("Body: ");
		lblCuerpo.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblCuerpo.setBounds(27, 215, 90, 70);
		contentPane.add(lblCuerpo);
	}
	public static boolean enviarGmail(String user, String contra, String destinatario, String cuerpo) {

		Properties emailProperties = new Properties();
		emailProperties.put("mail.smtp.host", "smtp.gmail.com");
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.port", "465");
		emailProperties.put("mail.smtp.socketFactory.port", "465");
		emailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		emailProperties.put("mail.debug", "true");
		emailProperties.put("mail.smtp.user", user);
		emailProperties.put("mail.smtp.clave", contra);

		Session session = Session.getDefaultInstance(emailProperties);
		MimeMessage message = new MimeMessage(session);
		try {
			BodyPart texto = new MimeBodyPart();
			texto.setText(cuerpo);

			MimeMultipart m = new MimeMultipart();
			m.addBodyPart(texto);

			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
			message.setContent(m);

			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", user, contra);
			transport.sendMessage(message, message.getAllRecipients());

			transport.close();
			return true;

		} catch (MessagingException me) {

			return false;
		}

	}

}
