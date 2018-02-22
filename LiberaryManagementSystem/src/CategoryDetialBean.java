/*
* CategoryDetialBean.java
*
* Created on 02-Dec-2012 02:02:23 PM
*
*
* @author Raja Kumar
*/

public class CategoryDetialBean{
    private int catDetailId;
    private String name;
    private String publisher;
    private String author;
    private String edition;
    private String volume;
    private int yearOfPublishing;
    private String isbn;
    private String accessNo;
    private String drasNo;
    private int prise;
    private String purchaseFrom;
    private java.util.Date dateOfPurchase;
    private String remarks;

    /*Constructor*/
    public CategoryDetialBean() {}

    /*Setter Methods*/
    public void setCatDetailId(int catDetailId){
        this.catDetailId = catDetailId;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setEdition(String edition){
        this.edition = edition;
    }
    public void setVolume(String volume){
        this.volume = volume;
    }
    public void setYearOfPublishing(int yearOfPublishing){
        this.yearOfPublishing = yearOfPublishing;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    public void setAccessNo(String accessNo){
        this.accessNo = accessNo;
    }
    public void setDrasNo(String drasNo){
        this.drasNo = drasNo;
    }
    public void setPrise(int prise){
        this.prise = prise;
    }
    public void setPurchaseFrom(String purchaseFrom){
        this.purchaseFrom = purchaseFrom;
    }
    public void setDateOfPurchase(java.util.Date dateOfPurchase){
        this.dateOfPurchase = dateOfPurchase;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks;
    }

    /*Getter Methods*/
    public int getCatDetailId(){
        return this.catDetailId;
    }
    public String getName(){
        return this.name;
    }
    public String getPublisher(){
        return this.publisher;
    }
    public String getAuthor(){
        return this.author;
    }
    public String getEdition(){
        return this.edition;
    }
    public String getVolume(){
        return this.volume;
    }
    public int getYearOfPublishing(){
        return this.yearOfPublishing;
    }
    public String getIsbn(){
        return this.isbn;
    }
    public String getAccessNo(){
        return this.accessNo;
    }
    public String getDrasNo(){
        return this.drasNo;
    }
    public int getPrise(){
        return this.prise;
    }
    public String getPurchaseFrom(){
        return this.purchaseFrom;
    }
    public java.util.Date getDateOfPurchase(){
        return this.dateOfPurchase;
    }
    public String getRemarks(){
        return this.remarks;
    }

    //@Override
    public String toString(){
        return name;
    }
}
