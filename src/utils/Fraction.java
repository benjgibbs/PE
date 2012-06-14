package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Fraction implements Comparable<Fraction>{
	public final int n;
	public final int d;
	public final BigDecimal f;
	public Fraction(int n, int d){
		int gcd = gcd(n,d);
		this.n = n/gcd;
		this.d = d/gcd;
		this.f = (new BigDecimal(n)).divide(new BigDecimal(d),100,RoundingMode.HALF_UP);
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
		return f.compareTo(o.f);
	}

	@Override public boolean equals(Object obj) {
		if(!(obj instanceof Fraction))
			return false;
		Fraction rhs = (Fraction)obj;
		return rhs.n == n && rhs.d == d;
	}
}