import java.util.HashMap;
import java.util.Map;

public class SubStringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() <= 1) return s.length();
        
        Map<Character, Integer> uniqueMap = new HashMap<Character, Integer>();
        int start = 0;
        int len = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int  i = 0; i < s.length(); i++) {
            if (uniqueMap.containsKey(s.charAt(i))) {
                if (len > maxLen) {
                    maxLen = len;
                }
                int pos = uniqueMap.get(s.charAt(i));
                for (int k = start; k <= pos; k++) {
                    uniqueMap.remove(s.charAt(k));
                }
                
                System.out.println("Prev length is " + len);
                
                len = len - (pos - start + 1);
                start = pos + 1;
                System.out.println("New length is " + len);
//                System.out.println("Len is " + len + " Map size " + uniqueMap.size());
//                System.out.println("When duplicate found " + uniqueMap.toString());
            } else {
//            	System.out.println("When dup not found " + uniqueMap.toString());
//            	System.out.println(s.charAt(i));
            }
            
            len++;
            uniqueMap.put(s.charAt(i), i);
            
        }
                        if (len > maxLen) {
                    maxLen = len;
                }
        return maxLen;
    }
    
    public static void main(String[] args) {
    	SubStringWithoutRepeat sr = new SubStringWithoutRepeat();
    	System.out.println(sr.lengthOfLongestSubstring("abcabcbb"));
    }
}