
// TimeBehavior.java
// Andrew Davison, April 2005, ad@fivedots.coe.psu.ac.th

/* Update the movie every timeDelay ms by calling
   the movie screen's nextFrame() method.
   This class is the Java 3D version of a Timer.
*/

import java.util.Enumeration;
import javax.media.j3d.*;


public class TimeBehavior extends Behavior
{
  private WakeupCondition timeOut;
  private JMFMovieScreen ms;
  private boolean isStopped = false;


  public TimeBehavior(int timeDelay, JMFMovieScreen ms)
  { this.ms = ms;
    timeOut = new WakeupOnElapsedTime(timeDelay);
  }

  public void initialize()
  { wakeupOn( timeOut );
  }

  public void processStimulus( Enumeration criteria )
  { // ignore criteria
    if (!isStopped) {
      ms.nextFrame();
      wakeupOn( timeOut );
    }
  } // end of processStimulus()


  public void stopUpdate()
  {  isStopped = true;  }


}  // end of TimeBehavior class
