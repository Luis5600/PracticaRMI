package client;

import java.io.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.EchoInt;

public class EchoRMI {
     
	public static void main(String[] args) {

	        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter stdOut = new PrintWriter(System.out);

	        String input,fin,output;
	        try{
	          Registry registry = LocateRegistry.getRegistry("192.168.100.3",1888);
	          EchoInt eo = (EchoInt) registry.lookup("echo");
	          
	          //Bucle que lee de teclado, invoca el eco y escribe respuesta en la pantalla:
	      	  input="";
	      	  fin="fin";
	      	  output = "";
	      	  while(!input.equals(fin)) {
	      		stdOut.println("Escriba cadena para invocar su eco...");
	      		stdOut.flush();
	          	input = stdIn.readLine(); //Lee cadena introducida por teclado
	  			//EJERCICIO: Invocar para la cadena leida el metodo echo del objeto RMI
	          	output = eo.echo(input);
	          	stdOut.println(output); //Escribe la respuesta del eco en la pantalla
	      		stdOut.flush();
	          }  	
	   
	        }catch(Exception e){
	              System.out.println("Error en el cliente de echo RMI : " + e.getMessage());
	        }
	}

}
