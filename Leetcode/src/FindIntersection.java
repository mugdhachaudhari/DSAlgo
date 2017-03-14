import java.util.HashMap;


public class FindIntersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Character> first  = new HashMap<Integer, Character>();
        for (int i = 0; i < nums1.length; i++) {
        	first.put(nums1[i], 'a');
        }
        
        HashMap<Integer, Character> resultMap = new HashMap<Integer, Character>();
        for (int j = 0; j < nums2.length; j++) {
        	if (first.containsKey(nums2[j])) {
        		resultMap.put(nums2[j], 'a');
        	}
        }
        int[] resultArr = new int[resultMap.size()];
        int k = 0;
        for (int i : resultMap.keySet()) {
        	resultArr[k++] = i;
        }
        
        return resultArr;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
