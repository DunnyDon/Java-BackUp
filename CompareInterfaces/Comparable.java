package CompareInterfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Comparable {
 public static void main(String args[]){
	 ArrayList<Rational> listofR = new ArrayList<Rational>();//create your arraylist
	 for(int z=0; z<=10; z++){
		 Random generator = new Random(); //generate random denominators for testing
		 int i = generator.nextInt(30) + 1;//have the range from 1 to 31 so 0 cant be included
		 listofR.add(z,new Rational(1, i));//add rational numbers to it 
	 }
	 for(int i=1; i<listofR.size(); i++){
	 Rational temp = listofR.get(i);//use insertion sort to sort the Rational numbers from largest to smallest
	 int j;
	 for(j=i-1; j>=0; j--){
		 if(temp.compare(listofR.get(j)) == 1){
			listofR.set(j+1, listofR.get(j));
			listofR.set(j, temp);
			 }
		
	 	}
	 }
	 Collections.reverse(listofR);// since We were asked for smallest to largest just reverse the list
	 System.out.println("***********Start of the List**********");
	 for(int z=0; z<=10; z++){
		 System.out.println(listofR.get(z).getNumer() +"/"+ listofR.get(z).getDenom());//print out the list in fraction form
	 }
	 System.out.println("***********End of the List**********");
	 
 }
 
}
