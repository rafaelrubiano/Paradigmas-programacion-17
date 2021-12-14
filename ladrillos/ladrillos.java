package ladrillos;

import java.awt.*; //para el frame y demas
import java.awt.event.*; //para los eventos
import java.util.*; //para el random

import pantalla.pantalla;

public class ladrillos  extends Frame implements WindowListener,  MouseListener, MouseMotionListener, Runnable
   {
      public int xbarra;
      public int ybarra;
      public int puntaje;
      Panel panel =new Panel();    
      
      public ladrillos()
         {
    	  
    	   /* xbarra = 220; 
    	   // setSize(510, 400); //le damos el tamaño a la pantalla
            add(panel); //agregamos el panel
            panel.setBackground(Color.black); //lo pintamos de negro
            panel.addMouseMotionListener(this); //le decimos que escuche el evento de mover el mouse
            panel.addMouseListener(this); //le decimos que escuche los click del mouse
            //px = 260; 
            //py = this.getHeight() - 60;*/
    	  
            
         }
      
	@Override
	public void run() {
		// TODO Auto-generated method stub
		pantalla jf = new pantalla();
		jf.dibujarrec(10,10,20,20);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
   }
