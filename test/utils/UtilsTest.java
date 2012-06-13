package utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class UtilsTest {
	
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
			List<String> result = Permutations.findPermutations("ab");
			Assert.assertArrayEquals(
					expect,
					result.toArray(new String[result.size()]));
			
		}
		@Test public void checkLessSimpleCase(){
			String[] expect = new String[] {"abc", "acb", "bac", "bca", "cab","cba" };
			List<String> result = Permutations.findPermutations("abc");
			Assert.assertArrayEquals(
					expect,
					result.toArray(new String[result.size()]));
			
		}
		
		@Test public void checkPrefixesAreIgnored(){
			String[] expect = new String[] {"bac", "bca", "cab","cba" };
			List<String> result = Permutations.findPermutations("abc","a");
			Assert.assertArrayEquals(
					expect,
					result.toArray(new String[result.size()]));
			
		}
		
		//Prime Sieve test
		
		@Test public void testFirstNPrimes(){
			
		}
}
