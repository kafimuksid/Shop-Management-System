package main;
public class GetBS2{
	String Pname;
	String Quantity;
	float Price;
	
	public GetBS2(){};
	public GetBS2(String Pname,String Quantity,float Price){
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
	public float getPrice(){
		return Price;
	}
}