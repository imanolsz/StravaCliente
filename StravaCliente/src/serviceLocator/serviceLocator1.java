package serviceLocator;

import java.rmi.Naming;

import remote.IremoteFacade;



public class serviceLocator1 {
	
	private IremoteFacade service;

	public void setService(String ip, String port, String serviceName) {
		//Activate Security Manager. It is needed for RMI.
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		//Get Remote Facade reference using RMIRegistry (IP + Port) and the service name.
		try {		
			String URL = "//" + "127.0.0.1" + ":" + "1099" + "/" + "Strava";
			this.service = (IremoteFacade) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote facade: " + ex);
		}		
	}

	public IremoteFacade getService() {
		return this.service;
	}
}
