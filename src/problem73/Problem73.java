package problem73;

import java.util.HashSet;
import java.util.Set;

import utils.Fraction;

public class Problem73 {
	/*
	 * Consider the fraction, n/d, where n and d are positive integers. If nd
	 * and HCF(n,d)=1, it is called a reduced proper fraction. If we list the
	 * set of reduced proper fractions for d 8 in ascending order of size, we
	 * get: 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5,
	 * 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8 It can be seen that there are 3
	 * fractions between 1/3 and 1/2. How many fractions lie between 1/3 and 1/2
	 * in the sorted set of reduced proper fractions for d 12,000? Note: The
	 * upper limit has been changed recently.
	 */

	public static void main(String[] args) {
		long D = 12_000;
		Fraction lowerBound = new Fraction(1, 3);
		Fraction upperBound = new Fraction(1, 2);
		Set<Fraction> done = new HashSet<>();
		for (int d = 4; d <= D; d++) {
			for (int n = (int) lowerBound.f * d; n < upperBound.f * d; n++) {
				Fraction f = new Fraction(n, d);
				if (f.compareTo(lowerBound) > 0 && f.compareTo(upperBound) < 0) {
					done.add(f);
				}
			}
		}
		System.out.println(String.format(
				"There are %d fractions up to D=%d between %s and %s",
				done.size(), D, lowerBound, upperBound));
	}
}
