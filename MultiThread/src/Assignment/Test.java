package Assignment;
//Conor Donohue 13404068
public class Test {
	public static void main(String args[]){
		//create your stock and stockroom and initialise them
		final Stock stock = new Stock("PS3", 4);
		final Stock fail = new Stock("XBox1", 2);
		StockRoom srt = new StockRoom();
		srt.addToStockRoom(stock);
		srt.addToStockRoom(fail);
		Thread trd = new Thread(new Runnable(){
			public void run(){
				//create a thread and run it on the stock			
				for (int i= 1; i<15; i++){//run numerous operations on your stock
					stock.addToStock(i);
					fail.checkStock();
					fail.addToStock(i);
					if(i%2==0){
						stock.RemoveStock(i);
						fail.RemoveStock(i+1);
					}
					stock.checkStock();
					if(i==14){
						fail.RemoveStock(100);
					}
				}
			}
	});
		trd.start(); //end your thread
		
		Thread trf = new Thread(new Runnable(){
			public void run(){
				
				
				for (int i= 1; i<15; i++){
					stock.addToStock(i);
					System.out.print("^ trf Thread\n");// use this print statement to determine which thread is operating
					fail.checkStock();
					System.out.print("^ trf Thread\n");
					fail.addToStock(i);
					System.out.print("^ trf Thread\n");
					if(i%2==0){
						stock.RemoveStock(i);
						System.out.print("^ trf Thread\n");
						fail.RemoveStock(i+1);
						System.out.print("^ trf Thread\n");
					}
					stock.checkStock();
					System.out.print("^ trf Thread\n");
					if(i==14){
						fail.RemoveStock(100);
						System.out.print("^ trf Thread\n");
					}
				}
			}
	});
		trf.start();
	}
}
