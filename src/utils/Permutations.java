package utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

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

	
	
}
