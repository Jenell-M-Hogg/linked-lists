import javax.swing.JOptionPane;

public class CalculoPD
{
	
	public String factorial(long n)
	{
		String stri="";
		int i;
		double fact = 1;
		
		if(n>=0)
		{
			//Operaciones
      		for(i=1;i<=n;i++)
      		{
       			fact = (double)fact*i;
				if(i != n)
				{
					stri = stri + i +" X ";
				}
			
				else
				{
					stri = stri + i;
				}         
      		}
      		
		}
		
		return stri;
	}
	
	public String exponencial(int x, int y)
	{
		String stri="";
		int pot=1, i, B;
				
      	if(y>=0)
      	{
      		for(i=1;i<=y;i++)
      		{
      	 	pot=pot*x;
      	 	if(i != y)
		 	{
			stri = stri + x +" X ";
		 	}
		 	else
			 {	
			stri = stri + x;
			 }         
      		} 
      	}
      	
      	else
      	{
      		for(i=1;i<=-y;i++)
      		{
      	 		pot=pot*x;
      		} 	
      	}
      	
      	return stri;           
	}
	
	public double fact(long n)
	{
		int i; 
		double facto = 1;
		for(i=1;i<=n;i++)
      		{
       		facto=facto*i;
      		}
      	return facto;
	}
	
	public double fact1(double n)
	{
		int i, auxiliar = 0;
		double facto = 1;
		String aux = "";
		
			auxiliar = (int) n;
			if(auxiliar - n == 0)
			{
				for(i=1;i<=n;i++)
	      		{
	       			facto=facto*i;
	      		}
	      		return facto;
			}
			return facto = 0;
	}
	
	public float factr(float n)
	{
		int i;
		float facto=0;
		for(i=1;i<=n;i++)
      		{
       		facto=facto*i;
      		}
      	return facto;
	}
	
	
	public int expo(int x, int y)
	{
		int pot = 1, i; 
		
		if(y<1234657)
		{
			if(y<0)
			{
				for(i=1;i<=-y;i++)
	      		{
	      	 		pot=pot*x;
	      		}
			}
			else
			{
				for(i=1;i<=y;i++)
	      		{
	      	 		pot=pot*x;
	      		}
			}
		}
	
      	
      	return pot;
	}
	
	
	public String exponencialLong(long x, long y)
	{
		long i; 
		double pot = 1;
		String str = "";
		
		if((x != 0)&&(x != 1))
		{
			if(y<10000)
			{
				if(y<0)
				{
					for(i=1;i<=-y;i++)
		      		{
		      	 		pot = (double)pot*x;
		      		}
				}
				else
				{
					for(i=1;i<=y;i++)
		      		{
		      	 		pot = (double)pot*x;
		      		}
				}
			}
			else
			{
				if(x == -1)
				{
					if(y%2 == 0)
						pot = 1;
					else
						pot = -1;
				}
				else
	      			return str = "Infinity";
			}

		}
		
      		
      	if(x == 0)
			pot = 0;
		if(x == 1)
			pot = 1;
			
      	return str + pot;
	}

  public String serie(int n)
	{
		String stri="";
		int i;
		double iFact=0;
		double sumaFloat=1;
		for(i=1; i<=n; i++)
		{
			iFact = fact(i+1);
			if(i != n)
			{
				stri = stri  + i + "/" + iFact + " + ";
			}
			else
			{
				stri = stri + i + "/" + iFact;
			}
			sumaFloat = sumaFloat + (double) i/iFact;
		}
		
		return stri;
	}
	
		
	public double ser(int n)
	{
		int i;
		double iFact=1;
		double sumaFloat = 1;
		for(i=1;i<=n;i++)
      	{
       		iFact = fact(i+1);
       		sumaFloat = sumaFloat + (double) i/iFact;
      	}
      	return sumaFloat;
	}
	
	public String calcularRaices(double a, double b, double c)
	{
		double x1, x2, det, img;
		String res = "";
		if(a == 0)
		{
			if(b == 0)
			{
				res = "MATH ERROR: No existe ecuación";
			}
			else
			{
				if(c == 0)
				{
					res = "X = 0";
				}
				else
				{
					x1 = -(double)c/b;
					res = "Ecuación Lineal:   X = " + x1;
				}
			}
		}
		else
		{
			if((b == 0)&&(c == 0))
			{
				res = "X = 0";
			}
			else
			{
				det = b*b-4*a*c;
				if(det>=0)
				{
					x1 = (-b+(double)Math.sqrt(det))/(2*a);
					x2 = (-b-(double)Math.sqrt(det))/(2*a);
					res = "X1 = "+x1+"   \nX2 = "+x2;
				}
				else
				{
					det = det*-1;
					x1 = (double)Math.sqrt(det)/(2*a);
					img = b*-1/(2*a);
					res = "X1 = "+img+" + "+x1+" i   \nX2 = "+img+" - "+x1+" i";
				}
			}
		}
		
		return res;
	}
	
	public double degrees(int opc, double grados)
	{
		double conver=0;
		if(opc == 1)
		{
			conver = (double)1.8*grados+32;
		}
		if(opc == 2){conver = (double)((grados-32)/1.8);}
		
		return conver;
	}
	
	public String table(long n)
	{
		String stri;
		long i, mult;
		
		stri = "Tabla de Multiplicar del "+n+"\n";
		for(i = 1; i<11; i++)
		{
			mult = i*n;
			stri = stri + n + " X " + i + " = " + mult + "\n";
		}
		
		return stri;
	}
	
	public int sumaUno(int n)
	{
		int i, suma = 0;
		for(i=1; i<=n; i++)
		{
			suma = suma + i;
		}
		
		return suma;
	}
	
	public float sumaDos(int n)
	{
		int i;
		float sumaFloat = 0;
		for(i=2; i<=n; i++)
		{
			sumaFloat = sumaFloat + (float)1/i;
		}
		
		return sumaFloat;
	}
	
	public float sumaTres(int n)
	{
		int i, cont = 1;
		float sumaFloat = 0;
		for(i=2; i<=n+1; i++)
		{
			sumaFloat = sumaFloat + (float)cont/i;
			cont++;
		}
		
		return sumaFloat;
	}
	
	public String operacionesUno(int n)
	{
		int i, suma = 0;
		String stri = "";
		for(i=1; i<=n; i++)
		{
			suma = suma + i;
			if(i != n)
			{
				stri = stri + i +" + ";
			}
			else
			{
				stri = stri + i;
			}
		}
		return stri;
	}
	
	public String operacionesDos(int n)
	{
		String stri="";
		int i;
		float sumaFloat = 0;
		for(i=2; i<=n; i++)
		{
			sumaFloat = sumaFloat + (float)1/i;
			if(i != n)
			{
				stri = stri + "1/" + i +" + ";
			}
			else
			{
				stri = stri + "1/" + i;
			}
		}
		return stri;
	}
	
	public String operacionesTres(int n)
	{
		String stri = "";
		int i, cont = 1;
		float sumaFloat = 0;
		for(i=2; i<=n+1; i++)
		{
			sumaFloat = sumaFloat + (float)cont/i;
			if(i != n+1)
			{
				stri = stri + cont + "/" + i +" + ";
			}
			else
			{
				stri = stri + cont + "/" + i;
			}
				cont++;
		}
		return stri;
	}	
		
	public String serieUNO(long n)
	{
		String stri="";
		int i;
		double iFact=0;
		double sumaFloat=1;
		
		if(n<=1234)
		{
			for(i=1; i<=n; i++)
			{
				iFact = fact(i+1);
				if(i != n)
				{
					stri = stri  + i + "/" + iFact + " + ";
				}
				else
				{
					stri = stri + i + "/" + iFact;
				}
				sumaFloat = sumaFloat + (double) i/iFact;
			}
			stri = stri + " = " + sumaFloat;
			
			if(n>=-1)
			{
				if(n==0)
				{
					stri = "La serie de 0 es = 1";
				}
				if(n==-1)
				{
					stri = "La serie de -1 es = 1";
				}
				if((n!=0) && (n!=-1))
				{
					stri = "La serie de "+ n  + " es:\n" + stri + " = "+sumaFloat;
				} 
			}
			
			else
			{
				stri = "La serie no funciona para números negativos\nmenores a -1, ya que el factorial de estos\nno existe.";
			}
		}
		else
			stri = "La serie tiende a 2";

		
		return stri;
		
	}
	//Calculadora
	public float calculadora(float n1, float n2, int op)
	{
		float res=0;
		
		switch (op)
		{
			case 1: 
				res = n1 + n2;
				
			break;
			
			case 2:
				res = n1 - n2; 
				
			break;
			
			case 3: 
				
			break;
			
			case 4: 
				
			break;
			
			case 5: 
				
			break;
			
			case 6: 
				
			break;
		}
		
		return 0;
	}
}