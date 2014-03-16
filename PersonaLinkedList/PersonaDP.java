import java.util.StringTokenizer;

public class PersonaDP
{
	private String nombre;
	private String telefono;
	private PersonaDP next;
	
	//Constructors
	public PersonaDP()
	{
		this.nombre   = "";
		this.telefono = "";
	}
	
	//String Tokenizer
	public PersonaDP(String datos)
	{
		StringTokenizer st = new StringTokenizer(datos, "_");
		
		this.nombre   = st.nextToken();
		this.telefono = st.nextToken();
	}
	
	//Accessors (Getters)
	public String getNombre()
	{
		return this.nombre;
	}
	
	public String getTelefono()
	{
		return this.telefono;
	}
	
		
	public PersonaDP getNext()
	{
		return this.next;
	}
	
	//Mutators(Setters)
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}
	
	public void setNext(PersonaDP dir)
	{
		this.next = dir;
	}
	
	//Final String
	public String toString()
	{
		return this.nombre+"_"+this.telefono;
	}
}