package controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.usuarioDTO;
import serviceLocator.serviceLocator1;

public class usuarioController {
	
	private serviceLocator1 serviceLocator;
	
	private long token = -1;

	
	public usuarioController(serviceLocator1 serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	public boolean registrarusuario(String nombre, String email, String password, Date fechaNacimiento, float peso, float altura, float frecuenciaCardiacaMaxima, float frecuenciaCardiacaReposo) {
		try {
			serviceLocator.setService(nombre, email, password);
			return this.serviceLocator.getService().registrarUsuario(nombre, email, password,fechaNacimiento, peso, altura, frecuenciaCardiacaMaxima, frecuenciaCardiacaReposo);
		} catch (RemoteException e) {
			System.out.println("# Error making a bid: " + e);
			return false;
		}
	}
	public boolean login(String email, String password) {
		try {
			this.token = this.serviceLocator.getService().login(email, password);			
			return true;
		} catch (RemoteException e) {
			System.out.println("# Error during login: " + e);
			this.token = -1;
			return false;
		}
	}
	
	public long getToken() {
		return token;
	}
	
	/*public List<Reto> getRetosActivos(long token) {
		try {
			return this.serviceLocator.getService().getRetosActivos(token);
		} catch (RemoteException e) {
			System.out.println("# Error getting all retos: " + e);
			return null;
		}
	}*/
	
	public void logout() {
		try {
			this.serviceLocator.getService().logout(this.token);
			this.token = -1;
		} catch (RemoteException e) {
			System.out.println("# Error during logout: " + e);
		}
	}
}
