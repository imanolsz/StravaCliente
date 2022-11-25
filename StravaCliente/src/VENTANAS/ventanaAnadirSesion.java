package VENTANAS;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dto.usuarioDTO;
import mainCliente.main;

public class ventanaAnadirSesion extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lTitulo;
	JTextField tfTitulo;
	JLabel lDeporte;
	JTextField tfDeporte;
	JLabel lDistancia;
	JTextField tfDistancia;
	JLabel lFechaInicio;
	JTextField tfFechaInicio;
	JLabel lHoraInicio;
	JTextField tfHoraInicio;
	JLabel lDuracion;
	JTextField tfDuracion;
	JButton bAnadir;
	JButton bAtras;
	
	
	public ventanaAnadirSesion() {
		
		setTitle( "ANADIR SESION" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setLayout(null);
		JPanel panelInferior = new JPanel(new FlowLayout());
		panelInferior.setBackground(Color.green);
		
		lTitulo = new JLabel("Titulo");
		lTitulo.setBounds(270, 200, 80, 25);
		panel.add(lTitulo);
		
		
		tfTitulo = new JTextField();
		tfTitulo.setBounds(330, 200, 160, 25);
		panel.add(tfTitulo);
		
		lDeporte = new JLabel("Deporte");
		lDeporte.setBounds(270, 250, 80, 25);
		panel.add(lDeporte);
		
		tfDeporte = new JTextField();
		tfDeporte.setBounds(330, 250, 190, 25);
		panel.add(tfDeporte);
		
		lDistancia = new JLabel("Distancia");
		lDistancia.setBounds(270, 300, 80, 25);
		panel.add(lDistancia);
		
		tfDistancia = new JTextField();
		tfDistancia.setBounds(330, 300, 190, 25);
		panel.add(tfDistancia);
		
		lFechaInicio = new JLabel("Fecha Inicio");
		lFechaInicio.setBounds(257, 350, 80, 25);
		panel.add(lFechaInicio);
		
		
		tfFechaInicio= new JTextField();
		tfFechaInicio.setBounds(330, 350, 160, 25);
		panel.add(tfFechaInicio);
		
		lHoraInicio = new JLabel("Hora inicio");
		lHoraInicio.setBounds(261, 400, 80, 25);
		panel.add(lHoraInicio);
		
		
		tfHoraInicio = new JTextField();
		tfHoraInicio.setBounds(330, 400, 160, 25);
		panel.add(tfHoraInicio);
		
		lDuracion = new JLabel("Duracion");
		lDuracion.setBounds(270, 450, 80, 25);
		panel.add(lDuracion);
		
		
		tfDuracion = new JTextField();
		tfDuracion.setBounds(330, 450, 160, 25);
		panel.add(tfDuracion);
		
		
		getContentPane().add(panel);
		
		bAnadir = new JButton("Anadir");
		panelInferior.add(bAnadir);
		bAtras = new JButton("Atras");
		panelInferior.add(bAtras);
		getContentPane().add(panelInferior,"South");
		
		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.getGestorVentanas().getVentanaMenu().setVisible(true);
				dispose();
			}
		});
		bAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = tfTitulo.getText();
				//DEPORTE
				long token = main.getUsuarioController().getToken();
				float distancia = Float.parseFloat(tfDistancia.getText());
				float duracion =  Float.parseFloat(tfDuracion.getText());
				SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:sss");
				Date fechaInicio;
				try {
					fechaInicio = sdf1.parse(tfFechaInicio.getText());
					Date horaInicio = sdf2.parse(tfHoraInicio.getText());
					boolean sesionResult = main.getSesionController().anadirSesion(token, titulo, duracion, distancia, fechaInicio, horaInicio);
					System.out.println("\t* sesion anadida " + sesionResult);
					dispose();
					ventanaMenu v = new ventanaMenu();
					v.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
}


