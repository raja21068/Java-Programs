class Faculty{
  // Variables declaration - do not modify
    private int facId;
    private String facName;
    private String remarks;

    public Faculty(){}
public Faculty(String facName, String remarks){
this.facName = facName;
this.remarks = remarks;}



//Setter Methods Generated
    public void setFacId(int facId){
        this.facId = facId ;
    }
    public void setFacName(String facName){
        this.facName = facName ;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks ;
    }




//Getter Methods Generated
    public int getFacId(){
        return this.facId ;
    }
    public String getFacName(){
        return this.facName ;
    }
    public String getRemarks(){
        return this.remarks ;
    }

    public String toString(){
        return "";
       }
}
