package problem62;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.Permutations;

public class Problem62 {

//	The cube, 41063625 (3453), can be permuted to produce two other cubes: 
//	56623104 (3843) and 66430125 (4053). In fact, 41063625 is the smallest 
//	cube which has exactly three permutations of its digits which are also cube.
//
//	Find the smallest cube for which exactly five permutations of its digits are cube.
	public static void main(String[] args) {
		
		long val = 1;
		long numToFind = 5;
		boolean found = false;
		Map<Long,Long> cubes = new HashMap<Long,Long>();
		Map<Long,Long> permutedCubes = new HashMap<Long,Long>();
		while(!found){
			permutedCubes.clear();
			long cube = val * val * val;
			cubes.put(cube,val);
			String cubeString = String.valueOf(cube);
			long startTime = System.currentTimeMillis();
			List<String> ps = Permutations.findPermutations(cubeString, "0");
			if(val % 100 == 0){
				System.out.println("Finding permuations of " +cubeString+" took: " + 
						(System.currentTimeMillis() - startTime) + "ms. There are " + 
						ps.size() + " of them.");
			}
			for(String p : ps){
				if(p.startsWith("0")){
					continue;
				}
				Long posCube = Long.valueOf(p);
				if(cubes.containsKey(posCube)){
					permutedCubes.put(posCube, cubes.get(posCube));
				}
			}
			if(permutedCubes.size() >= numToFind){
				printResult(permutedCubes);
				found = true;
			}else{
				val++;
			}
			if(val % 100 == 0){
				System.out.println("Checked up to " + val + ", size of cubes dictionary is " + cubes.size());
			}
		}
	}

	private static void printResult(Map<Long, Long> permutedCubes) {
		StringBuilder builder = new StringBuilder();
		for(Map.Entry<Long,Long> kvp : permutedCubes.entrySet()){
			if(builder.length() > 0){
				builder.append(", ");
			}
			builder.append(kvp.getKey())
					.append("=")
					.append(kvp.getValue())
					.append("^3");
		}
		System.out.println(String.format("Found %d permutations %s",
				permutedCubes.size(),
				builder.toString()));
	}
	
	
	

}
