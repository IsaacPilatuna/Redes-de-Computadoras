//Autores: Isaac Pilatuña & Romel Pumisacho

package ec.edu.epn.redes.cs.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ClienteTCP {
	
	private static  int SERVER_PORT = 9090;

	public static void main(String [] args)  {
		
		boolean flag=true;
		
                
                //Se realizará la petición de la dirección IP hasta que sea ingresada correctamente
		while(flag==true){
			
			String direccionServidor = JOptionPane.showInputDialog("Ingrese la dirección IP del servidor\nEjecutandose en el puerto: "+SERVER_PORT);
			
			
			
			try {
				//Establece la conexión con el servidor mediante un socket
				Socket socketCliente = new Socket(direccionServidor,SERVER_PORT);
				

				//Obtiene el mensaje enviado por el servidor a través del socket
				InputStreamReader inputStream = new InputStreamReader(socketCliente.getInputStream());
				

				//Lee los datos del mensaje de respuesta del servidor ("Ingrese el valor a")
				BufferedReader input = new BufferedReader(inputStream);
                                String respuesta = input.readLine();
				
                                //Imprime los datos del mensaje de respuesta del servidor
                                //Asigna a la variable "a" el valor ingresado por el usuario
                                String a = JOptionPane.showInputDialog(null, respuesta);
				
                                // Prepara la comunicación para la salida de mensajes
                                PrintWriter out = new PrintWriter(socketCliente.getOutputStream(),true);
                                
                                //Envia un mensaje de respuesta al servidor con el valor de la variable "a"
                                out.println(a);
                                
                                //Lee los datos del mensaje de respuesta del servidor ("Ingrese el valor de b")
                                respuesta = input.readLine();
                                
                                //Imprime los datos del mensaje de respuesta del servidor
                                //Asigna a la variable "b" el valor ingresado por el usuario
                                String b = JOptionPane.showInputDialog(null, respuesta);
                                
                                //Envia un mensaje de respuesta al servidor con el valor de la variable "b"
                                out.println(b);
                                
                                //Lee los datos del mensaje de respuesta del servidor ("Su respuesta es: ") con el valor de la suma
                                respuesta = input.readLine();
                                
                                //Muestra la respuesta del servidor al usuario
                                JOptionPane.showMessageDialog(null, respuesta);
                                
                                //Si la dirección IP fue correcta cierra el bucle que repite el ingreso de IP
                               	flag=false;
                                
                                //Cierre del programa
                                System.exit(0);
				
				
				
			} catch (IOException e) {
                                
                                //Error en el intento de conexión con el servidor, repite la petición de la IP
				JOptionPane.showMessageDialog(null, "No se ha podido establecer la conexión\nIntente ingresar la dirección IP nuevamente");
			}
		}
						
	}
	
}
