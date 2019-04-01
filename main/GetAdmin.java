package main;
public class GetAdmin{
	String userID;
	String password;
	String firstName;
	String lastName;
	String contInfo;
	String address;
	String mobileNo;
	
	public GetAdmin(){};
	public GetAdmin(String userID,String password,String firstName,String lastName,String contInfo,String address,String mobileNo)
	{
		this.userID=userID;
	    this.password=password;
	    this.firstName=firstName;
	    this.lastName=lastName;
	    this.contInfo=contInfo;
	    this.address=address;
	    this.mobileNo=mobileNo;
	}
	public String getuserID(){
		return userID;
	}
	public String getpassword(){
		return password;
	}
	public String getfirstName(){
		return firstName;
	}
	public String getlasName(){
		return lastName;
	}
	public String getcontInfo(){
		return contInfo;
	}
	
	public String getadress(){
		return address;
	}
	
	public String getmobileNo(){
		return mobileNo;
	}
}