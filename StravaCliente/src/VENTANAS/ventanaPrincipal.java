package VENTANAS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dto.usuarioDTO;
import mainCliente.main;


public class ventanaPrincipal extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JButton bCerrar;
	private JButton bInicio;
	private JButton bRegistrarse;
	private ArrayList<usuarioDTO> listausuarioDTOs = new ArrayList<usuarioDTO>();

	
	
	public ventanaPrincipal(){
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "INICIO" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );
		
		//Paneles principales
		JPanel panelCentral = new JPanel(new BorderLayout());
		panelCentral.setBackground(Color.white);
		JPanel panelInferior = new JPanel(new FlowLayout());
		JPanel panelSuperior = new JPanel(new BorderLayout());
		
		//PanelCentral
		JLabel lMensaje = new JLabel("                           STRAVA");
		lMensaje.setForeground(Color.black);
		lMensaje.setFont(new Font("Serif", Font.PLAIN, 44));
		panelSuperior.add(lMensaje);
		getContentPane().add(panelSuperior,"North");
		
		//PanelInferior
		bInicio = new JButton("Iniciar Sesion");
		panelInferior.add(bInicio);
		bRegistrarse = new JButton("Registrarse");
		panelInferior.add(bRegistrarse);
		bCerrar = new JButton("Cerrar");
		panelInferior.add(bCerrar);
		getContentPane().add(panelInferior,"South");
		
		
		bInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.getGestorVentanas().getVentanaInicio().setVisible(true);
				dispose();
			}	
		});
		bRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.getGestorVentanas().getVentanaRegistro().setVisible(true);
				dispose();
			}
		});
		bCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		//ETIQUETA IMAGEN
		JLabel etiquetaImg = new JLabel(new ImageIcon("FOTOSTRAVA.jpg"));
		etiquetaImg.setBounds(10, 20, 512, 512);
		panelCentral.add(etiquetaImg);
		getContentPane().add(panelCentral,"Center");
		
	}

}
