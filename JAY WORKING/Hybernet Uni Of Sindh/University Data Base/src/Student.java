class Student{
  // Variables declaration - do not modify
    private int batchID;
    private int studentId;
    private String studentName;
    private String fName;
    private String surname;
    private String cNIC;
    private String rollNo;
    private String cellNo;
    private int group;
    private int shift;
    private String address;
    private String remarks;

    public Student(){}
    public Student(int batchID, String studentName, String fName, String surname, String cNIC, String rollNo, String cellNo, int group, int shift, String address, String remarks){
this.batchID = batchID;
this.studentName = studentName;
this.fName = fName;
this.surname = surname;
this.cNIC = cNIC;
this.rollNo = rollNo;
this.cellNo = cellNo;
this.group = group;
this.shift = shift;
this.address = address;
this.remarks = remarks;}



//Setter Methods Generated
    public void setBatchID(int batchID){
        this.batchID = batchID ;
    }
    public void setStudentId(int studentId){
        this.studentId = studentId ;
    }
    public void setStudentName(String studentName){
        this.studentName = studentName ;
    }
    public void setFName(String fName){
        this.fName = fName ;
    }
    public void setSurname(String surname){
        this.surname = surname ;
    }
    public void setCNIC(String cNIC){
        this.cNIC = cNIC ;
    }
    public void setRollNo(String rollNo){
        this.rollNo = rollNo ;
    }
    public void setCellNo(String cellNo){
        this.cellNo = cellNo ;
    }
    public void setGroup(int group){
        this.group = group ;
    }
    public void setShift(int shift){
        this.shift = shift ;
    }
    public void setAddress(String address){
        this.address = address ;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks ;
    }




//Getter Methods Generated
    public int getBatchID(){
        return this.batchID ;
    }
    public int getStudentId(){
        return this.studentId ;
    }
    public String getStudentName(){
        return this.studentName ;
    }
    public String getFName(){
        return this.fName ;
    }
    public String getSurname(){
        return this.surname ;
    }
    public String getCNIC(){
        return this.cNIC ;
    }
    public String getRollNo(){
        return this.rollNo ;
    }
    public String getCellNo(){
        return this.cellNo ;
    }
    public int getGroup(){
        return this.group ;
    }
    public int getShift(){
        return this.shift ;
    }
    public String getAddress(){
        return this.address ;
    }
    public String getRemarks(){
        return this.remarks ;
    }

    public String toString(){
        return studentName;
       }
}
