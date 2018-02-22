
import java.util.ArrayList;

public class ChannelBean {
    String channelName;
    String channelIp;
    String programs;
    
    
    public void setChannelName(String name){
        channelName = name;
    }
    public String getName(){
        return channelName;
    }
    public void setPrograms(String ob){
        programs =  ob;
    }
    public String getPrograms(){
        return programs;
    }
    public void setChannelIp(String ip){
        channelIp = ip;
    }
    public String getChannelIp(){
        return channelIp;
    }
    public String toString(){
        return channelName;
    }
}
