package bean;
// ** author @Jay K  **

public class CertificateBean{
  // Variables declaration - do not modify
    private int certificateId;
    private String certificateName;
    private int rate;
    private String remarks;




//Setter Methods Generated
    public void setCertificateId(int certificateId){
        this.certificateId = certificateId ;
    }
    public void setCertificateName(String certificateName){
        this.certificateName = certificateName ;
    }
    public void setRate(int rate){
        this.rate = rate ;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks ;
    }




//Getter Methods Generated
    public int getCertificateId(){
        return this.certificateId ;
    }
    public String getCertificateName(){
        return this.certificateName ;
    }
    public int getRate(){
        return this.rate ;
    }
    public String getRemarks(){
        return this.remarks ;
    }

    public String toString(){
        return certificateName;
       }
}
