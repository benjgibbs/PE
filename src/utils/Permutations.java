package utils;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void findPermutations(
			String prefix, String toPermute, List<String> perms, String ignorePrefix){
		if(ignorePrefix != null && prefix.startsWith(ignorePrefix)){
			return;
		}
		int n = toPermute.length();
		if(n==0){
			perms.add(prefix);
		}else{
			for(int i = 0; i < n; ++i){
				findPermutations(prefix + toPermute.charAt(i), 
						toPermute.substring(0,i) + toPermute.substring(i+1,n),
						perms,
						ignorePrefix);
			}
		}
	}

	public static List<String> findPermutations(String toPermute){
		return findPermutations(toPermute,null);
	}
	public static List<String> findPermutations(String toPermute, String ignorePrefix){
		ArrayList<String> perms = new ArrayList<>();
		findPermutations("",toPermute, perms, ignorePrefix);
		return perms;
	}
	
	/*
	The following algorithm generates the next permutation lexicographically after a given permutation. It changes the given permutation in-place.
	Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
	Find the largest index l such that a[k] < a[l]. Since k + 1 is such an index, l is well defined and satisfies k < l.
	Swap a[k] with a[l].
	Reverse the sequence from a[k + 1] up to and including the final element a[n].
	*/
}
