package pe_problem29;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Problem29 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int max = 100;
        Set<BigInteger> results = new HashSet<BigInteger>();
        for(int a = 2; a<= max; ++a){
            for(int b = 2; b<= max; ++b){
                results.add(BigInteger.valueOf(a).pow(b));
            }
        }
        System.out.printf("Number: %d", results.size());
    }

}
