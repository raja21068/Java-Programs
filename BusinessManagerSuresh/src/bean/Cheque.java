package bean;
// Generated Oct 29, 2013 9:01:18 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Cheque generated by hbm2java
 */
public class Cheque  implements java.io.Serializable {


     private Integer chequeId;
     private Account account;
     private SalePurchase salePurchase;
     private String chequeNumber;
     private Date chequeDate;
     private Date givenDate;

    public Cheque() {
    }

    public Cheque(Account account, SalePurchase salePurchase, String chequeNumber, Date chequeDate, Date givenDate) {
       this.account = account;
       this.salePurchase = salePurchase;
       this.chequeNumber = chequeNumber;
       this.chequeDate = chequeDate;
       this.givenDate = givenDate;
    }
   
    public Integer getChequeId() {
        return this.chequeId;
    }
    
    public void setChequeId(Integer chequeId) {
        this.chequeId = chequeId;
    }
    public Account getAccount() {
        return this.account;
    }
    
    public void setAccount(Account account) {
        this.account = account;
    }
    public SalePurchase getSalePurchase() {
        return this.salePurchase;
    }
    
    public void setSalePurchase(SalePurchase salePurchase) {
        this.salePurchase = salePurchase;
    }
    public String getChequeNumber() {
        return this.chequeNumber;
    }
    
    public void setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }
    public Date getChequeDate() {
        return this.chequeDate;
    }
    
    public void setChequeDate(Date chequeDate) {
        this.chequeDate = chequeDate;
    }
    public Date getGivenDate() {
        return this.givenDate;
    }
    
    public void setGivenDate(Date givenDate) {
        this.givenDate = givenDate;
    }

    @Override
    public String toString() {
        return chequeNumber; //To change body of generated methods, choose Tools | Templates.
    }



}

