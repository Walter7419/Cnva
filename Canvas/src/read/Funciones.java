package read;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

	public class Funciones extends Canvas {
		  
		  public Funciones() {
		    setBackground(Color.WHITE); // Establecer el color de fondo del canvas
		  }
		  
		  public void paint(Graphics g) {
		    // Dibujar aquí en el canvas utilizando el objeto Graphics
		    g.setColor(Color.blue);
		    g.fillRect(50, 50, 100, 100);
		  }
		  
		  public static void main(String[] args) {
		    // Crear una ventana para mostrar el canvas
		    JFrame frame = new JFrame("Mi Canvas");
		    frame.setSize(200, 300);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
		    // Crear un nuevo canvas y agregarlo a la ventana
		    Funciones canvas = new Funciones();
		    frame.add(canvas);
		    
		    // Mostrar la ventana
		    frame.setVisible(true);
		  }
		}
	
		