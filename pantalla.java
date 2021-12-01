package pantalla;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.color.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;

public class pantalla extends JFrame {
	
	public JPanel contentPane = new JPanel();
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantalla frame = new pantalla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public pantalla() 
	{
		setTitle("COLORED BRIKS");//pantalla frame = new pantalla(); 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 510, 400);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.BLACK);
		
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("     LIFE                                                                                                                                  SCORE");
		lblNewLabel.setForeground(Color.GREEN);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		setVisible(true);
	}

	public void dibujarrec(int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		Graphics g = contentPane.getGraphics ();
		g.setPaintMode();
		g.setColor   (Color.yellow);
		g.setPaintMode();
        g.fillOval   (i, j, 10, 10);        
        g.setColor   (Color.red); //le damos color rojo al contorno de la pelotita
        g.drawOval   (i, j, 10, 10); //ahora hacemos el contorno        
          g.setPaintMode();
	}

}
