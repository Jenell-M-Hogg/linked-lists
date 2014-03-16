import java.io.*;
import java.util.StringTokenizer;

public class ArticuloAD
{
	private BufferedReader brArchivoEntrada;
	private PrintWriter pwArchivoSalida;
	
	public String capturar(String str)
	{
		int sw = 1;
		StringTokenizer st;
		String cve = "", datos = "", stringReader = "";
		try
		{
			//1) Abrir el Archivo
			pwArchivoSalida = new PrintWriter(new FileWriter("Articulos.txt", true));
			
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
			brArchivoEntrada = new BufferedReader(new FileReader("Articulos.txt"));
			
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
	
	public String consultarClave(String clave)
	{
		int sw = 0;
		String datos = "", str = "", cve = "";
		StringTokenizer st;
		boolean encontrado = false;
		
		try
		{
			//1) Abrir Archivo
			brArchivoEntrada = new BufferedReader(new FileReader ("Articulos.txt"));
			
			//2) Procesar Archivo
			while(brArchivoEntrada.ready())
			{
				str = brArchivoEntrada.readLine();
				st = new StringTokenizer(str, "_");
				cve = st.nextToken();
				
				if(cve.equals(clave)&&(!encontrado))
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
	
	public String sobreescribirDatos(String datos, String clave)
	{
		String datoExistente = "";
		int sw = 0;
		String str = "", cve = "";
		StringTokenizer st;
		
		try
		{
			//1) Abrir Archivo
			brArchivoEntrada = new BufferedReader(new FileReader ("Articulos.txt"));
			
			//2) Procesar Archivo
			while(brArchivoEntrada.ready())
			{
				str = brArchivoEntrada.readLine();
				st = new StringTokenizer(str, "_");
				cve = st.nextToken();
				
				if(cve.equals(clave))
				{
					pwArchivoSalida = new PrintWriter(new FileWriter("Articulos.txt", true));
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
	
	public String consultarMarca(String marca)
	{
		String str ="", datos = "", brand = "", clave = "", mca = "";
		StringTokenizer st;
		boolean encontrado = false;
		
		try
		{
			//1) Abrir Archivo en Modo Lectura
			brArchivoEntrada = new BufferedReader(new FileReader("Articulos.txt"));
			
			//2) Buscar Marca y guaradar los articulos en una variable
			while(brArchivoEntrada.ready())
			{
				str = brArchivoEntrada.readLine();
				st = new StringTokenizer(str, "_");
				clave = st.nextToken();
				mca = st.nextToken();
				
				if(mca.equals(marca))
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
		String datos = "", str = "", nmb = "", cve = "", mca = "";
		StringTokenizer st;
		boolean encontrado = false;
		
		try
		{
			//1) Abrir Archivo
			brArchivoEntrada = new BufferedReader(new FileReader ("Articulos.txt"));
			
			//2) Procesar Archivo
			while(brArchivoEntrada.ready())
			{
				str = brArchivoEntrada.readLine();
				st = new StringTokenizer(str, "_");
				cve = st.nextToken();
				mca = st.nextToken();
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