
// JMFMovieScreen.java
// Andrew Davison, May 2005, ad@fivedots.coe.psu.ac.th

/* JMFMovieScreen is a 3D movie screen, which shows the movie
   specified in 'movieFnm'. The movie is played in a loop, 
   continuously.

   The movie screen is a QuadArray, with sides proportional to 
   the movie's image size, but with a maximum dimension (width or 
   height) of 'screenSize'. The base of the quad is centered upon 
   the 'base' point and oriented along  the +z axis.

   The movie is loaded and played using JMFSnapper, and the current 
   frame is extracted from the JMFSnapper object by calling its
   getFrame() method.

   The movie screen is updated a frame at a time, by having a 
   TimeBehavior object call this class' nextFrame() method
   every few milliseconds (typically every 40 ms so the the frame 
   rate is 25 frames/sec). nextFrame() calls getFrame() in JMFSnapper.

   The frame is retrieved as a BufferedImage object of type
   BufferedImage.TYPE_3BYTE_BGR, and dimensions 
   FORMAT_SIZE x FORMAT_SIZE. It is used as a texture for the
   quad.

   -----
   The Java 3D parts of this class are derived from the ImageCsSeries 
   class used in the
   First Person Shooter (FPS) example in Chapter 24 of 
   "Killer Game Programming in Java"
   (http://fivedots.coe.psu.ac.th/~ad/jg)

*/

import java.awt.image.*;

import javax.vecmath.*;
import javax.media.j3d.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.*;


public class JMFMovieScreen extends Shape3D
{
  private static final int NUM_VERTS = 4;
  private static final int FORMAT_SIZE = 128;   // the BufferedImage dimensions

  private Texture2D texture;
  private ImageComponent2D ic;
    /* the texture uses ImageComponent2D, which uses the BufferedImage frames
       retrieved from the movie */

  private JMFSnapper snapper;    // the object that takes 'snaps' of the movie
  private boolean isStopped = false;


  public JMFMovieScreen(Point3f base, float screenSize, String movieFnm) 

  { 
    // load and play the movie
    snapper = new JMFSnapper(movieFnm);

    // retrieve the current frame of the movie
    BufferedImage im = snapper.getFrame();

    // prepare the ImageComponent2D object
    ic = new ImageComponent2D(ImageComponent2D.FORMAT_RGB, 
                                   FORMAT_SIZE, FORMAT_SIZE, true, true);
    /* The ImageComponent2D object sets both its "by reference" and 'Y-up"
       arguments to true. 

       These flags _should_ reduce the memory needed to store the image, since 
       Java 3D will avoid copying it from the application space into graphics 
       memory. However, it's also necessary to use specfic formats for
       the ImageComponent2D and BufferedImage objects.

       In a Win32/OpenGL combination, the ImageComponent format should be 
       ImageComponent.FORMAT_RGB (as here), and the BufferedImage format
       BufferedImage.TYPE_3BYTE_BGR. This BufferedImage format
       is fixed in JMFSnapper.

       More performance details can be found at
          http://www.j3d.org/tutorials/quick_fix/perf_guide_1_3.html
    */

	ic.setCapability(ImageComponent2D.ALLOW_IMAGE_WRITE);
         // the image will be changing

    createGeometry(base, screenSize);
    createAppearance(im); 
  } // end of JMFMovieScreen()


  private void createGeometry(Point3f c, float sz)
  {
    QuadArray plane = new QuadArray(NUM_VERTS, 
							GeometryArray.COORDINATES |
							GeometryArray.TEXTURE_COORDINATE_2 );

    // get the movie image's dimensions
    int imW = snapper.getImageWidth();
    int imH = snapper.getImageHeight();

    // get the quad's default dimensions (equal to the screen size, sz)
    float scrW = sz;
    float scrH = sz;

    /* The aim is to adjust the size of the quad so that it's dimensions
       are proportional to those of the movie image. Also the largest
       dimension (width or height) should be equal to the specified
       screen size (sz).
    */
    if (imW > imH)             // image width is biggest dimension
      scrH = (sz/imW) * imH;     // so reduce the screen's height
    else                       // else image height is biggest
      scrW = (sz/imH) * imW;     // so reduce the screen's width

    /* The screen base is centered at the base point (c), facing 
       along the +z axis. */
    Point3f p1 = new Point3f(c.x-scrW/2, c.y, c.z);
    Point3f p2 = new Point3f(c.x+scrW/2, c.y, c.z);
    Point3f p3 = new Point3f(c.x+scrW/2, c.y+scrH, c.z);
    Point3f p4 = new Point3f(c.x-scrW/2, c.y+scrH, c.z);

    // anti-clockwise from bottom left
    plane.setCoordinate(0, p1);
    plane.setCoordinate(1, p2);
    plane.setCoordinate(2, p3);
    plane.setCoordinate(3, p4);

/*
    TexCoord2f q = new TexCoord2f();
    q.set(0.0f, 0.0f);    
    plane.setTextureCoordinate(0, 0, q);
    q.set(1.0f, 0.0f);   
    plane.setTextureCoordinate(0, 1, q);
    q.set(1.0f, 1.0f);    
    plane.setTextureCoordinate(0, 2, q);
    q.set(0.0f, 1.0f);   
    plane.setTextureCoordinate(0, 3, q);  
*/

    /* The usual ordering for texture coordinates is to start at the bottom 
       left of the quad, and specify them anti-clockwise (see above). However, 
       since the ImageComponent2D object uses Y-UP, the ordering of the 
       texture points must be flipped around the horizontal axis.
    */
    TexCoord2f q = new TexCoord2f();
    q.set(0.0f, 0.0f);    
    plane.setTextureCoordinate(0, 3, q);  // (0,0) tex coord --> top left of quad
    q.set(1.0f, 0.0f);   
    plane.setTextureCoordinate(0, 2, q);  // (1,0) --> top right
    q.set(1.0f, 1.0f);    
    plane.setTextureCoordinate(0, 1, q);  // (1,1) --> bottom right
    q.set(0.0f, 1.0f);   
    plane.setTextureCoordinate(0, 0, q);  // (0,1) --> bottom left

    setGeometry(plane);
  }  // end of createGeometry()


  private void createAppearance(BufferedImage im)
  {                       
    Appearance app = new Appearance();

    // see the texture from both sides
    PolygonAttributes pa = new PolygonAttributes();
    pa.setCullFace(PolygonAttributes.CULL_NONE);   
    app.setPolygonAttributes(pa);

    // Create a two dimensional texture with magnification filtering
    texture = new Texture2D(Texture2D.BASE_LEVEL, Texture.RGBA,
                                               FORMAT_SIZE, FORMAT_SIZE);
    texture.setCapability(Texture.ALLOW_IMAGE_WRITE);   // texture can change
    texture.setMagFilter(Texture2D.BASE_LEVEL_LINEAR);   
         // this setting noticably reduces pixilation on the screen

    // set the texture from the retrieved movie frame
    ic.set(im);
    texture.setImage(0,ic);

    app.setTexture(texture);
    setAppearance(app);
  }  // end of createAppearance()


  public void nextFrame()
  /* Get the current movie frame (as a BufferedImage object),
     load it into the ImageComponent2D object, then into the 
     texture for the quad. 
  */
  { if (isStopped)    // the movie has been stopped
      return;
 
    BufferedImage im = snapper.getFrame();
    if (im != null) {
      ic.set(im);
      texture.setImage(0,ic);
    }
    else
      System.out.println("Null BufferedImage");
  }  // end of nextFrame()


  public void stopMovie()
  { isStopped = true;
    snapper.stopMovie();  
  }

} // end of JMFMovieScreen class