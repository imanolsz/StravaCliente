package VENTANAS;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dto.usuarioDTO;
import mainCliente.main;



public class ventanaInicio extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	JButton bAtras;
	JButton bEntrar;
	JLabel lusuarioDTO;
	JTextField TfusuarioDTO;
	JLabel lPasword;
	JTextField TfPasword;
	
	public ventanaInicio() {
		
		
		setTitle( "Inicio sesion" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.white);
		JPanel panelInferior = new JPanel(new FlowLayout());
		panelInferior.setBackground(Color.yellow);
		
		bEntrar = new JButton("Entrar");
		panelInferior.add(bEntrar);
		bAtras = new JButton("Atras");
		panelInferior.add(bAtras);
		getContentPane().add(panelInferior,"South");
		
		lusuarioDTO = new JLabel("Email");
		lusuarioDTO.setBounds(270, 200, 80, 25);
		panel.add(lusuarioDTO);
		
		TfusuarioDTO = new JTextField();
		TfusuarioDTO.setBounds(330, 200, 160, 25);
		panel.add(TfusuarioDTO);
		
		lPasword = new JLabel("Password");
		lPasword.setBounds(270, 250, 80, 25);
		panel.add(lPasword);
		
		TfPasword = new JTextField();
		TfPasword.setBounds(330, 250, 190, 25);
		panel.add(TfPasword);
		
		getContentPane().add(panel);
		
		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.getGestorVentanas().getVentanaPrincipal().setVisible(true);
				dispose();
			}
		});
		
		bEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					boolean loginResult = main.getUsuarioController().login(TfusuarioDTO.getText(), TfPasword.getText()); 
					System.out.println("\t* usuarioDTO logueado: " + loginResult);
					if(loginResult) {
						main.getGestorVentanas().getVentanaMenu().setVisible(true);
					}
					dispose();
				

				
			}
		});
	}
	
	
}
