import javax.swing.*;
import java.awt.event.*;

public class ProyectoGUI extends JFrame implements ActionListener
{
	private JMenuBar mbProyecto;
	private JMenu mCalculos, mGrados, mCalculosVarios, mFiguras, mEspirales, mArchivos, mExtra;
	private JMenuItem miEcuacion, miExponencial, miCentigrados, miFahrenheit, miFactorial, miTabla, miSerie, miCalculadora, miRectangulo, miCirculo, miCilindro, miCalculos, miFiguras, miArchivos, miExtra;
	private JMenuItem miEspiralRectangulo, miEspiralCirculo, miCubo, miEspiralCubo, miArticulos;
	private JPanel panel;
	private EcuacionGUI ecuacion = new EcuacionGUI();
	private ExponencialGUI exponencial = new ExponencialGUI();
	private ConversionGradosGUI grados = new ConversionGradosGUI();
	private VariosGUI varios = new VariosGUI();
	private ArticuloGUI articulo = new ArticuloGUI();
	private BancoGUI banco = new BancoGUI();
	
	public ProyectoGUI()
	{
		super("Proyecto");
		
		//Se Crean Atributos
		mbProyecto = new JMenuBar();
		
		mCalculos = new JMenu("Cálculos");
		
		miEcuacion = new JMenuItem("Ecuación Cuadrática");
		miEcuacion.addActionListener(this);
		
		miExponencial = new JMenuItem("Exponencial");
		miExponencial.addActionListener(this);
		
		mGrados = new JMenu("Conversión de Grados");
		miCentigrados = new JMenuItem("Centígrados a Fahrenheit");
		miCentigrados.addActionListener(this);
		
		miFahrenheit = new JMenuItem("Fahrenheit a Centígrados");
		miFahrenheit.addActionListener(this);
					
		mCalculosVarios = new JMenu("Cálculos Varios");
		
		miFactorial = new JMenuItem("Factorial de N");
		miFactorial.addActionListener(this);
		
		miTabla = new JMenuItem("Tabla de N");
		miTabla.addActionListener(this);
		
		miSerie = new JMenuItem("Serie de N");
		miSerie.addActionListener(this);
		
		miCalculadora = new JMenuItem("Calculadora");
		miCalculadora.addActionListener(this);
		
		mFiguras = new JMenu("Figuras");
		
		miRectangulo = new JMenuItem("Dibujar Prisma Rectangular");
		miRectangulo.addActionListener(this);
		
		miCirculo = new JMenuItem("Dibujar Círculo");
		miCirculo.addActionListener(this);
		
		miCilindro = new JMenuItem("Dibujar Cilindro");
		miCilindro.addActionListener(this);
		
		miCubo = new JMenuItem("Dibujar Cubo");
		miCubo.addActionListener(this);
		
		mEspirales = new JMenu("Dibujar Espirales");
		
		miEspiralRectangulo = new JMenuItem("Dibujar Espiral Rectangular");
		miEspiralRectangulo.addActionListener(this);
		
		miEspiralCirculo = new JMenuItem("Dibujar Espiral Circular");
		miEspiralCirculo.addActionListener(this);
		
		miEspiralCubo = new JMenuItem("Dibujar Espiral Cúbico");
		miEspiralCubo.addActionListener(this);
		
		mArchivos = new JMenu("Archivos");
		
		miArticulos = new JMenuItem("Artículos");
		miArticulos.addActionListener(this);
		
		//<!-- Un-Existing Objects -->
		miCalculos = new JMenuItem("C");
		miCalculos.addActionListener(this);
		
		miFiguras = new JMenuItem("F");
		miFiguras.addActionListener(this);
		
		miArchivos = new JMenuItem("Banco");
		miArchivos.addActionListener(this);
		
		mExtra = new JMenu("E");
		
		miExtra = new JMenuItem("e");
		miExtra.addActionListener(this);
		
		//Panel
		panel = new JPanel();
		
		//Adicionar Objetos al MenuBar, Menú "Cálculos"
		mGrados.add(miCentigrados);
		mGrados.add(miFahrenheit);
		
		mCalculosVarios.add(miFactorial);
		mCalculosVarios.add(miTabla);
		mCalculosVarios.add(miSerie);
		
		mCalculos.add(miEcuacion);
		mCalculos.add(mGrados);
		mCalculos.add(miExponencial);
		mCalculos.add(mCalculosVarios);
		mCalculos.add(miCalculadora);
		
		//Menú "Figuras"
		mEspirales.add(miEspiralRectangulo);
		mEspirales.add(miEspiralCirculo);
		mEspirales.add(miEspiralCubo);
		
		mFiguras.add(miRectangulo);
		mFiguras.add(miCirculo);
		mFiguras.add(miCilindro);
		mFiguras.add(miCubo);
		mFiguras.add(mEspirales);
		
		//Menú Archivos
		mArchivos.add(miArticulos);
		
		mbProyecto.add(mCalculos);
		mbProyecto.add(mFiguras);
		mbProyecto.add(mArchivos);
		
		mArchivos.add(miArchivos);
		
		//2) Visualizar Frame
		setJMenuBar(mbProyecto);
		setSize(700, 450);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == miEcuacion)
		{
			if(panel != null)
			{
				panel.setVisible(false);
			}
			panel = ecuacion.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(event.getSource() == miCentigrados)
		{
			if(panel != null)
			{
				panel.setVisible(false);
			}
			panel = grados.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(event.getSource() == miFahrenheit)
		{
			if(panel != null)
			{
				panel.setVisible(false);
			}
			panel = grados.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(event.getSource() == miExponencial)
		{
			if(panel != null)
			{
				panel.setVisible(false);
			}
			panel = exponencial.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(event.getSource() == miFactorial)
		{
			if(panel != null)
			{
				panel.setVisible(false);
			}
			panel = varios.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(event.getSource() == miTabla)
		{
			if(panel != null)
			{
				panel.setVisible(false);
			}
			panel = varios.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(event.getSource() == miSerie)
		{
			if(panel != null)
			{
				panel.setVisible(false);
			}
			panel = varios.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(event.getSource() == miCalculadora)
		{
			new Calculadora();
		}
		
		if(event.getSource() == miRectangulo)
		{
			if(panel != null)
			{
				panel.setVisible(false);
			}
			panel = new GraphicsPD("RECTANGULO");
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(event.getSource() == miCirculo)
		{
			if(panel != null)
			{
				panel.setVisible(false);
			}
			panel = new GraphicsPD("CIRCULO");
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(event.getSource() == miCilindro)
		{
			if(panel != null)
			{
				panel.setVisible(false);
			}
			panel = new GraphicsPD("CILINDRO");
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(event.getSource() == miCubo)
		{
			if(panel != null)
			{
				panel.setVisible(false);
			}
			panel = new GraphicsPD("CUBO");
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(event.getSource() == miEspiralRectangulo)
		{
			if(panel != null)
			{
				panel.setVisible(false);
			}
			panel = new GraphicsPD("ESP-RECT");
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(event.getSource() == miEspiralCirculo)
		{
			if(panel != null)
			{
				panel.setVisible(false);
			}
			panel = new GraphicsPD("ESP-CIRC");
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(event.getSource() == miEspiralCubo)
		{
			if(panel != null)
			{
				panel.setVisible(false);
			}
			panel = new GraphicsPD("ESP-CUBO");
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(event.getSource() == miArticulos)
		{
			if(panel != null)
			{
				panel.setVisible(false);
			}
			panel = articulo.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		
		if(event.getSource() == miArchivos)
		{
			if(panel != null)
			{
				panel.setVisible(false);
			}
			panel = banco.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
			
	}
	
	public static void main(String args[])
	{
		ProyectoGUI proyecto = new ProyectoGUI();
		proyecto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}