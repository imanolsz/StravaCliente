package VENTANAS;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class fondoMenu extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image imagen;
	
	@Override
	public void paint(Graphics g){
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
	
	public void setImagen(String i){
		imagen = new ImageIcon(getClass().getResource(i)).getImage();
	}
}
