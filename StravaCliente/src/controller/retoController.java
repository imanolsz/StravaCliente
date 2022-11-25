package controller;


import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import dto.retoDTO;
import serviceLocator.serviceLocator1;

public class retoController {

private serviceLocator1 serviceLocator;
	
	public retoController(serviceLocator1 serviceLocator) {
		this.serviceLocator = serviceLocator; 
	}
	
	public boolean crearReto(long token,String nombre ,Date fechaInicio, Date fechaFin ,float distancia, float duracion) {
		try {
			return this.serviceLocator.getService().crearReto(token, nombre, fechaInicio, fechaFin, distancia, duracion);
		} catch (RemoteException e) {
			System.out.println("# Error creando reto: " + e);
			return false;
		}
	}
	public List<retoDTO> getRetos() {
		try {
			return this.serviceLocator.getService().getRetos();
		} catch (RemoteException e) {
			System.out.println("# Error getting all retos: " + e);
			return null;
		}
	}
	
	public boolean anadirRetoActivo(long token,String nombre ,Date fechaInicio, Date fechaFin ,float distancia, float duracion) {
		try {
			return this.serviceLocator.getService().anadirRetoActivo( token, nombre , fechaInicio,  fechaFin ,distancia, duracion);
		} catch (RemoteException e) {
			System.out.println("# Error creando reto activo: " + e);
			return false;
		}
	}
}
