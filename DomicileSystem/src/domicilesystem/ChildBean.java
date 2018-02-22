/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domicilesystem;

/**
 *
 * @author Jetander
 */
public class ChildBean {
    private int id;
    private int applicantId;
    private String name;
    private int age;
    private String remarks;
    
        public void setId(int id){
        this.id = id; 
        }
        
        public int getId(){
        return id;
        }
        
        public void setFormId(int applicantId){
        this.applicantId = applicantId; 
        }
        
        public int getFormId(){
        return applicantId;
        }    
        
        public void setName(String name){
        this.name = name;
        }
        
        public String getName(){
        return name;
        }
        
        public void setAge(int age){
        this.age = age;
        }
        
        public int getAge(){
        return age;
        }
        
        public void setRemarks(String remarks){
        this.remarks = remarks;
        }
        
        public String getRemarks(){
        return remarks;
        }
}