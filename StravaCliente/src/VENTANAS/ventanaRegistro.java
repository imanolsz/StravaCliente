package VENTANAS;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import dto.usuarioDTO;




import mainCliente.main;



public class ventanaRegistro extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lemail;
	JTextField tfemail;
	JLabel lPasword;
	JTextField tfPasword;
	JLabel lRPasword;
	JTextField tfRPasword;
	JLabel lnombre;
	JTextField tfnombre;
	JLabel lfechaNacimiento;
	JTextField tffechaNacimiento;
	JLabel lpeso;
	JTextField tfpeso;
	JLabel laltura;
	JTextField tfaltura;
	JLabel lFrecuenciaCardiacaMaxima;
	JTextField tfFrecuenciaCardiacaMaxima;
	JLabel lFrecuenciaCardiacaReposo;
	JTextField tfFrecuenciaCardiacaReposo;
	JLabel lMensaje1;
	JLabel lMensaje2;
	JButton bRegistrarse;
	JButton bAtras;
	
	
	public ventanaRegistro() {
		
		setTitle( "Registro" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setLayout(null);
		JPanel panelInferior = new JPanel(new FlowLayout());
		panelInferior.setBackground(Color.green);
		
		lemail = new JLabel("Email");
		lemail.setBounds(270, 50, 80, 25);
		panel.add(lemail);
		
		
		tfemail = new JTextField();
		tfemail.setBounds(330, 50, 160, 25);
		panel.add(tfemail);
		
		lPasword = new JLabel("Password");
		lPasword.setBounds(270, 100, 80, 25);
		panel.add(lPasword);
		
		tfPasword = new JTextField();
		tfPasword.setBounds(330, 100, 190, 25);
		panel.add(tfPasword);
		
		lRPasword = new JLabel("Password");
		lRPasword.setBounds(270, 150, 80, 25);
		panel.add(lRPasword);
		tfRPasword = new JTextField();
		tfRPasword.setBounds(330, 150, 190, 25);
		panel.add(tfRPasword);
		
		
		lnombre = new JLabel("Nombre");
		lnombre.setBounds(270, 200, 80, 25);
		panel.add(lnombre);
		tfnombre = new JTextField();
		tfnombre.setBounds(330, 200, 160, 25);
		panel.add(tfnombre);
		
		lfechaNacimiento = new JLabel("fechaN");
		lfechaNacimiento.setBounds(270, 250, 80, 25);
		panel.add(lfechaNacimiento);
		tffechaNacimiento = new JTextField();
		tffechaNacimiento.setBounds(330, 250, 160, 25);
		panel.add(tffechaNacimiento);
		
		
		laltura = new JLabel("Altura");
		laltura.setBounds(270, 300, 80, 25);
		panel.add(laltura);
		tfaltura = new JTextField();
		tfaltura.setBounds(330, 300, 160, 25);
		panel.add(tfaltura);
		
		lpeso = new JLabel("Peso");
		lpeso.setBounds(270, 350, 80, 25);
		panel.add(lpeso);
		tfpeso = new JTextField();
		tfpeso.setBounds(330, 350, 160, 25);
		panel.add(tfpeso);
		
		lFrecuenciaCardiacaMaxima = new JLabel("FrecuenciaCardiacaMaxima");
		lFrecuenciaCardiacaMaxima.setBounds(130, 400, 180, 25);
		panel.add(lFrecuenciaCardiacaMaxima);
		tfFrecuenciaCardiacaMaxima = new JTextField();
		tfFrecuenciaCardiacaMaxima.setBounds(330, 400, 160, 25);
		panel.add(tfFrecuenciaCardiacaMaxima);
		
		lFrecuenciaCardiacaReposo = new JLabel("FrecuenciaCardiacaReposo");
		lFrecuenciaCardiacaReposo.setBounds(130, 450, 180, 25);
		panel.add(lFrecuenciaCardiacaReposo);
		tfFrecuenciaCardiacaReposo = new JTextField();
		tfFrecuenciaCardiacaReposo.setBounds(330, 450, 160, 25);
		panel.add(tfFrecuenciaCardiacaReposo);
		
		
		lMensaje1 = new JLabel("(Repeat)");
		lMensaje1.setForeground(Color.RED); 
		lMensaje1.setBounds(550, 150, 80, 25);
		panel.add(lMensaje1);
		
		lMensaje2 = new JLabel("(opcionales)");
		lMensaje2.setForeground(Color.RED); 
		lMensaje2.setBounds(550, 300, 80, 25);
		panel.add(lMensaje2);
		
		
		getContentPane().add(panel);
		
		bRegistrarse = new JButton("Registrarse");
		panelInferior.add(bRegistrarse);
		bAtras = new JButton("Atras");
		panelInferior.add(bAtras);
		getContentPane().add(panelInferior,"South");
		
		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.getGestorVentanas().getVentanaPrincipal().setVisible(true);
				dispose();
			}
		});
		bRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (registroCorrecto()) {
					//crearusuarioDTO(tfnombre.getText(),tfemail.getText(), tfPasword.getText(), Float.parseFloat(tfpeso.getText()), Float.parseFloat(tfaltura.getText()), Float.parseFloat(tfFrecuenciaCardiacaMaxima.getText()), Float.parseFloat(tfFrecuenciaCardiacaReposo.getText()));
					String nombre = tfnombre.getText(); 
					String email = tfemail.getText();
					System.out.println(email + " label");
					String password =  tfPasword.getText();
					SimpleDateFormat sdf = new SimpleDateFormat ("dd-MM-yyyy");
					float peso = Float.parseFloat(tfpeso.getText());
					float altura = Float.parseFloat(tfaltura.getText());
					float frecuenciaMaxima = Float.parseFloat(tfFrecuenciaCardiacaMaxima.getText());
					float frecuenciaReposo = Float.parseFloat(tfFrecuenciaCardiacaReposo.getText());
					Date fechaNacimiento = null;
					try {
						fechaNacimiento = sdf.parse(tffechaNacimiento.getText());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					/*usuarioDTODTO usuarioDTO = new usuarioDTODTO();
					System.out.println(email + " antes del set");
					usuarioDTO.setEmail(email);
					System.out.println(usuarioDTO.getEmail() + " get");
					usuarioDTO.setPassword(password);
					listausuarioDTOs.add(usuarioDTO);
					fichero f = new fichero();
					f.escribir(usuarioDTO);*/
					boolean resultadoRegistro = main.getUsuarioController().registrarusuario(nombre, email, password,fechaNacimiento, peso, altura, frecuenciaMaxima, frecuenciaReposo);
					System.out.println("\t* usuarioDTO creado: " + resultadoRegistro);
					if (resultadoRegistro) {
						dispose();
						ventanaPrincipal v = new ventanaPrincipal();
						v.setVisible(true);
					}
					// nno ha ido bien
					
				}
			}
		});
	}
	
	public boolean registroCorrecto() {
		boolean correcto = false;
		if (tfemail.getText().isEmpty()) {
			correcto = false;
		}else if (tfnombre.getText().isEmpty()) {
			correcto = false;
		}else if (tfPasword.getText().isEmpty()) {
			correcto = false;
		}else if (tffechaNacimiento.getText().isEmpty()) {
			correcto = false;
		}else {
			correcto = true;
		}
		return correcto;
	}
	//FALTA FECHA NACIMIENTO
	//public void crearusuarioDTO(String nombre, String email, String password, float peso, float altura, float frecuenciaCardiacaMaxima, float frecuenciaCardiacaReposo) {
		
		
	//}
}
