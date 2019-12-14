import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BancoGUI extends JFrame implements ActionListener
{
	private JLabel lCuenta, lNombre, lSaldo, lPrecio, lTipo;
	private JTextField tfCuenta, tfNombre, tfSaldo, tfPrecio, tfTipo;
	private JButton bApertura, bConsultar, bSalir, bConsultarCuenta, bconsultarTipo, bConsultarNombre;
	private JTextArea taDatos;
	private JPanel panel1, panel2;
	private BancoAD banco = new BancoAD();
	
	public BancoGUI()
	{
		super("Catálogo Local de Clientes");
		
		//1) Se crean los Objetos
		lCuenta = new JLabel("Número de Cuenta");
		lNombre = new JLabel("Nombre");
		lSaldo = new JLabel("Saldo");
		lPrecio = new JLabel("Saldo");
		lTipo = new JLabel("Tipo");
		
		tfCuenta = new JTextField();
		tfNombre = new JTextField();
		tfSaldo = new JTextField();
		tfPrecio = new JTextField();
		tfTipo = new JTextField();
		
		bApertura = new JButton("Apertura");
		bApertura.addActionListener(this);
		
		bConsultar = new JButton("Consultar");
		bConsultar.addActionListener(this);
		
		bSalir = new JButton("Salir");
		bSalir.addActionListener(this);
		
		bConsultarCuenta = new JButton("Consultar NÚMERO Cuenta");
		bConsultarCuenta.addActionListener(this);
		
		bconsultarTipo = new JButton("Consultar TIPO Cuenta");
		bconsultarTipo.addActionListener(this);
		
		taDatos = new JTextArea(10, 30);
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		//UnReal Elements
		bConsultarNombre = new JButton("Consultar por NOMBRE");
		bConsultarNombre.addActionListener(this);
		
		//2) Agregar objetos al Panel 1
		panel1.setLayout(new GridLayout(8, 2));
		
		panel1.add(lCuenta);
		panel1.add(tfCuenta);
				
		panel1.add(lNombre);
		panel1.add(tfNombre);
		
		panel1.add(lTipo);
		panel1.add(tfTipo);
		
		panel1.add(lSaldo);
		panel1.add(tfSaldo);
		
		panel1.add(bApertura);
		panel1.add(bConsultar);
		panel1.add(bConsultarCuenta);
		panel1.add(bconsultarTipo);
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
		String cuenta, nombre, saldo, precio, datos = "", tipo, aux1, aux2, aux3, aux4;
		int inSaldo, inPrecio, sw = 0, sw2 = 0;
		StringTokenizer st, st2;
		
		cuenta = tfCuenta.getText();
		tipo = tfTipo.getText();
		nombre = tfNombre.getText();
		saldo = tfSaldo.getText();
		
		if((cuenta.equals(""))||(tipo.equals(""))||(nombre.equals(""))||(saldo.equals("")))
		{
			datos = "Vacío";
		}
		else 
		{	
			st = new StringTokenizer(tipo, "_");
			aux1 = st.nextToken();
			st2 = new StringTokenizer(cuenta, "_");
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
					inSaldo = Integer.parseInt(saldo);
					sw = 1;
				}
				catch(NumberFormatException nfe)
				{
					datos = "Número";
				}
			}
		}
		
		if(sw == 1) datos = cuenta+"_"+nombre+"_"+tipo+"_"+saldo;
			
		return datos;		
	}
	
	public void clrScreen()
	{
		tfCuenta.setText("");
		tfTipo.setText("");
		tfNombre.setText("");
		tfSaldo.setText("");
	}
	
	public void mostrar(String datos)
	{
		StringTokenizer st;
		
		st =  new StringTokenizer(datos, "_");
		tfCuenta.setText(st.nextToken());
		tfNombre.setText(st.nextToken());
		tfTipo.setText(st.nextToken());
		tfSaldo.setText(st.nextToken());
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String datos, resultado = "";
		int sw;
		
		if(event.getSource() == bSalir)
			System.exit(0);
			
		if(event.getSource() == bApertura)
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
					taDatos.setText("Message Log\n---------------------------------------------------------------------------------------\nLos campos 'saldo' y 'Precio', deben ser valores numéricos");
				}
				else
				{
					if(datos.equals(""))
					{
						taDatos.setText("Message Log\n---------------------------------------------------------------------------------------\nEl campo 'Saldo' debe ser un valor numérico");
					}
					else
					{
						resultado = banco.consultarCuenta(tfCuenta.getText());
					
						if(resultado.equals("NO_DATOS")||(resultado.equals("ERROR")))
						{
							//2. Envíar los datos al objetos AD a través del método capturar
							resultado = banco.capturar(datos);
				
							//3. Desplegar el resultado de la transacción
							taDatos.setText(resultado);	
							
							//4. Se borran los campos ya utilizados
							clrScreen();
						}
						
						else
							taDatos.setText("Message Log\n---------------------------------------------------------------------------------------\nLa cuenta ya existe en el registro");
						}
				}
			}
		}
		
		if(event.getSource() == bConsultar)
		{
			//1) Llamar a consultar datos de bancoAD
			datos = banco.consultar();
			
			//2) Mostrar los datos en taDatos
			if(datos.equals("ERROR"))
				taDatos.setText("El archivo no existe");
			else
				taDatos.setText(datos);
		}
		
		if(event.getSource() == bConsultarCuenta)
		{
			String cve = tfCuenta.getText(), cle;
			int ce;
			
			datos = banco.consultarCuenta(cve);
			
			if (datos.equals("ERROR"))
			{
				taDatos.setText("El archivo no existe");
			}
			else
			{
				if (datos.equals("NO_DATOS"))
				{
					taDatos.setText("Message Log\n---------------------------------------------------------------------------------------\nLa cuenta no existe en la base de datos");
				}
				else
				{
					mostrar(datos);
				}		
			}
								
		}
		
		if(event.getSource() == bconsultarTipo)
		{
			
			datos = banco.consultarTipo(tfTipo.getText());
			
			if(datos.equals("ERROR"))
				taDatos.setText("El archivo no existe");
			else
			{
				if(datos.equals("NO_DATOS"))
					taDatos.setText("Message Log\n---------------------------------------------------------------------------------------\nEl tipo no existe en la base de datos");
				else
					taDatos.setText(datos);
			}
		}
		
		//<!-- Imaginary Event -->
		if(event.getSource() == bConsultarNombre)
		{
			String nombre = tfNombre.getText(), cle;
			int ce;
			
			datos = banco.consultarNombre(nombre);
			
			if (datos.equals("ERROR"))
			{
				taDatos.setText("El archivo no existe");
			}
			else
			{
				if (datos.equals("NO_DATOS"))
				{
					taDatos.setText("Message Log\n---------------------------------------------------------------------------------------\nEl nombre no existe en la base de datos");
				}
				else
				{
					mostrar(datos);
				}		
			}
		}
			
		
	}
	
	public static void main(String args[])
	{
		new BancoGUI();
	}
}