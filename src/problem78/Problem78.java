package problem78;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

// https://en.wikipedia.org/wiki/Partition_(number_theory)
public class Problem78 {

	public long p(long n) {
		
	}

	public static void main(String[] args) {

		Problem78 p = new Problem78();

		System.out.println("Given P(5)=7");
		
		int[] ps = {1, 1, 2, 3, 5, 7, 11, 15, 22, 30, 42, 56, 77, 101, 135, 176, 231, 297, 385, 490, 627, 792, 1002, 1255, 1575, 1958, 2436, 3010, 3718, 4565, 5604};
		for(int i = 0; i < ps.length; i++){
			assertThat(p.p(i)).
		}

		for (int i = 1;; i++) {
			Set<List<Integer>> ways = p.listWays(i);
			if (i == 5) {
				System.out.println("P(" + i + ")=" + ways.size());
			}
			if (ways.size() % 1_000_000 == 0) {
				System.out.println("\nP(" + i + ")=" + ways.size());
			}
			if (i % 10 == 0) {
				System.out.print(".");
				System.out.flush();
			}
		}
	}

}
