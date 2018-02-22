
public class DoctorsBean{
    private int doctorId;
    private String doctorName;
    private String remarks;

    /*Constructor*/
    public DoctorsBean() {}

    /*Setter Methods*/
    public void setDoctorId(int doctorId){
        this.doctorId = doctorId;
    }
    public void setDoctorName(String doctorName){
        this.doctorName = doctorName;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks;
    }

    /*Getter Methods*/
    public int getDoctorId(){
        return this.doctorId;
    }
    public String getDoctorName(){
        return this.doctorName;
    }
    public String getRemarks(){
        return this.remarks;
    }

    //@Override
    public String toString(){
        return doctorName;
    }
}
