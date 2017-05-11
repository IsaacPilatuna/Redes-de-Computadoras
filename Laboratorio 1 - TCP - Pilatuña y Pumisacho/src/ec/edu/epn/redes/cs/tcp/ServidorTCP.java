//Autores: Isaac Pilatuña & Romel Pumisacho

package ec.edu.epn.redes.cs.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServidorTCP {

	private static final int PORT = 9090;

	public static void main(String[] args) throws IOException {

		// Socket del servidor (Local App-Transport)
		ServerSocket serverSocket = new ServerSocket(PORT);

                //Aviso de que el servidor está corriendo en el puerto asignado
		JOptionPane.showMessageDialog(null,"Servidor ejecutándose en el puerto " + PORT);

		try {

			while (true) {

				// Aceptar la conexión en ese puerto y creo un nuevo Socket para la comunicación remota
				Socket socket = serverSocket.accept();

				try {

					// Prepara la comunicación para la salida de mensajes
					PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                                        
                                        //Envía un mensaje de respuesta para que el cliente devuelva el valor de "a"
					out.println("Ingrese el valor a");
                                        
                                        //Prepara la comunicación para recibir mensajes desde el cliente
                                        InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
                                        BufferedReader input = new BufferedReader(inputStream);

                                        //Lee y asigna a la variable "a", la respuesta del cliente
                                        String a = input.readLine();
                                        double valorA = Double.valueOf(a);
                                        
                                        //Envia un mensaje de respuesta para que el cliente devuelva el valor de "b"
                                        out.println("Ingrese el valor b");
                                        
                                        //Lee y asigna a la variable "b", la respuesta del cliente
                                        String b = input.readLine();
                                        double valorB = Double.valueOf(b);
                                        
                                        //Suma los dos valores y los asigna a la variable c
                                        double c= valorA+valorB;
                                        
                                        //Envia un mensaje de respuesta con el resultado de la suma
                                        out.println("Su resultado es: "+c);                                     
                                        
				} finally {

					socket.close();
				}
			}
		} finally {

			serverSocket.close();

		}

	}

}
