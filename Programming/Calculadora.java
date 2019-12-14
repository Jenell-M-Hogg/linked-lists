import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.Panel;
import java.awt.Graphics;
import java.awt.Color;

public class Calculadora extends JFrame implements ActionListener
{
	String str = "", stri = "", sim = "";
	int suma, cont = 0, resta, op=0;
	boolean factor = false;
	double auxiliar = 0;
	
	private JTextField tfNumero = new JTextField(8);
	private JButton bSuma, bResta, bMultiplica, bDivide, bIgual, bClear;
	private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
	private JButton bFactorial;
	private Panel panel1, panel2;
	
	private double n1, n2;
	private String operacion = "";
	private String strNumero = "";
	private int base, x;
	private CalculoPD objeto = new CalculoPD();
	
	public void Graphics()
	{
		//drawPolygon(5, 3, 4, 7);
	}
	
	public Calculadora()
	{
		super("Calculadora");
		
		panel1 = new Panel();
		panel2 = new Panel();
		panel1.setLayout(new GridLayout(1,2));
		panel2.setLayout(new GridLayout(5,4));
		tfNumero.setEditable(false);
		
		panel1.add(tfNumero);
		
		bClear = new JButton("clear");
		bClear.addActionListener(this);
		panel1.add(bClear);		
		
		
		b7 = new JButton("7");
		b7.addActionListener(this);
		panel2.add(b7);
		
		b8 = new JButton("8");
		b8.addActionListener(this);
		panel2.add(b8);
		
		b9 = new JButton("9");
		b9.addActionListener(this);
		panel2.add(b9);
		
		bSuma = new JButton("+");
		bSuma.addActionListener(this);
		panel2.add(bSuma);
		
		b4 = new JButton("4");
		b4.addActionListener(this);
		panel2.add(b4);
		
		b5 = new JButton("5");
		b5.addActionListener(this);
		panel2.add(b5);
		
		b6 = new JButton("6");
		b6.addActionListener(this);
		panel2.add(b6);
		
		bResta = new JButton("-");
		bResta.addActionListener(this);
		panel2.add(bResta);
		
		b1 = new JButton("1");
		b1.addActionListener(this);
		panel2.add(b1);
		
		b2 = new JButton("2");
		b2.addActionListener(this);
		panel2.add(b2);
		
		b3 = new JButton("3");
		b3.addActionListener(this);
		panel2.add(b3);
		
		bMultiplica = new JButton("x");
		bMultiplica.addActionListener(this);
		panel2.add(bMultiplica);
		
		b0 = new JButton("0");
		b0.addActionListener(this);
		panel2.add(b0);
				
		bIgual = new JButton("=");
		bIgual.addActionListener(this);
		panel2.add(bIgual);
		
		bFactorial = new JButton("x!");
		bFactorial.addActionListener(this);
		panel2.add(bFactorial);
		
		bDivide = new JButton("/");
		bDivide.addActionListener(this);
		panel2.add(bDivide);
	
		setLayout(new FlowLayout());
		add(panel1);
		add(panel2);
		setSize(350,220);
		setVisible(true);
	}
	
	public double factorial()
	{
		double resultado = 0;
		int n = 0;
		factor = true;
				
		str = (tfNumero.getText());
		if (n1 == 0)
		{
			n1 = Double.parseDouble(str);	
		}
		op = 5;
		tfNumero.setText("");
		
		//sim = sim + str;
		str = "";
		cont++;
		if(n1>=0)
		{
			resultado = objeto.fact1(n1);
			if(resultado == 0)
			{
				tfNumero.setText("MATH ERROR");
				n1 = 0;
				return resultado = 0;
			}
			else
				return resultado;	
		}
		else
		{
			tfNumero.setText("MATH ERROR");
			n1 = 0;
			return resultado = 0;
		}
	}
	
	
	public void actionPerformed(ActionEvent event)
	{
			if(event.getSource() == b1)
			{
				str = str + "1";
				tfNumero.setText(str);
				Graphics();
			}
			
			if(event.getSource() == b2)
			{
				str = str + "2";
				tfNumero.setText(str);
			}
			
			if(event.getSource() == b3)
			{
				str = str + "3";
				tfNumero.setText(str);	
			}
			
			if(event.getSource() == b4)
			{
				str = str + "4";
				tfNumero.setText(str);	
			}
			
			if(event.getSource() == b5)
			{
				str = str + "5";
				tfNumero.setText(str);	
			}
			
			if(event.getSource() == b6)
			{
				str = str + "6";
				tfNumero.setText(str);	
			}
			
			if(event.getSource() == b7)
			{
				str = str + "7";
				tfNumero.setText(str);	
			}
			
			if(event.getSource() == b8)
			{
				str = str + "8";
				tfNumero.setText(str);	
			}
			
			if(event.getSource() == b9)
			{
				str = str + "9";
				tfNumero.setText(str);	
			}
			
			if(event.getSource() == b0)
			{
				if(str != "")
				{
					str = str + "0";
					tfNumero.setText(str);
				}
			}
			
			if(event.getSource() == bSuma)
			{
				str = (tfNumero.getText());
				if (n1 == 0)
				{
					n1 = Double.parseDouble(str);	
				}
				
				op = 1;
				//sim = Integer.toString(n1);
				if(cont == 0)
				{
					tfNumero.setText("");
				}
				//else tfNumero.setText(sim);
				//sim = sim + str;
				str = "";
				cont++;
			}
			
			if(event.getSource() == bResta)
			{
				str = (tfNumero.getText());
				if (n1 == 0)
				{
					n1 = Double.parseDouble(str);	
				}
				op = 2;
				if(cont == 0)
				{
					tfNumero.setText("");
				}
				//else tfNumero.setText(sim);
				//sim = sim + str;
				str = "";
				cont++;
			}
			
			if(event.getSource() == bMultiplica)
			{
				str = (tfNumero.getText());
				if (n1 == 0)
				{
					n1 = Double.parseDouble(str);	
				}
				op = 3;
				if(cont == 0)
				{
					tfNumero.setText("");
				}
				else tfNumero.setText(sim);
				//sim = sim + str;
				str = "";
				cont++;
			}
			
			if(event.getSource() == bDivide)
			{
				str = (tfNumero.getText());
				if (n1 == 0)
				{
					n1 = Double.parseDouble(str);	
				}
				op = 4;
				if(cont == 0)
				{
					tfNumero.setText("");
				}
				else tfNumero.setText(sim);
				//sim = sim + str;
				str = "";
				cont++;
			}
			
			if(event.getSource() == bFactorial)
			{
				factorial();

			}
			
			if(event.getSource() == bIgual)
			{
				double resultado=0;
				int n=0;
				String respuesta = "";
				
				if(op != 5)
				{
					n2 = Double.parseDouble(str);
				}
			
				if(op == 1)
				{
					resultado =  n1 + n2;
				}
				if(op == 2)
				{
					resultado = n1 - n2;
				}
				if(op == 3)
				{
					resultado = n1 * n2;
				}
				if(op == 4)
				{
					resultado = (double )n1/n2;
				}
				if(op == 5)
				{	
					
					if(factor == true)
						resultado = factorial();
					if(factor == false)
						resultado = auxiliar;
					factor = false;
					auxiliar = resultado;
				}
				
				respuesta = Double.toString(resultado);
				tfNumero.setText(respuesta);
				//str="";
				//tfNumero.setText(str);
				n1 = resultado;
				str = "";
				
				
			}
			
			
			
			if(event.getSource() == bClear)
			{
				n1 = 0;
				n2 = 0;
				op = 0;
				str="";
				tfNumero.setText(str);
			}

			
	}
	
	
	public static void main(String args[])
	{
		Calculadora calculadora = new Calculadora();
		calculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
}
