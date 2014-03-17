import java.util.StringTokenizer;

public class PersonaDP
{
	private String id;
	private String nombre;
	private String existencia;
	private String precio;

	private PersonaDP next;
	
	//Constructors
	public PersonaDP()
	{
		this.id         = "";
		this.nombre     = "";
		this.existencia = "";
		this.precio		= "";
	}
	
	//String Tokenizer
	public PersonaDP(String datos)
	{
		StringTokenizer st = new StringTokenizer(datos, "_");
		
		this.id 		= st.nextToken();
		this.nombre 	= st.nextToken();
		this.existencia = st.nextToken();
		this.precio 	= st.nextToken();
	}
	
	//Accessors (Getters)
	public String getId()
	{
		return this.id;
	}

	public String getNombre()
	{
		return this.nombre;
	}
	
	public String getExistencia()
	{
		return this.existencia;
	}

	public String getPrecio()
	{
		return this.precio;
	}
	
		
	public PersonaDP getNext()
	{
		return this.next;
	}
	
	//Mutators(Setters)
	public void setId(String id)
	{
		this.id = id;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public void setExistencia(String existencia)
	{
		this.existencia = existencia;
	}

	public void setPrecio(String precio)
	{
		this.precio = precio;
	}
	
	public void setNext(PersonaDP dir)
	{
		this.next = dir;
	}
	
	//Final String
	public String toString()
	{
		return this.id+"_"+this.nombre+"_"+this.existencia+"_"+this.precio;
	}
}