import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class Mandelbrot {
	
	public double max_iteration, xmin, xmax, ymin, ymax;
	
	public int digits = 8;
	
	public MathContext mc = new MathContext(digits * digits + 1);
		
	public BigDecimal c = new BigDecimal(0.25);
	
	public BigDecimal hundred = new BigDecimal(100);
	
	public BigDecimal e = BigDecimal.ONE.divide(hundred.pow(digits - 1), mc);
	
	public BigDecimal z = BigDecimal.ZERO;
	
	public BigInteger iterations = BigInteger.ZERO;
	
	public BigDecimal two = new BigDecimal(2);
	
	
	public Mandelbrot()
	{
		this.max_iteration = 100;
		this.xmin = -2;
		this.xmax = 0.5;
		this.ymin = -1.25;
		this.ymax = 1.25;
		c = c.add(e);
	}
	
	public void mandelbrot_set(boolean couleur, Graphics2D g)
	{
		for(int i = 0; i < 700; i++)
		{
			for(int j = 0; j < 700; j++)
			{
				double cx = (i * (this.xmax - this.xmin) / 700 + this.xmin);
				double cy = (j * (this.ymin - this.ymax) / 700 + this.ymax);
				
				double xn = 0;
				double yn = 0;
				double n = 0;
				
				while((xn * xn + yn * yn) < 4 && n < this.max_iteration)
				{
					double tmp_x = xn;
					double tmp_y = yn;
					
					xn = tmp_x * tmp_x - tmp_y * tmp_y + cx;
		            yn = 2 * tmp_x * tmp_y + cy;
		            
		            n++;
				}
				
				if(!couleur)
				{
					if(n == this.max_iteration)
					{
						g.setColor(Color.black);
						g.fillRect(i, j, 1, 1);
					}
					else
					{
						g.setColor(Color.white);
						g.fillRect(i, j, 1, 1);
					}
				}
				else
				{
					if(n == this.max_iteration)
					{
						g.setColor(Color.black);
						g.fillRect(i, j, 1, 1);
					}
					else
					{
						g.setColor(new Color((int)((59 * n) % 256), (int)((19 * n) % 256),(int)((200 * n) % 256)));
						g.fillRect(i, j, 1, 1);
					}
				}				
			}
		}
		
		this.approximation_pi(g);
	}
	
	public void approximation_pi(Graphics2D g)
	{
		
		for(int i = 0; i < 25691; i++)
		{
			if (z.compareTo(two) == -1) 
			{
			      z = z.multiply(z, mc);
			      z = z.add(c, mc);
			      this.iterations = this.iterations.add(BigInteger.ONE);
			}
			else
			{
				break;
			}
		}
		
		g.setColor(Color.white);
		g.setFont(new Font("serif", Font.BOLD, 24));
		
		String s = iterations.toString();
		
		int diff = digits - s.length();
		
		for (int i = 0; i < diff; i++) 
		{
			s = '0' + s;
		}
		
		s = s.substring(0, 1) + '.' + s.substring(1, s.length());
		g.drawString("Pi = " + s, 10, 660);			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
