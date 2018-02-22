
package vaannila;

public class HelloWorld {


    private String value1;
    private String value2;
    
    public String execute() {
		if(value1!=null && !value1.trim().equals("") && value2!=null && !value2.trim().equals(""))    
		    return "SUCCESS";
		else
			return "INPUT";
			

    }

    public String getValue1() {
        return value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }
    public void setValue2(String value2) {
        this.value2 = value2;
    }

}