class CategoryDetial{
  // Variables declaration - do not modify
    private int catDetailId;
    private int catId;
    private String bookName;
    private String publisher;
    private String authir;
    private String edition;
    private String volume;
    private String yearOfPublishing;
    private String isbn;
    private String accessNo;
    private String drasNo;
    private int prise;
    private String purchaseFrom;
    private String dateOfPurchase;
    private String remarks;

    public CategoryDetial(){}
public CategoryDetial(int catId, String bookName, String publisher, String authir, String edition, String volume, String yearOfPublishing, String isbn, String accessNo, String drasNo, int prise, String purchaseFrom, String dateOfPurchase, String remarks){
this.catId = catId;
this.bookName = bookName;
this.publisher = publisher;
this.authir = authir;
this.edition = edition;
this.volume = volume;
this.yearOfPublishing = yearOfPublishing;
this.isbn = isbn;
this.accessNo = accessNo;
this.drasNo = drasNo;
this.prise = prise;
this.purchaseFrom = purchaseFrom;
this.dateOfPurchase = dateOfPurchase;
this.remarks = remarks;}



//Setter Methods Generated
    public void setCatDetailId(int catDetailId){
        this.catDetailId = catDetailId ;
    }
    public void setCatId(int catId){
        this.catId = catId ;
    }
    public void setBookName(String bookName){
        this.bookName = bookName ;
    }
    public void setPublisher(String publisher){
        this.publisher = publisher ;
    }
    public void setAuthir(String authir){
        this.authir = authir ;
    }
    public void setEdition(String edition){
        this.edition = edition ;
    }
    public void setVolume(String volume){
        this.volume = volume ;
    }
    public void setYearOfPublishing(String yearOfPublishing){
        this.yearOfPublishing = yearOfPublishing ;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn ;
    }
    public void setAccessNo(String accessNo){
        this.accessNo = accessNo ;
    }
    public void setDrasNo(String drasNo){
        this.drasNo = drasNo ;
    }
    public void setPrise(int prise){
        this.prise = prise ;
    }
    public void setPurchaseFrom(String purchaseFrom){
        this.purchaseFrom = purchaseFrom ;
    }
    public void setDateOfPurchase(String dateOfPurchase){
        this.dateOfPurchase = dateOfPurchase ;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks ;
    }




//Getter Methods Generated
    public int getCatDetailId(){
        return this.catDetailId ;
    }
    public int getCatId(){
        return this.catId ;
    }
    public String getBookName(){
        return this.bookName ;
    }
    public String getPublisher(){
        return this.publisher ;
    }
    public String getAuthir(){
        return this.authir ;
    }
    public String getEdition(){
        return this.edition ;
    }
    public String getVolume(){
        return this.volume ;
    }
    public String getYearOfPublishing(){
        return this.yearOfPublishing ;
    }
    public String getIsbn(){
        return this.isbn ;
    }
    public String getAccessNo(){
        return this.accessNo ;
    }
    public String getDrasNo(){
        return this.drasNo ;
    }
    public int getPrise(){
        return this.prise ;
    }
    public String getPurchaseFrom(){
        return this.purchaseFrom ;
    }
    public String getDateOfPurchase(){
        return this.dateOfPurchase ;
    }
    public String getRemarks(){
        return this.remarks ;
    }

    public String toString(){
        return "";
       }
}
