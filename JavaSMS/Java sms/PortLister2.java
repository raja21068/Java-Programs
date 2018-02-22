import javax.comm.*;
import java.util.*;

class PortLister2 {
  public static void main(String[] args) throws Exception{
    Enumeration e = CommPortIdentifier.getPortIdentifiers();
    while (e.hasMoreElements()) {
//      System.out.println(((CommPortIdentifier) e.nextElement()).getName());

CommPortIdentifier id=(CommPortIdentifier) e.nextElement();
if(id.getPortType() == CommPortIdentifier.PORT_SERIAL){
	String portName=id.getName();
	System.out.println(portName);
}

    }
  }
}
