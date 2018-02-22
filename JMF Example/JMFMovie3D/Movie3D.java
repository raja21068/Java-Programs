
// Movie3D.java
// Andrew Davison, May 2005, ad@fivedots.coe.psu.ac.th

/* Show a movie on a screen in the checkboard world.

   The movie filename is read from the command line, and is assumed
   to be in the movies/ subdirectory.

   The movie is played using JMF. Best results are achieved if
   the movie is in MPEG-1 format, and doesn't have an audio track. 

   The example in the subdirectory QTMovie3D is a version of this
   application that uses Quicktime for Java to manipulate movies.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Movie3D extends JFrame
{
  private WrapMovie3D w3d;

  public Movie3D(String fnm) 
  {
    super("Movie3D for " + fnm);

    Container c = getContentPane();
    c.setLayout( new BorderLayout() );
    w3d = new WrapMovie3D( "movies/" + fnm );
    c.add(w3d, BorderLayout.CENTER);

    // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    addWindowListener( new WindowAdapter() {
      public void windowClosing(WindowEvent e)
      { w3d.stopMovie();
        System.exit(0);
       }  
    });

    pack();
    setResizable(false);    // fixed size display
    setVisible(true);
  } // end of Movie3D()


// -----------------------------------------

  public static void main(String[] args)
  { 
    if (args.length != 1)
      System.out.println("Usage: java Movie3D <MPG file name>");
    else 
      new Movie3D(args[0]); 
  }

} // end of Movie3D class
