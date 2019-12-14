import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ArticuloGUI extends JFrame implements ActionListener
{
	private JLabel lClave, lNombre, lCantidad, lPrecio, lMarca;
	private JTextField tfClave, tfNombre, tfCantidad, tfPrecio, tfMarca;
	private JButton bCapturar, bConsultar, bSalir, bConsultarClave, bConsultarMarca, bConsultarNombre;
	private JTextArea taDatos;
	private JPanel panel1, panel2;
	private ArticuloAD articulo = new ArticuloAD();
	
	public ArticuloGUI()
	{
		super("Catálogo de Artículos");
		
		//1) Se crean los Objetos
		lClave = new JLabel("Clave");
		lNombre = new JLabel("Nombre");
		lCantidad = new JLabel("Cantidad");
		lPrecio = new JLabel("Precio");
		lMarca = new JLabel("Marca");
		
		tfClave = new JTextField();
		tfNombre = new JTextField();
		tfCantidad = new JTextField();
		tfPrecio = new JTextField();
		tfMarca = new JTextField();
		
		bCapturar = new JButton("Capturar");
		bCapturar.addActionListener(this);
		
		bConsultar = new JButton("Consultar");
		bConsultar.addActionListener(this);
		
		bSalir = new JButton("Salir");
		bSalir.addActionListener(this);
		
		bConsultarClave = new JButton("Consultar por CLAVE");
		bConsultarClave.addActionListener(this);
		
		bConsultarMarca = new JButton("Consultar por MARCA");
		bConsultarMarca.addActionListener(this);
		
		taDatos = new JTextArea(10, 30);
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		//UnReal Elements
		bConsultarNombre = new JButton("Consultar por NOMBRE");
		bConsultarNombre.addActionListener(this);
		
		//2) Agregar objetos al Panel 1
		panel1.setLayout(new GridLayout(8, 2));
		
		panel1.add(lClave);
		panel1.add(tfClave);
		
		panel1.add(lMarca);
		panel1.add(tfMarca);
		
		panel1.add(lNombre);
		panel1.add(tfNombre);
		
		panel1.add(lCantidad);
		panel1.add(tfCantidad);
		
		panel1.add(lPrecio);
		panel1.add(tfPrecio);
		
		panel1.add(bCapturar);
		panel1.add(bConsultar);
		panel1.add(bConsultarClave);
		panel1.add(bConsultarMarca);
		panel1.add(bSalir);
		
		//3) Agregar Panel 1 a Panel 2
		panel2.setLayout(new FlowLayout());
		
		panel2.add(panel1);
		panel2.add(new JScrollPane(taDatos));
		
		//Visualizar Frame
		add(panel2);
		//setSize(400, 400);
		//setVisible(true);
	}
	
	public JPanel getPanel2()
	{
		return this.panel2;
	}
	
	private String obtenerDatos()
	{
		String clave, nombre, cantidad, precio, datos = "", marca, aux1, aux2, aux3, aux4;
		int inCantidad, inPrecio, sw = 0, sw2 = 0;
		StringTokenizer st, st2;
		
		clave = tfClave.getText();
		marca = tfMarca.getText();
		nombre = tfNombre.getText();
		cantidad = tfCantidad.getText();
		precio = tfPrecio.getText();
		
		if((clave.equals(""))||(marca.equals(""))||(nombre.equals(""))||(cantidad.equals(""))||(precio.equals("")))
		{
			datos = "Vacío";
		}
		else 
		{	
			st = new StringTokenizer(marca, "_");
			aux1 = st.nextToken();
			st2 = new StringTokenizer(clave, "_");
			aux3 = st2.nextToken();
			try
			{
				aux4 = st2.nextToken();
				if(aux4.equals("_"))
					aux4 = st2.nextToken();
			}
			catch(NoSuchElementException nsee)
			{
				sw2 = 2;
				datos = "Número";
			}
			try
			{
				aux2 = st.nextToken();
			}
			catch(NoSuchElementException nsee)
			{
				sw = 2;	
				datos = "Número";		
			}
			if((sw == 2)&&(sw2 == 2))
			{
				try
				{
					inCantidad = Integer.parseInt(cantidad);
					inPrecio = Integer.parseInt(precio);
					sw = 1;
					
				}
				catch(NumberFormatException nfe)
				{
					datos = "Número";
				}
			}
		}
		
		if(sw == 1) datos = clave+"_"+marca+"_"+nombre+"_"+cantidad+"_"+precio;
			
		return datos;		
	}
	
	public void clrScreen()
	{
		tfClave.setText("");
		tfMarca.setText("");
		tfNombre.setText("");
		tfCantidad.setText("");
		tfPrecio.setText("");
	}
	
	public void mostrar(String datos)
	{
		StringTokenizer st;
		
		st =  new StringTokenizer(datos, "_");
		tfClave.setText(st.nextToken());
		tfMarca.setText(st.nextToken());
		tfNombre.setText(st.nextToken());
		tfCantidad.setText(st.nextToken());
		tfPrecio.setText(st.nextToken());
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String datos, resultado = "";
		int sw;
		
		if(event.getSource() == bSalir)
			System.exit(0);
			
		if(event.getSource() == bCapturar)
		{
			//1. Obtener datos de los TextFields
			datos = obtenerDatos();
			
			if(datos.equals("Vacío"))
			{
				taDatos.setText("Message Log\n---------------------------------------------------------------------------------------\nTodos los campos deben contener datos");	
			}
			else
			{
				if(datos.equals("Número"))
				{
					taDatos.setText("Message Log\n---------------------------------------------------------------------------------------\nLos campos 'Cantidad' y 'Precio', deben ser valores numéricos");
				}
				else
				{
					if(datos.equals(""))
					{
						taDatos.setText("Message Log\n---------------------------------------------------------------------------------------\nLos campos 'Cantidad' y 'Precio', deben ser valores numéricos");
					}
					else
					{
						resultado = articulo.consultarClave(tfClave.getText());
					
						if(resultado.equals("NO_DATOS")||(resultado.equals("ERROR")))
						{
							//2. Envíar los datos al objetos AD a través del método capturar
							resultado = articulo.capturar(datos);
				
							//3. Desplegar el resultado de la transacción
							taDatos.setText(resultado);	
							
							//4. Se borran los campos ya utilizados
							clrScreen();
						}
						
						else
							taDatos.setText("Message Log\n---------------------------------------------------------------------------------------\nLa clave ya existe en el registro");
						}
				}
			}
		}
		
		if(event.getSource() == bConsultar)
		{
			//1) Llamar a consultar datos de ArticuloAD
			datos = articulo.consultar();
			
			//2) Mostrar los datos en taDatos
			if(datos.equals("ERROR"))
				taDatos.setText("El archivo no existe");
			else
				taDatos.setText(datos);
		}
		
		if(event.getSource() == bConsultarClave)
		{
			String cve = tfClave.getText(), cle;
			int ce;
			
			datos = articulo.consultarClave(cve);
			
			if (datos.equals("ERROR"))
			{
				taDatos.setText("El archivo no existe");
			}
			else
			{
				if (datos.equals("NO_DATOS"))
				{
					taDatos.setText("Message Log\n---------------------------------------------------------------------------------------\nLa clave no existe en la base de datos");
				}
				else
				{
					mostrar(datos);
				}		
			}
								
		}
		
		if(event.getSource() == bConsultarMarca)
		{
			
			datos = articulo.consultarMarca(tfMarca.getText());
			
			if(datos.equals("ERROR"))
				taDatos.setText("El archivo no existe");
			else
			{
				if(datos.equals("NO_DATOS"))
					taDatos.setText("Message Log\n---------------------------------------------------------------------------------------\nLa marca no existe en la base de datos");
				else
					taDatos.setText(datos);
			}
		}
			
		
	}
	
	public static void main(String args[])
	{
		new ArticuloGUI();
	}
}