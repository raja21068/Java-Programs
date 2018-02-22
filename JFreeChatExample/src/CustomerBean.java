/*
* CustomerBean.java
*
* Created on 04-Nov-2012 01:06:25 AM
*
*
* @author Raja Kumar
*/

public class CustomerBean{
    private int id;
    private String castomerName;
    private String jan;
    private String feb;
    private String march;
    private String april;
    private String may;
    private String june;
    private String july;
    private String august;
    private String september;
    private String october;
    private String november;
    private String december;

    /*Constructor*/
    public CustomerBean() {}

    /*Setter Methods*/
    public void setId(int id){
        this.id = id;
    }
    public void setCastomerName(String castomerName){
        this.castomerName = castomerName;
    }
    public void setJan(String jan){
        this.jan = jan;
    }
    public void setFeb(String feb){
        this.feb = feb;
    }
    public void setMarch(String march){
        this.march = march;
    }
    public void setApril(String april){
        this.april = april;
    }
    public void setMay(String may){
        this.may = may;
    }
    public void setJune(String june){
        this.june = june;
    }
    public void setJuly(String july){
        this.july = july;
    }
    public void setAugust(String august){
        this.august = august;
    }
    public void setSeptember(String september){
        this.september = september;
    }
    public void setOctober(String october){
        this.october = october;
    }
    public void setNovember(String november){
        this.november = november;
    }
    public void setDecember(String december){
        this.december = december;
    }

    /*Getter Methods*/
    public int getId(){
        return this.id;
    }
    public String getCastomerName(){
        return this.castomerName;
    }
    public String getJan(){
        return this.jan;
    }
    public String getFeb(){
        return this.feb;
    }
    public String getMarch(){
        return this.march;
    }
    public String getApril(){
        return this.april;
    }
    public String getMay(){
        return this.may;
    }
    public String getJune(){
        return this.june;
    }
    public String getJuly(){
        return this.july;
    }
    public String getAugust(){
        return this.august;
    }
    public String getSeptember(){
        return this.september;
    }
    public String getOctober(){
        return this.october;
    }
    public String getNovember(){
        return this.november;
    }
    public String getDecember(){
        return this.december;
    }

    //@Override
    public String toString(){
        return "";
    }
}
