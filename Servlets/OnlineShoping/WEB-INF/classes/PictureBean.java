/*
* PictureBean.java
*
* Created on 09-Mar-2013 11:16:35 AM
*
*
* @author Raja Kumar
*/

public class PictureBean{
    private int pictureId;
    private int vehicalId;
    private String picturePath;
    private String remarks;

    /*Constructor*/
    public PictureBean() {}

    /*Setter Methods*/
    public void setPictureId(int pictureId){
        this.pictureId = pictureId;
    }
    public void setVehicalId(int vehicalId){
        this.vehicalId = vehicalId;
    }
    public void setPicturePath(String picturePath){
        this.picturePath = picturePath;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks;
    }

    /*Getter Methods*/
    public int getPictureId(){
        return this.pictureId;
    }
    public int getVehicalId(){
        return this.vehicalId;
    }
    public String getPicturePath(){
        return this.picturePath;
    }
    public String getRemarks(){
        return this.remarks;
    }

    //@Override
    public String toString(){
        return "";
    }
}
