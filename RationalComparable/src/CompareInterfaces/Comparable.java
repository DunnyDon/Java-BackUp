package CompareInterfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import CompareInterfaces.RationalComparator;
public class Comparable {
 public static void main(String args[]) throws Exception{
	 ArrayList<Rational> listofR = new ArrayList<Rational>();//create your arraylist
	 for(int z=0; z<=10; z++){
		 Random generator = new Random(); //generate random denominators for testing
		 int i = generator.nextInt(30) + 1;//have the range from 1 to 31 so 0 cant be included
		 listofR.add(z,new Rational(1, i));//add rational numbers to it 
	 }
	 Collections.shuffle(listofR);
	 RationalComparator.sort(listofR, new RationalComparator());
	 checkList(listofR);
 }
 public static boolean checkList(ArrayList<Rational> listofnums) throws Exception{
		int denom,numer;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter The denominator and numerator of the Rational Number you wish to check is in the List" );
		System.out.println("Enter Denominator:");
		denom = s.nextInt();
		System.out.println("Enter Numerator:");
		numer = s.nextInt();
		//enter the new Rational number to check if it is in the list
		Rational r = new Rational(denom,numer);
		if(Collections.binarySearch(listofnums, r, new RationalComparator())>0){//check if the entered number is in the list
			System.out.println(r + " is in the list");
			return true;
		}
		else{//if it isnt then the number returned from binarySearch should be less than 0
			System.out.println(r+" is not in the list");
			return false;
		}
		
		
		
	}
}
