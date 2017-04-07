import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor 
{
	public static void main( String[] arg ) throws IOException 
	{
		int puerto=Integer.parseInt(arg[1]);
		while(true)
		{
			byte[] msg_bytes=new byte[2048];
			
			DatagramSocket dgSocket = new DatagramSocket(puerto);
			DatagramPacket datagram = new DatagramPacket (msg_bytes, msg_bytes.length);
			
			dgSocket.receive(datagram);
		
			//ha llegado un datagrama, para ver los datos se utiliza getDAta()
			String received = new String (datagram.getData());
			System.out.println ("DATOS DEL DATAGRAMA: " + received );
			
			
			//cerramos el socket UDP
			dgSocket.close();
		}
	}
}
