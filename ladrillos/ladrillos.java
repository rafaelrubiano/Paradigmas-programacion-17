package ladrillos;

import java.awt.*; 
import java.awt.event.*; 
import java.util.*; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import clases.bolita;
import clases.ladrillo;
import clases.miscolores;

public class ladrillos  extends JFrame implements WindowListener,  MouseListener, MouseMotionListener, Runnable
   {
      JPanel panel;
      bolita bola;
      int xbarra  = 220;
      int ybarra  = 380;
      int xpelota = 245;
      int ypelota = 369;
      int puntaje = 0;
      int vidas   = 3;
      int xdir    = -1;
      int ydir    = -1;
      int j       = 0;
	  int k       = 0;
	  Boolean activo = false;
      Graphics g;
      miscolores micolor = new miscolores();
      ladrillo [] arrayladrillos = new ladrillo[10];
      bolita wbolita;
      ladrillo wladrillo = new ladrillo();
	        
      public ladrillos()
         {
    	    llenaArrayLadrillos();
            panel = new JPanel();
    	    setTitle("COLORED BRICKS - Grupo 17");
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setBounds(400, 200, 510, 400);
		    panel.setBackground(Color.black);
		    panel.addMouseMotionListener(this);
		    panel.addMouseListener(this);
		    panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		    setContentPane(panel);
		    panel.setLayout(null);
	        JLabel lblNewLabel = new JLabel("vidas");
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        lblNewLabel.setForeground(Color.YELLOW);
		    lblNewLabel.setBounds(30, 0, 51, 14);
		    panel.add(lblNewLabel);
		    JLabel lblNewLabel_2 = new JLabel("Puntaje");
		    lblNewLabel_2.setForeground(Color.YELLOW);
		    lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		    lblNewLabel_2.setBounds(400, 0, 46, 14);
		    panel.add(lblNewLabel_2);
		    wbolita = new bolita(getWidth(), getHeight());
		 }
      
	@Override
	  public void run() 
	     {
		 }
	     
	
	  public void  paint(Graphics g )
         {
            super.paint(g);
            Graphics2D g2=(Graphics2D)g;
	        j = 50;
	        for (int i = 1; i <= vidas; i++)
	           {
	              j += 15;
	        	  g2.setColor(Color.white);
	        	  g2.fillRect(j, 25, 10, 10);
	        	  g2.setColor(Color.red);
	        	  g2.drawRect(j, 25, 10, 10);
	           }	
	        g2.drawString(String.valueOf(puntaje), 460, 36);
	        g2.setColor(Color.yellow);
	        for (int i = 0; i < 10; i++)
	           {
	        	  wladrillo.xposicion = arrayladrillos[i].xposicion;
	    	      wladrillo.yposicion = arrayladrillos[i].yposicion;
	    	      wladrillo.color     = arrayladrillos[i].color;
	    	      if (arrayladrillos[i].visible)
	    	         wladrillo.pintarLadrillo(g2);
	    	      else
	    	  	     wladrillo.borrarLadrillo(g2);
	    	   }
	        g2.setColor(Color.red);
  	        wladrillo.color = g2.getColor();
  	        wladrillo.xposicion = xbarra;
  	        wladrillo.yposicion = ybarra;
  	        wladrillo.pintarLadrillo(g2);
  	        wbolita.color = g2.getColor();
 	        wbolita.pintarBola(g2);
 	     }
	
	  public void movimiento()
	     {
		    if (activo == true)
		       {
		          wbolita.moverBola(xdir, ydir);
		    	  xdir = wbolita.reboteVertical(xdir);
		    	  ydir = wbolita.reboteHorizontal(ydir);
		    	  wladrillo.xposicion=xbarra;
		    	  wladrillo.yposicion=ybarra;
		    	  choqueBarraInferior();
		    	  choqueBarraSuperior();
		    	  if (puntaje == 100)
		    	     {
    			         JOptionPane.showMessageDialog(this, "¡CONGRATULATIONS!\n\n"+ "YOU ARE DE WINNER","IMPORTANT", JOptionPane.YES_NO_OPTION);
    			         reiniciaVariables();
		    	     }
		          if (wbolita.yposicion + 10 > this.getHeight()) 
		             {
		    		    wbolita.yposicion = 369;
		    			xbarra = wbolita.xposicion - 24;
		    			vidas -= 1;
		    		    if (vidas == 0)
		    	           {
 			                  JOptionPane.showMessageDialog(this, "¡UPS. YOU HAVE LOSED!\n\n","IMPORTANT", JOptionPane.YES_NO_OPTION);
 			                  reiniciaVariables();
		    	           }
		    		    activo = false;
		             }
		       }
		 }
	  
	  public void reiniciaVariables()
	     {
		    llenaArrayLadrillos();
	        wbolita.yposicion = 369;
	        xbarra = wbolita.xposicion - 24;
		    vidas  = 3;
		    puntaje = 0;
		    activo = false;
	     }
	
	  public void llenaArrayLadrillos()
	     {
		    int wx = 5;
	        int wy = 40;
            for (int i=0;i<10;i++) 
               {
                  ladrillo wladrillo = new ladrillo();
      	          wladrillo.xposicion = wx;
      	          wladrillo.yposicion = wy;
      	          wladrillo.color = micolor.retornaRgb();
      	          wladrillo.visible = true;
      	          wx += 50;
      	          arrayladrillos[i] = wladrillo;
              }
	     }
	  
	  public void choqueBarraInferior()
	     {
		    if (wbolita.limiteBola().intersects(wladrillo.limiteLadrillo()))
 	           {
 		          wbolita.yposicion = 369;
 			      ydir *= -1;
 	           }
	     }
	  
	  public void choqueBarraSuperior()
	     {
		    for (int i = 0; i < 10; i++)
 	           {
 		          wladrillo.xposicion = arrayladrillos[i].xposicion;
 			      wladrillo.yposicion = arrayladrillos[i].yposicion;
 			      if (wbolita.limiteBola().intersects(wladrillo.limiteLadrillo()) & arrayladrillos[i].visible == true)
 			         {
 			            JOptionPane.showMessageDialog(this, "You broke a \n\n"+ micolor.retornaStr(arrayladrillos[i].color).toUpperCase()+"\n\n brick", "BRICK BROKE", JOptionPane.YES_NO_OPTION);
 			            ydir *= -1;
 				        arrayladrillos[i].visible = false;
 				        arrayladrillos[i].color = Color.BLACK;
 				        wbolita.yposicion=58;
 				        puntaje += 10;
 				        break;
 			         }
 	           }
         }
	  
      @Override
	  
	  public void mouseDragged(MouseEvent e) 
	     {
		    // TODO Auto-generated method stub
		 }
	  
	  @Override
	  public void mouseMoved(MouseEvent e) 
         {
		    xbarra = e.getX();
		    if (xbarra > this.getWidth() - 52)
               xbarra = this.getWidth() - 52;
            if (activo == false)
		  	   {
			      wbolita.yposicion = 369;
			      wbolita.xposicion = xbarra + 24;
          	   }
		 }
	  
	  @Override
	  public void mouseClicked(MouseEvent e) 
	  	{
		  	activo = true;
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
