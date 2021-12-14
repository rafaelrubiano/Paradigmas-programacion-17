package clases;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class bolita extends Objeto
   {
      public int diametro;
      public int anchomarco;
      public int largomarco;
      
      public bolita(int a, int l)
         {
    	    super();
    	    xposicion  = 245;
    	    yposicion  = 369;
    	    diametro   = 10;
    	    anchomarco = a;
    	    largomarco = l;
         }
   
      public void pintarBola(Graphics2D g)
         {
  		    g.fillOval(xposicion,yposicion,diametro,diametro);	
  		    g.setColor(Color.red);
  		    g.drawOval(xposicion, yposicion,diametro, diametro);
  	     }
      
      public void moverBola(int x, int y)
         {
    	    xposicion += 5 * x;
    	    yposicion += 5 * y;
      	 }
      
      public int reboteVertical(int x)
         {
    	    if (xposicion < 0)
    	       {
   	              x = x *= -1;
   	              xposicion = 10;
    	       }
    	    else
    	       if (xposicion> anchomarco-11)
    	          {
    	    	     xposicion = anchomarco -diametro-1;
    	    	     x *= -1;
    	          }
    	    return x;
         }
      
      public int reboteHorizontal(int y)
         {
 	        if (yposicion < 22)
 	           {	
	              y = y *= -1;
 	              yposicion = 22;
 	           }
 	        else
 	           if (yposicion > largomarco-6)
 	              {
 	        	     yposicion = largomarco-diametro - 16;
 	        	     y *= -1;
 	              }
 	        return y;
         }
      
      public Rectangle limiteBola()
         {
  		    return new Rectangle(xposicion, yposicion, diametro, diametro );
  		 }
   }
