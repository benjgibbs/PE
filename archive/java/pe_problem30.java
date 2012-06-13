package pe_problem30;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem30 {
    
    public static void main(String[] args) {
        
        final int power = 5;
        
        Map<Integer, Integer> powers = new HashMap<Integer, Integer>();
        for(int i = 0; i < 10; ++i){
            powers.put(i,  utils.Math.pow(i, power));
        }
        
        Set<Long> canBeWritten = new HashSet<Long>();
        for(int i = 2; i < utils.Math.pow(10, power + 1); ++i){
            String s = Integer.toString(i);
            long sum = 0;
            for(char c : s.toCharArray()){
                sum += powers.get(Integer.parseInt(c+""));
            }
            if(sum == i)
                canBeWritten.add(Long.valueOf(i));
        }
        
        long sum = 0;
        for(Long i : canBeWritten){
            sum += i;
            System.out.printf("Can be written %d\n", i );
        }
        
        System.out.printf("Sum of those: %d\n", sum);
    }
}
