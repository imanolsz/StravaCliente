package VENTANAS;

import java.util.ArrayList;

import dto.usuarioDTO;

public class gestorVentanas {
	
	ventanaPrincipal ventanaPrincipal;
	ventanaInicio ventanaInicio;
	ventanaRegistro ventanaRegistro;
	ventanaAnadirSesion ventanaAnadirSesion;
	ventanaCrearReto ventanaCrearReto ;
	ventanaMenu ventanaMenu ;
	ventanaRetosActivos ventanaRetosActivos;
	ventanaRetos ventanaRetos;
	
	public gestorVentanas() {
		ventanaPrincipal = new ventanaPrincipal();
		ventanaInicio = new ventanaInicio();
		ventanaRegistro = new ventanaRegistro();
		ventanaMenu = new ventanaMenu();
		ventanaAnadirSesion = new ventanaAnadirSesion();
		ventanaCrearReto = new ventanaCrearReto();
		ventanaRetosActivos = new ventanaRetosActivos();
		ventanaRetos = new ventanaRetos();
		
	}
	public ventanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}
	public ventanaInicio getVentanaInicio() {
		return ventanaInicio;
	}
	public ventanaAnadirSesion getVentanaAnadirSesion() {
		return ventanaAnadirSesion;
	}
	public ventanaRegistro getVentanaRegistro() {
		return ventanaRegistro;
	}
	public ventanaCrearReto getVentanaCrearReto() {
		return ventanaCrearReto;
	}
	public ventanaMenu getVentanaMenu() {
		return ventanaMenu;
	}
	public ventanaRetosActivos getVentanaRetosActivos() {
		return ventanaRetosActivos;
	}
	public ventanaRetos getVentanaRetos() {
		return ventanaRetos;
	}
}
