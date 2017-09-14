package Queue;
//Conor Donohue 13404068
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JOptionPane;


public class FIFOQueue {
	 protected String[] Q;				// array used to implement the queue 
	 protected int rear = -1;			// index for the rear of the queue
	 protected int capacity; 			// The actual capacity of the queue array
	 public static final int CAPACITY = 1000;	// default array capacity
	 final Lock lock = new ReentrantLock();	// create locks for enqueue and dequeue
	 final Lock locks = new ReentrantLock();
	 public static int count;
	 final Condition notFull  = lock.newCondition(); //create your condition variables
	 final Condition notEmpty = lock.newCondition();
	 final Condition notFulls  = locks.newCondition(); 
	 final Condition notEmptys = locks.newCondition();
	 public FIFOQueue() {
		   // default constructor: creates queue with default capacity
		   this(CAPACITY);
	 }

	 public FIFOQueue(int cap) {
		  // this constructor allows you to specify capacity
		  capacity = (cap > 0) ? cap : CAPACITY;
		  Q = new String[capacity]; 
	 }
	 
	 public synchronized void enqueue(String n)
	 {
		 lock.lock();//lock so only one thread at a time can enqueue
		 try{
		 while(isFull()){
			 try {
				notFull.await();//while the queue is full dont enqueue anymore by making the thread "sleep"
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
		 if (isFull()) {
			 JOptionPane.showMessageDialog(null, "Cannot enqueue object; queue is full.");
			 return;
		 }
		 rear++;
		 Q[rear] = n;
		 count++;
		 System.out.println("Enqueued "+n+". The size of the queue is now "+this.size());
		 notEmpty.signal();//turn the thread back "on"
		 }
		 finally{
			 lock.unlock();//unlock so other thread can enqueue again
		 }
		// System.out.println(this.count);
		//this was used to make sure that correct amount of strings were produced 
	 }
	 
	 public synchronized String dequeue()
	 {
		 String toReturn = null;
		 locks.lock();//lock so only one thread at a time can dequeue
		 try{
		 while(isEmpty()){
			 try {
				notEmptys.await(); //while the queue is empty stop threads from dequeueing
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
		 
		 // Can't do anything if it's empty
		 if (isEmpty())
			 return null;
		 
		 toReturn = Q[0];
		 
		 // shuffle all other objects towards 0
		 int i = 1;
		 while (i <= rear) {
			 Q[i-1] = Q[i];
			 i++;
		 }
		 rear--;
		 System.out.println("String being Dequeued is "+toReturn+". The size of the queue is now "+this.size());
		 notFulls.signal();
		 }
		 finally{
			 //allow threads access again
			 locks.unlock();
			 }
		 return toReturn; 
		 
		 
	 }
	 
	 public boolean isEmpty()  {
	     return (rear < 0);
	 }
	 
	 public boolean isFull() {
		 return (rear == capacity-1);
	 }
	 
	 public String front()
	 {
		 if (isEmpty())
			 return null;
		 
		 return Q[0];
	 }
	 public int size(){
		return rear+1;
		 
	 }
}
