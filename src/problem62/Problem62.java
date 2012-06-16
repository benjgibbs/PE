package problem62;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem62 {

//	The cube, 41063625 (345^3), can be permuted to produce two other cubes: 
//	56623104 (384^3) and 66430125 (405^3). In fact, 41063625 is the smallest 
//	cube which has exactly three permutations of its digits which are also cube.
//
//	Find the smallest cube for which exactly five permutations of its digits are cube.
	
	public static void main(String[] args) {
		System.out.println("Max Long value: " + Long.MAX_VALUE);
		long start = System.currentTimeMillis();
		boolean found = false;
		int numToFind = 5;
		long i = 1;
		Map<String,Integer> cubes = new HashMap<>();
		Map<String,List<Long>> cubePerms = new HashMap<>();
		while(!found){
			long cube = i * i * i;
			String cubeString = String.valueOf(cube);
			char[] bits = cubeString.toCharArray();
			Arrays.sort(bits);
			String sortedCubeString = String.valueOf(bits);
			if(cubes.containsKey(sortedCubeString)){
				cubes.put(sortedCubeString, cubes.get(sortedCubeString) + 1);
			}else{
				cubes.put(sortedCubeString, 1);
				cubePerms.put(sortedCubeString, new ArrayList<Long>());
			}
			cubePerms.get(sortedCubeString).add(cube);
			
			if(cubes.get(sortedCubeString) >= numToFind){
				found = true;
				printResult(cubePerms.get(sortedCubeString));
			}
			i++;
		}
		System.out.println("Took: " +(System.currentTimeMillis() - start) + "ms");
	}

	private static void printResult(List<Long> permutedCubes) {
		StringBuilder builder = new StringBuilder();
		for(Long c : permutedCubes){
			if(builder.length() > 0){
				builder.append(", ");
			}
			builder.append(c)
					.append("=")
					.append((long)Math.cbrt(c))
					.append("^3");
		}
		System.out.println(String.format("Found %d permutations %s",
				permutedCubes.size(),
				builder.toString()));
	}
}
