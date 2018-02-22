class Faculty{
  // Variables declaration - do not modify
    private int factId;
    private String factName;
    private String remarks;

    public Faculty(){}
    public Faculty(String factName, String remarks){
this.factName = factName;
this.remarks = remarks;}



//Setter Methods Generated
    public void setFactId(int factId){
        this.factId = factId ;
    }
    public void setFactName(String factName){
        this.factName = factName ;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks ;
    }




//Getter Methods Generated
    public int getFactId(){
        return this.factId ;
    }
    public String getFactName(){
        return this.factName ;
    }
    public String getRemarks(){
        return this.remarks ;
    }

    public String toString(){
        return factName;
       }
}
