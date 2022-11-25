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

public class ventanaCrearReto extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JLabel lNombre;
	JTextField tfNombre;
	JLabel lFechaInicio;
	JTextField tfFechaInicio;
	JLabel lFechaFin;
	JTextField tfFechaFin;
	JLabel lDistancia;
	JTextField tfDistancia;
	JLabel lTiempoObjetivo;
	JTextField tfTiempoObjetivo;
	JButton bCrear;
	JButton bAtras;
	
	
	public ventanaCrearReto() {
		
		setTitle( "CREAR RETO" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setLayout(null);
		JPanel panelInferior = new JPanel(new FlowLayout());
		panelInferior.setBackground(Color.green);
		
		lNombre = new JLabel("Nombre");
		lNombre.setBounds(270, 200, 80, 25);
		panel.add(lNombre);
		
		
		tfNombre = new JTextField();
		tfNombre.setBounds(330, 200, 160, 25);
		panel.add(tfNombre);
		
		lFechaInicio = new JLabel("Fecha Inicio");
		lFechaInicio.setBounds(250, 250, 80, 25);
		panel.add(lFechaInicio);
		
		tfFechaInicio = new JTextField();
		tfFechaInicio.setBounds(330, 250, 190, 25);
		panel.add(tfFechaInicio);
		
		lFechaFin = new JLabel("Fecha Fin");
		lFechaFin.setBounds(260, 300, 80, 25);
		panel.add(lFechaFin);
		
		tfFechaFin = new JTextField();
		tfFechaFin.setBounds(330, 300, 190, 25);
		panel.add(tfFechaFin);
		
		lDistancia = new JLabel("Distancia");
		lDistancia.setBounds(270, 350, 80, 25);
		panel.add(lDistancia);
		
		
		tfDistancia = new JTextField();
		tfDistancia.setBounds(330, 350, 160, 25);
		panel.add(tfDistancia);
		
		lTiempoObjetivo = new JLabel("Tiempo");
		lTiempoObjetivo.setBounds(270, 400, 80, 25);
		panel.add(lTiempoObjetivo);
		
		
		tfTiempoObjetivo = new JTextField();
		tfTiempoObjetivo.setBounds(330, 400, 160, 25);
		panel.add(tfTiempoObjetivo);
		
	
		
		getContentPane().add(panel);
		
		bCrear = new JButton("Crear");
		panelInferior.add(bCrear);
		bAtras = new JButton("Atras");
		panelInferior.add(bAtras);
		getContentPane().add(panelInferior,"South");
		
		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.getGestorVentanas().getVentanaMenu().setVisible(true);
				dispose();
			}
		});
		bCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				long token = main.getUsuarioController().getToken();
				String nombre = tfNombre.getText();
				SimpleDateFormat sdf = new SimpleDateFormat ("dd-MM-yyyy");
				float duracion = Float.parseFloat(tfTiempoObjetivo.getText());
				float distancia = Float.parseFloat(tfDistancia.getText());
				Date fechaInicio;
				Date fechaFin;
				try {
					fechaInicio = sdf.parse(tfFechaInicio.getText());
					fechaFin = sdf.parse(tfFechaFin.getText());
					boolean sesionResult = main.getRetoController().crearReto(token,nombre,fechaInicio, fechaFin, distancia, duracion);
					System.out.println("\t* reto creado: " + sesionResult);
					dispose();
					ventanaMenu v = new ventanaMenu();
					v.setVisible(true);
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("retono");
				}
				
			}
		});
		
		
	}
	/** 
	 * Metodo por programar para ver si las dos contrasenas son iguales, el nombre no este repetido...
	 */
	
}

