import javax.swing.*;
import java.util.*;
import java.io.*;

public class PersonaAD
{
	private PersonaDP primero, ultimo, actual, anterior;
	private PrintWriter archivoSalida;
	private BufferedReader archivoEntrada;
	
	public PersonaAD()
	{
		String datos = "";
		try
		{
			//1) Abrir Archivo
			archivoEntrada = new BufferedReader(new FileReader("Articulos.txt"));
			
			//2) Procesar datos del archivo
			while(archivoEntrada.ready())
			{
				datos = archivoEntrada.readLine();
				crearNodo(datos);
			}
			
			//3) Cerrar Archivo
			archivoEntrada.close();
		}
		catch(IOException ioe)
		{
			System.out.println("Error: " + ioe);
		}
		
	}
	
	public String crearNodo(String datos)
	{
		String respuesta = "Nuevo nodo creado: ";
		if(primero == null)
		{
			primero = new PersonaDP(datos);
			ultimo = primero;
			ultimo.setNext(null);
			return respuesta + datos;
		}
		else
		{
			actual = new PersonaDP(datos);
			ultimo.setNext(actual); //Link
			ultimo = actual;
			ultimo.setNext(null);
			return respuesta + datos;
		}
	}
	
	public String crearNodoInicio(String datos)
	{
		String respuesta = "Nuevo nodo creado: ";
		if(primero == null)
		{
			primero = new PersonaDP(datos);
			ultimo = primero;
			ultimo.setNext(null);
			return respuesta + datos;
		}
		else
		{
			actual = primero;
			primero = new PersonaDP(datos);
			primero.setNext(actual);
			return respuesta + datos;
		}
	}
	
	public boolean vacia()
	{
		boolean vacia = false;
		
		if(primero == null)
			vacia = true;
		
		return vacia;
	}
	
	public String consultarNodo()
	{
		String datos = "";
		
		if(primero == null)
			datos = "LISTA_VACÍA";
		else
		{
			actual = primero;
			
			while(actual != null)
			{
				datos = datos + actual.toString() + "\n";
				actual = actual.getNext();
			}
		}
		return datos;
	}

	public String consultarId(String id)
	{
		String datos = "";
		boolean encontrado = false;
		
		if(primero == null)
			datos = "LISTA_VACÍA"; 
		else
		{
			actual = primero;
			while((actual != null)&&(encontrado == false))
			{
				String clave = actual.getId();
				if(clave.equals(id))
				{
					datos = actual.toString();
					encontrado = true;
				}
				else
				{
					anterior = actual;
					actual = actual.getNext();
				}
			}
			if(encontrado == false)
					datos = "NO_ENCONTRADO";
		}
		return datos;
	}
	
	public String consultarNombre(String nombre)
	{
		String datos = "";
		boolean encontrado = false;
		
		if(primero == null)
			datos = "LISTA_VACÍA";
		else
		{
			actual = primero;
			while((actual != null)&&(encontrado == false))
			{
				String name = actual.getNombre();
				if(name.equals(nombre))
				{
					datos = actual.toString();
					encontrado = true;
				}
				else
				{
					anterior = actual;
					actual = actual.getNext();
				}
			}
			if(encontrado == false)
					datos = "NO_ENCONTRADO";
		}
		return datos;
	}
	
	public String modificarNodo(String datos)
	{
		StringTokenizer st = new StringTokenizer(datos, "_");
		String nombre = "", existencia = "";
		
		nombre   = st.nextToken();
		existencia = st.nextToken();
		
		actual.setNombre(nombre);
		actual.setExistencia(existencia);
		
		return datos;
	}
	
	public String borrarNodo()
	{ 
		if(actual == primero)
			primero = actual.getNext(); // Nodo siguiente a "Actual"; Segundo nodo
		else 
		{
			if(actual == ultimo)
			{
				ultimo = anterior; 
				ultimo.setNext(null); //Apuntar a un "null" en la siguiente dirección del último nodo.
			}
			else
				anterior.setNext(actual.getNext()); //Unir el nodo anterior con el siguiente del que se borra.
		}
		
		return "Nodo Borrado Exitósamente.";
	}
	
	public String datosListaArchivo()
	{
		String resultado = "";
		
		if(primero == null)
			resultado = "LISTA_VACÍA";
		else
		{
			try
			{
				//1) Abrir archivo
				archivoSalida = new PrintWriter(new FileWriter("Articulos.txt"));
				
				//2) Procesar datos 
				actual = primero;
			
				while(actual != null)
				{
					archivoSalida.println(actual.toString());
					actual = actual.getNext();
				}
				
				//3) Cerrar Archivo
				archivoSalida.close();
			}
			catch(IOException ioe)
			{
				System.out.println("Error: " + ioe);
			}
		}
		return resultado;
	}
}