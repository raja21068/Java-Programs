import java.io.*;

public class RecordBean{
	private int id;
    private String name;
    private String fatherName;
    private String rollNo;
	private String surName;
	private String cellNo;
   
   public void setId(int id){
		this.id = id;
   }
   public void setName(String name){
		this.name = name;
   }
   public void setFatherName(String fname){
		fatherName = fname;
   }
   
   public void setRollNo(String no){
		rollNo = no;
   }
   public void setSurname(String sur){
		surName = sur;
   }
 
   public void setCellNo(String cell){
		cellNo = cell;
   }
   public int getId(){
		return id;
   }
    public String getName(){
	return name;
    }
    public String getFatherName(){
	return fatherName;
    }
    public String getRollNo(){
	return rollNo;
    }
	
	public String getSurname(){
	return surName;
    }
		public String getCellNo(){
	return cellNo;
    }


   public String toString(){
	return name;
   }
}