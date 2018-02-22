
public class ContactBean {
    private String number;
    private String name;
    
    @Override
    public String toString(){
        return name;
     }
    
    public void setNumber(String no){
        this.number = no;
    }
    
    public void setName(String nam){
        this.name = nam;
    }
    
    public String getNumber(){
        return number;
    }
    
    public String getName(){
        return name;
    }
}
