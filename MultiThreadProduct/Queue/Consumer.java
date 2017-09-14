package Queue;
//Conor Donohue 13404068
public class Consumer extends Thread{
	public boolean terminate;
	public String consumed;
	private FIFOQueue fifo;
	public Consumer(FIFOQueue q){
		terminate = true;
		consumed=null;
		fifo=q;
	}
	public void run() {
			while(!fifo.isEmpty()){
				//empty out the queue one by one
				fifo.dequeue();
				try {
					this.sleep(200);//Used a longer delay to tr and ensure that a consumer would be running by the time
					//all the producers would finish
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	}
	
}