public class CreditCardsBean{

	private int cardId;
	private String cardName;
	private String remarks;
	
	//getter methods
	public int getCardId(){
		return cardId;
	}
	public String getCardName(){
		return cardName;
	}
	public String getRemarks(){
		return remarks;
	}
	
	
	//setter methods
	public void setCardId(int cardId){
		this.cardId = cardId;
	}
	public void setCardName(String cardName){
		this.cardName = cardName;
	}
	public void setRemarks(String remarks){
		this.remarks = remarks;
	}
	
}