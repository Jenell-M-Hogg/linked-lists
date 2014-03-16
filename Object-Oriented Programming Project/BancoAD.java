import java.io.*;
import java.util.StringTokenizer;

public class BancoAD
{
	private BufferedReader brArchivoEntrada;
	private PrintWriter pwArchivoSalida;
	
	public String capturar(String str)
	{
		int sw = 1;
		StringTokenizer st;
		String cta = "", datos = "", stringReader = "";
		try
		{
			//1) Abrir el Archivo
			pwArchivoSalida = new PrintWriter(new FileWriter("Clientes.txt", true));
			
			//2) Guardar y Escribir Archivo
			pwArchivoSalida.println(str);
		
			//2) Cerrar el Archivo
			pwArchivoSalida.close();
		
		}
		catch(IOException ioe)
		{
			System.out.println("Error: " + ioe);
		}

		return "Datos:" + str;
	}
	
	public String consultar()
	{
		String datos = "";
		try
		{
			//1) Abrir el Archivo
			brArchivoEntrada = new BufferedReader(new FileReader("Clientes.txt"));
			
			//2) Procesar datos
			while(brArchivoEntrada.ready())
			{
				datos = datos + brArchivoEntrada.readLine() + "\n";
			}
			
			//3) Cerrar el Archivo
			brArchivoEntrada.close();
		}
		catch(IOException ioe)
		{
			System.out.println("Error: " + ioe);
			datos = "ERROR";
		}

		return datos;
	}
	
	public String consultarCuenta(String cuenta)
	{
		int sw = 0;
		String datos = "", str = "", cta = "";
		StringTokenizer st;
		boolean encontrado = false;
		
		try
		{
			//1) Abrir Archivo
			brArchivoEntrada = new BufferedReader(new FileReader ("Clientes.txt"));
			
			//2) Procesar Archivo
			while(brArchivoEntrada.ready())
			{
				str = brArchivoEntrada.readLine();
				st = new StringTokenizer(str, "_");
				cta = st.nextToken();
				
				if(cta.equals(cuenta)&&(!encontrado))
				{
					datos = str;
					encontrado = true;
					//break;
				}
			}
			
			if (encontrado == false) 
				datos = "NO_DATOS";
			
			//3) Cerrar Archivo
			brArchivoEntrada.close();
		}
		
		catch(IOException ioe) 
		{
			System.out.println("Error: " + ioe);
			datos = "ERROR";
		}
		
		return datos;
	}
	
	public String sobreescribirDatos(String datos, String cuenta)
	{
		String datoExistente = "";
		int sw = 0;
		String str = "", cta = "";
		StringTokenizer st;
		
		try
		{
			//1) Abrir Archivo
			brArchivoEntrada = new BufferedReader(new FileReader ("Clientes.txt"));
			
			//2) Procesar Archivo
			while(brArchivoEntrada.ready())
			{
				str = brArchivoEntrada.readLine();
				st = new StringTokenizer(str, "_");
				cta = st.nextToken();
				
				if(cta.equals(cuenta))
				{
					pwArchivoSalida = new PrintWriter(new FileWriter("Clientes.txt", true));
					pwArchivoSalida.println(datos);
		
					//3) Cerrar el Archivo
					pwArchivoSalida.close();
					sw = 1;
					break;
				}
			}
			
			//if (sw == 0) datos = "NO_DATOS";
			
			//3) Cerrar Archivo
			brArchivoEntrada.close();
		}
		
		catch(IOException ioe) 
		{
			System.out.println("Error: " + ioe);
		}
		
		return str;
	}
	
	public String consultarTipo(String tipo)
	{
		String str ="", datos = "", cuenta = "", tpo = "", nombre = "";
		StringTokenizer st;
		boolean encontrado = false;
		
		try
		{
			//1) Abrir Archivo en Modo Lectura
			brArchivoEntrada = new BufferedReader(new FileReader("Clientes.txt"));
			
			//2) Buscar tipo y guaradar los Clientes en una variable
			while(brArchivoEntrada.ready())
			{
				str = brArchivoEntrada.readLine();
				st = new StringTokenizer(str, "_");
				cuenta = st.nextToken();
				nombre = st.nextToken();
				tpo = st.nextToken();
				
				if(tpo.equals(tipo))
				{
					datos = datos + str + "\n";
					encontrado = true;
				}
			}
			
			if(encontrado == false)
				 datos = "NO_DATOS";
		}
		catch(IOException ioe)
		{
			System.out.println("Error: " + ioe);
			datos = "ERROR";
		}
		
		return datos;
	}
	
	//<!-- AD Non-Existant -->
	
	public String consultarNombre(String nombre)
	{
		int sw = 0;
		String datos = "", str = "", nmb = "", cta = "", tpo = "";
		StringTokenizer st;
		boolean encontrado = false;
		
		try
		{
			//1) Abrir Archivo
			brArchivoEntrada = new BufferedReader(new FileReader ("Clientes.txt"));
			
			//2) Procesar Archivo
			while(brArchivoEntrada.ready())
			{
				str = brArchivoEntrada.readLine();
				st = new StringTokenizer(str, "_");
				cta = st.nextToken();
				tpo = st.nextToken();
				nmb = st.nextToken();
				
				
				if(nmb.equals(nombre)&&(!encontrado))
				{
					datos = str;
					encontrado = true;
				}
			}
			
			if (encontrado == false) 
				datos = "NO_DATOS";
			
			//3) Cerrar Archivo
			brArchivoEntrada.close();
		}
		
		catch(IOException ioe) 
		{
			System.out.println("Error: " + ioe);
			datos = "ERROR";
		}
		
		return datos;
	}
	
}