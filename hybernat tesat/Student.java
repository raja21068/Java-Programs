class Student{
  // Variables declaration - do not modify
    private int batchId;
    private int stdId;
    private String fname;
    private String surname;
    private String rollNo;
    private String remarks;
    private String stdName;
    private String cellNo;
    private byte[] stdPic;

    public Student(){}
public Student(int batchId, String fname, String surname, String rollNo, String remarks, String stdName, String cellNo, byte[] stdPic){
this.batchId = batchId;
this.fname = fname;
this.surname = surname;
this.rollNo = rollNo;
this.remarks = remarks;
this.stdName = stdName;
this.cellNo = cellNo;
this.stdPic = stdPic;}



//Setter Methods Generated
    public void setBatchId(int batchId){
        this.batchId = batchId ;
    }
    public void setStdId(int stdId){
        this.stdId = stdId ;
    }
    public void setFname(String fname){
        this.fname = fname ;
    }
    public void setSurname(String surname){
        this.surname = surname ;
    }
    public void setRollNo(String rollNo){
        this.rollNo = rollNo ;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks ;
    }
    public void setStdName(String stdName){
        this.stdName = stdName ;
    }
    public void setCellNo(String cellNo){
        this.cellNo = cellNo ;
    }
    public void setStdPic(byte[] stdPic){
        this.stdPic = stdPic ;
    }




//Getter Methods Generated
    public int getBatchId(){
        return this.batchId ;
    }
    public int getStdId(){
        return this.stdId ;
    }
    public String getFname(){
        return this.fname ;
    }
    public String getSurname(){
        return this.surname ;
    }
    public String getRollNo(){
        return this.rollNo ;
    }
    public String getRemarks(){
        return this.remarks ;
    }
    public String getStdName(){
        return this.stdName ;
    }
    public String getCellNo(){
        return this.cellNo ;
    }
    public byte[] getStdPic(){
        return this.stdPic ;
    }

    public String toString(){
        return "";
       }
}
