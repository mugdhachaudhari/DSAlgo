// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X) {
        // write your code in Java SE 8
        int y = X;
        List<Integer> ls = new ArrayList<Integer>();
        while(y > 0) {
            ls.add(y%10);
            y = y/10;
        }
        int res = 0;
        for (int i = ls.size() -1; i > 0; i--) {
            int p = (int) Math.ceil(((double)ls.get(i) + ls.get(i -1))/2);
            if (p >= ls.get(i)) {

                return calcNum(ls, i, p);
            } else if (i == 1) {
                res =  calcNum(ls, i, p);
            }
        }
        return res;
        
    }
    
    private int calcNum(List<Integer> ls, int i, int p) {
        int res = 0;
        for (int j = ls.size() - 1; j > i; j--) {
                    res += (int) ls.get(j) * Math.pow(10, j -1);
        }
                res+= (int) p*Math.pow(10, i - 1);
                for (int k = i - 2; k >= 0; k--) {
                    res += (int) ls.get(k) * Math.pow(10, k);
                }
                
        return res;
    }
    
    
}