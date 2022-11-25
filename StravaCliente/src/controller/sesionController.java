package controller;


import java.rmi.RemoteException;
import java.util.Date;


import serviceLocator.serviceLocator1;

public class sesionController {
	
	private serviceLocator1 serviceLocator;
	
	public sesionController(serviceLocator1 serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	public boolean anadirSesion(long token,String titulo, float duracion, float distancia, Date fechaInicio, Date horaInicio) {
		try {
			return this.serviceLocator.getService().anadirSesion(token, titulo, duracion, distancia, fechaInicio, horaInicio);
		} catch (RemoteException e) {
			System.out.println("# Error making a bid: " + e);
			return false;
		}
	}

}
