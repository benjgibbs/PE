package problem81;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import static java.lang.System.out;

public class Problem81 {
	public static void main(String[] args) throws IOException{
		calculateShortestPath(getMatrix());
	}
	
	@Test public void checkWeMatchGivens(){
		long shortestSum = calculateShortestPath(getMatrixTest());
		assertThat(shortestSum, is(equalTo(2427L)));
	}

	private static long calculateShortestPath(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		long[][] shortestPaths = new long[rows][];
		for(int i = 0; i < rows; ++i){
			shortestPaths[i] = new long[cols];
		}
		int sum = 0;
		for(int c = 0; c < cols; c++ ){
			sum += matrix[0][c];
			shortestPaths[0][c] = sum; 
		}
		sum = 0;
		for(int r = 0; r < rows; r++){
			sum += matrix[r][0];
			shortestPaths[r][0] = sum;
		}
		for(int c = 1; c < cols; c++){
			for(int r = 1; r < rows; r++){
				int cost = matrix[r][c];
				if(shortestPaths[r-1][c] < shortestPaths[r][c-1]){
					shortestPaths[r][c] = shortestPaths[r-1][c] + cost;
				}else{
					shortestPaths[r][c] = shortestPaths[r][c-1] + cost;
				}
			}
		}
		for(long[] row : shortestPaths){
			out.println(Arrays.toString(row));
		}
		out.println("Cheapest corner is: " + shortestPaths[rows-1][cols-1]);
		return shortestPaths[rows-1][cols-1];
	}
	
	private static int[][] getMatrixTest(){
		return new int[][]{
				{131,673,234,103,18},
				{201,96,342,965,150},
				{630,803,746,422,111},
				{537,699,497,121,956},
				{805,732,524,37,331}};
	}
	
	
	private static int[][] getMatrix() throws IOException {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("src/problem81/Matrix.txt");
			br = new BufferedReader(fr);
			String line;
			line = br.readLine();
			ArrayList<int[]> result = new ArrayList<int[]>();
			while(line != null){
				String[] row  = line.split(",");
				int[] row2 = new int[row.length];
				for(int i = 0; i < row.length; i++){
					row2[i] = Integer.parseInt(row[i]);
				}
				result.add(row2);
				line = br.readLine();
			}
			return result.toArray(new int[result.size()][]);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		finally{
			if(br != null){
				br.close();
			}
		}
	}
}
