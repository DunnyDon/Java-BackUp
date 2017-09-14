package Assignment;
//Conor Donohue 13404068
//Create a Stock object so products can be added to the StockRoom 
public class Stock {
	private int numberleft;
	private String product;
	public Stock(String s, int i){
		product = s;
		numberleft = i;
	}
	//create your constructor ^^^
	
	//create your method and make them synchronised so only one thread at a time can access them
	public synchronized void addToStock(int i){
				numberleft+=i; //increase the stock
				System.out.println("After adding "+ i + " to "+ product);
		
	}
	
	public synchronized int checkStock(){
		System.out.println("After Checking there is "+ numberleft+" of "+ product);
		//check how much stock is left	
		return numberleft;
	}
	
	public synchronized void RemoveStock(int i){
		if(i<numberleft){//make sure there enough stock to take out
				numberleft -=i;
				System.out.println("After removing "+ i + " to "+ product);
			}
			else{//if there isn't throw an error
				throw new Error("\nThere is not enough Stock to remove "+i+" "+product+"\n");
			}
				
	}

}
