package Queue;
//Conor Donohue 13404068
import java.util.Random;

public class Test {
	
	public static void main(String args[]){
		FIFOQueue q=new FIFOQueue(300);//create your queue
		Random r= new Random();
		int n=r.nextInt(10)+1;//generate a random amount of producers and consumers
		System .out.println("There are "+n+" Producers and Consumers");
		for(int i=0;i<n;i++){
			new Product(i,q).start();//create the producers and run them
			new Consumer(q).start();//create the consumers and run them
		}	
	}
}
