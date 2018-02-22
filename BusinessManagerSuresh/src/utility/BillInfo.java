package utility;

/**
 *
 * @author Jay Kumar
 */
public class BillInfo{

    public int transactionId;
    public int productId;
    public String productName;
    public  double quantity;
    public double rate;

    public BillInfo(){}
    public BillInfo(int trId , int proId, String pName, double quan, double rat){
        transactionId = trId;
        productId = proId;
        productName = pName;
        quantity = quan;
        rate = rat;
    }
    
    @Override
    public String toString() {
        return productName; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}    
