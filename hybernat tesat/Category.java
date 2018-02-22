class Category{
  // Variables declaration - do not modify
    private int catId;
    private String catName;
    private String remarks;

    public Category(){}
public Category(String catName, String remarks){
this.catName = catName;
this.remarks = remarks;}



//Setter Methods Generated
    public void setCatId(int catId){
        this.catId = catId ;
    }
    public void setCatName(String catName){
        this.catName = catName ;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks ;
    }




//Getter Methods Generated
    public int getCatId(){
        return this.catId ;
    }
    public String getCatName(){
        return this.catName ;
    }
    public String getRemarks(){
        return this.remarks ;
    }

    public String toString(){
        return "";
       }
}
