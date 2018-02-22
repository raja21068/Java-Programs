package beans;

public class CityBean {
	private int junction_no;
	private String city;

	public void setJunction_no(int junction_no){this.junction_no = junction_no;};
	public void setCity(String city){this.city = city;};

	public int getJunction_no(){return this.junction_no;};
	public String getCity(){return this.city;};

	@Override
	public String toString(){
		return this.city;
	}
}
