package read;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JFrame;


public class Canvas extends JPanel  implements MouseMotionListener{
	
	
	private int x,y;
	static BufferedImage image;
	static BufferedImage img;
	
	static Graphics gfx;	
	


	public Canvas() {		
		addMouseMotionListener(this);
		img = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
		gfx = img.createGraphics();
		
	        try {
	            // Lee la imagen desde un archivo
	            image = ImageIO.read(new File("Finn.jpg"));
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    
	}
	
        
    
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	    Graphics2D g2 = (Graphics2D) g;
        // Dibuja la imagen en el lienzo
        g2.drawImage(image, 50, 50, null);
        
		g.drawImage(img, 0, 0, null);
	    g.fillOval(x-5, y-5, 10, 10);
	    

	}

		
	
	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX(); //get the x and y coordinates of
		y = e.getY(); //the mouse click point
		
		repaint();
	}
	
	public Graphics getGraphic() {
		return gfx;
	}
	
}
