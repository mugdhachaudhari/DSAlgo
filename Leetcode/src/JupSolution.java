import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class JupSolution {
    public int jump(int[] nums) {
        if (nums.length  == 0) {
            return 0;
        }
        int[] res = new int[nums.length];

        res[nums.length - 1] = 0;
        
        for (int i = nums.length - 2; i >= 0; i--) {
            int val = 1 + res[i + 1];
            if (nums[i] > 0) {
                
                for (int j = i + 1; j < Math.min(nums[i], nums.length - i -1) ; j++) {
                    if (val > j - i + res[j]) {
                        val = j - i + res[j];
                    }
                }
            }
            res[i] = val;
            System.out.println("Result for "  + i + " is " + res[i]);
        }
        return res[0];
    }
    
    public static void main(String[] args) {
    	
    	 int p = (int) Math.ceil(((double)3 + 2)/2);
    	 System.out.println(p);
    	 String s = new String();
    	 
    	 Map<String, Integer> map = new HashMap<String, Integer>();
    	 map.containsKey(s);
    	 PriorityQueue<Integer> pq = new PriorityQueue<>(comparator);
    	 
//    	int[] num = {2, 3, 1, 1, 4};
//    	System.out.println(Arrays.toString(num));
//    	JupSolution jp = new JupSolution();
//    	System.out.println(jp.jump(num));
    }
}