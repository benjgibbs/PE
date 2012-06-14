package utils;

import java.util.Arrays;

public class PrimeSieve {
	private final boolean[] primes; 
	public PrimeSieve(int upto){
		primes = new boolean[upto];
		Arrays.fill(primes, true);
		primes[0] = primes[1] = false;
		for(int i = 2; i < Math.sqrt(upto); ++i){
			if(primes[i]){
				int j = 2*i;
				while(j < upto){
					primes[j] = false;
					j += i;
				}
			}
		}
	}

	public boolean isPrime(int p) {
		return primes[p];
	}
}
