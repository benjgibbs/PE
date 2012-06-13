package utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Fraction implements Comparable<Fraction>{
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

	// Tests
	
	@Test public void checkEqualFractions(){
		Fraction f1 = new Fraction(1,2);
		Fraction f2 = new Fraction(2,4);
		assertTrue(f1.equals(f2));
		assertEquals(f1.compareTo(f2),0);
		
		Fraction f3 = new Fraction(1,4);
		
		assertTrue(f1.compareTo(f3) > 0);
		assertTrue(f3.compareTo(f1) < 0);
	}

}