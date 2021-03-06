package bean;
// Generated Oct 30, 2013 3:01:14 AM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;

/**
 * DiscountCode generated by hbm2java
 */
public class DiscountCode  implements java.io.Serializable {


     private char discountCode;
     private BigDecimal rate;

    public DiscountCode() {
    }

	
    public DiscountCode(char discountCode) {
        this.discountCode = discountCode;
    }
    public DiscountCode(char discountCode, BigDecimal rate) {
       this.discountCode = discountCode;
       this.rate = rate;
    }
   
    public char getDiscountCode() {
        return this.discountCode;
    }
    
    public void setDiscountCode(char discountCode) {
        this.discountCode = discountCode;
    }
    public BigDecimal getRate() {
        return this.rate;
    }
    
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }




}


