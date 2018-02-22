public class ProductBean{

	private int typeId;
	private int productId;
	private String productName;
	private double price;
	private String description;
	
	//getter methods
	public int getTypeId(){
		return typeId;
	}
	public int getProductId(){
		return productId;
	}
	public String getProductName(){
		return productName;
	}
	public double getPrice(){
		return price;
	}
	public String getDescription(){
		return description;
	}

	//setter methods
	public void setTypeId(int typeId){
		this.typeId = typeId;
	}
	public void setProductId(int productId){
		this.productId = productId;
	}
	public void setProductName(String productName){
		this.productName = productName;
	}
	public void setPrice(double price){
		this.price = price;
	}
	public void setDescription(String description){
		this.description = description;
	}
}