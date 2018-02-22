
public class CategoryBean {
	int CatID;
	String CatName;

	public void setCatID(int CatID){
		this.CatID = CatID;
	}
	public void setCatName(String CatName){
		this.CatName = CatName;
	}
	public int getCatID(){
		return CatID;
	}
	public String getCatName(){
		return CatName;
	}
	public String toString(){
		return CatName;
	}
}
