package VENTANAS;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dto.usuarioDTO;
import dto.retoDTO;
import mainCliente.main;

public class ventanaRetos extends JFrame implements MouseListener{
	
	
	private static final long serialVersionUID = 1L;
	JButton bAtras;
	JButton bAceptarReto;
	JButton bVisualizarRetos;
	JTable tabla;
	
	
	public ventanaRetos() {
		
		setTitle( "RETOS" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.white);
		JPanel panelInferior = new JPanel(new FlowLayout());
		panelInferior.setBackground(Color.green);
		
		tabla = new JTable();
		tabla.addMouseListener(this);
		bVisualizarRetos = new JButton("Visualizar retos");
		panelInferior.add(bVisualizarRetos);
		bAceptarReto = new JButton("AceptarReto");
		panelInferior.add(bAceptarReto);
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
		
	
		bVisualizarRetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabla = getTabla();
				JScrollPane scroll = new JScrollPane(tabla);
				scroll.setBounds(0, 0, 800, 800);
				panel.add(scroll);
				getContentPane().add(panel);
			}
		});
		
	}
	public JTable getTabla() {
		ArrayList<String> titulosLista=new ArrayList<>();
			titulosLista.add("NOMBRE");
			titulosLista.add("FECHA INICIO");
			titulosLista.add("FECHA FIN");
			titulosLista.add("DISTANCIA");
			titulosLista.add("TIEMPO");
			titulosLista.add("Aceptar");
		String cabezera [] = new String [titulosLista.size()];
			for (int i = 0; i < cabezera.length; i++) {
				cabezera[i]=titulosLista.get(i);
			}
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
		List<retoDTO> listaRetos = main.getRetoController().getRetos();
		String datos [][] = new String [listaRetos.size()][titulosLista.size()];
			for (int x = 0; x < datos.length; x++) {
				datos[x][0] = listaRetos.get(x).getNombre();
				datos[x][1] = dateFormat.format(listaRetos.get(x).getFechaInicio());  
				datos[x][2] = dateFormat.format(listaRetos.get(x).getFechaFin());
				datos[x][3] = Float.toString(listaRetos.get(x).getDistancia());
				datos[x][4] = Float.toString(listaRetos.get(x).getTiempo());
				datos[x][5] = "Aceptar Reto";
			}
		DefaultTableModel mod = new DefaultTableModel(datos,cabezera);
		JTable tabla = new JTable(mod);
		return tabla;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int fila = tabla.rowAtPoint(e.getPoint());
		int columna = tabla.columnAtPoint(e.getPoint());
		if (columna == 5) {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			   String nombre = (String) tabla.getValueAt(tabla.getSelectedRow(), 0);
			   float distancia = Float.parseFloat((String)tabla.getValueAt(tabla.getSelectedRow(), 3));
			   float duracion = Float.parseFloat((String)tabla.getValueAt(tabla.getSelectedRow(), 4));
			   Date fechaInicio;
			   Date fechaFin;
					try {
						fechaInicio = formato.parse( (String) tabla.getValueAt(tabla.getSelectedRow(), 1));
						fechaFin = formato.parse((String) tabla.getValueAt(tabla.getSelectedRow(), 2));
						bAceptarReto.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								boolean resultRetoActivo = main.getRetoController().anadirRetoActivo(main.getUsuarioController().getToken(), nombre , fechaInicio, fechaFin ,distancia, duracion);
								System.out.println("\t* retoActivo anadido: " + resultRetoActivo );
								main.getGestorVentanas().getVentanaMenu().setVisible(true);
								dispose();
							}
						});
		
							
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							System.out.println("\t* retoActivo anadido: false "  );
							
						}
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
