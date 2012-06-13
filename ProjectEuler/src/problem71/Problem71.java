package problem71;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class Problem71 {

	static class Fraction implements Comparable<Fraction>{
		public final int n;
		public final int d;
		public final double f;
		public Fraction(int n, int d){
			int gcd = gcd(n,d);
			this.n = n/gcd;
			this.d = d/gcd;
			this.f = (double)n/d;
		}
		
		int gcd(int a, int b){
			if(b==0){
				return a;
			}
			return gcd(b, a % b);
		}
		
		@Override public String toString() {
			return String.format("%d/%d", n,d);
		}
		@Override public int compareTo(Fraction o) {
			if(o.f == f) return 0;
			if(o.f < f) return 1;
			return -1;
		}
		@Override public boolean equals(Object obj) {
			if(!(obj instanceof Fraction))
				return false;
			Fraction rhs = (Fraction)obj;
			return rhs.n == n && rhs.d == d;
		}
	}
	
	@Test public void checkEqualFractions(){
		Fraction f1 = new Fraction(1,2);
		Fraction f2 = new Fraction(2,4);
		assertTrue(f1.equals(f2));
		assertEquals(f1.compareTo(f2),0);
		
		Fraction f3 = new Fraction(1,4);
		
		assertTrue(f1.compareTo(f3) > 0);
		assertTrue(f3.compareTo(f1) < 0);
	}
	
	@Test public void checkGivens(){
		Set<Fraction> fractions = createFractionsUpTo(8);
		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for(Fraction f : fractions){
			if(first){
				first = false;
			}else{
				builder.append(", ");
			}
			builder.append(f);
		}
		assertEquals("1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8",
				builder.toString());
	}
	
	public static void main(String[] args) {
		//It is not
		//To the left of 3/7 we have: 383480/894787
		//It could be:
		//To the left of 3/7 we have: 428570/999997
		Fraction f = getClosestFractionTo(new Fraction(3,7), 1_000_000);
		System.out.println("To the left of 3/7 we have: " + f);
	}
	
	@Test public void checkLowestFractionWithGiven(){
		Fraction f = getClosestFractionTo(new Fraction(3,7), 8);
		assertThat(f, is(equalTo(new Fraction(2,5))));
	}

	private static Fraction getClosestFractionTo(Fraction fHigh, int maxD){
		Fraction fLow = new Fraction(0, 1);
		for(int d = 2; d <= maxD; d++){
			int low = (int)(d*fLow.f);
			boolean done = false;
			for(int n = low; n < d && !done; n++){
				Fraction f = new Fraction(n,d);
				if(f.compareTo(fLow) > 0){
					if(f.compareTo(fHigh) < 0){
						fLow = f;
					}else{
						done = true;
					}
				}
			}
		}
		return fLow;
	}
	
	private static Set<Fraction> createFractionsUpTo(int d) {
		TreeSet<Fraction> fractions = new TreeSet<Fraction>();
		
		for(int i = 1; i < d; i++){
			long start = System.currentTimeMillis();
			for(int j = i+1; j <=d; ++j){
				if(i % j != 0){
					Fraction f = new Fraction(i,j);
					if(!fractions.contains(f))
						fractions.add(f);
				}
			}
			System.out.println(String.format(
					"Took %dms for i:=%d",
					System.currentTimeMillis() - start,i));
		}
		return fractions;
	}
}
