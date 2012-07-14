package problem60;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import utils.PrimeSieve;

public class Problem60 {

	/*
	 * The primes 3, 7, 109, and 673, are quite remarkable. By taking any two
	 * primes and concatenating them in any order the result will always be
	 * prime. For example, taking 7 and 109, both 7109 and 1097 are prime. The
	 * sum of these four primes, 792, represents the lowest sum for a set of
	 * four primes with this property. Find the lowest sum for a set of five
	 * primes for which any two primes concatenate to produce another prime.
	 */
	// (4/2) -> 4!/((4-2)!2!) = 4*3/2 = 6
	// 37,73,3109,1093,3673,6733,7109,1097,7673,6737,109673,673109
	// (5/2) -> 5!/(5-2)!2! = 5*4/2 = 10 -> 20 ways?

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		PrimeSieve ps = new PrimeSieve(1_000_000);

		for (int max = 100; max < 1000; max += 100) {
			PrimeSieve qs = new PrimeSieve(max);
			int bestSum = Integer.MAX_VALUE;
			for (int p : qs.listFrom(1)) {
				for (int q : qs.listFrom(p)) {
					for (int r : qs.listFrom(q)) {
						for (int s : qs.listFrom(r)) {
							for (int t : qs.listFrom(s)) {
								bestSum = check(ps, bestSum, p, q, r, s, t);
							}
						}
					}
				}
			}
			System.out.println(max + " took: " + (System.currentTimeMillis() - start)
					+ "ms.");
		}
	}

	private static int check(PrimeSieve ps, int bestSum, int p, int q, int r,
			int s, int t) {
		if (check(ps, p, q) && check(ps, p, r) && check(ps, p, s)
				&& check(ps, p, t) && check(ps, q, r) && check(ps, q, s)
				&& check(ps, q, t) && check(ps, r, s) && check(ps, r, t)
				&& check(ps, s, t)) {
			int thisSum = p + q + r + s + t;
			if (thisSum < bestSum) {
				System.out
						.println(String
								.format("Found new best sum: %d, with p=%d,q=%d,r=%d,s=%d,t=%d",
										thisSum, p, q, r, s, t));
				bestSum = thisSum;
			}
		}
		return bestSum;
	}

	private static boolean check(PrimeSieve ps, int p, int q) {
		String pstr = String.valueOf(p);
		String qstr = String.valueOf(q);
		return ps.isPrime(Integer.parseInt(pstr + qstr))
				&& ps.isPrime(Integer.parseInt(qstr + pstr));
	}

	@Test
	public void checkGivens() {
		// PrimeSieve ps = new PrimeSieve(1_000_000);
		// int sum = check(ps,Integer.MAX_VALUE, 3,7,109,673);
		// assertEquals(sum, 792);
	}

	@Test
	public void checkListFrom() {
		PrimeSieve ps = new PrimeSieve(1_000_000);
		List<Integer> listFrom = ps.listFrom(2);
		assertEquals(3, listFrom.get(0).intValue());
	}
}
