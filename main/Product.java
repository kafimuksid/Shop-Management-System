package main;
public class Product{
	String ProductName;
	String ProductID;
	String Price;
	String Stock;
	String CatagoryID;
	
	public Product(){};
	public Product(String ProductName,String ProductID,String Price,String Stock,String CatagoryID){
		this.ProductName = ProductName;
		this.ProductID = ProductID;
		this.Price = Price;
		this.Stock = Stock;
		this.CatagoryID = CatagoryID;
	}
	public String getProductName(){
		return ProductName;
	}
	public String getProductID(){
		return ProductID;
	}
	public String getPrice(){
		return Price;
	}
	public String getStock(){
		return Stock;
	}
	public String getCatagoryID(){
		return CatagoryID;
	}
}