public class ProductBean {
    private int productId;
    private String productName;
    private int quantity;
    private int rate;
    private String remarks;
    
    // Setter Methods**
    public void setProductId(int productId){
        this.productId = productId;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setRate(int rate){
        this.rate = rate;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks;
    }
    // Getter Methods**
        public int getProductId(){
        return this.productId;
    }
    public String getProductName(){
        return this.productName;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public int getRate(){
        return this.rate;
    }
    public String getRemarks(){
        return this.remarks;
    }
     public String toString(){
        return this.productName;
    }
   
}
