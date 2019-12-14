import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.Color;

public class GraphicsPD extends JPanel
{
	String figura;
	
	public GraphicsPD(String fig)
	{
		this.figura = fig;
		setSize(400, 400);
		setVisible(true);
	}
	
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		setBackground(Color.WHITE);
		
		if(figura.equals("RECTANGULO"))
		{
			int i = 2;
			for(i=7; i<=50; i++)
			{
				g.drawRect(i*2, i*2, 225, 175);
			}
		}
		
		if(figura.equals("CILINDRO"))
		{
			int i = 2;
			for(i=7; i<=50; i++)
			{
				g.drawOval(i*2, i*2, 225, 165);
			}
		}
		
		if(figura.equals("CIRCULO"))
		{
			int i;
			for(i=75; i>=2; i--)
			{
				g.drawOval(185-i*2, 163-i*2, i*4, i*4);
			}
		}
		
		if(figura.equals("ESP-RECT"))
		{
			int i = 2;
			for(i=7; i<=50; i++)
			{
				g.drawRect(i*2, i*2, i*4, i*3);
			}
		}
		
		if(figura.equals("ESP-CIRC"))
		{
			int i;
			for(i=50; i>=2; i--)
			{
				g.drawOval(i*2, i*2, i*4, i*4);
			}
		}
		
		if(figura.equals("CUBO"))
		{
			int i = 2;
			for(i=7; i<=50; i++)
			{
				g.drawRect(i*2, i*2, 225, 225);
			}
		}
		
		if(figura.equals("ESP-CUBO"))
		{
			int i = 2;
			for(i=7; i<=50; i++)
			{
				g.drawRect(i*2, i*2, i*4, i*4);
			}
		}
		
	}
	
	public static void main (String args[])
	{
		new GraphicsPD(null);
	}
}