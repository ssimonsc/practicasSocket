import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Listening extends Thread
{
	int numCliente=0;
	public void tcp() throws IOException
	{
		ServerSocket skServidor = new ServerSocket(); 
		System.out.println("Escucho el puerto:" );
		while(true)
		{
			Socket skCliente = skServidor.accept(); 
			Hilos hilo=new Hilos(skCliente);
			hilo.start();
		}
	}
	
	public void run() 
	{
		try {
			tcp();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
