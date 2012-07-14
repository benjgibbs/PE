package problem60;

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
		
		int bestSum = Integer.MAX_VALUE;
		
		for (int p : qs) {
			for (int q : qs.listFrom(p)) {
				if(check(ps,p,q)){
					for (int r : qs.listFrom(q)) {
						if (check(ps, p, r) && check(ps, q, r)) {
							for(int s : qs.listFrom(r)){
								if(check(ps,p,s) && check(ps, q, s) && check(ps, r, s)){
									for(int t  : qs.listFrom(s)){
										if(check(ps,p,t) && check(ps, q, t) && check(ps, r, t) && check(ps, s, t)){
											bestSum = checkSum(start, bestSum, p, q, r, s, t);						
										}
									}
								}
								
							}
						}
					}
				}
			}
		}
		System.out.println("Took: " + (System.currentTimeMillis() - start)
				+ "ms.");
	}
	private static int checkSum(long start, int bestSum, int p, int q, int r, int s, int t) {
		int sum = p+q+r+s+t;
		if (sum < bestSum) {
			System.out.println(String.format(
					"Found new best sum: %d, with %s. Took %dms", 
					sum, Sets.newHashSet(p,q,r,s,t), (System.currentTimeMillis() - start)));
			bestSum = sum;

		}
		return bestSum;
	}
	private static boolean check(PrimeSieve ps, int p, int q) {
		String pstr = String.valueOf(p);
		String qstr = String.valueOf(q);
		return ps.isPrime(Integer.parseInt(pstr + qstr))
				&& ps.isPrime(Integer.parseInt(qstr + pstr));
	}
}
