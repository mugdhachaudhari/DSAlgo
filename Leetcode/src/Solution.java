import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution {
	/*
	 * Complete the function below.
	 */

		
	    static int getIntegerComplement(int n) {
	        Stack<Character> st = getBinary(n);
//	        System.out.println((st.toString()));
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
			pq.add(10);

	        while (st.size() > 0 && st.peek() != '1') {
	            st.pop();
	        }
	        int[] a = new int[10];
	        int i = 225;
	        String bt = Integer.toBinaryString(i);
	        System.out.println(bt);
//	        Byte b = 2;
//	        String s = "01";
//	        System.out.println(b.SIZE);
//	        System.out.println(Arrays.toString(s.getBytes()));

	        return getDecimal(st);

	    }

	    private static Stack<Character> getBinary(int n) {
	        int m = n;
	        Stack<Character> st = new Stack<Character>();
	        while (m > 0) {
	            int rem = m%2;
	            m = m/2;
	            st.push((char)(rem+ 48));
	 
	         
	        }
	        return st;
	    }

	    private static int getDecimal(Stack<Character> st) {
	        int num = 0;
	        int i = st.size() - 1;
	        while (st.size() > 0) {
	            num += (1 - ((int)st.pop() - 48)) * Math.pow(2, i);
	            i--;
	        }
	        return num;
	    }

    
    public static void main(String[] args) {
//    	Solution s = new Solution();
//    	s.getIntegerComplement(5);
    	Map<Integer, Integer> chk = new LinkedHashMap<Integer, Integer>();
    	LinkedList<Integer> l = new LinkedList<Integer>();
    	chk.c
    	
    }
}