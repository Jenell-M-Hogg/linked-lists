import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent; 


public class EcuacionGUI extends JFrame implements ActionListener
{
	int sw;
	
	private JTextField tfCoeficienteA;
	private JTextField tfCoeficienteB;
	private JTextField tfCoeficienteC;
	
	private JButton bCalcular, bSalir;
	
	private JTextArea taDatos;
	
	private JLabel lCoefA;
	
	private JPanel panel1, panel2;

	
	//Asignación de Atributos (Herencia Múltiple)
	private CalculoPD objeto = new CalculoPD();
	
	public EcuacionGUI()
	{
		super("Ecuación Cuadrática");
	
		//Crear Objetos de los Atributos
		tfCoeficienteA = new JTextField();
		tfCoeficienteB = new JTextField();
		tfCoeficienteC = new JTextField();	
		
		lCoefA = new JLabel("Coeficiente A = ");
		
		bCalcular = new JButton("Calcular Raíces");
		bCalcular.addActionListener(this);
		
		bSalir = new JButton("Salir");
		bSalir.addActionListener(this);
		
		taDatos = new JTextArea(10, 30);	
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		//Adicionar objetos o atributos al Panel 1
		panel1.setLayout(new GridLayout(4, 2));
		panel2.setLayout(new FlowLayout());
		
		panel1.add(lCoefA);
		panel1.add(tfCoeficienteA);
		
		
		panel1.add(new JLabel("Coeficiente B = "));
		panel1.add(tfCoeficienteB);
		
		
		panel1.add(new JLabel("Coeficiente C = "));
		panel1.add(tfCoeficienteC);
		
		panel1.add(bCalcular);
		panel1.add(bSalir);
		
		//Adicionar el Panel 1 al Panel 2
		panel2.add(panel1);
		panel2.add(new JScrollPane(taDatos));
			
		//Visualizar el JFrame
		add(panel2);
		//setSize(350, 400);
		//setVisible(true);
	}
	
	public JPanel getPanel2()
	{
		return this.panel2;
	}
	
	private void ecuacion()
	{
		String str, strRaices;
		double a, b, c;
		
		str = (tfCoeficienteA.getText());
		a = Double.parseDouble(str);
		str = (tfCoeficienteB.getText());
		b = Double.parseDouble(str);
		str = (tfCoeficienteC.getText());
		c = Double.parseDouble(str);
		taDatos.append("A = "+a+"   \nB = "+b+"   \nC = "+c);
		
		//Calcular Raíces
		strRaices = objeto.calcularRaices(a, b, c);
		
		//Desplegar Raices
		taDatos.append("\n \n" + strRaices);
	}	
		
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == bSalir)
		System.exit(0);
		
		if(event.getSource() == bCalcular)
		{
			taDatos.setText("Solución de una Ecuación Cuadrática \n----------------------------------------------------------------------------------\n");
			try
			{
				ecuacion();
			}
			catch(NumberFormatException nfe)
			{
				//System.out.println("Error: "+nfe);
				taDatos.append("ERROR: Debes ingresar números, no letras.\nTampoco se pueden dejar espacios en blanco. \n \n \n");
			}
		}
	}
	
	
	public static void main(String args[])
	{
		EcuacionGUI objeto = new EcuacionGUI();
	}
}