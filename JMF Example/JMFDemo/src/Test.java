import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;

public class Test {
    public static void main(String arg[]){
        CaptureDeviceInfo info = CaptureDeviceManager.getDevice("vfw://0");
        System.out.println();
    }
}
