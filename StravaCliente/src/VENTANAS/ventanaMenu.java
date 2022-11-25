package VENTANAS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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



public class ventanaMenu extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton bCrearReto;
	JButton bAnadirSesion;
	JButton bVerRetosActivos;
	JButton bVerRetos;
	JButton bSalir;
	
	
	
	//private Thread t;
	
	public ventanaMenu() {
	
	setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
	setTitle( "MENU" );
	setSize( 800, 600 );
	setLocationRelativeTo( null );
	JPanel panelInferior = new JPanel(new FlowLayout());
	panelInferior.setBackground(Color.orange);
	JPanel panelCentral = new JPanel(new BorderLayout());
	panelCentral.setBackground(Color.white);
	bCrearReto = new JButton("Crear reto");
	panelInferior.add(bCrearReto);
	bAnadirSesion = new JButton("Anadir sesion");
	panelInferior.add(bAnadirSesion);
	bVerRetosActivos = new JButton("Ver Retos Activos"); 
	panelInferior.add(bVerRetosActivos);
	bVerRetos = new JButton("Ver Retos");
	panelInferior.add(bVerRetos);
	bSalir = new JButton("Salir");
	panelInferior.add(bSalir);
	getContentPane().add(panelInferior,"South");
	
	
	
	bVerRetos.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			main.getGestorVentanas().getVentanaRetos().setVisible(true);
			dispose();
		}
	});

	bSalir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			logout();
			main.getGestorVentanas().getVentanaPrincipal().setVisible(true);
			dispose();
		}
	});
	
	bCrearReto.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			main.getGestorVentanas().getVentanaCrearReto().setVisible(true);
			dispose();
		}
	});
	bAnadirSesion.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			 ventanaAnadirSesion v = new ventanaAnadirSesion();
			 v.setVisible(true);
			dispose();
		}
	});
	bVerRetosActivos.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			main.getGestorVentanas().getVentanaRetosActivos().setVisible(true);
			dispose();
		}
	});
	JLabel etiquetaImg = new JLabel(new ImageIcon("images.jpg"));
	etiquetaImg.setBounds(10, 20, 512, 512);
	panelCentral.add(etiquetaImg);
	getContentPane().add(panelCentral,"Center");
	
	}
	public void logout() {
		System.out.println(" - Logout from the server...");		
		main.getUsuarioController().logout();
		System.out.println("\t* Logout success!");		
	}
}
