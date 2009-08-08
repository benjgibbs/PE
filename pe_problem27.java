package pe_problem27;

import utils.PrimeSieve;


public class Problem27 {
	
	public static void main(String[] args) {
	    System.out.println("Starting");
	    int mostRemarkable = 0;
	    
	    Problem27 p = new Problem27();
	    
	    for(int a = -999; a < 1000; ++a){
	        for(int b = -999; b < 1000; ++b){
	            int x = p.howRemarkable(a, b);
	            if(x > mostRemarkable){
	                System.out.println("New most remarkable: a="+a+" b="+b+" primes " + x + " product="+a*b);
	                mostRemarkable = x;
	            }
	        }
	    }
	    System.out.println("Done");
	}

	PrimeSieve ps = new PrimeSieve(100000);
	
	public int howRemarkable(int a, int b) {
	    int n = 0;
	    while(ps.isPrime( n*n + a*n + b))
	        n++;
		return n;
	}
	
	
}
