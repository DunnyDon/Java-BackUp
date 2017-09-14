package CompareInterfaces;
//Conor Donohue 13404068
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.lang.*;
//create your Rational Number Class
public class Rational extends Comparable{
	private int denominator;
	private int numerator;
	private float ration;
	//create your constructor
	public Rational(int numer, int denom) throws Exception{
		if(denom != 0){//only allow a new Rational number to be set if the Denominator !=0 as it is impossible to divide by 0
		this.denominator = denom;
		this.numerator = numer;
		this.ration = (float) numer/denom;
		}
		else{
			throw new Exception("You can't divide by zero!");
		}
	}
	//make your setters and getters
	public void setDenom(int num) throws Exception{//so throw an exception when the denominator is 0
		if(num!=0){
			this.denominator = num;
		}
		else{
			throw new Exception("You can't divide by zero!");
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
	
	public String toString(){
		return this.getNumer() +"/"+ this.getDenom();
	}
	
}
