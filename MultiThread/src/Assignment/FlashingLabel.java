package Assignment;
//Conor Donohue 13404068
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.JTextArea;
import java.util.Scanner;
public class FlashingLabel extends JApplet implements Runnable, MouseListener{
	String Message = "I'm Flashing";
	Font font = new Font("TimesRoman",Font.BOLD,24);
	Thread StartThread = null;
	JTextArea text = new JTextArea("I'm Flashing");
	private int delay;
	private boolean terminate,stop,start;
	private FlowLayout layout;
	private Container container;
	//initialise all your variables
	public void start(){
		 	Scanner in = new Scanner(System.in);//use a scanner to determine the delay in the flashes
		 	System.out.println("How long do you want the delay between flashes to be?");
		 	delay = in.nextInt();//save the inputted answer
			terminate= false;
			start = true;
			stop = false;//set your boolean values and create a thread
			System.out.println("Starting");
			StartThread = new Thread(this);
			StartThread.start();			
			
	}
	public void init(){
		//initialise everything in the string
		 text.setFont(font);//add the text to the applet
		 container = getContentPane();
		 layout = new FlowLayout();
		 container.setLayout( layout );
		 container.add(text);
		 addMouseListener(this);//create a mouse listener to handle events created by the mouse/keypad
	}
	public void run() {//run the thread
		
	    while (!terminate){
			 while(!stop){//use the booleans to determine whether or not the applet should be flashing or not
				 try {
					text.setVisible(true);//show the text
					Thread.sleep(delay);//keep the text shown for a user specified period of time
					text.setVisible(false);//hide the text
					Thread.sleep(delay);//keep the text hidden for a user specified period of time
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			 }
			 while(!start){//when the flashing is to stop just hide the text
				text.setVisible(false);
				System.out.print("");
			 }
			
		 }
		
	}
	
	public void Terminate(){
		terminate = true;
	}
	
	
	  // This method will be called when the mouse has been clicked. 
	  public void mouseClicked (MouseEvent me) {
		 	if(me.getModifiers() == InputEvent.BUTTON1_MASK){
		 		if(!stop){
					stop=true;
					System.out.println("Stop");
					start=false;
					//reset the booleans so they will enter the while loop that will turn off the flashing
		 		}
		 		else{
		 			start = true;
					stop = false;
		 			System.out.println("Start again");
		 			// reset the booleans so they will enter the while loop that will turn on the flashing
		 		}
			}
		 	
	  }
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	}

