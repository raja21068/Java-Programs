package beans;

public class TrainBean {
    private int train_id;
    private String train_name;
    private String remarks;

    public void setTrainId(int train_id){this.train_id = train_id;};
    public void setTrainName(String train_name){this.train_name = train_name;};
    public void setRemarks(String remarks){this.remarks = remarks;};

    public int getTrain_id(){return this.train_id;};
    public String getTrain_name(){return this.train_name;};
    public String getRemarks(){return this.remarks;};
    
    public String toString (){
    	return this.train_name;
    }
}
