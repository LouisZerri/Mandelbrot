import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Sketch extends JPanel implements ActionListener {
	
	public Timer timer;
	public int delay = 1;
	
	public Mandelbrot m;
	
	public Sketch()
	{
				
		timer = new Timer(delay,this);
		timer.start();
		m = new Mandelbrot();		
	}
	
	
	public void paint(Graphics g)
	{
		
		m.mandelbrot_set(true, (Graphics2D) g);
		
		
		
		g.dispose();
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		timer.start();
		
		repaint();
	}

}
