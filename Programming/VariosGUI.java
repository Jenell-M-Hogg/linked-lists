import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VariosGUI extends JFrame implements ActionListener
{
	private JLabel lFactorial;
	private JButton bSerie, bSalir, bFactorial, bTabla;
	private JTextField tfVariable;
	private JTextArea taDatos;
	private JPanel panel1, panel2;
	private CalculoPD factorial = new CalculoPD();
	
	public VariosGUI()
	{
		super("Factorial");
		lFactorial = new JLabel("Número = ");
		
		bFactorial = new JButton("Factorial");
		bFactorial.addActionListener(this);
		
		bSalir = new JButton("Salir");
		bSalir.addActionListener(this);
		
		bTabla = new JButton("Tabla");
		bTabla.addActionListener(this);
		
		bSerie = new JButton("Serie");
		bSerie.addActionListener(this);
		
		tfVariable = new JTextField(10);
		
		taDatos = new JTextArea(14, 25);
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		//Añadir atributos al Panel 1
		panel1.setLayout(new GridLayout (3, 2));
		panel1.add(lFactorial);
		panel1.add(tfVariable);
		panel1.add(bFactorial);
		panel1.add(bTabla);
		panel1.add(bSerie);
		panel1.add(bSalir);
		
		//Agregar atributos a Panel 2
		panel2.setLayout(new FlowLayout());
		
		panel2.add(panel1);
		panel2.add(new JScrollPane(taDatos));
		
		//Visualizar Frame
		add(panel2);
		//setSize(500, 500);
		//setVisible(true);
	}
	
	public JPanel getPanel2()
	{
		return this.panel2;
	}
	
	public void getFactorial()
	{
		String stri;
		long x;
		double res;
		stri = (tfVariable.getText());
		x = Long.parseLong(stri);
		if(x>=0)
		{
			res = factorial.fact(x);
			stri = ("Resultado = " +res);
			taDatos.append(stri);	
		}
		else
			taDatos.append("MATH ERROR: \nNo existe el factorial de números negativos.");
	}
	
	public void getTabla()
	{
		String stri, res;
		long x;
		stri = (tfVariable.getText());
		x = Long.parseLong(stri);
		res = factorial.table(x);
		taDatos.append(res);
	}
	
	public void getSerie()
	{
		String stri, res;
		long x;
		stri = (tfVariable.getText());
		x = Long.parseLong(stri);
		res = factorial.serieUNO(x);
		taDatos.append(res);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == bSalir) 
			System.exit(0);
			
		if(event.getSource() == bFactorial)
		{
			taDatos.setText("Factorial \n--------------------------------------------------------------------\n");
			try
			{
				getFactorial();
			}
			catch(NumberFormatException nfe)
			{
				taDatos.append("ERROR: Debes introducir números enteros,\nno debe haber letras, ni espacios en blanco.\n(Recuerda no ocupar números muy grandes)\n");
			}
		}
		
		if(event.getSource() == bTabla)
		{
			taDatos.setText("Tabla de Multiplicar  \n--------------------------------------------------------------------\n");
			try
			{
				getTabla();
			}
			catch(NumberFormatException nfe)
			{
				taDatos.append("ERROR: Debes introducir números enteros,\nno debe haber letras, ni espacios en blanco.\n(Recuerda no ocupar números muy grandes) \n");
			}
		}
		
		if(event.getSource() == bSerie)
		{
			taDatos.setText("Serie  \n--------------------------------------------------------------------\n");
			try
			{
				getSerie();
			}
			catch(NumberFormatException nfe)
			{
				taDatos.append("ERROR: Debes introducir números enteros,\nno debe haber letras, ni espacios en blanco.\n(Recuerda no ocupar números muy grandes) \n");
			}
		}
	}
	
	public static void main(String args[])
	{
		new VariosGUI();
	}
}