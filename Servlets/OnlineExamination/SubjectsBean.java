/*
* SubjectsBean.java
*
* Created on 17-Mar-2013 12:17:26 PM
*
*
* @author Raja Kumar
*/

public class SubjectsBean{
    private int subId;
    private String subName;
    private String remarks;

    /*Constructor*/
    public SubjectsBean() {}

    /*Setter Methods*/
    public void setSubId(int subId){
        this.subId = subId;
    }
    public void setSubName(String subName){
        this.subName = subName;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks;
    }

    /*Getter Methods*/
    public int getSubId(){
        return this.subId;
    }
    public String getSubName(){
        return this.subName;
    }
    public String getRemarks(){
        return this.remarks;
    }

    //@Override
    public String toString(){
        return "";
    }
}
