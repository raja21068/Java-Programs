/*
* BookIssueBean.java
*
* Created on 02-Dec-2012 02:02:22 PM
*
*
* @author Raja Kumar
*/

public class BookIssueBean{
    private int issueId;
    private int catDetailId;
    private java.util.Date dateOfIssue;
    private java.util.Date dateOfReturn;
    private int fineAmount;
    private String remarks;
    private String departmentName;
    private int batchYear;
    private String studentName;
    private String rollNo;

    /*Constructor*/
    public BookIssueBean() {}

    /*Setter Methods*/
    public void setIssueId(int issueId){
        this.issueId = issueId;
    }
    public void setCatDetailId(int catDetailId){
        this.catDetailId = catDetailId;
    }
    public void setDateOfIssue(java.util.Date dateOfIssue){
        this.dateOfIssue = dateOfIssue;
    }
    public void setDateOfReturn(java.util.Date dateOfReturn){
        this.dateOfReturn = dateOfReturn;
    }
    public void setFineAmount(int fineAmount){
        this.fineAmount = fineAmount;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks;
    }
    public void setDepartmentName(String departmentName){
        this.departmentName = departmentName;
    }
    public void setBatchYear(int batchYear){
        this.batchYear = batchYear;
    }
    public void setStudentName(String studentName){
        this.studentName = studentName;
    }
    public void setRollNo(String rollNo){
        this.rollNo = rollNo;
    }

    /*Getter Methods*/
    public int getIssueId(){
        return this.issueId;
    }
    public int getCatDetailId(){
        return this.catDetailId;
    }
    public java.util.Date getDateOfIssue(){
        return this.dateOfIssue;
    }
    public java.util.Date getDateOfReturn(){
        return this.dateOfReturn;
    }
    public int getFineAmount(){
        return this.fineAmount;
    }
    public String getRemarks(){
        return this.remarks;
    }
    public String getDepartmentName(){
        return this.departmentName;
    }
    public int getBatchYear(){
        return this.batchYear;
    }
    public String getStudentName(){
        return this.studentName;
    }
    public String getRollNo(){
        return this.rollNo;
    }

    //@Override
    public String toString(){
        return studentName;
    }
}
