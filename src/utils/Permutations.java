package utils;

import java.util.Set;
import java.util.TreeSet;

public class Permutations {

	//////////////////////////////////////////////////////////////////////////////
	public static void findPermutations(
			String prefix, String toPermute, Set<String> perms, String ignorePrefix){
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
	
	public static Set<String> findPermutations(String toPermute){
		return findPermutations(toPermute,null);
	}
	public static Set<String> findPermutations(String toPermute, String ignorePrefix){
		Set<String> perms = new TreeSet<>();
		findPermutations("",toPermute, perms, ignorePrefix);
		return perms;
	}
	//////////////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////////////////
	private static void swap(char[] v, int i, int j) {
		char t = v[i]; v[i] = v[j]; v[j] = t;
	}

	public static Set<String> bHeapPermute(String s){
		Set<String> result = new TreeSet<>();
		bHeapPermute(s.toCharArray(), s.length(), result);
		return result;
	}
	
	public static void bHeapPermute(char[] s, int n, Set<String> perms) {
		if (n == 1) {
			perms.add(String.valueOf(s));
		} else {
			for (int i = 0; i < n; i++) {
				bHeapPermute(s, n-1, perms);
				if (n % 2 == 1) {
					swap(s, 0, n-1);
				} else {
					swap(s, i, n-1);
				}
			}
		}
	}
	//////////////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////////////////
	public static Set<String> quickPerm(String s){
		Set<String> perms = new TreeSet<String>();
		perms.add(s);
		char[] chars = s.toCharArray();
		int N = chars.length;
		int[] p = new int[N+1];
		for(int i = 0; i <= N; ++i){
			p[i] = i;
		}
		
		int i = 1;
		while(i < N){
			p[i]--;
			int j = i % 2 *p[i];
			swap(chars,i,j);
			perms.add(String.valueOf(chars));
			i=1;
			while(p[i] == 0){
				p[i] = i;
				i++;
			}
		}
		return perms;
	}
}
