package problem76;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class Problem76 {

//	It is possible to write five as a sum in exactly six different ways:
//
//		4 + 1
//		3 + 2
//		3 + 1 + 1
//		2 + 2 + 1
//		2 + 1 + 1 + 1
//		1 + 1 + 1 + 1 + 1
//
//		How many different ways can one hundred be written as a sum of at least two positive integers?

	
	static int count(List<Integer> ints, int toFind){
		if(ints.size() == 0 || toFind < 0) return 0;
		if(toFind == 0) return 1;
		return count(ints.subList(1,ints.size()),toFind) + count(ints,toFind - ints.get(0));
	}
	
	
	static int howManyWays(int x){
		List<Integer> ints = new ArrayList<>();
		for(int i = x-1; i > 0; i--){
			ints.add(i);
		}
		return count(ints,x);
	}
	
	@Test public void checkTheFirstEight(){
		/*
		 * 1 -> 0: 1
		 * 2 -> 1: 1+1
		 * 3 -> 2: 1+1+1, 2+1
		 * 4 -> 3: 1+1+1+1, 2+1+1, 2+2, 3+1  
		 * 5 -> 6
		 * 6 -> 10: 1+1+1+1+1+1,2+1+1+1+1,2+2+1+1,2+2+2,3+1+1+1,3+2+1,3+3,4+1+1,4+2,5+1
		 * 7 -> 14: 1+1+1+1+1+1+1,2+1+1+1+1+1,2+2+1+1+1,2+2+2+1,3+1+1+1+1,3+2+1+1,3+2+2,3+3+1,4+1+1+1,4+2+1,4+3,5+1+1,5+2,6+1
		 * 8 -> 21: 1+1+1+1+1+1+1+1,2+1+1+1+1+1+1,2+2+1+1+1+1,2+2+2+1+1,2+2+2+2,3+1+1+1+1+1,3+2+1+1+1,3+2+2+1,3+3+1+1,3+3+2,4+1+1+1+1,4+2+1+1,4+2+2,4+3+1,4+4,5+1+1+1,5+2+1,5+3,6+1+1,6+2,7+1
		 */
		int[] ways = new int[]{0,0,1,2,4,6,10,14,21};
		for(int i = 0; i <= 8; ++i){
			int howManyWays = howManyWays(i);
			System.out.println(i+": "+howManyWays);
			assertThat(howManyWays,is(equalTo(ways[i])));
		}
	}
	
	public static void main(String[] args) {
		int ways = howManyWays(100);
		System.out.println("There are " + ways + " ways to make 100");
	}

}
