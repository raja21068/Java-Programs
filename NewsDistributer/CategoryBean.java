
class CategoryBean
{
	private int catID;
	private String catName;
	
	public String toString(){
		return catName;
	}
	
	void setCatID(int catID){
		this.catID = catID;
	}
	
	void setCatName(String catName){
		this.catName = catName;
	}
	
	int getCatID(){
		return catID;
	}
	
	String getCatName(){
		return catName;
	}
}
