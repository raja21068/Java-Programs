package bean;
// ** author @Jay K  **

public class ProgramBean{
  // Variables declaration - do not modify
    private int progId;
    private String programTitle;
    private int semDuration;
    private String remarks;
    private String degreeTitle;




//Setter Methods Generated
    public void setProgId(int progId){
        this.progId = progId ;
    }
    public void setProgramTitle(String programTitle){
        this.programTitle = programTitle ;
    }
    public void setSemDuration(int semDuration){
        this.semDuration = semDuration ;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks ;
    }
    public void setDegreeTitle(String degreeTitle){
        this.degreeTitle = degreeTitle ;
    }




//Getter Methods Generated
    public int getProgId(){
        return this.progId ;
    }
    public String getProgramTitle(){
        return this.programTitle ;
    }
    public int getSemDuration(){
        return this.semDuration ;
    }
    public String getRemarks(){
        return this.remarks ;
    }
    public String getDegreeTitle(){
        return this.degreeTitle ;
    }

    public String toString(){
        return "";
       }
}
