package com.demo.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteRMI {
	
	public static void main(String[] args) throws Exception
	{
		
		// Obtengo referencia a la registry del servidor (IP+PORT)
		Registry reg= LocateRegistry.getRegistry("127.0.0.1", 1099);
		
		// Ubico el objeto remoto identifi cado por "OBJRemoto"
		ObjetoRemoto objRemoto;
		objRemoto = (ObjetoRemoto) reg.lookup("OBJRemoto");
		
		// invoco sus metodos como lo hago con cualquier otro objeto
		String saludo= objRemoto.obtenerSaludo("Geovanny");
		System.out.println(saludo);
	}

}
