package problem60;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import utils.PrimeSieve;

import com.google.common.collect.Sets;

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

		PrimeSieve ps = new PrimeSieve(100_000_000);
		PrimeSieve qs = new PrimeSieve(10_000);

		System.out.println("Building sieves took: "
				+ (System.currentTimeMillis() - start) + "ms.");
		
		List<Set<Integer>> matches = new ArrayList<Set<Integer>>();

		for (int p : qs) {
			for (int q : qs.listFrom(p)) {
				for (int r : qs.listFrom(q)) {
					if (check(ps, p, q) && check(ps, p, r) && check(ps, q, r)) {
						matches.add(Sets.newHashSet(p, q, r));
					}
				}
			}
		}
		System.out.println("Building pairs took: "
				+ (System.currentTimeMillis() - start) + "ms.");

		int bestSum = Integer.MAX_VALUE;

		for (int i = 0; i < matches.size(); i++) {
			long loopStart = System.currentTimeMillis();
			for (int j = i + 1; j < matches.size(); j++) {
				Set<Integer> union = Sets.union(matches.get(i), matches.get(j));
				if (union.size() == 5 && checkAll(ps, union)) {
					int sum = sum(union);
					if (sum < bestSum) {
						System.out.println(String.format(
								"Found new best sum: %d, with %s", sum, union));
						bestSum = sum;

					}
				}
			}
			// System.out.println("Loop time: " +
			// (System.currentTimeMillis() - loopStart) + "ms.");
		}
		System.out.println("Took: " + (System.currentTimeMillis() - start)
				+ "ms.");
	}

	private static int sum(Set<Integer> union) {
		int sum = 0;
		for (Integer i : union) {
			sum += i.intValue();
		}
		return sum;
	}

	private static boolean checkAll(PrimeSieve ps, Set<Integer> union) {
		for (List<Integer> s : Sets.<Integer> cartesianProduct(union, union)) {
			int p1 = s.get(0);
			int p2 = s.get(1);
			if (p1 < p2) {
				if (!check(ps, p1, p2)) {
					return false;
				}
			}
		}
		return true;
	}

	// for (int max = 100; max < 1000; max += 100) {
	// PrimeSieve qs = new PrimeSieve(max);
	// int bestSum = Integer.MAX_VALUE;
	// for (int p : qs.listFrom(1)) {
	// for (int q : qs.listFrom(p)) {
	// for (int r : qs.listFrom(q)) {
	// for (int s : qs.listFrom(r)) {
	// for (int t : qs.listFrom(s)) {
	// bestSum = check(ps, bestSum, p, q, r, s, t);
	// }
	// }
	// }
	// }
	// }
	// System.out.println(max + " took: " + (System.currentTimeMillis() - start)
	// + "ms.");
	// }
	// }
	//
	// private static int check(PrimeSieve ps, int bestSum, int p, int q, int r,
	// int s, int t) {
	// if (check(ps, p, q) && check(ps, p, r) && check(ps, p, s)
	// && check(ps, p, t) && check(ps, q, r) && check(ps, q, s)
	// && check(ps, q, t) && check(ps, r, s) && check(ps, r, t)
	// && check(ps, s, t)) {
	// int thisSum = p + q + r + s + t;
	// if (thisSum < bestSum) {
	// System.out
	// .println(String
	// .format("Found new best sum: %d, with p=%d,q=%d,r=%d,s=%d,t=%d",
	// thisSum, p, q, r, s, t));
	// bestSum = thisSum;
	// }
	// }
	// return bestSum;
	// }
	//
	private static boolean check(PrimeSieve ps, int p, int q) {
		String pstr = String.valueOf(p);
		String qstr = String.valueOf(q);
		return ps.isPrime(Integer.parseInt(pstr + qstr))
				&& ps.isPrime(Integer.parseInt(qstr + pstr));
	}
	//
	// @Test
	// public void checkGivens() {
	// // PrimeSieve ps = new PrimeSieve(1_000_000);
	// // int sum = check(ps,Integer.MAX_VALUE, 3,7,109,673);
	// // assertEquals(sum, 792);
	// }
	//
	// @Test
	// public void checkListFrom() {
	// PrimeSieve ps = new PrimeSieve(1_000_000);
	// List<Integer> listFrom = ps.listFrom(2);
	// assertEquals(3, listFrom.get(0).intValue());
	// }
}
