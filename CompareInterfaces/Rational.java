package CompareInterfaces;
//Conor Donohue 13404068
import java.util.Comparator;
import java.lang.*;
//create your Rational Number Class
public class Rational extends Comparable{
	private int denominator;
	private int numerator;
	private float ration;
	//create your constructor
	public Rational(int numer, int denom){
		if(denom != 0){//only allow a new Rational number to be set if the Denominator !=0 as it is impossible to divide by 0
		this.denominator = denom;
		this.numerator = numer;
		this.ration = (float) numer/denom;
		}
		else{
			System.out.println("The Denominator can never equal zero");
		}
	}
	//make your setters and getters
	public void setDenom(int num){
		if(num!=0){
			this.denominator = num;
		}
	}
	public int getDenom(){
		return this.denominator;
	}
	public void setNumer(int num){
		this.numerator = num;
	}
	public int getNumer(){
		return this.numerator;
	}
	public float getRation(){
		return this.ration;
	}
	//create a compare method so you can compare Rational numbers
	public int compare(Rational one) {
		int retval = Float.compare(this.getRation(), one.getRation());
		//retval = 1 if one > two 
		return retval;
	}
}
