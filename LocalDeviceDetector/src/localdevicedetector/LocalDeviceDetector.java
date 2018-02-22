/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package localdevicedetector;

import java.net.Inet4Address;
import java.net.InetAddress;

/**
 *
 * @author JAY KUMAR
 */
public class LocalDeviceDetector {

    public static String getSubnet()throws Exception{
        InetAddress localHost = Inet4Address.getLocalHost();
        String str = localHost.getHostAddress();
        return str.substring(0, str.lastIndexOf('.'));
    }
    
   public static void checkHosts(String subnet)throws Exception{
       
       int timeout=2000;
       for (int i=1;i<254;i++){
           String host=subnet + "." + i;
           InetAddress inetAddr = InetAddress.getByName(host);
           System.out.println(host);
           if(InetAddress.getByName(host).isReachable(timeout)){
               //System.err.println(host + " is reachable");
               System.err.println(host+""+inetAddr.getHostName());
           }
        }
    }
    
    public static void main(String[] args) {
        try{
            String mask = getSubnet();
            System.out.println("Subnet mask : "+mask);
            checkHosts(mask);
        }catch(Exception ex){ex.printStackTrace();}
    }
}
