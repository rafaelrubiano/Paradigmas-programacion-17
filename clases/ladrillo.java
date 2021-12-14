package clases;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class ladrillo extends Objeto
   {
      public int ancho;
      public int largo;

      public ladrillo()
         {
	        super();
            this.ancho = 48;
            this.largo = 15;
         }
   
      public void pintarLadrillo(Graphics2D g)
         {
    	    g.setColor(this.color);
    	    g.fillRect(xposicion, yposicion, ancho, largo);
    	    g.setColor(Color.white);
    	    g.drawRect(xposicion, yposicion, ancho, largo);	
	     }
      
      public void pintarLadrillo2(Graphics2D g)
      {
    	   	  g.setColor(this.color);
 	          g.fillRect(xposicion, yposicion, 148, 45);
 	          g.setColor(Color.white);
 	          g.drawRect(xposicion, yposicion, 148, 45);	
 	          try 
 	             {
			        Thread.sleep(5);
		         } 
 	          catch (InterruptedException e) 
 	             {
			        // TODO Auto-generated catch block
			        e.printStackTrace();
		         }
	      }
 	  
      
      public void borrarLadrillo(Graphics2D g)
         {
 	        g.setColor(Color.black);
 	        g.fillRect(xposicion, yposicion, ancho, largo);
 	        g.drawRect(xposicion, yposicion, ancho, largo);
 	        g.setColor(Color.black);
 	        g.drawRect(xposicion, yposicion, ancho, largo);	
	     }
      
      public Rectangle limiteLadrillo()
         {
  		    return new Rectangle(xposicion,yposicion, ancho,largo );
  	     }
   }