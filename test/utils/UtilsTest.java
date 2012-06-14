package utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class UtilsTest {
		private static final String TO_PERMUTE = "abcdefghi";
	
		// Fraction Tests
	

		@Test public void checkEqualFractions(){
			Fraction f1 = new Fraction(1,2);
			Fraction f2 = new Fraction(2,4);
			assertTrue(f1.equals(f2));
			assertEquals(f1.compareTo(f2),0);
			
			Fraction f3 = new Fraction(1,4);
			
			assertTrue(f1.compareTo(f3) > 0);
			assertTrue(f3.compareTo(f1) < 0);
		}
		
		
		// Permuation Tests
		
		@Test public void checkSimpleCase(){
			String[] expect = new String[] {"ab", "ba" };
			Set<String> result = Permutations.findPermutations("ab");
			Assert.assertArrayEquals(
					expect,
					result.toArray(new String[result.size()]));
			
		}
		@Test public void checkLessSimpleCase(){
			String[] expect = new String[] {"abc", "acb", "bac", "bca", "cab","cba" };
			Set<String> result = Permutations.findPermutations("abc");
			Assert.assertArrayEquals(
					expect,
					result.toArray(new String[result.size()]));
		}
		
		@Test public void check1000(){
			String[] expect = new String[] {"0001", "0010", "0100", "1000"};
			Set<String> result = Permutations.findPermutations("1000");
			Assert.assertArrayEquals(
					expect,
					result.toArray(new String[result.size()]));
		}
		
		
		@Test public void checkPrefixesAreIgnored(){
			String[] expect = new String[] {"bac", "bca", "cab","cba" };
			Set<String> result = Permutations.findPermutations("abc","a");
			Assert.assertArrayEquals(
					expect,
					result.toArray(new String[result.size()]));
			
		}
		
		@Test public void timeOriginalPermuationAlgorithm(){
			long start = System.currentTimeMillis();
			Set<String> perms = Permutations.findPermutations(TO_PERMUTE);
			long took = System.currentTimeMillis() - start;
			System.out.println(String.format("Finding %d permutations took %d ms.",
					perms.size(), took));
			
		}

		@Test public void timeBHeap(){
			long start = System.currentTimeMillis();
			Set<String> perms = Permutations.bHeapPermute(TO_PERMUTE);
			long took = System.currentTimeMillis() - start;
			System.out.println(String.format("BHeap: Finding %d permutations took %d ms.",
					perms.size(), took));
			
		}
		
		@Test public void timeQuickPerm(){
			long start = System.currentTimeMillis();
			Set<String> perms = Permutations.quickPerm(TO_PERMUTE);
			long took = System.currentTimeMillis() - start;
			System.out.println(String.format("QuickPerms: Finding %d permutations took %d ms.",
					perms.size(), took));
			
		}
		
		@Test public void checkQuickPerm(){
			String[] expect = new String[] {"abc", "acb", "bac", "bca", "cab", "cba" };
			Set<String> result = Permutations.quickPerm("bac");
			Assert.assertArrayEquals(
					expect,
					result.toArray(new String[result.size()]));
		}
		
		@Test public void checkBHeapPerm(){
			String[] expect = new String[] {"abc", "acb", "bac", "bca", "cab", "cba" };
			Set<String> result = Permutations.bHeapPermute("bac");
			Assert.assertArrayEquals(
					expect,
					result.toArray(new String[result.size()]));
		}
		
		//Prime Sieve test
		
		@Test public void testFirstNPrimes(){
			PrimeSieve ps = new PrimeSieve(42);
			for(int p : new int[]{2,3,5,7,11,13,17,19,23,29,31,37,41})
				assertTrue(p + " is prime.", ps.isPrime(p));
			for(int p : new int[]{1,4,6,8,9,10,12,14,15,16,18,20,21,22,24,25,26,27,28,30})
				assertFalse(ps.isPrime(p));
		}
}
