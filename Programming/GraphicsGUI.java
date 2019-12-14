import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JMenu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicsGUI extends JFrame implements ActionListener
{
	private JMenuBar mbFiguras;
	private JMenuItem miRectangulo, miCirculo, miSalir, miCilindro, miEspiralRectangulo, miEspiralCirculo, miCubo, miEspiralCubo;
	private JMenu mFiguras, mEspirales;
	private JPanel panel;
	
	public GraphicsGUI()
	{
		super("Figuras Geométricas");
		
		mbFiguras = new JMenuBar();
		
		miRectangulo = new JMenuItem("Dibujar Prisma Rectangular");
		miRectangulo.addActionListener(this);
		
		miCirculo = new JMenuItem("Dibujar Círculo");
		miCirculo.addActionListener(this);
		
		miCilindro = new JMenuItem("Dibujar Cilindro");
		miCilindro.addActionListener(this);
		
		miEspiralRectangulo = new JMenuItem("Dibujar Espiral Rectangular");
		miEspiralRectangulo.addActionListener(this);
		
		miEspiralCirculo = new JMenuItem("Dibujar Espiral Circular");
		miEspiralCirculo.addActionListener(this);
		
		miCubo = new JMenuItem("Dibujar Cubo");
		miCubo.addActionListener(this);
		
		miEspiralCubo = new JMenuItem("Dibujar Espiral Cúbico");
		miEspiralCubo.addActionListener(this);
		
		miSalir = new JMenuItem("Salir");
		miSalir.addActionListener(this);
		
		mFiguras = new JMenu("Figuras");
		mEspirales = new JMenu("Dibujar Espirales");
		
		mEspirales.add(miEspiralRectangulo);
		mEspirales.add(miEspiralCirculo);
		mEspirales.add(miEspiralCubo);
		
		mFiguras.add(miRectangulo);
		mFiguras.add(miCirculo);
		mFiguras.add(miCilindro);
		mFiguras.add(miCubo);
		mFiguras.add(mEspirales);
		mFiguras.add(miSalir);
		
		mbFiguras.add(mFiguras);
		
		//Añadir atributos a JFrame
		setJMenuBar(mbFiguras);
		
		//Visualizar Frame
		setSize(400, 400);
		setVisible(true);
		
	}
	
	private void crearFigura(String str)
	{
		if(panel != null)
		{
			panel.setVisible(false);
		}
		panel = new GraphicsPD(str);
		add(panel);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == miSalir)
			System.exit(0);
			
		if(event.getSource() == miRectangulo)
			crearFigura("RECTANGULO");
		
		if(event.getSource() == miCirculo)
			crearFigura("CIRCULO");
		
		if(event.getSource() == miCilindro)
			crearFigura("CILINDRO");
				
		if(event.getSource() == miEspiralRectangulo)
			crearFigura("ESP-RECT");
		
		if(event.getSource() == miEspiralCirculo)
			crearFigura("ESP-CIRC");
		
		if(event.getSource() == miCubo)
			crearFigura("CUBO");
		
		if(event.getSource() == miEspiralCubo)
			crearFigura("ESP-CUBO");
	}
	
	public static void main(String args[])
	{
		new GraphicsGUI();
	}
}