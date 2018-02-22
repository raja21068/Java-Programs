
// WrapMovie3D.java
// Andrew Davison, May 2005, ad@fivedots.coe.psu.ac.th

/* Create a checkerboard world with a movie screen.

   The movie screen, and the timer for making the movie advance,
   are set up in addMovieScreen().

   The rest of the Java 3D code here has been copied from Checkers3D,
   the first Java 3D example in Chapter 15 of 
   "Killer Game Programming in Java"
   (http://fivedots.coe.psu.ac.th/~ad/jg)
*/

import javax.swing.*;
import java.awt.*;

import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.geometry.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.behaviors.vp.*;



public class WrapMovie3D extends JPanel
// Holds the 3D canvas where the loaded image is displayed
{
  private static final int PWIDTH = 512;   // size of panel
  private static final int PHEIGHT = 512; 

  private static final int BOUNDSIZE = 100;  // larger than world

  private static final Point3d USERPOSN = new Point3d(0,1.8,5.5);
    // initial user position

  private SimpleUniverse su;
  private BranchGroup sceneBG;
  private BoundingSphere bounds;   // for environment nodes

  private JMFMovieScreen ms;   // the movie screen
  private TimeBehavior timer;  // for updating the screen



  public WrapMovie3D(String fnm)
  // A panel holding a 3D canvas: the usual way of linking Java 3D to Swing
  {
    setLayout( new BorderLayout() );
    setOpaque( false );
    setPreferredSize( new Dimension(PWIDTH, PHEIGHT));

    GraphicsConfiguration config =
					SimpleUniverse.getPreferredConfiguration();
    Canvas3D canvas3D = new Canvas3D(config);
    add("Center", canvas3D);
    canvas3D.setFocusable(true);     // give focus to the canvas 
    canvas3D.requestFocus();

    su = new SimpleUniverse(canvas3D);

    createSceneGraph(fnm);
    initUserPosition();        // set user's viewpoint

    orbitControls(canvas3D);   // controls for moving the viewpoint
    
    su.addBranchGraph( sceneBG );
  } // end of WrapMovie3D()



  private void createSceneGraph(String fnm) 
  // initilise the scene
  { 
    sceneBG = new BranchGroup();
    bounds = new BoundingSphere(new Point3d(0,0,0), BOUNDSIZE);   

    lightScene();         // add the lights
    addBackground();      // add the sky
    sceneBG.addChild( new CheckerFloor().getBG() );  // add the floor

    addMovieScreen(fnm);

    sceneBG.compile();   // fix the scene
  } // end of createSceneGraph()


  private void lightScene()
  /* One ambient light, 2 directional lights */
  {
    Color3f white = new Color3f(1.0f, 1.0f, 1.0f);

    // Set up the ambient light
    AmbientLight ambientLightNode = new AmbientLight(white);
    ambientLightNode.setInfluencingBounds(bounds);
    sceneBG.addChild(ambientLightNode);

    // Set up the directional lights
    Vector3f light1Direction  = new Vector3f(-1.0f, -1.0f, -1.0f);
       // left, down, backwards 
    Vector3f light2Direction  = new Vector3f(1.0f, -1.0f, 1.0f);
       // right, down, forwards

    DirectionalLight light1 = 
            new DirectionalLight(white, light1Direction);
    light1.setInfluencingBounds(bounds);
    sceneBG.addChild(light1);

    DirectionalLight light2 = 
        new DirectionalLight(white, light2Direction);
    light2.setInfluencingBounds(bounds);
    sceneBG.addChild(light2);
  }  // end of lightScene()



  private void addBackground()
  // A blue sky
  { Background back = new Background();
    back.setApplicationBounds( bounds );
    back.setColor(0.17f, 0.65f, 0.92f);    // sky colour
    sceneBG.addChild( back );
  }  // end of addBackground()



  private void orbitControls(Canvas3D c)
  /* OrbitBehaviour allows the user to rotate around the scene, and to
     zoom in and out.  */
  {
    OrbitBehavior orbit = 
		new OrbitBehavior(c, OrbitBehavior.REVERSE_ALL);
    orbit.setSchedulingBounds(bounds);

    ViewingPlatform vp = su.getViewingPlatform();
    vp.setViewPlatformBehavior(orbit);	 
  }  // end of orbitControls()


  private void initUserPosition()
  // Set the user's initial viewpoint using lookAt()
  {
    ViewingPlatform vp = su.getViewingPlatform();
    TransformGroup steerTG = vp.getViewPlatformTransform();

    Transform3D t3d = new Transform3D();
    steerTG.getTransform(t3d);

    // args are: viewer posn, where looking, up direction
    t3d.lookAt( USERPOSN, new Point3d(0,0,0), new Vector3d(0,1,0));
    t3d.invert();

    steerTG.setTransform(t3d);
  }  // end of initUserPosition()



  // -------------------- movie screen -----------------------

  private void addMovieScreen(String fnm)
  {
    // put the movie specified on the command line onto a movie screen
    ms = new JMFMovieScreen( new Point3f(1.5f, 0, -1), 2.0f, fnm);
    sceneBG.addChild( ms );

    // set up the timer for animating the movie
    timer = new TimeBehavior(40, ms);  
           // update the movie every 40ms (== 25 frames/sec)
    timer.setSchedulingBounds( bounds );
    sceneBG.addChild( timer );
  }  // end of addMovieScreen()


  public void stopMovie()
  { timer.stopUpdate();    // shut down the timer
    ms.stopMovie();        // terminate the movie screen
  }  

} // end of WrapMovie3D class