package problem76;

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

	/*
	 * 
	 * 1 -> 0: 1
	 * 2 -> 1: 1+1
	 * 3 -> 2: 1+1+1, 2+1
	 * 4 -> 3: 1+1+1+1, 2+1+1, 2+2, 3+1  
	 * 6 -> n: 
	 */
	static int howManyWays(int x){
		if(x == 1 || x == 0) return 0;
		if(x == 2) return 1;
		int ways = 0;
		for(int i = 1; i < x; ++i)
			ways += (howManyWays(x-i) + howManyWays(i));
		return ways;
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 10; ++i){
			System.out.println(i+": "+howManyWays(i));
		}
	}

}
