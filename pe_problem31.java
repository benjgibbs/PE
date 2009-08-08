package pe_problem31;

import junit.framework.Assert;

import org.junit.Test;

public class Problem31 {
    private static final long[] coins = {200, 100, 50, 20, 10, 5, 2, 1};

    void run(){
        for(int i = 1; i < 201; ++i)
            System.out.println("Num ways to get " + i + ": " + numWays(i, coins));
    }
        
    public static void main(String[] args) {
        new Problem31().run();
    }

    private long numWays(long toFind, long[] withValues) {
        long curVal = withValues[0];
        long numWays = 0;
        if (withValues.length > 1) {
            long[] newValues = new long[withValues.length - 1];
            System.arraycopy(withValues, 1, newValues, 0, withValues.length - 1);
            long remainder = toFind;
            do {
                numWays += numWays(remainder, newValues);
                remainder = remainder - curVal;
            } while (remainder > 0);
            if(remainder == 0) ++numWays;
        } else if (toFind % curVal == 0) {
            ++numWays;
        }
        return numWays;
    }
    
    /*
     * 5,5
     * 5,2,2,1
     * 5,2,1,1,1
     * 5,1,1,1,1,1
     * 2,2,2,2,2
     * 2,2,2,2,1,1
     * 2,2,2,1,1,1,1
     * 2,2,1,1,1,1,1,1,
     * 2,1,1,1,1,1,1,1,1
     * 1,1,1,1,1,1,1,1,1,1
     */
    
    @Test
    public void testnumWays(){
        Assert.assertEquals(3, numWays(5, new long[] { 2, 1}));
        Assert.assertEquals(4, numWays(5, new long[] { 5, 2, 1}));
        Assert.assertEquals(10, numWays(10, new long[] { 5, 2, 1}));
        Assert.assertEquals(11, numWays(10, new long[] { 10, 5, 2, 1}));
        Assert.assertEquals(1, numWays(200, new long[] { 200 }));
    }
}
