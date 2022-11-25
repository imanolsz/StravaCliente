package VENTANAS;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;




import mainCliente.main;

public class ventanaRetosActivos extends JFrame{
	
	
	private static final long serialVersionUID = 1L;
	JButton bAtras;
	JButton bVisualizarRetosActivos;
	
	public ventanaRetosActivos() {
		
		setTitle( "RETOS ACTIVOS" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.white);
		JPanel panelInferior = new JPanel(new FlowLayout());
		panelInferior.setBackground(Color.green);
		

		bVisualizarRetosActivos = new JButton("Visualizar retos");
		panelInferior.add(bVisualizarRetosActivos);
		bAtras = new JButton("Atras");
		panelInferior.add(bAtras);
		getContentPane().add(panelInferior,"South");
		
		
		
		getContentPane().add(panel);
		
		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.getGestorVentanas().getVentanaMenu().setVisible(true);
				dispose();
			}
		});
		bVisualizarRetosActivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JScrollPane scroll = getTabla();
				panel.add(scroll);
				getContentPane().add(panel);
			}
		});
		
	}
	public JScrollPane getTabla() {
		ArrayList<String> titulosLista=new ArrayList<>();
			titulosLista.add("NOMBRE");
			titulosLista.add("FECHA INICIO");
			titulosLista.add("FECHA FIN");
			titulosLista.add("DISTANCIA");
			titulosLista.add("TIEMPO");
		String cabezera [] = new String [titulosLista.size()];
			for (int i = 0; i < cabezera.length; i++) {
				cabezera[i]=titulosLista.get(i);
			}
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
		/*List<Reto> listaRetos = main.getusuarioDTOController().getRetosActivos(main.getusuarioDTOController().getToken());
		String datos [][] = new String [listaRetos.size()][titulosLista.size()];
			for (int x = 0; x < datos.length; x++) {
				datos[x][0] = listaRetos.get(x).getNombre();
				datos[x][1] = dateFormat.format(listaRetos.get(x).getFechaInicio());  
				datos[x][2] = dateFormat.format(listaRetos.get(x).getFechaFin());
				datos[x][3] = Float.toString(listaRetos.get(x).getDistancia());
				datos[x][4] = Float.toString(listaRetos.get(x).getTiempo());
			}
		DefaultTableModel mod = new DefaultTableModel(datos,cabezera);
		JTable tabla = new JTable(mod);
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setBounds(0, 0, 800, 800);
		return scroll;*/
		
		return null; // FIXME
	}
	
}
