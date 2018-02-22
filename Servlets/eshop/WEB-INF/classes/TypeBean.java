public class TypeBean{

	private int typeId;
	private String typeName;
	private String remarks;
	
	//getter methods
	public int getTypeId(){
		return typeId;
	}
	public String getTypeName(){
		return typeName;
	}
	public String getRemarks(){
		return remarks;
	}
	
	//setter methods
	public void setTypeId(int typeId){
		this.typeId = typeId;
	}
	public void setTypeName(String typeName){
		this.typeName = typeName;
	}
	public void setRemarks(String remarks){
		this.remarks = remarks;
	}
}