import ladrillos.ladrillos;

class Main
   {
	  public static void main (String [] Args)
	     {
            ladrillos juego = new ladrillos();
            juego.setVisible(true);
            while (true)
               {
                  juego.repaint();
            	  juego.movimiento();
            	  try 
            	     {
            		    Thread.sleep(30);
            		 } 
            	  catch (InterruptedException e) 
            	     {
            		    e.printStackTrace();
            		 }
               }
		}
   }
