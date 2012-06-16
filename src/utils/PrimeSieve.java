package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PrimeSieve implements Iterable<Integer> {
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
	
	public List<Integer> listFrom(int p){
		int q = p+2;
		for(; !isPrime(p) &&  p < primes.length; p++){
		}
		List<Integer> result = new ArrayList<>();
		for(int i = q; i < primes.length; ++i){
			if(isPrime(i)){
				result.add(i);
			}
		}
		return result;
	}

	@Override public Iterator<Integer> iterator() {
		return new Iterator<Integer>(){
			private int next = 2;
			@Override public boolean hasNext() {
				return next < primes.length;
			}

			@Override public Integer next() {
				int result = next;
				while(next < primes.length && !isPrime(next)){
					next++;
				}
				return result;
			}

			@Override public void remove() {
				throw new UnsupportedOperationException("Maths is truth!");
			}
		};
	}
	
}
