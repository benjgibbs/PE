package problem71;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Problem71 {

	static class Fraction implements Comparable<Fraction>{
		public final int n;
		public final int d;
		public final float f;
		public Fraction(int n, int d){
			
			if(d % n > 0){
				
			}
			this.n = n;
			this.d = d;
			this.f = (float)n/d;
		}
		@Override public String toString() {
			return String.format("%d/%d", n,d);
		}
		@Override
		public int compareTo(Fraction o) {
			if(o.f == f) return 0;
			if(o.f < f) return 1;
			return -1;
		}
		@Override
		public boolean equals(Object obj) {
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
	}
	
	@Test public void checkGivens(){
		int d = 8;
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
		Set<Fraction> fractions = createFractionsUpTo(1_000_000);
		Fraction threeSevenths = new Fraction(3,7);
		Fraction last = null;
		for(Fraction f : fractions){
			if(f.equals(threeSevenths)){
				System.out.println("Found 3/7 to the left we have: " + last);
			}
			last = f;
		}
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
