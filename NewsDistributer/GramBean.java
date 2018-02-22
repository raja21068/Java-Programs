
class GramBean {
	
	private int catID;
	private int gramID;
	private String gram;
	
	public String toString(){
		return gram;
	}
	
	void setCatID(int catID){
		this.catID = catID;
	}
	
	void setGramID(int gramID){
		this.gramID = gramID;
	}
	
	void setGram(String gram){
		this.gram = gram;
	}
	
	int getCatID(){
		return catID;
	}
	
	int getGramID(){
		return gramID;
	}
	
	String setGram(){
		return gram;
	}
}
