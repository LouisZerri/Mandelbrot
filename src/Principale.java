import javax.swing.JFrame;

public class Principale {
	
	public static void main(String[] args) {
		
		JFrame object = new JFrame(); //instance JFrame
		
		Sketch s = new Sketch();
		
		object.setBounds(10,10,700,700); //Dimension de la fenetre
		object.setTitle("Mandelbrot Set"); //Titre de la fenetre
		
		object.setResizable(false); //Non redimensionable
		
		object.setVisible(true); //Creation d'une fenêtre
		
		object.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		object.add(s);
	}
	
	
}
