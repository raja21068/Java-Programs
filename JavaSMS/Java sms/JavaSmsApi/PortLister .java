import javax.comm.*;
import java.util.*;

class PortLister {
  public static void main(String[] args) throws Exception{
    Enumeration e = CommPortIdentifier.getPortIdentifiers();
    while (e.hasMoreElements()) {
      System.out.println(((CommPortIdentifier) e.nextElement()).getName());
    }
  }
}
