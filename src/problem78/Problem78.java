package problem78;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class Problem78 {

	private Map<Integer, Set<List<Integer>>> cache = new HashMap<>();

	public Problem78() {
		cache.put(0, Sets.newHashSet());
		Set<List<Integer>> one = Sets.newHashSet();
		one.add(Lists.newArrayList(1));
		cache.put(1, one);
	}
	
	public Set<List<Integer>> deepCopy(Set<List<Integer>> toCopy){
		Set<List<Integer>> result = Sets.newHashSet();
		for(List<Integer> list : toCopy){
			result.add(new ArrayList<Integer>(list));
		}
		return result;
	}

	public Set<List<Integer>> listWays(int coins) {
		if (cache.containsKey(coins)) {
			return deepCopy(cache.get(coins));
		}

		HashSet<List<Integer>> result = Sets.newHashSet();
		result.add(Lists.newArrayList(coins));

		for (int i = 1; i <= coins; i++) {
			Set<List<Integer>> allSubWays = listWays(coins - i);
			for (List<Integer> subWay : allSubWays) {
				subWay.add(i);
				subWay.sort((a, b) -> a - b);
				result.add(subWay);

			}
		}
		cache.put(coins, result);
		return deepCopy(result);
	}

	public static void main(String[] args) {

		Problem78 p = new Problem78();

		System.out.println("Given P(5)=7");

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
