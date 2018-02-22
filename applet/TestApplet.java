import java.applet.*;

public class TestApplet extends Applet{

   public void init(){
      System.out.println("I am init");
   }
   public void start(){
      System.out.println("I am start");
   }
   public void stop(){
      System.out.println("I am stop");
   }
   public void destroy(){
      System.out.println("I am destroy");
   }
}
