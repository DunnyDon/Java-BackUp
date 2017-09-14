package CompareInterfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RationalComparator implements Comparator<Rational>{

	public int compare(Rational one, Rational two) {
		int retval = Float.compare(one.getRation(), two.getRation());
		//retval = 1 if one > two 
		return retval;
	}

	public static void sort(ArrayList<Rational> listofR, RationalComparator r){
		for(int i=1; i<listofR.size(); i++){
			 Rational temp = listofR.get(i);//use insertion sort to sort the Rational numbers from largest to smallest
			 int j;
			 for(j=i-1; j>=0; j--){
				 if(r.compare(temp,listofR.get(j)) == 1){
					listofR.set(j+1, listofR.get(j));
					listofR.set(j, temp);
					 }
				
			 	}
			 }
			 Collections.reverse(listofR);// since We were asked for smallest to largest just reverse the list
			 System.out.println("***********Start of the List**********");
			 for(int z=0; z<=10; z++){
				 System.out.println(listofR.get(z).toString());//print out the list in fraction form
			 }
			 System.out.println("***********End of the List**********");
	}
}
