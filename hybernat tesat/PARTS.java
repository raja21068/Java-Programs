class PARTS{
  // Variables declaration - do not modify
    private int batchId;
    private int partId;
    private int part;
    private int partYear;
    private String remarks;

    public PARTS(){}
public PARTS(int batchId, int part, int partYear, String remarks){
this.batchId = batchId;
this.part = part;
this.partYear = partYear;
this.remarks = remarks;}



//Setter Methods Generated
    public void setBatchId(int batchId){
        this.batchId = batchId ;
    }
    public void setPartId(int partId){
        this.partId = partId ;
    }
    public void setPart(int part){
        this.part = part ;
    }
    public void setPartYear(int partYear){
        this.partYear = partYear ;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks ;
    }




//Getter Methods Generated
    public int getBatchId(){
        return this.batchId ;
    }
    public int getPartId(){
        return this.partId ;
    }
    public int getPart(){
        return this.part ;
    }
    public int getPartYear(){
        return this.partYear ;
    }
    public String getRemarks(){
        return this.remarks ;
    }

    public String toString(){
        return "";
       }
}
