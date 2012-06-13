package utils;

import java.util.ArrayList;
import java.util.List;

import com.google.common.primitives.Chars;

public class Permutations {

	//////////////////////////////////////////////////////////////////////////////
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
	//////////////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////////////////
	private static void swap(char[] v, int i, int j) {
		char t = v[i]; v[i] = v[j]; v[j] = t;
	}

	public static List<String> bHeapPermute(String s){
		List<String> result = new ArrayList<String>();
		bHeapPermute(s.toCharArray(), s.length(), result);
		return result;
	}
	
	public static void bHeapPermute(char[] s, int n, List<String> perms) {
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
	public static List<String> quickPerm(String s){
		List<String> perms = new ArrayList<String>();
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
