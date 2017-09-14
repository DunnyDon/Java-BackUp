package Queue;
//Conor Donohue 13404068
public class Product extends Thread{
	public boolean terminate;
	private String details;
	private FIFOQueue fifo;
	private int fi;//initialise your variables
	public Product(int i,FIFOQueue q){//create your constructor
		fi=i;
		terminate=true;
		details= "String "+i;
		fifo=q;
	}
	public void run() {
			int size= fifo.size();
			for(int i=size-10;i<size;i++){
				fifo.enqueue(details+"."+i);//enqueue 10 strings per producer with a unique string for each entry
				try {
					this.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	
}