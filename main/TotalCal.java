package main;
public class TotalCal{
	static float total;
	public TotalCal(){};
	public TotalCal(float total){
		this.total = this.total+total;
		
	}
	public float getTotal(){
		return total;
	}
	
}