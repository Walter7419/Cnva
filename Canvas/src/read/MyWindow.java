package read;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;



public class MyWindow extends JFrame implements ActionListener , MouseListener , ChangeListener {
	
	JButton okButton, color;
	JPanel contentPane;
	Canvas canvas, paleta;
	JLabel red, green, blue;
	JSlider R, G, B;
	JLabel lbl;
	static Graphics g;	
	static BufferedImage img;
	
	int width, height, x, y;
	
	public MyWindow(int width, int height) {
	
		this.width = width;
		this.height = height;				
		
		components();		
		
		//img = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
		
		//g = img.createGraphics();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // al cerrar la ventana se detiene el programa
		setSize(width,height);							// tamaño de la ventana
		setLocationRelativeTo(null);					// centra la ventana
		setLayout(null);								// elimina plantillas
		setResizable(false);							// no permite modificar el tamaño de la ventana
		setVisible(true);								// muestra la ventana	

	}
			
	private void components()
	{
		contentPane = new JPanel();
		okButton 	= new JButton("Okk tuuu");
		lbl 		= new JLabel("");
		red 		= new JLabel("");
		green 		= new JLabel("");
		blue 		= new JLabel("");
		canvas 		= new Canvas();
		paleta		= new Canvas(); 


		R			= new JSlider(0, 255);
		G			= new JSlider(0, 255);
		B			= new JSlider(0, 255);

				
		contentPane.setLayout(null);
		contentPane.setBackground(Color.gray);
		contentPane.setBounds(0,0,width,height);//*/
				
		lbl.setBounds(0,0, width,height);
		lbl.setForeground(Color.white);
		lbl.setFont(new Font("Serif", Font.PLAIN, 70));
		
		red.setBounds(0,50, width,height);
		red.setForeground(Color.red);
		red.setFont(new Font("Serif", Font.PLAIN, 35));	
		
		green.setBounds(0,100, width,height);
		green.setForeground(Color.green);
		green.setFont(new Font("Serif", Font.PLAIN, 35));	
		
		blue.setBounds(0,150, width,height);
		blue.setForeground(Color.blue);
		blue.setFont(new Font("Serif", Font.PLAIN, 35));
		
		
		R.setBounds(0, 0, 330, 35);
		R.addChangeListener(this); //AGREGAR SLIDERS
		R.setBackground(Color.RED);
		G.setBounds(0, 50, 330, 35);
		G.addChangeListener(this);
		G.setBackground(Color.GREEN);
		B.setBounds(0, 100, 330, 35);
		B.addChangeListener(this);
		B.setBackground(Color.BLUE);
		
	    Color rgb 	= new Color(R.getValue(), G.getValue(), B.getValue());
		paleta		= new Canvas();	
		paleta.setBounds(350, 50,50,50);//---	

		
		okButton.setBounds(0, 750, 150, 30);
		okButton.addActionListener(this);	//AGREGAR BOTON

				
		canvas.setBounds((width/2 )- 250, (height/2) - 250,500,500);//---	
		canvas.addMouseListener(this);
		
		
		contentPane.add(R);
		contentPane.add(G);
		contentPane.add(B);


		contentPane.add(canvas);
		contentPane.add(paleta);


		contentPane.add(lbl);
		contentPane.add(red);
		contentPane.add(green);
		contentPane.add(blue);

		contentPane.add(okButton);
		
		add(contentPane);
		

	}
	
	public void actionPerformed(ActionEvent event) {				
			lbl.setText("HOLA TODOS !!!");	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		x = e.getX(); //get the x and y coordinates of
		y = e.getY();
		
	    Color rgb 	= new Color(R.getValue(), G.getValue(), B.getValue());

		canvas.getGraphic().setColor(new Color(R.getValue(), G.getValue(), B.getValue()));
		canvas.getGraphic().fillRect(x-10, y-10, 20, 20);
		canvas.getGraphic().setColor(new Color(R.getValue(), G.getValue(), B.getValue()));
		canvas.getGraphic().drawRect(x-10, y-10, 20, 20);
		//canvas.setImage(img);
		
		lbl.setText(x+" "+y);
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		new Color(R.getValue(), G.getValue(), B.getValue());
		paleta.setBackground(new Color(R.getValue(), G.getValue(), B.getValue()));


	}

	
	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {	}

	
}