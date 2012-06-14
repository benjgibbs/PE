package problem62;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.Permutations;

public class Problem62 {

//	The cube, 41063625 (345^3), can be permuted to produce two other cubes: 
//	56623104 (384^3) and 66430125 (405^3). In fact, 41063625 is the smallest 
//	cube which has exactly three permutations of its digits which are also cube.
//
//	Find the smallest cube for which exactly five permutations of its digits are cube.
	public static void main(String[] args) {
		
		long val = 10;
		long numToFind = 3;
		boolean found = false;
		long start = System.currentTimeMillis();
		Set<Long> considered = new HashSet<Long>();
		while(!found){
			long cube = val * val * val;
			if(!considered.contains(cube)){
				String cubeString = String.valueOf(cube);
				Set<String> ps = Permutations.quickPerm(cubeString);
				List<Long> cubes = new ArrayList<>();
				for(String p : ps){
					if(p.startsWith("0")){
						continue;
					}
					Long posCube = Long.valueOf(p);
					considered.add(posCube);
					
					double d = Math.cbrt(posCube);
					double ceil = Math.ceil(d);
					double floor = Math.floor(d);
					if(ceil == floor){
						cubes.add(posCube);
						if(cubes.size() >= numToFind){
							found = true;
							printResult(cubes);
							System.out.println("Took: " +(System.currentTimeMillis() - start) + "ms");
							break;
						}
					}
					
				}
			}
			val++;
			if(val % 100 == 0){
				System.out.println("Checked up to " + val );
			}
		}
	}

	private static void printResult(List<Long> permutedCubes) {
		StringBuilder builder = new StringBuilder();
		for(Long c : permutedCubes){
			if(builder.length() > 0){
				builder.append(", ");
			}
			builder.append(c)
					.append("=")
					.append((int)Math.cbrt(c))
					.append("^3");
		}
		System.out.println(String.format("Found %d permutations %s",
				permutedCubes.size(),
				builder.toString()));
	}
	
	
	

}
