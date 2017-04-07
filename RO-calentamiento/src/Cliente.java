import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Cliente
{
	//Variables:
	static final String HOST = "localhost"; 
	static final String msg = "Hola pepito";
	static final byte[] msg_bytes=msg.getBytes();
	
	public Cliente(String conexion,InetAddress ip_servidor,int puerto) throws IOException
	{
				switch(conexion)
				{
					case "udp":
						udp(ip_servidor, puerto);
						break;
					case "tcp":
						tcp(ip_servidor,puerto);
						
						break;
				} 
}
	public void udp(InetAddress ip_servidor,int puerto) throws IOException
	{
		DatagramSocket dgSocket = new DatagramSocket();
		
		//enviamos el datagrama
		DatagramPacket datagram = new DatagramPacket (msg_bytes, msg_bytes.length,ip_servidor,puerto);
		dgSocket.send(datagram);
		
		//esperamos que nos llegue respuesta desde el servidor

		dgSocket.receive(datagram);

		//ha llegado un datagrama, para ver los datos se utiliza getDAta()

		String received = new String (datagram.getData());
		System.out.println ("DATOS DEL DATAGRAMA: " + received );

		//cerramos el socket UDP

		dgSocket.close();
	}
	public void tcp(InetAddress ip_servidor,int puerto)
	{
		Socket cliente;
		try 
		{
			cliente = new Socket (ip_servidor, puerto);
			
		//Salida
		PrintStream salida; 
		try 
		{
			salida = new PrintStream(cliente.getOutputStream() ); 
			System.out.println("Esperando respuesta..."); 
			
		} catch( IOException e ) 
		{
			System.out.println("Error en la peticion"); 
		}
		
		//Entrada
		DataInputStream entrada; 
		try 
		{
			entrada = new DataInputStream( cliente.getInputStream() ); 
			System.out.println("Respuesta recibida"); 
		} catch( IOException error ) 
		{
			System.out.println("Error en la respuesta" ); 
		}
		} catch (UnknownHostException e1) 
		{
			e1.printStackTrace();
		} catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		
	}
}

