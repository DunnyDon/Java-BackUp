package Assignment;
//Conor Donohue 13404068
import java.util.ArrayList;

public class StockRoom{//create a stockroom where all the products can be accesssed
	private ArrayList<Stock> products = new ArrayList<Stock> ();
	
	public void addToStockRoom(Stock st){//add stock to the stock room
		products.add(st);
	}
	
}
