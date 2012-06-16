package utils;


public class Fraction implements Comparable<Fraction>{
	public final long n;
	public final long d;
	public final double f;
	public Fraction(long n, long d){
		long gcd = gcd(n,d);
		this.n = n/gcd;
		this.d = d/gcd;
		this.f = (double)n/d;
	}
	
	long gcd(long a, long b){
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
	@Override public int hashCode() {
		return (int)(n*17 ^ d);
	}
}