import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Principal 
{
	public static void main( String[] arg ) throws IOException 
	{
		//Argumentos:
		
		String conexion=arg[1];
		InetAddress ip_servidor = InetAddress.getByName(arg[2]);
		int puerto=Integer.parseInt(arg[3]);
		
		System.out.println("Conexion:"+conexion);
		System.out.println("ip:"+ip_servidor);
		System.out.println("puerto:"+puerto);
		
		Cliente cliente=new Cliente(conexion,ip_servidor,puerto);
	}
}
