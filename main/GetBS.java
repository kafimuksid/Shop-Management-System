package main;
public class GetBS{
	String Pname;
	String Quantity;
	String Price;
	
	public GetBS(){};
	public GetBS(String Pname,String Quantity,String Price){
		this.Pname = Pname;
		this.Quantity = Quantity;
		this.Price = Price;
	}
	public String getPname(){
		return Pname;
	}
	public String getQuantity(){
		return Quantity;
	}
	public String getPrice(){
		return Price;
	}
}