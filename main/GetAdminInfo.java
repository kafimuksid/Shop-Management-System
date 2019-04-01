package main;
public class GetAdminInfo{
	static String ID;
	static String Password;
	static String Firstname;
	static String Lastname;
	static String contact;
	static String Address;
	static String Mobileno;
	
	public GetAdminInfo(){};
	public GetAdminInfo(String ID,String Password,String Firstname,String Lastname,String contact,String Address,String Mobileno){
		this.ID = ID;
		this.Password = Password;
		this.Firstname = Firstname;
		this.Lastname = Lastname;
		this.contact = contact;
		this.Address = Address;
		this.Mobileno = Mobileno;
	}
	public String getID(){
		return ID;
	}
	public String getPass(){
		return Password;
	}
	public String getFname(){
		return Firstname;
	}
	public String getLname(){
		return Lastname;
	}
	public String getCont(){
		return contact;
	}
	public String getAdd(){
		return Address;
	}
	public String getMobNo(){
		return Mobileno;
	}
}