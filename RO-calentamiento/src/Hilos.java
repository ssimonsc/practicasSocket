import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Hilos extends Thread
{
	public Hilos(Socket skCliente) throws IOException 
	{
				// Crea objeto 
				OutputStream aux = skCliente.getOutputStream(); 
				DataOutputStream flujo= new DataOutputStream( aux ); 
				flujo.writeUTF( "hola" ); 
				skCliente.close();
	}
	
}
