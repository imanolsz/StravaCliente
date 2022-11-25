package mainCliente;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import VENTANAS.gestorVentanas;
import dto.usuarioDTO;
import controller.sesionController;
import controller.retoController;
import controller.*;
import serviceLocator.serviceLocator1;

public class main {
private static gestorVentanas gestorVentanas;
private static sesionController sesionController;
private static 	retoController retoController;
private static  usuarioController usuarioController;
private static serviceLocator1 serviceLocator;

	public static void main(String[] args)
	{
		serviceLocator = new serviceLocator1();
		serviceLocator.setService(args[0], args[1], args[2]);
		
		usuarioController = new usuarioController(serviceLocator);	
		sesionController = new sesionController(serviceLocator);			
		retoController = new retoController(serviceLocator);
		
		
		gestorVentanas = new gestorVentanas();
		gestorVentanas.getVentanaPrincipal().setVisible(true);;
		
		
		//args[0] = RMIRegistry IP
		//args[1] = RMIRegistry Port
		//args[2] = Service Name

		
	} 
	
	
	
	public static gestorVentanas getGestorVentanas() {
		return gestorVentanas;
	}
	public static usuarioController getUsuarioController() {
		return usuarioController;
	}
	public static sesionController getSesionController() {
		return sesionController;
	}
	public static retoController getRetoController() {
		return retoController;
	}
	public static serviceLocator1 getServiceLocator() {
		return serviceLocator;
	}
}
