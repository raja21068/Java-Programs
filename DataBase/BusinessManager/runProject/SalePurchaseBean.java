
public class SalePurchaseBean {
    private int dayId;
    private int accountId;
    private int salePuchaseId;
    private String billNo;
    private java.util.Date day;
    private int totalAmount;
    private int type;
    private String remarks;
    
    public int getDayId(){
        return dayId;
    }
    public int getAccountId(){
        return accountId;
    }
    public int getSalePuchaseId(){
        return salePuchaseId;
    }
    public String getBillNo(){
        return billNo;
    }
    public java.util.Date getDay(){
        return day;
    }
    public int getTotalAmount(){
        return totalAmount;
    }
    public int getType(){
        return type;
    }
    public String getRemarks(){
        return this.remarks;
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
    public void setBillNo(String b){
        billNo = b;
    }
    public void setDay(java.util.Date d){
         day = d;
    }
    public void setTotalAmount(int t){
        totalAmount = t;
    }
    public void setType(int t){
        type = t;
    }
     public void setRemarks(String remark){
        this.remarks = remark;
    }
     public String toString(){
         return TypeDecoder.typeDecode(type)+" - "+totalAmount ;
     } 
}
