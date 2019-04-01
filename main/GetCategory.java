package main;
public class GetCategory{
	String CategoryName;
	String CategoryID;
	
	public GetCategory(){};
	public GetCategory(String CategoryName,String CategoryID){
		this.CategoryName = CategoryName;
		this.CategoryID = CategoryID;
		
	}
	public String getCategoryName(){
		return CategoryName;
	}
	public String getCategoryID(){
		return CategoryID;
	}

}