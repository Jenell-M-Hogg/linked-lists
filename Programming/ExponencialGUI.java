import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ExponencialGUI extends JFrame implements ActionListener
{
	int sw;
	
	private JLabel lBase, lExponente;
	private JTextField tfBase, tfExponente;
	private JButton bCalcular, bSalir;
	private JPanel panel1, panel2;
	private JTextArea taDatos;
	
	private CalculoPD objeto = new CalculoPD();
	
	public ExponencialGUI()
	{
		super("Base Y Exponente");
		
		lBase = new JLabel("Base            =  ");
		lExponente = new JLabel("Exponente  =  ");
		
		tfBase = new JTextField(8);
		tfExponente = new JTextField(8);
		
		bCalcular = new JButton("Calcular");
		bCalcular.addActionListener(this);
		
		bSalir = new JButton("Salir");
		bSalir.addActionListener(this);
		
		taDatos = new JTextArea(10, 25);
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		//Agregar al Panel 1
		panel1.setLayout(new GridLayout(3, 2));
		
		panel1.add(lBase);
		panel1.add(tfBase);
		
		panel1.add(lExponente);
		panel1.add(tfExponente);
		
		panel1.add(bCalcular);
		panel1.add(bSalir);
		
		//Agregar al Panel 2
		panel2.setLayout(new FlowLayout());
		
		panel2.add(panel1);
		panel2.add(new JScrollPane(taDatos));
		
		//Crear Frame
		add(panel2);
		//setSize(350, 400);
		//setVisible(true);
	}
	
	public JPanel getPanel2()
	{
		return this.panel2;
	}
	
	private void mostrarExponencial()
	{
		long b, x = 0;
		double pot;
		String str, potencial;
		
		str = (tfBase.getText());
		b = Long.parseLong(str);
		str = (tfExponente.getText());
		x = Long.parseLong(str);
		potencial = objeto.exponencialLong(b,x);
		//pot = Double.parseDouble(potencial);
		if(x>=0)
      	{
      			taDatos.append("R =  " + b + " ^ " + x + "  =  " + potencial);  
      	}
      	else
      	{
      		taDatos.append("R = " + "1/( " + b + " ^ " + -x + " )" + "  =  " + "1/" + potencial);  
      	}
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == bSalir)
		System.exit(0);
		
		if(event.getSource() == bCalcular)
		{
			taDatos.setText("Exponencial \n--------------------------------------------------------------------\n");
			try
			{
				mostrarExponencial();
			}
			catch (NumberFormatException nfe)
			{
				taDatos.append("ERROR: Debes introducir números enteros,\nno debe haber letras, ni espacios en blanco.\n(Recuerda no ocupar números muy grandes) \n");
			}
		
		}
	}
	
	public static void main(String args[])
	{
		ExponencialGUI objeto = new ExponencialGUI();
	}
}