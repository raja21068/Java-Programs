
import java.util.Date;

/**
 *
 * @author Jay
 */
public class PatientBean extends TransactionBean{
    private String doctorName;
    private Date date;
    
    public void setDoctorName(String doctor){
        this.doctorName = doctor;
    }
    
    public void setDate(Date date){
        this.date = date;
    }
    
    
    //Getter Methods
    public String getDoctorName(){
        return doctorName;
    }
    
    public Date getDate(){
        return date;
    }

    @Override
    public String toString() {
        return getPatientName();
    }
    
    
}
