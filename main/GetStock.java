package main;
public class GetStock{
	int PrevStock;
	int PresStock;
	
	public GetStock(){};
	public GetStock(int PrevStock,int PresStock){
		this.PrevStock = PrevStock;
		this.PresStock = PresStock;
	}
	public int PrevStock(){
		return PrevStock;
	}
	public int PresStock(){
		return PresStock;
	}
}