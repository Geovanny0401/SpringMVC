package com.demo.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObjetoRemotoImple extends UnicastRemoteObject implements ObjetoRemoto {

	public ObjetoRemotoImple() throws RemoteException {
		super();
	}

	
	public String obtenerSaludo(String nombre) throws RemoteException {
		return "Hola Mundo RMI: " + nombre;
	}

}
