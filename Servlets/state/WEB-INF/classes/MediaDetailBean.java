
public class MediaDetailBean{
    private int mediaId;
    private int propertyDetailId;
    private String mediaName;


    /*Setter Methods*/
    public void setMediaId(int mediaId){
        this.mediaId = mediaId;
    }
    public void setPropertyDetailId(int propertyDetailId){
        this.propertyDetailId = propertyDetailId;
    }
    public void setMediaName(String mediaName){
        this.mediaName = mediaName;
    }

    /*Getter Methods*/
    public int getMediaId(){
        return this.mediaId;
    }
    public int getPropertyDetailId(){
        return this.propertyDetailId;
    }
    public String getMediaName(){
        return this.mediaName;
    }

    //@Override
    public String toString(){
        return "";
    }
}
