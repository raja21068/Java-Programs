public class TransactionBean {
    private int dayId;
    private int accountId;
    private java.util.Date date;
    private int salePuchaseId;
    private int productId;
    private int transactionId;
    private int quantity;
    private int amount;
    private int type;
    public int getDayId(){
        return dayId;
    }
    public int getAccountId(){
        return accountId;
    }
    public void setDate(java.util.Date day){
        this.date = day;
    }
    public int getSalePuchaseId(){
        return salePuchaseId;
    }
    public int getProductId(){
        return productId;
    }
     public java.util.Date getdate(){
       return this.date; 
    }
    public int getTransactionId(){
        return transactionId;
    }
    public int getQuantity(){
        return quantity;
    }
    public int getAmount(){
        return amount;
    }
    public int getType(){
        return type;
    }
    
    
    public void setDayId(int i){
        dayId = i;
    }
    public void setAccountId(int aI){
        accountId = aI;
    }
    public void setSalePuchaseId(int saleId){
        salePuchaseId = saleId;
    }
    public void setTransactionId(int t){
        transactionId = t;
    }
    public void setProductId(int p){
        productId = p;
    }
    public void setQuantity(int q){
        quantity = q;
    }
    public void setAmount(int a){
        amount = a;
    }
    public void setType(int t){
        type = t;
    }
}
