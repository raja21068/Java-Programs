public class CreditCardNumberBean{

	private int cardId;
	private int cardNoId;
	private String cardNumber;
	private double amount;
	private String remarks;

	//getter methods
	public int getCardId(){
		return cardId;
	}
	public int getCardNoId(){
		return cardNoId;
	}
	public String getCardNumber(){
		return cardNumber;
	}
	public double getAmount(){
		return amount;
	}
	public String getRemarks(){
		return remarks;
	}
	
	
	//setter methods
	public void setCardId(int cardId){
		this.cardId = cardId;
	}
	public void setCardNoId(int cardNoId){
		this.cardNoId = cardNoId;
	}
	
	public void setCardNumber(String cardNumber){
		this.cardNumber = cardNumber;
	}
	
	public void setAmount(double amount){
		this.amount = amount;
	}
	public void setRemarks(String remarks){
		this.remarks = remarks;
	}
	

}