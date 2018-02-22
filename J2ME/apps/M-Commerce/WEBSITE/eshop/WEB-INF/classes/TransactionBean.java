public class TransactionBean{

	private int customerId;
	private int productId;
	private int cardNoId;
	private int transactionId;
	private double amount;
	private int quantity;
	private java.util.Date dateOfTrans;
	private String shipStatus;
	private double shipingCharges;
	private String remarks;

	//setter methods
	public void setCustomerId(int customerId){
		this.customerId = customerId;
	}
	public void setProductId(int productId){
		this.productId = productId;
	}
	public void setCardNoId(int cardNoId){
		this.cardNoId=cardNoId;
	}
	public void settransactionId(int transactionId){
		this.transactionId = transactionId;
	}
	public void setAmount(double amount){
		this.amount = amount;
	}
	public void setQuantity(int quantity){
		this.quantity =quantity ;
	}
	public void setDateOfTrans(java.util.Date dateOfTrans){
		this.dateOfTrans = dateOfTrans;
	}
	public void setShipStatus(String shipStatus){
		this.shipStatus = shipStatus;
	}
	public void setShipingCharges(double shipingCharges){
		this.shipingCharges = shipingCharges;
	}
	public void setRemarks(String remarks){
		this.remarks = remarks;
	}
	

	//getter methods
	public int getCustomerId(){
		return customerId;
	}
	public int getProductId(){
		return productId;
	}
	public int getCardNoId(){
		return cardNoId;
	}
	public int getTransactionId(){
		return transactionId;
	}
	public double getAmount(){
		return amount;
	}
	public double getQuantity(){
		return quantity;
	}
	public java.util.Date getDateOfTrans(){
		return dateOfTrans;
	}
	public String getShipStatus(){
		return shipStatus;
	}
	public double getShipingCharges(){
		return shipingCharges;
	}
	public String getRemarks(){
		return remarks;
	}

}